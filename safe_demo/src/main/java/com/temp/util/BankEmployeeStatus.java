package com.temp.util;

public enum BankEmployeeStatus {

	ENABLE(0), DISABLE(1);
	
	private int value;
	
	private BankEmployeeStatus(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
