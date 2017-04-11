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
					"boxId", "reportLossType", "paymentType", "feeTotal");
			
			// Set the Status of corresponding Box.
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
	public String setReportLossDetails(String rawData, ReportLossAction reportLossAction) {
		boolean isSuccess = true;
		try {
			ReportLossPo reportLossPo = (ReportLossPo) JsonUtil.parseJson(rawData, ReportLossPo.class);
			
			switch (reportLossPo.getVisualReportLossType()) {
			case PWDLOSS:
				isSuccess = cardDao.changeCardPwd(reportLossPo.getCardRfid(), reportLossPo.getPassword());
				break;
			case CARDLOSS:
				isSuccess = cardDao.changeCard(reportLossPo);
				break;
			case KEYLOSS:
				isSuccess = boxDao.setBoxNewKey(reportLossPo.getBoxId(), reportLossPo.getKeyNo());
				break;
			default:
				break;
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
