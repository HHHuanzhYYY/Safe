package com.temp.dao;

import java.util.List;

import com.temp.po.BankEmployeePo;
import com.temp.vo.BankEmployeeVo;

public interface BankEmployeeDao {

	/**
	 * validateBankEmployee.
	 * 
	 * @param employeeName
	 * @param employeePwd
	 * @return employeeId
	 */
	int validateBankEmployeeByNameAndPwd(String employeeName, String employeePwd); 
	
	/**
	 * validateBankEmployeeByIdAndPwd.
	 * 
	 * @param employeeId
	 * @param employeePwd
	 * @return boolean
	 */
	boolean validateBankEmployeeByIdAndPwd(int employeeId, String employeePwd);
	
	/**
	 * listAllBankEmployees.
	 * 
	 * @param bankId
	 * @return List<BankEmployeeVo>
	 */
	List<BankEmployeeVo> getAllBankEmployees(long bankId);
	
	/**
	 * setBankEmployeeDetails.
	 * 
	 * @param bankEmployeePo
	 * @return employeeId
	 */
	long setBankEmployeeDetails(BankEmployeePo bankEmployeePo);
	
	/**
	 * deleteMessage.
	 * 
	 * @param messageIds
	 * @return boolean
	 */
	boolean deleteBankEmployee(List<Long> bankEmployeeIds); 
}
