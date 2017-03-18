package com.temp.po;

public class FeeTypePo extends Po {

	private int feeTypeId; // 费用类型ID
	
	private String feeTypeTitle; // 费用类型名称
	
	private int subjectId; // 所属科目
	
	private String remark; // 备注
	
	private float feeValue; // 费用值
	
	private int status; // 费用类型状态
	
	public FeeTypePo() {}

	@Override
	public String toString() {
		return "FeeTypeVo [feeTypeId=" + feeTypeId + ", feeTypeTitle=" + feeTypeTitle + ", subjectId=" + subjectId
				+ ", remark=" + remark + ", feeValue=" + feeValue + ", status=" + status + "]";
	}

	public int getFeeTypeId() {
		return feeTypeId;
	}

	public void setFeeTypeId(int feeTypeId) {
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
