package com.temp.dao;

import java.util.List;

import com.temp.domain.Account;

public interface AccountDao {

	/**
	 * getAccountListById.
	 * 
	 * @param id identity card
	 * @return Accounts
	 */
	public List<Account> getAccountListById(final String id);
	
	/**
	 * getAccountListByRFID.
	 * 
	 * @param rfid
	 * @return Accounts
	 */
	public List<Account> getAccountListByRFID(final String rfid);
}
