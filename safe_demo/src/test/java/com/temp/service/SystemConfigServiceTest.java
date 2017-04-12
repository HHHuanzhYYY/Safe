package com.temp.service;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class SystemConfigServiceTest extends ServiceTestBase {
	
	@Autowired  
    private SystemConfigService systemConfigService;
	
	/*@Test
	public void listAllMessages() {
		String retJSON = systemConfigService.listAllMessages();

		//assertEquals(retJSON, "");
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void getBankBranchEmployees() {
		final String rawData = "{\"success\":true,\"message\":null,\"data\":{\"bankId\":101}}";
		String retJSON = systemConfigService.getBankBranchEmployees(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setMessageDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"messageType\":0,"
					+ "\"messageTitle\":\"English\","
					+ "\"messageContent\":\"English\","
					+ "\"messageReceiverType\":0,"
					+ "\"messageReceivers\":[1101,1102,1106],"
					+ "\"remark\":\"English\"}"
				+ "}";
		String retJSON = systemConfigService.setMessageDetails(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void deleteMessage() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"messageIds\":[11,12,13],"
					+ "}"
				+ "}";
		
		String retJSON = systemConfigService.deleteMessage(rawData);
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void getAllBankBranches() {
		String retJSON = systemConfigService.listBankBranches();
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setBankDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankId\":0,"
					+ "\"bankTitle\":\"BC\","
					+ "\"remark\":\"民生银行\"}"
				+ "}";
		String retJSON = systemConfigService.setBankDetails(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void deleteBank() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankIds\":[106],"
					+ "}"
				+ "}";
		
		String retJSON = systemConfigService.deleteBank(rawData);
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void listAllSubjects(){
		String retJSON = systemConfigService.listAllSubjects();

		//assertEquals(retJSON, "");
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setSubjectDetails(){
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"subjectCode\":\"3004\","
					+ "\"subjectTitle\":\"yajin\","
					+ "\"direction\":0,"
					+ "\"remark\":\"English\"}"
				+ "}";
		
		String retJSON = systemConfigService.setSubjectDetails(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void deleteSubject(){
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"subjectIds\":[713,714],"
					+ "}"
				+ "}";
		
		String retJSON = systemConfigService.deleteSubject(rawData);
		
		System.out.println(retJSON);
	}*/
	
	@Test
	public void listAllFeeTypes(){
		String retJSON = systemConfigService.listAllFeeTypes();

		//assertEquals(retJSON, "");
		
		System.out.println(retJSON);
	}
	
	
	/*@Test
	public void setFeeTypeDetails(){
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
				    + "\"feeTypeId\":606,"
					+ "\"feeTypeTitle\":\"保证金\","
					+ "\"subjectId\":755,"
					+ "\"remark\":\"续约租金\","
					+ "\"feeValue\":200,"
					+ "\"status\":1}"
				+ "}";
		String retJSON = systemConfigService.setFeeTypeDetails(rawData);
		
		System.out.println(retJSON);
	}*/
	
	
	/*@Test
	public void setFeeType(){
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
				    + "\"feeTypeId\":602,"					
					+ "\"status\":4}"
				+ "}";
		String retJSON = systemConfigService.setFeeType(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void deleteFeeType(){
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"feeTypeIds\":[606],"
					+ "}"
				+ "}";
		
		String retJSON = systemConfigService.deleteFeeType(rawData);
		
		System.out.println(retJSON);
	}*/
}
