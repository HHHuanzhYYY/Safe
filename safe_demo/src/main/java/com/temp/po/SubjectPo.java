package com.temp.po;

public class SubjectPo extends Po {

	private int subjectId; // 科目ID（0-新增，非0-编辑）
	
	private String subjectCode; // 科目代码
	
	private String subjectTitle; // 科目名称
	
	private int direction; // 方向
	
	private String remark; // 备注

	public SubjectPo() {}

	@Override
	public String toString() {
		return "SubjectPo [subjectId=" + subjectId + ", subjectCode=" + subjectCode + ", subjectTitle=" + subjectTitle
				+ ", direction=" + direction + ", remark=" + remark + "]";
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
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
