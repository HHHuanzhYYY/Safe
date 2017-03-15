package com.temp.service;

import java.util.Date;

import com.temp.util.DateTimeUtil;

public interface RentService {

	/**
	 * calculateOverdueFine.(overdueFine = rent * overdueFineStrategy)
	 * 
	 * @param rent rentDay/rentMonth/rentYear
	 * @param overdueFineStrategy
	 * @return float
	 */
	default float calculateOverdueFine(final float rent, final float overdueFineStrategy) {
		return rent * overdueFineStrategy;
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
	default float calculateRent(final float rent, final Date beginDate, final Date endDate) {
		// todo.
		
		
		return 0;
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
	String setBoxUnrentInfo(final String rawData);
	
}
