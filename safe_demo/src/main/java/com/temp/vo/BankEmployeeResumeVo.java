package com.temp.vo;

public class BankEmployeeResumeVo extends Vo {

	private int employeeId; // 银行雇员ID
	
	private String employeeName; // 银行职员名
	
	public BankEmployeeResumeVo() {}

	@Override
	public String toString() {
		return "BankEmployeeResumeVo [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
