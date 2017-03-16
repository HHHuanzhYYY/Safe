package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BoxDao;
import com.temp.util.BoxStatus;
import com.temp.util.JsonUtil;

@Service
public class BoxManageServiceImpl implements BoxManageService {
	
	@Autowired
	private BoxDao boxDao;

	@Override
	public String modifyBoxPwd(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeBox(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyBoxStatus(String rawData, BoxStatus boxStatus) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId", "freezeReason");
			
			isSuccess = boxDao.setBoxStatusChangeDetails(
					(Integer)paramValues.get("boxId"), 
					boxStatus.getValue(),
					(String)paramValues.get("freezeReason"));
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
