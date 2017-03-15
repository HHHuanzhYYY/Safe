package com.temp.dao;

import java.util.Map;

import com.temp.po.RentPo;
import com.temp.vo.UnrentVo;

public interface RentDao {

	/**
	 * setRent.
	 * 
	 * @param rent
	 * @return boolean
	 */
	boolean setRent(RentPo rent);
	
	/**
	 * getBoxInfo4CountOverdueFineInfo.
	 * 
	 * @param boxId
	 * @return Map<String, Object> = {<"unitRent",***>, <"overdueFineStrategy",***>, <"rentDay",**>, <"endDate">,***}
	 */
	Map<String, Object> getBoxInfo4CountOverdueFineInfo(int boxId);
	
	/**
	 * setReletInfo.
	 * 
	 * @param reletInfo
	 * @return boolean
	 */
	boolean setReletInfo(Map<String, Object> reletInfo);
	
	/**
	 * getUnrentInfo.
	 * 
	 * @param boxId
	 * @return UnrentVo
	 */
	UnrentVo getUnrentInfo(final int boxId);
}
