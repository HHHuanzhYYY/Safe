package com.temp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.dao.BoxDao;
import com.temp.po.BoxDetailsPo;
import com.temp.po.BoxModelPo;
import com.temp.util.BoxStatus;
import com.temp.util.JsonUtil;
import com.temp.vo.BoxDetailsVo;
import com.temp.vo.BoxModelVo;

@Service
public class BoxManageServiceImpl implements BoxManageService {
	
	@Autowired
	private BoxDao boxDao;

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
