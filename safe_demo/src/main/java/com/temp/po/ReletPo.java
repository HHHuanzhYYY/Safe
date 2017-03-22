package com.temp.po;

import java.util.Date;

public class ReletPo extends Po {
	
	private int id; // 租赁ID
	
	private int rentTime; // 续租时间	
	
	private Date startDate; // 开始日期
	
	private Date endDate; // 到期日期	
	
	private float rent; // 续约租金
	
	private float overdueFine; // 滞纳金
	
	private float overdueRent; // 滞纳租金	
	
	private int paymentType; // 付款方式
	
	private float feeTotal; // 费用总计
	
	public ReletPo() {}

	@Override
	public String toString() {
		return "ReletPo [id=" + id + ", rentTime=" + rentTime + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", rent=" + rent + ", overdueFine=" + overdueFine + ", overdueRent=" + overdueRent + ", paymentType="
				+ paymentType + ", feeTotal=" + feeTotal + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRentTime() {
		return rentTime;
	}

	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}

	public float getOverdueFine() {
		return overdueFine;
	}

	public void setOverdueFine(float overdueFine) {
		this.overdueFine = overdueFine;
	}

	public float getOverdueRent() {
		return overdueRent;
	}

	public void setOverdueRent(float overdueRent) {
		this.overdueRent = overdueRent;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public float getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(float feeTotal) {
		this.feeTotal = feeTotal;
	}
	
}
