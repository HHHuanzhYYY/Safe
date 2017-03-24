package com.temp.vo;

public class BoxModelResumeVo extends Vo {

	private int boxModelNo; // œ‰–Õ±‡∫≈
	
	private String boxModel; // œ‰–Õ
	
	private String remark; // ±∏◊¢

	public BoxModelResumeVo() {}

	@Override
	public String toString() {
		return "BoxModelResumeVo [boxModelNo=" + boxModelNo + ", boxModel=" + boxModel + ", remark=" + remark + "]";
	}

	public int getBoxModelNo() {
		return boxModelNo;
	}

	public void setBoxModelNo(int boxModelNo) {
		this.boxModelNo = boxModelNo;
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
