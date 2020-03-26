package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class DqsTensioneMaxMin implements Serializable {
	private static final long serialVersionUID = -1;
	
	private DqsTensioneMaxMinId id;
	
	private String matricolaCcs = null;
	private Date dataAcq=null;
	private Integer	tensioneFaseR;
	private Integer	tensioneFaseS;
	private Integer	tensioneFaseT;	
	
	
	public DqsTensioneMaxMin() {
		
	}	


	public DqsTensioneMaxMin(DqsTensioneMaxMinId id, String matricolaCcs,
			Date dataAcq, Integer tensioneFaseR, Integer tensioneFaseS,
			Integer tensioneFaseT) {
		super();
		this.id = id;
		this.matricolaCcs = matricolaCcs;
		this.dataAcq = dataAcq;
		this.tensioneFaseR = tensioneFaseR;
		this.tensioneFaseS = tensioneFaseS;
		this.tensioneFaseT = tensioneFaseT;
	}



	public DqsTensioneMaxMinId getId() {
		return id;
	}


	public void setId(DqsTensioneMaxMinId id) {
		this.id = id;
	}


	public String getMatricolaCcs() {
		return matricolaCcs;
	}


	public void setMatricolaCcs(String matricolaCcs) {
		this.matricolaCcs = matricolaCcs;
	}


	public Date getDataAcq() {
		return dataAcq;
	}


	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}


	public Integer getTensioneFaseR() {
		return tensioneFaseR;
	}


	public void setTensioneFaseR(Integer tensioneFaseR) {
		this.tensioneFaseR = tensioneFaseR;
	}


	public Integer getTensioneFaseS() {
		return tensioneFaseS;
	}


	public void setTensioneFaseS(Integer tensioneFaseS) {
		this.tensioneFaseS = tensioneFaseS;
	}


	public Integer getTensioneFaseT() {
		return tensioneFaseT;
	}


	public void setTensioneFaseT(Integer tensioneFaseT) {
		this.tensioneFaseT = tensioneFaseT;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((matricolaCcs == null) ? 0 : matricolaCcs.hashCode());
		result = prime * result
				+ ((tensioneFaseR == null) ? 0 : tensioneFaseR.hashCode());
		result = prime * result
				+ ((tensioneFaseS == null) ? 0 : tensioneFaseS.hashCode());
		result = prime * result
				+ ((tensioneFaseT == null) ? 0 : tensioneFaseT.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DqsTensioneMaxMin other = (DqsTensioneMaxMin) obj;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricolaCcs == null) {
			if (other.matricolaCcs != null)
				return false;
		} else if (!matricolaCcs.equals(other.matricolaCcs))
			return false;
		if (tensioneFaseR == null) {
			if (other.tensioneFaseR != null)
				return false;
		} else if (!tensioneFaseR.equals(other.tensioneFaseR))
			return false;
		if (tensioneFaseS == null) {
			if (other.tensioneFaseS != null)
				return false;
		} else if (!tensioneFaseS.equals(other.tensioneFaseS))
			return false;
		if (tensioneFaseT == null) {
			if (other.tensioneFaseT != null)
				return false;
		} else if (!tensioneFaseT.equals(other.tensioneFaseT))
			return false;
		return true;
	}

	
	
}
