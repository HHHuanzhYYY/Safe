package com.temp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.AccountDao;
import com.temp.dao.BoxDao;
import com.temp.dao.CardDao;
import com.temp.dao.CustomerDao;
import com.temp.dao.RentDao;
import com.temp.po.AccountAddBoxPo;
import com.temp.po.AccountAddCustomerPo;
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

@Transactional(readOnly = true)
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
		boolean isSuccess = false;
		List<AccountVo> accounts = null;
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "certificateType", "certificateNo");
			
			final int certificateType = Integer.parseInt((String)requestParams.get("certificateType"));
			
			switch (certificateType) {
			case 1:
				accounts = accountDao.getAccountListById(CertificateType.ID, 
						(String)requestParams.get("certificateNo"));
				break;
			case 2:
				accounts = accountDao.getAccountListByRFID((String)requestParams.get("certificateNo"));
				break;
			default:
				break;
			}
			
			isSuccess = true;
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, accounts);
	}

	@Override
	public String getAccountInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, List<? extends Vo>> dataContents = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "accountId", "accountType");
			
			AccountType accountType = Utility.classifyAccountType(
					Integer.parseInt(((String)requestParams.get("accountType")).trim()));
					
			// Customer List.
			List<CustomerVo> allCustomers = customerDao.getAllCustomersByAccountId(
					(String)requestParams.get("accountId"), accountType);
			
			// Box List.
			List<BoxVo> allBoxs = boxDao.getAllBoxsByAccountId(
					(String)requestParams.get("accountId"), accountType);
			
			dataContents.put("customerList", allCustomers);
			dataContents.put("boxList", allBoxs);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, dataContents);
	}
	
	@Transactional(readOnly = false/*, propagation=Propagation.SUPPORTS*/)
	@Override
	public String setAccountInfo(String rawData) {
		boolean isSuccess = true;
		try {
			// AccountPo.
			AccountPo newAccount = (AccountPo) JsonUtil.parseJson(rawData, AccountPo.class);
			
			// Generate 'accountId'.
			if (newAccount.getAccountId().isEmpty()) {
				newAccount.setAccountId(generateAccountId());
			}
			
			// Set Table: account
			isSuccess = accountDao.setAccount(newAccount);
			
			// Customer List.
			List<CustomerPo> newCustomers = newAccount.getCustomerList();
			for (CustomerPo newCustomer : newCustomers) {
				long customerId = customerDao.setCustomer(newCustomer);
				
				// SET TABLE: account_customer_relationship
				isSuccess = customerDao.setAccountCustomerRelationship(newAccount.getAccountId(), customerId);
				
				// SET TABLE: card
				CardPo cardPo = newCustomer.buildCardPo();
				cardPo.setAccountId(newAccount.getAccountId());
				cardPo.setCustomerId(customerId);
				if (cardPo != null) {
					isSuccess = cardDao.setCard(cardPo);
				}
			}
			
			// Rent List.
			List<RentPo> newRents = newAccount.getRentList();
			for (RentPo newRent : newRents) {
				// SET TABLE: box_card_relationship
				for (int i = 0; i < newCustomers.size(); i++) {
					isSuccess = boxDao.setBoxCardRelationship(newRent.getBoxId(), newRent.getCardRfid());
				}
				
				// SET TABLE: rent
				newRent.setAccountId(newAccount.getAccountId());
				isSuccess = rentDao.setRent(newRent);
			}
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = false)
	@Override
	public String setAccountNewBox(String rawData) {
		boolean isSuccess = true;
		try {
			AccountAddBoxPo accountAddBoxPo = (AccountAddBoxPo) JsonUtil.parseJson(rawData, AccountAddBoxPo.class);
			
			final RentPo rentPo = accountAddBoxPo.getBoxRent();
			rentPo.setAccountId(accountAddBoxPo.getAccountId());
			
			// Write table: box_card_relationship.
			isSuccess = boxDao.setBoxCardRelationship(rentPo.getBoxId(), rentPo.getCardRfid());
			
			// Write table: rent
			isSuccess = rentDao.setRent(rentPo);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly=false, rollbackFor=Exception.class)
	@Override
	public String setAccountNewCustomer(String rawData) {
		boolean isSuccess = true;
		try {
			AccountAddCustomerPo accountAddCustomerPo = (AccountAddCustomerPo) JsonUtil.parseJson(
					rawData, AccountAddCustomerPo.class);
			
			// Write table "customer".
			long customerId = customerDao.setCustomer(accountAddCustomerPo.getCustomer());
			
			// Write table "card".
			CardPo cardPo = accountAddCustomerPo.getCustomer().buildCardPo();
			cardPo.setAccountId(accountAddCustomerPo.getAccountId());
			cardPo.setCustomerId(customerId);
			isSuccess = cardDao.setCard(cardPo);
			
			// Write table "account_customer_relationship".
			isSuccess = customerDao.setAccountCustomerRelationship(
					accountAddCustomerPo.getAccountId(), customerId);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}
}
