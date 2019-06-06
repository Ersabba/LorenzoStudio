package com.ericsson.urm.exceptions;


public class URMBusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static int CONCURRENT_ACCESS=0;
	public static int UNCLASSIFIED_ERROR=1;
	public final static int NO_SUCH_ELEMENT_ERROR=2;	
	public final static int RESOURCE_BUSY=3;
	public final static int COMMUNICATION_ERROR=4;
	public final static int OBSOLETE_FILE_FOUND=5;
	
	private int type=-1;

	public URMBusinessException() {
		this.type=UNCLASSIFIED_ERROR;
		
	}

	public URMBusinessException(String arg0) {
		super(arg0);
		this.type=UNCLASSIFIED_ERROR;
	}

	public URMBusinessException(Throwable arg0) {
		super(arg0);
		this.type=UNCLASSIFIED_ERROR;
	}

	public URMBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.type=UNCLASSIFIED_ERROR;
	}
	
	
	
	public URMBusinessException(int newType) {
		this.type=newType;
		
	}

	public URMBusinessException(String arg0, int newType) {
		super(arg0);
		this.type=newType;
	}

	public URMBusinessException(Throwable arg0, int newType) {
		super(arg0);
		this.type=newType;
	}

	public URMBusinessException(String arg0, Throwable arg1, int newType) {
		super(arg0, arg1);
		this.type=newType;
	}
	

	public int getType() {
		return type;
	}

}
