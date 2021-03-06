package com.temp.dao;

import java.util.List;

import com.temp.po.CustomerDataPo;
import com.temp.po.CustomerPo;
import com.temp.util.AccountType;
import com.temp.util.PwdType;
import com.temp.vo.CustomerDataVo;
import com.temp.vo.CustomerFullInfoVo;
import com.temp.vo.CustomerVo;

public interface CustomerDao {
	
	/**
	 * validateCustomer.
	 * 
	 * @param accountId
	 * @param pwd
	 * @param fingerPwd
	 * @return boolean
	 */
	boolean validateCustomer(String accountId, PwdType pwdType, String pwd);
	
	/**
	 * validateCustomerByNameAndPwd.
	 * 
	 * @param name
	 * @param pwd
	 * @return boolean
	 */
	boolean validateCustomerByNameAndPwd(String name, String pwd);

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
	List<CustomerVo> getAllCustomersByAccountId(final String accountId, final AccountType accountType);
	
	/**
	 * setCustomer.
	 * 
	 * @param newCustomer
	 * @return customerId
	 */
	long setCustomer(CustomerPo newCustomer);
	
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
	boolean setAccountCustomerRelationship(String accountId, long customerId);
	
	/**
	 * setCustomerData.
	 * 
	 * @param customerDataPo 
	 * @return boolean
	 */
	boolean setCustomerData(CustomerDataPo customerDataPo);
	
	/**
	 * getCustomersByCardRfid.
	 * 
	 * @param cardRfid
	 * @return List<CustomerFullInfoVo>
	 */
	List<CustomerFullInfoVo> getCustomersByCardRfid(String cardRfid);
	
}
