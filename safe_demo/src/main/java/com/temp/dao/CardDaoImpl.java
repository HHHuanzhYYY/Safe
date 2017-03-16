package com.temp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.CardPo;

@Repository
public class CardDaoImpl implements CardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setCard(CardPo card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyCardPwd(String cardRfid, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
