package com.temp.vo;

import java.util.Date;

public class ReletVo extends Vo {

	private long reletId;
	
	private long rentId;
	
	private Date endDate;
	
	private float overdueFine;
	
	private float overdueRent;
	
	private float rent;
	
	public ReletVo(){}

	@Override
	public String toString() {
		return "ReletVo [reletId=" + reletId + ", rentId=" + rentId + ", endDate=" + endDate + ", overdueFine="
				+ overdueFine + ", overdueRent=" + overdueRent + ", rent=" + rent + "]";
	}

	public long getReletId() {
		return reletId;
	}

	public void setReletId(long reletId) {
		this.reletId = reletId;
	}

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}
		
}
