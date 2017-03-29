package com.temp.po;

import java.util.ArrayList;
import java.util.List;

public class AccountPo extends Po {

	private String accountId;
	
	private int accountType;
	
	private int bankId;
	
	private int isAccountFree;
	
	private float openAccountFee;
	
	private int paymentType;
	
	private float amountSum;
	
	private int customerSum;
	
	private List<CustomerPo> customerList = new ArrayList<>();
	
	private List<RentPo> rentList = new ArrayList<>();
	
	public AccountPo() {}

	@Override
	public String toString() {
		return "AccountPo [accountId=" + accountId + ", accountType=" + accountType + ", bankId=" + bankId
				+ ", isAccountFree=" + isAccountFree + ", openAccountFee=" + openAccountFee + ", paymentType="
				+ paymentType + ", amountSum=" + amountSum + ", customerSum=" + customerSum + ", customerList="
				+ customerList + ", rentList=" + rentList + "]";
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

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
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

	public List<CustomerPo> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerPo> customerList) {
		this.customerList = customerList;
	}

	public List<RentPo> getRentList() {
		return rentList;
	}

	public void setRentList(List<RentPo> rentList) {
		this.rentList = rentList;
	}

}
