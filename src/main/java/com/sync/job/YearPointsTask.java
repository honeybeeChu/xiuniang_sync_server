package com.sync.job;

import org.apache.log4j.Logger;

import com.sync.dao.interfaces.MembershipDao;
import com.sync.util.log.LogFactory;

public class YearPointsTask {
	
	private static Logger error = LogFactory.getLogger("error");
	
	public MembershipDao membershipDao;
	
	/**
	 * 1.每年的最后一天计算每个会员的积分是否需要清零
	 * 2.将membership表中每个会员的最近消费总额recent_consumption 减掉去年的数据，因为要变成前年的了
	 */
	public void caculatePoint(){
		
		membershipDa
		
		
	}
	
	
	
	
	
	private Boolean setPointZero(){
		
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	


	public MembershipDao getMembershipDao() {
		return membershipDao;
	}


	public void setMembershipDao(MembershipDao membershipDao) {
		this.membershipDao = membershipDao;
	}
	
	
	
	

}
