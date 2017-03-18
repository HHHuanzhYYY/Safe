package com.temp.vo;

public class BankBranchVo {

	private int bankId;
	
	private String bankTitle;
	
	public BankBranchVo() {}

	@Override
	public String toString() {
		return "BankBranchVo [bankId=" + bankId + ", bankTitle=" + bankTitle + "]";
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}
	
}
