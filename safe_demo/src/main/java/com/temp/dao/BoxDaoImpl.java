package com.temp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.BoxDetailsPo;
import com.temp.po.BoxModelPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxDetailsVo;
import com.temp.vo.BoxModelVo;
import com.temp.vo.BoxVo;

@Repository
public class BoxDaoImpl implements BoxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoxVo> getAllBoxsByAccountId(int accountId, AccountType accountType) {
		//String sql = null;
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
	public boolean setBoxStatusChangeDetails(int boxId, BoxStatus boxStatusFuture, String reason) {
		boolean isSucceed = false;
		int modifyRows = 0;
		int insertRows = 0;
		try {
			String queryBoxStatusSQL = "SELECT status FROM box WHERE boxId = ?";
			int boxCurrentStatus = jdbcTemplate.queryForObject(queryBoxStatusSQL, Integer.class, boxId);
			
			String modifyBoxStatusSQL = "UPDATE box SET status = ? WHERE boxId = ?";		
			modifyRows = jdbcTemplate.update(modifyBoxStatusSQL, boxStatusFuture.getValue(), boxId);
			
			String insertTalbeBoxStatusChangeSQL = 
					"INSERT INTO box_status_change(boxId, statusChangeDateTime, statusBefore, statusCurrent, changeReason)" +  
					"VALUES(?, NOW(), ?, ?, ?)";
			insertRows = jdbcTemplate.update(insertTalbeBoxStatusChangeSQL, boxId, boxCurrentStatus, boxStatusFuture.getValue(), reason);
		} catch (Exception e) {
			isSucceed = false;
		}
		
		if ((modifyRows == 1) && (insertRows == 1)) {
			isSucceed = true;
		} else {
			// Log.
			
		}
		return isSucceed;
	}

	@Override
	public boolean setBoxNewKey(int boxId, String keyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoxDetailsVo> getAllBoxs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBoxDetails(BoxDetailsPo boxDetailsPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBox(List<Integer> boxIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoxModelVo> getAllBoxModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setBoxModelDetails(BoxModelPo boxModelPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoxModel(List<String> boxModels) {
		// TODO Auto-generated method stub
		return false;
	}
}
