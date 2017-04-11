package com.temp.service;

//import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.BankEmployeeDao;
import com.temp.dao.LogDao;
import com.temp.po.BankEmployeeLoginLogPo;
import com.temp.po.BankEmployeePo;
import com.temp.util.JsonUtil;
import com.temp.vo.BankEmployeeVo;

@Transactional
@Service  
public class BankEmployeeServiceImpl implements BankEmployeeService {

	@Autowired  
    private BankEmployeeDao bankEmployeeDao;  
	
	@Autowired
	private LogDao logDao;

	@Override
	public String validateBankEmployee(final String rawData, Cookie... cookies) {
		boolean isSuccess = true;
		long employeeId = 0;
		try {
			//final String utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			Map<String, Object> requestInfo = JsonUtil.parseJson(rawData, "name", "password");
			
			if (cookies != null && (cookies.length >= 1) && (cookies[0] != null)) {
				cookies[0].setValue((String)requestInfo.get("name"));
			}
			
			employeeId = bankEmployeeDao.validateBankEmployeeByNameAndPwd(
					(String)requestInfo.get("name"), (String)requestInfo.get("password"));
		} catch (Exception e) {
			throw e;
		}
		
		if (employeeId == 0) {
			isSuccess = false;
		} else {
			if (cookies != null && (cookies.length >= 2) && (cookies[1] != null)) {
				cookies[1].setValue(Long.toString(employeeId));
			}
			
			// Log BankEmployee`s Login Action.
			BankEmployeeLoginLogPo bankEmployeeLoginLogPo = new BankEmployeeLoginLogPo();
			bankEmployeeLoginLogPo.setEmployeeId(employeeId);
			isSuccess = logDao.setEmployeeLoginLog(bankEmployeeLoginLogPo);
		}
		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String getAllBankEmployees(String rawData) {
		boolean isSuccess = true;
		List<BankEmployeeVo> bankEmployeeVos = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankId");
			
			bankEmployeeVos = bankEmployeeDao.getAllBankEmployees(Long.parseLong((String)paramValues.get("bankId")));
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, bankEmployeeVos);
	}

	@Override
	public String setBankEmployeeDetails(final String rawData) {
		boolean isSuccess = true;
		Map<String, Long> bankEmployeeId = new HashMap<>();
		try {
			BankEmployeePo paramValues = (BankEmployeePo) JsonUtil.parseJson(rawData, BankEmployeePo.class);
			
			long employeeId = bankEmployeeDao.setBankEmployeeDetails(paramValues);
			
			bankEmployeeId.put("employeeId", employeeId);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, bankEmployeeId);
	}

	@Override
	public String deleteBankEmployee(String rawData) {
		boolean isSuccess = true;
		try {
			@SuppressWarnings("unchecked")
			List<Long> bankEmployeeIds = (List<Long>) JsonUtil.parseJson(rawData, Long.class, "bankEmployeeIds");
			
			isSuccess = bankEmployeeDao.deleteBankEmployee(bankEmployeeIds);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}  
}
