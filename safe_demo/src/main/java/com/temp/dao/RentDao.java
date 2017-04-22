package com.temp.dao;

import java.util.Map;

import com.temp.po.ChangeBoxPo;
import com.temp.po.OffleasePo;
import com.temp.po.ReletPo;
import com.temp.po.RentPo;

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
	 * @return Map<String, Object> = {<"overdueFineStrategy",***>, <"rentDay",***>, <"endDate",***>}
	 */
	Map<String, Object> getBoxInfo4CountOverdueFineInfo(long boxId);
	
	/**
	 * setReletInfo.
	 * 
	 * @param reletInfo
	 * @return boolean
	 */
	boolean setReletInfo(ReletPo reletPo);
	
	/**
	 * getUnrentInfo.
	 * 
	 * @param boxId
	 * @return Map<String, Object>
	 */
	Map<String, Object> getUnrentInfo(final long boxId);
	
	/**
	 * setUnrentInfo.
	 * 
	 * @param offleasePo
	 * @return boolean
	 */
	boolean setOffleaseInfo(final OffleasePo offleasePo);
	
	/**
	 * setChangeBoxInfo.
	 * 
	 * @param oldBoxId
	 * @param newBoxId
	 * @param amountDifference
	 * @return boolean
	 */
	boolean setChangeBoxInfo(long oldBoxId, long newBoxId, float amountDifference);
	
	/**
	 * setChangeBoxLogInfo.
	 * 
	 * @param changeBoxPo
	 * @return boolean
	 */
	boolean setChangeBoxLogInfo(ChangeBoxPo changeBoxPo);
	
	/**
	 * getReportLossType.
	 * 
	 * @param boxId
	 * @return
	 */
	Map<String, Object> getReportLossType(final long boxId);
	
	/**
	 * getRentAndDeposit.
	 * 
	 * @param boxId
	 * @return Map<String, Object>
	 */
	Map<String, Object> getRentAndDeposit(final long boxId);
}
