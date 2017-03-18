package com.temp.service;

public interface AccountManageService {

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
}