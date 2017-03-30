package com.temp.vo;

public class BankEmployeeVo extends Vo {

	private long employeeId; // ����ְԱID
	
	private String loginId; // ��¼ID
	
	private String employeeName; // ����ְԱ��
	
	private int priority; // �û�Ȩ��
	
	private String icCardNo; // IC����
	
	private int certificateType; // ֤������
	
	private String certificateId; // ֤������
	
	private int isAdministrator; // ����Ա��
	
	private long bankId; // ����ID
	
	private String bankTitle; // ����

	public BankEmployeeVo() {}

	@Override
	public String toString() {
		return "BankEmployeeVo [employeeId=" + employeeId + ", loginId=" + loginId + ", employeeName="
				+ employeeName + ", priority=" + priority + ", icCardNo=" + icCardNo + ", certificateType="
				+ certificateType + ", certificateId=" + certificateId + ", isAdministrator=" + isAdministrator
				+ ", bankId=" + bankId + ", bankTitle=" + bankTitle + "]";
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

	public String getIcCardNo() {
		return icCardNo;
	}

	public void setIcCardNo(String icCardNo) {
		this.icCardNo = icCardNo;
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

	public int getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(int isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankTitle() {
		return bankTitle;
	}

	public void setBankTitle(String bankTitle) {
		this.bankTitle = bankTitle;
	}
	
}
