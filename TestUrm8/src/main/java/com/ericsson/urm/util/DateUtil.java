package com.ericsson.urm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.ericsson.urm.StringConstants;

public abstract class DateUtil {
	private static Date date = new Date();
	
	private static Map<Integer, Date> savingsToSolarDateCache = new HashMap<Integer, Date>();
	private static Map<Integer, Date> solarToSavingsDateCache =  new HashMap<Integer, Date>();
	
	private static Map<Integer, Date> giorni23H = new HashMap<Integer, Date>(); //anno,giorno da 23 h
	private static Map<Integer, Date> giorni25H = new HashMap<Integer, Date>(); //anno,giorno da 25 h
	
	private static final String DEF_TZ_NAME = "Europe/Rome";
	public static final long MILLIS_IN_HOUR = 60 * 60 * 1000;
	
	
	public static Date getCurrentDate() {
		date = new Date();
		return date;
	}
	
	public static Date getNextDay(Date d, boolean preserveTime) {
		if (d == null)
			throw new IllegalArgumentException();
		Calendar cal = new GregorianCalendar();
		if ( ! preserveTime) 
			cal.setTime(azzeraHHMMSS(d));
		else
			cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	public static Date getDay23Hours(int year) {
		if ( ! giorni23H.containsKey(year)) {
			giorni23H.put(year, TZUtil.calculate(TimeZone.getTimeZone(DEF_TZ_NAME), year, true).getDayBeginDST());
		}
		return new Date(giorni23H.get(year).getTime());
	}
	
	public static Date getDay25Hours(int year) {
		if ( ! giorni25H.containsKey(year)) {
			giorni25H.put(year, TZUtil.calculate(TimeZone.getTimeZone(DEF_TZ_NAME), year, true).getDayEndDST());
		}
		return new Date(giorni25H.get(year).getTime());
	}
	
	public static int getYear(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getDayFromDate(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonthFromDate(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.MONTH);
	}
	
	public static int getPreviousMonth(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		cal.add(Calendar.MONTH, -1);
		return cal.get(Calendar.MONTH);
	}
	
	public static Date azzeraHHMMSS(Date d) {
		Date result = null;
		if (d != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(d);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			result = cal.getTime();
		}
		return result;
	}
	
	public static Calendar getCalendarWithAmountOffset(Date d, int field, int amount) {
		Calendar cal = null;
		if (d != null) {
			cal = getOnlyDateAsCalendar(d);
			cal.add(field, amount);
		}
		return cal;
	}
	
	public static Date getDateWithOffset(Date d, int field, int amount) {
		
		Calendar cal = getCalendarWithAmountOffset(d, field, amount);
		return cal.getTime();
	}
	
	public static int computeElapsingDays(Date from, Date to) throws IllegalArgumentException{
		if (from == null || to == null)
			throw new IllegalArgumentException("Both dates must be not null");
		
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(azzeraHHMMSS(from));
		
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(azzeraHHMMSS(to));
		
		if (cal1.getTimeInMillis() > cal2.getTimeInMillis())
			throw new IllegalArgumentException("'from' date (" + from + ") cannot be greater than 'to' date (" + to + ")");
		
		int diff = 0;
		while (cal1.getTimeInMillis() < cal2.getTimeInMillis()) {
			cal1.add(Calendar.DAY_OF_YEAR, 1);
			diff++;
		}
		
		return diff;
	}
	
	public static int getDateDos(Calendar cal) {

		int year = cal.get(Calendar.YEAR);
		int month = 1 + cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		int result = (year % 100) << 9;
		result |= (month & 0x0f) << 5;
		result |= (day & 0x1f);
		
		return result;
	}	
	
	public static int getDateDos(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		return getDateDos(cal);
	}
	
	public static Calendar getOnlyCurrentDateAsCalendar() {
		Calendar cal = new GregorianCalendar();	
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	public static Calendar getOnlyDateAsCalendar(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	public static Calendar getOnlyDateAsCalendar(Calendar cal) {	
		return getOnlyDateAsCalendar(cal.getTime());
	}
	
	public static String formatDate(Date date, String format) {
		ArgumentsCheckerUtil.checkNull(date);
		ArgumentsCheckerUtil.checkNull(format);
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		
		return formatter.format(date);
	}
	
	public static Date parseDate(String strDate, String format) {
		ArgumentsCheckerUtil.checkNull(strDate);
		ArgumentsCheckerUtil.checkNull(format);
		
		String trimmed = strDate.trim();
		
		if (trimmed.length()!=format.length())
			throw new IllegalArgumentException("Wrong format it must be:"+format+" instead you passed:"+trimmed);
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			return formatter.parse(trimmed);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Wrong format it must be:"+format+" instead you passed:"+trimmed);
		}
	}
	
	public static Date parseXMLDate(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_XML);
	}
	
	public static String formatXMLDate(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_XML);
	}
	
	public static Date parseXMLDateTime(String strDate) {
		return parseDate(strDate,StringConstants.DATETIME_FORMAT_XML);
	}
	
	public static String formatXMLDateTime(Date date) {
		return formatDate(date,StringConstants.DATETIME_FORMAT_XML);
	}
	
	public static Date parseDate(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT);
	}
	
