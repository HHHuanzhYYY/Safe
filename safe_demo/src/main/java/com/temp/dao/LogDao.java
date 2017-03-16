package com.temp.dao;

import com.temp.po.ReportLossPo;
import com.temp.util.ReportLossAction;

public interface LogDao {

	/**
	 * setReportLossLog.
	 * 
	 * @param reportLossPo
	 * @param ReportLossAction
	 * @return boolean
	 */
	boolean setReportLossLog(ReportLossPo reportLossPo, ReportLossAction reportlossAction);
}
