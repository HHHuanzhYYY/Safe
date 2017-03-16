package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.util.AccountType;
import com.temp.vo.BoxVo;

@Repository
public class BoxDaoImpl implements BoxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoxVo> getAllBoxsByAccountId(int accountId, AccountType accountType) {
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
	public boolean setBox(BoxVo box) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBoxCardRelationship(int boxId, String cardRfid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBoxStatusChangeDetails(int boxId, int boxStatusFuture, String reason) {
		// TODO Auto-generated method stub
		return false;
	}

}
