package com.ericsson.urm.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import com.ericsson.urm.exceptions.URMBusinessException;


public abstract class FunctionUtil {
	
	private static Long counterReferenceMsg = 0L;
	
	public interface GenericConstants {
		public final String EMPTY_STRING = "";
	}
	
	public static String getReferenceIdMessage(String idRequest) {
		synchronized(counterReferenceMsg) {
			return DateUtil.formatDateMsec(new Date()) + "_" + String.valueOf(idRequest) + "_" + String.valueOf(++counterReferenceMsg);
		}
    }
	
	public static String nullToEmptyString(String value) {
		return value!=null ? value : GenericConstants.EMPTY_STRING;
	}
	

	public static <T> T castTo(Object obj, Class<T> clsResult) {
		ArgumentsCheckerUtil.checkNull(clsResult, "clsResult");
		
		if(obj==null) {
			throw new IllegalArgumentException("Undefined object");
		}
		
		if (!clsResult.isAssignableFrom(obj.getClass())) {
			throw new ClassCastException("Invalid result type, received: " + obj + " expected "+clsResult);
		}
		return clsResult.cast(obj);
	}
	
	public static String appendString(String origStr, String otherStr, char sep) {
		if(origStr==null) {
			origStr = "";
		}
		if(otherStr!=null && otherStr.trim().length()>0) {
			if(origStr.length()>0) {
				origStr += sep;
			}
			origStr += otherStr;
		}
		return origStr;
	}
	
	public static <T extends Number> T toNumber(String value, Class<T> clsRet) {
		T result = null;
		
		if(value != null) {
			
			Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new HashMap<Class<?>, Class<?>>() {
				{ 
					put(byte.class, Byte.class);
					put(double.class, Double.class);
					put(float.class, Float.class);
					put(int.class, Integer.class);
					put(long.class, Long.class);
					put(short.class, Short.class);
				};
			};
			
			clsRet = clsRet.isPrimitive() ? (Class<T>)PRIMITIVES_TO_WRAPPERS.get(clsRet) : clsRet;
			
			if(clsRet.isAssignableFrom(Double.class)) {
				result = clsRet.cast(Double.valueOf(value));
			}
			else
			if(clsRet.isAssignableFrom(Float.class)) {
					result = clsRet.cast(Float.valueOf(value));
			}
			else {
				int j = value.lastIndexOf('.');
				if(j>=0) {
					value = value.substring(0,j);
				}

				if(clsRet.isAssignableFrom(Long.class)) {
					result = clsRet.cast(Long.valueOf(value));
				} 
				else
				if(clsRet.isAssignableFrom(Integer.class)) {
					result = clsRet.cast(Integer.valueOf(value));
				}
				else
				if(clsRet.isAssignableFrom(Short.class)) {
					result = clsRet.cast(Short.valueOf(value));
				}
				else
				if(clsRet.isAssignableFrom(Byte.class)) {
					result = clsRet.cast(Byte.valueOf(value));
				}
			}
		}
		return result;
	}
	
	/**
	 * If ref is null then return empty string
	 * else return valueOf ref
	 * @param ref
	 * @return String 
	 */
	public static <T> String checkNullAndValueOf(T ref) {
		if(ref == null) {
			return GenericConstants.EMPTY_STRING;
		}		
		return String.valueOf(ref);
	}
	
	public static boolean isNullOrEmpty(String value) {
		return (value==null || value.trim().length()==0);
	}
	
	public static boolean isNullOrEmpty(List list) {
		return (list==null || list.isEmpty());
	}
	
	public static boolean isNullOrEmpty(Collection coll) {
		return (coll==null || coll.isEmpty());
	}
	
