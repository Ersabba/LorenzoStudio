package com.ericsson.urm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public abstract class SerializationUtil {
	public static byte[] toByteArray(Object obj) throws IOException {
		if(obj==null) {
			throw new IllegalArgumentException("obj has not been defined");
		}
		
		ByteArrayOutputStream baos= null;
        ObjectOutputStream oos = null;
        byte[] array = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.flush();
			array = baos.toByteArray();
		} 
		finally {
			if(oos!=null) { oos.close(); oos=null; }
		}
		return array;
	}
	
	public static Object toObject(byte[] aObj) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		Object obj = null;
		if(aObj!=null) {
			try {
				bis = new ByteArrayInputStream(aObj);
				ois = new ObjectInputStream(bis);
				obj = ois.readObject();
			} 
			finally {
				if(ois!=null) { ois.close(); ois=null; }
			}
		}
		
		return obj;
	}
	
	public static void gzipSerialize(Serializable object,File output) throws IOException {
		if(output == null) {
			throw new IllegalArgumentException("output is null");
		}
		if(object == null) {
			throw new IllegalArgumentException("serializable object is null");
		}
		
		if(!output.getParentFile().exists()) {
			if(!output.getParentFile().mkdirs()) {
				throw new IOException("Can not create path:"+output.getParent());
			}
		}	
		
		FileOutputStream fos   = null;
		GZIPOutputStream gz    = null;
		ObjectOutputStream oos = null;
		try {
	        fos = new FileOutputStream(output);
	        gz =  new GZIPOutputStream(fos);
	        oos = new ObjectOutputStream(gz); 
	        oos.writeObject(object);  
	    } 
		finally {
			if(oos!=null) {
				oos.close();
			}
			if(gz!=null) {
				gz.close();
			}
			if(fos!=null) {
				fos.close();
			}
		}
	}
	
	public static Serializable gzipDeserialize(File input) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(input == null) {
			throw new IllegalArgumentException("input file is null");
		}
		FileInputStream fis   = null;
		ObjectInputStream ois = null;
		GZIPInputStream gz    = null;
		try {
	        fis = new FileInputStream(input);
	        gz  = new GZIPInputStream(fis);
	        ois = new ObjectInputStream(gz); 
	        return (Serializable)ois.readObject();  
	    } 
		finally {
			if(ois!=null) {
				ois.close();
			}
			if(gz!=null) {
				gz.close();
			}
			if(fis!=null) {
				fis.close();
			}
		}
	}
	
	public static void serialize(Serializable object,File output) throws IOException {
		if(output == null) {
			throw new IllegalArgumentException("output is null");
		}
		if(object == null) {
			throw new IllegalArgumentException("serializable object is null");
		}
		
		if(!output.getParentFile().exists()) {
			if(!output.getParentFile().mkdirs()) {
				throw new IOException("Can not create path:"+output.getParent());
			}
		}	
		
		FileOutputStream fos   = null;
		ObjectOutputStream oos = null;
		try {
	        fos = new FileOutputStream(output);
	        oos = new ObjectOutputStream(fos); 
	        oos.writeObject(object);  
	    } 
		finally {
			if(oos!=null) {
				oos.close();
			}
			if(fos!=null) {
				fos.close();
			}
		}
	}
	
	public static Serializable deserialize(File input) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(input == null) {
			throw new IllegalArgumentException("input file is null");
		}
		FileInputStream fis = null;
		ObjectInputStream ois=null;
		try {
	        fis = new FileInputStream(input);
	        ois = new ObjectInputStream(fis); 
	        return (Serializable)ois.readObject();  
	    } 
		finally {
			if(ois!=null) {
				ois.close();
			}
			if(fis!=null) {
				fis.close();
			}
		}
	}
}
