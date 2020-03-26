package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * The persistent class for the GRE_CRZ_PROFILO_LENNT database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_PROFILO_LENNT")
public class CrzLenntProfilo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MATRICOLA_LENNT_PRIMITIVO")
	private String matricolaLenntPrimitivo;

	
	@Column(name="ID_PROFILO_LETTURA")
	private Long idProfiloLettura;

	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ULTIMA_MODIFICA")
	private Date dtUltimaModifica; 
	
	
	@Column(name="autoProfiling")
	private String autoProfiling = "Y";
	
	public CrzLenntProfilo(){
		super();
	}
	
	

	public CrzLenntProfilo(String matricolaLenntPrimitivo,
			Long idProfiloLettura, Date dtUltimaModifica) {
		super();
		this.matricolaLenntPrimitivo = matricolaLenntPrimitivo;
		this.idProfiloLettura = idProfiloLettura;
		this.dtUltimaModifica = dtUltimaModifica;
	}



	public String getMatricolaLenntPrimitivo() {
		return matricolaLenntPrimitivo;
	}

	public void setMatricolaLenntPrimitivo(String matricolaLenntPrimitivo) {
		this.matricolaLenntPrimitivo = matricolaLenntPrimitivo;
	}

	public Long getIdProfiloLettura() {
		return idProfiloLettura;
	}

	public void setIdProfiloLettura(Long idProfiloLettura) {
		this.idProfiloLettura = idProfiloLettura;
	}

	public Date getDtUltimaModifica() {
		return dtUltimaModifica;
	}

	public void setDtUltimaModifica(Date dtUltimaModifica) {
		this.dtUltimaModifica = dtUltimaModifica;
	}

	public String getAutoProfiling() {
		return autoProfiling;
	}

	public void setAutoProfiling(String autoProfiling) {
		this.autoProfiling = autoProfiling;
	}



	@Override
	public String toString() {
		return "CrzLenntProfilo [matricolaLenntPrimitivo=" + matricolaLenntPrimitivo + ", idProfiloLettura="
				+ idProfiloLettura + ", dtUltimaModifica=" + dtUltimaModifica + ", autoProfiling=" + autoProfiling
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoProfiling == null) ? 0 : autoProfiling.hashCode());
		result = prime * result + ((dtUltimaModifica == null) ? 0 : dtUltimaModifica.hashCode());
		result = prime * result + ((idProfiloLettura == null) ? 0 : idProfiloLettura.hashCode());
		result = prime * result + ((matricolaLenntPrimitivo == null) ? 0 : matricolaLenntPrimitivo.hashCode());
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
		CrzLenntProfilo other = (CrzLenntProfilo) obj;
		if (autoProfiling == null) {
			if (other.autoProfiling != null)
				return false;
		} else if (!autoProfiling.equals(other.autoProfiling))
			return false;
		if (dtUltimaModifica == null) {
			if (other.dtUltimaModifica != null)
				return false;
		} else if (!dtUltimaModifica.equals(other.dtUltimaModifica))
			return false;
		if (idProfiloLettura == null) {
			if (other.idProfiloLettura != null)
				return false;
		} else if (!idProfiloLettura.equals(other.idProfiloLettura))
			return false;
		if (matricolaLenntPrimitivo == null) {
			if (other.matricolaLenntPrimitivo != null)
				return false;
		} else if (!matricolaLenntPrimitivo.equals(other.matricolaLenntPrimitivo))
			return false;
		return true;
	}



		
}