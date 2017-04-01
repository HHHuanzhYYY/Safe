package com.temp.service;

import java.util.Random;

public interface AccountManageService {

	/**
	 * generateAccountId.
	 * 
	 * @return accountId
	 */
	default String generateAccountId() {
		return Long.toString(new Random().nextLong());
	}
	
	/**
	 * getAccoutListByIdOrRFID.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getAccoutListByIdOrRFID(final String rawData);
	
	/**
	 * getAccountInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getAccountInfo(final String rawData);
	
	/**
	 * setAccountInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setAccountInfo(final String rawData);
	
	/**
	 * setAccountNewBox.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setAccountNewBox(final String rawData);
	
	/**
	 * setAccountNewCustomer.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setAccountNewCustomer(final String rawData);
}
