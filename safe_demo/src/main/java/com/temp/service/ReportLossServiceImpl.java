package com.temp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temp.dao.BankEmployeeDao;
import com.temp.dao.BoxDao;
import com.temp.dao.CardDao;
import com.temp.dao.LogDao;
import com.temp.po.ReportLossPo;
import com.temp.util.JsonUtil;
import com.temp.util.ReportLossAction;

@Transactional
@Service
public class ReportLossServiceImpl implements ReportLossService {
	
	@Autowired
	private BankEmployeeDao bankEmployeeDao;
	
	@Autowired
	private CardDao cardDao;
	
	@Autowired
	private BoxDao boxDao;
	
	@Autowired
	private LogDao logDao;

	@Transactional(readOnly = true)
	@Override
	public String bankEmployeeLogin(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "bankEmployeeID", "bankEmployeePwd");
			
			isSuccess = bankEmployeeDao.validateBankEmployeeByIdAndPwd(
					Integer.parseInt((String)paramValues.get("bankEmployeeID")),
					(String)paramValues.get("bankEmployeePwd"));
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String setReportLossLog(String rawData, ReportLossAction reportLossAction) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, 
					"cardRfid", "boxId", "reportLossType", "paymentType", "feeTotal");
			
			// Set the Status of corresponding Box to "BoxStatus.REPORTLOSS".
			// reportLossAction.getValue() = 1 : BoxStatus.INRENT
			// reportLossAction.getValue() = 3 : BoxStatus.REPORTLOSS
			boxDao.setBoxStatus(Long.parseLong((String)paramValues.get("boxId")), 
					reportLossAction.getValue());
			
			// Log the Action of Apply/Remove the Report Loss.
			isSuccess = logDao.setReportLossLog(
					reportLossAction,
					Long.parseLong((String)paramValues.get("boxId")),
					Integer.parseInt((String)paramValues.get("reportLossType")),
					Integer.parseInt((String)paramValues.get("paymentType")),
					Float.parseFloat((String)paramValues.get("feeTotal"))
					);
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}
	
	@Override
	public String getReportLossType(String rawData) {
		boolean isSuccess = true;
		try {
			Map<String, Object> paramValues = JsonUtil.parseJson(rawData, "boxId");
			
			
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}

	@Override
	public String setReportLossDetails(String rawData, ReportLossAction reportLossAction) {
		boolean isSuccess = false;
		try {
			ReportLossPo reportLossPo = (ReportLossPo) JsonUtil.parseJson(rawData, ReportLossPo.class);
			
			int reportLossType = reportLossPo.getReportLossType();			
			if ((reportLossType & 0x01) == 1) {
				// Modify Password of the Card.
				isSuccess = cardDao.changeCardPwd(reportLossPo.getCardRfid(), reportLossPo.getPassword());
			}
			if (((reportLossType >> 1) & 0x01) == 1) {
				// Change a new Card.
				isSuccess = cardDao.changeCard(reportLossPo);
			}
			if (((reportLossType >> 2) & 0x01) == 1) {
				// Change a new Key.
				isSuccess = boxDao.setBoxNewKey(reportLossPo.getBoxId(), reportLossPo.getKeyNo());
			}
			
			// Log the Action of Handle the Report Loss.
			isSuccess = logDao.setReportLossLog(reportLossAction, 
					reportLossPo.getBoxId(),
					reportLossPo.getReportLossType(),
					reportLossPo.getPaymentType(),
					reportLossPo.getFeeTotal());
		} catch (Exception e) {
			throw e;
		}		
		return JsonUtil.constructJson(isSuccess, null, null);
	}


}
