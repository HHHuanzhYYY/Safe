package com.temp.temp;

public class Card {
	
	private int CardRfid;
	
	private String CardNum;
	
	private int CardType;
	
	private int ValidateType;
	
	private String Password;
	
	private String FingerPwd;
	
	private String ReserveFingerPwd;
	
	private int CardStatus;
	
	private int BoxId;
	
	private int CustomerId;

	public int getCardRfid() {
		return CardRfid;
	}

	public void setCardRfid(int cardRfid) {
		CardRfid = cardRfid;
	}

	public String getCardNum() {
		return CardNum;
	}

	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}

	public int getCardType() {
		return CardType;
	}

	public void setCardType(int cardType) {
		CardType = cardType;
	}

	public int getValidateType() {
		return ValidateType;
	}

	public void setValidateType(int validateType) {
		ValidateType = validateType;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFingerPwd() {
		return FingerPwd;
	}

	public void setFingerPwd(String fingerPwd) {
		FingerPwd = fingerPwd;
	}

	public String getReserveFingerPwd() {
		return ReserveFingerPwd;
	}

	public void setReserveFingerPwd(String reserveFingerPwd) {
		ReserveFingerPwd = reserveFingerPwd;
	}

	public int getCardStatus() {
		return CardStatus;
	}

	public void setCardStatus(int cardStatus) {
		CardStatus = cardStatus;
	}

	public int getBoxId() {
		return BoxId;
	}

	public void setBoxId(int boxId) {
		BoxId = boxId;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
}
