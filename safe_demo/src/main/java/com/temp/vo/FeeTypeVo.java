package com.temp.vo;

public class FeeTypeVo extends Vo {

	private long feeTypeId;
	
	private String feeTypeTitle;
	
	private int subjectId;
	
	private String subjectTitle;
	
	private String remark;
	
	private float feeValue;
	
	private int status; 
	
	public FeeTypeVo() {}

	@Override
	public String toString() {
		return "FeeTypeVo [feeTypeId=" + feeTypeId + ", feeTypeTitle=" + feeTypeTitle + ", subjectId=" + subjectId
				+ ", subjectTitle=" + subjectTitle + ", remark=" + remark + ", feeValue=" + feeValue + ", status="
				+ status + "]";
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

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public float getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(float feeValue) {
		this.feeValue = feeValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
