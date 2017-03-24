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
			// 当前日期还在原有租期之内，且无续租
			retRent = rentUnit * (end - now);		
			if (endDate.before(endDateAfterRelet)) {
				// 当前日期还在原有租期之内，且至少续租一次
				retRent += rentDay * (endAfterRelet - end);
			}
		} else {
			// 当前日期已经超出原有租期，但在续租期间之内
			retRent = rentDay * (endAfterRelet - now);
		}
		
		return retRent;
	}
}
