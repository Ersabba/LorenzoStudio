package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class CurvaCaricoConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String  matricolaLenntCliente;
	private String  periodoCurve;
	private Integer abilAttAss = 0;
	private Integer abilAttEr = 0;
	private Integer abilReattIndAss = 0;
	private Integer abilReattIndEr = 0;
	private Integer abilReattCapAss = 0;
	private Integer abilReattCapEr = 0;
	private String  abilDisponibCampioni;
	private Date    dataAbilDisponib;
	private String  modalitaInserimento = null;
	private Integer flagMonitor = 0;
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getPeriodoCurve() {
		return periodoCurve;
	}
	public void setPeriodoCurve(String periodoCurve) {
		this.periodoCurve = periodoCurve;
	}
	public Boolean getAbilAttAss() {
		if (abilAttAss != null)
			return abilAttAss == 0 ? false : true;
		return null;
	}
	public void setAbilAttAss(Boolean abilAttAss) {
		if (abilAttAss != null)
			this.abilAttAss = abilAttAss ? 1 : 0;
		else
			this.abilAttAss = 0;
	}
	public Boolean getAbilAttEr() {
		if (abilAttEr != null)
			return abilAttEr == 0 ? false : true;
		return null;
	}
	public void setAbilAttEr(Boolean abilAttEr) {
		if (abilAttEr != null)
			this.abilAttEr = abilAttEr ? 1 : 0;
		else
			this.abilAttEr = 0;
	}
	public Boolean getAbilReattIndAss() {
		if (abilReattIndAss != null)
			return abilReattIndAss == 0 ? false : true;
		return null;
	}
	public void setAbilReattIndAss(Boolean abilReattIndAss) {
		if (abilReattIndAss != null)
			this.abilReattIndAss = abilReattIndAss ? 1 : 0;
		else
			this.abilReattIndAss = 0;
	}
	public Boolean getAbilReattIndEr() {
		if (abilReattIndEr != null)
			return abilReattIndEr == 0 ? false : true;
		return null;
	}
	public void setAbilReattIndEr(Boolean abilReattIndEr) {
		if (abilReattIndEr != null)
			this.abilReattIndEr = abilReattIndEr ? 1 : 0;
		else
			this.abilReattIndEr = 0;
	}
	public Boolean getAbilReattCapAss() {
		if (abilReattCapAss != null)
			return abilReattCapAss == 0 ? false : true;
		return null;
	}
	public void setAbilReattCapAss(Boolean abilReattCapAss) {
		if (abilReattCapAss != null)
			this.abilReattCapAss = abilReattCapAss ? 1 : 0;
		else
			this.abilReattCapAss = 0;
	}
	public Boolean getAbilReattCapEr() {
		if (abilReattCapEr != null)
			return abilReattCapEr == 0 ? false : true;
		return null;
	}
	public void setAbilReattCapEr(Boolean abilReattCapEr) {
		if (abilReattCapEr != null)
			this.abilReattCapEr = abilReattCapEr ? 1 : 0;
		else
			this.abilReattCapEr = 0;
	}
	public String getAbilDisponibCampioni() {
		return abilDisponibCampioni;
	}
	public void setAbilDisponibCampioni(String abilDisponibCampioni) {
		this.abilDisponibCampioni = abilDisponibCampioni;
	}
	public Date getDataAbilDisponib() {
		return dataAbilDisponib;
	}
	public void setDataAbilDisponib(Date dataAbilDisponib) {
		this.dataAbilDisponib = dataAbilDisponib;
	}
	
	public String getModalitaInserimento() {
		return modalitaInserimento;
	}
	public void setModalitaInserimento(String modalitaInserimento) {
		this.modalitaInserimento = modalitaInserimento;
	}
	
	public Boolean getFlagMonitor() {
		if (flagMonitor != null)
			return flagMonitor == 0 ? false : true;
		return null;
	}
	public void setFlagMonitor(Boolean flagMonitor) {
		if (flagMonitor != null)
			this.flagMonitor = flagMonitor ? 1 : 0;
		else
			this.flagMonitor = 0;
	}

	public static enum AbilDisponibCampioni {
		A, D, FA, FAD, FD;
		
		public static AbilDisponibCampioni parse(String typeName)	{	
			for (AbilDisponibCampioni curr : AbilDisponibCampioni.values()) {
				if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			}
			
			throw new IllegalArgumentException ("AbilDisponibCampioni: unsupported type name " + typeName);
		}
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abilAttAss == null) ? 0 : abilAttAss.hashCode());
		result = prime * result
				+ ((abilAttEr == null) ? 0 : abilAttEr.hashCode());
		result = prime
				* result
				+ ((abilDisponibCampioni == null) ? 0 : abilDisponibCampioni
						.hashCode());
		result = prime * result
				+ ((abilReattCapAss == null) ? 0 : abilReattCapAss.hashCode());
		result = prime * result
				+ ((abilReattCapEr == null) ? 0 : abilReattCapEr.hashCode());
		result = prime * result
				+ ((abilReattIndAss == null) ? 0 : abilReattIndAss.hashCode());
		result = prime * result
				+ ((abilReattIndEr == null) ? 0 : abilReattIndEr.hashCode());
		result = prime
				* result
				+ ((dataAbilDisponib == null) ? 0 : dataAbilDisponib.hashCode());
		result = prime * result
				+ ((flagMonitor == null) ? 0 : flagMonitor.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime
				* result
				+ ((modalitaInserimento == null) ? 0 : modalitaInserimento
						.hashCode());
		result = prime * result
				+ ((periodoCurve == null) ? 0 : periodoCurve.hashCode());
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
		CurvaCaricoConfig other = (CurvaCaricoConfig) obj;
		if (abilAttAss == null) {
			if (other.abilAttAss != null)
				return false;
		} else if (!abilAttAss.equals(other.abilAttAss))
			return false;
		if (abilAttEr == null) {
			if (other.abilAttEr != null)
				return false;
		} else if (!abilAttEr.equals(other.abilAttEr))
			return false;
		if (abilDisponibCampioni == null) {
			if (other.abilDisponibCampioni != null)
				return false;
		} else if (!abilDisponibCampioni.equals(other.abilDisponibCampioni))
			return false;
		if (abilReattCapAss == null) {
			if (other.abilReattCapAss != null)
				return false;
		} else if (!abilReattCapAss.equals(other.abilReattCapAss))
			return false;
		if (abilReattCapEr == null) {
			if (other.abilReattCapEr != null)
				return false;
		} else if (!abilReattCapEr.equals(other.abilReattCapEr))
			return false;
		if (abilReattIndAss == null) {
			if (other.abilReattIndAss != null)
				return false;
		} else if (!abilReattIndAss.equals(other.abilReattIndAss))
			return false;
		if (abilReattIndEr == null) {
			if (other.abilReattIndEr != null)
				return false;
		} else if (!abilReattIndEr.equals(other.abilReattIndEr))
			return false;
		if (dataAbilDisponib == null) {
			if (other.dataAbilDisponib != null)
				return false;
		} else if (!dataAbilDisponib.equals(other.dataAbilDisponib))
			return false;
		if (flagMonitor == null) {
			if (other.flagMonitor != null)
				return false;
		} else if (!flagMonitor.equals(other.flagMonitor))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (modalitaInserimento == null) {
			if (other.modalitaInserimento != null)
				return false;
		} else if (!modalitaInserimento.equals(other.modalitaInserimento))
			return false;
		if (periodoCurve == null) {
			if (other.periodoCurve != null)
				return false;
		} else if (!periodoCurve.equals(other.periodoCurve))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CurvaCaricoConfig [matricolaLenntCliente="
				+ matricolaLenntCliente + ", periodoCurve=" + periodoCurve
				+ ", abilAttAss=" + abilAttAss + ", abilAttEr=" + abilAttEr
				+ ", abilReattIndAss=" + abilReattIndAss + ", abilReattIndEr="
				+ abilReattIndEr + ", abilReattCapAss=" + abilReattCapAss
				+ ", abilReattCapEr=" + abilReattCapEr
				+ ", abilDisponibCampioni=" + abilDisponibCampioni
				+ ", dataAbilDisponib=" + dataAbilDisponib
				+ ", modalitaInserimento=" + modalitaInserimento
				+ ", flagMonitor=" + flagMonitor + "]";
	}	
	
	
	
}