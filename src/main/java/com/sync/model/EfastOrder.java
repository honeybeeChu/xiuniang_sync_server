package com.sync.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

public class EfastOrder {

	public static final String TABLE_NAME = "efast_orders";
	//efast 订单号 
	private String sell_record_code;
	//订单状态 0-未确认；1-已确认；3-已作废；5-已完成
	private String order_status;
	/*0-未发货 1-已通知配货 2-拣货中(已分配拣货任务) 3-已完成拣货4-已发货'*/	
	private int shipping_status;
	// 支付状态 0:未付款 2:已付款'
	private String pay_status;
	//销售平台  taobao jingdong
	private String sale_channel_code;
	//店铺代码
	private String shop_code;
	//会员昵称
	private String buyer_name;
	//收货人
	private String receiver_name;
	//国家编号
	private String receiver_country; 
	//省（名称）
	private String receiver_province;
	//市（名称） 
	private String receiver_city; 
	//区（名称）
	private String receiver_district; 
	//街道（名称）
	private String receiver_street; 
	//收货地址(包含省市
	private String receiver_address; 
	//收货地址(不包含省市
	private String receiver_addr;
	//收货邮编 
	private String receiver_zip_code; 
	//收货手机号码
	private String receiver_mobile; 
	//收货电话
	private String receiver_phone; 
	//收货邮箱
	private String receiver_email ; 
	//订单应付款=商品均摊金额之和+运费
	private int payable_money; 
	//订单总额sum（单价*数量）
	private int order_money; 
	//优惠金额 订单总额-订单应付款
	private int discount_fee; 
	//支付方式
	private String pay_code; 
	//支付时间
	private Date pay_time;

	//这个订单属于哪个会员
	private String openid;
	
	JSONObject jsonObject = null;
	
	
	public EfastOrder(){
	}
	
	public EfastOrder(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}
	
	public EfastOrder createEfastOrder() throws Exception{
		EfastOrder efastOrder = new EfastOrder();
		efastOrder.setSell_record_code(this.jsonObject.get("sell_record_code").toString());
		efastOrder.setOrder_status(this.jsonObject.get("order_status").toString());
		efastOrder.setShipping_status(Integer.parseInt(this.jsonObject.get("shipping_status").toString()));
		efastOrder.setPay_status(this.jsonObject.get("pay_status").toString());
		efastOrder.setSale_channel_code(this.jsonObject.get("sale_channel_code").toString());
		efastOrder.setShop_code(this.jsonObject.get("shop_code").toString());
		efastOrder.setBuyer_name(this.jsonObject.get("buyer_name").toString());
		efastOrder.setReceiver_name(this.jsonObject.get("receiver_name").toString());
		efastOrder.setReceiver_country(this.jsonObject.get("receiver_country").toString());
		efastOrder.setReceiver_province(this.jsonObject.get("receiver_province").toString());
		efastOrder.setReceiver_city(this.jsonObject.get("receiver_city").toString());
		efastOrder.setReceiver_district(this.jsonObject.get("receiver_district").toString());
		efastOrder.setReceiver_street(this.jsonObject.get("receiver_street").toString());
		efastOrder.setReceiver_address(this.jsonObject.get("receiver_address").toString());
		efastOrder.setReceiver_addr(this.jsonObject.get("receiver_addr").toString());
		efastOrder.setReceiver_zip_code(this.jsonObject.get("receiver_zip_code").toString());
		efastOrder.setReceiver_mobile(this.jsonObject.get("receiver_mobile").toString());
		efastOrder.setReceiver_phone(this.jsonObject.get("receiver_phone").toString());
		efastOrder.setReceiver_email(this.jsonObject.get("receiver_email").toString());
		efastOrder.setPayable_money((int)Float.parseFloat(this.jsonObject.get("payable_money").toString()));
		
		efastOrder.setOrder_money((int)Float.parseFloat(this.jsonObject.get("order_money")==null?"0":this.jsonObject.get("order_money").toString()));
		
		efastOrder.setDiscount_fee((int)Float.parseFloat(this.jsonObject.get("discount_fee").toString()));
		efastOrder.setPay_code(this.jsonObject.get("pay_code").toString());
		
		String payTime = this.jsonObject.get("pay_time").toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		efastOrder.setPay_time(new Date(format.parse(payTime).getTime()));
		
//		efastOrder.setOpenid(this.jsonObject.get("openid").toString());
		
		return efastOrder;
	}
	
	

	public String getSell_record_code() {
		return sell_record_code;
	}

	public void setSell_record_code(String sell_record_code) {
		this.sell_record_code = sell_record_code;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getShipping_status() {
		return shipping_status;
	}

	public void setShipping_status(int shipping_status) {
		this.shipping_status = shipping_status;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}


	public String getSale_channel_code() {
		return sale_channel_code;
	}

	public void setSale_channel_code(String sale_channel_code) {
		this.sale_channel_code = sale_channel_code;
	}


	public String getShop_code() {
		return shop_code;
	}

	public void setShop_code(String shop_code) {
		this.shop_code = shop_code;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_country() {
		return receiver_country;
	}

	public void setReceiver_country(String receiver_country) {
		this.receiver_country = receiver_country;
	}

	public String getReceiver_province() {
		return receiver_province;
	}

	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}

	public String getReceiver_city() {
		return receiver_city;
	}

	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}

	public String getReceiver_district() {
		return receiver_district;
	}

	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}

	public String getReceiver_street() {
		return receiver_street;
	}

	public void setReceiver_street(String receiver_street) {
		this.receiver_street = receiver_street;
	}

	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	public String getReceiver_addr() {
		return receiver_addr;
	}

	public void setReceiver_addr(String receiver_addr) {
		this.receiver_addr = receiver_addr;
	}

	public String getReceiver_zip_code() {
		return receiver_zip_code;
	}

	public void setReceiver_zip_code(String receiver_zip_code) {
		this.receiver_zip_code = receiver_zip_code;
	}

	public String getReceiver_mobile() {
		return receiver_mobile;
	}

	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getReceiver_email() {
		return receiver_email;
	}

	public void setReceiver_email(String receiver_email) {
		this.receiver_email = receiver_email;
	}

	public int getPayable_money() {
		return payable_money;
	}

	public void setPayable_money(int payable_money) {
		this.payable_money = payable_money;
	}

	public int getOrder_money() {
		return order_money;
	}

	public void setOrder_money(int order_money) {
		this.order_money = order_money;
	}

	public int getDiscount_fee() {
		return discount_fee;
	}

	public void setDiscount_fee(int discount_fee) {
		this.discount_fee = discount_fee;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getPay_code() {
		return pay_code;
	}

	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	
	
	
	
//	public String toString() {
//		return "BSpecialUser [openid=" + openid + ", eccode=" + eccode
//				+ ", apptype=" + apptype + ", phone=" + phone
//				+ ", verifyStatus=" + verifyStatus + ", openuserStatus="
//				+ openuserStatus + ", verifyexpireDate=" + verifyexpireDate
//				+ ", openDate=" + openDate + ", modDate=" + modDate
//				+ ", username=" + username + ", qrgroupid=" + qrgroupid + "]";
//	}

}
