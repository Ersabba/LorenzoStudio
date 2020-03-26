package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class StorMisuPotMensili implements Serializable, MisuPotMensiliInterface, MgdbDto {
	private static final long serialVersionUID = -1;
	private StorMisuPotMensiliId id;
	private String codConcentratore = null;
	private String strValueT1;
	private String strValueT2;
	private String strValueT3;
	private String strValueT4;
	private Date dataRilT1 = null;
	private Date dataRilT2 = null;
	private Date dataRilT3 = null;
	private Date dataRilT4 = null;
	private Date dataAcq = null;
	private String provenienza=null;

	public Object clone() {
		try {
			StorMisuPotMensili ret = (StorMisuPotMensili) super.clone();
			if (id != null)
				ret.id = (StorMisuPotMensiliId) id.clone();
			if (dataRilT1 != null)
				ret.dataRilT1 = (Date) dataRilT1.clone();
			if (dataRilT2 != null)
				ret.dataRilT2 = (Date) dataRilT2.clone();
			if (dataRilT3 != null)
				ret.dataRilT3 = (Date) dataRilT3.clone();
			if (dataRilT4 != null)
				ret.dataRilT4 = (Date) dataRilT4.clone();
			if (dataAcq != null)
				ret.dataAcq = (Date) dataAcq.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		StorMisuPotMensili other = (StorMisuPotMensili)srcDto;
		if (other.id != null)
			this.id = (StorMisuPotMensiliId)other.id.clone();
		else
			this.id = null;

		this.codConcentratore = other.codConcentratore;
		this.strValueT1 = other.strValueT1;
		this.strValueT2 = other.strValueT2;
		this.strValueT3 = other.strValueT3;
		this.strValueT4 = other.strValueT4;
		this.dataRilT1 = other.dataRilT1;
		this.dataRilT2 = other.dataRilT2;
		this.dataRilT3 = other.dataRilT3;
		this.dataRilT4 = other.dataRilT4;
		this.dataAcq = other.dataAcq;
		this.provenienza = other.provenienza;
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public StorMisuPotMensiliId getId() {
		return id;
	}

	public void setId(StorMisuPotMensiliId id) {
		this.id = id;
	}

	
	public String getMatricolaLenntCliente() {
		if(id!=null)
			return id.getMatricolaLenntCliente();
		else return null;
	}
	
	public Date getDataAcq() {
		return dataAcq;
	}

	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public Date getDataRilT1() {
		return dataRilT1;
	}

	public void setDataRilT1(Date dataRilT1) {
		this.dataRilT1 = dataRilT1;
	}

	public Date getDataRilT2() {
		return dataRilT2;
	}

	public void setDataRilT2(Date dataRilT2) {
		this.dataRilT2 = dataRilT2;
	}

	public Date getDataRilT3() {
		return dataRilT3;
	}

	public void setDataRilT3(Date dataRilT3) {
		this.dataRilT3 = dataRilT3;
	}

	public Date getDataRilT4() {
		return dataRilT4;
	}

	public void setDataRilT4(Date dataRilT4) {
		this.dataRilT4 = dataRilT4;
	}

	public Long getValueT1() {
		Long ret = null;
		if (strValueT1 != null)
			ret = new Long(strValueT1);
		return ret;
	}

	public void setValueT1(Long value) {
		if (value == null)
			strValueT1 = null;
		strValueT1 = value.toString();
	}

	public Long getValueT2() {
		Long ret = null;
		if (strValueT2 != null)
			ret = new Long(strValueT2);
		return ret;
	}

	public void setValueT2(Long value) {
		if (value == null)
			strValueT2 = null;
		strValueT2 = value.toString();
	}

	public Long getValueT3() {
		Long ret = null;
		if (strValueT3 != null)
			ret = new Long(strValueT3);
		return ret;
	}

	public void setValueT3(Long value) {
		if (value == null)
			strValueT3 = null;
		strValueT3 = value.toString();
	}

	public Long getValueT4() {
		Long ret = null;
		if (strValueT4 != null)
			ret = new Long(strValueT4);
		return ret;
	}

	public void setValueT4(Long value) {
		if (value == null)
			strValueT4 = null;
		strValueT4 = value.toString();
	}

	public Date getDataRil() {
		Date ret=null;
		if(id!=null)
			ret=id.getDataRil();
		return ret;
	}


	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result
				+ ((dataRilT1 == null) ? 0 : dataRilT1.hashCode());
		result = prime * result
				+ ((dataRilT2 == null) ? 0 : dataRilT2.hashCode());
		result = prime * result
				+ ((dataRilT3 == null) ? 0 : dataRilT3.hashCode());
		result = prime * result
				+ ((dataRilT4 == null) ? 0 : dataRilT4.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((provenienza == null) ? 0 : provenienza.hashCode());
		result = prime * result
				+ ((strValueT1 == null) ? 0 : strValueT1.hashCode());
		result = prime * result
				+ ((strValueT2 == null) ? 0 : strValueT2.hashCode());
		result = prime * result
				+ ((strValueT3 == null) ? 0 : strValueT3.hashCode());
		result = prime * result
				+ ((strValueT4 == null) ? 0 : strValueT4.hashCode());
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
		StorMisuPotMensili other = (StorMisuPotMensili) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (dataRilT1 == null) {
			if (other.dataRilT1 != null)
				return false;
		} else if (!dataRilT1.equals(other.dataRilT1))
			return false;
		if (dataRilT2 == null) {
			if (other.dataRilT2 != null)
				return false;
		} else if (!dataRilT2.equals(other.dataRilT2))
			return false;
		if (dataRilT3 == null) {
			if (other.dataRilT3 != null)
				return false;
		} else if (!dataRilT3.equals(other.dataRilT3))
			return false;
		if (dataRilT4 == null) {
			if (other.dataRilT4 != null)
				return false;
		} else if (!dataRilT4.equals(other.dataRilT4))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (provenienza == null) {
			if (other.provenienza != null)
				return false;
		} else if (!provenienza.equals(other.provenienza))
			return false;
		if (strValueT1 == null) {
			if (other.strValueT1 != null)
				return false;
		} else if (!strValueT1.equals(other.strValueT1))
			return false;
		if (strValueT2 == null) {
			if (other.strValueT2 != null)
				return false;
		} else if (!strValueT2.equals(other.strValueT2))
			return false;
		if (strValueT3 == null) {
			if (other.strValueT3 != null)
				return false;
		} else if (!strValueT3.equals(other.strValueT3))
			return false;
		if (strValueT4 == null) {
			if (other.strValueT4 != null)
				return false;
		} else if (!strValueT4.equals(other.strValueT4))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StorMisuPotMensili [id=" + id + ", codConcentratore="
				+ codConcentratore + ", strValueT1=" + strValueT1
				+ ", strValueT2=" + strValueT2 + ", strValueT3=" + strValueT3
				+ ", strValueT4=" + strValueT4 + ", dataRilT1=" + dataRilT1
				+ ", dataRilT2=" + dataRilT2 + ", dataRilT3=" + dataRilT3
				+ ", dataRilT4=" + dataRilT4 + ", dataAcq=" + dataAcq
				+ ", provenienza=" + provenienza + "]";
	}
	
	
	
}
