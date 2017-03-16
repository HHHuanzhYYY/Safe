package com.temp.util;

public enum BoxStatus {
	
	NORMAL(1), FREEZE(2);

	private int value;
	
	private BoxStatus(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
