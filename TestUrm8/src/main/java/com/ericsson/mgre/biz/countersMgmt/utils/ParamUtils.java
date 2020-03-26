package com.ericsson.mgre.biz.countersMgmt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ParamUtils  {

    public ParamUtils() { }

    public static String nullSafeValue(String value)
    {
        if(value != null)
            return new String(value);
        else
            return null;
    }

    public static Long nullSafeValue(Long value)
    {
        if(value != null)
            return new Long(value.longValue());
        else
            return null;
    }

    public static void checkIdRel(String value)
        throws Exception
    {
        String name = "identificativo relativo";
        checkNotNull(name, value);
        checkNumeric(name, value);
        checkLength(name, value, 2, 2);
    }

    public static Integer nullSafeValue(Integer value)
    {
        if(value != null)
            return new Integer(value.intValue());
        else
            return null;
    }

    public static Date nullSafeValue(Date value)
    {
        if(value != null)
            return new Date(value.getTime());
        else
            return null;
    }

    public static void checkRange(String name, Long value, long min, long max)
        throws Exception
    {
        if(value == null)
            return;
        if(value.longValue() < min || value.longValue() > max)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve essere compreso tra " + min + " e " + max);
        else
            return;
    }

    public static void checkRange(String name, Integer value, int min, int max)
        throws Exception
    {
        if(value == null)
            return;
        if(value.longValue() < (long)min || value.longValue() > (long)max)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve essere compreso tra " + min + " e " + max);
        else
            return;
    }

    public static void checkLength(String name, String value, int minLength, int maxLength)
        throws Exception
    {
        if(value == null)
            return;
        if(value.length() < minLength || value.length() > maxLength)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve avere lunghezza compresa tra " + minLength + " e " + maxLength);
        else
            return;
    }

    public static void checkNumeric(String name, String value)
        throws Exception
    {
        if(value == null)
            return;
        for(int i = 0; i < value.length(); i++)
            if(!Character.isDigit(value.charAt(i)))
                throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve essere numerico. Carattere non valido: -" + value.charAt(i) + "-.");

    }

    public static void checkGreater(String lowName, Long lowValue, String highName, Long highValue)
        throws Exception
    {
        if(lowValue == null || highValue == null)
            return;
        if(lowValue.compareTo(highValue) >= 0)
            throw new Exception("Il valore -" + lowValue + "- non \350 valido per il parametro -" + lowName + "-. Deve essere minore del valore -" + highValue + "- del parametro -" + highName + "-.");
        else
            return;
    }

    public static void checkGreater(String lowName, Integer lowValue, String highName, Integer highValue)
        throws Exception
    {
        if(lowValue == null || highValue == null)
            return;
        if(lowValue.compareTo(highValue) >= 0)
            throw new Exception("Il valore -" + lowValue + "- non \350 valido per il parametro -" + lowName + "-. Deve essere minore del valore -" + highValue + "- del parametro -" + highName + "-.");
        else
            return;
    }

    public static void checkNotNull(String name, String value)
        throws Exception
    {
        if(value == null)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Il parametro \350 obbligatorio.");
        else
            return;
    }

    public static void checkNotNull(String name, Long value)
        throws Exception
    {
        if(value == null)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Il parametro \350 obbligatorio.");
        else
            return;
    }

    public static void checkNotNull(String name, Integer value)
        throws Exception
    {
        if(value == null)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Il parametro \350 obbligatorio.");
        else
            return;
    }

    public static void checkNotNull(String name, Date value)
        throws Exception
    {
        if(value == null)
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Il parametro \350 obbligatorio.");
        else
            return;
    }

    public static void checkPattern(String name, String value, String pattern)
        throws Exception
    {
        if(value == null)
            return;
        Pattern regExpPattern = null;
        try
        {
            regExpPattern = Pattern.compile(pattern);
        }
        catch(PatternSyntaxException pse)
        {
            throw new Exception("La struttura -" + pattern + "- non \350 valida.");
        }
        Matcher matcher = regExpPattern.matcher(value);
        if(matcher.matches())
            return;
        else
            throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve rispettare la struttura: -" + pattern + "-.");
    }

    public static int checkValueSet(String name, String value, String valueSet[])
        throws Exception
    {
        if(value == null)
            return -1;
        for(int i = 0; i < valueSet.length; i++)
            if(value.equals(valueSet[i]))
                return i;

        throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve appartenere all'insieme: " + getValueSetAsString(valueSet) + ".");
    }

    public static String getValueSetAsString(String valueSet[])
    {
        int len = valueSet.length;
        switch(len)
        {
        case 0: // '\0'
            return new String("--");

        case 1: // '\001'
            return new String("-" + valueSet[0] + "-");
        }
        StringBuffer sb = new StringBuffer("-" + valueSet[0]);
        for(int i = 1; i < len; i++)
            sb.append("," + valueSet[i]);

        sb.append("-");
        return sb.toString();
    }

    public static int checkValueSet(String name, Long value, Long valueSet[])
        throws Exception
    {
        if(value == null)
            return -1;
        for(int i = 0; i < valueSet.length; i++)
            if(value.equals(valueSet[i]))
                return i;

        throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve appartenere all'insieme: " + getValueSetAsString(valueSet) + ".");
    }

    public static String getValueSetAsString(Long valueSet[])
    {
        int len = valueSet.length;
        switch(len)
        {
        case 0: // '\0'
            return new String("--");

        case 1: // '\001'
            return new String("-" + valueSet[0] + "-");
        }
        StringBuffer sb = new StringBuffer("-" + valueSet[0]);
        for(int i = 1; i < len; i++)
            sb.append("," + valueSet[i]);

        sb.append("-");
        return sb.toString();
    }

    public static int checkValueSet(String name, Integer value, Integer valueSet[])
        throws Exception
    {
        if(value == null)
            return -1;
        for(int i = 0; i < valueSet.length; i++)
            if(value.equals(valueSet[i]))
                return i;

        throw new Exception("Il valore -" + value + "- non \350 valido per il parametro -" + name + "-. Deve appartenere all'insieme: " + getValueSetAsString(valueSet) + ".");
    }

    public static String getValueSetAsString(Integer valueSet[])
    {
        int len = valueSet.length;
        switch(len)
        {
        case 0: // '\0'
            return new String("--");

        case 1: // '\001'
            return new String("-" + valueSet[0] + "-");
        }
        StringBuffer sb = new StringBuffer("-" + valueSet[0]);
        for(int i = 1; i < len; i++)
            sb.append("," + valueSet[i]);

        sb.append("-");
        return sb.toString();
    }

    public static Date addYear(String MMdd)
        throws ParseException
    {
        Calendar today = Calendar.getInstance();
        today.add(5, -1);
        String yyyyMMdd = today.get(1) + "/" + MMdd;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.parse(yyyyMMdd);
    }

    public static void checkYyMmDd(String year, String month, String day)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        try
        {
            sdf.parse(year + month + day);
        }
        catch(ParseException pex)
        {
            throw new Exception("Il valore -" + year + month + day + "- non \350 una data valida nel formato AAAAMMGG.");
        }
    }

    public static void checkYyyyMmDd(String year, String month, String day)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try
        {
            sdf.parse(year + month + day);
        }
        catch(ParseException pex)
        {
            throw new Exception("Il valore -" + year + month + day + "- non \350 una data valida nel formato AAAAMMGG.");
        }
    }
    
    public static String dateToString(Date date, String format) {
		if(format==null) {
			format = "yyMMdd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return new String(sdf.format(date));
	}
    
    public static String dateToString(Date date) {
		return dateToString(date, null);
	}
}