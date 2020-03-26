package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ericsson.mgre.datatypes.Componente;
import com.ericsson.urm.util.DateUtil;

public class NumeroCampioniCurve implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String matricolaLennt;
	private String componente;
	private Date dataCurva;
	private Integer campioniQuartorari;
	
	public String getMatricolaLennt() {
		return matricolaLennt;
	}
	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}
	public Componente getComponente() {
		return componente != null ? Componente.parse(componente) : null;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public void setComponenteEnum(Componente componente) {
		this.componente = componente!=null ? componente.toString() : null;
	}
	public Date getDataCurva() {
		return dataCurva;
	}
	public void setDataCurva(Date dataCurva) {
		this.dataCurva = DateUtil.azzeraHHMMSS(dataCurva);
	}
	public Integer getCampioniQuartorari() {
		return campioniQuartorari;
	}
	public void setCampioniQuartorari(Integer campioniQuartorari) {
		this.campioniQuartorari = campioniQuartorari;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(matricolaLennt + ",");
		if (dataCurva != null)
			sb.append(new SimpleDateFormat("dd/MM/yyyy").format(dataCurva) + ",");
		else
			sb.append("null,");
		sb.append(componente + ",");
		sb.append(campioniQuartorari);
		return sb.toString();
	}
}
