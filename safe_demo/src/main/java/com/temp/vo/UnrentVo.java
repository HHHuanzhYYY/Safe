package com.temp.vo;

import java.util.Date;

public class UnrentVo extends Vo {

	private float unitRent;
	
	private float overdueFineStrategy;
	
	private Date beginDate;
	
	private Date endDate;
	
	private float rentDay;
	
	private float actualRent;
	
	private int keySum = 1; // 钥匙数目, 默认暂时为1
	
	private float keyFee;

	public UnrentVo() {}

	public float getUnitRent() {
		return unitRent;
	}

	public void setUnitRent(float unitRent) {
		this.unitRent = unitRent;
	}

	public float getOverdueFineStrategy() {
		return overdueFineStrategy;
	}

	public void setOverdueFineStrategy(float overdueFineStrategy) {
		this.overdueFineStrategy = overdueFineStrategy;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getRentDay() {
		return rentDay;
	}

	public void setRentDay(float rentDay) {
		this.rentDay = rentDay;
	}

	public float getActualRent() {
		return actualRent;
	}

	public void setActualRent(float actualRent) {
		this.actualRent = actualRent;
	}

	public int getKeySum() {
		return keySum;
	}

	public void setKeySum(int keySum) {
		this.keySum = keySum;
	}

	public float getKeyFee() {
		return keyFee;
	}

	public void setKeyFee(float keyFee) {
		this.keyFee = keyFee;
	}
	
}
