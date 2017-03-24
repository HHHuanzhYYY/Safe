package com.temp.dao;

import com.temp.po.CardPo;
import com.temp.po.ReportLossPo;

public interface CardDao {

	/**
	 * setCard.
	 * 
	 * @param card
	 * @return boolean
	 */
	boolean setCard(CardPo card);
	
	/**
	 * modifyCardPwd.
	 * 
	 * @param cardRfid
	 * @param pwd
	 * @return boolean
	 */
	boolean changeCardPwd(String cardRfid, String pwd);
	
	/**
	 * changeCard.
	 * 
	 * @param reportLossPo
	 * @return boolean
	 */
	boolean changeCard(ReportLossPo reportLossPo);
}
