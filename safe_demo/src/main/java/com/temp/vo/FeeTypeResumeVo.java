package com.temp.vo;

public class FeeTypeResumeVo extends Vo {

	private long feeTypeId;
	
	private String feeTypeTitle;
	
	public FeeTypeResumeVo() {}

	@Override
	public String toString() {
		return "FeeTypeResumeVo [feeTypeId=" + feeTypeId + ", feeTypeTitle=" + feeTypeTitle + "]";
	}

	public long getFeeTypeId() {
		return feeTypeId;
	}

	public void setFeeTypeId(long feeTypeId) {
		this.feeTypeId = feeTypeId;
	}

	public String getFeeTypeTitle() {
		return feeTypeTitle;
	}

	public void setFeeTypeTitle(String feeTypeTitle) {
		this.feeTypeTitle = feeTypeTitle;
	}
	
}
