package com.temp.util;

public enum SystemMessageType {

	MESSAGE(0, "��Ϣ"), // ��Ϣ
	
	NOTICE(1, "����"),  // ����
	
	WARN(2, "����");    // ����
	
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
