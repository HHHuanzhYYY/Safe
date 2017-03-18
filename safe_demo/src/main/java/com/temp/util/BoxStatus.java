package com.temp.util;

public enum BoxStatus {
	
	EMPTY(0),  // 0:空箱
	
	INRENT(1), // 1:在租
	
	FREEZE(2), // 2:冻结
	
	REPORTLOSS(3), // 3:挂失
	
	RESERVED(4), // 4:预留
	
	BROKEN(5), // 5:坏箱
	
	COORDINATEERROR(6), // 6:箱子坐标错误
	
	NOBOX(7), // 7:无箱子
	
	CHANGED_BUT_NOWNORMAL(8); // 8:换过箱子，现在正常使用

	private BoxStatus(int v) {
		this.value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}
}
