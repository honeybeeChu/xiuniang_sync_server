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

	// 商品代码
	private String goods_code;
	// 商品名称
	private String goods_name;
	// 商品单价
	private String goods_price;
	// 商品总数量
	private String goods_num;
	// 配送方式代码
	private String express_code;
	// 快递单号
	private String express_no;
	// 买家留言
	private String buyer_remark;
	// 运费
	private String express_money;
	// 支付类型
	private String pay_type;
	// 平台交易号
	private String deal_code;
	// 平台子交易号
	private String sub_deal_code;
	// 仓库代码
	private String store_code;
	// 会员代码
	private String customer_code;
	
	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(String goods_num) {
		this.goods_num = goods_num;
	}

	public String getExpress_code() {
		return express_code;
	}

	public void setExpress_code(String express_code) {
		this.express_code = express_code;
	}

	public String getExpress_no() {
		return express_no;
	}

	public void setExpress_no(String express_no) {
		this.express_no = express_no;
	}

	public String getBuyer_remark() {
		return buyer_remark;
	}

	public void setBuyer_remark(String buyer_remark) {
		this.buyer_remark = buyer_remark;
	}

	public String getExpress_money() {
		return express_money;
	}

	public void setExpress_money(String express_money) {
		this.express_money = express_money;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getDeal_code() {
		return deal_code;
	}

	public void setDeal_code(String deal_code) {
		this.deal_code = deal_code;
	}

	public String getSub_deal_code() {
		return sub_deal_code;
	}

	public void setSub_deal_code(String sub_deal_code) {
		this.sub_deal_code = sub_deal_code;
	}

	public String getStore_code() {
		return store_code;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

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
