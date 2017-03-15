package com.temp.po;

import java.util.ArrayList;
import java.util.List;

public class AccountPo extends Po {

	private int accountId;
	
	private int accountType;
	
	private String bankId;
	
	private int customerNum;
	
	private List<CustomerPo> customers = new ArrayList<>();
	
	private List<RentPo> rents = new ArrayList<>();
	
	public AccountPo() {}
	
	@Override
	public String toString() {
		return "AccountPo [accountId=" + accountId + ", accountType=" + accountType + ", bankId=" + bankId
				+ ", customerNum=" + customerNum + ", customers=" + customers + ", rents=" + rents + "]";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public List<CustomerPo> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerPo> customers) {
		this.customers = customers;
	}

	public List<RentPo> getRents() {
		return rents;
	}

	public void setRents(List<RentPo> rents) {
		this.rents = rents;
	}
	
}
