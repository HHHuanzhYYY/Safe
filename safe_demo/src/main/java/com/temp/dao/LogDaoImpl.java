package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.ReportLossPo;
import com.temp.util.ReportLossAction;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setReportLossLog(ReportLossPo reportLossPo, ReportLossAction reportlossAction) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
