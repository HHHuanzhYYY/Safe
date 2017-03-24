package com.temp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.po.BoxModelResumePo;
import com.temp.po.BoxModelPo;
import com.temp.po.ChangeBoxPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxModelResumeVo;
import com.temp.vo.BoxModelVo;
import com.temp.vo.BoxVo;

@Repository
public class BoxDaoImpl implements BoxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoxVo> getAllBoxsByAccountId(long accountId, AccountType accountType) {
		List<BoxVo> boxVos = null;
		String queryBoxesSQL = "";
		if (AccountType.SINGLE.equals(accountType)) {
			// Card 信息绑定到 Box 上面
			queryBoxesSQL = "SELECT box.boxId, box.boxModel, box.keyId, "
					             + "cardtemp.cardNo, cardtemp.cardRfid, cardtemp.cardType, cardtemp.cardStatus, "
					             + "rent.deposit, rent.actualRent, rent.endDate " 
					      + "FROM rent, box, (SELECT card.cardNo, card.cardRfid, card.cardType, "
					                              + "card.cardStatus, card.accountId "
					      				   + "FROM card "
					      				   + "WHERE card.accountId = ?) AS cardtemp "
					      + "WHERE rent.boxId = box.boxId "
					        + "AND rent.accountId = cardtemp.accountId "
					        + "AND rent.accountId = ?";
			
			boxVos = jdbcTemplate.queryForList(queryBoxesSQL, 
					new Object[] {accountId, accountId}, 
					new int[] {Types.BIGINT, Types.BIGINT}, 
					BoxVo.class);
		} else if (AccountType.UION.equals(accountType)) {
			// Card 信息绑定到 Customer 上面
			queryBoxesSQL = "SELECT box.bankId, box.boxModel, box.keyId, "
					             + "rent.deposit, rent.actualRent, rent.endDate "
					      + "FROM rent, box " 
					      + "WHERE rent.boxId = box.boxId and rent.accountId = ? ";
			boxVos = jdbcTemplate.queryForList(queryBoxesSQL, 
					new Object[] {accountId}, 
					new int[] {Types.BIGINT}, 
					BoxVo.class);
		}
		
