package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;

public class TensioniDataRequestBO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String  idRequestFile;
	private String  fileName;
	private int 	idSS;
	private int		idEs;
	
	TensioniRequestBO[] records;
	
	public String getIdRequestFile() {
		return idRequestFile;
	}

	public void setIdRequestFile(String idRequestFile) {
		this.idRequestFile = idRequestFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getIdSS() {
		return idSS;
	}

	public void setIdSS(int idSS) {
		this.idSS = idSS;
	}

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}

	public TensioniRequestBO[] getRecords() {
		return records;
	}

	public void setRecords(TensioniRequestBO[] records) {
		this.records = records;
	}
}
