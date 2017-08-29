package com.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.efast.interfaces.EfastOrderService;
import com.sync.mybatis.mapper.Efast_orderMapper;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.mapper.Points_ruleMapper;
import com.sync.mybatis.model.Efast_order;
import com.sync.mybatis.model.Membership;
import com.sync.mybatis.model.Points_rule;
import com.sync.service.interfaces.SyncEfastOrderServer;
import com.sync.util.log.LogFactory;
import com.sync.youzan.interfaces.YouzanPointsService;

/**
 * @author chuliang
 *
 */
@Service
public class SyncEfastOrderServerImpl implements SyncEfastOrderServer {

	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");

	@Autowired
	private MembershipMapper membershipMapper;
	@Autowired
	private Efast_orderMapper efast_orderMapper;
	@Autowired
	private EfastOrderService efastOrderService;
	@Autowired
	private Points_ruleMapper points_ruleMapper;
	@Autowired
	private YouzanPointsService youzanPointsService;
	
	// 同步订单数据
	public void syncEfastOrders() {
		try{
			// 获取订单数据
			List<Efast_order> efastOrderList = new ArrayList<Efast_order>();
			efastOrderService.getEfastOrdersFromLastTimeByPage(1,new Date(), efastOrderList);
			
//			Efast_order testorder = new Efast_order();
//			testorder.setSellRecordCode("1");
//			testorder.setReceiverMobile("15150500169");
//			testorder.setPayableMoney(100);
//			efastOrderList.add(testorder);
			
			// 循环处理订单数据
			for (Efast_order efastOrder : efastOrderList) {
				//如果此订单在数据库中不存在，那么保存订单数据，入库
				int count = efast_orderMapper.selectAcountBySellRecordCode(efastOrder.getSellRecordCode());
				if(0 == count){
					efast_orderMapper.insertSelective(efastOrder);
					// 通过手机号获取会员信息
					Membership membership = membershipMapper.selectByMobile(efastOrder.getReceiverMobile());
					if(null != membership){
						main.info(membership.getPhone() + " 有新的线上订单产生，消费额度是: "+efastOrder.getPayableMoney());
						// 更新会员的消费额和最近消费额，等级，最新消费时间
						if(updateMembershipInfoByEfastOrder(efastOrder, membership)){
							//给有赞平台注入积分
							if(importPointsToYouzan(efastOrder, membership)){
								main.info(membership.getOpenid() + " 的 youzan 积分注入成功。");
							}
						}else{
							error.error("更新会员信息失败");
						}
					}
				}
			}
		}catch(Exception e){
			error.error(e.toString());
			error.error("订单数据同步失败");
		}
	}


	/**
	 * @param efastOrder
	 * @param membership
	 * @return
	 */
	private Boolean updateMembershipInfoByEfastOrder(Efast_order efastOrder, Membership membership) {
		//应该升级到的等级
		int to_level = toWhichLevel(efastOrder, membership);
		
		membership.setTotalNum(membership.getTotalNum() + 1);
		membership.setLevel(to_level);
		membership.setTotalConsumption(efastOrder.getPayableMoney() + membership.getTotalConsumption());
		membership.setRecentConsumption(efastOrder.getPayableMoney() + membership.getRecentConsumption());
		
		int updatecount = membershipMapper.updateByPrimaryKeySelective(membership);
		
		return updatecount > 0;
	}
	
	/**
	 * 根据当前的等级，返回要升级到的等级
	 * @param current_level
	 * @return
	 */
	private int toWhichLevel(Efast_order efastOrder, Membership membership){
		// 获取所有的rules,按照level来降序
		List<Points_rule> ruleList = points_ruleMapper.selectAllRules();
		
		//算上本次目前的总消费额
		int totalConsumption = membership.getTotalConsumption() + efastOrder.getPayableMoney();
		//算上本次目前的总消费笔数
		int totalNum = membership.getTotalNum() + 1;
		
		for(Points_rule rule:ruleList){
			int condition = rule.getConditions();
			//0：consumption消费金额满足即可
			if(0 == condition){
				if(totalConsumption >= rule.getConsumption()){
					return rule.getLevel();
				}
			}
			//1： :trand_num 交易笔数满足即可
			else if(1 == condition){
				if(totalNum >= rule.getTradeNum()){
					return rule.getLevel();
				}
			}
			//2：金额和笔数有一个满足即可
			else if(2 == condition){
				if(totalConsumption >= rule.getConsumption() 
						|| totalNum >= rule.getTradeNum()){
					return rule.getLevel();
				}
			}
			//3：金额和笔数同时满足即可
			else if(3 == condition){
				if(totalConsumption >= rule.getConsumption() 
						&& totalNum >= rule.getTradeNum()){
					return rule.getLevel();
				}
			}
			//4：单笔消费满足即可
			else if(4 == condition){
				if(efastOrder.getPayableMoney() >= rule.getConsumption()){
					return rule.getLevel();
				}
			}
		}
		return membership.getLevel();
	}
	

	/**
	 * @param efastOrder
	 * @param membership
	 * @return
	 * @throws Exception
	 */
	private boolean importPointsToYouzan(Efast_order efastOrder, Membership membership) throws Exception {
		try{
			// 当前用户等级下的消费等级数额和积分比例
			float rate = points_ruleMapper.selectByLevel(membership.getLevel()).get(0).getRate();
			int addPoints = (int) (efastOrder.getPayableMoney() * rate);
			
			if(addPoints > 0){
				StringBuffer reasonBuf = new StringBuffer();
				reasonBuf.append("sell_record_code： ").append(efastOrder.getSellRecordCode()).append(" ")
						.append(efastOrder.getReceiverName()).append("(").append(efastOrder.getBuyerName())
						.append(") consumed at ").append(efastOrder.getSaleChannelCode()).append(" spend ")
						.append(efastOrder.getPayableMoney()).append("yuan");
				
				boolean importPointsSuccess = youzanPointsService.importPointsByMobile(addPoints, membership.getPhone(), reasonBuf.toString());
				if(importPointsSuccess)
					main.info(membership.getOpenid() + " 有赞注入积分为 "+ addPoints);
				else
					main.error(membership.getOpenid() + " 有赞注入积分失败，应该注入 "+ addPoints);
				return importPointsSuccess;
			}
			return true;
		}
		catch (Exception e) {
			error.error(e.toString());
			return false;
		}
	}
	
	
	
	public static void main(String args[]){
		float rate = (float) 0.5;
		int addPoints = (int) (1 * rate);
		System.out.println(addPoints);
	}
	
}
