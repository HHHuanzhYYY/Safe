package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BankEmployeeDao;
import com.temp.util.JsonUtil;

@Service
public class ReportLossServiceImpl implements ReportLossService {
	
	@Autowired
	private BankEmployeeDao bankEmployeeDao;

	@Override
	public String bankEmployeeLogin(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankEmployeeID", "bankEmployeePwd");
			
			isSuccess = bankEmployeeDao.validateBankEmployeeByIdAndPwd(
					(Integer)paramValues.get("bankEmployeeID"), (String)paramValues.get("bankEmployeePwd"));
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String setReportLossDetails(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeReportLossState(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

}
