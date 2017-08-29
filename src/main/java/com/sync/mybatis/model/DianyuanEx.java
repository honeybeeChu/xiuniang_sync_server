package com.sync.mybatis.model;

public class DianyuanEx extends Dianyuan{
	private int sumMemberCount;
	
	private Long totalConsumption;

	public int getSumMemberCount() {
		return sumMemberCount;
	}

	public void setSumMemberCount(int sumMemberCount) {
		this.sumMemberCount = sumMemberCount;
	}

	public Long getTotalConsumption() {
		return totalConsumption;
	}

	public void setTotalConsumption(Long totalConsumption) {
		this.totalConsumption = totalConsumption;
	}
}
