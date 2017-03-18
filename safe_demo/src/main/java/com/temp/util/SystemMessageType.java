package com.temp.util;

public enum SystemMessageType {

	MESSAGE(0, "消息"), // 消息
	
	NOTICE(1, "公告"),  // 公告
	
	WARN(2, "提醒");    // 提醒
	
	private SystemMessageType(int v, String d) {
		value = v;
		description = d;
	}
	
	private int value;
	
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
}
