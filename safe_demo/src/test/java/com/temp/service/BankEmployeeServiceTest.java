package com.temp.service;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class BankEmployeeServiceTest extends ServiceTestBase {

	@Autowired
	private BankEmployeeService bankEmployeeService;
	
	@Test
	public void validateBankEmployee() throws Exception {
		final String rawData = "{"
				//+ "\"success\":true,"
				//+ "\"message\":null,"
				//+ "\"data\":{"
					+ "\"name\":\"柳宗元\","
					+ "\"password\":\"123456\""
				//	+ "}"
				+ "}";
		
		Cookie employeeName = new Cookie("employeeName", "admin");
		Cookie employeeId = new Cookie("employeeId", "0"); 
		
		String jsonStr = bankEmployeeService.validateBankEmployee(rawData, 
				employeeName, 
				employeeId);
		
		System.out.println(jsonStr);
	}
	
	/*@Test
	public void getAllBankEmployees() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankId\":101"
					+ "}"
				+ "}";
		
		String jsonStr = bankEmployeeService.getAllBankEmployees(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void setBankEmployeeDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"employeeId\":1106,"
					+ "\"loginId\":\"PEK1234567890\","
					+ "\"employeeName\":\"柳宗元是个麻子\","
					+ "\"priority\":5,"
					+ "\"certificateType\":1,"
					+ "\"certificateNo\":\"010987654321\","
					+ "\"mobile\":\"010-57651234\","
					+ "\"icCardNo\":\"6578904321\","
					+ "\"isAdministrator\":1,"
					+ "\"remark\":\"柳宗元是个大麻子脸\","
					+ "\"bankId\":105"
					+ "}"
				+ "}";
		
		String jsonStr = bankEmployeeService.setBankEmployeeDetails(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	@Test
	public void deleteBankEmployee() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankEmployeeIds\":[1102,1103]"
					+ "}"
				+ "}";
		
		String jsonStr = bankEmployeeService.deleteBankEmployee(rawData);
		
		System.out.println(jsonStr);
	}
	
}
