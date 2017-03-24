package com.temp.service;

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
