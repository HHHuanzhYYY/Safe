package com.temp.service;

import java.net.URLDecoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BankEmployeeDao;
import com.temp.dao.LogDao;
import com.temp.util.JsonUtil;

@Service  
public class BankEmployeeServiceImpl implements BankEmployeeService {

	@Autowired  
    private BankEmployeeDao bankEmployeeDao;  
	
	@Autowired
	private LogDao logDao;

	@Override
	public String validateBankEmployee(final String rawData) {
		boolean isValidateSucceed = false;
		try {
			final String utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			Map<String, Object> requestInfo = JsonUtil.parseJson(utf8Data, "Name", "Password");
			
			isValidateSucceed = bankEmployeeDao.validateBankEmployeeByNameAndPwd(
					(String)requestInfo.get("Name"), (String)requestInfo.get("Password"));			
		} catch (Exception e) {
			isValidateSucceed = false;
		}
		
		// Log.
		
		String retJson = JsonUtil.constructJson(isValidateSucceed, null, null);
		
		return retJson;
	}  
}
