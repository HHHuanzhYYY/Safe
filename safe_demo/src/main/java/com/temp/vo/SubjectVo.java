package com.temp.vo;

import java.util.List;

public class SubjectVo extends Vo {

	private long subjectId; 
	
	private String subjectCode; 
	
	private String subjectTitle; 
	
	private int direction; 
	
	private String remark;
	
	private List<FeeTypeResumeVo> feeTypeList;

	public SubjectVo() {}

	@Override
	public String toString() {
		return "SubjectVo [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectTitle=" + subjectTitle
				+ ", direction=" + direction + ", remark=" + remark + ", feeTypeList=" + feeTypeList + "]";
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<FeeTypeResumeVo> getFeeTypeList() {
		return feeTypeList;
	}

	public void setFeeTypeList(List<FeeTypeResumeVo> feeTypeList) {
		this.feeTypeList = feeTypeList;
	}	
	
}
