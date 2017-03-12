package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
}
