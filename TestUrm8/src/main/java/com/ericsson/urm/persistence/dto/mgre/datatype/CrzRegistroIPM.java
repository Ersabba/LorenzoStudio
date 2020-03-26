package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.datatype.ComponentId;

public class CrzRegistroIPM implements Serializable {
	
	private static Logger logger = Logger.getLogger(CrzRegistroIPM.class);
	
	private static final long serialVersionUID = 1L;
	
	private ComponentId componente;
	private String crz;
	private String matricolaLenntCliente;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String d1;
	private String d2;
	private String d3;
	private String d4;
	private Date dataRil;  //connDate
	private Date acqDate;  //urmDate
	private Provenienza provenienza;
	private String esito = "0";
	private String integrationperiod = "IPM";
	private String crzDate;
	private String lenntPrimitivo;
	private String lenntDate;
	

	
	
	public CrzRegistroIPM(ComponentId componente, String crz,
			String matricolaLenntCliente, String t1, String t2, String t3,
			String t4, String d1, String d2, String d3, String d4,
			Date dataRil, Date acqDate, Provenienza provenienza, String esito,
			String integrationperiod, String crzDate, String lenntPrimitivo, String lenntDate) {
		super();
		this.componente = componente;
		this.crz = crz;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
		this.dataRil = dataRil;
		this.acqDate = acqDate;
		this.provenienza = provenienza;
		this.esito = esito;
		this.integrationperiod = integrationperiod;
		this.crzDate = crzDate;
		this.lenntPrimitivo = lenntPrimitivo;
		this.lenntDate = lenntDate;
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
	public String getD1() {
		return d1;
	}
	public void setD1(String d1) {
		this.d1 = d1;
	}
	public String getD2() {
		return d2;
	}
	public void setD2(String d2) {
		this.d2 = d2;
	}
	public String getD3() {
		return d3;
	}
	public void setD3(String d3) {
		this.d3 = d3;
	}
	public String getD4() {
		return d4;
	}
	public void setD4(String d4) {
		this.d4 = d4;
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
	
	public String getIntegrationperiod() {
		return integrationperiod;
	}
	
	public String getCrzDate() {
		return crzDate;
	}
	public void setCrzDate(String crzDate) {
		this.crzDate = crzDate;
	}
	public String getLenntDate() {
		return lenntDate;
	}
	public void setLenntDate(String lenntDate) {
		this.lenntDate = lenntDate;
	}
	public String getLenntPrimitivo() {
		return lenntPrimitivo;
	}

	public void setLenntPrimitivo(String lenntPrimitivo) {
		this.lenntPrimitivo = lenntPrimitivo;
	}

	public void setIntegrationperiod(String integrationperiod) {
		this.integrationperiod = integrationperiod;
	}
	@Override
	public String toString() {
		return "CrzRegistroIPM [componente=" + componente + ", crz=" + crz
				+ ", matricolaLenntCliente=" + matricolaLenntCliente + ", t1="
				+ t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4 + ", d1="
				+ d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4
				+ ", dataRil=" + dataRil + ", acqDate=" + acqDate
				+ ", provenienza=" + provenienza + ", esito=" + esito
				+ ", integrationperiod=" + integrationperiod + ", crzDate="
				+ crzDate + ", lenntPrimitivo=" + lenntPrimitivo
				+ ", lenntDate=" + lenntDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acqDate == null) ? 0 : acqDate.hashCode());
		result = prime * result
				+ ((componente == null) ? 0 : componente.hashCode());
		result = prime * result + ((crz == null) ? 0 : crz.hashCode());
		result = prime * result + ((crzDate == null) ? 0 : crzDate.hashCode());
		result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
		result = prime * result + ((d2 == null) ? 0 : d2.hashCode());
		result = prime * result + ((d3 == null) ? 0 : d3.hashCode());
		result = prime * result + ((d4 == null) ? 0 : d4.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime
				* result
				+ ((integrationperiod == null) ? 0 : integrationperiod
						.hashCode());
		result = prime * result
				+ ((lenntDate == null) ? 0 : lenntDate.hashCode());
		result = prime * result
				+ ((lenntPrimitivo == null) ? 0 : lenntPrimitivo.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((provenienza == null) ? 0 : provenienza.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
		result = prime * result + ((t3 == null) ? 0 : t3.hashCode());
		result = prime * result + ((t4 == null) ? 0 : t4.hashCode());
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
		CrzRegistroIPM other = (CrzRegistroIPM) obj;
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
		if (d1 == null) {
			if (other.d1 != null)
				return false;
		} else if (!d1.equals(other.d1))
			return false;
		if (d2 == null) {
			if (other.d2 != null)
				return false;
		} else if (!d2.equals(other.d2))
			return false;
		if (d3 == null) {
			if (other.d3 != null)
				return false;
		} else if (!d3.equals(other.d3))
			return false;
		if (d4 == null) {
			if (other.d4 != null)
				return false;
		} else if (!d4.equals(other.d4))
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
		if (integrationperiod == null) {
			if (other.integrationperiod != null)
				return false;
		} else if (!integrationperiod.equals(other.integrationperiod))
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
		return true;
	}

	
}
