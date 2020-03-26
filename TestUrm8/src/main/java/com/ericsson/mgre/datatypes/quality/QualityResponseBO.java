package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;

public class QualityResponseBO implements Serializable {
	
	public interface ResultValue {
		public final static int REQUEST_SUCCESS = 0;
		public final static int COMMUNICATION_ERROR = 1;
		public final static int FILE_NOT_FOUND = 2;
		public final static int GENERIC_ERROR = 3;
		public final static int FILE_NOT_VALID = 4;
	}
	

	private static final long serialVersionUID = 1L;

	String  	idRequest;
	String		filename;
	int         resultValue;
	
	
	public QualityResponseBO() {
		// TODO Auto-generated constructor stub
	}


	public QualityResponseBO(String idRequest, String filename,int resultValue) {
		this.idRequest = idRequest;
		this.filename = filename;
		this.resultValue = resultValue;
	}


	public String getIdRequest() {
		return idRequest;
	}


	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getResultValue() {
		return resultValue;
	}


	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	
}
