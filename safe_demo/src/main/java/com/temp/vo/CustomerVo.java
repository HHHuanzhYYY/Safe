package com.temp.vo;

public class CustomerVo extends Vo {
	
	private String customerName;
	
	private int customerSex; 
	
	private int certificateType;
	
	private String certificateNo;
	
	private String mobile;
	
	private int cardType;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int cardStatus;
	
	public CustomerVo() {}

	@Override
	public String toString() {
		return "CustomerVo [customerName=" + customerName + ", customerSex=" + customerSex + ", certificateType="
				+ certificateType + ", certificateNo=" + certificateNo + ", mobile=" + mobile + ", cardType=" + cardType
				+ ", cardRfid=" + cardRfid + ", cardNo=" + cardNo + ", cardStatus=" + cardStatus + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(int customerSex) {
		this.customerSex = customerSex;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public int getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}
	
}
