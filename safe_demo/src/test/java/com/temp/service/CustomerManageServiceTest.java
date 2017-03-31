package com.temp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class CustomerManageServiceTest extends ServiceTestBase {

	@Autowired
	private CustomerManageService customerManageService;
	
	/*@Test
	public void validateCustomer() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"accountId\":\"902\","
					+ "\"pwdType\":0,"
					+ "\"pwd\":\"111111\""
					+ "}"
				+ "}";
		
		String jsonStr = customerManageService.validateCustomer(rawData);
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void customerLogin() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"name\":\"张大麻子\","
					+ "\"password\":\"111111\""
					+ "}"
				+ "}";
		
		String jsonStr = customerManageService.customerLogin(rawData);
		System.out.println(jsonStr);
	}*/

	/*@Test
	public void getCustomerData() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					//+ "\"certificateType\":1,"
					//+ "\"certificateNo\":\"110123456789\","
					+ "\"certificateType\":2,"
					+ "\"certificateNo\":\"PEK1234555\","
					+ "\"accountId\":\"2545504967213581981\""
					+ "}"
				+ "}";
		
		String jsonStr = customerManageService.getCustomerData(rawData);
		System.out.println(jsonStr);
	}*/
	
	@Test
	public void setCustomerData() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"customerId\":813,"
					+ "\"unitAddress\":\"北京市朝阳区\","
					+ "\"homeAddress\":\"北京市海淀区橡树湾小区\","
					+ "\"phone\":\"010-12345678\","
					+ "\"mobile\":\"18600003443\","
					+ "\"post\":\"010\","
					+ "\"remark\":\"今天我就要修改你丫的\""
					+ "}"
				+ "}";
		
		String jsonStr = customerManageService.setCustomerData(rawData);
		System.out.println(jsonStr);
	}
	
}
