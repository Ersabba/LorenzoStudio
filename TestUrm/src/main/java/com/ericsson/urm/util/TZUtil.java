package com.ericsson.urm.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

//import com.ericsson.urm.config.UrmConfig;


public abstract class TZUtil {
	
	public static class Dst {
		private TimeZone timeZone = null;
		private Date startDST = null;
		private Date endDST = null;
		
		public Dst(TimeZone timeZone, Date startDST, Date endDST) {
			this.timeZone = timeZone;
			this.startDST = startDST;
			this.endDST = endDST;
		}

		public TimeZone getTimeZone() {
			return timeZone;
		}

		public void setTimeZone(TimeZone timeZone) {
			this.timeZone = timeZone;
		}

		public Date getStartDST() {
			return startDST;
		}

		public void setStartDST(Date startDST) {
			this.startDST = startDST;
		}

		public Date getEndDST() {
			return endDST;
		}

		public void setEndDST(Date endDST) {
			this.endDST = endDST;
		}
		
		public Date getDayBeginDST() {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(startDST);
			cal.set(GregorianCalendar.HOUR_OF_DAY,0);
			cal.set(GregorianCalendar.MINUTE,0);
			cal.set(GregorianCalendar.SECOND,0);
			cal.set(GregorianCalendar.MILLISECOND,0);
			return cal.getTime();
		}
		
		public Date getDayEndDST() {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(endDST);
			cal.set(GregorianCalendar.HOUR_OF_DAY,0);
			cal.set(GregorianCalendar.MINUTE,0);
			cal.set(GregorianCalendar.SECOND,0);
			cal.set(GregorianCalendar.MILLISECOND,0);
			return cal.getTime();
		}
	}
	
	public static interface Constants {
		public static interface Keys {
			public static interface TimeZone {
				public static final String ID                    = "timezone.id";
				public static final String GMT                   = "timezone.gmt";
				public static final String START_MONTH           = "timezone.start_month";
				public static final String START_DAY             = "timezone.start_day";
				public static final String START_DAY_OF_WEEK     = "timezone.start_day_of_week";
				public static final String START_TIME            = "timezone.start_time";
				public static final String END_MONTH             = "timezone.end_month";
				public static final String END_DAY               = "timezone.end_day";
				public static final String END_DAY_OF_WEEK       = "timezone.end_day_of_week";
				public static final String END_TIME              = "timezone.end_time";
				public static final String MSEC_SAVED_DURING_DST = "timezone.msec_saved_during_dst";
			}	
		};
	}; 
	
	private static Hashtable dstMap = new Hashtable();
	
	public static TimeZone getServerTimeZone(String tzId, Integer gmt) {
		TimeZone tz = null;
		if(tzId!=null && tzId.length()>0) {
			tzId = tzId.trim();
			
			String[] availableIDs = null;
			if(gmt!=null) {
				int rawOffset = gmt.intValue() * 60000; // GMT to msec
				availableIDs = TimeZone.getAvailableIDs(rawOffset);
			}
			if(availableIDs==null) {
				availableIDs = TimeZone.getAvailableIDs();
			}
			for(int j=0; j<availableIDs.length; ++j) {
				if(availableIDs[j].equalsIgnoreCase(tzId)) {
					tz = TimeZone.getTimeZone(tzId);
					break;
				}
			}
		} 
		else {
			tz = TimeZone.getDefault();
		}
		
		return tz;
	}
	
	public static TimeZone getTimeZone() {
		TimeZone tz = null;
		/*
		String tzId = UrmConfig.getInstance().getProperty(Constants.Keys.TimeZone.ID, "Europe/Rome");
		Integer gmt = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.GMT,null);
		
		tz = getServerTimeZone(tzId, gmt);
		
		if(tz==null) {
			tz = TimeZone.getDefault();
			
			if(tzId!=null && tzId.length()>0 && gmt!=null) {
				tzId.trim();
				
				int rawOffset = gmt.intValue() * 60000;

				Integer startMonth     = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.START_MONTH,null);
				Integer startDay       = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.START_DAY,null);
				Integer startDayOfWeek = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.START_DAY_OF_WEEK,null);
				Integer startTime      = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.START_TIME,null);

				Integer endMonth     = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.END_MONTH,null);
				Integer endDay       = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.END_DAY,null);
				Integer endDayOfWeek = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.END_DAY_OF_WEEK,null);
				Integer endTime      = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.END_TIME,null);

				Integer millisSavedDuringDST = UrmConfig.getInstance().getIntProperty(Constants.Keys.TimeZone.MSEC_SAVED_DURING_DST,null);

				if(startMonth!=null && startDay!=null && startDayOfWeek!=null && startTime!=null &&
						endMonth!=null && endDay!=null && endDayOfWeek!=null && endTime!=null && millisSavedDuringDST!=null) {
					SimpleTimeZone stz = new SimpleTimeZone(rawOffset,tzId);

					stz.setStartRule(startMonth.intValue(), startDay.intValue(), startDayOfWeek.intValue(), startTime.intValue());
					stz.setEndRule(endMonth.intValue(), endDay.intValue(), endDayOfWeek.intValue(), endTime.intValue());
					stz.setDSTSavings(millisSavedDuringDST.intValue());

					tz = (TimeZone)stz;
				}
			}
		}*/

		return tz;
	}
	
	public static void freeDstMap() {
		dstMap.clear();
	}
	
	public static Dst calculate(int year) {
		return calculate(getTimeZone(), year);
	}
	
	public static Dst calculate(TimeZone tz, int year, boolean clearMap) {
		if (clearMap) {
			freeDstMap();
		}
		
		return calculate(tz, year);
	}
 
	
	public static Dst calculate(TimeZone tz, int year) {
    	
    	Dst dst = (Dst)dstMap.get(tz.getID());
    	
    	if(dst==null) {
    		final Calendar c = Calendar.getInstance(tz);
            c.setLenient(false);
            c.set(year, Calendar.JANUARY, 1, 1, 0, 0);
            c.set(Calendar.MILLISECOND, 0);

            if (tz.getDSTSavings() == 0) {
                return null;
            }

            boolean flag = false;
            Date startDst = null;
            Date endDst = null;

            do {
                Date date = c.getTime();
                boolean daylight = tz.inDaylightTime(date);

                if (daylight && !flag) {
                    flag = true;
                    startDst = date;
                }
                else if (!daylight && flag) {
                    flag = false;
                    endDst = date;
                }

                c.add(Calendar.HOUR_OF_DAY, 1);
            }
            while (c.get(Calendar.YEAR) == year);

            dst = new Dst(tz,startDst,endDst);
            
            dstMap.put(tz.getID(), dst);
    	}
    	
        return dst;
    }
   
}
