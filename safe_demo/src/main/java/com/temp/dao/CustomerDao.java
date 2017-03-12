package com.temp.dao;

import com.temp.domain.CustomerDetails;

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
	CustomerDetails getCustomerDetailsById(int custormerId);
	
}
