package com.temp.vo;

import java.util.Date;

public class AccountFullInfoVo extends Vo {

	private String accountId; //(账户ID)	
	
	private int accountType; //(账户类型)	
	
	private Date openAccountDate; //(开户日期)	
	
	private Date cancelAccountDate; //(账户注销日期)	
	
	private int isAccountFree; //(开户费用: 免费-0, 收费-1)	
	
	private float openAccountFee; //(开户费用)	
	
	private int paymentType; //(付款方式：现金-0, 刷卡-1, 支票-2)	
	
	private float amountSum; //(金额总计)	
	
	private int customerSum; // (账户关联的客户数目)
	
	private long bankId; // (银行网点)	

	public AccountFullInfoVo() {}

	@Override
	public String toString() {
		return "AccountFullInfoVo [accountId=" + accountId + ", accountType=" + accountType + ", openAccountDate="
				+ openAccountDate + ", cancelAccountDate=" + cancelAccountDate + ", isAccountFree=" + isAccountFree
				+ ", openAccountFee=" + openAccountFee + ", paymentType=" + paymentType + ", amountSum=" + amountSum
				+ ", customerSum=" + customerSum + ", bankId=" + bankId + "]";
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public Date getOpenAccountDate() {
		return openAccountDate;
	}

	public void setOpenAccountDate(Date openAccountDate) {
		this.openAccountDate = openAccountDate;
	}

	public Date getCancelAccountDate() {
		return cancelAccountDate;
	}

	public void setCancelAccountDate(Date cancelAccountDate) {
		this.cancelAccountDate = cancelAccountDate;
	}

	public int getIsAccountFree() {
		return isAccountFree;
	}

	public void setIsAccountFree(int isAccountFree) {
		this.isAccountFree = isAccountFree;
	}

	public float getOpenAccountFee() {
		return openAccountFee;
	}

	public void setOpenAccountFee(float openAccountFee) {
		this.openAccountFee = openAccountFee;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public float getAmountSum() {
		return amountSum;
	}

	public void setAmountSum(float amountSum) {
		this.amountSum = amountSum;
	}

	public int getCustomerSum() {
		return customerSum;
	}

	public void setCustomerSum(int customerSum) {
		this.customerSum = customerSum;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

}
