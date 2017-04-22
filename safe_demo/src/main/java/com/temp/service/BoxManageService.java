package com.temp.service;

import com.temp.util.BoxStatus;

public interface BoxManageService {
	
	/**
	 * getChangeBoxInfo.
	 * 
	 * @param rawData
	 * @return
	 */
	String getChangeBoxInfo(final String rawData);
	
	/**
	 * getChangeBoxDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String getChangeBoxDetails(final String rawData);

	/**
	 * setChangeBoxDetails.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setChangeBoxDetails(final String rawData);
	
	/**
	 * modifyBoxStatus.
	 * 
	 * @param rawData String from HttpRequest
	 * @param boxStatus
	 * @return JSON String Contains Account Info.
	 */
	String modifyBoxStatus(final String rawData, final BoxStatus boxStatus);
	
	/**
	 * listAllModelResumes.
	 * 
	 * @return String
	 */
	String listAllModelResumes();
	
	/**
	 * setBoxModelResumes.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setBoxModelResumes(final String rawData);
	
	/**
	 * deleteBoxModel.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteBoxModel(final String rawData);
	
	/**
	 * listAllBoxModels.
	 * 
	 * @return
	 */
	String listAllBoxModels();
	
	/**
	 * setBoxModelDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setBoxModelDetails(final String rawData);
	
	/**
	 * listAllFreeBox.
	 * 
	 * @return
	 */
	String listAllFreeBox();
	
	/**
	 * getBoxInfo.
	 * 
	 * @param rawData
	 * @return
	 */
	String getBoxInfo(final String rawData);
	
}
