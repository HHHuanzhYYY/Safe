package com.temp.vo;

public class AccountVo extends Vo {

	private int accountId;
	
	private int accountType;
	
	private String bankId;
	
	private int customerNum;
	
	public AccountVo() {}
	
	public AccountVo(int accountId, int accountType, String bankId, int customerNum) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.bankId = bankId;
		this.customerNum = customerNum;
	}
	
	@Override
	public String toString() {
		return "AccountVo [accountId=" + accountId + ", accountType=" + accountType + ", bankId=" + bankId
				+ ", customerNum=" + customerNum + "]";
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

}
