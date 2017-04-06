package com.temp.util.test;

import java.util.Calendar;

import com.temp.util.JsonUtil;

public class JsonUtilTest {
	
	private static long constructUUID(String param) {
		int indicator = Math.abs(param.hashCode());
		
		System.out.println(indicator);
		
		Calendar now = Calendar.getInstance();
		long time = now.getTimeInMillis();
		
		System.out.println(time);
		
//		System.out.println(time << 16);
		
		return time & indicator; 
	}
	
	public static void main(String[] args) {
		String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"secondId\":111111,"
					+ "\"demo\":{"
					+ "\"id\":222222,"
					+ "\"name\":\"张三\","
					+ "\"address\":\"北京市\""
					+ "}"
				+ "}}";
		
		System.out.println(constructUUID(rawData));
	}
	
}
