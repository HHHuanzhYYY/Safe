package com.temp.dao;

import com.temp.util.ReportLossAction;

public interface LogDao {

	/**
	 * setReportLossLog.
	 * 
	 * @param reportLossAction
	 * @param boxId
	 * @param reportLossType
	 * @param paymentType
	 * @param feeTotal
	 * @return boolean
	 */
	boolean setReportLossLog(ReportLossAction reportLossAction, 
			int boxId, int reportLossType, int paymentType, float feeTotal);
}
