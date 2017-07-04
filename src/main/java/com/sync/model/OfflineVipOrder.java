package com.sync.model;

/**
 * @author chuliang
 * 线下会员订单拉取
 */
public class OfflineVipOrder {
	//会员卡号
	private String vip_card;
	//交易时间
	private String trade_date;
	//会员名称
	private String gkmc;
	//会员性别 0:女 1：男
	private String sex;
	//订单金额
	private String get_money;
	//订单电话
	private String telephone;
	//店铺编码？
	private String vshop;
	//销售编码？
	private String vempcode;
	//xx编码？
	private String vspcode;
	public String getVip_card() {
		return vip_card;
	}
	public void setVip_card(String vip_card) {
		this.vip_card = vip_card;
	}
	public String getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(String trade_date) {
		this.trade_date = trade_date;
	}
	public String getGkmc() {
		return gkmc;
	}
	public void setGkmc(String gkmc) {
		this.gkmc = gkmc;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGet_money() {
		return get_money;
	}
	public void setGet_money(String get_money) {
		this.get_money = get_money;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getVshop() {
		return vshop;
	}
	public void setVshop(String vshop) {
		this.vshop = vshop;
	}
	public String getVempcode() {
		return vempcode;
	}
	public void setVempcode(String vempcode) {
		this.vempcode = vempcode;
	}
	public String getVspcode() {
		return vspcode;
	}
	public void setVspcode(String vspcode) {
		this.vspcode = vspcode;
	}
	
}
