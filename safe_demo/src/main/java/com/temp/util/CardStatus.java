package com.temp.util;

public enum CardStatus {

	NULL(0), // 0:空卡，未使用
	
	INUSE(1), // 1:使用中
	
	ORIGINAL_BUT_BOXCHANGED(2), // 2:换箱过的原卡
	
	ORIGINAL_BUT_REPORTLOSS(3), // 3:卡挂失过的原卡
	
	ORIGINAL_BUT_EVICTION(4), // 4:已经退租的卡
	
	FROZEN(5); // 5：卡已经冻结
	
	CardStatus(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

}
