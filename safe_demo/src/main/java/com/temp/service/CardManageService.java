package com.temp.service;

public interface CardManageService {

	/**
	 * modifyCardPwd.
	 * 
	 * @param rawData
	 * @return String
	 */
	String modifyCardPwd(final String rawData);
	
	/**
	 * getAccountsCustomersBoxsByCardRfid.
	 * 
	 * @param rawData
	 * @return
	 */
	String getAccountsCustomersBoxsByCardRfid(final String rawData);
	
}
