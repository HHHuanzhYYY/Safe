package com.temp.po;

public class BankBranchPo extends Po {

	private int bankId; // ����ID (0-��������0-�༭)
	
	private String bankTitle; // ��������
	
	private String remark; // ��ע
	
	public BankBranchPo() {}

	@Override
	public String toString() {
		return "BankBranchPo [bankId=" + bankId + ", bankTitle=" + bankTitle + ", remark=" + remark + "]";
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}