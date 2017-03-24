package com.temp.dao;

import java.util.List;
import java.util.Map;

import com.temp.po.BoxModelResumePo;
import com.temp.po.BoxModelPo;
import com.temp.po.ChangeBoxPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxModelResumeVo;
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
	 * getAllBoxModelResumes.
	 * 
	 * @return List<SubjectVo>
	 */
	List<BoxModelResumeVo> getAllBoxModelResumes();
	
	/**
	 * setAllBoxModelResumes.
	 * 
	 * @param boxDetailsPo
	 * @return boolean
	 */
	boolean setAllBoxModelResumes(BoxModelResumePo boxDetailsPo);
	
	/**
	 * deleteBox.
	 * 
	 * @param boxIds
	 * @return boolean
	 */
	boolean deleteBoxModel(List<String> boxModels);
	
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
	
}
