package com.temp.service;

public interface BankEmployeeService {
	
	/**
	 * validateBankEmployee.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String validateBankEmployee(final String rawData);  
}
