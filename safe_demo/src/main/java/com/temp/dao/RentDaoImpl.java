package com.temp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
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
				+ "keySum, rentType, rentTime, startDate, endDate, deposit, rent, rentDiscount, actualRent, "
				+ "paymentType, feeTotal, isRelet, boxId, accountId) "
				+ "VALUES(0, ?, ?, ?, ?, 2, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, ?)";
		
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
							  rent.getRentDiscount(), 
							  rent.getActualRent(),
							  rent.getPaymentType(), 
							  rent.getFeeTotal(),
							  rent.getBoxId(),
							  rent.getAccountId()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
						   Types.INTEGER, Types.INTEGER, Types.DATE,    Types.DATE, 
						   Types.DECIMAL, Types.DECIMAL, Types.DECIMAL, Types.DECIMAL, 
						   Types.INTEGER, Types.DECIMAL, Types.BIGINT,  Types.VARCHAR});
		
		return count == 1 ? true : false;
	}

	@Override
	public Map<String, Object> getBoxInfo4CountOverdueFineInfo(int boxId) {
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
		String queryRentInfoSQL = "SELECT id, isRelet, keySum, startDate, endDate, actualRent "
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
		Date endDate = jdbcTemplate.queryForObject(queryEndDateSQL, Date.class, boxId);
		// ��������Ϊʱ = rent.endDate
		// ��������Ϊʱ = Max(relet.endDate)
		retBoxInfo.put("endDateAfterRelet", endDate);
		
		return retBoxInfo;
	}

	@Override
	public boolean setReletInfo(ReletPo reletPo) {
		String insertReletSQL = "INSERT INTO relet (id, reletTime, startDate, endDate, "
				                                 + "overdueFine, overdueRent, rent, "
				                                 + "paymentType, feeTotal, reletDate) " 
				              + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE()) ";
		int count = jdbcTemplate.update(insertReletSQL, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				int index = 1;
				
				pst.setInt(index++, reletPo.getId());
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
	public Map<String, Object> getUnrentInfo(int boxId) {
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
		
		String queryKeyFeeSQL = "SELECT keyFee FROM box, key "
							  + "WHERE box.keyId = key.keyId AND box.boxId = ? ";
		float keyFee = jdbcTemplate.query(queryKeyFeeSQL, new Object[] {boxId}, 
				new ResultSetExtractor<Float> () {

			@Override
			public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.getFloat("keyFee");
			}
			
		});
		unrentInfo.put("keyFee", keyFee);
		
		return unrentInfo;
	}

	@Override
	public boolean setOffleaseInfo(OffleasePo offleasePo) {
		String insertOffleaseSQL = "INSERT INTO offlease VALUES (?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		int count = jdbcTemplate.update(insertOffleaseSQL, 
				new Object[] {offleasePo.getId(), offleasePo.getReturnDeposit(), 
						offleasePo.getReturnRent(), offleasePo.getOverdueRent(), 
						offleasePo.getOverdueFine(), offleasePo.getUnrecycleKeySum(), 
						offleasePo.getKeyFee(), offleasePo.getPaymentType(), 
						offleasePo.getFeeTotal()}, 
				new int[] {Types.INTEGER, Types.FLOAT,   Types.FLOAT, 
						   Types.FLOAT,   Types.FLOAT,   Types.INTEGER, 
						   Types.FLOAT,   Types.INTEGER, Types.FLOAT});
		
		return count == 1 ? true : false;
	}
	
	private Map<String, Object> getOverdueFineStrategyAndRentDay(int boxId) {
		String queryOverdueFineStrategyAndRentDaySQL = 
				"SELECT box.boxId, box_model.rentDay, box_model.overdueFineStrategy "
			  + "FROM box, box_model "
			  + "WHERE box.boxModel = box_model.boxModel AND boxId = ?";
		Map<String, Object> ofsAndRd = jdbcTemplate.queryForMap(queryOverdueFineStrategyAndRentDaySQL, 
				new Object[] {boxId}, new int[] {Types.INTEGER});
		return ofsAndRd;
	}

	@Override
	public boolean setChangeBoxInfo(int oldBoxId, int newBoxId, float amountDifference) {
		String changeBoxSQL = "UPDATE rent SET boxId = ?, feeTotal = feeTotal + ? WHERE boxId = ? ";
		int count = jdbcTemplate.update(changeBoxSQL, 
				new Object[] {newBoxId, amountDifference, oldBoxId}, 
				new int[] {Types.INTEGER, Types.FLOAT, Types.INTEGER});
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
				new int[] {Types.INTEGER, 
						   Types.INTEGER, 
						   Types.FLOAT, 
						   Types.FLOAT, 
						   Types.INTEGER, 
						   Types.FLOAT, 
						   Types.INTEGER});
		return count == 1 ? true : false;
	}

}
