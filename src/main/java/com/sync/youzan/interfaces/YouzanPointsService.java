package com.sync.youzan.interfaces;

/**
 * @author chuliang
 * 有赞积分相关接口
 *
 */
public interface YouzanPointsService {
	
	/**
	 * 通过手机号给用户注入相应的积分
	 * @param mobile
	 * @param points
	 * @return
	 */
	boolean importPointsByMobile(int points,String mobile, String reason);
	
	/**
	 * 通过手机号码给用户减积分
	 * @param mobile
	 * @return
	 */
	boolean decreasePointsByMobile(int decreasePoints,String mobile,String reason);
}
