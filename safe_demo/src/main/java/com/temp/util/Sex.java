package com.temp.util;

public enum Sex {

	MALE(0),
	FEMALE(1);
	
	private Sex(int v) {
		this.value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}
}