	public static String readFileAsString(String filePath) throws IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	    } finally {
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    }
	    return new String(buffer);
	}
	
	public static byte[] readFile(String filePath) throws IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	    } finally {
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    }
	    return buffer;
	}
	
	public static void writeToFile(byte[] fileData, File fileName) throws IOException {
		if(fileName!=null && fileData!=null) {
			OutputStream  out = null;
			try {
				out = new FileOutputStream(fileName);
				out.write(fileData);
			} finally {
				if(out!=null) {
					out.close();
				}
			}
		}
	}
	
	public synchronized static void removeDir(File fileDir) throws IOException {
		if(fileDir!=null ) {
			if(fileDir.isDirectory()) {
				File[] fileChilds = fileDir.listFiles();
				for(File file : fileChilds) {
					if(file.isFile()) {
						if( !file.delete() ) {
							throw new IOException("Can't delete file:"+file.getAbsolutePath());
						}
					} else {
						removeDir(file);
					}
				}
				if(!fileDir.delete()) {
					throw new IOException("Can't delete directory:"+fileDir.getAbsolutePath());
				}
			}
		}
	}
	
	public static void xcopy(File fileSource, File fileTarget) throws IOException {
		if(fileSource != null) {
			if (fileTarget == null) {
				throw new IllegalArgumentException("Target undefined");
			}
			if(!fileSource.exists()) {
				throw new IOException("Source not exist");
			}
			
			if(fileSource.isDirectory()) {
				if(!fileSource.canRead()) {
					throw new IOException("Cannot read source directory:"+fileSource.getAbsolutePath());
				}
				if(!fileTarget.exists()) {
					if(!fileTarget.mkdir()) {
						throw new IOException("Cannot create directory:"+fileTarget.getAbsolutePath());
					}
				}
				if(!fileTarget.canWrite()) {
					throw new IOException("Cannot write into target directory:"+fileTarget.getAbsolutePath());
				}
				String[] filenames = fileSource.list();
				for(int j=0; j<filenames.length; ++j) {
					xcopy(new File(fileSource, filenames[j]),
						  new File(fileTarget, filenames[j]));
				}
			} 
			else {
				if(!fileSource.canRead()) {
					throw new IOException("Cannot read file:"+fileSource.getAbsolutePath());
				}
				
				FileInputStream  in  = null;
				FileOutputStream out = null;
				byte[] buff = new byte[1024];
				int len;
				try {
					in = new FileInputStream(fileSource);
					out = new FileOutputStream(fileTarget);
					
					while ((len = in.read(buff)) > 0) { 
				       out.write(buff, 0, len);
				    }
				}
				finally {
					if(in!=null) {
						in.close();
					}
					if(out!=null) {
						out.close();
					}
				}    
			}
		}
	}
	
	public static Boolean parseBoolean(String boolString) {
		if (boolString == null || boolString.length() == 0)
			return null;
		if (boolString.equalsIgnoreCase("y") || 
				boolString.equalsIgnoreCase("yes") || 
				boolString.equalsIgnoreCase("s") || 
				boolString.equalsIgnoreCase("si") || 
				boolString.equalsIgnoreCase("1") ||
				boolString.equalsIgnoreCase("true"))
			return Boolean.TRUE;
		if (boolString.equalsIgnoreCase("n") || 
				boolString.equalsIgnoreCase("no") || 
				boolString.equalsIgnoreCase("false") || 
				boolString.equalsIgnoreCase("0"))
			return Boolean.FALSE;
		throw new IllegalArgumentException("Unrecognized boolean value: " + boolString);
	}
	
	public static boolean parsePrimitiveBoolean(String boolString) {
		if (parseBoolean(boolString) == null)
			return false;
		return parseBoolean(boolString).booleanValue();
	}
	
	public static String generateThreadResourceOwner() {
		
		String owner = Thread.currentThread().getName()+Thread.currentThread().getId();
		String name = null;
		try {
			name = ManagementFactory.getRuntimeMXBean().getName();
			int pos = name.indexOf('@');
			String pid=name;
			if(pos>=0) {
				pid = name.substring(0, pos);
			}
			java.net.InetAddress i = java.net.InetAddress.getLocalHost();
			owner = String.format("%s_%s@%s/%s", owner,  pid, i.getHostName(), i.getHostAddress());
		} catch (Exception e) {
			throw new IllegalStateException("*** Cannot generate thread resource owner ***");  
		}
		return owner;
	}
	
	public static String strFill(char charToFill, int length) {
		if (length > 0) {
			char[] array = new char[length];
			Arrays.fill(array, charToFill);
			return new String(array);
		}
		return GenericConstants.EMPTY_STRING;
	}
	
	public static String[] strPartition(String s, int wordLenght, boolean beginPadding, char chPadding) {
		int len = s.length();
		
		if(wordLenght > len) {
			wordLenght = len;
		}
		if(wordLenght<1) {
			wordLenght = 1;
		}
		
		String padding = strFill(chPadding, wordLenght);
		
		int r = len % wordLenght;
		if(r > 0 && beginPadding) {
			s = strFill(' ',wordLenght-r) + s;
		}
		
		String[] ret = s.split("(?<=\\G"+strFill('.',wordLenght)+")");
		
		int j = 0;
		for(String js : ret) {
			s = js.trim();
			ret[j++] = (padding + s).substring(s.length(), s.length()+wordLenght);
		} 
 		
		return ret;
	}

	
	public static String[] strPartition(String s, int wordLenght, boolean beginPadding) {
		
		int len = s.length();
		if(wordLenght > len) {
			wordLenght = len;
		}
		if(wordLenght<1) {
			wordLenght = 1;
		}
		
		int r = len % wordLenght;
		if(r > 0 && beginPadding) {
			s = strFill(' ',wordLenght-r) + s;
		}
		
		String[] ret = s.split("(?<=\\G"+strFill('.',wordLenght)+")");
		
		int j = 0;
		for(String js : ret) {
			ret[j++] = js.trim();
		} 
 		
		return ret;
	}
	
	// se non occorre evito del tutto la computazione dei parametri della loggata, poiche potrebbe essere computazionalmente onerosa
	public static void logOnlyIfDebug(Logger logger, String optionalObjectDescr, Object objectToLog, Throwable t) {
		if (Level.DEBUG.equals(logger.getEffectiveLevel())) {
			if (t == null)
				logger.debug(optionalObjectDescr + " " + objectToLog);
			else
				logger.debug(optionalObjectDescr + " " + objectToLog, t);
		}
	}
	
	public enum PadPosition {
		LEFT,
		RIGHT
	}
	
	public static String pad(String base, char padChar, int padLength, PadPosition pos) {
		if (base == null || pos == null)
			throw new IllegalArgumentException("Input parameters cannot be null");
		
		if (base.length() < padLength) {
			if (pos == PadPosition.LEFT)
				return pad(padChar + base, padChar, padLength, pos);
			else
				return pad(base + padChar, padChar, padLength, pos);
		}
		return base;
	}
	
