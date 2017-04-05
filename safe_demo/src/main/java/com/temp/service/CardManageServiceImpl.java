package com.temp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.AccountDao;
import com.temp.dao.BoxDao;
import com.temp.dao.CardDao;
import com.temp.dao.CustomerDao;
import com.temp.util.JsonUtil;
import com.temp.vo.AccountFullInfoVo;
import com.temp.vo.BoxFullInfoVo;
import com.temp.vo.CustomerFullInfoVo;
import com.temp.vo.Vo;

@Transactional
@Service
public class CardManageServiceImpl implements CardManageService {

	@Autowired
	private CardDao cardDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BoxDao boxDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public String setCardPwd(final String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "cardRfid", "pwd");
			
			isSuccess = cardDao.changeCardPwd((String)paramValues.get("cardRfid"), (String)paramValues.get("pwd"));			
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String getAccountsCustomersBoxsByCardRfid(String rawData) {
		boolean isSuccess = true;
		Map<String, List<? extends Vo>> customersAndBoxsAndAccounts = new HashMap<>();
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "cardRfid");
			
			// Customer Details.
			List<CustomerFullInfoVo> customers = customerDao.getCustomersByCardRfid(
					(String)paramValues.get("cardRfid"));
			customersAndBoxsAndAccounts.put("customers", customers);
			
			// Box Details.
			List<BoxFullInfoVo> boxs = boxDao.getBoxsByCardRfid((String)paramValues.get("cardRfid"));
			customersAndBoxsAndAccounts.put("boxs", boxs);
			
			// Account Details.
			List<AccountFullInfoVo> accounts = accountDao.getAccountsByCardRfid(
					(String)paramValues.get("cardRfid"));
			customersAndBoxsAndAccounts.put("accounts", accounts);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, customersAndBoxsAndAccounts);
	}

}
