package com.sync.mybatis.vo;

public class EfastOrderConditionVO {
	// 昵称
	private String buyerName;

	// 姓名
	private String receiverName;

	// trade_amount_from 交易金额的最小值
	private String trade_amount_from;

	// trade_amount_to 交易金额的最大值
	private String trade_amount_to;

	// trade_number_from 交易笔数的最小值
	private String trade_number_from;

	// trade_number_to 交易笔数的最小值
	private String trade_number_to;

	// trade_date_from 交易开始日期
	private String trade_date_from;

	// trade_date_to 交易结束日期
	private String trade_date_to;

	// 省份
	private String receiverProvince;

	// 城市
	private String receiverCity;
	// 区
	private String receiverDistrict;
	// 街道
	private String receiverStreet;

	// 手机号码
	private String receiverMobile;

	// 手机号码
	private String receiverPhone;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName == null ? null : buyerName.trim();
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName == null ? null : receiverName.trim();
	}

	public String getReceiverProvince() {
		return receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince == null ? null : receiverProvince.trim();
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity == null ? null : receiverCity.trim();
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
	}

	public String getReceiverStreet() {
		return receiverStreet;
	}

	public void setReceiverStreet(String receiverStreet) {
		this.receiverStreet = receiverStreet == null ? null : receiverStreet.trim();
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
	}

	public String getTrade_amount_from() {
		return trade_amount_from;
	}

	public void setTrade_amount_from(String trade_amount_from) {
		this.trade_amount_from = trade_amount_from;
	}

	public String getTrade_amount_to() {
		return trade_amount_to;
	}

	public void setTrade_amount_to(String trade_amount_to) {
		this.trade_amount_to = trade_amount_to;
	}

	public String getTrade_number_from() {
		return trade_number_from;
	}

	public void setTrade_number_from(String trade_number_from) {
		this.trade_number_from = trade_number_from;
	}

	public String getTrade_number_to() {
		return trade_number_to;
	}

	public void setTrade_number_to(String trade_number_to) {
		this.trade_number_to = trade_number_to;
	}

	public String getTrade_date_from() {
		return trade_date_from;
	}

	public void setTrade_date_from(String trade_date_from) {
		this.trade_date_from = trade_date_from;
	}

	public String getTrade_date_to() {
		return trade_date_to;
	}

	public void setTrade_date_to(String trade_date_to) {
		this.trade_date_to = trade_date_to;
	}
	
}