/*	public static void sendJmsMessage(String jmsConnectionFactory, String jmsDesinationName, Serializable data) throws URMBusinessException {
		sendJmsMessage(jmsConnectionFactory, jmsDesinationName, data,  null, 0, 0L);
	}
	
	public static void sendJmsMessage(String jmsConnectionFactory, String jmsDesinationName, Serializable data,  HashMap<String,?> properties) throws URMBusinessException {
		sendJmsMessage(jmsConnectionFactory, jmsDesinationName, data,  properties, 0, 0L);
	}*/

/*	public static void sendJmsMessage(String jmsConnectionFactory, String jmsDesinationName, Serializable data,  HashMap<String,?> properties, int priority, long delay) throws URMBusinessException {
		ArgumentsCheckerUtil.checkNull(jmsConnectionFactory, "jmsConnectionFactory");
		ArgumentsCheckerUtil.checkNull(jmsDesinationName, "jmsDesinationName");
		ArgumentsCheckerUtil.checkNull(data, "data");

	
		JmsQueueSession jmsQueueSession = null;
		try {
			try {
				jmsQueueSession = JmsQueueSession.createSession(jmsConnectionFactory, jmsDesinationName);
			} catch (Throwable t) {
				jmsQueueSession = JmsQueueSession.createSessionByJndi(jmsConnectionFactory, jmsDesinationName);
			}
			
			ObjectMessage message = jmsQueueSession.getSession().createObjectMessage();
			
			if(properties!=null) {
				for(Map.Entry<String, ?> entry: properties.entrySet()) { 
					if(entry.getValue() instanceof String) {
						message.setStringProperty(entry.getKey(), (String)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Boolean) {
						message.setBooleanProperty(entry.getKey(), (Boolean)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Byte) {
						message.setByteProperty(entry.getKey(), (Byte)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Short) {
						message.setShortProperty(entry.getKey(), (Short)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Integer) {
						message.setIntProperty(entry.getKey(), (Integer)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Long) {
						message.setLongProperty(entry.getKey(), (Long)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Float) {
						message.setDoubleProperty(entry.getKey(), (Float)entry.getValue());
					}
					else
					if(entry.getValue() instanceof Double) {
						message.setDoubleProperty(entry.getKey(), (Double)entry.getValue());
					}
				}	
			}
			message.setObject(data);
			
			if (priority >= 0) {
				jmsQueueSession.getSender().setPriority(priority);
			}
			if (delay > 0) {
				((WLMessageProducer) jmsQueueSession.getSender()).setTimeToDeliver(delay);
			}
			jmsQueueSession.getSender().send(message);
			
		}
		catch (NamingException e) {
			throw new URMBusinessException("Cannot send message destination name:" + jmsDesinationName + " not found;" + e.getMessage());
		}
		catch (Throwable t) {
			throw new URMBusinessException("Send message on destination name:" + jmsDesinationName + " failed;" + t.getMessage());
		}
		finally {
		
			if (jmsQueueSession != null) {
				jmsQueueSession.close();
			}
		}
		
	}*/
	
	public static boolean isANumber(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	public static boolean isNumeric(String toCheck){
		boolean ret = false;
		try{
			Double number = Double.parseDouble(toCheck);
			return (number !=null);
        }catch(NumberFormatException nfe){
			return ret;			
		}
	}
	
	
	
	public static String join(Object[] array, String separator){
		return join(array, separator, 0, array.length);
	}
	
	public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        if (separator == null) {
            separator = "";
        }

        // endIndex - startIndex > 0:   Len = NofStrings *(len(firstString) + len(separator))
        //           (Assuming that all Strings are roughly equally long)
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return "";
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length())
                        + separator.length());

        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

}
	
