package com.ericsson.urm.util.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;



public class CSVWriter {
	
	private static Logger logger = Logger.getLogger(CSVWriter.class);
	
	private long flockTimeout = 0L;
	
	private File fileName = null;
	private FileOutputStream fout = null;
	private FileChannel fileChannel = null;
	private FileLock flock = null;
    private OutputStreamWriter writer  = null;
    
    private boolean append = false;
    
    private boolean isHeaderWritten = false;
    
    private boolean isHeaderEnabled = true;
    
    private boolean isAlwaysWithContainer = false;
    
    private String  fileEncoding = null;
    private String  newline = "\n"; 
    private char    fieldSeparator = ';';
    private char    charContainer = '\"';
    
    private boolean fileCreated = false;
 
	
    /**
     * 
     * @param isHeaderEnabled
     */
    public void setHeaderEnabled(boolean isHeaderEnabled) {
		 this.isHeaderEnabled = isHeaderEnabled;
	}
    
    /**
     * 
     * @return
     */
    public boolean getHeaderEnabled() {
		 return isHeaderEnabled;
	}
    
    /**
     * 
     * @return
     */
    public boolean isHeaderWritten() {
		 return isHeaderWritten;
	}
    
    /**
     * 
     * @param newline
     */
    public void setNewline(String newline) {
    	 if(newline==null || newline.equals(""))
    		 newline="\n";
		 this.newline = newline;
	}
    
    /**
     * 
     * @return
     */
    public String getNewline() {
		 return new String(newline);
	}
    
    /**
     * 
     * @param fieldSeparator
     */
    public void setFieldSeparator(char fieldSeparator) {
    	this.fieldSeparator = fieldSeparator;
	}
    
    /**
     * 
     * @return
     */
    public char getFieldSeparator() {
    	return fieldSeparator;
	}
    
    /**
     * 
     * @param charContainer
     */
    public void setCharContainer(char charContainer) {
    	this.charContainer = charContainer;
	}
    
    /**
     * 
     * @return
     */
    public char getCharContainer() {
    	return charContainer;
	}
    
    /**
     * 
     * @param charContainer
     */
    public void isAlwaysWithContainer(boolean isAlwaysWithContainer) {
    	this.isAlwaysWithContainer = isAlwaysWithContainer;
	}
    
    /**
     * 
     * @param charContainer
     */
    public boolean isAlwaysWithContainer() {
    	return isAlwaysWithContainer;
	}
    
    /**
     * 
     * @param fileEncoding
     */
    public void setFileEncoding(String fileEncoding) {
    	this.fileEncoding = fileEncoding;
	}
    
    /**
     * 
     * @return
     */
    public String getFileEncoding() {
    	return fileEncoding != null ? new String(fileEncoding) : null;
	}  
    
    /**
     * 
     * @param file
     * @throws IOException
     */
    public CSVWriter(File file) throws IOException {
    	
    	this(file,null,null,false);
    	
    }
    

    /**
     * 
     * @param file
     * @param append
     * @throws IOException
     */
    public CSVWriter(File file,boolean append) throws IOException {
  
    	this(file,null,null,append);
    	
    }
    
    /**
     * 
     * @param file
     * @param encoding
     * @throws IOException
     */
    public CSVWriter(File file, String encoding) throws IOException {
    	this(file,encoding,null,false);
    }
    
    /**
     * 
     * @param file
     * @param encoding
     * @param append
     * @throws IOException
     */
    public CSVWriter(File file, String encoding, boolean append) throws IOException {
    	this(file,encoding,null,append);
    }
    
    /**
     * 
     * @param file
     * @param header
     * @throws IOException
     */
    public CSVWriter(File file, String[] header) throws IOException {
    	
    	this(file,null,header,false);
    	
    }
	
    /**
     * 
     * @param file
     * @param header
     * @param append
     * @throws IOException
     */
    public CSVWriter(File file, String[] header, boolean append) throws IOException {
    	
    	this(file,null,header,append);
    	
    }
    
    private void releaseLockAndStream() {
    	if(flock!=null) {
			try { flock.release(); } catch (Exception e) {
				logger.error(e.getMessage());
			}
			flock = null;
		}
		if(writer!=null) {
			try { writer.close(); } catch (Exception e) {
				logger.error(e.getMessage());
			}
			writer = null;
		}
		if(fileChannel!=null) {
			try { fileChannel.close(); } catch (Exception e) {
				logger.error(e.getMessage());
			}
			fileChannel = null;
		}
		if(fout!=null) {
			try { fout.close(); } catch (Exception e) {
				logger.error(e.getMessage());
			}
			fout = null;
		}
    }
    
