package com.ericsson.urm.util.security;


import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CryptDecryptPassword {
	
	private static Logger logger = Logger.getLogger(CryptDecryptPassword.class);
	private static CryptDecryptPassword securityAccessDB = null;
	
	private SecretKeySpec skeySpec = null;
	private Cipher cipher          = null;
	
	private final static String EMPTY_PASSWORD = "__[EMPTY_PASSWORD]__";
	
	
	private static final byte[] raw = {49,122,-12,39,-107,-121,80,31,
		                               120,-69,-125,-36,61,90,-118,-100};
	
	private CryptDecryptPassword() {
		//KeyGenerator kgen = KeyGenerator.getInstance("AES");
	    //kgen.init(128);
	    
	    //	  Generate the secret key specs.
	    //SecretKey skey = kgen.generateKey();
	    //byte[] raw = skey.getEncoded();

		try {
	      skeySpec = new SecretKeySpec(raw, "AES");
	    
	      cipher = Cipher.getInstance("AES");
		}
		catch(Exception e) {
			logger.error(e.toString(),e);
		}
	}
	
	public synchronized String crypt(String s) {
		String encrypted = "";
		byte[] buffer = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			buffer = cipher.doFinal(s.getBytes());
			
			for(int k=0;k<buffer.length;++k) {
				String b=Integer.toHexString(buffer[k]&0xff);
				encrypted += "00".substring(b.length())+b;
			}
		}
		catch(Exception e) {
		   logger.error(e.toString(),e);
		}
		
		return encrypted;
	}
	
	public synchronized String decrypt(String encrypted) {
		String originalString = null;
		byte[] buffer = null;
		try {
			buffer = new byte[encrypted.length()/2];
			
			for(int k=0;k<buffer.length;++k) {
				String sb = encrypted.substring((k*2), (k*2)+2);
				buffer[k] = (byte)Integer.parseInt(sb,16);
			}
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] original = cipher.doFinal(buffer);
			originalString = new String(original);
			if(originalString.equals(EMPTY_PASSWORD)) {
				originalString="";
			}
		}
		catch(Exception e) {
		   logger.error(e.toString(),e);
		}
	    return originalString;
	}
	
	
	private String replaceKeyPassword(String line) {
		 String tmpValue = new String(line);
		 Pattern pattern = Pattern.compile(".*\\.password\\s*=.*");
	     Matcher matcher = pattern.matcher(tmpValue);
	     String p;
	     
	     if (matcher.find()) {
	    	 p = matcher.group();
	    	 String[] param = p.split("=");
	    	 param[0]+= "=";
	    	 
	    	 tmpValue = (param.length>1 && param[1].trim().length()>0) ? crypt(param[1]) : EMPTY_PASSWORD;
	    	 tmpValue = param[0].replaceAll("password\\s*=", ".passwordEncrypted=") + tmpValue; 
	     }
	     
	     pattern = Pattern.compile(".*_PASSWORD\\s*=.*");
	     matcher = pattern.matcher(tmpValue);
	    
	     if (matcher.find()) {
	    	 p = matcher.group();
	    	 String[] param = p.split("=");
	    	 param[0]+= "=";
	    	 tmpValue = (param.length>1 && param[1].trim().length()>0) ? crypt(param[1]) : EMPTY_PASSWORD;
	    	 tmpValue = param[0].replaceAll("_PASSWORD\\s*=", "_PASSWORD_ENCRYPTED=") + tmpValue; 
	     }
	    
	     return tmpValue;
	 }
	
	public synchronized void updateProperties(String pathFile) {
		FileOutputStream fos = null;
		PrintStream outFile = null;
		
		FileInputStream fis = null;
		BufferedReader br = null;
		File f = null;
		
		if(pathFile==null || pathFile.equals(""))
			return;
		
		try {
			f = new File(pathFile);
			fis = new FileInputStream(f);
			br=new BufferedReader(new InputStreamReader(fis));
			boolean changed = false;
			String line;
			String result;
			StringBuffer buffer = new StringBuffer("");
			while((line=br.readLine())!=null) {
				if(!line.trim().startsWith("#")) {
					result = replaceKeyPassword(line);
					if(!result.equals(line)) {
						changed = true;
				}
				} else {
					result = line;
			}
				logger.debug(result);
				buffer.append(result+"\n");
			}
			fis.close();
			fis = null;
			
			if(changed) {
			fos = new FileOutputStream (pathFile);
			outFile = new PrintStream(fos);
			outFile.println(buffer.toString());
			}
			
			buffer = null;
			
		} catch(Exception e) {
			logger.error(e.toString(),e);
		}
		finally {
			try { if(br!=null) { br.close(); br=null; } } catch(IOException e) { logger.error(e.toString()); }
			try { if(fis!=null) { fis.close(); fis=null; } } catch(IOException e) { logger.error(e.toString()); }
			
			if(outFile!=null) { outFile.close(); outFile=null; }
			try { if(fos!=null) { fos.close(); fos=null; } } catch(IOException e) { logger.error(e.toString()); }
		}
	}
	
	public synchronized static CryptDecryptPassword getInstance() {
		if(securityAccessDB==null) {
			securityAccessDB = new CryptDecryptPassword();
		}
		return securityAccessDB;
	}
}