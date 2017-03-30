package com.temp.po;

public class FeeTypePo extends Po {

	private long feeTypeId; // ��������ID
	
	private String feeTypeTitle; // ������������
	
	private long subjectId; // ������Ŀ
	
	private String remark; // ��ע
	
	private float feeValue; // ����ֵ
	
	private int status; // ��������״̬
	
	public FeeTypePo() {}

	@Override
	public String toString() {
		return "FeeTypeVo [feeTypeId=" + feeTypeId + ", feeTypeTitle=" + feeTypeTitle + ", subjectId=" + subjectId
				+ ", remark=" + remark + ", feeValue=" + feeValue + ", status=" + status + "]";
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

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
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
