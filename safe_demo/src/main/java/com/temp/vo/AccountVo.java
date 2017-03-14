package com.temp.vo;

public class AccountVo {

	private int AccountId;
	
	private int AccountType;
	
	private String BankId;
	
	private int CustomerNum;
	
	public AccountVo() {}
	
	public AccountVo(int accountId, int accountType, String bankId, int customerNum) {
		AccountId = accountId;
		AccountType = accountType;
		BankId = bankId;
		CustomerNum = customerNum;
	}

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	public int getAccountType() {
		return AccountType;
	}

	public void setAccountType(int accountType) {
		AccountType = accountType;
	}

	public String getBankId() {
		return BankId;
	}

	public void setBankId(String bankId) {
		BankId = bankId;
	}

	public int getCustomerNum() {
		return CustomerNum;
	}

	public void setCustomerNum(int customerNum) {
		CustomerNum = customerNum;
	}
	
}
