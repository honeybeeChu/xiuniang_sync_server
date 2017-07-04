package com.sync.job;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.mybatis.mapper.Efast_orderMapper;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.model.Membership;
import com.sync.util.log.LogFactory;
import com.sync.youzan.interfaces.YouzanPointsService;
@Service
public class YearPointsTask {
	
	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");
	
	@Autowired
	private MembershipMapper membershipMapper;
	@Autowired
	private Efast_orderMapper efast_orderMapper;
	@Autowired
	private YouzanPointsService youzanPointsService;
	
	/**
	 * 1.每年的最后一天计算每个会员的积分是否需要清零
	 * 2.将membership表中每个会员的最近消费总额recent_consumption 减掉去年的数据，因为要变成前年的了
	 */
	public void caculatePoint(){
		try{
			main.info("this year caculatePoint() ...");
			List<Membership> alllist = membershipMapper.selectAllMemberships();
			for(Membership membership:alllist){
				//获得用户去年的总消费额
				int lastyear_money = efast_orderMapper.getTotalConsumptionByYear(Calendar.getInstance().get(Calendar.YEAR - 1),membership.getPhone());
				int thisyear_money = efast_orderMapper.getTotalConsumptionByYear(Calendar.getInstance().get(Calendar.YEAR),membership.getPhone());
				
				//如果去年有消费，最近两年的消费里面，去掉去年的消费额
				if(lastyear_money > 0){
					int recent_money = membership.getRecentConsumption() - lastyear_money;
					membership.setRecentConsumption(recent_money);
					membershipMapper.updateByPrimaryKeySelective(membership);
				}
				
				//判断积分是不是需要清零，当用户最近一次消费在去年，积分清零
				if(0 == thisyear_money){
					/*因为没有积分清零的接口，所以先获得现在的积分（有赞没有通过mobile获取积分的接口，而是fan_id，
					所以积分从membership表中获取现在的积分），在剪掉这些积分,*/
					String reason = "no consumption in this year.";
					youzanPointsService.decreasePointsByMobile(membership.getBonus(), membership.getPhone(), reason);
				}
			}
		}catch(Exception e){
			error.error(e.toString());
		}
	}
}
