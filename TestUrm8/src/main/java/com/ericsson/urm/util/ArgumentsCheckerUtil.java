package com.ericsson.urm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ericsson.urm.StringConstants;

public class ArgumentsCheckerUtil {

	/**
	 * Methos that checks if the string parameter passed as argument is null or
	 * empty
	 * 
	 * @param arg
	 * @throws IllegalArgumentException
	 *             if the argument is null or empty
	 */
	public static String checkString(String arg) {
		if (arg == null || arg.length()==0)
			throw new IllegalArgumentException("Not valid argument");
		
		return arg;
	}

	public static String checkString(String arg, String fieldName) {
		if (fieldName == null)
			fieldName = StringConstants.EMPTY_STRING;

		if (arg == null || arg.length()==0)
			throw new IllegalArgumentException("String " + fieldName + " not valid");
		
		return arg;
	}
	
	public static void checkRangeValue(long min, long max, long value) {
		if (value<min || value>max)
			throw new IllegalArgumentException("Out of range value:"+value+" (min="+min+",max="+max+")");
	}
	public static void checkMinValue(long min, long value) {
		if (value<min)
			throw new IllegalArgumentException("Out of range value:"+value+" (min="+min+")");
	}
	public static void checkMaxValue(long max, long value) {
		if (value>max)
			throw new IllegalArgumentException("Out of range value:"+value+" (max="+max+")");
	}

	/**
	 * Method to check if the passed parameter is null
	 * 
	 * @param arg
	 * @throws IllegalArgumentException
	 *             if the argument is null
	 */
	public static void checkNull(Object arg) {
		if (arg == null)
			throw new IllegalArgumentException("Not valid argument");
	}

	public static <T> T checkNull(T arg, String fieldname) {
		if (fieldname == null)
			fieldname = StringConstants.EMPTY_STRING;

		if (arg == null)
			throw new IllegalArgumentException("Argument " + fieldname + " not valid");
		
		return arg;
	}
	
	//
	public static String checkDeviceId(String deviceId, String paramName) {
		checkNull(deviceId, "deviceId");
		
		String descParam = "";
		if(paramName!=null) {
			descParam = "Invalid param: " + paramName+"; ";
		}
		
		if (deviceId.length() != 13)
			throw new IllegalArgumentException(descParam+"deviceId must be long 13 characters");

		for (int i = 0; i < deviceId.length(); i++) {
			if (!Character.isDigit(deviceId.charAt(i)))
				throw new IllegalArgumentException(descParam+"deviceId must only digits");
		}
		
		return deviceId;
	}

	/**
	 * Method to check the correct format yyyyMMdd of a date string
	 * 
	 * @param date
	 * @throws IllegalArgumentException
	 *             if the string is null or empty or doesn't respect the correct
	 *             format
	 * @return
	 */
	public static Date checkDateStringShortFormat(String date) {
		checkString(date);
		SimpleDateFormat formatter = new SimpleDateFormat(StringConstants.DATE_FORMAT);

		try {
			return formatter.parse(date);
		} catch (ParseException ex) {
			throw new IllegalArgumentException("Not valid date string: the valid format is " + StringConstants.DATE_FORMAT);
		}

	}

	/**
	 * Method to check the correct format yyyyMMddHHmmss of a date string
	 * 
	 * @param date
	 * @throws IllegalArgumentException
	 *             if the string is null or empty or doesn't respect the correct
	 *             format
	 * @return
	 */
	public static Date checkDateStringLongFormat(String date) {
		checkString(date);
		SimpleDateFormat formatter = new SimpleDateFormat(StringConstants.DATE_FORMAT_LONG);

		try {
			return formatter.parse(date);
		} catch (ParseException ex) {
			throw new IllegalArgumentException("Not valid date string: the valid format is " + StringConstants.DATE_FORMAT_LONG);
		}

	}

	public static void checkNumericString(String in, String fieldname) {
		if (fieldname == null)
			fieldname = StringConstants.EMPTY_STRING;
		checkNull(in, fieldname);

		char[] chars = in.toCharArray();
		boolean error = false;
		for (int i = 0; !error && i < chars.length; i++)
			error = !(Character.isDigit(chars[i]));
		if (error)
			throw new IllegalArgumentException("Field " + fieldname + " not valid numeric string");

	}
	
	public static void checkNumericString(String in, char decimalSeparator, String fieldname) {
		if (fieldname == null)
			fieldname = StringConstants.EMPTY_STRING;
		checkNull(in, fieldname);

		char[] chars = in.toCharArray();
		boolean error = false;
		boolean decimalFound=false;
		for (int i = 0; !error && i < chars.length; i++){
					error = !(Character.isDigit(chars[i]) ||(chars[i]==decimalSeparator && !decimalFound));
					decimalFound=decimalFound || (!error && chars[i]==decimalSeparator);
		}
		if (error)
			throw new IllegalArgumentException("Field " + fieldname + " not valid numeric string");

	}
	
	public static int checkIntAsString(String arg, String fieldName) {
		checkString(arg, fieldName);
		int value;
		try {
			value = Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Field " + fieldName + " not valid integer string");
		}
		return value;
	}
}
