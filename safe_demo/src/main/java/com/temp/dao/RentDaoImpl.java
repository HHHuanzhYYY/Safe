package com.temp.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.RentPo;
import com.temp.vo.UnrentVo;

@Repository
public class RentDaoImpl implements RentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setRent(RentPo rent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getBoxInfo4CountOverdueFineInfo(int boxId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setReletInfo(Map<String, Object> reletInfo) {
		// Need to Use "Merge Statement".
		
		return false;
	}

	@Override
	public UnrentVo getUnrentInfo(int boxId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setUnrentInfo(Map<String, Object> unrentInfo) {
		// TODO Auto-generated method stub
		return false;
	}

}
