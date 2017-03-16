package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.CustomerDao;
import com.temp.po.CustomerDataPo;
import com.temp.util.JsonUtil;
import com.temp.vo.CustomerDataVo;
import com.temp.vo.CustomerVo;

@Service
public class CustomerManageServiceImpl implements CustomerManageService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public String validateCustomer(String rawData) {
		boolean isValidateSucceed = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "customerId", "pwd", "fingerPwd");
			
			isValidateSucceed = customerDao.validateCustomer((Integer)paramValues.get("customerId"), 
					(String)paramValues.get("pwd"), (String)paramValues.get("fingerPwd"));
			
		} catch (Exception e) {
			isValidateSucceed = false;
		}
		return JsonUtil.constructJson(isValidateSucceed, null, null);
	}

	@Override
	public String getCustomerInfoById(String rawData) {
		boolean isSuccess = true;
		CustomerVo customerDetails = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "customerId");
			
			customerDetails = customerDao.getCustomerDetailsById((Integer)paramValues.get("customerId"));		
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, customerDetails);
	}
	
	@Override
	public String getCustomerData(String rawData) {
		boolean isSuccess = true;
		CustomerDataVo customerDataVo = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "certificateType", "certificateNo");
			
			customerDataVo = customerDao.getCustomerDataByCertificateNo(
					(Integer)paramValues.get("certificateType"), (String)paramValues.get("certificateNo"));
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, customerDataVo);
	}

	@Override
	public String setCustomerData(String rawData) {
		boolean isSuccess = true;
		try {
			CustomerDataPo customerDataPo = (CustomerDataPo) JsonUtil.parseJson(rawData, CustomerDataPo.class);
			
			isSuccess = customerDao.setCustomerData(customerDataPo);
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
