package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the GRE_CRZ_LETTURE_SCARTATE database table.
 *
 */
@Embeddable
public class CrzLettureScartateId implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MATRICOLA_CRZ")
	private String matricolaCrz;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="URMdate")
	private java.util.Date urmDate;
	  
    @Column(name="COMPONENTE_ENERGETICA")
	private String componenteEnergetica;
    
    @Column(name="TIPO_REGISTRO")
   	private String tipoRegistro;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date conndate;


	public CrzLettureScartateId() {
	}


	public String getMatricolaCrz() {
		return matricolaCrz;
	}


	public void setMatricolaCrz(String matricolaCrz) {
		this.matricolaCrz = matricolaCrz;
	}


	public java.util.Date getUrmDate() {
		return urmDate;
	}


	public void setUrmDate(java.util.Date urmDate) {
		this.urmDate = urmDate;
	}


	public String getComponenteEnergetica() {
		return componenteEnergetica;
	}


	public void setComponenteEnergetica(String componenteEnergetica) {
		this.componenteEnergetica = componenteEnergetica;
	}


	public String getTipoRegistro() {
		return tipoRegistro;
	}


	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}




	public Date getConndate() {
		return conndate;
	}


	public void setConndate(Date conndate) {
		this.conndate = conndate;
	}


	@Override
	public String toString() {
		return "CrzLettureScartateId [matricolaCrz=" + matricolaCrz
				+ ", urmDate=" + urmDate + ", componenteEnergetica="
				+ componenteEnergetica + ", tipoRegistro=" + tipoRegistro
				+ ", conndate=" + conndate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((componenteEnergetica == null) ? 0 : componenteEnergetica
						.hashCode());
		result = prime * result
				+ ((conndate == null) ? 0 : conndate.hashCode());
		result = prime * result
				+ ((matricolaCrz == null) ? 0 : matricolaCrz.hashCode());
		result = prime * result
				+ ((tipoRegistro == null) ? 0 : tipoRegistro.hashCode());
		result = prime * result + ((urmDate == null) ? 0 : urmDate.hashCode());
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
		CrzLettureScartateId other = (CrzLettureScartateId) obj;
		if (componenteEnergetica == null) {
			if (other.componenteEnergetica != null)
				return false;
		} else if (!componenteEnergetica.equals(other.componenteEnergetica))
			return false;
		if (conndate == null) {
			if (other.conndate != null)
				return false;
		} else if (!conndate.equals(other.conndate))
			return false;
		if (matricolaCrz == null) {
			if (other.matricolaCrz != null)
				return false;
		} else if (!matricolaCrz.equals(other.matricolaCrz))
			return false;
		if (tipoRegistro == null) {
			if (other.tipoRegistro != null)
				return false;
		} else if (!tipoRegistro.equals(other.tipoRegistro))
			return false;
		if (urmDate == null) {
			if (other.urmDate != null)
				return false;
		} else if (!urmDate.equals(other.urmDate))
			return false;
		return true;
	}
	
	
	
}