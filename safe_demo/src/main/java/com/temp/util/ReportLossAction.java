package com.temp.util;

public enum ReportLossAction {

	SETREPORTLOSS(1), REMOVEREPORTLOSS(0);
	
	private ReportLossAction(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

}
