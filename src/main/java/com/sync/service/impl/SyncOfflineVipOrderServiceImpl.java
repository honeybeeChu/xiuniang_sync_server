package com.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.mapper.Offline_vip_orderMapper;
import com.sync.mybatis.mapper.Points_ruleMapper;
import com.sync.mybatis.model.Membership;
import com.sync.mybatis.model.Offline_vip_order;
import com.sync.mybatis.model.Points_rule;
import com.sync.offline.interfaces.OfflineVipOrderService;
import com.sync.service.interfaces.SyncOfflineVipOrderService;
import com.sync.util.log.LogFactory;
import com.sync.youzan.interfaces.YouzanPointsService;

@Service
public class SyncOfflineVipOrderServiceImpl implements SyncOfflineVipOrderService {
	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");
	
	@Autowired
	private OfflineVipOrderService offlineVipOrderService;

	@Autowired
	private Offline_vip_orderMapper offline_vip_orderMapper;
	@Autowired
	private MembershipMapper membershipMapper;
	@Autowired
	private Points_ruleMapper points_ruleMapper;
	@Autowired
	private YouzanPointsService youzanPointsService;
	
	

	@Override
	public void syncOfflineVipOrders() {
		try{
			// 获取订单数据
			List<Offline_vip_order> offlineOrdersList = offlineVipOrderService.getOfflineVipOrderFromLastTime();
			
			
//			List<Offline_vip_order> offlineOrdersList = new ArrayList<Offline_vip_order>();
//			Offline_vip_order testorder = new Offline_vip_order();
//			testorder.setVmbillid("1111111");
//			testorder.setGetMoney("100");
//			testorder.setTelephone("15150500169");
//			testorder.setVipCard("1234567");
//			offlineOrdersList.add(testorder);
			
			// 循环处理订单数据
			for (Offline_vip_order offlineorder : offlineOrdersList) {
				//如果此订单在数据库中不存在，那么保存订单数据，入库
				int hascount = offline_vip_orderMapper.selectCountByVmbillId(offlineorder.getVmbillid());
				if(0 == hascount){
					offline_vip_orderMapper.insertSelective(offlineorder);
					// 通过手机号获取会员信息
					Membership membership = membershipMapper.selectByMobile(offlineorder.getTelephone());
					if(null != membership){
						main.info(membership.getPhone() + " 有新的线下订单产生，消费额度是: "+offlineorder.getGetMoney());
						// 更新会员的消费额和最近消费额，等级，最新消费时间
						if(updateMembershipInfoByOfflineOrder(offlineorder, membership)){
							//给有赞平台注入积分
							if(importPointsToYouzan(offlineorder, membership)){
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
			error.error("offline订单数据同步失败");
		}
		
	}
	
	
	
	
	/**
	 * @param efastOrder
	 * @param membership
	 * @return
	 */
	private Boolean updateMembershipInfoByOfflineOrder(Offline_vip_order offline_vip_order, Membership membership) {
		//应该升级到的等级
		int to_level = toWhichLevel(offline_vip_order, membership);
		
		int payed_money = (int)Double.parseDouble(offline_vip_order.getGetMoney());
		
		membership.setTotalNum(membership.getTotalNum() + 1);
		membership.setLevel(to_level);
		membership.setTotalConsumption( payed_money  + membership.getTotalConsumption());
		membership.setRecentConsumption(payed_money + membership.getRecentConsumption());
		
		int updatecount = membershipMapper.updateByPrimaryKeySelective(membership);
		
		return updatecount > 0;
	}
	
	
	/**
	 * 根据当前的等级，返回要升级到的等级
	 * @param current_level
	 * @return
	 */
	private int toWhichLevel(Offline_vip_order offline_vip_order, Membership membership){
		// 获取所有的rules,按照level来降序
		List<Points_rule> ruleList = points_ruleMapper.selectAllRules();
		
		//算上本次目前的总消费额
		int totalConsumption = membership.getTotalConsumption() + (int)Double.parseDouble(offline_vip_order.getGetMoney());
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
				if((int)Double.parseDouble(offline_vip_order.getGetMoney())  >= rule.getConsumption()){
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
	private boolean importPointsToYouzan(Offline_vip_order offline_vip_order, Membership membership) throws Exception {
		try{
			
			int paymoney = (int)Double.parseDouble(offline_vip_order.getGetMoney());
			// 当前用户等级下的消费等级数额和积分比例
			float rate = points_ruleMapper.selectByLevel(membership.getLevel()).getRate();
			int addPoints = (int) (paymoney * rate);
			
			if(addPoints > 0){
				StringBuffer reasonBuf = new StringBuffer();
				reasonBuf.append("vmBillId： ").append(offline_vip_order.getVmbillid()).append(" ")
						.append(offline_vip_order.getVipCard()).append("(").append(offline_vip_order.getGkmc())
						.append(") consumed at ").append(offline_vip_order.getVshop()).append(" spend ")
						.append(offline_vip_order.getGetMoney()).append("yuan");
				
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
	
	
	public static void main(String args[]) {
		System.out.println((int)Double.parseDouble("1280"));
	}
	
	
	
}
