package com.temp.po;

import com.temp.util.ReportLossType;

public class ReportLossPo extends Po {
	
	private int certificateType;
	
	private String certificateNo;

	private int reportLossType; // ¹ÒÊ§ÀàÐÍ (ÃÜÂë¶ªÊ§-1,¿¨¹ÒÊ§-2,Ô¿³×¶ªÊ§-3)	
	
	private int boxId; // ÏäºÅ	
	
	private String cardRfid; // ¿¨RFID	
	
	private String cardNo; // ¿¨ºÅ	
	
	private String password; // ÃÜÂë	
	
	private String keyId; // Ô¿³×ºÅ	
	
	private int paymentType; // ¸¶¿î·½Ê½	
	
	private float feeTotal; // ·ÑÓÃ×Ü¼Æ	

	public ReportLossPo() {}

	public ReportLossType getVisualReportLossType() {
		ReportLossType ret = null;
		switch (getReportLossType()) {
		case 1:
			ret = ReportLossType.PWDLOSS;
			break;
		case 2:
			ret = ReportLossType.CARDLOSS;
			break;
		case 3:
			ret = ReportLossType.KEYLOSS;
			break;
		default:
			break;
		}	
		return ret;
	}
	
	public CardPo getCardPo() {
		CardPo retCardPo = new CardPo();
		retCardPo.setCardNo(getCardNo());
		retCardPo.setCardRfid(getCardRfid());
		retCardPo.setPassword(getPassword());
		return retCardPo;
	}

	public int getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(int certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public int getReportLossType() {
		return reportLossType;
	}

	public void setReportLossType(int reportLossType) {
		this.reportLossType = reportLossType;
	}

	public int getBoxId() {
		return boxId;
	}

	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}

	public String getCardRfid() {
		return cardRfid;
	}

	public void setCardRfid(String cardRfid) {
		this.cardRfid = cardRfid;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public float getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(float feeTotal) {
		this.feeTotal = feeTotal;
	}

}
