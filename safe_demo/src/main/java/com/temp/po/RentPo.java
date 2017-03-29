package com.temp.po;

import java.util.Date;

public class RentPo extends Po {
	
	private long rentId;
	
	private String leaseNo;
	
	private String leaseRemark;
	
	private String voucherNo;
	
	private String voucherRemark;
	
	private int rentType;
	
	private int rentTime;
	
	private Date startDate;
	
	private Date endDate;
	
	private float deposit;
	
	private float rent;
	
	private float rentDiscount;

	private float actualRent;
	
	private int paymentType;
	
	private float feeTotal;
	
	private long boxId;
	
	private String accountId;
	
	private String cardRfid;
	
	public RentPo() {}

	@Override
	public String toString() {
		return "RentPo [rentId=" + rentId + ", leaseNo=" + leaseNo + ", leaseRemark=" + leaseRemark + ", voucherNo="
				+ voucherNo + ", voucherRemark=" + voucherRemark + ", rentType=" + rentType + ", rentTime=" + rentTime
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", deposit=" + deposit + ", rent=" + rent
				+ ", rentDiscount=" + rentDiscount + ", actualRent=" + actualRent + ", paymentType=" + paymentType
				+ ", feeTotal=" + feeTotal + ", boxId=" + boxId + ", accountId=" + accountId + ", cardRfid=" + cardRfid
				+ "]";
	}

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public String getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}

	public String getLeaseRemark() {
		return leaseRemark;
	}

	public void setLeaseRemark(String leaseRemark) {
		this.leaseRemark = leaseRemark;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getVoucherRemark() {
		return voucherRemark;
	}

	public void setVoucherRemark(String voucherRemark) {
		this.voucherRemark = voucherRemark;
	}

	public int getRentType() {
		return rentType;
	}

	public void setRentType(int rentType) {
		this.rentType = rentType;
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

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}

	public float getRentDiscount() {
		return rentDiscount;
	}

	public void setRentDiscount(float rentDiscount) {
		this.rentDiscount = rentDiscount;
	}

	public float getActualRent() {
		return actualRent;
	}

	public void setActualRent(float actualRent) {
		this.actualRent = actualRent;
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

	public long getBoxId() {
		return boxId;
	}

	public void setBoxId(long boxId) {
		this.boxId = boxId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCardRfid() {
		return cardRfid;
	}

	public void setCardRfid(String cardRfid) {
		this.cardRfid = cardRfid;
	}

}
