package com.temp.dao;

import java.util.List;

import com.temp.po.AccountPo;
import com.temp.util.CertificateType;
import com.temp.vo.AccountVo;

public interface AccountDao {

	/**
	 * getAccountListById.
	 * 
	 * @param id identity card
	 * @return AccountListVo
	 */
	public List<AccountVo> getAccountListById(final CertificateType type, final String id);
	
	/**
	 * getAccountListByRFID.
	 * 
	 * @param rfid
	 * @return AccountListVo
	 */
	public List<AccountVo> getAccountListByRFID(final String rfid);
	
	/**
	 * setAccount.
	 * 
	 * @param accountVo
	 * @return boolean
	 */
	public boolean setAccount(final AccountPo accountPo);
	
}
