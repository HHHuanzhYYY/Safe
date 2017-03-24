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
	
	/**
	 * listAllBankEmployees.
	 * 
	 * @param bankId
	 * @return List<BankEmployeeVo>
	 */
	List<BankEmployeeVo> getAllBankEmployees(int bankId);
	
	/**
	 * setBankEmployeeDetails.
	 * 
	 * @param bankEmployeePo
	 * @return employeeId
	 */
	int setBankEmployeeDetails(BankEmployeePo bankEmployeePo);
	
	/**
	 * deleteMessage.
	 * 
	 * @param messageIds
	 * @return boolean
	 */
	boolean deleteBankEmployee(List<Integer> bankEmployeeIds); 
}