    private void renewFileLock() throws IOException {
		if(fileChannel!=null) {
			if( flock!=null) {
				try { flock.release(); } catch (Exception e) {
					logger.error(e.getMessage());
				}
				flock = null;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {}
			}

			for (int i = 0; i < 1000; i++) {
				try {
					flock = fileChannel.lock();
					flockTimeout = System.currentTimeMillis() + 5000;
					break;
				} catch (OverlappingFileLockException e) {
					logger.debug(e.getMessage());
					try {Thread.sleep(300); }
					catch (InterruptedException e1) { logger.debug(e1.getMessage()); }
				}
			}
		}
	}
    
    private void makeWriter() throws IOException {
		
		if(!fileName.exists()) {
			fileCreated = fileName.createNewFile();
		}
		
		if(fout==null) {
			fout = new FileOutputStream(fileName, this.append);
			fileChannel = fout.getChannel();
			renewFileLock();
		}

		if(fileEncoding==null || fileEncoding.length() == 0) {
			writer = new OutputStreamWriter(fout);
		} 
		else {
			writer = new OutputStreamWriter(fout, fileEncoding);
		}

	}
   
    private void checkLock() throws IOException {
		
		try {
    		if(fout!=null && fileChannel!=null) {
    			if( flock!=null && System.currentTimeMillis() > flockTimeout) {
    				renewFileLock();
    			}
    		}
    		else {
    			makeWriter();
    		}
  
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			throw new IOException(e.getMessage());
		} catch (FileNotFoundException e) {
			throw e;
		} 
    }
  
    
    /**
     * 
     * @param file
     * @param encoding
     * @param header
     * @throws IOException
     */
	public CSVWriter(File file, String encoding,String[] header, boolean append) throws IOException {
		this.append = append;
		
		try {
			fileName = file;
		
			if (encoding == null) {
				this.fileEncoding = getFileEncoding();
			}

			makeWriter();
		
			if(header!=null && getHeaderEnabled() && !append) {
				writeHeader(header);
			}
			
		} catch(IOException e) {
			logger.error(e.toString());
			if(writer!=null) {
				writer.close();
				writer=null;
			}
			else
			if(fout!=null) { 
				fout.close();
				fout=null;
			}
			throw e;
		}
    }
	
	/**
     * 
     * @param header
     * @throws IOException
     */
    public void writeHeader(String[] header) throws IOException {
    	if(!isHeaderWritten() && !append) {
    		writeFields(header);
    		isHeaderWritten = true;
    	}
    }
	
    /**
     * 
     * @param fields
     * @throws IOException
     */
    public void writeRecord(String[] fields) throws IOException {
        writeFields(fields);
    }

    /**
     * closes the csv file.
     */
    public void close() throws IOException {
    	releaseLockAndStream();
    }

    //
    //
    private void writeFields(String[] fields) throws IOException {
    	checkLock();
    	
        for (int j = 0; j < fields.length; j++) {
            if (j > 0) {
                this.writer.write(getFieldSeparator());
            }

            if (fields[j] != null) { 
                this.writer.write(convertValue(fields[j]));
            }
        }

        this.writer.write(getNewline());
    }

    //
    //
    private String convertValue(String str) {

    	if(str == null)
    		return ""+getCharContainer()+getCharContainer();
    		
    	String result = "";
        StringBuffer sb = new StringBuffer();
        boolean cont = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            sb.append(c);
            
            if( c==getFieldSeparator() || c==' ' && i==0 || c==' ' && (i+1)==str.length() ) {  	
            	cont=true;
            }
            
            if(c==getCharContainer() ) {
            	sb.append(getCharContainer());
            	cont = true;
            }
        
        }
        
        if(cont || sb.length()==0 || isAlwaysWithContainer() ) {
        	result = String.valueOf(getCharContainer()) + sb.toString() + String.valueOf(getCharContainer());
        }
        else {
        	result = sb.toString();
        }
        return result;
    }
    
    public boolean isAppend() {
		return append;
	}

	//
    //
    public void finalize() {
    	try { close(); } catch(IOException e) { logger.error(e.toString()); };
    }
}
