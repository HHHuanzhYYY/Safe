package com.temp.vo;

import java.util.Date;

public class BoxVo extends Vo {
	
	private long boxId;
	
	private int boxStatus;
	
	private String boxModel;
	
	private String keyNo;
	
	private float deposit;
	
	private float actualRent;
	
	// 
	//private boolean isRelet;
	
	private Date endDate;
	
	private long rentId;
	
	// Operator.
	private String operator;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int cardType;
	
	private int cardStatus;
	
	public BoxVo() {}
			
	@Override
	public String toString() {
		return "BoxVo [boxId=" + boxId + ", boxStatus=" + boxStatus + ", boxModel=" + boxModel + ", keyNo=" + keyNo
				+ ", deposit=" + deposit + ", actualRent=" + actualRent +/* ", isRelet=" + isRelet + */", endDate="
				+ endDate + ", rentId=" + rentId + ", operator=" + operator + ", cardRfid=" + cardRfid + ", cardNo="
				+ cardNo + ", cardType=" + cardType + ", cardStatus=" + cardStatus + "]";
	}

	public long getBoxId() {
		return boxId;
	}

	public void setBoxId(long boxId) {
		this.boxId = boxId;
	}

	public String getBoxModel() {
		return boxModel;
	}

	public void setBoxModel(String boxModel) {
		this.boxModel = boxModel;
	}

	public String getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getActualRent() {
		return actualRent;
	}

	public void setActualRent(float actualRent) {
		this.actualRent = actualRent;
	}

	/*public boolean isRelet() {
		return isRelet;
	}

	public void setIsRelet(boolean isRelet) {
		this.isRelet = isRelet;
	}*/

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

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getBoxStatus() {
		return boxStatus;
	}

	public void setBoxStatus(int boxStatus) {
		this.boxStatus = boxStatus;
	}

}
