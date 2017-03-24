package com.temp.service;

public interface SystemConfigService {

	/**
	 * listAllMessages.
	 * 
	 * @return String
	 */
	String listAllMessages();
	
	/**
	 * listBankBranchEmployees.
	 * 
	 * @param rawData
	 * @return String
	 */
	String listBankBranchEmployees(final String rawData);
	
	/**
	 * setMessageDetails.
	 * 
	 * @return String
	 */
	String setMessageDetails(final String rawData);
	
	/**
	 * deleteMessage.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteMessage(final String rawData);
	
	/**
	 * listBankBranches.
	 * 
	 * @return String
	 */
	String listBankBranches();
	
	/**
	 * setBankDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setBankDetails(final String rawData);
	
	/**
	 * deleteBank.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteBank(final String rawData);
	
	/**
	 * listAllSubjects.
	 * 
	 * @param rawData
	 * @return String
	 */
	String listAllSubjects();
	
	/**
	 * setSubjectDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setSubjectDetails(final String rawData);
	
	/**
	 * deleteSubject.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteSubject(final String rawData);
	
	/**
	 * listAllFeeTypes. 
	 * @param rawData
	 * @return String
	 */
	String listAllFeeTypes();
	
	/**
	 * setFeeTypeDetails.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setFeeTypeDetails(final String rawData);
	
	/**
	 * operateFeeType.
	 * 
	 * @param rawData
	 * @return String
	 */
	String operateFeeType(final String rawData);
	
	/**
	 * deleteFeeType.
	 * 
	 * @param rawData
	 * @return String
	 */
	String deleteFeeType(final String rawData);
}
