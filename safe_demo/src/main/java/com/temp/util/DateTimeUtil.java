package com.temp.util;

import java.util.Calendar;
import java.util.Date;

public final class DateTimeUtil {

	public static int daysBetween2Date(final Date begin, final Date end) {
		Calendar aCalendar = Calendar.getInstance();
		
	    aCalendar.setTime(begin);
	    int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
	    aCalendar.setTime(end);
	    int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
	    
	    return day2 - day1;
	}
}
