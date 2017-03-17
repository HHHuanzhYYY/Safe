package com.temp.util;

public enum CardStatus {

	NULL(0), // 0:�տ���δʹ��
	
	INUSE(1), // 1:ʹ����
	
	ORIGINAL_BUT_BOXCHANGED(2), // 2:�������ԭ��
	
	ORIGINAL_BUT_REPORTLOSS(3), // 3:����ʧ����ԭ��
	
	ORIGINAL_BUT_EVICTION(4), // 4:�Ѿ�����Ŀ�
	
	FROZEN(5); // 5�����Ѿ�����
	
	CardStatus(int v) {
		value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

}
