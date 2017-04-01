package com.temp.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
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
		String insertEmployeeLoginLogSQL = "INSERT INTO employee_login_log(loginDateTime, remark, employeeId) "
										 + "VALUES(sysdate(), ?, ?) ";
		int count = jdbcTemplate.update(insertEmployeeLoginLogSQL, 
				new Object[] {bankEmployeeLoginLogPo.getRemark(), 
							  bankEmployeeLoginLogPo.getEmployeeId()}, 
				new int[] {Types.BIGINT, Types.VARCHAR});
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean setReportLossLog(ReportLossAction reportLossAction, 
			long boxId, int reportLossType, int paymentType, float feeTotal) {
		// Query "rentId" corresponding to the box.
		String queryRentIdSQL = "SELECT rentId FROM rent WHERE boxId = ? ";
		int rentId = jdbcTemplate.queryForObject(queryRentIdSQL, Integer.class, boxId);
		
		// Log the Action in table reportloss_log.
		String insertReportLossSQL = 
				"INSERT INTO reportloss_log(occurrenceTime, reportlossAction, "
										 + "reportLossType, paymentType, feeTotal, boxId, rentId) "
			  + "VALUES(NOW(), ?, ?, ?, ?, ?, ?) ";
		int count = jdbcTemplate.update(insertReportLossSQL, 
				new Object[] {reportLossAction.getValue(), reportLossType, paymentType, feeTotal, boxId, rentId}, 
				new int[] {Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.FLOAT, Types.INTEGER, Types.INTEGER});
		
		return count == 1  ? true : false;
	}

}
