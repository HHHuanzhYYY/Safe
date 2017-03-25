package com.temp.util;

public enum CertificateType {
	
	ID(1), // Identity Card
	CARD(2), // certificate of officers
	
	PP(3), // Passport
	CO(4);	
	
	private int value;
	
	private CertificateType(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
