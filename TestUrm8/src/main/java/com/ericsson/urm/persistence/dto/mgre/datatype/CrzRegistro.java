package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.datatype.ComponentId;

public class CrzRegistro implements Serializable {
	
	private static Logger logger = Logger.getLogger(CrzRegistro.class);
	
	private static final long serialVersionUID = 1L;
	
	public enum RegEnergyType{
		TOT, MEN;
	}
	
	private ComponentId componente;
	private String crz;
	private String matricolaLenntCliente;
	private String gen;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private Date dataRil;  //connDate
	private Date acqDate;  //urmDate
	private Provenienza provenienza;
	private String esito = "0";
	private RegEnergyType type = null;


	private String crzDate;
	private String lenntPrimitivo;
	private String lenntDate;
	
	public CrzRegistro(ComponentId componente, String crz,
			String matricolaLenntCliente, String gen, String t1, String t2,
			String t3, String t4, Date dataRil, Date acqDate,
			Provenienza provenienza, String esito, String crzDate,
			String lenntPrimitivo, String lenntDate, RegEnergyType type) {
		super();
		this.componente = componente;
		this.crz = crz;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.gen = gen;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.dataRil = dataRil;
		this.acqDate = acqDate;
		this.provenienza = provenienza;
		this.esito = esito;
		this.crzDate = crzDate;
		this.lenntPrimitivo = lenntPrimitivo;
		this.lenntDate = lenntDate;
		this.type = type;
	}
	public ComponentId getComponente() {
		return componente;
	}
	public void setComponente(ComponentId componente) {
		this.componente = componente;
	}
	public String getCrz() {
		return crz;
	}
	public void setCrz(String crz) {
		this.crz = crz;
	}
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT4() {
		return t4;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	public Date getAcqDate() {
		return acqDate;
	}
	public void setAcqDate(Date acqDate) {
		this.acqDate = acqDate;
	}
	public Provenienza getProvenienza() {
		return provenienza;
	}
	public void setProvenienza(Provenienza provenienza) {
		this.provenienza = provenienza;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public String getCrzDate() {
		return crzDate;
	}
	public void setCrzDate(String crzDate) {
		this.crzDate = crzDate;
	}
	public String getLenntPrimitivo() {
		return lenntPrimitivo;
	}
	public void setLenntPrimitivo(String lenntPrimitivo) {
		this.lenntPrimitivo = lenntPrimitivo;
	}
	public String getLenntDate() {
		return lenntDate;
	}
	public void setLenntDate(String lenntDate) {
		this.lenntDate = lenntDate;
	}
	public RegEnergyType getType() {
		return type;
	}
	public void setType(RegEnergyType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CrzRegistro [componente=" + componente + ", crz=" + crz + ", matricolaLenntCliente="
				+ matricolaLenntCliente + ", gen=" + gen + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4
				+ ", dataRil=" + dataRil + ", acqDate=" + acqDate + ", provenienza=" + provenienza + ", esito=" + esito
				+ ", type=" + type + ", crzDate=" + crzDate + ", lenntPrimitivo=" + lenntPrimitivo + ", lenntDate="
				+ lenntDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acqDate == null) ? 0 : acqDate.hashCode());
		result = prime * result + ((componente == null) ? 0 : componente.hashCode());
		result = prime * result + ((crz == null) ? 0 : crz.hashCode());
		result = prime * result + ((crzDate == null) ? 0 : crzDate.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((gen == null) ? 0 : gen.hashCode());
		result = prime * result + ((lenntDate == null) ? 0 : lenntDate.hashCode());
		result = prime * result + ((lenntPrimitivo == null) ? 0 : lenntPrimitivo.hashCode());
		result = prime * result + ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente.hashCode());
		result = prime * result + ((provenienza == null) ? 0 : provenienza.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
		result = prime * result + ((t3 == null) ? 0 : t3.hashCode());
		result = prime * result + ((t4 == null) ? 0 : t4.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CrzRegistro other = (CrzRegistro) obj;
		if (acqDate == null) {
			if (other.acqDate != null)
				return false;
		} else if (!acqDate.equals(other.acqDate))
			return false;
		if (componente != other.componente)
			return false;
		if (crz == null) {
			if (other.crz != null)
				return false;
		} else if (!crz.equals(other.crz))
			return false;
		if (crzDate == null) {
			if (other.crzDate != null)
				return false;
		} else if (!crzDate.equals(other.crzDate))
			return false;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (gen == null) {
			if (other.gen != null)
				return false;
		} else if (!gen.equals(other.gen))
			return false;
		if (lenntDate == null) {
			if (other.lenntDate != null)
				return false;
		} else if (!lenntDate.equals(other.lenntDate))
			return false;
		if (lenntPrimitivo == null) {
			if (other.lenntPrimitivo != null)
				return false;
		} else if (!lenntPrimitivo.equals(other.lenntPrimitivo))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (provenienza != other.provenienza)
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		if (t3 == null) {
			if (other.t3 != null)
				return false;
		} else if (!t3.equals(other.t3))
			return false;
		if (t4 == null) {
			if (other.t4 != null)
				return false;
		} else if (!t4.equals(other.t4))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
