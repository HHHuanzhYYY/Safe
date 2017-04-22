package com.temp.po;

public class ReportLossPo extends Po {
	
	private long reportlossId;
	
	private long boxId; //涉及的箱子号

	private int reportLossType; //挂失类型 (密码丢失-1,卡挂失-2,钥匙丢失-4,卡和密码丢失-3，钥匙和密码丢失-5，钥匙和卡丢失-6，钥匙、卡和密码丢失-7)
	
	private String cardRfid; // 旧卡RFID	
	private String cardNo;   // 旧卡号
	private String password; // 旧卡密码
	
	private String newCardRfid;     // 新卡RFID
	private String newCardNo;       // 新卡卡号
	private String newCardPassword; // 新卡密码
	
	private long keyNo; // 箱子对应的钥匙号
	
	private int paymentType;
	
	private float feeTotal;

	public ReportLossPo() {}

	@Override
	public String toString() {
		return "ReportLossPo [reportlossId=" + reportlossId + ", boxId=" + boxId + ", reportLossType=" + reportLossType
				+ ", cardRfid=" + cardRfid + ", cardNo=" + cardNo + ", password=" + password + ", newCardRfid="
				+ newCardRfid + ", newCardNo=" + newCardNo + ", newCardPassword=" + newCardPassword + ", keyNo=" + keyNo
				+ ", paymentType=" + paymentType + ", feeTotal=" + feeTotal + "]";
	}

	public CardPo getCardPo() {
		CardPo retCardPo = new CardPo();
		retCardPo.setCardNo(getCardNo());
		retCardPo.setCardRfid(getCardRfid());
		retCardPo.setPassword(getPassword());
		return retCardPo;
	}

	public long getReportlossId() {
		return reportlossId;
	}

	public void setReportlossId(long reportlossId) {
		this.reportlossId = reportlossId;
	}

	public long getBoxId() {
		return boxId;
	}

	public void setBoxId(long boxId) {
		this.boxId = boxId;
	}

	public int getReportLossType() {
		return reportLossType;
	}

	public void setReportLossType(int reportLossType) {
		this.reportLossType = reportLossType;
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

	public String getNewCardRfid() {
		return newCardRfid;
	}

	public void setNewCardRfid(String newCardRfid) {
		this.newCardRfid = newCardRfid;
	}

	public String getNewCardNo() {
		return newCardNo;
	}

	public void setNewCardNo(String newCardNo) {
		this.newCardNo = newCardNo;
	}

	public String getNewCardPassword() {
		return newCardPassword;
	}

	public void setNewCardPassword(String newCardPassword) {
		this.newCardPassword = newCardPassword;
	}

	public long getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(long keyNo) {
		this.keyNo = keyNo;
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
