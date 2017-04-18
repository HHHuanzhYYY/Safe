package com.temp.util;

import java.util.Calendar;
import java.util.Date;

public final class Utility {
	
	public final static int DEFAULT_BOXKEY_SUM = 2;

	public static AccountType classifyAccountType(int value) {
		AccountType accountType = null;
		switch (value) {
		case 0:
			accountType = AccountType.SINGLE;
			break;
		case 1:
			accountType = AccountType.ONECARDMULTIBOX;
			break;
		case 2:
			accountType = AccountType.MULTICARDMULTIBOX;
			break;
		case 3:
			accountType = AccountType.UION;
			break;
		default:
			break;
		}
		return accountType;
	}
	
	/**
	 * calculateRent.
	 * 
	 * @param rent
	 * @param beginDate
	 * @param endDate
	 * @return float
	 */
	public static float calculateRefoundRent(final float actualRent, final Date startDate, final Date endDate, 
			final Date endDateAfterRelet, final float rentDay) {
		final Calendar calendar = Calendar.getInstance();
		
		// Start.
		calendar.setTime(startDate);
		int start = calendar.get(Calendar.DAY_OF_YEAR);
		// End.
		calendar.setTime(endDate);
		int end = calendar.get(Calendar.DAY_OF_YEAR);
		
		// Unit Rent.
		float rentUnit = actualRent / (end - start);
		
		// EndAfterRelet.
		calendar.setTime(endDateAfterRelet);
		int endAfterRelet = calendar.get(Calendar.DAY_OF_YEAR);
		
		// Now.
		final Date nowDate = new Date();
		calendar.setTime(nowDate);
		int now = calendar.get(Calendar.DAY_OF_YEAR);
		
		// Calculate Rent.
		float retRent = 0;
		if (nowDate.before(endDate)) {
			// ��ǰ���ڻ���ԭ������֮�ڣ���������
			retRent = rentUnit * (end - now);		
			if (endDate.before(endDateAfterRelet)) {
				// ��ǰ���ڻ���ԭ������֮�ڣ�����������һ��
				retRent += rentDay * (endAfterRelet - end);
			}
		} else {
			// ��ǰ�����Ѿ�����ԭ�����ڣ����������ڼ�֮��
			retRent = rentDay * (endAfterRelet - now);
		}
		
		return retRent;
	}
}
