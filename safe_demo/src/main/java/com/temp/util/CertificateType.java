package com.temp.util;

public enum CertificateType {
	
	ID(1), // Identity Card
	CARD(2), // Card
	
	PP(3), // Passport
	MOC(4); // Military Officer Certificate
	
	private int value;
	
	private CertificateType(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
