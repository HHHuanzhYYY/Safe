package com.temp.service;

import javax.servlet.http.Cookie;

public interface BankEmployeeService {
	
	/**
	 * validateBankEmployee.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String validateBankEmployee(final String rawData, Cookie... cookies);  
	
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
}
