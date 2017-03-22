package com.temp.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.util.ReportLossAction;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean setReportLossLog(ReportLossAction reportLossAction, 
			int boxId, int reportLossType, int paymentType, float feeTotal) {
		// ≤È—Ø rentId.
		String queryRentIdSQL = "SELECT rentId FROM rent WHERE boxId = ? ";
		int rentId = jdbcTemplate.queryForObject(queryRentIdSQL, Integer.class, boxId);
		
		// –¥ reportloss_log.
		String insertReportLossSQL = 
				"INSERT INTO reportloss_log(occurrenceTime, reportlossAction, "
										 + "reportLossType, paymentType, feeTotal, boxId, rentId) "
			  + "VALUES(NOW(), ?, ?, ?, ?, ?, ?) ";
		int count = jdbcTemplate.update(insertReportLossSQL, 
				new Object[] {reportLossAction.getValue(), reportLossType, paymentType, feeTotal, boxId, rentId}, 
				new int[] {Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.FLOAT, Types.INTEGER, Types.INTEGER});
		
		// …Ë÷√œ‰◊”◊¥Ã¨Œ™ "π“ ß"
		String setBoxStatusSQL = "UPDATE box SET status = ? WHERE boxId = ? ";
		int count1 = jdbcTemplate.update(setBoxStatusSQL, 
				new Object[] {reportLossAction.getValue(), boxId}, 
				new int[] {Types.INTEGER, Types.INTEGER});
		
		return ((count == 1) && (count1 == 1))  ? true : false;
	}

}
