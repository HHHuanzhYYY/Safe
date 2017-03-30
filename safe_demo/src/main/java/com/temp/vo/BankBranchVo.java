package com.temp.vo;

public class BankBranchVo {

	private long bankId;
	
	private String bankTitle;
	
	public BankBranchVo() {}

	@Override
	public String toString() {
		return "BankBranchVo [bankId=" + bankId + ", bankTitle=" + bankTitle + "]";
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}
	
}
