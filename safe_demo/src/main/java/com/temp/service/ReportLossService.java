package com.temp.service;

public interface ReportLossService {

	/**
	 * bankEmployeeLogin.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String bankEmployeeLogin(final String rawData);
	
	/**
	 * setReportLossDetails.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setReportLossDetails(final String rawData);
	
	/**
	 * removeReportLossState.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String removeReportLossState(final String rawData);
}
