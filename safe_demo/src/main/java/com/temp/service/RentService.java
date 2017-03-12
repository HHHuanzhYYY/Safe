package com.temp.service;

public interface RentService {

	/**
	 * getBoxDetails.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getBoxDetails(final String rawData);
	
	/**
	 * setBoxReletInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setBoxReletInfo(final String rawData);
	
	/**
	 * setBoxUnrentInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setBoxUnrentInfo(final String rawData);
}
