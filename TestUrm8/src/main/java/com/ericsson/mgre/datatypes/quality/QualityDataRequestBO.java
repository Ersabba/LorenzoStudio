package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;

public class QualityDataRequestBO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String  idRequestFile;
	private String  fileName;
	private int 	idSS;
	private int		idEs;
	private QualityRequestBO[] qualityRequestBOs;
	
	public QualityDataRequestBO() {}

	public QualityDataRequestBO(String idRequestFile, int idSS, int idEs,
			QualityRequestBO[] qualityRequestBOs,String fileName) {
		this.idRequestFile = idRequestFile;
		this.idSS = idSS;
		this.idEs = idEs;
		this.qualityRequestBOs = qualityRequestBOs;
		this.fileName = fileName;
	}

	public String getIdRequestFile() {
		return idRequestFile;
	}

	public void setIdRequestFile(String idRequestFile) {
		this.idRequestFile = idRequestFile;
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

	public QualityRequestBO[] getQualityRequestBOs() {
		return qualityRequestBOs;
	}

	public void setQualityRequestBOs(QualityRequestBO[] qualityRequestBOs) {
		this.qualityRequestBOs = qualityRequestBOs;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
