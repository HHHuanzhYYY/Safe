package com.temp.service;

import com.temp.util.BoxStatus;

public interface BoxManageService {

	/**
	 * changeBox.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String changeBox(final String rawData);
	
	/**
	 * modifyBoxStatus.
	 * 
	 * @param rawData String from HttpRequest
	 * @param boxStatus
	 * @return JSON String Contains Account Info.
	 */
	String modifyBoxStatus(final String rawData, final BoxStatus boxStatus);
	
	/**
	 * listAllBoxs.
	 * 
	 * @return String
	 */
	String listAllBoxs();
	
	/**
	 * setBoxDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setBoxDetails(final String rawData);
	
	/**
	 * deleteBox.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteBox(final String rawData);
	
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
	 * deleteBoxModel.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteBoxModel(final String rawData);
	
}
