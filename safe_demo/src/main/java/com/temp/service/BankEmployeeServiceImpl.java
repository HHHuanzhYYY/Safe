package com.temp.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BankEmployeeDao;
import com.temp.dao.LogDao;
import com.temp.po.BankEmployeePo;
import com.temp.util.JsonUtil;
import com.temp.vo.BankEmployeeVo;

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

	@Override
	public String listAllBankEmployees(String rawData) {
		boolean isSuccess = true;
		List<BankEmployeeVo> bankEmployeeVos = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankId");
			
			bankEmployeeVos = bankEmployeeDao.getAllBankEmployees((int)paramValues.get("bankId"));
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, bankEmployeeVos);
	}

	@Override
	public String setBankEmployeeDetails(final String rawData) {
		boolean isSuccess = true;
		Map<String, Integer> bankEmployeeId = new HashMap<>();
		try {
			BankEmployeePo paramValues = (BankEmployeePo) JsonUtil.parseJson(rawData, BankEmployeePo.class);
			
			int employeeId = bankEmployeeDao.setBankEmployeeDetails(paramValues);
			
			bankEmployeeId.put("employeeId", employeeId);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, bankEmployeeId);
	}

	@Override
	public String deleteBankEmployee(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankEmployeeIds");
			
			@SuppressWarnings("unchecked")
			List<Integer> bankEmployeeIds = (List<Integer>)paramValues.get("bankEmployeeIds");
			isSuccess = bankEmployeeDao.deleteBankEmployee(bankEmployeeIds);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}  
}
