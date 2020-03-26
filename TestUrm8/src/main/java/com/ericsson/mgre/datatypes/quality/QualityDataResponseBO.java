package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;

public class QualityDataResponseBO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String  IdRequestFile;
	private String  fileName;
	private int  result;
	private int 	idSS;
	private int		idEs;
	private QualityResponseBO[] qualityResponseBOs;
	
	public QualityDataResponseBO() {}


	public QualityDataResponseBO(String idRequestFile, String fileName,
			int result, int idSS, int idEs,
			QualityResponseBO[] qualityResponseBOs) {
		IdRequestFile = idRequestFile;
		this.fileName = fileName;
		this.result = result;
		this.idSS = idSS;
		this.idEs = idEs;
		this.qualityResponseBOs = qualityResponseBOs;
	}

	public String getIdRequestFile() {
		return IdRequestFile;
	}

	public void setIdRequestFile(String idRequestFile) {
		IdRequestFile = idRequestFile;
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

	public QualityResponseBO[] getQualityResponseBOs() {
		return qualityResponseBOs;
	}

	public void setQualityResponseBOs(QualityResponseBO[] qualityResponseBOs) {
		this.qualityResponseBOs = qualityResponseBOs;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}

}
