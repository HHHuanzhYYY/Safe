package com.temp.po;

public class BoxModelPo extends Po {

	private String boxModel; // 箱型名称
	
	private float deposit; // 箱型押金
	
	private float rentYear; // 年租金
	
	private float rentMonth; // 月租金
	
	private float rentDay; // 日租金
	
	private float boxLength; // 箱型长度
	
	private float boxWidth; // 箱型宽度
	
	private float boxHeight; // 箱型深度
	
	public BoxModelPo() {}

	@Override
	public String toString() {
		return "BoxModelVo [boxModel=" + boxModel + ", deposit=" + deposit + ", rentYear=" + rentYear + ", rentMonth="
				+ rentMonth + ", rentDay=" + rentDay + ", boxLength=" + boxLength + ", boxWidth=" + boxWidth
				+ ", boxHeight=" + boxHeight + "]";
	}

	public String getBoxModel() {
		return boxModel;
	}

	public void setBoxModel(String boxModel) {
		this.boxModel = boxModel;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getRentYear() {
		return rentYear;
	}

	public void setRentYear(float rentYear) {
		this.rentYear = rentYear;
	}

	public float getRentMonth() {
		return rentMonth;
	}

	public void setRentMonth(float rentMonth) {
		this.rentMonth = rentMonth;
	}

	public float getRentDay() {
		return rentDay;
	}

	public void setRentDay(float rentDay) {
		this.rentDay = rentDay;
	}

	public float getBoxLength() {
		return boxLength;
	}

	public void setBoxLength(float boxLength) {
		this.boxLength = boxLength;
	}

	public float getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(float boxWidth) {
		this.boxWidth = boxWidth;
	}

	public float getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(float boxHeight) {
		this.boxHeight = boxHeight;
	}

}
