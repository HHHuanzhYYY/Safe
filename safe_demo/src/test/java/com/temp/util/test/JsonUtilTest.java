package com.temp.util.test;

import com.temp.util.JsonUtil;

public class JsonUtilTest {
	
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
		DemoChild demoChild = (DemoChild) JsonUtil.parseJson(rawData, DemoChild.class);
		
		System.out.println(demoChild);
	}
	
}
