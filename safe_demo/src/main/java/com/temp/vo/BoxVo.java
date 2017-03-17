package com.temp.vo;

import java.util.Date;

public class BoxVo extends Vo {
	
	private int boxId;
	
	private int boxModel;
	
	private String keyId;
	
	private float deposit;
	
	private float rentSum;
	
	private Date endDate;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int cardType;
	
	private int cardStatus;
	
	public BoxVo() {}

	@Override
	public String toString() {
		return "BoxVo [boxId=" + boxId + ", boxModel=" + boxModel + ", keyId=" + keyId + ", deposit=" + deposit
				+ ", rentSum=" + rentSum + ", endDate=" + endDate + ", cardRfid=" + cardRfid + ", cardNo=" + cardNo
				+ ", cardType=" + cardType + ", cardStatus=" + cardStatus + "]";
	}

	public int getBoxId() {
		return boxId;
	}

	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}

	public int getBoxModel() {
		return boxModel;
	}

	public void setBoxModel(int boxModel) {
		this.boxModel = boxModel;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getRentSum() {
		return rentSum;
	}

	public void setRentSum(float rentSum) {
		this.rentSum = rentSum;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public int getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(int cardStatus) {
		this.cardStatus = cardStatus;
	}

}
