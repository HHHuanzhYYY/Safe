package com.temp.dao;

import com.temp.po.BankEmployeeLoginLogPo;
import com.temp.util.ReportLossAction;

public interface LogDao {
	
	/**
	 * setEmployeeLoginLog.
	 * 
	 * @param bankEmployeeLoginLogPo
	 * @return boolean
	 */
	boolean setEmployeeLoginLog(BankEmployeeLoginLogPo bankEmployeeLoginLogPo);
	
	/**
	 * setEmployeeLogoutLog.
	 * 
	 * @param bankEmployeeId
	 * @return
	 */
	boolean setEmployeeLogoutLog(long bankEmployeeId);

	/**
	 * setReportLossLog.
	 * 
	 * @param boxId
	 * @param reportLossType
	 * @param paymentType
	 * @param feeTotal
	 * @return boolean
	 */
	boolean setReportLossLog(long boxId, int reportLossType, int paymentType, float feeTotal);
	
	/**
	 * setReportLossLogUpdate.
	 * 
	 * @param boxId
	 * @param reportLossType
	 * @param paymentType
	 * @param feeTotal
	 * @return boolean
	 */
	boolean setReportLossLogUpdate(ReportLossAction reportlossAction, 
			long reportlossId, int paymentType, float feeTotal);
}
