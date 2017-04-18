package com.temp.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.temp.po.ChangeBoxPo;
import com.temp.po.OffleasePo;
import com.temp.po.ReletPo;
import com.temp.po.RentPo;

@Repository
public class RentDaoImpl implements RentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean setRent(RentPo rent) {
		String insertRentSQL = "INSERT INTO rent(rentStatus, leaseNo, leaseRemark, voucherNo, voucherRemark, "
				+ "keySum, rentType, rentTime, startDate, endDate, deposit, rent, rentDiscountRate, actualRent, "
				+ "paymentType, feeTotal, isRelet, isChangeBox, operator, boxId, accountId) "
				+ "VALUES(0, ?, ?, ?, ?, 2, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, ?, ?, ?)";
		
		int count = jdbcTemplate.update(insertRentSQL, 
				new Object[] {rent.getLeaseNo(), 
							  rent.getLeaseRemark(),
							  rent.getVoucherNo(),
							  rent.getVoucherRemark(),
							  rent.getRentType(), 
							  rent.getRentTime(), 
							  rent.getStartDate(), 
							  rent.getEndDate(), 
							  rent.getDeposit(), 
							  rent.getRent(),
							  rent.getRentDiscountRate(), 
							  rent.getActualRent(),
							  rent.getPaymentType(), 
							  rent.getFeeTotal(),
							  rent.getOperator(),
							  rent.getBoxId(),
							  rent.getAccountId()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
						   Types.INTEGER, Types.INTEGER, Types.DATE,    Types.DATE, 
						   Types.DECIMAL, Types.DECIMAL, Types.DECIMAL, Types.DECIMAL, 
						   Types.INTEGER, Types.DECIMAL, Types.VARCHAR, Types.BIGINT,  
						   Types.VARCHAR});
		
