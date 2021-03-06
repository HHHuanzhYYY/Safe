package com.temp.service;

public interface CustomerManageService {
		
	/**
	 * validateCustomer.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String validateCustomer(final String rawData);
	
	/**
	 * customerLogin.
	 * 
	 * @param rawData
	 * @return JSON String Contains Account Info.
	 */
	String customerLogin(final String rawData);
	
	/**
	 * getCustomerInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getCustomerData(final String rawData);
	
	/**
	 * setCustomerInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setCustomerData(final String rawData);
	
}
