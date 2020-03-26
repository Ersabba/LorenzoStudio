package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;
import java.util.Date;

public class TensioniRequestBO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String matrLennt;
	private Date dataRil;
	
	public TensioniRequestBO() {
		super();
	}
	
	public TensioniRequestBO(String matrLennt, Date dataRil) {
		this.matrLennt = matrLennt;
		this.dataRil = dataRil;
	}

	public String getMatrLennt() {
		return matrLennt;
	}
	public void setMatrLennt(String matrLennt) {
		this.matrLennt = matrLennt;
	}
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
}
