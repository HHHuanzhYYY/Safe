package com.temp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class AccountManagerServiceTest extends ServiceTestBase {

	@Autowired
	private AccountManageService accountManageService;
	
	/*@Test
	public void getAccoutListByIdOrRFID() {
		// Identification Card.
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"certificateType\":1,"
					+ "\"certificateNo\":\"111111111111111111\""
					+ "}"
				+ "}";
//		// RFID.
//		final String rawData = "{"
//				+ "\"success\":true,"
//				+ "\"message\":null,"
//				+ "\"data\":{"
//					+ "\"certificateType\":2,"
//					+ "\"certificateNo\":\"34567\""
//					+ "}"
//				+ "}";
		
		String jsonStr = accountManageService.getAccoutListByIdOrRFID(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void getAccountInfo() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"accountType\":0,"
					+ "\"accountId\":\"905\""
					+ "}"
				+ "}";
		
		String jsonStr = accountManageService.getAccountInfo(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void setAccountInfo() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"accountType\":0,"
					+ "\"bankId\":101,"
					+ "\"isAccountFree\":0,"
					+ "\"openAccountFee\":0.0,"
					+ "\"paymentType\":0,"
					+ "\"amountSum\":550.5,"
					+ "\"customerSum\":1,"
					+ "\"customerList\":"
						+ "[{"
						+ "\"customerType\":0,"
						+ "\"customerName\":\"张大麻子\","
						+ "\"customerSex\":1,"
						+ "\"certificateType\":1,"
						+ "\"certificateNo\":\"110123456789\","
						+ "\"unitAddress\":\"北京市朝阳区***路\","
						+ "\"homeAddress\":\"北京市海淀区***小区\","
						+ "\"phone\":\"010-56436789\","
						+ "\"mobile\":\"18500003443\","
						+ "\"post\":\"010\","
						+ "\"remark\":\"这只是一个测试用例\","
						+ "\"photo\":null,"
						+ "\"cardType\":1,"
						+ "\"cardNo\":\"PEK1234555\","
						+ "\"cardRfid\":\"PEK1234555\","
						+ "\"password\":\"asdfghjkl\","
						+ "\"fingerPwd\":\"asdfghjkllkjhgfdsa\","
						+ "\"reserveFingerPwd\":\"asdfghjkllkjhgfdsa\","
						+ "}],"
					+ "\"rentList\":"
						+ "[{"
						+ "\"boxId\":110,"
						+ "\"cardRfid\":\"PEK1234555\","
						+ "\"leaseNo\":\"L11111\","
						+ "\"leaseRemark\":\"无\","
						+ "\"voucherNo\":\"V11111\","
						+ "\"voucherRemark\":\"无\","
						+ "\"rentType\":2,"
						+ "\"rentTime\":2,"
						+ "\"startDate\":1491321600000,"
						+ "\"endDate\":1554307200000,"
						+ "\"deposit\":1000.0,"
						+ "\"rent\":5000.0,"
						+ "\"rentDiscount \":0.8,"
						+ "\"actualRent\":4000.0,"
						+ "\"paymentType\":0,"
						+ "\"feeTotal\":4000.0,"
						+ "},"
						+ "{"
						+ "\"boxId\":111,"
						+ "\"cardRfid\":\"PEK5554321\","
						+ "\"leaseNo\":\"L22222\","
						+ "\"leaseRemark\":\"无\","
						+ "\"voucherNo\":\"V22222\","
						+ "\"voucherRemark\":\"无\","
						+ "\"rentType\":2,"
						+ "\"rentTime\":1,"
						+ "\"startDate\":1491321600000,"
						+ "\"endDate\":1522771200000,"
						+ "\"deposit\":1000.0,"
						+ "\"rent\":3000.0,"
						+ "\"rentDiscount \":0.8,"
						+ "\"actualRent\":2400.0,"
						+ "\"paymentType\":0,"
						+ "\"feeTotal\":2400.0,"
						+ "}]"
					+ "}"
				+ "}";
		
		String jsonStr = accountManageService.setAccountInfo(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void setAccountNewBox() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"accountId\":8074786040259612645,"
					+ "\"boxRent\":"
						+ "{"
						+ "\"boxId\":110,"
						+ "\"cardRfid\":\"PEK1234555\","
						+ "\"leaseNo\":\"L11111\","
						+ "\"leaseRemark\":\"无\","
						+ "\"voucherNo\":\"V11111\","
						+ "\"voucherRemark\":\"无\","
						+ "\"rentType\":2,"
						+ "\"rentTime\":2,"
						+ "\"startDate\":1491321600000,"
						+ "\"endDate\":1554307200000,"
						+ "\"deposit\":1000.0,"
						+ "\"rent\":5000.0,"
						+ "\"rentDiscount \":0.8,"
						+ "\"actualRent\":4000.0,"
						+ "\"paymentType\":0,"
						+ "\"feeTotal\":4000.0,"
						+ "}"
					+ "}"
				+ "}";
		
		String jsonStr = accountManageService.setAccountNewBox(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	@Test
	public void setAccountNewCustomer() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"accountId\":8074786040259612645,"
					+ "\"customer\":"
						+ "{"
						+ "\"customerType\":0,"
						+ "\"customerName\":\"大李子\","
						+ "\"customerSex\":1,"
						+ "\"certificateType\":1,"
						+ "\"certificateNo\":\"110123456789\","
						+ "\"unitAddress\":\"北京市朝阳区***路\","
						+ "\"homeAddress\":\"北京市海淀区***小区\","
						+ "\"phone\":\"010-56436789\","
						+ "\"mobile\":\"18500003443\","
						+ "\"post\":\"010\","
						+ "\"remark\":\"这只是一个测试用例\","
						+ "\"photo\":null,"
						+ "\"cardType\":1,"
						+ "\"cardNo\":\"PEK1234555\","
						+ "\"cardRfid\":\"PEK1234555\","
						+ "\"password\":\"asdfghjkl\","
						+ "\"fingerPwd\":\"asdfghjkllkjhgfdsa\","
						+ "\"reserveFingerPwd\":\"asdfghjkllkjhgfdsa\","
						+ "}"
					+ "}"
				+ "}";
		
		String jsonStr = accountManageService.setAccountNewCustomer(rawData);
		
		System.out.println(jsonStr);
	}
}
