package com.temp.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.temp.po.CardPo;
import com.temp.po.ReportLossPo;

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
	public boolean changeCardPwd(String cardRfid, String pwd) {
		String modifyCardPwdSQL = "UPDATE card SET password = ? WHERE cardRfid = ? ";	
		int count = jdbcTemplate.update(modifyCardPwdSQL, 
				new Object[] {pwd, cardRfid}, 
				new int[] {Types.VARCHAR, Types.VARCHAR});		
		return count == 1 ? true : false;
	}

	@Override
	public boolean changeCard(ReportLossPo reportLossPo) {
		// Query Old Card Info.
		String queryOldCardInfoSQL = "SELECT card.customerId, "
										  + "card.accountId, "
										  + "card.cardType "
								   + "FROM card "
								   + "WHERE card.cardRfid = ? ";
		final Map<String, Object> oldCardInfo = jdbcTemplate.queryForMap(queryOldCardInfoSQL, 
				new Object[] {reportLossPo.getCardRfid()}, 
				new int[] {Types.VARCHAR});
		
		// Insert into the relationship between New-Card and Box in Table "box_card_relationship".
		String insertBoxCardRelationshipSQL = "INSERT INTO box_card_relationship(boxId, cardRfid) VALUES(?, ?) ";
		int count = jdbcTemplate.update(insertBoxCardRelationshipSQL, 
				new Object[] {reportLossPo.getBoxId(), reportLossPo.getNewCardRfid()}, 
				new int[] {Types.BIGINT, Types.VARCHAR});
		
		// Insert New Card into Table "card".
		String insertCardInfoSQL = "INSERT INTO card VALUES(?, ?, ?, 0, ?, NULL, NULL, 1, ?, ?) ";
		int count1 = jdbcTemplate.update(insertCardInfoSQL, 
				new Object[] {reportLossPo.getNewCardRfid(), 
							  reportLossPo.getNewCardNo(), 
							  oldCardInfo.get("cardType"),
							  reportLossPo.getNewCardPassword(),
							  oldCardInfo.get("accountId"), 
							  oldCardInfo.get("customerId")}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, 
						   Types.VARCHAR, Types.BIGINT, Types.BIGINT});
		
		// Delete the relationship between Old-Card and Box in Table "box_card_relationship".
		String deleteBoxCardRelationshipSQL = "DELETE FROM box_card_relationship "
											+ "WHERE cardRfid = ? AND boxId = ? ";
		int count2 = jdbcTemplate.update(deleteBoxCardRelationshipSQL, 
				new Object[] {reportLossPo.getCardRfid(), reportLossPo.getBoxId()}, 
				new int[] {Types.BIGINT, Types.BIGINT});
		
		// Delete Old Card in Table "card" when there is no other box corresponding to the Card.
		String deleteCardInfoSQL = "DELETE FROM card "
		+ "USING card, (SELECT ? as cardRfid, COUNT(relationshipId) AS sum "
					 + "FROM box_card_relationship "
					 + "WHERE cardRfid = ?) AS temp "
		+ "WHERE card.cardRfid = temp.cardRfid AND temp.sum = 0 ";
		jdbcTemplate.update(deleteCardInfoSQL, 
				new Object[] {reportLossPo.getCardRfid(), reportLossPo.getCardRfid()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR});
		
		return ((count >= 1) && (count1 >= 1) && (count2 >= 1)) ? true : false;
	}

}
