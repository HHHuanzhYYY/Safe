package com.temp.service;

import java.util.Date;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;

public class RentServiceTest extends ServiceTestBase {

	@Autowired
	private RentService rentService;
	
	/*@Test
	public void getBoxReletInfo() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxId\":11102}"
				+ "}";
		String retJSON = rentService.getBoxReletInfo(rawData);
		
		System.out.println(retJSON);
	}*/
	
	/*@Test
	public void setBoxReletInfo() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"rentTime\":30,"
					+ "\"startDate\":1491321600000,"
					+ "\"endDate\":1554307200000,"
					+ "\"rent\":50,"
					+ "\"overdueFine\":0,"					
                    + "\"overdueRent\":0,"
                    + "\"paymentType\":0,"
					+ "\"feeTotal\":200}"
				+ "}";
		String retJSON = rentService.setBoxReletInfo(rawData);
		
		System.out.println(retJSON);
	}*/
	
	@Test
	public void getBoxUnrentInfo() {
		
		final String rawData = "{"			
					+ "\"boxId\":111102"
				+ "}";
		String retJSON = rentService.getBoxUnrentInfo(rawData);
		
		System.out.println(retJSON);
	}
	
	/*@Test
	public void setBoxOffleaseInfo() {
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"returnDeposit\":1000,"
					+ "\"returnRent\":0,"
					+ "\"overdueRent\":20,"
					+ "\"overdueFine\":20,"
					+ "\"unrecycleKeySum\":2,"					
                    + "\"keyFee\":30,"
                    + "\"paymentType\":0,"
					+ "\"feeTotal\":300}"
				+ "}";
		String retJSON = rentService.setBoxOffleaseInfo(rawData);
		
		System.out.println(retJSON);
	}*/
}
