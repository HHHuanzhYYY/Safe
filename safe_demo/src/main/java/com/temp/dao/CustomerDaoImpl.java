package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.domain.CustomerDetails;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateCustomer(int customerId, String pwd, String fingerPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerDetails getCustomerDetailsById(int custormerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
