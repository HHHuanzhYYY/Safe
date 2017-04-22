package com.temp.service;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;
import com.temp.util.ReportLossAction;

public class ReportLossServiceTest extends ServiceTestBase {

	@Autowired
	private ReportLossService reportLossService;
	
	@Test
	public void bankEmployeeLogin() {
		
		final String rawData = "{"
					+ "\"bankEmployeeID\":1105,"					
					+ "\"bankEmployeePwd\":\"333333\""
				+ "}";
		String retJSON = reportLossService.bankEmployeeLogin(rawData);
		
		System.out.println(retJSON);
	}
	
	/*@Test
	public void setReportLossLog() {
		
		final String rawData = "{"
					+ "\"boxId\":901,"
					+ "\"reportlossType\":1,"
					+ "\"paymentType\":1,"
					+ "\"feeTotal\":299.99"
				+ "}";
		String retJSON = reportLossService.setReportLossLog(rawData,ReportLossAction.APPLYREPORTLOSS);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setReportLossDetails() {
		
		final String rawData = "{"
					+ "\"reportlossId\":519,"
					+ "\"reportLossType\":2,"
					+ "\"boxId\":901,"
					+ "\"cardRfid\":\"111345677\","
					+ "\"cardNo\":\"12345\","					
                    + "\"password\":\"asdfghjkl\","
                    + "\"newCardRfid\":\"1113456777\","
					+ "\"newCardNo\":\"1113456777\","
                    + "\"newCardPassword\":\"asdfghjkl\","
                    //+ "\"keyId\":11102,"
                    + "\"paymentType\":2,"
					+ "\"feeTotal\":399.99"
				+ "}";
		String retJSON = reportLossService.setReportLossDetails(rawData, ReportLossAction.HANDLEEPORTLOSS);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void getReportLossType() {
		final String rawData = "{"
				+ "\"boxId\":11101"
			+ "}";
		String retJSON = reportLossService.getReportLossType(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setReportLossRemove() {
		
		final String rawData = "{"
					+ "\"reportlossId\":519,"
					+ "\"boxId\":901,"
					+ "\"paymentType\":1,"
					+ "\"feeTotal\":299.99"
				+ "}";
		String retJSON = reportLossService.setReportLossRemove(rawData,ReportLossAction.REMOVEREPORTLOSS);
		
		System.out.println(retJSON);
	}*/
	
}
