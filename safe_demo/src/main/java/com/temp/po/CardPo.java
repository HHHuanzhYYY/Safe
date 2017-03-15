package com.temp.po;

public class CardPo extends Po {

	private int cardType;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int validateType;
	
	private String password;
	
	private String fingerPwd;
	
	private String reserveFingerPwd;

	public CardPo() {}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
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

	public int getValidateType() {
		return validateType;
	}

	public void setValidateType(int validateType) {
		this.validateType = validateType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFingerPwd() {
		return fingerPwd;
	}

	public void setFingerPwd(String fingerPwd) {
		this.fingerPwd = fingerPwd;
	}

	public String getReserveFingerPwd() {
		return reserveFingerPwd;
	}

	public void setReserveFingerPwd(String reserveFingerPwd) {
		this.reserveFingerPwd = reserveFingerPwd;
	}
}
