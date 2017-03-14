package com.temp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.util.AccountType;
import com.temp.vo.CustomerVo;

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
	public CustomerVo getCustomerDetailsById(int custormerId) {
		final String sql = "";
		CustomerVo customerVo = jdbcTemplate.queryForObject(sql, new CustomerVoMapper(), custormerId);
		return customerVo;
	}
	
	class CustomerVoMapper implements RowMapper<CustomerVo> {

		@Override
		public CustomerVo mapRow(ResultSet arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}		
	}

	@Override
	public List<CustomerVo> getAllCustomersByAccountId(int accountId, AccountType accountType) {
		String sql = null;
		if (AccountType.SINGLE.equals(accountType)) {
			// todo.
		} else if (AccountType.UION.equals(accountType)) {
			// todo.
		}
		
		// todo.
		
		
		return null;
	}

	@Override
	public boolean setCustomer(CustomerVo newCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCustomerCardRelationship(int customerId, String cardRfid) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
