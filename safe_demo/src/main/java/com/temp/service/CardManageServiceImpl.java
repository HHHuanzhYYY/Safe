package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.CardDao;
import com.temp.util.JsonUtil;

@Service
public class CardManageServiceImpl implements CardManageService {

	@Autowired
	private CardDao cardDao;
	
	@Override
	public String modifyCardPwd(final String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "cardRfid", "pwd");
			
			isSuccess = cardDao.modifyCardPwd((String)paramValues.get("cardRfid"), (String)paramValues.get("pwd"));			
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
