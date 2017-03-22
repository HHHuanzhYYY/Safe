package com.temp.dao;

import java.util.List;

import com.temp.po.CustomerDataPo;
import com.temp.po.CustomerPo;
import com.temp.util.AccountType;
import com.temp.util.PwdType;
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
	boolean validateCustomer(int accountId, PwdType pwdType, String pwd);
	
	/**
	 * getCustomerDetailsById.
	 * 
	 * @param custormerId
	 * @return CustomerDetails
	 */
	CustomerVo getCustomerDetailsById(int custormerId);
	
	/**
	 * getCustomerDataByCertificateNo.
	 * 
	 * @param certificateType
	 * @param certificateNo
	 * @param accountId
	 * @return List<CustomerDataVo>
	 */
	List<CustomerDataVo> getCustomerDataByCertificateNo(int certificateType, String certificateNo, long accountId);
	
	/**
	 * getAllCustomersByAccountId.
	 * 
	 * @param accountId
	 * @return List<CustomerVo>
	 */
	List<CustomerVo> getAllCustomersByAccountId(final long accountId, final AccountType accountType);
	
	/**
	 * setCustomer.
	 * 
	 * @param newCustomer
	 * @return customerId
	 */
	int setCustomer(CustomerPo newCustomer);
	
	/**
	 * setCustomerCardRelationship.
	 * 
	 * @param customerId
	 * @param cardRfid
	 * @return boolean
	 */
	boolean setCustomerCardRelationship(int customerId, String cardRfid);
	
	/**
	 * setAccountCustomerRelationship.
	 * 
	 * @param accountId
	 * @param customerId
	 * @return boolean
	 */
	boolean setAccountCustomerRelationship(long accountId, int customerId);
	
	/**
	 * setCustomerData.
	 * 
	 * @param customerDataPo 
	 * @return boolean
	 */
	boolean setCustomerData(CustomerDataPo customerDataPo);
	
}
