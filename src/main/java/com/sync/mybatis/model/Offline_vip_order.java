package com.sync.mybatis.model;

import java.util.Date;

/**
 * @author chuliang 线下会员订单拉取
 */
public class Offline_vip_order {
	private Integer id;
	// 会员卡号
	private String vipCard;
	
	private String vmbillid;
	// 交易时间
	private Date tradeDate;
	// 会员名称
	private String gkmc;
	// 会员性别 0:女 1：男
	private Integer sex;
	// 订单金额
	private String getMoney;
	// 订单电话
	private String telephone;
	// 店铺编码？
	private String vshop;
	// 销售编码？
	private String vempcode;
	// xx编码？
	private String vspcode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVipCard() {
		return vipCard;
	}

	public void setVipCard(String vipCard) {
		this.vipCard = vipCard == null ? null : vipCard.trim();
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getGkmc() {
		return gkmc;
	}

	public void setGkmc(String gkmc) {
		this.gkmc = gkmc == null ? null : gkmc.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(String getMoney) {
		this.getMoney = getMoney == null ? null : getMoney.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getVshop() {
		return vshop;
	}

	public void setVshop(String vshop) {
		this.vshop = vshop == null ? null : vshop.trim();
	}

	public String getVempcode() {
		return vempcode;
	}

	public void setVempcode(String vempcode) {
		this.vempcode = vempcode == null ? null : vempcode.trim();
	}

	public String getVspcode() {
		return vspcode;
	}

	public void setVspcode(String vspcode) {
		this.vspcode = vspcode == null ? null : vspcode.trim();
	}

	public String getVmbillid() {
		return vmbillid;
	}

	public void setVmbillid(String vmbillid) {
		this.vmbillid = vmbillid;
	}
}