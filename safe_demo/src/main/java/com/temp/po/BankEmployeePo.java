package com.temp.po;

public class BankEmployeePo extends Po {

	private int employeeId; // 银行职员ID
	
	private String loginId; // 登录ID
	
	private String employeeName; // 银行职员名
	
	private int priority; // 用户权限
	
	private int certificateType; // 证件类型
	
	private String certificateId; // 证件号码
	
	private String mobile; // 手机号
	
	private int bankId; // 网点ID
	
	private String icCardNo; // IC卡号
	
	private int isAdministrator; // 管理员卡
	
	private String remark; // 备注
	
	public BankEmployeePo() {}

	@Override
	public String toString() {
		return "BankEmployeePo [employeeId=" + employeeId + ", loginId=" + loginId + ", employeeName="
				+ employeeName + ", priority=" + priority + ", certificateType=" + certificateType + ", certificateId="
				+ certificateId + ", mobile=" + mobile + ", bankId=" + bankId + ", icCardNo=" + icCardNo
				+ ", isAdministrator=" + isAdministrator + ", remark=" + remark + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
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

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
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
