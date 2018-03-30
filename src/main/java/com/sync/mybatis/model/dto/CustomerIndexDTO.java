package com.sync.mybatis.model.dto;

public class CustomerIndexDTO {
	private String buyer_name;
	private String counter;
	private String amounter;
	private String avger;
	private String laster_timer;
	private String nickname;
	private String phone;
	private String sale_channel_code;
	private String pay_code;
	private String receiver_address;
	private String receiver_province;
	
	public String getReceiver_province() {
		return receiver_province;
	}
	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getSale_channel_code() {
		return sale_channel_code;
	}
	public void setSale_channel_code(String sale_channel_code) {
		this.sale_channel_code = sale_channel_code;
	}
	public String getPay_code() {
		return pay_code;
	}
	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}
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