package com.temp.util;

public enum PwdType {

	CHARPWD(0),
	FINGERPWD(1),
	RESERVEFINGERPWD(2);
	
	private PwdType(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

	public static PwdType convert2PwdType(int param) {
		switch (param) {
		case 0:
			return CHARPWD;
		case 1:
			return FINGERPWD;
		case 2:
			return RESERVEFINGERPWD;
		default:
			return null;
		}
	}
}
