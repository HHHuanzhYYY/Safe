package com.temp.po;

public class BankBranchPo extends Po {

	private long bankId; // 网点ID (0-新增，非0-编辑)
	
	private String bankTitle; // 网点名称
	
	private String remark; // 备注
	
	public BankBranchPo() {}

	@Override
	public String toString() {
		return "BankBranchPo [bankId=" + bankId + ", bankTitle=" + bankTitle + ", remark=" + remark + "]";
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
