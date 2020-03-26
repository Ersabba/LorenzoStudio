package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class CurvaCaricoOperazioni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private CurvaCaricoOperazioniId id;
	private Date dataAcquisizione;
	private String fonteRichiesta;
	private Date periodoRichiestaDa;
	private Date periodoRichiestaA;
	private Long numComandiBt;
	private Long numSuccessi;
	
	
	public CurvaCaricoOperazioniId getId() {
		return id;
	}
	public void setId(CurvaCaricoOperazioniId id) {
		this.id = id;
	}
	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}
	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}
	public String getFonteRichiesta() {
		return fonteRichiesta;
	}
	public void setFonteRichiesta(String fonteRichiesta) {
		this.fonteRichiesta = fonteRichiesta;
	}
	public Date getPeriodoRichiestaDa() {
		return periodoRichiestaDa;
	}
	public void setPeriodoRichiestaDa(Date periodoRichiestaDa) {
		this.periodoRichiestaDa = periodoRichiestaDa;
	}
	public Date getPeriodoRichiestaA() {
		return periodoRichiestaA;
	}
	public void setPeriodoRichiestaA(Date periodoRichiestaA) {
		this.periodoRichiestaA = periodoRichiestaA;
	}
	public Long getNumComandiBt() {
		return numComandiBt;
	}
	public void setNumComandiBt(Long numComandiBt) {
		this.numComandiBt = numComandiBt;
	}
	public Long getNumSuccessi() {
		return numSuccessi;
	}
	public void setNumSuccessi(Long numSuccessi) {
		this.numSuccessi = numSuccessi;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
		result = prime * result + ((fonteRichiesta == null) ? 0 : fonteRichiesta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numComandiBt == null) ? 0 : numComandiBt.hashCode());
		result = prime * result + ((numSuccessi == null) ? 0 : numSuccessi.hashCode());
		result = prime * result + ((periodoRichiestaA == null) ? 0 : periodoRichiestaA.hashCode());
		result = prime * result + ((periodoRichiestaDa == null) ? 0 : periodoRichiestaDa.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurvaCaricoOperazioni other = (CurvaCaricoOperazioni) obj;
		if (dataAcquisizione == null) {
			if (other.dataAcquisizione != null)
				return false;
		}
		else if (!dataAcquisizione.equals(other.dataAcquisizione))
			return false;
		if (fonteRichiesta == null) {
			if (other.fonteRichiesta != null)
				return false;
		}
		else if (!fonteRichiesta.equals(other.fonteRichiesta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (numComandiBt == null) {
			if (other.numComandiBt != null)
				return false;
		}
		else if (!numComandiBt.equals(other.numComandiBt))
			return false;
		if (numSuccessi == null) {
			if (other.numSuccessi != null)
				return false;
		}
		else if (!numSuccessi.equals(other.numSuccessi))
			return false;
		if (periodoRichiestaA == null) {
			if (other.periodoRichiestaA != null)
				return false;
		}
		else if (!periodoRichiestaA.equals(other.periodoRichiestaA))
			return false;
		if (periodoRichiestaDa == null) {
			if (other.periodoRichiestaDa != null)
				return false;
		}
		else if (!periodoRichiestaDa.equals(other.periodoRichiestaDa))
			return false;
		return true;
	}
}
