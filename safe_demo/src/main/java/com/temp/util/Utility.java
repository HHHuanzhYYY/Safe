package com.temp.util;

public final class Utility {

	public static AccountType classifyAccountType(int value) {
		AccountType accountType = null;
		switch (value) {
		case 0:
			accountType = AccountType.SINGLE;
			break;
		case 1:
			accountType = AccountType.UION;
			break;
		default:
			break;
		}
		return accountType;
	}
}
