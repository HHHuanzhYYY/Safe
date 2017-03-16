package com.temp.service;

import com.temp.util.BoxStatus;

public interface BoxManageService {

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
	 * modifyBoxStatus.
	 * 
	 * @param rawData String from HttpRequest
	 * @param boxStatus
	 * @return JSON String Contains Account Info.
	 */
	String modifyBoxStatus(final String rawData, final BoxStatus boxStatus);
	
}
