package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.CustomerDao;
import com.temp.util.JsonUtil;
import com.temp.vo.CustomerVo;

@Service
public class CustomerManagerServiceImpl implements CustomerManagerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public String validateCustomer(String rawData) {
		boolean isValidateSucceed = false;
		try {
			Map<String, Object> accountInfo = JsonUtil.parseJson(rawData, "CustomerId", "Pwd", "FingerPwd");
			
			isValidateSucceed = customerDao.validateCustomer((Integer)accountInfo.get("CustomerId"), 
					(String)accountInfo.get("Pwd"), (String)accountInfo.get("FingerPwd"));
			
		} catch (Exception e) {
			isValidateSucceed = false;
		}
		return JsonUtil.constructJson(isValidateSucceed, null, null);
	}

	@Override
	public String getCustomerInfoById(String rawData) {
		boolean isSuccess = false;
		CustomerVo customerDetails = null;
		try {
			Map<String, Object> accountInfo = JsonUtil.parseJson(rawData, "CustomerId");
			
			customerDetails = customerDao.getCustomerDetailsById((Integer)accountInfo.get("CustomerId"));		
		} catch (Exception e) {
			isSuccess = false;
		}
		
		return JsonUtil.constructJson(isSuccess, null, customerDetails);
	}
	
	@Override
	public String getCustomerInfo(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCustomerInfo(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}


}
