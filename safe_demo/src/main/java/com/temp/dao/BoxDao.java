package com.temp.dao;

import java.util.List;
import java.util.Map;

import com.temp.po.BoxDetailsPo;
import com.temp.po.BoxModelPo;
import com.temp.po.ChangeBoxPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxDetailsVo;
import com.temp.vo.BoxModelVo;
import com.temp.vo.BoxVo;

public interface BoxDao {

	/**
	 * getAllBoxsByAccountId.
	 * 
	 * @param accountId
	 * @param accountType
	 * @return List<BoxVo>
	 */
	List<BoxVo> getAllBoxsByAccountId(final long accountId, final AccountType accountType);
	
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
	
	/**
	 * setBoxStatusChangeDetails.
	 * 
	 * @param boxId
	 * @param boxStatusFuture 
	 * @param reason
	 * @return boolean
	 */
	boolean setBoxStatusChangeDetails(int boxId, BoxStatus boxStatusFuture, String reason);
	
	/**
	 * getBoxKeyDetails.
	 * 
	 * @param boxId
	 * @return Map<String, Object>
	 */
	Map<String, Object> getBoxKeyDetails(int boxId);
	
	/**
	 * setChangeBoxDetails.
	 * 
	 * @param changeBoxPo
	 * @return boolean
	 */
	boolean setChangeBoxDetails(ChangeBoxPo changeBoxPo);
	
	/**
	 * modifyBoxCardRelationship.
	 * 
	 * @param oldBoxId
	 * @param newBoxId
	 * @return
	 */
	boolean modifyBoxCardRelationship(int oldBoxId, int newBoxId);
	
	/**
	 * setBoxNewKey.
	 * 
	 * @param boxId
	 * @param keyId
	 * @return boolean
	 */
	boolean setBoxNewKey(int boxId, String keyId);
	
	/**
	 * getAllSubjects.
	 * 
	 * @return List<SubjectVo>
	 */
	List<BoxDetailsVo> getAllBoxs();
	
	/**
	 * setBoxDetails.
	 * 
	 * @param boxDetailsPo
	 * @return boolean
	 */
	boolean setBoxDetails(BoxDetailsPo boxDetailsPo);
	
	/**
	 * deleteBox.
	 * 
	 * @param boxIds
	 * @return boolean
	 */
	boolean deleteBox(List<Integer> boxIds);
	
	/**
	 * getAllBoxModels.
	 * 
	 * @return List<BoxModelVo>
	 */
	List<BoxModelVo> getAllBoxModels();
	
	/**
	 * setBoxModelDetails.
	 * 
	 * @param boxModelPo
	 * @return boolean
	 */
	boolean setBoxModelDetails(BoxModelPo boxModelPo);
	
	/**
	 * deleteBox.
	 * 
	 * @param boxIds
	 * @return boolean
	 */
	boolean deleteBoxModel(List<String> boxModels);
	
	
	
}
