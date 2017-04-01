package com.temp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class CardManageServiceTest extends ServiceTestBase {

	@Autowired
	private CardManageService cardManageService;
	
	/*@Test
	public void modifyCardPwd() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"cardRfid\":\"67890\","
					+ "\"pwd\":\"password67890\""
					+ "}"
				+ "}";
		
		String jsonStr = cardManageService.modifyCardPwd(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	@Test
	public void getAccountsCustomersBoxsByCardRfid() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"cardRfid\":\"PEK1234555\""
					+ "}"
				+ "}";
		
		String jsonStr = cardManageService.getAccountsCustomersBoxsByCardRfid(rawData);
		
		System.out.println(jsonStr);
	}
}
