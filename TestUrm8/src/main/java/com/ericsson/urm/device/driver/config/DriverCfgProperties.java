package com.ericsson.urm.device.driver.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class DriverCfgProperties {
	 private static Logger logger = Logger.getLogger(DriverCfgProperties.class);

	 private static Properties       properties = null;
	 private static long             filePropLastModified = 0;
	 private final static String     classpathResourceBundle = "com.ericsson.urm.device.driver.config.deviceDriverBundle";
	 private final static String     home = System.getProperty("urm.home");
	 
	 
	 private final static String propFileName="deviceDriver.properties";
	 private final static File   propFile = new File(home + File.separator + "config" +  File.separator + propFileName);
	
	 public static interface Keys {
		 public static interface DeviceDriverMap  {
			 public static final String PREFIX_DRIVER_CLASS            = "meterhandling.driver.{0}.class";	 
		 }
	 }
	 
	 public static class KeyValuePair {
		 public String key = null;
		 public String defaultValue = null;

		 public KeyValuePair(String key, String defaultValue) {
			 super();
			 this.key = key;
			 this.defaultValue = defaultValue;
		 }
	}
	 
	 public static String makeKey(String key, Object ... parameters) {
		 String result = null;
		 if(parameters!=null && parameters.length>0) {
			 try {
				 return MessageFormat.format(key, parameters);
			 } catch (Exception e) {
				 String err = "Make key:"+key + " failed with parameters:"+parameters;
				 logger.error(err);
				 throw new RuntimeException(err,e);
			 }
		 }
		 else {
			 result = key;
		 }
		 return result;
	 }
	 
	 
	 private static ResourceBundle getUrmBundle() {
		 Locale currentLocale = new Locale(System.getProperty("language"));
		 return ResourceBundle.getBundle(classpathResourceBundle,currentLocale);
	 }
	 
	 public synchronized static final boolean containsKeyInBundle(String key) {
		
		 return getUrmBundle().containsKey(key);
	 }
	 
	 public synchronized static String getBundleProperty(KeyValuePair keyValue) {
		 String value = keyValue != null ? getBundleProperty(keyValue.key) : null;
		 return value != null && !value.equals("") ? value : keyValue.defaultValue;
	 }
	 
	 public synchronized static final String getBundleProperty(String key) {
		 return getBundleProperty(key, null);
	 }
	 
	 public synchronized static final String getBundleProperty(String key, String defValue) {
	
		String prop = null;
		try {
			prop = getUrmBundle().getString(key);
			if(prop!=null) {
				prop = prop.trim();
			}
			
		} catch (Exception e) {
			logger.warn("Property \"" + key + "\" not found");
			prop = defValue;
		}
		return prop;
	}
	 
	public synchronized static String getProperty(String key) {
		return getProperty(key, new Object[] {});
	}

	public synchronized static String getProperty(String key, Object[] arguments) {

		 FileInputStream fis = null;
		 File f = propFile;

		 try {
			 if(properties==null || filePropLastModified != f.lastModified()) {
				 fis = new FileInputStream(f);
				 properties = new Properties();
				 properties.load(fis);
				 filePropLastModified = f.lastModified();
				 logger.debug("Loaded "+f.getAbsolutePath());
			 }
			 
			 String value = null;
			 if(key !=null) {
				 value = properties.getProperty(key);
				 if(value == null) {
					 try {
						value = getUrmBundle().getString(key);
					} catch (Exception e) {
						// not need
					}
					value = value !=null ? (arguments!=null && arguments.length>0 
										   ? MessageFormat.format(value.trim(), arguments) 
										   : value.trim()) : value;
				 }
			 } 
			 return value !=null ? value.trim() : value;

		 } catch (Exception e) {
			 logger.warn("Property \""+key+"\" not found");
			 return null;
		 }
		 finally {
			 try{ if(fis!=null) fis.close(); } catch(IOException e) { logger.error(e.toString()); }
		 }
	 }
	 
	 public synchronized static String getProperty(KeyValuePair keyValue) {
		 String value = keyValue != null ? getProperty(keyValue.key) : null;
		 return value != null && !value.equals("") ? value : keyValue.defaultValue;
	 }
	 
	 public synchronized static boolean getBooleanProperty(KeyValuePair keyValue) {
		 String value = keyValue != null ? getProperty(keyValue.key) : null;
		 return value != null && value.trim().length()>0 ? Boolean.valueOf(value).booleanValue() : Boolean.valueOf(keyValue.defaultValue);
	 }
	 
	 public synchronized static int getIntProperty(KeyValuePair keyValue) {
		 String value = keyValue != null ? getProperty(keyValue.key) : null;
		 return ( value!=null && value.trim().length()>0) ? Integer.parseInt(value.trim()) : Integer.parseInt(keyValue.defaultValue);
	 }
	 
	 public synchronized static long getLongProperty(KeyValuePair keyValue) {
		 String value = keyValue != null ? getProperty(keyValue.key) : null;
		 return ( value!=null && value.trim().length()>0) ? Long.parseLong(value.trim()) : Long.parseLong(keyValue.defaultValue);
	 }
	 
	 
	 public synchronized static String getProperty(String key, String defaultValue) {
		 String value = getProperty(key);
		 return value != null && !value.equals("") ? value : defaultValue;
	 }


	 public synchronized static boolean getBooleanProperty(String key) {
		 return Boolean.valueOf(getProperty(key)).booleanValue();
	 }
	 
	 public synchronized static boolean getBooleanProperty(String key,boolean defValue) {
		 String value = getProperty(key);
		 return value != null && value.trim().length()>0 ? Boolean.valueOf(value).booleanValue() : defValue;
	 }


	 public synchronized static int getIntProperty(String key, int defaultValue) {
		 String sValue = getProperty(key);
		 return ( sValue!=null && sValue.trim().length()>0) ? Integer.parseInt(sValue.trim()) 
				                                            : defaultValue;
	 }
	 
	 public synchronized static long getLongProperty(String key,long defaultValue) {
		 String sValue = getProperty(key);
		 return ( sValue!=null && sValue.trim().length()>0) ? Long.parseLong(sValue.trim()) 
                 : defaultValue;
	 }
	 
	 
	 public static boolean printDebug() {
	        if (getProperty("DEBUG_LOG").equals("ON")) {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
