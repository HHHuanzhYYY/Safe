package com.temp.po;

import com.temp.util.ReportLossType;

public class ReportLossPo extends Po {
	
	private int certificateType;
	
	private String certificateNo;

	private int reportLossType; // ��ʧ���� (���붪ʧ-1,����ʧ-2,Կ�׶�ʧ-3)	
	
	private long boxId; // ���	
	
	private String cardRfid; // ��RFID	
	
	private String cardNo; // ����	
	
	private String password; // ����	
	
	private long keyId; // Կ�׺�	
	
	private int paymentType; // ���ʽ	
	
	private float feeTotal; // �����ܼ�	

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

	public long getBoxId() {
		return boxId;
	}

	public void setBoxId(long boxId) {
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

	public long getKeyId() {
		return keyId;
	}

	public void setKeyId(long keyId) {
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
