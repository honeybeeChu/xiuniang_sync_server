package com.sync.dao.interfaces;

import java.util.List;

import com.sync.model.EfastOrder;
import com.sync.model.Membership;

public interface MembershipDao {
	
	
	List<Membership> queryAllMembership();
	
	/**
	 * 通过订单中的手机号码，获取会员信息
	 * @param mobile
	 * @return
	 */
	Membership queryMembershipByMobile(String mobile);
	
	
	/**
	 * 通过订单的信息，修改会员的信息
	 * 1.增加消费总额；2，判断是否需要升级会员等级 3.增加今年的消费总额
	 * @param membership
	 * @return
	 */
	Boolean modifyMembershipByOrder(EfastOrder efastOrder,int level);
}
