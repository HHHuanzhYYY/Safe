package com.temp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.CustomerDao;
import com.temp.po.CustomerDataPo;
import com.temp.util.JsonUtil;
import com.temp.util.PwdType;
import com.temp.vo.CustomerDataVo;

@Transactional(readOnly = true)
@Service
public class CustomerManageServiceImpl implements CustomerManageService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public String validateCustomer(String rawData) {
		boolean isValidateSucceed = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "accountId", "pwdType", "pwd");
			
			isValidateSucceed = customerDao.validateCustomer(
					(String)paramValues.get("accountId"), 
					PwdType.convert2PwdType(Integer.parseInt((String)paramValues.get("pwdType"))), 
					(String)paramValues.get("pwd"));
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isValidateSucceed, null, null);
	}
	
	@Override
	public String customerLogin(String rawData) {
		boolean isValidateSucceed = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "name", "password");
			
			isValidateSucceed = customerDao.validateCustomerByNameAndPwd(
					(String)paramValues.get("name"), 
					(String)paramValues.get("password"));
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isValidateSucceed, null, null);
	}

	@Override
	public String getCustomerData(String rawData) {
		boolean isSuccess = true;
		List<CustomerDataVo> customerDataVos = null;
		try {
			Map<String, Object> paramValues = 
					JsonUtil.parseJson(rawData, "certificateType", "certificateNo", "accountId");
			
			customerDataVos = customerDao.getCustomerDataByCertificateNo(
					Integer.parseInt((String)paramValues.get("certificateType")), 
					(String)paramValues.get("certificateNo"), 
					Long.parseLong((String)paramValues.get("accountId")));
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, customerDataVos);
	}

	@Transactional(readOnly = false)
	@Override
	public String setCustomerData(String rawData) {
		boolean isSuccess = true;
		try {
			CustomerDataPo customerDataPo = (CustomerDataPo) JsonUtil.parseJson(rawData, CustomerDataPo.class);
			
			isSuccess = customerDao.setCustomerData(customerDataPo);
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}


}
