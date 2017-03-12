package com.temp.service;

public interface CustomerManagerService {
	
	/**
	 * validateCustomer.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String validateCustomer(final String rawData);

	/**
	 * getCustomerInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getCustomerInfo(final String rawData);
	
	/**
	 * setCustomerInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setCustomerInfo(final String rawData);
	
	/**
	 * getCustomerInfoById.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getCustomerInfoById(final String rawData);
}
