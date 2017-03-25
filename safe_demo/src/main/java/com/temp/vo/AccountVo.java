package com.temp.vo;

public class AccountVo extends Vo {

	private String accountId;
	
	private int accountType;
	
	private String bankId;
	
	private int customerSum;
	
	public AccountVo() {}
	
	public AccountVo(String accountId, int accountType, String bankId, int customerSum) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.bankId = bankId;
		this.customerSum = customerSum;
	}
	
	@Override
	public String toString() {
		return "AccountVo [accountId=" + accountId + ", accountType=" + accountType + ", bankId=" + bankId
				+ ", customerSum=" + customerSum + "]";
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

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public int getCustomerSum() {
		return customerSum;
	}

	public void setCustomerSum(int customerSum) {
		this.customerSum = customerSum;
	}

}
