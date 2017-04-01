package com.temp.po;

public class AccountAddCustomerPo extends Po {

	private String accountId;
	
	private CustomerPo customer;
	
	public AccountAddCustomerPo() {}

	@Override
	public String toString() {
		return "AccountAddCustomerPo [accountId=" + accountId + ", customer=" + customer + "]";
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public CustomerPo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPo customer) {
		this.customer = customer;
	}

}
