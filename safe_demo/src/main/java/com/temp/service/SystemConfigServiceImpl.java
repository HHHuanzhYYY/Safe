package com.temp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.SystemConfigDao;
import com.temp.po.BankBranchPo;
import com.temp.po.FeeTypePo;
import com.temp.po.MessagePo;
import com.temp.po.SubjectPo;
import com.temp.util.JsonUtil;
import com.temp.vo.BankBranchVo;
import com.temp.vo.BankEmployeeResumeVo;
import com.temp.vo.FeeTypeVo;
import com.temp.vo.MessageVo;
import com.temp.vo.SubjectVo;

@Transactional
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
	
	@Autowired
	private SystemConfigDao systemConfigDao;
	
	@Transactional(readOnly = true)
	@Override
	public String listAllMessages() {
		boolean isSuccess = true;
		List<MessageVo> messageVos = null;
		try {
			messageVos = systemConfigDao.getAllMessages();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, messageVos);
	}

	@Transactional(readOnly = true)
	@Override
	public String getBankBranchEmployees(String rawData) {
		boolean isSuccess = true;
		List<BankEmployeeResumeVo> employeeResumeVos = null;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankId");
			
			employeeResumeVos = systemConfigDao.getBankBranchEmployees(
					Integer.parseInt(((String)paramValues.get("bankId")).trim()));
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, employeeResumeVos);
	}

	@Override
	public String setMessageDetails(String rawData) {
		boolean isSuccess = true;
		Map<String, Long> messageIdMap = new HashMap<>();
		try {
			MessagePo paramValues = (MessagePo) JsonUtil.parseJson(rawData, MessagePo.class);
			
			long messageId = systemConfigDao.setMessageDetails(paramValues);
			messageIdMap.put("messageId", messageId);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, messageIdMap);
	}

	@Override
	public String deleteMessage(String rawData) {
		boolean isSuccess = true;
		try {
			@SuppressWarnings("unchecked")
			List<Long> msgIds = (List<Long>) JsonUtil.parseJson(rawData, Long.class, "messageIds");
			
			isSuccess = systemConfigDao.deleteMessage(msgIds);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listBankBranches() {
		boolean isSuccess = true;
		List<BankBranchVo> bankBrancheVos = null;
		try {
			bankBrancheVos = systemConfigDao.getAllBankBranches();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, bankBrancheVos);
	}

	@Override
	public String setBankDetails(String rawData) {
		boolean isSuccess = true;
		Map<String, Long> retId = new HashMap<>();
		try {
			BankBranchPo paramValues = (BankBranchPo) JsonUtil.parseJson(rawData, BankBranchPo.class);
			
			long bankId = systemConfigDao.setBankDetails(paramValues); 
			retId.put("bankId", bankId);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, retId);
	}

	@Override
	public String deleteBank(String rawData) {
		boolean isSuccess = true;
		try {
			@SuppressWarnings("unchecked")
			List<Long> bankIds = (List<Long>) JsonUtil.parseJson(rawData, Long.class, "bankIds");
			
			isSuccess = systemConfigDao.deleteBank(bankIds);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listAllSubjects() {
		boolean isSuccess = true;
		List<SubjectVo> subjectVos = null;
		try {
			subjectVos = systemConfigDao.getAllSubjects();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, subjectVos);
	}

	@Override
	public String setSubjectDetails(String rawData) {
		boolean isSuccess = true;
		Map<String, Long> retId = new HashMap<>();
		try {
			SubjectPo paramValues = (SubjectPo) JsonUtil.parseJson(rawData, SubjectPo.class);
			
			long subjectId = systemConfigDao.setSubjectDetails(paramValues);
			
			retId.put("subjectId", subjectId);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, retId);
	}

	@Override
	public String deleteSubject(String rawData) {
		boolean isSuccess = true;
		try {
			@SuppressWarnings("unchecked")
			List<Long> subjectIds = (List<Long>) JsonUtil.parseJson(rawData, 
					Long.class, "subjectIds");
			
			isSuccess = systemConfigDao.deleteSubject(subjectIds);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Transactional(readOnly = true)
	@Override
	public String listAllFeeTypes() {
		boolean isSuccess = true;
		List<FeeTypeVo> feeTypeVos = null;
		try {
			feeTypeVos = systemConfigDao.getAllFeeTypes();
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, feeTypeVos);
	}

	@Override
	public String setFeeTypeDetails(String rawData) {
		boolean isSuccess = true;
		try {
			FeeTypePo paramValues = (FeeTypePo) JsonUtil.parseJson(rawData, FeeTypePo.class);
			
			isSuccess = systemConfigDao.setFeeTypeDetails(paramValues);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String setFeeType(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "feeTypeId", "status");
			
			isSuccess = systemConfigDao.setFeeTypeStatus(
					Long.parseLong((String)paramValues.get("feeTypeId")), 
					Integer.parseInt((String)paramValues.get("status")));
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String deleteFeeType(String rawData) {
		boolean isSuccess = true;
		try {
			@SuppressWarnings("unchecked")
			List<Long> feeTypeIds = (List<Long>) JsonUtil.parseJson(rawData, 
					Long.class, "feeTypeIds");
			isSuccess = systemConfigDao.deleteFeeType(feeTypeIds);
		} catch (Exception e) {
			throw e;
		}
		return JsonUtil.constructJson(isSuccess, null, null);
	}

}
