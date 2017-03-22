package com.temp.util;

public enum ReportLossAction {

	APPLYREPORTLOSS(3), REMOVEREPORTLOSS(1);
	
	private ReportLossAction(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

}
