package com.temp.dao;

import java.util.List;
import java.util.Map;

import com.temp.po.BoxModelResumePo;
import com.temp.po.BoxModelPo;
import com.temp.util.AccountType;
import com.temp.util.BoxStatus;
import com.temp.vo.BoxFullInfoVo;
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
	List<BoxVo> getAllBoxsByAccountId(final String accountId, final AccountType accountType);
	
	/**
	 * setBoxCardRelationship.
	 * 
	 * @param boxId
	 * @param cardRfid
	 * @return boolean
	 */
	boolean setBoxCardRelationship(long boxId, String cardRfid);
	
	/**
	 * setBoxStatusChangeDetails.
	 * 
	 * @param boxId
	 * @param boxStatusFuture 
	 * @param reason
	 * @return boolean
	 */
	boolean setBoxStatusChangeDetails(long boxId, BoxStatus boxStatusFuture, String reason);
	
	/**
	 * getBoxKeyDetails.
	 * 
	 * @param boxId
	 * @return Map<String, Object>
	 */
	Map<String, Object> getBoxKeyDetails(long boxId);
	
	/**
	 * modifyBoxCardRelationship.
	 * 
	 * @param oldBoxId
	 * @param newBoxId
	 * @return
	 */
	boolean modifyBoxCardRelationship(long oldBoxId, long newBoxId);
	
	/**
	 * setBoxNewKey.
	 * 
	 * @param boxId
	 * @param keyNo
	 * @return boolean
	 */
	boolean setBoxNewKey(long boxId, long keyNo);
	
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
	
	/**
	 * getBoxsByCardRfid.
	 * 
	 * @param cardRfid
	 * @return List<BoxFullInfoVo>
	 */
	List<BoxFullInfoVo> getBoxsByCardRfid(String cardRfid);
	
	/**
	 * setBoxStatus.
	 * 
	 * @param boxId
	 * @param futureBoxStatus
	 * @return boolean
	 */
	boolean setBoxStatus(final long boxId, final int futureBoxStatus);
	
	/**
	 * getAllFreeBox.
	 * 
	 * @return
	 */
	List<Long> getAllFreeBox();
	
	/**
	 * getBoxInfoByBoxId.
	 * 
	 * @param boxId
	 * @return
	 */
	Map<String, Object> getBoxInfoByBoxId(final long boxId);
}
