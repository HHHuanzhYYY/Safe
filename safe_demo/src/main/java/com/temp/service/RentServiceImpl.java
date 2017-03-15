package com.temp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.RentDao;
import com.temp.util.DateTimeUtil;
import com.temp.util.JsonUtil;
import com.temp.vo.UnrentVo;

@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentDao rentDao;

	@Override
	public String getBoxReletInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, Float> overdueFineAndRent = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "boxId");
			
			final int boxId = Integer.parseInt((String)requestParams.get("boxId"));
			
			Map<String, Object> overdueFineInfo = rentDao.getBoxInfo4CountOverdueFineInfo(boxId);
			 
			/*
			 *  Count overdueFine.
			 *  overdueFine = rent * overdueFineStrategy
			 */
			overdueFineAndRent.put("overdueFine", 
					calculateOverdueFine((float)overdueFineInfo.get("unitRent"), 
							(float)overdueFineInfo.get("overdueFineStrategy")));
			
			/*
			 *  Count overdueRent.
			 *  overdueRent = rentDay * (currentDate - endDate)
			 */						
			overdueFineAndRent.put("overdueRent", 
					calculateOverdueRent((Date)overdueFineInfo.get("endDate"), 
							(float)overdueFineInfo.get("rentDay")));
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, overdueFineAndRent);
	}

	@Override
	public String setBoxReletInfo(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, 
					"boxId", "rentType", "beginDate", "endDate", "paymentType", "feeTotal");
			isSuccess = rentDao.setReletInfo(requestParams);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String getBoxUnrentInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, Object> unrentInfo = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "boxId");
			UnrentVo unrentVo = rentDao.getUnrentInfo(Integer.parseInt((String)requestParams.get("boxId")));
			
			unrentInfo.put("refoundRent", 
					calculateRent(unrentVo.getActualRent(), unrentVo.getBeginDate(), unrentVo.getEndDate()));
			unrentInfo.put("overdueFine", 
					calculateOverdueFine(unrentVo.getUnitRent(), unrentVo.getOverdueFineStrategy()));
			unrentInfo.put("overdueRent", 
					calculateOverdueRent(unrentVo.getEndDate(), unrentVo.getRentDay()));
			unrentInfo.put("recoverKeySum", unrentVo.getKeySum());
			unrentInfo.put("keyFee", unrentVo.getKeyFee());
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, unrentInfo);
	}

	@Override
	public String setBoxUnrentInfo(String rawData) {
		// TODO Auto-generated method stub
		return null;
	}

}