	public static String formatDate(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT);
	}
	
	public static String formatDate() {
		return formatDate(date,StringConstants.DATE_FORMAT);
	}
	
	public static Date parseLongDate(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_LONG);
	}
	
	public static String formatLongDate(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_LONG);
	}
	
	public static String formatLongDate() {
		return formatDate(date,StringConstants.DATE_FORMAT_LONG);
	}
	
	public static Date parseDateYYMMDD(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_YYMMDD);
	}
	
	public static String formatDateYYMMDD(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_YYMMDD);
	}
	
	public static String formatDateYYMMDD() {
		return formatDate(date,StringConstants.DATE_FORMAT_YYMMDD);
	}
	
	public static Date parseDate_Month_Day(String strDate) {
		return parseDate(strDate,StringConstants.DATE_MONTH_DAY);
	}
	
	public static String formatDate_Month_Day(Date date) {
		return formatDate(date,StringConstants.DATE_MONTH_DAY);
	}
	
	public static Date parseDate_Month_M_Day(String strDate) {
		return parseDate(strDate,StringConstants.DATE_MONTH_M_DAY);
	}
	
	public static String formatDate_Month_M_Day(Date date) {
		return formatDate(date,StringConstants.DATE_MONTH_M_DAY);
	}
	
	public static Date parseDateView(String strDate) {
		return parseDate(strDate,StringConstants.DATE_VIEW);
	}
	
	public static String formatDateView(Date date) {
		return formatDate(date,StringConstants.DATE_VIEW);
	}
	
	public static Date parseDateFile(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_FILE);
	}
	
	public static String formatDateFile(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_FILE);
	}
	
	public static String formatDateFile() {
		return formatDate(date,StringConstants.DATE_FORMAT_FILE);
	}
	
	public static Date parseDateMsec(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_MSEC);
	}
	
	public static String formatDateMsec(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_MSEC);
	}
	
	public static String formatDateMsec() {
		return formatDate(date,StringConstants.DATE_FORMAT_MSEC);
	}
	
	public static Date parseDateMsec2(String strDate) {
		return parseDate(strDate,StringConstants.DATE_FORMAT_MSEC2);
	}
	
	public static String formatDateMsec2(Date date) {
		return formatDate(date,StringConstants.DATE_FORMAT_MSEC2);
	}
	
	public static String formatDateMsec2() {
		return formatDate(date,StringConstants.DATE_FORMAT_MSEC2);
	}

	public static Date parseDateHourMinute(String strDate) {
		return parseDate(strDate,StringConstants.TIME_FORMAT3);
	}

	public static String formatDateHourMinute(Date date) {
		return formatDate(date,StringConstants.TIME_FORMAT3);
	}
	
	public static String formatDateHourMinuteSecond(Date date) {
		return formatDate(date,StringConstants.TIME_FORMAT4);
	}
	
	public static Date getLastPreviousPeriod(Date date) {
		Calendar cal = new GregorianCalendar();
		if(date!=null) {
			cal.setTime(date);
		}
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		return cal.getTime();
	}
	
	public static int getLastDayOfMonth(Date date) {
		Calendar cal = new GregorianCalendar();
		if(date!=null) {
			cal.setTime(date);
		}
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.MONTH,1);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
		
	public static int getLastDayOfMonth(Calendar cal) {
		return getLastDayOfMonth(cal.getTime());
	}
	
	public static Date getLastDayOfMonth(int year, int month) {
		if(month<1 || month>12) {
			throw new IllegalArgumentException("Invalid month:"+month+"; valid:1-12");
		}
		
		Calendar cal = new GregorianCalendar();
		
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, month-1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH,-1);
			
		return cal.getTime();
	}
	
	public static boolean isDate1AfterDate2(Date date1, Date date2){
		boolean ret = false;
		
		GregorianCalendar gcDate1 = new GregorianCalendar();
		gcDate1.set(Calendar.HOUR_OF_DAY, 0);
		gcDate1.set(Calendar.MINUTE, 0);
		gcDate1.set(Calendar.SECOND, 0);
		gcDate1.set(Calendar.MILLISECOND, 0);
		
		GregorianCalendar gcDate2 = new GregorianCalendar();
		gcDate2.set(Calendar.HOUR_OF_DAY, 0);
		gcDate2.set(Calendar.MINUTE, 0);
		gcDate2.set(Calendar.SECOND, 0);
		gcDate2.set(Calendar.MILLISECOND, 0);
		
		gcDate1.setTime(date1);
		gcDate2.setTime(date2);
		
		if(gcDate1.after(gcDate2)){
			ret = true;
		}
		
		return ret;
	}
	
	public static boolean isDate1BeforeDate2(Date date1, Date date2){
		boolean ret = false;
		
		GregorianCalendar gcDate1 = new GregorianCalendar();
		gcDate1.set(Calendar.HOUR_OF_DAY, 0);
		gcDate1.set(Calendar.MINUTE, 0);
		gcDate1.set(Calendar.SECOND, 0);
		gcDate1.set(Calendar.MILLISECOND, 0);
		
		GregorianCalendar gcDate2 = new GregorianCalendar();
		gcDate2.set(Calendar.HOUR_OF_DAY, 0);
		gcDate2.set(Calendar.MINUTE, 0);
		gcDate2.set(Calendar.SECOND, 0);
		gcDate2.set(Calendar.MILLISECOND, 0);
		
		gcDate1.setTime(date1);
		gcDate2.setTime(date2);
		
		if(gcDate1.before(gcDate2)){
			ret = true;
		}
		
		return ret;
	}
	
	public static boolean isDate1EqualToDate2(Date date1, Date date2){
	
		ArgumentsCheckerUtil.checkNull(date1,"date1");
		ArgumentsCheckerUtil.checkNull(date2,"date2");
		
		Calendar gcDate1 = getOnlyDateAsCalendar(date1);
		Calendar gcDate2 = getOnlyDateAsCalendar(date2);
		
		return gcDate1.equals(gcDate2);
	}
	
	public static int compareDateToNumDaysAgo(Date date, int days) {
		if (date == null)
			throw new IllegalArgumentException("Date cannot be null");

		Calendar cal1 = DateUtil.getOnlyCurrentDateAsCalendar();
		cal1.add(GregorianCalendar.DAY_OF_MONTH, -days);

		Calendar cal = DateUtil.getOnlyDateAsCalendar(date);

		if (cal.getTimeInMillis() < cal1.getTimeInMillis())
			return -1;
		else if (cal.getTimeInMillis() > cal1.getTimeInMillis())
			return 1;
		else
			return 0;
	}
	
	public static int getPreviousWeekOfYear(Date date, int week){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		cal.add(GregorianCalendar.WEEK_OF_YEAR, -1 -week );		
		return cal.get(GregorianCalendar.WEEK_OF_YEAR);
	}
	
	public static Date getPrevioustDayOfWeek(Date date, int week){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.WEEK_OF_YEAR, -1 -week );
		int min = cal.getFirstDayOfWeek();	    
	    cal.set(GregorianCalendar.DAY_OF_WEEK,min);
		cal.set(GregorianCalendar.HOUR_OF_DAY,0);
		cal.set(GregorianCalendar.MINUTE,0);
		cal.set(GregorianCalendar.SECOND,0);
		cal.set(GregorianCalendar.MILLISECOND,0);
		return cal.getTime();
	}
		
	public static Date addDays(Date in, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(in);
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();
	}
	
	public static Date getPreviousDayOfYear(Date date){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);			
		
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}
	
	public static Date getFirstDayOfMonth(Date date){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);	
		cal.set(Calendar.MILLISECOND, 0);
		
		cal.set(GregorianCalendar.DAY_OF_MONTH, cal.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
		
		return cal.getTime();
	}
	
	public static Date getFirstDateOfPreviousMonth(Date date) {
		return getDatePreviousMonth(getFirstDayOfMonth(date));
	}
	
	public static int getCurrentDayOfMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public static Date getCurrentDayOfMonthByDay(Date dt, int dd) {
		GregorianCalendar cal= new GregorianCalendar();
		cal.setTime(dt);
		cal.set(Calendar.DAY_OF_MONTH, dd);

		return cal.getTime();
	}
	
	public static Date getPreviousDayOfYear(Date in, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(in);
		cal.add(Calendar.DAY_OF_YEAR, -days);
		return cal.getTime();
	}
	
	/**
	 * Metodo che restituisce la data di cambio da ora legale a ora solare per l'anno
	 * passato come parametro, metodo non ricalcola ogni volta la data ma la conserva nella cache. 
	 * 
	 * @return
	 */
	public static synchronized Date getSavingsToSolarDate(int year) {
		
				GregorianCalendar cal = new GregorianCalendar();
		Date savingsToSolarDate=savingsToSolarDateCache.get(year);

		if (savingsToSolarDate == null ) {
			TimeZone tz = TimeZone.getDefault();

			cal.setLenient(false);
			cal.set(Calendar.DAY_OF_YEAR, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			/*
			 * L'algoritmo è questo: prima si scorre il calendario fino ad
			 * arrivare al periodo di ora legale poi si continua a scorrere fino
			 * ad arrivare al periodo di ora solare e questa è la data
			 */

			boolean flag1 = tz.inDaylightTime(cal.getTime());
			while (!flag1) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				flag1 = tz.inDaylightTime(cal.getTime());
			}

			flag1 = tz.inDaylightTime(cal.getTime());
			// mi devo fermare quando esco da periodo di ora legale
			while (flag1) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				flag1 = tz.inDaylightTime(cal.getTime());
			}

			// il giorno prima della data calcolata è eella dell'effettivo
			// cambiamento
			cal.add(Calendar.DAY_OF_YEAR, -1);
			savingsToSolarDate = cal.getTime();
			savingsToSolarDateCache.put(year, savingsToSolarDate);
		}
		return savingsToSolarDate;

	}

	/**
	 * Metodo che retituisce la data di cambiamento da ora solare a ora legale per l'anno passato come parametro.
	 * Il metodo non ricalcola ogni volta il valore ma conserva in una mappa di cache i valori calcolato in modo
	 * da restituirli nella successiva richiesta.
	 * @param year
	 * @return
	 */
	public static synchronized Date getSolarToSavingsDate(int year) {
		
		GregorianCalendar cal = new GregorianCalendar();
		Date solarToSavingsDate=solarToSavingsDateCache.get(year);

		if (solarToSavingsDate == null ) {
			TimeZone tz = TimeZone.getDefault();

			cal.setLenient(false);
			cal.set(Calendar.DAY_OF_YEAR, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			/*
			 * L'algoritmo è questo: prima si scorre il calendario fino ad
			 * arrivare al periodo di ora solare poi si continua a scorrere fino
			 * ad arrivare al periodo di ora solare e questa è la data
			 * 
			 * tz.inDaylightTime(date)=true se siamo in ora legale, false se
			 * siamo in ora solare
			 */

			boolean solar = !tz.inDaylightTime(cal.getTime());
			while (!solar) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				solar = !tz.inDaylightTime(cal.getTime());
			}

			solar = !tz.inDaylightTime(cal.getTime());
			// mi devo fermare quando esco dal periodo di ora solare
			while (solar) {
				cal.add(Calendar.DAY_OF_YEAR, 1);
				solar = !tz.inDaylightTime(cal.getTime());
			}

			// il giorno prima della data calcolata è eella dell'effettivo
			// cambiamento
			cal.add(Calendar.DAY_OF_YEAR, -1);

			solarToSavingsDate = cal.getTime();
			solarToSavingsDateCache.put(year, solarToSavingsDate);
		}
		return solarToSavingsDate;

	}

	/**
	 * Metodo che verifica se la data passata come paramero è la data di passagio dall'ora legale alla solare
	 * per l'anno corrente.
	 * @param dt
	 * @return
	 */
	public static boolean isSummerToSolarTimeChange(Date dt) {

		
		GregorianCalendar cal= new GregorianCalendar();
		cal.setTime(dt);
		Date change = getSavingsToSolarDate(cal.get(Calendar.YEAR));
		SimpleDateFormat formatter = new SimpleDateFormat(StringConstants.DATE_FORMAT);
		String app1 = formatter.format(change);
		String app2 = formatter.format(dt);
		return app1.equals(app2);
	}
	/**
	 * Metodo che verifica se la data passata come paramero è la data di passagio dall'ora solare all'ora legale
	 * per l'anno corrente.
	 * @param dt
	 * @return
	 */
	public static boolean isSolarToSummerTimeChange(Date dt) {

		
		GregorianCalendar cal= new GregorianCalendar();
		cal.setTime(dt);		
		Date change = getSolarToSavingsDate(cal.get(Calendar.YEAR));
		SimpleDateFormat formatter = new SimpleDateFormat(StringConstants.DATE_FORMAT);
		String app1 = formatter.format(change);
		String app2 = formatter.format(dt);
		return app1.equals(app2);
	}
	
	public static Date getDatePreviousMonth(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		cal.add(Calendar.MONTH, -1);
		cal.set(GregorianCalendar.DAY_OF_MONTH, cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		cal.set(GregorianCalendar.HOUR_OF_DAY,0);
		cal.set(GregorianCalendar.MINUTE,0);
		cal.set(GregorianCalendar.SECOND,0);
		cal.set(GregorianCalendar.MILLISECOND,0);
		
		return cal.getTime();
	}
	
   
	
	public static Date getLastDateOfMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		
		return cal.getTime();
	}
	
	public static int computeDifferenceDateInMinutes(Date date1, Date date2) throws IllegalArgumentException{
		if (date1 == null || date2 == null)
			throw new IllegalArgumentException("Both dates must be not null");
		
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
	
		
		long diff = cal1.getTimeInMillis() - cal2.getTimeInMillis();
		int minuti = (int)Math.abs(diff/60000);
		return minuti;
	}
	
	public static String convertOracleSqlFormat(String oracleFormat) throws IllegalArgumentException{
		String result = oracleFormat.replaceAll("(?i)(A\\.{0,1}D\\.{0,1})", "G")
				.replaceAll("(?i)(A\\.{0,1}M\\.{0,1})", "a")
				.replaceAll("(?i)(B\\.{0,1}C\\.{0,1})", "G")
				.replaceAll("(?i)IW", "w")
				.replaceAll("(?i)WW", "w")
				.replaceAll("(?i)W", "W")
				.replaceAll("(?i)DAY", "E")
	            .replaceAll("(?i)DD", "dd")
				.replaceAll("(?i)D", "u")
				.replaceAll("(?i)YYYY", "yyyy")
	            .replaceAll("(?i)YY", "yy")
	            .replaceAll("(?i)HH24", "hh")
	            .replaceAll("(?i)HH12", "h")
	            .replaceAll("(?i)MI", "mm")
	            .replaceAll("(?i)SS", "ss")
	            .replaceAll("(?i)FF[0-9]*", "SSS");
		return result;
	}
	
	public static Date toDateViaInstant(LocalDate dateToConvert) {
	    return Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date toDateViaInstant(LocalDateTime dateToConvert) {
	    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate toLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	public static LocalDateTime toLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public static String format(LocalDate dateToConvert, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

		return dateToConvert.format(formatter);
	}
	
	public static String format(LocalDateTime dateToConvert, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

		return dateToConvert.format(formatter);
	}
	
	public static String format(Date dateToConvert, String format) {
		return formatDate(dateToConvert, format);
	}
	
	public static LocalDate parseToLocalDate(String dateToConvert, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

		return LocalDate.parse(dateToConvert, formatter);
	}
	
	public static LocalDateTime parseToLocalDateTime(String dateTimeToConvert, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

		return LocalDateTime.parse(dateTimeToConvert, formatter);
	}
}
	
