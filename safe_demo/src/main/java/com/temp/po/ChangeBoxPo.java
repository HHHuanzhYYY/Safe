package com.temp.po;

public class ChangeBoxPo extends Po {

	private long oldBoxId; // �������	
	
	private long newBoxId; // �������	
	
	private String newKeyNo; // Կ�׺�
	
	private float amountDifference; // ��۽��	
	
	private float keyFee; // Կ�׷���	
	
	private int paymentType; // ���ʽ	
	
	private float feeTotal; // �����ܼ�
	
	public ChangeBoxPo() {}

	@Override
	public String toString() {
		return "ChangeBoxPo [oldBoxId=" + oldBoxId + ", newBoxId=" + newBoxId + ", newKeyNo=" + newKeyNo
				+ ", amountDifference=" + amountDifference + ", keyFee=" + keyFee + ", paymentType=" + paymentType
				+ ", feeTotal=" + feeTotal + "]";
	}

	public long getOldBoxId() {
		return oldBoxId;
	}

	public void setOldBoxId(long oldBoxId) {
		this.oldBoxId = oldBoxId;
	}

	public long getNewBoxId() {
		return newBoxId;
	}

	public void setNewBoxId(long newBoxId) {
		this.newBoxId = newBoxId;
	}

	public String getNewKeyNo() {
		return newKeyNo;
	}

	public void setNewKeyNo(String newKeyNo) {
		this.newKeyNo = newKeyNo;
	}

	public float getAmountDifference() {
		return amountDifference;
	}

	public void setAmountDifference(float amountDifference) {
		this.amountDifference = amountDifference;
	}

	public float getKeyFee() {
		return keyFee;
	}

	public void setKeyFee(float keyFee) {
		this.keyFee = keyFee;
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
