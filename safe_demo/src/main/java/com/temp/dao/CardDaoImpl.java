package com.temp.dao;

import java.sql.Types;

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
		final String insertCardSQL = "INSERT INTO card VALUES(?, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
		
		int count = jdbcTemplate.update(insertCardSQL, 
				new Object[] {card.getCardRfid(), card.getCardNo(), 
						card.getCardType(), card.getValidateType(), 
						card.getPassword(), card.getFingerPwd(), 
						card.getReserveFingerPwd(), card.getAccountId(), 
						card.getCustomerId()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, 
						Types.INTEGER, Types.VARCHAR, Types.VARCHAR, 
						Types.VARCHAR, Types.BIGINT, Types.INTEGER});
		
		return count == 1 ? true : false;
	}

	@Override
	public boolean modifyCardPwd(String cardRfid, String pwd) {
		String modifyCardPwdSQL = "UPDATE card SET password = ? WHERE cardRfid = ? ";
		
		int count = jdbcTemplate.update(modifyCardPwdSQL, 
				new Object[] {pwd, cardRfid}, 
				new int[] {Types.VARCHAR, Types.VARCHAR});
		
		return count == 1 ? true : false;
	}

}
