package com.temp.util;

public enum BoxStatus {
	
	EMPTY(0),  // 0:����
	
	INRENT(1), // 1:����
	
	FREEZE(2), // 2:����
	
	REPORTLOSS(3), // 3:��ʧ
	
	RESERVED(4), // 4:Ԥ��
	
	BROKEN(5), // 5:����
	
	COORDINATEERROR(6), // 6:�����������
	
	NOBOX(7), // 7:������
	
	CHANGED_BUT_NOWNORMAL(8); // 8:�������ӣ���������ʹ��

	private BoxStatus(int v) {
		this.value = v;
	}
	
	private int value;

	public int getValue() {
		return value;
	}
}
