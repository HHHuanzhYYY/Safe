package com.temp.vo;

public class BoxFullInfoVo extends Vo {

	private long boxId; //(箱子ID)	
	
	private long boxNo; //(箱号)	
	
	private String lockId; //(锁编号)	
	
	private int status; //(箱子状态)	
	
	private String remark; //(箱子备注)	
	
	private int sideNo; //(侧号)	
	
	private int rowNo; //(行号)	
	
	private int columnNo; //(列号)	
	
	private String rowPosX; //(行坐标)	
	
	private String columnPosX; //(列坐标)	
	
	private String boxModel; //(箱型)	
	
	private long bankId; //(银行网点)	
	
	private long rentId; //(租赁号)	
	
	private long keyNo; //(钥匙号)	

	public BoxFullInfoVo() {}

	@Override
	public String toString() {
		return "BoxFullInfoVo [boxId=" + boxId + ", boxNo=" + boxNo + ", lockId=" + lockId + ", status=" + status
				+ ", remark=" + remark + ", sideNo=" + sideNo + ", rowNo=" + rowNo + ", columnNo=" + columnNo
				+ ", rowPosX=" + rowPosX + ", columnPosX=" + columnPosX + ", boxModel=" + boxModel + ", bankId="
				+ bankId + ", rentId=" + rentId + ", keyNo=" + keyNo + "]";
	}

	public long getBoxId() {
		return boxId;
	}

	public void setBoxId(long boxId) {
		this.boxId = boxId;
	}

	public long getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(long boxNo) {
		this.boxNo = boxNo;
	}

	public String getLockId() {
		return lockId;
	}

	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSideNo() {
		return sideNo;
	}

	public void setSideNo(int sideNo) {
		this.sideNo = sideNo;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

	public String getRowPosX() {
		return rowPosX;
	}

	public void setRowPosX(String rowPosX) {
		this.rowPosX = rowPosX;
	}

	public String getColumnPosX() {
		return columnPosX;
	}

	public void setColumnPosX(String columnPosX) {
		this.columnPosX = columnPosX;
	}

	public String getBoxModel() {
		return boxModel;
	}

	public void setBoxModel(String boxModel) {
		this.boxModel = boxModel;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public long getRentId() {
		return rentId;
	}

	public void setRentId(long rentId) {
		this.rentId = rentId;
	}

	public long getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(long keyNo) {
		this.keyNo = keyNo;
	}

}
