package com.temp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.RentDao;
import com.temp.po.OffleasePo;
import com.temp.po.ReletPo;
import com.temp.util.JsonUtil;

@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentDao rentDao;

	@Override
	public String getBoxReletInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, Object> overdueFineAndRent = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "boxId");
			
			final int boxId = Integer.parseInt((String)requestParams.get("boxId"));
			
			Map<String, Object> overdueFineInfo = rentDao.getBoxInfo4CountOverdueFineInfo(boxId);
			
			/*
			 * rent Primary Key:id
			 */
			overdueFineAndRent.put("id", overdueFineInfo.get("id"));
			 
			/*
			 *  Count overdueFine.
			 *  overdueFine = rent * overdueFineStrategy
			 */
			overdueFineAndRent.put("overdueFine", 
					calculateOverdueFine((float)overdueFineInfo.get("rentDay"), 
										 (Date)overdueFineInfo.get("endDate"),
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
			ReletPo reletPo = (ReletPo) JsonUtil.parseJson(rawData, ReletPo.class);
			isSuccess = rentDao.setReletInfo(reletPo);
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
			Map<String, Object> offleaseInfo = rentDao.getUnrentInfo(
					Integer.parseInt((String)requestParams.get("boxId")));
			
			unrentInfo.put("id", offleaseInfo.get("id"));
			unrentInfo.put("keySum", offleaseInfo.get("keySum"));
			unrentInfo.put("keyFee", offleaseInfo.get("keyFee"));
			
			if (new Date().before((Date)offleaseInfo.get("endDate"))) {
				// 还未到 箱子的到期日期
				unrentInfo.put("refoundRent", 
						calculateRent((Float)offleaseInfo.get("actualRent"), 
									  (Date)offleaseInfo.get("startDate"), 
									  (Date)offleaseInfo.get("endDate"),
									  (Date)offleaseInfo.get("endDateAfterRelet"),
									  (Float)offleaseInfo.get("rentDay")));
				unrentInfo.put("overdueFine", 0);
				unrentInfo.put("overdueRent", 0);
			} else {
				// 已经超过 箱子的到期日期
				unrentInfo.put("refoundRent", 0);
				unrentInfo.put("overdueFine", 
						calculateOverdueFine((Integer)offleaseInfo.get("rentDay"), 
											 (Date)offleaseInfo.get("endDateAfterRelet"), 
											 (Float)offleaseInfo.get("overdueFineStrategy")));
				unrentInfo.put("overdueRent", 
						calculateOverdueRent((Date)offleaseInfo.get("endDateAfterRelet"), 
											 (Float)offleaseInfo.get("rentDay")));
			}
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, unrentInfo);
	}

	@Override
	public String setBoxOffleaseInfo(String rawData) {
		boolean isSuccess = true;
		try {
			OffleasePo requestParams = (OffleasePo) JsonUtil.parseJson(rawData, OffleasePo.class);
			isSuccess = rentDao.setOffleaseInfo(requestParams);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
