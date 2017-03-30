package com.temp.vo;

public class AccountVo extends Vo {

	private String accountId;
	
	private int accountType;
	
	private long bankId;
	
	private int customerSum;
	
	public AccountVo() {}
	
	public AccountVo(String accountId, int accountType, long bankId, int customerSum) {
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

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public int getCustomerSum() {
		return customerSum;
	}

	public void setCustomerSum(int customerSum) {
		this.customerSum = customerSum;
	}

}
