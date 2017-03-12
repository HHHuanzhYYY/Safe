package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankEmployeeDaoImpl implements BankEmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateBankEmployee(String employeeName, String employeePwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
