package com.temp.service;

public interface AccountManagerService {

	/**
	 * getAccoutListByIdOrRFID.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getAccoutListByIdOrRFID(final String rawData);
	
	/**
	 * setAccountInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setAccountInfo(final String rawData);
}
