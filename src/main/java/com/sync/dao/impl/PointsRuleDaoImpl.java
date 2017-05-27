package com.sync.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sync.dao.interfaces.PointsRuleDao;
import com.sync.util.log.LogFactory;

/**
 * @author chuliang
 *
 */
public class PointsRuleDaoImpl extends AbstractDaoImpl implements PointsRuleDao {
	
	private static Logger sql = LogFactory.getLogger("sql");
	
	/* (non-Javadoc)
	 * @see com.sync.dao.interfaces.PointsRuleDao#getPointsRules()
	 */
	@Override
	public List<Map<Integer,String[]>> getPointsRules(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		
		List<Map<Integer,String[]>> retList = new ArrayList<Map<Integer,String[]>>();
		try {
			querysql = queryAllRulesStr();
			sql.info("queryAllRulesStr:" + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			Map<Integer,String[]> ruleMap ;
			while (rs.next()) {
				ruleMap = new HashMap<Integer,String[]>();
				ruleMap.put(rs.getInt("level"), new String[]{String.valueOf(rs.getInt("rate")),String.valueOf(rs.getInt("consumption"))});
				retList.add(ruleMap);
			}
		} catch (Exception e) {
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return retList;
	}
	
	
	
	/**
	 * @param level
	 * @return
	 */
	@Override
	public float queryRateByLevel(int level){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = queryRateByLevelStr(level);
			sql.info("queryRateByLevel:" + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			if (rs.next()) {
				return (float)rs.getInt("rate");
			}
		} catch (Exception e) {
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return (float)1;
	}
	
	
	
	@Override
	public int queryConsumptionByLevel(int level){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String querysql = "";
		try {
			querysql = queryConsumptionByLevelStr(level);
			sql.info("queryConsumptionByLevel: " + querysql);
			conn = createConn();
			st = conn.createStatement();
			rs = st.executeQuery(querysql);
			if (rs.next()) {
				return rs.getInt("consumption");
			}
		} catch (Exception e) {
			sql.error("exec query exception , sql:" + querysql.toString());
		} finally {
			close(conn, st, rs);
		}
		return 0;
	}
	
	
	
	/**
	 * 返回查询所有积分规则的数据
	 * @return
	 */
	private String queryAllRulesStr(){
		return "select * from pointsRules";
	}
	
	
	/**
	 * 返回查询所有积分规则的数据
	 * @return
	 */
	private String queryRateByLevelStr(int Level){
		return "select rate from points_rules where level = " + Level;
	}
	
	
	/**
	 * 返回查询所有积分规则的数据
	 * @return
	 */
	private String queryConsumptionByLevelStr(int Level){
		return "select consumption from points_rules where level = " + Level;
	}
	
}
