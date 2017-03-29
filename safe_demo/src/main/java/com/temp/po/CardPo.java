package com.temp.po;

public class CardPo extends Po {

	private int cardType;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int validateType;
	
	private String password;
	
	private String fingerPwd;
	
	private String reserveFingerPwd;
	
	private String accountId;
	
	private long customerId;

	public CardPo() {}

	@Override
	public String toString() {
		return "CardPo [cardType=" + cardType + ", cardRfid=" + cardRfid + ", cardNo=" + cardNo + ", validateType="
				+ validateType + ", password=" + password + ", fingerPwd=" + fingerPwd + ", reserveFingerPwd="
				+ reserveFingerPwd + ", accountId=" + accountId + ", customerId=" + customerId + "]";
	}

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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
