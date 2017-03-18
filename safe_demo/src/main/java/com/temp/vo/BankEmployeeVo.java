package com.temp.vo;

public class BankEmployeeVo extends Vo {

	private int bankEmployeeId; // 银行职员ID
	
	private String loginId; // 登录ID
	
	private String employeeName; // 银行职员名
	
	private int priority; // 用户权限
	
	private String icCardNo; // IC卡号
	
	private int certificateType; // 证件类型
	
	private String certificateId; // 证件号码
	
	private int isAdministrator; // 管理员卡
	
	private String bankName; // 网点

	public BankEmployeeVo() {}

	@Override
	public String toString() {
		return "BankEmployeeVo [bankEmployeeId=" + bankEmployeeId + ", loginId=" + loginId + ", employeeName="
				+ employeeName + ", priority=" + priority + ", icCardNo=" + icCardNo + ", certificateType="
				+ certificateType + ", certificateId=" + certificateId + ", isAdministrator=" + isAdministrator
				+ ", bankName=" + bankName + "]";
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
