package com.temp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.BoxDao;
import com.temp.dao.RentDao;
import com.temp.po.BoxModelResumePo;
import com.temp.po.BoxModelPo;
import com.temp.po.ChangeBoxPo;
import com.temp.util.BoxStatus;
import com.temp.util.DateTimeUtil;
import com.temp.util.JsonUtil;
import com.temp.util.Utility;
import com.temp.vo.BoxModelResumeVo;
import com.temp.vo.BoxModelVo;

@Transactional
@Service
public class BoxManageServiceImpl implements BoxManageService {
	
	@Autowired
	private BoxDao boxDao;
	
	@Autowired
	private RentDao rentDao;
	
	@Transactional(readOnly = true)
	@Override
	public String getChangeBoxInfo(String rawData) {
		boolean isSuccess = false;
		Map<String, Object> rentAndDeposit = null;		
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId");
			
			rentAndDeposit = rentDao.getRentAndDeposit(Long.parseLong((String)paramValues.get("boxId")));
			
			isSuccess = true;
		} catch (Exception e) {
			throw e;
		}	
		return JsonUtil.constructJson(isSuccess, null, rentAndDeposit);
	}

	@Transactional(readOnly = true)
	@Override
	public String getChangeBoxDetails(String rawData) {
		boolean isSuccess = true;
		// retChangeBoxDetails = {<"keyNo", ***>, <"amountDifference", ***>, <"keyFee", ***>}
		Map<String, Object> retChangeBoxDetails = new HashMap<>();
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "oldBoxId", "newBoxId");
			
			Map<String, Object> boxKeyDetails = boxDao.getBoxKeyDetails(
					Long.parseLong((String)paramValues.get("newBoxId")));
			if (boxKeyDetails != null) {
				retChangeBoxDetails.put("keyFee", 
						((java.math.BigDecimal)boxKeyDetails.get("newBoxKeyFee")).floatValue() 
						* Utility.DEFAULT_BOXKEY_SUM);
				retChangeBoxDetails.put("keyNo", boxKeyDetails.get("newKeyNo"));
				
				Map<String, Object> rentDetails = rentDao.getUnrentInfo(
						Long.parseLong((String)paramValues.get("oldBoxId")));
				float rentBalance = Utility.calculateRefoundRent(
						((java.math.BigDecimal)rentDetails.get("actualRent")).floatValue(), 
						(Date)rentDetails.get("startDate"), 
						(Date)rentDetails.get("endDate"),
						(Date)rentDetails.get("endDateAfterRelet"),
						((java.math.BigDecimal)rentDetails.get("rentDay")).floatValue());
				float newRent = ((java.math.BigDecimal)boxKeyDetails.get("newBoxRentDay")).floatValue() 
						* DateTimeUtil.daysBetween2Date(new Date(), (Date)rentDetails.get("endDateAfterRelet"));
				float amountDifference = newRent - rentBalance;
				retChangeBoxDetails.put("amountDifference", amountDifference);
			}
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, retChangeBoxDetails);
	}

	@Override
	public String setChangeBoxDetails(String rawData) {
		boolean isSuccess = true;
		try {
			ChangeBoxPo changeBoxPo = (ChangeBoxPo) JsonUtil.parseJson(rawData, ChangeBoxPo.class);
			
			// 
			isSuccess = boxDao.modifyBoxCardRelationship(changeBoxPo.getOldBoxId(), changeBoxPo.getNewBoxId());
			
			/*
			 *  
			 */
			isSuccess = rentDao.setChangeBoxLogInfo(changeBoxPo);
			
			/*
			 *  
			 */
			isSuccess = rentDao.setChangeBoxInfo(changeBoxPo.getOldBoxId(), changeBoxPo.getNewBoxId(), 
					changeBoxPo.getAmountDifference());
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String modifyBoxStatus(String rawData, BoxStatus boxStatus) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId", "changeReason");
			
			isSuccess = boxDao.setBoxStatusChangeDetails(
					Long.parseLong((String)paramValues.get("boxId")), 
					boxStatus,
					(String)paramValues.get("changeReason"));
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listAllModelResumes() {
		boolean isSuccess = true;
		List<BoxModelResumeVo> boxDetailsVos = null;
		try {
			boxDetailsVos = boxDao.getAllBoxModelResumes();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, boxDetailsVos);
	}

	@Override
	public String setBoxModelResumes(String rawData) {
		boolean isSuccess = true;
		try {
			BoxModelResumePo paramValues = (BoxModelResumePo) JsonUtil.parseJson(rawData, BoxModelResumePo.class);
			
			isSuccess = boxDao.setAllBoxModelResumes(paramValues);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String deleteBoxModel(String rawData) {
		boolean isSuccess = true;
		try {
			List<String> boxModels = JsonUtil.parseJson(null, rawData, "boxModels");
			
			isSuccess = boxDao.deleteBoxModel(boxModels);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listAllBoxModels() {
		boolean isSuccess = true;
		List<BoxModelVo> boxModelVos = null;
		try {
			boxModelVos = boxDao.getAllBoxModels();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, boxModelVos);
	}

	@Override
	public String setBoxModelDetails(String rawData) {
		boolean isSuccess = true;
		try {
			BoxModelPo paramValues = (BoxModelPo) JsonUtil.parseJson(rawData, BoxModelPo.class);
			
			isSuccess = boxDao.setBoxModelDetails(paramValues);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String listAllFreeBox() {
		boolean isSuccess = true;
		List<Long> boxIds = null;
		try {
			boxIds = boxDao.getAllFreeBox();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, boxIds);
	}

	@Override
	public String getBoxInfo(String rawData) {
		boolean isSuccess = false;
		Map<String, Object> boxInfo = null;
		try {
			Map<String, Object> boxIdMap = JsonUtil.parseJson(rawData, "boxId");
			
			boxInfo = boxDao.getBoxInfoByBoxId(Long.parseLong((String)boxIdMap.get("boxId")));
			
			isSuccess = true;
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, boxInfo);
	}

}
