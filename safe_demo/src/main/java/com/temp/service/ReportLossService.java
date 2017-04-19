package com.temp.service;

import com.temp.util.ReportLossAction;

public interface ReportLossService {

	/**
	 * bankEmployeeLogin.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String bankEmployeeLogin(final String rawData);
	
	/**
	 * setReportLossLog.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setReportLossLog(final String rawData, final ReportLossAction reportLossAction);
	
	/**
	 * getReportLossType.
	 * 
	 * @param rawData
	 * @return
	 */
	String getReportLossType(final String rawData);
	
	/**
	 * setReportLossDetails.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setReportLossDetails(final String rawData, final ReportLossAction reportLossAction);
	
}
