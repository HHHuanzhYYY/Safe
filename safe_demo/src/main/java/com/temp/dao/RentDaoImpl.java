package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.RentPo;

@Repository
public class RentDaoImpl implements RentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setRent(RentPo rent) {
		// TODO Auto-generated method stub
		return false;
	}

}
