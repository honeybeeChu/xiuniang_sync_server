package com.sync.mybatis.model;

import java.util.Date;

public class Membership {
    private Integer id;

    private String openid;

    private Integer dianyuanId;

    private String cardId;

    private String code;

    private String name;

    private Integer sex;

    private String phone;

    private String birthday;

    private String idcard;

    private String email;

    private String location;

    private Integer postcode;

    private String educationBackgro;

    private String industry;

    private String income;

    private String habit;

    private Integer bonus;

    private Integer balance;

    private Integer level;

    private String userCardStatus;

    private Boolean hasActive;

    private Integer totalConsumption;

    private Integer recentConsumption;

    private Integer totalNum;

    private Date createdAt;
    
    private Points_rule points_rule;

    public Integer getId() {
        return id;
    }

    public Points_rule getPoints_rule() {
		return points_rule;
	}

	public void setPoints_rule(Points_rule points_rule) {
		this.points_rule = points_rule;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getDianyuanId() {
        return dianyuanId;
    }

    public void setDianyuanId(Integer dianyuanId) {
        this.dianyuanId = dianyuanId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getEducationBackgro() {
        return educationBackgro;
    }

    public void setEducationBackgro(String educationBackgro) {
        this.educationBackgro = educationBackgro == null ? null : educationBackgro.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit == null ? null : habit.trim();
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserCardStatus() {
        return userCardStatus;
    }

    public void setUserCardStatus(String userCardStatus) {
        this.userCardStatus = userCardStatus == null ? null : userCardStatus.trim();
    }

    public Boolean getHasActive() {
        return hasActive;
    }

    public void setHasActive(Boolean hasActive) {
        this.hasActive = hasActive;
    }

    public Integer getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(Integer totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public Integer getRecentConsumption() {
        return recentConsumption;
    }

    public void setRecentConsumption(Integer recentConsumption) {
        this.recentConsumption = recentConsumption;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}