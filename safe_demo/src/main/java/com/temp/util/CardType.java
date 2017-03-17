package com.temp.util;

public enum CardType {

	MAINCARD(0),
	
	VICECARD(1);
	
	private CardType(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

}
