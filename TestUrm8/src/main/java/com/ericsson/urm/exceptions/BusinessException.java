package com.ericsson.urm.exceptions;


public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static int CONCURRENT_ACCESS=0;
	public static int UNCLASSIFIED_ERROR=1;
	public final static int NO_SUCH_ELEMENT_ERROR=2;	
	public final static int RESOURCE_BUSY=3;
	public final static int COMMUNICATION_ERROR=4;
	
	private int type=-1;

	public BusinessException() {
		this.type=UNCLASSIFIED_ERROR;
		
	}

	public BusinessException(String arg0) {
		this(arg0,null,UNCLASSIFIED_ERROR);
	}

	public BusinessException(Throwable arg0) {
		this(null,arg0,UNCLASSIFIED_ERROR);
	}

	public BusinessException(String arg0, Throwable arg1) {
		this(arg0, arg1,UNCLASSIFIED_ERROR);
	}
	
	
	
	public BusinessException(int newType) {
		this(null,null,newType);
	}

	public BusinessException(String arg0,int newType) {
		this(arg0,null,newType);
	}

	public BusinessException(Throwable arg0,int newType) {
		this(null,arg0,newType);
	}

	public BusinessException(String arg0, Throwable arg1,int newType) {
		super(arg0, arg1);
		this.type=newType;
	}
	

	public int getType() {
		return type;
	}

}
