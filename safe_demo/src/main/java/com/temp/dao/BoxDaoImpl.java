package com.temp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.temp.po.BoxModelResumePo;
import com.temp.po.BoxModelPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxFullInfoVo;
import com.temp.vo.BoxModelResumeVo;
import com.temp.vo.BoxModelVo;
import com.temp.vo.BoxVo;

@Repository
public class BoxDaoImpl implements BoxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoxVo> getAllBoxsByAccountId(String accountId, AccountType accountType) {
		List<BoxVo> boxVos = null;
		String queryBoxesSQL = "";
		if (AccountType.SINGLE.equals(accountType)) {
			// Card ��Ϣ�󶨵� Box ����
			queryBoxesSQL = "SELECT box.boxId, "
								 + "box.boxModel, "
								 + "box.keyNo, "
					             + "cardtemp.cardNo, "
					             + "cardtemp.cardRfid, "
					             + "cardtemp.cardType, "
					             + "cardtemp.cardStatus, "
					             + "rent.deposit, "
					             + "rent.actualRent, "
					             + "rent.endDate " 
					      + "FROM rent, box, (SELECT card.cardNo, "
					      						  + "card.cardRfid, "
					      						  + "card.cardType, "
					                              + "card.cardStatus, "
					                              + "card.accountId "
					      				   + "FROM card "
					      				   + "WHERE card.accountId = ?) AS cardtemp "
					      + "WHERE rent.boxId = box.boxId "
					        + "AND rent.accountId = cardtemp.accountId "
					        + "AND rent.accountId = ?";
			
			boxVos = jdbcTemplate.query(queryBoxesSQL, 
					new Object[] {accountId, accountId}, 
					new int[] {Types.VARCHAR, Types.VARCHAR}, 
					new RowMapper<BoxVo>() {

						@Override
						public BoxVo mapRow(ResultSet rs, int arg1) throws SQLException {
							BoxVo boxVo = new BoxVo();
							
							boxVo.setBoxId(rs.getInt("boxId"));
							boxVo.setBoxModel(rs.getString("boxModel"));
							boxVo.setKeyNo(rs.getString("keyNo"));
							boxVo.setCardNo(rs.getString("cardNo"));
							boxVo.setCardRfid(rs.getString("cardRfid"));
							boxVo.setCardType(rs.getInt("cardType"));
							boxVo.setCardStatus(rs.getInt("cardStatus"));
							boxVo.setDeposit(rs.getFloat("deposit"));
							boxVo.setActualRent(rs.getFloat("actualRent"));
							boxVo.setEndDate(new java.util.Date(rs.getDate("endDate").getTime()));
							
							return boxVo;
						}
					});
		} else if (AccountType.UION.equals(accountType)) {
			// Card ��Ϣ�󶨵� Customer ����
			queryBoxesSQL = "SELECT box.boxId, "
								 + "box.boxModel, "
								 + "box.keyNo, "
					             + "rent.deposit, "
					             + "rent.actualRent, "
					             + "rent.endDate "
					      + "FROM rent, box " 
					      + "WHERE rent.boxId = box.boxId "
					        + "AND rent.accountId = ? ";
			boxVos = jdbcTemplate.query(queryBoxesSQL, 
					new Object[] {accountId}, 
					new int[] {Types.VARCHAR}, 
					new RowMapper<BoxVo>() {

						@Override
						public BoxVo mapRow(ResultSet rs, int arg1) throws SQLException {
							BoxVo boxVo = new BoxVo();
							
							boxVo.setBoxId(rs.getInt("boxId"));
							boxVo.setBoxModel(rs.getString("boxModel"));
							boxVo.setKeyNo(rs.getString("keyNo"));
							boxVo.setDeposit(rs.getFloat("deposit"));
							boxVo.setActualRent(rs.getFloat("actualRent"));
							boxVo.setEndDate(new java.util.Date(rs.getDate("endDate").getTime()));
							
							return boxVo;
						}
					});
		}		
		return boxVos;
	}

	@Override
	public boolean setBoxCardRelationship(long boxId, String cardRfid) {
		final String insertBoxCardRelationshipSQL = 
				"INSERT INTO box_card_relationship(cardRfid, boxId) VALUES (?, ?)";
		
		int count = jdbcTemplate.update(insertBoxCardRelationshipSQL, 
				new Object[] {cardRfid, boxId}, 
				new int[] {Types.VARCHAR, Types.BIGINT});
		
		return count == 1 ? true : false;
	}

	@Override
	public boolean setBoxStatusChangeDetails(long boxId, BoxStatus boxStatusFuture, String reason) {
		boolean isSucceed = false;
		int modifyRows = 0;
		int insertRows = 0;
		try {
			String queryBoxStatusAndRentIdSQL = "SELECT status, rentId FROM box WHERE boxId = ?";
			Map<String, Object> statusAndRentId = jdbcTemplate.queryForMap(queryBoxStatusAndRentIdSQL, 
					new Object[] {boxId}, new int[] {Types.BIGINT});
			
			String modifyBoxStatusSQL = "UPDATE box SET status = ? WHERE boxId = ?";		
			modifyRows = jdbcTemplate.update(modifyBoxStatusSQL, boxStatusFuture.getValue(), boxId);
			
			String insertTalbeBoxStatusChangeSQL = 
					"INSERT INTO box_status_change(boxId, rentId, statusChangeDateTime, statusBefore, statusCurrent, changeReason)" +  
					"VALUES(?, ?, NOW(), ?, ?, ?)";
			insertRows = jdbcTemplate.update(insertTalbeBoxStatusChangeSQL, 
					new Object[] {
							boxId, 
							statusAndRentId.get("rentId"), 
							statusAndRentId.get("status"),
							boxStatusFuture.getValue(), 
							reason
							},
					new int[] {Types.BIGINT, Types.BIGINT, Types.INTEGER, Types.INTEGER, Types.VARCHAR});
		} catch (Exception e) {
			e.printStackTrace();
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
	public Map<String, Object> getBoxKeyDetails(long boxId) {
		// Map<String, Object> = {<"newKeyNo", ***>, <"newBoxKeyFee", ***>, <"newBoxRentDay", ***>}
		Map<String, Object> retInfo = null;
		
		String queryKeyFeeAndRentDaySQL = 
				"SELECT box.keyNo AS newKeyNo, `key`.keyFee AS newBoxKeyFee, box_model.rentDay AS newBoxRentDay "
			  + "FROM box, `key`, box_model "
			  + "WHERE box.keyNo = `key`.keyNo "
				+ "AND box.boxModel = box_model.boxModel "
				+ "AND box.boxId = ? ";
		try {
			retInfo = jdbcTemplate.queryForMap(queryKeyFeeAndRentDaySQL, boxId);
		} catch (EmptyResultDataAccessException e) {
			retInfo = null;
		}		
		return retInfo;
	}
	
	@Override
	public boolean modifyBoxCardRelationship(long oldBoxId, long newBoxId) {
		String modifySQL = "UPDATE box_card_relationship SET boxId = ? WHERE boxId = ? ";
		int count = jdbcTemplate.update(modifySQL, newBoxId, oldBoxId);
		return count > 0 ? true : false;
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
		String insertBoxModelResumeSQL = "INSERT INTO box_model(boxModel, boxModelNo, remark) "
				+ "VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE boxModelNo = ?, remark= ? ";
				//"INSERT INTO box_model(boxModel, boxModelNo, remark) VALUES(?, ?, ?) ";
		int count = jdbcTemplate.update(insertBoxModelResumeSQL, 
				new Object[] {boxModelResumePo.getBoxModel(), 
							  boxModelResumePo.getBoxModelNo(), 
							  boxModelResumePo.getRemark(),
							  boxModelResumePo.getBoxModelNo(), 
							  boxModelResumePo.getRemark()}, 
				new int[] {Types.VARCHAR, Types.INTEGER, Types.VARCHAR, 
						   Types.INTEGER, Types.VARCHAR});
		return count >= 1 ? true : false;
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

	@Override
	public boolean setBoxNewKey(long boxId, long keyNo) {
		// Hand out key of the box, always keep the rent.keySum = 2, 
		// so it doesn`t need to write a new keyNo in Database.
		// then, Log this kinds of Action, 
		// At last, everything is OK.
		return true;
	}

	@Override
	public List<BoxFullInfoVo> getBoxsByCardRfid(String cardRfid) {
		String queryBoxSQL = "SELECT box.boxId, boxNo, lockId, `status`, remark, sideNo, rowNo, columnNo, "
								  + "rowPosX, columnPosX, boxModel, bankId, rentId, keyNo "
						   + "FROM box_card_relationship, box "
						   + "WHERE box_card_relationship.boxId = box.boxId AND box_card_relationship.cardRfid = ? ";
		List<BoxFullInfoVo> boxFullInfoVos = jdbcTemplate.query(queryBoxSQL, 
				new Object[] {cardRfid}, new int[] {Types.VARCHAR}, 
				new RowMapper<BoxFullInfoVo>() {

					@Override
					public BoxFullInfoVo mapRow(ResultSet rs, int arg1) throws SQLException {
						BoxFullInfoVo boxFullInfoVo = new BoxFullInfoVo();
						
						boxFullInfoVo.setBoxId(rs.getLong("boxId"));
						boxFullInfoVo.setBoxNo(rs.getLong("boxNo"));
						boxFullInfoVo.setLockId(rs.getString("status"));
						boxFullInfoVo.setRemark(rs.getString("remark"));
						boxFullInfoVo.setSideNo(rs.getInt("sideNo"));
						boxFullInfoVo.setRowNo(rs.getInt("rowNo"));
						boxFullInfoVo.setColumnNo(rs.getInt("columnNo"));
						boxFullInfoVo.setRowPosX(rs.getString("rowPosX"));
						boxFullInfoVo.setColumnPosX(rs.getString("columnPosX"));
						boxFullInfoVo.setBoxModel(rs.getString("boxModel"));
						boxFullInfoVo.setBankId(rs.getLong("bankId"));
						boxFullInfoVo.setRentId(rs.getLong("rentId"));
						boxFullInfoVo.setKeyNo(rs.getLong("keyNo"));
						
						return boxFullInfoVo;
					}
				});
		return boxFullInfoVos;
	}

	@Override
	public boolean setBoxStatus(long boxId, int futureBoxStatus) {
		String setBoxStatusSQL = "UPDATE box SET status = ? WHERE boxId = ? ";
		int count = jdbcTemplate.update(setBoxStatusSQL, 
				new Object[] {futureBoxStatus, boxId}, 
				new int[] {Types.INTEGER, Types.BIGINT});
		return count == 1 ? true : false;
	}

}
