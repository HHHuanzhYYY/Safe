package com.temp.service;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;
import com.temp.util.ReportLossAction;

public class ReportLossServiceTest extends ServiceTestBase {

	@Autowired
	private ReportLossService reportLossService;
	
	/*@Test
	public void bankEmployeeLogin() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"bankEmployeeID\":1101,"					
					+ "\"bankEmployeePwd\":\"123456\"}"
				+ "}";
		String retJSON = reportLossService.bankEmployeeLogin(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setReportLossLog() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxId\":110,"
					+ "\"reportLossType\":1,"
					+ "\"paymentType\":1,"
					+ "\"feeTotal\":300}"
				+ "}";
		String retJSON = reportLossService.setReportLossLog(rawData,ReportLossAction.APPLYREPORTLOSS);
		
		System.out.println(retJSON);
	}*/
	
	@Test
	public void setReportLossDetails() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"certificateType\":1,"
					+ "\"certificateNo\":\"110123456789\","
					+ "\"reportLossType\":3,"
					+ "\"boxId\":11102,"
					+ "\"cardRfid\":\"11134567\","
					+ "\"cardNo\":\"34567\","					
                    + "\"password\":\"qaz123\","
                    + "\"keyId\":11102,"
                    + "\"paymentType\":1,"
					+ "\"feeTotal\":300}"
				+ "}";
		String retJSON = reportLossService.setReportLossDetails(rawData);
		
		System.out.println(retJSON);
	}
}
