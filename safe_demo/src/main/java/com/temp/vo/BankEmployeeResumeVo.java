package com.temp.vo;

public class BankEmployeeResumeVo extends Vo {

	private long employeeId; // ���й�ԱID
	
	private String employeeName; // ����ְԱ��
	
	public BankEmployeeResumeVo() {}

	@Override
	public String toString() {
		return "BankEmployeeResumeVo [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
