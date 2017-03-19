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
import com.temp.po.AccountPo;
import com.temp.po.CardPo;
import com.temp.po.CustomerPo;
import com.temp.po.RentPo;
import com.temp.util.AccountType;
import com.temp.util.CertificateType;
import com.temp.util.JsonUtil;
import com.temp.util.Utility;
import com.temp.vo.AccountVo;
import com.temp.vo.BoxVo;
import com.temp.vo.CustomerVo;
import com.temp.vo.Vo;

@Service
public class AccountManageServiceImpl implements AccountManageService {

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
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "certificateType", "certificateNo");
			
			final int certificateType = Integer.parseInt((String)requestParams.get("certificateType"));
			
			switch (certificateType) {
			case 1:
				accounts = accountDao.getAccountListById(
						CertificateType.ID.getValue(), 
						(String)requestParams.get("certificateNo"));
				break;
			case 2:
				accounts = accountDao.getAccountListByRFID((String)requestParams.get("certificateNo"));
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
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "accountId", "accountType");
			
			AccountType accountType = Utility.classifyAccountType((Integer)requestParams.get("accountType"));
					
			// Customer List.
			List<CustomerVo> allCustomers = customerDao.getAllCustomersByAccountId(
					(Integer)requestParams.get("accountId"), accountType);
			// Box List.
			List<BoxVo> allBoxs = boxDao.getAllBoxsByAccountId(
					(Integer)requestParams.get("accountId"), accountType);
			
			dataContents.put("customerList", allCustomers);
			dataContents.put("boxList", allBoxs);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, dataContents);
	}
	
	@Override
	public String setAccountInfo(String rawData) {
		boolean isSuccess = true;
		try {
			// AccountPo.
			AccountPo newAccount = (AccountPo) JsonUtil.parseJson(rawData, AccountPo.class);
			accountDao.setAccount(newAccount);
			
			// Customer List.
			List<CustomerPo> newCustomers = newAccount.getCustomers();
			for (CustomerPo newCustomer : newCustomers) {
				customerDao.setCustomer(newCustomer);
				
				CardPo cardPo = newCustomer.buildCardPo();
				if (cardPo != null) {
					customerDao.setCustomerCardRelationship(newCustomer.getCustomerId(), cardPo.getCardRfid());
					cardDao.setCard(cardPo);
				}
			}
			
			// Rent List.
			List<RentPo> newRents = newAccount.getRents();
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
