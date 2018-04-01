package com.sync.mybatis.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

public class Efast_order {
	private Integer id;

    private String sellRecordCode;

    private String orderStatus;

    private Integer shippingStatus;

    private String payStatus;

    private String saleChannelCode;

    private String shopCode;

    private String storeCode;

    private String customerCode;

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

    private String payType;

    private String subDealCode;

    private String dealCode;

    private Date payTime;

    private String goodsCode;

    private String goodsName;

    private String goodsPrice;

    private String goodsNum;

    private String expressCode;

    private String buyerRemark;

    private String expressMoney;

    private String expressNo;

    private String openid;
    
    JSONObject jsonObject = null;
    
	public Efast_order(){
	}
    
	public Efast_order(JSONObject jsonObject){
		this.jsonObject = jsonObject;
	}
    
	public Efast_order createEfastOrder() throws Exception{
		Efast_order efastOrder = new Efast_order();
		
		if(null != this.jsonObject.get("sell_record_code"))
			efastOrder.setSellRecordCode(this.jsonObject.get("sell_record_code").toString());
		
		if(null != this.jsonObject.get("order_status"))
			efastOrder.setOrderStatus(this.jsonObject.get("order_status").toString());
		
		if(null != this.jsonObject.get("shipping_status"))
			efastOrder.setShippingStatus(Integer.parseInt(this.jsonObject.get("shipping_status").toString()));
		
		if(null != this.jsonObject.get("pay_status"))
			efastOrder.setPayStatus(this.jsonObject.get("pay_status").toString());
		
		if(null != this.jsonObject.get("sale_channel_code"))
			efastOrder.setSaleChannelCode(this.jsonObject.get("sale_channel_code").toString());
		
		if(null != this.jsonObject.get("shop_code"))
			efastOrder.setShopCode(this.jsonObject.get("shop_code").toString());
		
		if(null != this.jsonObject.get("store_code"))
			efastOrder.setStoreCode(this.jsonObject.get("store_code").toString());
		
		if(null != this.jsonObject.get("customer_code"))
			efastOrder.setCustomerCode(this.jsonObject.get("customer_code").toString());
		
		if(null != this.jsonObject.get("buyer_name"))
			efastOrder.setBuyerName(this.jsonObject.get("buyer_name").toString());
		
		if(null != this.jsonObject.get("receiver_name"))
		efastOrder.setReceiverName(this.jsonObject.get("receiver_name").toString());
		
		if(null != this.jsonObject.get("receiver_country"))
			efastOrder.setReceiverCountry(this.jsonObject.get("receiver_country").toString());
		
		if(null != this.jsonObject.get("receiver_province"))
			efastOrder.setReceiverProvince(this.jsonObject.get("receiver_province").toString());
		
		if(null != this.jsonObject.get("receiver_city"))
			efastOrder.setReceiverCity(this.jsonObject.get("receiver_city").toString());
		
		if(null != this.jsonObject.get("receiver_district"))
			efastOrder.setReceiverDistrict(this.jsonObject.get("receiver_district").toString());
		
		if(null != this.jsonObject.get("receiver_email"))
		efastOrder.setReceiverStreet(this.jsonObject.get("receiver_street").toString());
		
		if(null != this.jsonObject.get("receiver_address"))
			efastOrder.setReceiverAddress(this.jsonObject.get("receiver_address").toString());
		
		if(null != this.jsonObject.get("receiver_addr"))
			efastOrder.setReceiverAddr(this.jsonObject.get("receiver_addr").toString());
		
		if(null != this.jsonObject.get("receiver_zip_code"))
			efastOrder.setReceiverZipCode(this.jsonObject.get("receiver_zip_code").toString());
		
		if(null != this.jsonObject.get("receiver_mobile"))
			efastOrder.setReceiverMobile(this.jsonObject.get("receiver_mobile").toString());
		
		if(null != this.jsonObject.get("receiver_phone"))
			efastOrder.setReceiverPhone(this.jsonObject.get("receiver_phone").toString());
		
		if(null != this.jsonObject.get("receiver_email"))
			efastOrder.setReceiverEmail(this.jsonObject.get("receiver_email").toString());
		
		if(null != this.jsonObject.get("payable_money"))
			efastOrder.setPayableMoney((int)Float.parseFloat(this.jsonObject.get("payable_money").toString()));
		
		efastOrder.setOrderMoney((int)Float.parseFloat(this.jsonObject.get("order_money")==null?"0":this.jsonObject.get("order_money").toString()));
		
		if(null != this.jsonObject.get("discount_fee"))
			efastOrder.setDiscountFee((int)Float.parseFloat(this.jsonObject.get("discount_fee").toString()));
		if(null != this.jsonObject.get("pay_code"))
			efastOrder.setPayCode(this.jsonObject.get("pay_code").toString());
		
		efastOrder.setPayType(this.jsonObject.get("pay_type").toString());
		if(null != this.jsonObject.get("sub_deal_code"))
			efastOrder.setSubDealCode(this.jsonObject.get("sub_deal_code").toString());
		
		if(null != this.jsonObject.get("deal_code"))
			efastOrder.setDealCode(this.jsonObject.get("deal_code").toString());
		
		String payTime = this.jsonObject.get("pay_time").toString();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		efastOrder.setPayTime(format.parse(payTime));
		
		if(null != this.jsonObject.get("goods_code"))
			efastOrder.setGoodsCode(this.jsonObject.get("goods_code").toString());
		
		if(null != this.jsonObject.get("goods_name"))
			efastOrder.setGoodsName(this.jsonObject.get("goods_name").toString());
		
		if(null != this.jsonObject.get("goods_price"))
			efastOrder.setGoodsPrice(this.jsonObject.get("goods_price").toString());
		
		if(null != this.jsonObject.get("goods_num"))
			efastOrder.setGoodsNum(this.jsonObject.get("goods_num").toString());

		if(null != this.jsonObject.get("express_code"))
			efastOrder.setExpressCode(this.jsonObject.get("express_code").toString());
		
		if(null != this.jsonObject.get("buyer_remark"))
			efastOrder.setBuyerRemark(this.jsonObject.get("buyer_remark").toString());
		
		if(null != this.jsonObject.get("express_money"))
			efastOrder.setExpressMoney(this.jsonObject.get("express_money").toString());
		if(null != this.jsonObject.get("express_no"))
			efastOrder.setExpressNo(this.jsonObject.get("express_no").toString());
		
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

    public String getPayTime() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	return sdf.format(payTime);
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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getSubDealCode() {
		return subDealCode;
	}

	public void setSubDealCode(String subDealCode) {
		this.subDealCode = subDealCode;
	}

	public String getDealCode() {
		return dealCode;
	}

	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getBuyerRemark() {
		return buyerRemark;
	}

	public void setBuyerRemark(String buyerRemark) {
		this.buyerRemark = buyerRemark;
	}

	public String getExpressMoney() {
		return expressMoney;
	}

	public void setExpressMoney(String expressMoney) {
		this.expressMoney = expressMoney;
	}

	public String getExpressNo() {
		return expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
    
}