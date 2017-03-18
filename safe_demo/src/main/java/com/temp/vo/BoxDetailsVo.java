package com.temp.vo;

public class BoxDetailsVo extends Vo {

	private int boxId; // Ïä×ÓID
	
	private String boxModel; // ÏäÐÍ
	
	private String remark; // ±¸×¢

	public BoxDetailsVo() {}

	@Override
	public String toString() {
		return "BoxDetailsVo [boxId=" + boxId + ", boxModel=" + boxModel + ", remark=" + remark + "]";
	}

	public int getBoxId() {
		return boxId;
	}

	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}

	public String getBoxModel() {
		return boxModel;
	}

	public void setBoxModel(String boxModel) {
		this.boxModel = boxModel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
