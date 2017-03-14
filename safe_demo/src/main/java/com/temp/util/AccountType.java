package com.temp.util;

public enum AccountType {

	SINGLE(0), UION(1);
	
	private int value;
	
	private AccountType(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
