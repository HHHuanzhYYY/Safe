package com.temp.service;

import java.util.Calendar;
import java.util.Date;

import com.temp.util.DateTimeUtil;

public interface RentService {

	/**
	 * calculateOverdueFine.(overdueFine = rentDay * overdueDays * overdueFineStrategy)
	 * 
	 * @param rent rentDay/rentMonth/rentYear
	 * @param overdueFineStrategy
	 * @return float
	 */
	default float calculateOverdueFine(final float rentDay, final Date endDate, final float overdueFineStrategy) {
		int overdueDays = DateTimeUtil.daysBetween2Date(endDate, new Date());
		return rentDay * overdueDays * overdueFineStrategy;
	}
	
	/**
	 * calculateOverdueRent.(overdueRent = rentDay * (currentDate - endDate))
	 * 
	 * @param endDate
	 * @param rentDay
	 * @return float
	 */
	default float calculateOverdueRent(final Date endDate, final float rentDay) {
		int overdueDays = DateTimeUtil.daysBetween2Date(endDate, new Date());
		float overdueRent = 0;
		if (overdueDays > 0) {
			overdueRent = overdueDays * rentDay;
		}
		return overdueRent;
	}
	
	/**
	 * calculateRent.
	 * 
	 * @param rent
	 * @param beginDate
	 * @param endDate
	 * @return float
	 */
	default float calculateRent(final float actualRent, final Date startDate, final Date endDate, 
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
	
	/**
	 * getBoxReletInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getBoxReletInfo(final String rawData);
	
	/**
	 * setBoxReletInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setBoxReletInfo(final String rawData);
	
	/**
	 * getBoxUnrentInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String getBoxUnrentInfo(final String rawData);
	
	/**
	 * setBoxUnrentInfo.
	 * 
	 * @param rawData String from HttpRequest
	 * @return JSON String Contains Account Info.
	 */
	String setBoxOffleaseInfo(final String rawData);
	
}
