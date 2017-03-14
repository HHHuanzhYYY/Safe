package com.temp.dao;

import java.util.List;

import com.temp.util.AccountType;
import com.temp.vo.BoxVo;

public interface BoxDao {

	/**
	 * getAllBoxsByAccountId.
	 * 
	 * @param accountId
	 * @param accountType
	 * @return List<BoxVo>
	 */
	List<BoxVo> getAllBoxsByAccountId(final int accountId, final AccountType accountType);
	
	/**
	 * setBox.
	 * 
	 * @param box
	 * @return boolean
	 */
	boolean setBox(BoxVo box);
	
	/**
	 * setBoxCardRelationship.
	 * 
	 * @param boxId
	 * @param cardRfid
	 * @return boolean
	 */
	boolean setBoxCardRelationship(int boxId, String cardRfid);
	
}
