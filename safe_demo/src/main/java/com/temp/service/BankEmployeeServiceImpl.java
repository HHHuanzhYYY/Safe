package com.temp.service;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String validateBankEmployee(final String rawData) {
		boolean isSuccess = true;
		int employeeId = 0;
		try {
			final String utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			Map<String, Object> requestInfo = JsonUtil.parseJson(utf8Data, "name", "password");
			
			employeeId = bankEmployeeDao.validateBankEmployeeByNameAndPwd(
					(String)requestInfo.get("name"), (String)requestInfo.get("password"));			
		} catch (Exception e) {
			isSuccess = false;
		}
		
		// Log BankEmployee`s Login Action.
		BankEmployeeLoginLogPo bankEmployeeLoginLogPo = new BankEmployeeLoginLogPo();
		bankEmployeeLoginLogPo.setEmployeeId(employeeId);
		isSuccess = logDao.setEmployeeLoginLog(bankEmployeeLoginLogPo);
		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listAllBankEmployees(String rawData) {
		boolean isSuccess = true;
		List<BankEmployeeVo> bankEmployeeVos = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankId");
			
			bankEmployeeVos = bankEmployeeDao.getAllBankEmployees(Long.parseLong((String)paramValues.get("bankId")));
		} catch (Exception e) {
			isSuccess = false;
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
			e.printStackTrace();
			isSuccess = false;
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
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}  
}
