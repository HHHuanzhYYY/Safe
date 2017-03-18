package com.temp.dao;

import java.util.List;

import com.temp.po.CustomerDataPo;
import com.temp.po.CustomerPo;
import com.temp.util.AccountType;
import com.temp.vo.CustomerDataVo;
import com.temp.vo.CustomerVo;

public interface CustomerDao {
	
	/**
	 * validateCustomerByNameAndPwd.
	 * 
	 * @param name
	 * @param pwd
	 * @return boolean
	 */
	boolean validateCustomerByNameAndPwd(String name, String pwd);

	/**
	 * validateCustomer.
	 * 
	 * @param accountId
	 * @param pwd
	 * @param fingerPwd
	 * @return boolean
	 */
	boolean validateCustomer(int accountId, int pwdType, String pwd);
	
	/**
	 * getCustomerDetailsById.
	 * 
	 * @param custormerId
	 * @return CustomerDetails
	 */
	CustomerVo getCustomerDetailsById(int custormerId);
	
	/**
	 * 
	 * @return CustomerDataVo
	 */
	CustomerDataVo getCustomerDataByCertificateNo(int certificateType, String certificateNo);
	
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
	
	/**
	 * setCustomerData.
	 * 
	 * @param customerDataPo 
	 * @return boolean
	 */
	boolean setCustomerData(CustomerDataPo customerDataPo);
	
}
