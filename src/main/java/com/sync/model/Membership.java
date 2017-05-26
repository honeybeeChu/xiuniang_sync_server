package com.sync.model;

import java.sql.Date;

public class Membership {
	private String openid;
	private int dianyuan_id;
	private String card_id;
	private String code;
	private String name;
	private String sex;
	private String phone;
	private String birthday;
	private String idcard;
	private String email;
	private String location;
	private int postcode;
	private String education_backgro;
	private String industry;
	private String income;
	private String habit;
	private int bonus;
	private int balance;
	private int level;
	private String user_card_status;
	private int has_active;
	// 一共消费的总额
	private int total_consumption;
	// 最近消费的总额（从去年的一月一日起到现在的消费额，）
	private int recent_consumption;
	//最后一次加积分的时间
	private Date update_points_date;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getDianyuan_id() {
		return dianyuan_id;
	}
	public void setDianyuan_id(int dianyuan_id) {
		this.dianyuan_id = dianyuan_id;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getEducation_backgro() {
		return education_backgro;
	}
	public void setEducation_backgro(String education_backgro) {
		this.education_backgro = education_backgro;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUser_card_status() {
		return user_card_status;
	}
	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}
	public int getHas_active() {
		return has_active;
	}
	public void setHas_active(int has_active) {
		this.has_active = has_active;
	}
	public int getTotal_consumption() {
		return total_consumption;
	}
	public void setTotal_consumption(int total_consumption) {
		this.total_consumption = total_consumption;
	}
	public int getRecent_consumption() {
		return recent_consumption;
	}
	public void setRecent_consumption(int recent_consumption) {
		this.recent_consumption = recent_consumption;
	}
	public Date getUpdate_points_date() {
		return update_points_date;
	}
	public void setUpdate_points_date(Date update_points_date) {
		this.update_points_date = update_points_date;
	}
	
}