		return count == 1 ? true : false;
	}

	@Override
	public Map<String, Object> getBoxInfo4CountOverdueFineInfo(long boxId) {
		// Map<String, Object> = {<"id",***>
		//                        <"overdueFineStrategy",***>, 
		//                        <"rentDay",***>, 
		//                        <"startDate",***>,
		//                        <"endDate",***>,
		//						  <"endDateAfterRelet",***>
		//                        <"actualRent",***>,
		//                        <"keySum",***>}
		Map<String, Object> retBoxInfo = new HashMap<>();
		
		// Get: overdueFineStrategy && rentDay
		Map<String, Object> ofsAndRd = getOverdueFineStrategyAndRentDay(boxId);
		for (Entry<String, Object> entry : ofsAndRd.entrySet()) {
			retBoxInfo.put(entry.getKey(), entry.getValue());
		}
		
		// Get: startDate && endDate && actualRent && id && keySum
		String queryRentInfoSQL = "SELECT rentId, isRelet, keySum, startDate, endDate, actualRent "
							    + "FROM rent WHERE boxId = ? ";		
		Map<String, Object> rentInfo = jdbcTemplate.queryForMap(queryRentInfoSQL, boxId);
		for (Entry<String, Object> entry : rentInfo.entrySet()) {
			retBoxInfo.put(entry.getKey(), entry.getValue());
		}
		
		// Get: endDateAfterRelet
		// �Ȳ鿴�Ƿ���������Ϊ.
		String queryEndDateSQL = null;
		if ((Integer)rentInfo.get("isRelet") == 0) {
			queryEndDateSQL = "SELECT endDate FROM rent WHERE rent.boxId = ? ";
		} else if ((Integer)rentInfo.get("isRelet") == 1) {
			// ��Լ������һ��.
			queryEndDateSQL = "SELECT MAX(relet.endDate) AS endDate "
					        + "FROM rent, relet "
					        + "WHERE rent.id = relet.id AND rent.boxId = ? ";
		}
		Date endDate = null;
		try {
			endDate = jdbcTemplate.queryForObject(queryEndDateSQL, 
					new Object[] {boxId},
					new int[] {Types.BIGINT},
					Date.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			endDate = null;
		}				
		// ��������Ϊʱ = rent.endDate
		// ��������Ϊʱ = Max(relet.endDate)
		retBoxInfo.put("endDateAfterRelet", endDate);
		
		return retBoxInfo;
	}

	@Override
	public boolean setReletInfo(ReletPo reletPo) {
		String insertReletSQL = "INSERT INTO relet (reletId, reletTime, startDate, endDate, "
				                                 + "overdueFine, overdueRent, rent, "
				                                 + "paymentType, feeTotal, reletDate) " 
				              + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE()) ";
		int count = jdbcTemplate.update(insertReletSQL, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				int index = 1;
				
				pst.setLong(index++, reletPo.getId());
				pst.setInt(index++, reletPo.getRentTime());
				pst.setDate(index++, new java.sql.Date(reletPo.getStartDate().getTime()));
				pst.setDate(index++, new java.sql.Date(reletPo.getEndDate().getTime()));
				pst.setFloat(index++, reletPo.getOverdueFine());
				pst.setFloat(index++, reletPo.getOverdueRent());
				pst.setFloat(index++, reletPo.getRent());
				pst.setInt(index++, reletPo.getPaymentType());
				pst.setFloat(index++, reletPo.getFeeTotal());
			}
			
		});
		return count == 1 ? true : false;
	}

	@Override
	public Map<String, Object> getUnrentInfo(long boxId) {
		// Map<String, Object> = {<"id",***>
		//                        <"overdueFineStrategy",***>, 
		//                        <"rentDay",***>, 
		//                        <"startDate",***>,
		//                        <"endDate",***>,
		//						  <"endDateAfterRelet",***>
		//                        <"actualRent",***>,
		//                        <"keySum",***>}
		//  					  <"keyFee",***>}
		Map<String, Object> unrentInfo = getBoxInfo4CountOverdueFineInfo(boxId);
		
		String queryKeyFeeSQL = "SELECT keyFee FROM box, `key` "
							  + "WHERE box.keyNo = `key`.keyNo AND box.boxId = ? ";
		float keyFee = 0f;
		try {
			BigDecimal decimalValue = jdbcTemplate.queryForObject(queryKeyFeeSQL, 
					new Object[] {boxId}, 
					new int[] {Types.BIGINT}, 
					BigDecimal.class);
			if (decimalValue != null) {
				keyFee = decimalValue.floatValue();
			}
		} catch (IncorrectResultSizeDataAccessException e) {
			keyFee = 0f;
		}				
		unrentInfo.put("keyFee", keyFee);
		
		return unrentInfo;
	}

	@Override
	public boolean setOffleaseInfo(OffleasePo offleasePo) {
		String insertOffleaseSQL = "INSERT INTO offlease VALUES (?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		int count = jdbcTemplate.update(insertOffleaseSQL, 
				new Object[] {offleasePo.getRentId(), offleasePo.getReturnDeposit(), 
						offleasePo.getReturnRent(), offleasePo.getOverdueRent(), 
						offleasePo.getOverdueFine(), offleasePo.getUnrecycleKeySum(), 
						offleasePo.getIsCardDestroy(), offleasePo.getKeyFee(), 
						offleasePo.getPaymentType(), offleasePo.getFeeTotal()}, 
				new int[] {Types.BIGINT, Types.FLOAT,   Types.FLOAT, 
						   Types.FLOAT,   Types.FLOAT,   Types.INTEGER, Types.INTEGER, 
						   Types.FLOAT,   Types.INTEGER, Types.FLOAT});
		
		return count == 1 ? true : false;
	}
	
	private Map<String, Object> getOverdueFineStrategyAndRentDay(long boxId) {
		String queryOverdueFineStrategyAndRentDaySQL = 
				"SELECT box.boxId, box_model.rentDay, box_model.overdueFineStrategy "
			  + "FROM box, box_model "
			  + "WHERE box.boxModel = box_model.boxModel AND boxId = ?";
		Map<String, Object> ofsAndRd = null;
		try {
			ofsAndRd = jdbcTemplate.queryForMap(queryOverdueFineStrategyAndRentDaySQL, 
					new Object[] {boxId}, new int[] {Types.INTEGER});
		} catch (EmptyResultDataAccessException e) {
			ofsAndRd = null;
		}
				
		return ofsAndRd;
	}

	@Override
	public boolean setChangeBoxInfo(long oldBoxId, long newBoxId, float amountDifference) {
		String changeBoxSQL = "UPDATE rent SET boxId = ?, feeTotal = feeTotal + ? WHERE boxId = ? ";
		int count = jdbcTemplate.update(changeBoxSQL, 
				new Object[] {newBoxId, amountDifference, oldBoxId}, 
				new int[] {Types.BIGINT, Types.FLOAT, Types.BIGINT});
		return count == 1 ? true : false;
	}

	@Override
	public boolean setChangeBoxLogInfo(ChangeBoxPo changeBoxPo) {
		String insertChangeBoxLogSQL = 
				"INSERT INTO changebox_log(changeboxDate, oldBoxId, newBoxId, amountDifference, "
				                        + "keyFee, paymentType, feeTotal, rentId) "
			  + "VALUES(NOW(), ?, ?, ?, ?, ?, ?, "
			        + "(SELECT CONCAT(rentId) FROM rent WHERE boxId = ?)) ";
		int count = jdbcTemplate.update(insertChangeBoxLogSQL, 
				new Object[] {changeBoxPo.getOldBoxId(), 
							  changeBoxPo.getNewBoxId(), 
							  changeBoxPo.getAmountDifference(),
							  changeBoxPo.getKeyFee(), 
							  changeBoxPo.getPaymentType(), 
							  changeBoxPo.getFeeTotal(), 
							  changeBoxPo.getOldBoxId()}, 
				new int[] {Types.BIGINT, 
						   Types.BIGINT, 
						   Types.FLOAT, 
						   Types.FLOAT, 
						   Types.INTEGER, 
						   Types.FLOAT, 
						   Types.BIGINT});
		return count == 1 ? true : false;
	}

}
