package com.sync.mybatis.model.dto;

public class CustomerIndexDTO {
	private String buyer_name;
	private String counter;
	private String amounter;
	private String avger;
	private String laster_timer;
	private String nickname;
	private String phone;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	public String getAmounter() {
		return amounter;
	}
	public void setAmounter(String amounter) {
		this.amounter = amounter;
	}
	public String getAvger() {
		return avger;
	}
	public void setAvger(String avger) {
		this.avger = avger;
	}
	public String getLaster_timer() {
		return laster_timer;
	}
	public void setLaster_timer(String laster_timer) {
		this.laster_timer = laster_timer;
	}
	
	
	
	
}