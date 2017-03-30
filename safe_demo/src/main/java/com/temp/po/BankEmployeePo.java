package com.temp.po;

public class BankEmployeePo extends Po {

	private long employeeId; // ����ְԱID
	
	private String loginId; // ��¼ID
	
	private String employeeName; // ����ְԱ��
	
	private int priority; // �û�Ȩ��
	
	private int certificateType; // ֤������
	
	private String certificateId; // ֤������
	
	private String mobile; // �ֻ���
	
	private long bankId; // ����ID
	
	private String icCardNo; // IC����
	
	private int isAdministrator; // ����Ա��
	
	private String remark; // ��ע
	
	public BankEmployeePo() {}

	@Override
	public String toString() {
		return "BankEmployeePo [employeeId=" + employeeId + ", loginId=" + loginId + ", employeeName="
				+ employeeName + ", priority=" + priority + ", certificateType=" + certificateType + ", certificateId="
				+ certificateId + ", mobile=" + mobile + ", bankId=" + bankId + ", icCardNo=" + icCardNo
				+ ", isAdministrator=" + isAdministrator + ", remark=" + remark + "]";
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
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
