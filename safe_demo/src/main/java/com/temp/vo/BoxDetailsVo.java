package com.temp.vo;

public class BoxDetailsVo extends Vo {

	private int boxId; // ����ID
	
	private String boxModel; // ����
	
	private String remark; // ��ע

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
