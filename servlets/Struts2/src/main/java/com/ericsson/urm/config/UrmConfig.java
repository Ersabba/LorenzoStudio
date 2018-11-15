package com.ericsson.urm.config;

import com.ericsson.urm.StringConstants;
import com.ericsson.urm.util.security.CryptDecryptPassword;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrmConfig {
	
	public interface Keys {
		public static interface Locking {
			 public final String ENABLED = "locking.enabled";
			 public final String REFRESH_ENABLED = "locking.refreshEnabled";
			 public final String METERS_TIME_EXPIRED = "locking.meters.timeExpired.msec";
			 public final String METERS_WAIT_RETRIES = "locking.meters.waitRetries";
			 public final String METERS_DELAY_RETRY = "locking.meters.delayRetry.msec";
		 }
	}
	
	public class GenericKeys{
		public static final String URM_PROVIDER_URL1="server.managed1.provider_url";
		public static final String URM_PROVIDER_URL2="server.managed2.provider_url";
		
		public static final String URM_FAKE_EXTERNAL_SYSTEM="urm.fake.externalsystem";
		public static final String URM_FAKE_ID_EXTERNAL_SYSTEM="urm.fake.id_externalsystem";
//		public static final String CHARACTER_REPLACE_MAP = "character.replace.map";
		public static final String URM_XML_ENCODING = "urm.xml.encoding";
		public static final String ENVIRONMENT_TEST = "environment.test";
		// di default da la root di MDS che è comune a tutti...
		public static final String CONTEXT_WEB_APP_DEFAULT_RESOURCES  =  "context.webapp.default.resources";

	}
	
	
	public static class ModuleWebResourcesKeys{		
		public static final String GRE_ROOT = "gre.root";
		public static final String MDS_ROOT = "UrmMdsWeb.root";	// UrmMdsWeb.root.img	path esempio da costruire 		
	}
	
	
	public static interface ModuleWebResourcesTypeKeys{		 
		public static final String CONTEXT_PATH = ""; 
		public static final String IMAGES = ".img";
		public static final String SCRIPTS = ".js";
		public static final String CSS = ".css";
		public static final String JSP = ".jsp";	
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
	
	
	 private static Logger logger = Logger.getLogger(UrmConfig.class);
	 private long       filePropLastModified = 0;
	 private final      String propFileName="urm.properties";
	
	 //private Hashtable htEnv = null;
	 
	 private Properties prop = null;
	 private static UrmConfig urmConfig = null;
	 
	 private UrmConfig() {
	 }
	 
	 private String getPropFile() {
		 String home = System.getProperty("urm.home");
		 String path = home + File.separator + propFileName;
		 
		 return path;
	 }
	 
	 public synchronized static UrmConfig getInstance() {
		 if(urmConfig==null) {
			 urmConfig = new UrmConfig();
		 }
		 
		 return urmConfig;
	 }
	 
	 public synchronized long getFilePropLastModified() {
		 getProperty(null);
		 return filePropLastModified;
	 }
	 
	 public synchronized int getIntProperty(String key,int defaultValue) {
		 String value = getProperty(key);
		 if(value!=null) {
			 try {
				 return Integer.parseInt(value);
			 } catch(NumberFormatException e) {
				 logger.error(e.toString(),e);
			 }
		 }
		 return defaultValue;
	 }
	 
	 public synchronized Integer getIntProperty(String key,Integer defaultValue) {
		 String value = getProperty(key);
		 if(value!=null) {
			 try {
				 return Integer.valueOf(value);
			 } catch(NumberFormatException e) {
				 logger.error(e.toString(),e);
			 }
		 }
		 return defaultValue;
	 }
	 
	 public synchronized Long getLongProperty(String key, Long defaultValue) {
		 String value = getProperty(key);
		 if(value!=null) {
			 try {
				 return Long.valueOf(value);
			 } catch(NumberFormatException e) {
				 logger.error(e.toString(),e);
			 }
		 }
		 return defaultValue;
	 }
	 
	 public synchronized boolean getBooleanProperty(String key) {
		 return Boolean.valueOf(getProperty(key)).booleanValue();
	 }
	 
	 public synchronized boolean getBooleanProperty(String key,boolean defValue) {
		 String value = getProperty(key);
		 return value != null && value.trim().length()>0 ? Boolean.valueOf(value).booleanValue() : defValue;
	 }
	  
	 public synchronized String getProperty(String key) {
		 FileInputStream fis = null;
		 File f = null;
		 
		 try {
			 String path = getPropFile();
			 f = new File(path);
			 if(prop==null || filePropLastModified != f.lastModified()) {
				 
				 CryptDecryptPassword.getInstance().updateProperties(path);
				 
				 fis = new FileInputStream(path);
				 prop = new Properties();
				 prop.load(fis);
				 filePropLastModified = f.lastModified();
				 logger.debug("Loaded "+path);
			 }
			 
			 return key!=null ? prop.getProperty(key) : null;

		 } catch (Exception e) {
			 logger.warn(e.toString());
			 return null;
		 }
		 finally {
			 try{ if(fis!=null) fis.close(); } catch(IOException e) { logger.error(e.toString()); }
		 }
	 }
	 
	 public synchronized String getProperty(String key,String defaultValue) {
		 String value = getProperty(key);
		 // PER DEBUG !!!
		 // if(value==null || value.equals(""))
		 //	 logger.debug("default key requested= "+defaultValue);
		 // END DEBUG
		 return value!=null && !value.equals("") ? value : defaultValue;
	 }
	 
	 
	 public synchronized Properties replaceVariables(Properties prop) {
		 String key = null;
		 String value;
		 Properties newProp = new Properties();
		 Enumeration keys = prop.keys();
		 while(keys.hasMoreElements()) {
			 try {
				key = (String)keys.nextElement();
				 value = prop.getProperty(key);
				 value = replaceVar(value);
				 newProp.put(key, value);
			} catch (Exception e) {
				logger.error("replaceVariables on property key:"+key+" failed; "+e.getMessage());
			}
		 }
		 return newProp;
	 }
	 
	 
	 public synchronized String replaceVar(String value) {
		 if(value==null) {
			 return StringConstants.EMPTY_STRING;
		 }
		 
		 String tmpValue = null;
		 try {
			 tmpValue = new String(value);
			 Pattern pattern = Pattern.compile("(?<=__)(\\w*?)(?=__)");
			 Matcher matcher = pattern.matcher(tmpValue);
			 String keyEnv;
			 String replacement;

			 while (matcher.find()) {
				 keyEnv = matcher.group();
				 replacement = getProperty("urm.env."+keyEnv);
				 if(keyEnv.endsWith("_ENCRYPTED")) {
					 replacement = replacement!=null ? CryptDecryptPassword.getInstance().decrypt(replacement) : null;
					 if(replacement!=null) {
						 tmpValue = tmpValue.replaceAll("__"+keyEnv+"__", replacement);
					 } else {
						 tmpValue = null;
					 }
				 }
				 else
				 if(replacement!=null) {
					 tmpValue = tmpValue.replaceAll("__"+keyEnv+"__", replacement);
				 } else {
					 logger.error("The key:"+keyEnv+" has not been found in "+propFileName);
					 replacement = System.getProperty(keyEnv);
					 if(replacement!=null) {
						 tmpValue = tmpValue.replaceAll("__"+keyEnv+"__", replacement);
					 } else {
						 logger.error("The key:"+keyEnv+" has not been found in system properties");
					 }
				 }
			 }
		 } catch (Exception e) {
			 return value;
		 }
		 
		 if(tmpValue==null) {
			 tmpValue = StringConstants.EMPTY_STRING;
		 }

		 return tmpValue;
	 }
	 
	 public synchronized String getFirmLabel() {
		 String[] vLabels = null;
		 String label = "";
		 String labels = getProperty("firm.label.names","empty");
		 int j = 0;

		 if(labels!=null) {
			 vLabels = labels.split("[ ,;:]+");
		 }
		 if(vLabels!=null) {
			 String index = getProperty("firm.label.index","0");
			 try {
				 j = Integer.parseInt(index);
				 if(j<0) {
					 logger.warn("Into the file:"+propFileName+", the value assigned to key:firm.label.index must be a positive integer number - used: 0");
				 }
				 else if(j>=vLabels.length) {
					 logger.warn("Into the file:"+propFileName+", the value assigned to key:firm.label.index must be less then maximum number of elements in key:firm.label.names - used: 0");
				 }
			 } catch(NumberFormatException e) {
				 logger.warn("Into the file:"+propFileName+", the value assigned to key:firm.label.index must be a positive integer number - used: 0");
				 j=0;
			 }
			 label = vLabels[j];
		 }
		 
		 String labelRet = String.valueOf(label.toLowerCase()+getTestEnv()).trim();		
		 return labelRet;
	 }
	 
	
	public synchronized String getWebAppPathResources(String contextPath, String typeResources) {
			String key;
		if (typeResources != null && !typeResources.equals("")) {
			if (contextPath != null && !contextPath.equals("")) {
				key = contextPath.replaceAll("/", "").concat(typeResources.toString());
				return getProperty(key,
						getProperty(GenericKeys.CONTEXT_WEB_APP_DEFAULT_RESOURCES + typeResources.toString(),
								"PATH_NOT_FOUND"));
			} else {			
				return getProperty(GenericKeys.CONTEXT_WEB_APP_DEFAULT_RESOURCES + typeResources.toString(),
						"PATH_NOT_FOUND");
			}
		} else {
			return getProperty(GenericKeys.CONTEXT_WEB_APP_DEFAULT_RESOURCES,
					"basepath '" + GenericKeys.CONTEXT_WEB_APP_DEFAULT_RESOURCES + "' not found");
		}
	}
	 
	 // metodo che permette di distinguere tra ambiente di produzione o di test
	 public synchronized String getTestEnv(){
		 
		 return getBooleanProperty(UrmConfig.GenericKeys.ENVIRONMENT_TEST, false)?"_test":"";
		 
	 }	
	 
}
