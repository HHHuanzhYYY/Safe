package com.temp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.AccountDao;
import com.temp.dao.BoxDao;
import com.temp.dao.CardDao;
import com.temp.dao.CustomerDao;
import com.temp.dao.RentDao;
import com.temp.po.RentPo;
import com.temp.util.AccountType;
import com.temp.util.CertificateType;
import com.temp.util.JsonUtil;
import com.temp.vo.AccountVo;
import com.temp.vo.BoxVo;
import com.temp.vo.CustomerVo;
import com.temp.vo.Vo;

@Service
public class AccountManagerServiceImpl implements AccountManagerService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BoxDao boxDao;
	
	@Autowired
	private CardDao cardDao;
	
	@Autowired
	private RentDao rentDao;
	
	@Override
	public String getAccoutListByIdOrRFID(String rawData) {
		boolean isSuccess = true;
		List<AccountVo> accounts = null;
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "CertificateType", "CertificateNum");
			
			final int certificateType = Integer.parseInt((String)requestParams.get("CertificateType"));
			
			switch (certificateType) {
			case 1:
				accounts = accountDao.getAccountListById(CertificateType.ID.getValue(), 
						(String)requestParams.get("CertificateNum"));
				break;
			case 2:
				accounts = accountDao.getAccountListByRFID((String)requestParams.get("CertificateNum"));
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
	public String getAccountInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, List<? extends Vo>> dataContents = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "AccountId", "AccountType");
			
			AccountType accountType = null;
			switch ((Integer)requestParams.get("AccountType")) {
			case 0:
				accountType = AccountType.SINGLE;
				break;
			case 1:
				accountType = AccountType.UION;
				break;
			default:
				break;
			}
					
			// Customer List.
			List<CustomerVo> allCustomers = customerDao
					.getAllCustomersByAccountId((Integer)requestParams.get("AccountId"), accountType);
			// Box List.
			List<BoxVo> allBoxs = boxDao.getAllBoxsByAccountId((Integer)requestParams.get("AccountId"), accountType);
			
			dataContents.put("customerList", allCustomers);
			dataContents.put("boxList", allBoxs);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, dataContents);
	}
	
	@Override
	public String setAccountInfo(String rawData) {
		boolean isSuccess = false;
		try {
			Map<String, Object> requestParam = JsonUtil.parseJson(rawData, "CustomerName", "CustomerSex", 
					"CertificateType", "CertificateNum", "TelephoneNum", "AccountName", "AccountType", 
					"AccountNum", "BoxId", "BoxModel", "KeyId", "RfidCard", "Status", "EndDate", "");
			
			// Account.
			AccountVo newAccount = null;
			accountDao.setAccount(newAccount);
			
			// Customer List.
			List<CustomerVo> newCustomers = null;
			for (CustomerVo newCustomer : newCustomers) {
				customerDao.setCustomer(newCustomer);
				if (newCustomer.getCard() != null) {
					customerDao.setCustomerCardRelationship(newCustomer.getCustomerId(), newCustomer.getCard().getCardRfid());
					cardDao.setCard(newCustomer.getCard());
				}
			}
			
			// Rent List.
			List<RentPo> newRents = null;
			for (RentPo newRent : newRents) {
				// Box Card Relationship.
				if (newAccount.getAccountType() == AccountType.SINGLE.getValue()) {
					boxDao.setBoxCardRelationship(newRent.getBoxId(), newRent.getCardRfid());
				}
				
				// Rent Details.
				newRent.setAccountId(newAccount.getAccountId());
				rentDao.setRent(newRent);
			}
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
