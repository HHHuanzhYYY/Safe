package com.temp.po;

public class BankEmployeePo extends Po {

	private int bankEmployeeId; // ����ְԱID
	
	private String loginId; // ��¼ID
	
	private String employeeName; // ����ְԱ��
	
	private int priority; // �û�Ȩ��
	
	private int certificateType; // ֤������
	
	private String certificateId; // ֤������
	
	private String mobile; // �ֻ���
	
	private String bankName; // ����
	
	private String icCardNo; // IC����
	
	private int isAdministrator; // ����Ա��
	
	private String remark; // ��ע
	
	public BankEmployeePo() {}

	@Override
	public String toString() {
		return "BankEmployeePo [bankEmployeeId=" + bankEmployeeId + ", loginId=" + loginId + ", employeeName="
				+ employeeName + ", priority=" + priority + ", certificateType=" + certificateType + ", certificateId="
				+ certificateId + ", mobile=" + mobile + ", bankName=" + bankName + ", icCardNo=" + icCardNo
				+ ", isAdministrator=" + isAdministrator + ", remark=" + remark + "]";
	}

	public int getBankEmployeeId() {
		return bankEmployeeId;
	}

	public void setBankEmployeeId(int bankEmployeeId) {
		this.bankEmployeeId = bankEmployeeId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(int certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIcCardNo() {
		return icCardNo;
	}

	public void setIcCardNo(String icCardNo) {
		this.icCardNo = icCardNo;
	}

	public int getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(int isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
