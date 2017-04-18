package com.temp.service;

import java.util.Map;

public interface BankEmployeeService {
	
	/**
	 * validateBankEmployee.
	 * 
	 * @param requestInfo
	 * @return String[0]: JSON String Contains Account Info.
	 * 		   String[1]: BankEmployeeId
	 */
	String[] validateBankEmployee(final Map<String, Object> requestInfo);  
	
	/**
	 * getAllBankEmployees.
	 * 
	 * @param rawData
	 * @return String
	 */
	String getAllBankEmployees(final String rawData);
	
	/**
	 * setBankEmployeeDetails.
	 * 
	 * @param bankEmployeePo
	 * @return String
	 */
	String setBankEmployeeDetails(final String rawData);
	
	/**
	 * deleteBankEmployee.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteBankEmployee(final String rawData);
	
	/**
	 * getBankEmployeeLogout.
	 * 
	 * @param rawData
	 * @return
	 */
	String getBankEmployeeLogout(final String rawData);
}
