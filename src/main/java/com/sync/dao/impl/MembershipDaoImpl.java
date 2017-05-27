package com.sync.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sync.dao.interfaces.MembershipDao;
import com.sync.model.EfastOrder;
import com.sync.model.Membership;
import com.sync.util.log.LogFactory;

/**
 * @author chuliang
 *
 */
public class MembershipDaoImpl  extends AbstractDaoImpl implements MembershipDao{
	
	private static Logger sql = LogFactory.getLogger("sql");
	
	
	
	/**
	 * 通过订单中的手机号码，获取会员信息
	 * @param mobile
	 * @return
	 */
	@Override
	public Membership queryMembershipByMobile(String mobile) {
		Membership membership = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = queryMembershipByMobileStr(mobile);
			System.out.println(querysql);
			sql.debug("queryMembershipByMobileStr:" + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			if (rs.next()) {
				membership = new Membership();
				membership.setOpenid(rs.getString("openid"));
				membership.setCard_id(rs.getString("card_id"));
				membership.setName(rs.getString("name"));
				membership.setSex(rs.getString("sex"));
				membership.setBirthday(rs.getString("birthday"));
				membership.setIdcard(rs.getString("idcard"));
				membership.setPhone(rs.getString("phone"));
				membership.setTotal_consumption(rs.getInt("total_consumption"));
				membership.setRecent_consumption(rs.getInt("recent_consumption"));
				membership.setLevel(rs.getInt("level"));
				return membership;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return null;
	}
	
	
	/*  通过订单的信息，修改会员的信息
	 * 1.增加消费总额；2，判断是否需要升级会员等级 3.增加今年的消费总额
	 * @see com.sync.dao.interfaces.MembershipDao#modifyMembershipByOrder(com.sync.model.EfastOrder)
	 */
	@Override
	public Boolean modifyMembershipByOrder(EfastOrder efastOrder,int level) {
		//通过手机号，查找需要更新的会员信息
		Membership membership = queryMembershipByMobile(efastOrder.getReceiver_mobile());
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String updateSql = "";
		try {
			//更新总消费额 = 原有总消费额+本次消费额
			int totalSpend = efastOrder.getPayable_money() 
					+ membership.getTotal_consumption();
			
			//更最近两年消费额 = 原有最近消费额+本次消费额
			int recent_consumption = efastOrder.getPayable_money()
					+ membership.getRecent_consumption();
			updateSql = updateMembershipByOrderStr(membership.getOpenid(),level,totalSpend,recent_consumption);
			conn = createConn();
			setAutoCommit(conn, false);
			pstmt = conn.prepareStatement(updateSql);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				commit(conn);
				ret = true;
			} else {
				rollback(conn);
			}
		}catch(Exception e){
			sql.error("exec query exception , sql:" + updateSql);
		} finally {
			close(conn, pstmt, null);
		}
		return ret;
	}
	
	
	/**
	 * 获取所有会员信息
	 * @param mobile
	 * @return
	 */
	@Override
	public List<Membership> queryAllMembership() {
		List<Membership> membershipList = new ArrayList<Membership>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = "select * from memberships";
			sql.debug("queryMembershipByMobileStr:" + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			Membership membership = null;
			while (rs.next()) {
				membership = new Membership();
				membership.setOpenid(rs.getString("openid"));
				membership.setCard_id(rs.getString("card_id"));
				membership.setName(rs.getString("name"));
				membership.setSex(rs.getString("sex"));
				membership.setBirthday(rs.getString("birthday"));
				membership.setIdcard(rs.getString("idcard"));
				membership.setPhone((rs.getString("phone")));
				membership.setBonus(rs.getInt("bonus"));
				membership.setTotal_consumption(rs.getInt("total_consumption"));
				membership.setRecent_consumption(rs.getInt("recent_consumption"));
				membership.setLevel(rs.getInt("level"));
				membership.setUpdate_points_date(rs.getDate("update_points_date"));
				membershipList.add(membership);
			}
		} catch (Exception e) {
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return membershipList;
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.sync.dao.interfaces.MembershipDao#modifyRecentConsumption(java.lang.String, int)
	 */
	@Override
	public Boolean modifyRecentConsumption(String openid,int recent_money) {
		//通过手机号，查找需要更新的会员信息
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String updateSql = "";
		try {
			updateSql = "update memberships set recent_consumption = "+recent_money 
					+" where openid='"+openid+"'";
			sql.info("modifyRecentConsumption:" + updateSql);
			conn = createConn();
			setAutoCommit(conn, false);
			pstmt = conn.prepareStatement(updateSql);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				commit(conn);
				ret = true;
			} else {
				rollback(conn);
			}
		}catch(Exception e){
			sql.error("exec query exception , sql:" + updateSql);
		} finally {
			close(conn, pstmt, null);
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param openid
	 * @return
	 */
	private String queryMembershipByMobileStr(String mobile){
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("select * from memberships where phone='")
		.append(mobile)
		.append("'");
		return queryStr.toString();
	}
	

	
	
	
	
	/**
	 * @param openid
	 * @return
	 */
	private String updateMembershipByOrderStr(String openid,int level,int total_consumption,int recent_consumption){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		StringBuffer updateStr = new StringBuffer();
		if(0  != level){
			updateStr.append("update memberships set total_consumption = ")
			.append(total_consumption)
			.append(", level = ")
			.append(level)
			.append(", recent_consumption = ")
			.append(recent_consumption)
			.append(", update_points_date = '")
			.append(sdf.format(new Date()))
			.append("' where openid='")
			.append(openid)
			.append("'");
		}else{
			updateStr.append("update memberships set total_consumption = ")
			.append(total_consumption)
			.append(", recent_consumption = ")
			.append(recent_consumption)
			.append(", update_points_date = '")
			.append(sdf.format(new Date()))
			.append("' where openid='")
			.append(openid)
			.append("'");
		}
		
		return updateStr.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
