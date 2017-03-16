package com.temp.util;

public enum ReportLossType {

	PWDLOSS(1), CARDLOSS(2), KEYLOSS(3);
	
	ReportLossType (int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}	
}
