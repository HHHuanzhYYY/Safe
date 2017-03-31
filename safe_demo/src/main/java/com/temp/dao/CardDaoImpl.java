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
		// ���Ҿɵ� Card.
		String queryOldCardInfoSQL = "SELECT card.cardRfid, "
										  + "card.accountId, "
										  + "card.cardType, "
										  + "box_card_relationship.relationshipId, "
										  + "customer.customerId " 
								   + "FROM customer, card, box_card_relationship "
								   + "WHERE customer.customerId = card.customerId "
								     + "AND certificateType = ? "
								     + "AND certificateNo = ? "
								     + "AND card.cardRfid = box_card_relationship.cardRfid "
								     + "AND boxId = ? ";
		final Map<String, Object> oldCardInfo = jdbcTemplate.queryForMap(queryOldCardInfoSQL, 
				new Object[] {reportLossPo.getCertificateType(), 
							  reportLossPo.getCertificateNo(), 
							  reportLossPo.getBoxId()}, 
				new int[] {Types.INTEGER, Types.VARCHAR, Types.INTEGER});
		
		// ���� Box �� Card ����ϵ
		String insertBoxCardRelationshipSQL = "INSERT INTO box_card_relationship(boxId, cardRfid) VALUES(?, ?) ";
		int count = jdbcTemplate.update(insertBoxCardRelationshipSQL, 
				new Object[] {reportLossPo.getBoxId(), reportLossPo.getCardRfid()}, 
				new int[] {Types.INTEGER, Types.VARCHAR});
		
		// ������ Card ��Ϣ
		String insertCardInfoSQL = "INSERT INTO card VALUES(?, ?, ?, 0, ?, NULL, NULL, 1, ?, ?) ";
		int count1 = jdbcTemplate.update(insertCardInfoSQL, 
				new Object[] {reportLossPo.getCardRfid(), 
							  reportLossPo.getCardNo(), 
							  oldCardInfo.get("cardType"),
							  reportLossPo.getPassword(),
							  oldCardInfo.get("accountId"), 
							  oldCardInfo.get("customerId")}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, 
						   Types.VARCHAR, Types.INTEGER, Types.INTEGER});
		
		// ɾ�� ��Card �� Box ����ϵ.
		String deleteBoxCardRelationshipSQL = "DELETE FROM box_card_relationship WHERE relationshipId = ? ";
		int count2 = jdbcTemplate.update(deleteBoxCardRelationshipSQL, oldCardInfo.get("relationshipId"));
		
		// ɾ�� ��Card ��Ϣ.
		String deleteCardInfoSQL = "DELETE FROM card WHERE cardRfid = ? ";
		int count3 = jdbcTemplate.update(deleteCardInfoSQL, reportLossPo.getCardRfid());
		
		return ((count == 1) && (count1 == 1) && (count2 == 1) && (count3 == 1)) ? true : false;
	}

}
