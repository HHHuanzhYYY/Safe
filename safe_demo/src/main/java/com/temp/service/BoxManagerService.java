package com.temp.service;

public interface BoxManagerService {

	/**
	 * modifyBoxPwd.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String modifyBoxPwd(final String rawData);
	
	/**
	 * changeBox.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String changeBox(final String rawData);
	
	/**
	 * freezeBox.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String freezeBox(final String rawData);
	
	/**
	 * unfreezeBox.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String unfreezeBox(final String rawData);
	
}
