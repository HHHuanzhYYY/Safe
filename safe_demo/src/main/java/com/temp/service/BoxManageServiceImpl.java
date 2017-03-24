package com.temp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BoxDao;
import com.temp.dao.RentDao;
import com.temp.po.BoxDetailsPo;
import com.temp.po.BoxModelPo;
import com.temp.po.ChangeBoxPo;
import com.temp.util.BoxStatus;
import com.temp.util.DateTimeUtil;
import com.temp.util.JsonUtil;
import com.temp.util.Utility;
import com.temp.vo.BoxDetailsVo;
import com.temp.vo.BoxModelVo;

@Service
public class BoxManageServiceImpl implements BoxManageService {
	
	@Autowired
	private BoxDao boxDao;
	
	@Autowired
	private RentDao rentDao;

	@Override
	public String getChangeBoxDetails(String rawData) {
		boolean isSuccess = true;
		// retChangeBoxDetails = {<"keyNo", ***>, <"amountDifference", ***>, <"keyFee", ***>}
		Map<String, Object> retChangeBoxDetails = new HashMap<>();
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId");
			
			Map<String, Object> boxKeyDetails = boxDao.getBoxKeyDetails((int)paramValues.get("boxId"));
			retChangeBoxDetails.put("keyFee", (float)boxKeyDetails.get("newBoxKeyFee") * Utility.DEFAULT_BOXKEY_SUM);
			retChangeBoxDetails.put("keyNo", boxKeyDetails.get("newKeyNo"));
			
			Map<String, Object> rentDetails = rentDao.getUnrentInfo((int)paramValues.get("boxId"));
			float rentBalance = Utility.calculateRefoundRent(
					(Float)rentDetails.get("actualRent"), 
					(Date)rentDetails.get("startDate"), 
					(Date)rentDetails.get("endDate"),
					(Date)rentDetails.get("endDateAfterRelet"),
					(Float)rentDetails.get("rentDay"));
			float newRent = (float)boxKeyDetails.get("newBoxRentDay") 
					* DateTimeUtil.daysBetween2Date(new Date(), (Date)rentDetails.get("endDateAfterRelet"));
			float amountDifference = newRent - rentBalance;
			retChangeBoxDetails.put("amountDifference", amountDifference);
			
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, retChangeBoxDetails);
	}

	@Override
	public String setChangeBoxDetails(String rawData) {
		boolean isSuccess = true;
		try {
			ChangeBoxPo changeBoxPo = (ChangeBoxPo) JsonUtil.parseJson(rawData, ChangeBoxPo.class);
			
			// 修改 Card 和 Box 的关联关系
			isSuccess = boxDao.modifyBoxCardRelationship(changeBoxPo.getOldBoxId(), changeBoxPo.getNewBoxId());
			
			/*
			 *  新增换箱行为日志, 即 changebox_log 表新增一项
			 *  (使用旧箱的 boxId 来获取 rentId, 所以操作顺序不能变)
			 */
			isSuccess = rentDao.setChangeBoxLogInfo(changeBoxPo);
			
			/*
			 *  修改 租赁关系, 即 rent 表
			 *  1. 修改 boxId
			 *  2. 修改 feeTotal = (旧的)feeTotal + amountDifference
			 */
			isSuccess = rentDao.setChangeBoxInfo(changeBoxPo.getOldBoxId(), changeBoxPo.getNewBoxId(), 
					changeBoxPo.getAmountDifference());
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String modifyBoxStatus(String rawData, BoxStatus boxStatus) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId", "freezeReason");
			
			isSuccess = boxDao.setBoxStatusChangeDetails(
					(Integer)paramValues.get("boxId"), 
					boxStatus,
					(String)paramValues.get("freezeReason"));
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String listAllBoxs() {
		boolean isSuccess = true;
		List<BoxDetailsVo> boxDetailsVos = null;
		try {
			boxDetailsVos = boxDao.getAllBoxs();
		} catch (Exception e) {
			isSuccess = false;
		}		
		return JsonUtil.constructJson(isSuccess, null, boxDetailsVos);
	}

	@Override
	public String setBoxDetails(String rawData) {
		boolean isSuccess = true;
		try {
			BoxDetailsPo paramValues = (BoxDetailsPo) JsonUtil.parseJson(rawData, BoxDetailsPo.class);
			
			isSuccess = boxDao.setBoxDetails(paramValues);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String deleteBox(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxIds");
			
			@SuppressWarnings("unchecked")
			List<Integer> boxIds = (List<Integer>)paramValues.get("boxIds");
			isSuccess = boxDao.deleteBox(boxIds);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String listAllBoxModels() {
		boolean isSuccess = true;
		List<BoxModelVo> boxModelVos = null;
		try {
			boxModelVos = boxDao.getAllBoxModels();
		} catch (Exception e) {
			isSuccess = false;
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
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String deleteBoxModel(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxModels");
			
			@SuppressWarnings("unchecked")
			List<String> boxModels = (List<String>)paramValues.get("boxModels");
			isSuccess = boxDao.deleteBoxModel(boxModels);
		} catch (Exception e) {
			isSuccess = false;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
