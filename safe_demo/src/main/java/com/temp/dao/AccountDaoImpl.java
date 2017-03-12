package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.domain.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Account> getAccountListById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountListByRFID(String rfid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
