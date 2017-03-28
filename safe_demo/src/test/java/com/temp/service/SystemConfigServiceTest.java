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
	}
	
	@Test
	public void listBankBranchEmployees() {
		final String rawData = "{\"success\":true,\"message\":null,\"data\":{\"bankId\":101}}";
		String retJSON = systemConfigService.listBankBranchEmployees(rawData);
		
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
					+ "\"messageIds\":[14,15,16,17],"
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
					+ "\"remark\":\"中国银行\"}"
				+ "}";
		String retJSON = systemConfigService.setBankDetails(rawData);
		
		System.out.println(retJSON);
	}*/
	
	@Test
	public void deleteBank() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankIds\":[107,108,114,115],"
					+ "}"
				+ "}";
		
		String retJSON = systemConfigService.deleteBank(rawData);
		System.out.println(retJSON);
	}
}
