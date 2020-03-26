package com.ericsson.urm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.ericsson.urm.StringConstants;

public abstract class LogUtil {
	private static final Logger logger = Logger.getLogger(LogUtil.class);
			
	public static  void printByteArray(byte[] byteArray,String sFilename) {
		StringBuffer buff = new StringBuffer();
		StringBuffer rowB = null;
		StringBuffer rowA = null;
		int numByte = 16;
		char[] spc = new char[3*numByte+3];
		Arrays.fill(spc, ' ');
		String spaces = String.valueOf(spc);
		String sZ = "00000000";
		String nr;
		String b;
		char ch;
		int n;
		int k=0;
		int j=0;
		for(; j<byteArray.length; ++j) {
			if( j%numByte==0 ) {
				if( rowB!=null && rowB.length() > 0 ) {
					nr = Integer.toHexString((j-k)&0xffff);
					nr = sZ.substring(nr.length())+nr;
					buff.append(nr);
					buff.append(" ");
					buff.append(rowB.toString());
					buff.append(spaces.substring(3*k));
					buff.append(rowA.toString());
					buff.append("\n");
				}
				k=0;
				rowB = new StringBuffer();
				rowA = new StringBuffer();
			} 

			b = Integer.toHexString(byteArray[j]&0xff);
			b = sZ.substring(b.length(),2)+b;
			
			if(rowB.length()>0) {
				rowB.append(" ");
			}
			rowB.append(b);
			
			n = (int)byteArray[j];
			ch = (n > 32 && n<127) ? (char)byteArray[j] : '.';
			
			rowA.append(ch);
			
			++k;
		}
		if( rowB!=null && rowB.length() > 0 ) {
			nr = Integer.toHexString((j>=k ? j-k : 0)&0xffff);
			nr = sZ.substring(nr.length())+nr;
			buff.append(nr);
			buff.append(" ");
			buff.append(rowB.toString());
			buff.append(spaces.substring(3*k));
			buff.append(rowA.toString());
			buff.append("\n");
		}
		
		logger.debug(sFilename+":\n"+buff.toString()+"\nLength:"+byteArray.length+" bytes");
	}
	
	public static String objectToString(Object obj) throws IllegalAccessException, InvocationTargetException {
		if (obj == null)
			return "null";
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(obj.getClass().getName());
		sb.append(" [");
		Method[] methods = obj.getClass().getDeclaredMethods();
		
		boolean firstWrote = false;
		
		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i];
			String name = m.getName();
			if (name.startsWith("get") || name.startsWith("is")) {
				if (firstWrote)
					sb.append(", ");
				
				sb.append(name.substring(name.startsWith("get") ? 3 : 2));
				sb.append("=");
				
				try {
					Object result = m.invoke(obj, null);
					if (result == null)
						sb.append("null");
					else if (result.getClass().equals(java.util.Date.class) || result.getClass().equals(java.sql.Date.class)) 
						sb.append(new SimpleDateFormat(StringConstants.DATE_VIEW).format(result));
					else if (result.getClass().getName().startsWith("java.lang") || result.getClass().getName().startsWith("java.util"))
						sb.append(result);
					else
						sb.append(objectToString(result)); //probabilmente è un bean a sua volta, quindi vado in ricorsione
				}
				catch (Exception e) {
					logger.error("Unable to get or print value. Continue processing " + name + ". Exception message:" + e.getMessage());
					sb.append("Unable to get or print value");
				}
				
				firstWrote = true;
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