		return boxVos;
	}

	@Override
	public boolean setBox(BoxVo box) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBoxCardRelationship(int boxId, String cardRfid) {
		final String insertBoxCardRelationshipSQL = "INSERT INTO box_card_relationship(cardRfid, boxId) VALUES (?, ?)";
		
		int count = jdbcTemplate.update(insertBoxCardRelationshipSQL, 
				new Object[] {cardRfid, boxId}, 
				new int[] {Types.VARCHAR, Types.INTEGER});
		
		return count == 1 ? true : false;
	}

	@Override
	public boolean setBoxStatusChangeDetails(int boxId, BoxStatus boxStatusFuture, String reason) {
		boolean isSucceed = false;
		int modifyRows = 0;
		int insertRows = 0;
		try {
			String queryBoxStatusAndRentIdSQL = "SELECT status, rentId FROM box WHERE boxId = ?";
			Map<String, Object> statusAndRentId = jdbcTemplate.queryForMap(queryBoxStatusAndRentIdSQL, 
					new Object[] {boxId}, new int[] {Types.INTEGER});
			
			String modifyBoxStatusSQL = "UPDATE box SET status = ? WHERE boxId = ?";		
			modifyRows = jdbcTemplate.update(modifyBoxStatusSQL, boxStatusFuture.getValue(), boxId);
			
			String insertTalbeBoxStatusChangeSQL = 
					"INSERT INTO box_status_change(boxId, rentId, statusChangeDateTime, statusBefore, statusCurrent, changeReason)" +  
					"VALUES(?, ?, NOW(), ?, ?, ?)";
			insertRows = jdbcTemplate.update(insertTalbeBoxStatusChangeSQL, boxId, (int)statusAndRentId.get("rentId"), 
					(int)statusAndRentId.get("status"), boxStatusFuture.getValue(), reason);
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
	public Map<String, Object> getBoxKeyDetails(int boxId) {
		// Map<String, Object> = {<"newKeyNo", ***>, <"newBoxKeyFee", ***>, <"newBoxRentDay", ***>}
		Map<String, Object> retInfo = null;
		
		// 新箱子单把钥匙费用和日租金.
		String queryKeyFeeAndRentDaySQL = 
				"SELECT keyNo AS newKeyNo, keyFee AS newBoxKeyFee, box_model.rentDay AS newBoxRentDay "
			  + "FROM box, `key`, box_model "
			  + "WHERE box.keyNo = `key`.keyNo "
				+ "AND box.boxModel = box_model.boxModel "
				+ "AND box.boxId = ? ";
		retInfo = jdbcTemplate.queryForMap(queryKeyFeeAndRentDaySQL, boxId);
		
		return retInfo;
	}
	
	@Override
	public boolean modifyBoxCardRelationship(int oldBoxId, int newBoxId) {
		String modifySQL = "UPDATE box_card_relationship SET boxId = ? WHERE boxId = ? ";
		int count = jdbcTemplate.update(modifySQL, newBoxId, oldBoxId);
		return count > 0 ? true : false;
	}

	@Override
	public boolean setChangeBoxDetails(ChangeBoxPo changeBoxPo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBoxNewKey(int boxId, String keyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoxModelResumeVo> getAllBoxModelResumes() {
		String queryBoxDetailsSQL = "SELECT boxModelNo, boxModel, remark FROM box_model ";
		List<BoxModelResumeVo> boxDetailsVos = jdbcTemplate.query(queryBoxDetailsSQL, 
				new RowMapper<BoxModelResumeVo>() {

			@Override
			public BoxModelResumeVo mapRow(ResultSet rs, int arg1) throws SQLException {
				BoxModelResumeVo boxModelResumeVo = new BoxModelResumeVo();
				
				boxModelResumeVo.setBoxModelNo(rs.getInt("boxModelNo"));
				boxModelResumeVo.setBoxModel(rs.getString("boxModel"));
				boxModelResumeVo.setRemark(rs.getString("remark"));
				
				return boxModelResumeVo;
			}
			
		});
		return boxDetailsVos;
	}
	
	@Override
	public boolean setAllBoxModelResumes(BoxModelResumePo boxModelResumePo) {
		String insertBoxModelResumeSQL = "INSERT INTO box_model(boxModel, boxModelNo, remark) VALUES(?, ?, ?) ";
		int count = jdbcTemplate.update(insertBoxModelResumeSQL, 
				new Object[] {boxModelResumePo.getBoxModel(), 
							  boxModelResumePo.getBoxModelNo(), 
							  boxModelResumePo.getRemark()}, 
				new int[] {Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
		return count == 1 ? true : false;
	}
	
	@Override
	public boolean deleteBoxModel(List<String> boxModels) {
		String deleteBoxModelSQL = "DELETE FROM box_model WHERE boxModel = ? ";
		List<Object[]> batchArgs = new ArrayList<>();
		for (String boxModel : boxModels) {
			Object[] batchArg = new Object[] {boxModel};
			batchArgs.add(batchArg);
		}
		int[] ret = jdbcTemplate.batchUpdate(deleteBoxModelSQL, batchArgs, new int[] {Types.VARCHAR});
		
		return ret.length == 0 ? false : true;
	}
	
	@Override
	public List<BoxModelVo> getAllBoxModels() {
		String queryBoxModelSQL = "SELECT boxModel, boxModelNo, deposit, rentYear, rentMonth, "
									   + "rentDay, boxLength, boxWidth, boxHeight "
				                + "FROM box_model ";
		List<BoxModelVo> boxModelVos = jdbcTemplate.query(queryBoxModelSQL, 
				new RowMapper<BoxModelVo>() {

					@Override
					public BoxModelVo mapRow(ResultSet rs, int arg1) throws SQLException {
						BoxModelVo boxModelVo = new BoxModelVo();
						
						boxModelVo.setBoxModel(rs.getString("boxModel"));
						boxModelVo.setBoxModelNo(rs.getInt("boxModelNo"));
						boxModelVo.setDeposit(rs.getFloat("deposit"));
						boxModelVo.setRentYear(rs.getFloat("rentYear"));
						boxModelVo.setRentMonth(rs.getFloat("rentMonth"));
						boxModelVo.setRentDay(rs.getFloat("rentDay"));
						boxModelVo.setBoxLength(rs.getFloat("boxLength"));
						boxModelVo.setBoxWidth(rs.getFloat("boxWidth"));
						boxModelVo.setBoxHeight(rs.getFloat("boxHeight"));
						
						return boxModelVo;
					}
			
		});
		return boxModelVos;
	}

	@Override
	public boolean setBoxModelDetails(BoxModelPo boxModelPo) {
		String updateBoxModelSQL = "UPDATE box_model "
								 + "SET deposit = ?, rentYear = ?, rentMonth = ?, rentDay = ?, "
								     + "boxLength = ?, boxWidth = ?, boxHeight = ? "
								 + "WHERE boxModel = ? ";
		int count = jdbcTemplate.update(updateBoxModelSQL, 
				new Object[] {boxModelPo.getDeposit(), 
							  boxModelPo.getRentYear(), 
							  boxModelPo.getRentMonth(), 
							  boxModelPo.getRentDay(), 
							  boxModelPo.getBoxLength(), 
							  boxModelPo.getBoxWidth(), 
							  boxModelPo.getBoxHeight(), 
							  boxModelPo.getBoxModel()}, 
				new int[] {Types.FLOAT, Types.FLOAT, Types.FLOAT, Types.FLOAT, 
						   Types.FLOAT, Types.FLOAT, Types.FLOAT, Types.VARCHAR});
		return count == 1 ? true : false;
	}

}
