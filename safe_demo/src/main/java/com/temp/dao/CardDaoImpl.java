package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.vo.CardVo;

@Repository
public class CardDaoImpl implements CardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setCard(CardVo card) {
		// TODO Auto-generated method stub
		return false;
	}

}
