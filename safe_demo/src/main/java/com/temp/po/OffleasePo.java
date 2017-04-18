package com.temp.po;

public class OffleasePo extends Po {
	
	private long rentId;

	private float returnDeposit;
	
	private float returnRent;
	
	private float overdueRent;
	
	private float overdueFine;
	
	private int unrecycleKeySum; 
	
	private int isCardDestroy;  //Card 是否被销毁(0-是，1-否)
	
	private float keyFee;
	
	private int paymentType;
	
	private float feeTotal;

	public OffleasePo() {}

	@Override
	public String toString() {
		return "OffleasePo [rentId=" + rentId + ", returnDeposit=" + returnDeposit + ", returnRent=" + returnRent
				+ ", overdueRent=" + overdueRent + ", overdueFine=" + overdueFine + ", unrecycleKeySum="
				+ unrecycleKeySum + ", isCardDestroy=" + isCardDestroy + ", keyFee=" + keyFee + ", paymentType="
				+ paymentType + ", feeTotal=" + feeTotal + "]";
	}

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public float getReturnDeposit() {
		return returnDeposit;
	}

	public void setReturnDeposit(float returnDeposit) {
		this.returnDeposit = returnDeposit;
	}

	public float getReturnRent() {
		return returnRent;
	}

	public void setReturnRent(float returnRent) {
		this.returnRent = returnRent;
	}

	public float getOverdueRent() {
		return overdueRent;
	}

	public void setOverdueRent(float overdueRent) {
		this.overdueRent = overdueRent;
	}

	public float getOverdueFine() {
		return overdueFine;
	}

	public void setOverdueFine(float overdueFine) {
		this.overdueFine = overdueFine;
	}

	public int getUnrecycleKeySum() {
		return unrecycleKeySum;
	}

	public void setUnrecycleKeySum(int unrecycleKeySum) {
		this.unrecycleKeySum = unrecycleKeySum;
	}

	public int getIsCardDestroy() {
		return isCardDestroy;
	}

	public void setIsCardDestroy(int isCardDestroy) {
		this.isCardDestroy = isCardDestroy;
	}

	public float getKeyFee() {
		return keyFee;
	}

	public void setKeyFee(float keyFee) {
		this.keyFee = keyFee;
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
