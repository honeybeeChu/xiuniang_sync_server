package com.sync.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.sync.dao.interfaces.EfastOrderDao;
import com.sync.model.EfastOrder;
import com.sync.util.log.LogFactory;

/**
 * @author chuliang
 *
 */
public class EfastOrderDaoImpl extends AbstractDaoImpl implements EfastOrderDao {

	private static Logger log = LogFactory.getLogger("main");
	private static Logger sql = LogFactory.getLogger("sql");

	@Override
	public boolean isExistBySellRecordCode(String sell_record_code) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = "select count(*) as code_count from efast_orders where sell_record_code = '" + sell_record_code
					+ "'";
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			if (rs.next()) {
				return rs.getInt("code_count") > 0;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return true;
	}

	/**
	 * 
	 * @param user
	 * @return 返回增加addEfastOrder的sql字符串
	 * @throws Exception
	 */
	public boolean addEfastOrder(EfastOrder efastOrder) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String addSql = "";
		try {
			addSql = addEfastOrderSql();
			log.info("addEfastOrder:" + addSql);
			conn = createConn();
			setAutoCommit(conn, false);
			pstmt = conn.prepareStatement(addSql);

			pstmt.setString(1, efastOrder.getSell_record_code());
			pstmt.setString(2, efastOrder.getOrder_status());
			pstmt.setInt(3, efastOrder.getShipping_status());
			pstmt.setString(4, efastOrder.getPay_status());
			pstmt.setString(5, efastOrder.getSale_channel_code());
			pstmt.setString(6, efastOrder.getShop_code());
			pstmt.setString(7, efastOrder.getBuyer_name());
			pstmt.setString(8, efastOrder.getReceiver_name());
			pstmt.setString(9, efastOrder.getReceiver_country());
			pstmt.setString(10, efastOrder.getReceiver_province());
			pstmt.setString(11, efastOrder.getReceiver_city());
			pstmt.setString(12, efastOrder.getReceiver_district());
			pstmt.setString(13, efastOrder.getReceiver_street());
			pstmt.setString(14, efastOrder.getReceiver_address());
			pstmt.setString(15, efastOrder.getReceiver_addr());
			pstmt.setString(16, efastOrder.getReceiver_zip_code());
			pstmt.setString(17, efastOrder.getReceiver_mobile());
			pstmt.setString(18, efastOrder.getReceiver_phone());
			pstmt.setString(19, efastOrder.getReceiver_email());
			pstmt.setInt(20, efastOrder.getPayable_money());
			pstmt.setInt(21, efastOrder.getOrder_money());
			pstmt.setInt(22, efastOrder.getDiscount_fee());
			pstmt.setString(23, efastOrder.getPay_code());
			pstmt.setDate(24, efastOrder.getPay_time());
			pstmt.setString(25, efastOrder.getOpenid());

			int count = pstmt.executeUpdate();
			if (count > 0) {
				commit(conn);
				ret = true;
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			log.error("exec add exception , sql:" + addSql.toString());
			rollback(conn);
			sql.error(e.toString());
		} finally {
			close(conn, pstmt, null);
		}
		return ret;
	}

	/**
	 * 通过订单中的手机号码，获取会员信息
	 * 
	 * @param mobile
	 * @return
	 */
	@Override
	public int getTotalConsumptionByYear(int year) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = getTotalConsumptionByYearStr(year);
			sql.debug("queryMembershipByMobileStr:" + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			if (rs.next()) {
				return rs.getInt("sum_money");
			}
		} catch (Exception e) {
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return 0;
	}

	/**
	 * 构造insert sql
	 * 
	 * @return
	 * @throws Exception
	 */
	private String addEfastOrderSql() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into efast_orders")
				.append("(sell_record_code,order_status,shipping_status,pay_status,sale_channel_code,shop_code,buyer_name,receiver_name,receiver_country,receiver_province,receiver_city,receiver_district,receiver_street,receiver_address,receiver_addr,receiver_zip_code,receiver_mobile,receiver_phone,receiver_email,payable_money,order_money,discount_fee,pay_code,pay_time,openid) values")
				.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		return sql.toString();
	}

	/**
	 * @param openid
	 * @return
	 */
	private String getTotalConsumptionByYearStr(int year) {
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("select sum(pay_money) as sum_money from efast_orders where year(pay_time)=").append(year);
		return queryStr.toString();
	}

	/**
	 * 从数据库连接池中获取连接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	// private Connection createConn() throws Exception {
	// Class.forName("com.sybase.jdbc3.jdbc.SybDriver").newInstance();
	// String url =
	// "jdbc:sybase:Tds:172.31.4.151:4001/JKUSER_SERVER?charset=eucgb";//
	// myDB为你的数据库名
	// Properties sysProps = System.getProperties();
	// sysProps.put("user", "useradmin"); // 设置数据库访问用户名
	// sysProps.put("password", "useradmin"); // 密码
	// return DriverManager.getConnection(url, sysProps);
	// }

}
