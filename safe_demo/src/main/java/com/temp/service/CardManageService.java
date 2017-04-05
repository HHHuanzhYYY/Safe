package com.temp.service;

public interface CardManageService {

	/**
	 * setCardPwd.
	 * 
	 * @param rawData
	 * @return String
	 */
	String setCardPwd(final String rawData);
	
	/**
	 * getAccountsCustomersBoxsByCardRfid.
	 * 
	 * @param rawData
	 * @return
	 */
	String getAccountsCustomersBoxsByCardRfid(final String rawData);
	
}
