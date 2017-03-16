package com.temp.dao;

import com.temp.po.CardPo;

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
	boolean modifyCardPwd(String cardRfid, String pwd);
}
