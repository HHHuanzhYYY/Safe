package com.temp.po;

public class AccountAddBoxPo extends Po {

	private String accountId;
	
	private RentPo boxRent;

	public AccountAddBoxPo() {}

	@Override
	public String toString() {
		return "AccountAddBoxPo [accountId=" + accountId + ", boxRent=" + boxRent + "]";
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public RentPo getBoxRent() {
		return boxRent;
	}

	public void setBoxRent(RentPo boxRent) {
		this.boxRent = boxRent;
	}

}
