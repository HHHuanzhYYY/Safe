package com.temp.util;

public enum AccountType {

	SINGLE(0), 
	ONECARDMULTIBOX(1),
	MULTICARDMULTIBOX(2),
	UION(3); 
	
	private int value;
	
	private AccountType(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
