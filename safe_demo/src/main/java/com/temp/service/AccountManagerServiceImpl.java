package com.temp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.AccountDao;
import com.temp.domain.Account;
import com.temp.util.JsonUtil;

@Service
public class AccountManagerServiceImpl implements AccountManagerService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public String getAccoutListByIdOrRFID(String rawData) {
		boolean isSuccess = true;
		List<Account> accounts = null;
		try {
			Map<String, Object> accountInfo = JsonUtil.parseJson(rawData, "CertificateType", "CertificateNum");
			
			final int certificateType = Integer.parseInt((String)accountInfo.get("CertificateType"));
			
			switch (certificateType) {
			case 1:
				accounts = accountDao.getAccountListById((String)accountInfo.get("CertificateNum"));
				break;
			case 2:
				accounts = accountDao.getAccountListByRFID((String)accountInfo.get("CertificateNum"));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, accounts);
	}

	@Override
	public String setAccountInfo(String rawData) {
		boolean isSuccess = false;
		try {
			Map<String, Object> accountInfo = JsonUtil.parseJson(rawData, "CustomerName", "CustomerSex", 
					"CertificateType", "CertificateNum", "TelephoneNum", "AccountName", "AccountType", 
					"AccountNum", "BoxId", "BoxModel", "KeyId", "RfidCard", "Status", "EndDate", "");
			
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}
	
}
