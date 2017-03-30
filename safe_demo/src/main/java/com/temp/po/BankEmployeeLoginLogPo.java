package com.temp.po;

public class BankEmployeeLoginLogPo extends Po {

	private long employeeId;
	
	private String remark;
	
	public BankEmployeeLoginLogPo() {}

	@Override
	public String toString() {
		return "BankEmployeeLoginLogPo [employeeId=" + employeeId + ", remark=" + remark + "]";
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
