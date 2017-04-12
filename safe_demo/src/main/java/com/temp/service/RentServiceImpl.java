package com.temp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.RentDao;
import com.temp.po.OffleasePo;
import com.temp.po.ReletPo;
import com.temp.util.JsonUtil;
import com.temp.util.Utility;

@Transactional
@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentDao rentDao;

	@Transactional(readOnly = true)
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
			overdueFineAndRent.put("id", overdueFineInfo.get("rentId"));
			 
			/*
			 *  Count overdueFine.
			 *  overdueFine = rent * overdueFineStrategy
			 */
		    
			overdueFineAndRent.put("overdueFine", 
					calculateOverdueFine(((java.math.BigDecimal)overdueFineInfo.get("rentDay")).floatValue(),
							               (Date)overdueFineInfo.get("endDate"),
							               ((java.math.BigDecimal)overdueFineInfo.get("overdueFineStrategy")).floatValue()));
			
			/*
			 *  Count overdueRent.
			 *  overdueRent = rentDay * (currentDate - endDate)
			 */
			overdueFineAndRent.put("overdueRent", 
					calculateOverdueRent((Date)overdueFineInfo.get("endDate"),
							             ((java.math.BigDecimal)overdueFineInfo.get("rentDay")).floatValue()));
		} catch (Exception e) {
			throw e;
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
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String getBoxUnrentInfo(String rawData) {
		boolean isSuccess = true;
		Map<String, Object> unrentInfo = new HashMap<>();
		try {
			Map<String, Object> requestParams = JsonUtil.parseJson(rawData, "boxId");
			Map<String, Object> offleaseInfo = rentDao.getUnrentInfo(
					Long.parseLong((String)requestParams.get("boxId")));
			
			unrentInfo.put("id", offleaseInfo.get("rentId"));
			unrentInfo.put("keySum", offleaseInfo.get("keySum"));
			unrentInfo.put("keyFee", offleaseInfo.get("keyFee"));
			
			if (new Date().before((Date)offleaseInfo.get("endDate"))) {
				// ��δ�� ���ӵĵ�������
				unrentInfo.put("refoundRent", Utility.calculateRefoundRent(
						((java.math.BigDecimal)offleaseInfo.get("actualRent")).floatValue(),
						(Date)offleaseInfo.get("startDate"), 
						(Date)offleaseInfo.get("endDate"),
						(Date)offleaseInfo.get("endDateAfterRelet"),
				        ((java.math.BigDecimal)offleaseInfo.get("rentDay")).floatValue()));
				unrentInfo.put("overdueFine", 0);
				unrentInfo.put("overdueRent", 0);
			} else {
				// �Ѿ����� ���ӵĵ�������
				unrentInfo.put("refoundRent", 0);
				unrentInfo.put("overdueFine", 
						calculateOverdueFine((Integer.parseInt((String)offleaseInfo.get("rentDay"))), 
											 (Date)offleaseInfo.get("endDateAfterRelet"), 
											 ((java.math.BigDecimal)offleaseInfo.get("overdueFineStrategy")).floatValue()));
				unrentInfo.put("overdueRent", 
						calculateOverdueRent((Date)offleaseInfo.get("endDateAfterRelet"),
								             ((java.math.BigDecimal)offleaseInfo.get("rentDay")).floatValue()));
			}
		} catch (Exception e) {
			throw e;
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
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
