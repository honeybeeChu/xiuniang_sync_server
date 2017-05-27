package com.sync.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sync.dao.interfaces.EfastOrderDao;
import com.sync.dao.interfaces.MembershipDao;
import com.sync.dao.interfaces.PointsRuleDao;
import com.sync.efast.interfaces.EfastOrderService;
import com.sync.model.EfastOrder;
import com.sync.model.Membership;
import com.sync.service.interfaces.SyncEfastOrderServer;
import com.sync.util.log.LogFactory;
import com.sync.youzan.interfaces.YouzanPointsService;

/**
 * @author chuliang
 *
 */
public class SyncEfastOrderServerImpl implements SyncEfastOrderServer {

	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");

	private EfastOrderDao efastOrderDao;
	private MembershipDao membershipDao;
	private PointsRuleDao pointsRuleDao;

	private EfastOrderService efastOrderService;
	private YouzanPointsService youzanPointsService;

	// 同步订单数据
	public void syncEfastOrders() {
		try{
			// 获取订单数据
			List<EfastOrder> efastOrderList = new ArrayList<EfastOrder>();
//			efastOrderService.getEfastOrdersFromLastTimeByPage(1,new Date(), efastOrderList);
			
			
			EfastOrder testorder = new EfastOrder();
			testorder.setSell_record_code("0000001");
			testorder.setReceiver_mobile("15150500169");
			testorder.setPayable_money(100);
			efastOrderList.add(testorder);
			
			
			
			// 循环处理订单数据
			for (EfastOrder efastOrder : efastOrderList) {
				//如果此订单在数据库中不存在，那么保存订单数据，入库
				if(!efastOrderDao.isExistBySellRecordCode(efastOrder.getSell_record_code())){
					efastOrderDao.addEfastOrder(efastOrder);
					// 通过手机号获取会员信息
					Membership membership = membershipDao.queryMembershipByMobile(efastOrder.getReceiver_mobile());
					if(null != membership){
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
	private boolean updateMembershipInfoByEfastOrder(EfastOrder efastOrder, Membership membership) {
		int level = membership.getLevel();
		int to_level=0;
		//考虑是否需要增加等级
		if(level<6){
			// 当前用户等级下的消费等级数额和积分比例
			int consumption = pointsRuleDao.queryConsumptionByLevel(level+1);
			
			int recent_consumption = membership.getRecent_consumption()
					+ efastOrder.getPayable_money();
			//达到下一个等级需要的消费总额,level提高一个等级
			if(recent_consumption >= consumption){
				to_level = level+1;
			}
		}
		
		// to_level==0的时候，表示不需要提升等级，等级最低为1
		return membershipDao.modifyMembershipByOrder(efastOrder,to_level);
		
	}

	/**
	 * @param efastOrder
	 * @param membership
	 * @return
	 * @throws Exception
	 */
	private boolean importPointsToYouzan(EfastOrder efastOrder, Membership membership) throws Exception {
		int level = membership.getLevel();
		// 当前用户等级下的消费等级数额和积分比例
		float rate = pointsRuleDao.queryRateByLevel(level);
		int addPoints = (int) (efastOrder.getPayable_money() * rate);
		StringBuffer reasonBuf = new StringBuffer();
		reasonBuf.append("sell_record_code： ").append(efastOrder.getSell_record_code()).append(" ")
				.append(efastOrder.getReceiver_name()).append("(").append(efastOrder.getBuyer_name())
				.append(") consumed at ").append(efastOrder.getSale_channel_code()).append(" spend ")
				.append(efastOrder.getPayable_money()).append("yuan");
		
		boolean importPointsSuccess = youzanPointsService.importPointsByMobile(addPoints, membership.getPhone(), reasonBuf.toString());
		if(importPointsSuccess)
			main.info(membership.getOpenid() + " 有赞注入积分为 "+ addPoints);
		else
			main.error(membership.getOpenid() + " 有赞注入积分失败，应该注入 "+ addPoints);
		return importPointsSuccess;
		
	}
	
	
	public EfastOrderDao getEfastOrderDao() {
		return efastOrderDao;
	}

	public void setEfastOrderDao(EfastOrderDao efastOrderDao) {
		this.efastOrderDao = efastOrderDao;
	}

	public MembershipDao getMembershipDao() {
		return membershipDao;
	}

	public void setMembershipDao(MembershipDao membershipDao) {
		this.membershipDao = membershipDao;
	}

	public PointsRuleDao getPointsRuleDao() {
		return pointsRuleDao;
	}

	public void setPointsRuleDao(PointsRuleDao pointsRuleDao) {
		this.pointsRuleDao = pointsRuleDao;
	}

	public EfastOrderService getEfastOrderService() {
		return efastOrderService;
	}

	public void setEfastOrderService(EfastOrderService efastOrderService) {
		this.efastOrderService = efastOrderService;
	}

	public YouzanPointsService getYouzanPointsService() {
		return youzanPointsService;
	}

	public void setYouzanPointsService(YouzanPointsService youzanPointsService) {
		this.youzanPointsService = youzanPointsService;
	}

}
