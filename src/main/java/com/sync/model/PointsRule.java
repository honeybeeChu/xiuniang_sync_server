package com.sync.model;

public class PointsRule {
	//等级
	private int level;
	//消费额
	private int consumption;
	//不同等级对应的积分兑换比例 1元= 1*rate 积分
	private float rate;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
}
