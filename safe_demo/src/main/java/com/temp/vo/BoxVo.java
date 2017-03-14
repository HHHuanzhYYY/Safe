package com.temp.vo;

public class BoxVo extends Vo {
	
	private int boxId;
	
	private int boxModel;
	
	private String keyId;
	
	private float deposit;
	
	private float rentSum;
	
	private String endDate;
	
	private String cardRfid;
	
	private String cardNo;
	
	public BoxVo() {}

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

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

}
