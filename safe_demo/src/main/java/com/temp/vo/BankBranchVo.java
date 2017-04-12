package com.temp.vo;

public class BankBranchVo {

	private long bankId;
	
	private String bankTitle;
	
	private String remark;
	
	public BankBranchVo() {}

	@Override
	public String toString() {
		return "BankBranchVo [bankId=" + bankId + ", bankTitle=" + bankTitle + ", remark=" + remark + "]";
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
