package com.temp.vo;

public class SubjectVo extends Vo {

	private long subjectId; // ��ĿID
	
	private String subjectCode; // ��Ŀ����
	
	private String subjectTitle; // ��Ŀ����
	
	private int direction; // ����
	
	private String remark; // ��ע

	public SubjectVo() {}

	@Override
	public String toString() {
		return "SubjectVo [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectTitle=" + subjectTitle
				+ ", direction=" + direction + ", remark=" + remark + "]";
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
	
}
