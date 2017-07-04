package com.sync.mybatis.model;

import java.util.Date;

public class Offline_vip_order {
    private Integer id;

    private String vipCard;

    private Date tradeDate;

    private String gkmc;

    private Integer sex;

    private String getMoney;

    private String telephone;

    private String vshop;

    private String vempcode;

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
}