package com.sync.model;

import java.sql.Date;

/**
 * 会员积分变更记录
 * @author chuliang
 *
 */
public class PointsRecord {
	
	private int fans_id;
	
	private String openid;
	
	private String kdt_name;
	
	private String mobile;
	//积分变动值
	private int amount;
	
	//积分变动后总值
	private int total;
	
	//积分变动描述
	private String description;
	
	//积分变动时间
	private Date created_time;
	
	private String client_hash;

	public int getFans_id() {
		return fans_id;
	}

	public void setFans_id(int fans_id) {
		this.fans_id = fans_id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getKdt_name() {
		return kdt_name;
	}

	public void setKdt_name(String kdt_name) {
		this.kdt_name = kdt_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public String getClient_hash() {
		return client_hash;
	}

	public void setClient_hash(String client_hash) {
		this.client_hash = client_hash;
	}
	
}
