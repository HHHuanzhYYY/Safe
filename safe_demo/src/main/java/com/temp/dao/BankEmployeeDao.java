package com.temp.dao;

public interface BankEmployeeDao {

	/**
	 * validateBankEmployee.
	 * 
	 * @param employeeName
	 * @param employeePwd
	 * @return boolean
	 */
	boolean validateBankEmployeeByNameAndPwd(String employeeName, String employeePwd); 
	
	/**
	 * validateBankEmployeeByIdAndPwd.
	 * 
	 * @param employeeId
	 * @param employeePwd
	 * @return boolean
	 */
	boolean validateBankEmployeeByIdAndPwd(int employeeId, String employeePwd);
}
