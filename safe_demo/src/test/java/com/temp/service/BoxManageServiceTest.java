package com.temp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.temp.baseTest.ServiceTestBase;
import com.temp.util.BoxStatus;

public class BoxManageServiceTest extends ServiceTestBase {

	@Autowired
	private BoxManageService boxManageService;
	
	/*@Test
	public void getChangeBoxDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"oldBoxId\":11101,"
					+ "\"newBoxId\":11105"
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.getChangeBoxDetails(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void setChangeBoxDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"oldBoxId\":11101,"
					+ "\"newBoxId\":11105,"
					+ "\"newKeyNo\":\"11105\","
					+ "\"amountDifference\":250,"
					+ "\"keyFee\":80,"
					+ "\"paymentType\":0,"
					+ "\"feeTotal\":330"
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.setChangeBoxDetails(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void modifyBoxStatus() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxId\":11103, "
					+ "\"changeReason\":\"This is just a usecase.\""
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.modifyBoxStatus(rawData, BoxStatus.FREEZE);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void listAllModelResumes() {
		String jsonStr = boxManageService.listAllModelResumes();
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void setBoxModelResumes() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxModel\":\"E\","
					+ "\"boxModelNo\":5,"
					+ "\"remark\":\"新箱型\""
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.setBoxModelResumes(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void deleteBoxModel() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxModels\":[\"B\",\"C\"]"
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.deleteBoxModel(rawData);
		
		System.out.println(jsonStr);
	}*/
	
	/*@Test
	public void listAllBoxModels() {
		String jsonStr = boxManageService.listAllBoxModels();
		
		System.out.println(jsonStr);
	}*/
	
	@Test
	public void setBoxModelDetails() {
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxModel\":\"E\","
					+ "\"deposit\":1000.0,"
					+ "\"rentYear\":1200.0,"
					+ "\"rentMonth\":150.0,"
					+ "\"rentDay\":6.0,"
					+ "\"boxLength\":5.85,"
					+ "\"boxWidth\":4.75,"
					+ "\"boxHeight\":3.65"
					+ "}"
				+ "}";
		
		String jsonStr = boxManageService.setBoxModelDetails(rawData);
		
		System.out.println(jsonStr);
	}
	
}
