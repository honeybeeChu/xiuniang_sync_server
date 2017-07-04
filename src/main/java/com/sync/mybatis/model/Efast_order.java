package com.sync.mybatis.model;

import java.text.SimpleDateFormat;
import java.sql.Date;

import net.sf.json.JSONObject;

public class Efast_order {
    private Integer id;

    private String sellRecordCode;

    private String orderStatus;

    private Integer shippingStatus;

    private String payStatus;

    private String saleChannelCode;

    private String shopCode;

    private String buyerName;

    private String receiverName;

    private String receiverCountry;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverStreet;

    private String receiverAddress;

    private String receiverAddr;

    private String receiverZipCode;

    private String receiverMobile;

    private String receiverPhone;

    private String receiverEmail;

    private Integer payableMoney;

    private Integer orderMoney;

    private Integer discountFee;

    private String payCode;

    private Date payTime;

    private String openid;
    
    JSONObject jsonObject = null;
    
	public Efast_order(){
	}
    
	public Efast_order(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}
    
	public Efast_order createEfastOrder() throws Exception{
		Efast_order efastOrder = new Efast_order();
		efastOrder.setSellRecordCode(this.jsonObject.get("sell_record_code").toString());
		efastOrder.setOrderStatus(this.jsonObject.get("order_status").toString());
		efastOrder.setShippingStatus(Integer.parseInt(this.jsonObject.get("shipping_status").toString()));
		efastOrder.setPayStatus(this.jsonObject.get("pay_status").toString());
		efastOrder.setSaleChannelCode(this.jsonObject.get("sale_channel_code").toString());
		efastOrder.setShopCode(this.jsonObject.get("shop_code").toString());
		efastOrder.setBuyerName(this.jsonObject.get("buyer_name").toString());
		efastOrder.setReceiverName(this.jsonObject.get("receiver_name").toString());
		efastOrder.setReceiverCountry(this.jsonObject.get("receiver_country").toString());
		efastOrder.setReceiverProvince(this.jsonObject.get("receiver_province").toString());
		efastOrder.setReceiverCity(this.jsonObject.get("receiver_city").toString());
		efastOrder.setReceiverDistrict(this.jsonObject.get("receiver_district").toString());
		efastOrder.setReceiverStreet(this.jsonObject.get("receiver_street").toString());
		efastOrder.setReceiverAddress(this.jsonObject.get("receiver_address").toString());
		efastOrder.setReceiverAddr(this.jsonObject.get("receiver_addr").toString());
		efastOrder.setReceiverZipCode(this.jsonObject.get("receiver_zip_code").toString());
		efastOrder.setReceiverMobile(this.jsonObject.get("receiver_mobile").toString());
		efastOrder.setReceiverPhone(this.jsonObject.get("receiver_phone").toString());
		efastOrder.setReceiverEmail(this.jsonObject.get("receiver_email").toString());
		efastOrder.setPayableMoney((int)Float.parseFloat(this.jsonObject.get("payable_money").toString()));
		
		efastOrder.setOrderMoney((int)Float.parseFloat(this.jsonObject.get("order_money")==null?"0":this.jsonObject.get("order_money").toString()));
		
		efastOrder.setDiscountFee((int)Float.parseFloat(this.jsonObject.get("discount_fee").toString()));
		efastOrder.setPayCode(this.jsonObject.get("pay_code").toString());
		
		String payTime = this.jsonObject.get("pay_time").toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		efastOrder.setPayTime(new Date(format.parse(payTime).getTime()));
		
//		efastOrder.setOpenid(this.jsonObject.get("openid").toString());
		
		return efastOrder;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellRecordCode() {
        return sellRecordCode;
    }

    public void setSellRecordCode(String sellRecordCode) {
        this.sellRecordCode = sellRecordCode == null ? null : sellRecordCode.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Integer getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Integer shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getSaleChannelCode() {
        return saleChannelCode;
    }

    public void setSaleChannelCode(String saleChannelCode) {
        this.saleChannelCode = saleChannelCode == null ? null : saleChannelCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
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

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry == null ? null : receiverCountry.trim();
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

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr == null ? null : receiverAddr.trim();
    }

    public String getReceiverZipCode() {
        return receiverZipCode;
    }

    public void setReceiverZipCode(String receiverZipCode) {
        this.receiverZipCode = receiverZipCode == null ? null : receiverZipCode.trim();
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

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail == null ? null : receiverEmail.trim();
    }

    public Integer getPayableMoney() {
        return payableMoney;
    }

    public void setPayableMoney(Integer payableMoney) {
        this.payableMoney = payableMoney;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}