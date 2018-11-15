package com.ericsson.urm.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.ericsson.urm.util.ArgumentsCheckerUtil;

public abstract class XMLObjectFactory {
	
	private static Logger logger = Logger.getLogger(XMLObjectFactory.class);
	
	public final static String ENCODING = "UTF-8";
	private static final String defaultDateFormat = "yyyyMMdd";
	
	protected String getDateFormat() {
	    return defaultDateFormat;
	}

	public Date parseDate(String strDate) {
		ArgumentsCheckerUtil.checkString(getDateFormat());
	    try {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat(getDateFormat());
			return strDate != null ? dateFormat.parse(strDate) : null;
		} catch (ParseException e) {
			throw new IllegalArgumentException("Parse date of: "+strDate+" failed",e);
		}
	}

	public String formatDate(Date date) {
		ArgumentsCheckerUtil.checkString(getDateFormat());
		SimpleDateFormat dateFormat = new SimpleDateFormat(getDateFormat());
		return date != null ? dateFormat.format(date) : "";
	}
	
	public <T> String toString(T obj) throws JAXBException {
		return obj!=null ? marshallerToString(obj) : null;
	}
	
	protected static void saveToFile(Object xmlObj, String ctxName, File xmlOutputFile) throws IOException, JAXBException {
		
		saveToFile(xmlObj, ctxName, xmlOutputFile, false);
	
	}
	
	protected static void saveToFile(Object xmlObj, String ctxName, File xmlOutputFile, boolean formatted) throws IOException, JAXBException {
		ArgumentsCheckerUtil.checkNull(xmlObj);
		ArgumentsCheckerUtil.checkString(ctxName);
		ArgumentsCheckerUtil.checkNull(xmlOutputFile);
		
		FileOutputStream  fos = null;
		try {
			JAXBContext jc = JAXBContext.newInstance( ctxName );
		    Marshaller m = jc.createMarshaller();
		    
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.valueOf(formatted) );
		    
		    fos = new FileOutputStream(xmlOutputFile);
		    m.marshal(xmlObj, fos);		    
		} finally {
			if(fos != null ) {
				fos.close();
			}
		}
	}
	
	protected static String toString(Object xmlObj, String ctxName, boolean formatted) throws IOException, JAXBException {
		ArgumentsCheckerUtil.checkNull(xmlObj);
		ArgumentsCheckerUtil.checkString(ctxName);
		
		ByteArrayOutputStream  bos = null;
		try {
			JAXBContext jc = JAXBContext.newInstance( ctxName );
		    Marshaller m = jc.createMarshaller();
		    
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.valueOf(formatted) );
		    
		    bos = new ByteArrayOutputStream();
		    m.marshal(xmlObj, bos);	
		    
		    return bos.toString();
		    
		} finally {
			if(bos != null ) {
				bos.close();
			}
		}
	}
	
	public static <T> void marshaller(T obj, OutputStream outputStream ) throws JAXBException {
		marshaller(obj, outputStream, true );
    }
	
	public static <T> void marshaller(T obj, File xmlFile) throws JAXBException {
		marshaller(obj, xmlFile, true);
    }
	
	public static <T> void marshaller(T obj, OutputStream outputStream,  boolean formatted ) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(obj);
		ArgumentsCheckerUtil.checkNull(outputStream);
		
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatted);
        marshaller.marshal(obj, outputStream);
    }
	
	public static <T> void marshaller(T obj, File xmlFile, boolean formatted ) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(obj);
		ArgumentsCheckerUtil.checkNull(xmlFile);
		
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatted);
        marshaller.marshal(obj, xmlFile);
    }
	
	public static <T> String marshallerToString(T obj) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(obj);
	
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        String result = null;
        ByteArrayOutputStream bos = null;
        try {
			bos = new ByteArrayOutputStream();
			
			marshaller.marshal(obj, bos);
			
			result = bos.toString();
		} finally {
			try {
				if(bos!=null) {
					bos.close();
				}
			} catch (IOException e) {
				logger.error("Cannot close stream");
			}
		}
        
        return result;
    }
	
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshaller(Class<T> cls, String xmlInput) throws JAXBException, UnsupportedEncodingException {
		ArgumentsCheckerUtil.checkNull(cls);
		ArgumentsCheckerUtil.checkString(xmlInput);
		
        JAXBContext jc = JAXBContext.newInstance(cls);
         
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
        T result = null;
        InputStream inputStream = null;
        try {
			inputStream = new ByteArrayInputStream(xmlInput.getBytes(ENCODING));
			 
			result = (T)unmarshaller.unmarshal(inputStream);
		} finally {
			try {
				if(inputStream!=null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("Cannot close stream");
			}
		}
        
        return result;
    }
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshaller(Class<T> cls, InputStream inputStream ) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(cls);
		ArgumentsCheckerUtil.checkNull(inputStream);
		
        JAXBContext jc = JAXBContext.newInstance(cls);
         
        Unmarshaller unmarshaller = jc.createUnmarshaller();
         
        return (T)unmarshaller.unmarshal(inputStream);
    }
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshaller(Class<T> cls, File xmlFilename ) throws JAXBException {
		ArgumentsCheckerUtil.checkNull(cls);
		ArgumentsCheckerUtil.checkNull(xmlFilename);
		
        JAXBContext jc = JAXBContext.newInstance(cls);
         
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (T)unmarshaller.unmarshal(xmlFilename);
    }
	
}
