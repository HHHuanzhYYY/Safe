package com.temp.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.BankEmployeeLoginLogPo;
import com.temp.util.ReportLossAction;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setEmployeeLoginLog(BankEmployeeLoginLogPo bankEmployeeLoginLogPo) {
		String insertEmployeeLoginLogSQL = "INSERT INTO log_employee_loginout(inOutDateTime, inOutFlag, remark, employeeId) "
										 + "VALUES(sysdate(), 0, ?, ?) ";
		int count = jdbcTemplate.update(insertEmployeeLoginLogSQL, 
				new Object[] {bankEmployeeLoginLogPo.getRemark(), 
							  bankEmployeeLoginLogPo.getEmployeeId()}, 
				new int[] {Types.VARCHAR, Types.BIGINT});
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean setEmployeeLogoutLog(long bankEmployeeId) {
		String insertEmployeeLogoutLogSQL = 
				"INSERT INTO log_employee_loginout(inOutDateTime, inOutFlag, remark, employeeId) "
			  + "VALUES(sysdate(), 0, null, ?) ";
		int count = jdbcTemplate.update(insertEmployeeLogoutLogSQL, 
				new Object[] {bankEmployeeId}, 
				new int[] {Types.BIGINT});
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean setReportLossLog(long boxId, int reportLossType, int paymentType, float feeTotal) {
		// Query "rentId" corresponding to the box.
		String queryRentIdSQL = "SELECT rentId FROM rent WHERE boxId = ? AND rent.rentStatus = 0 ";
		long rentId = 0;
		try {
			rentId = jdbcTemplate.queryForObject(queryRentIdSQL, 
					new Object[] {boxId},
					new int[] {Types.BIGINT},
					Long.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			rentId = 0;
		}
		if (rentId == 0) {
			return false;
		}
		
		// Log the Action in table reportloss_log.
		String insertReportLossSQL = 
				"INSERT INTO reportloss_log(reportlossStatus, applyTime, reportlossType, "
										 + "applyPaymentType, applyFeeTotal, boxId, rentId) "
			  + "VALUES(0, NOW(), ?, ?, ?, ?, ?) ";
		int count = jdbcTemplate.update(insertReportLossSQL, 
				new Object[] {reportLossType, paymentType, feeTotal, boxId, rentId}, 
				new int[] {Types.INTEGER, Types.INTEGER, Types.FLOAT, 
						   Types.BIGINT,  Types.BIGINT});
		
		return count == 1  ? true : false;
	}

	@Override
	public boolean setReportLossLogUpdate(ReportLossAction reportlossAction, long reportlossId, int paymentType,
			float feeTotal) {
		String updateReportLossLogSQL = null;
		switch (reportlossAction) {
		case HANDLEEPORTLOSS:
			updateReportLossLogSQL = 
					  "UPDATE reportloss_log "
					+ "SET processTime = NOW(), processPaymentType = ?, processFeeTotal = ? "
					+ "WHERE reportlossId = ? ";
			break;
		case REMOVEREPORTLOSS:
			updateReportLossLogSQL = 
			  		  "UPDATE reportloss_log "
			  		+ "SET removeTime = NOW(), removePaymentType = ?, removeFeeTotal = ? "
			  		+ "WHERE reportlossId = ? ";
			break;
		default:
			return false;
		}
		int count = jdbcTemplate.update(updateReportLossLogSQL, 
				new Object[] {paymentType, feeTotal, reportlossId}, 
				new int[] {Types.INTEGER, Types.FLOAT, Types.BIGINT});
		
		return count == 1 ? true : false;
	}

}
