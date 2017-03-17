package com.temp.util;

public enum CertificateType {
	
	ID(0), // Identity Card
	PP(1), // Passport
	CO(2),
	CARD(3); // certificate of officers
	
	private int value;
	
	private CertificateType(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
