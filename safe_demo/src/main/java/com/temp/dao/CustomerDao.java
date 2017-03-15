package com.temp.dao;

import java.util.List;

import com.temp.po.CustomerPo;
import com.temp.util.AccountType;
import com.temp.vo.CustomerVo;

public interface CustomerDao {

	/**
	 * validateCustomer.
	 * 
	 * @param customerId
	 * @param pwd
	 * @param fingerPwd
	 * @return boolean
	 */
	boolean validateCustomer(int customerId, String pwd, String fingerPwd);
	
	/**
	 * getCustomerDetailsById.
	 * 
	 * @param custormerId
	 * @return CustomerDetails
	 */
	CustomerVo getCustomerDetailsById(int custormerId);
	
	/**
	 * getAllCustomersByAccountId.
	 * 
	 * @param accountId
	 * @return List<CustomerVo>
	 */
	List<CustomerVo> getAllCustomersByAccountId(final int accountId, final AccountType accountType);
	
	/**
	 * setCustomer.
	 * 
	 * @param newCustomer
	 * @return boolean
	 */
	boolean setCustomer(CustomerPo newCustomer);
	
	/**
	 * setCustomerCardRelationship.
	 * 
	 * @param customerId
	 * @param cardRfid
	 * @return boolean
	 */
	boolean setCustomerCardRelationship(int customerId, String cardRfid);
	
}
