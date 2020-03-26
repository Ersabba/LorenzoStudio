package com.ericsson.mgre.properties;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class LoadGreBundle {
	private static Logger logger = Logger.getLogger(LoadGreBundle.class);


	public static final String getProperty(String key) {
			Locale currentLocale= new Locale(System.getProperty("language"));
			ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
			try{
				String message=messages.getString(key);
				return message;
	        } catch (Exception e) {
	            logger.error("Property \""+key+"\" not found");
	            return null;
	        }
	}
	
	public static final String getProperty(String key, Object[] arguments) {
		Locale currentLocale= new Locale(System.getProperty("language"));
		ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
		try{
			String message=messages.getString(key);
			return MessageFormat.format(message, arguments);
        } catch (Exception e) {
            logger.error("Property \""+key+"\" not found");
            return null;
        }
		
    }

}

