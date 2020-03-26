package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the GRE_CRZ_EVENT_LOG database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_EVENT_LOG")
public class CrzEventLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "crzEventLogIdGenerator", sequenceName = "SQN_CRZ_EVENTLOG",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="crzEventLogIdGenerator")	
	@Column(name="ID_LOG", unique=true, nullable=false)
	private Long idLog;

	@Column(name="MATRICOLA_CRZ")
	private String matricolaCrz;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EVENT_TIMESTAMP")
	private Date eventTimestamp;
	
	@Column(name="EVENT_CODE")
	private String eventCode;

	@Column(name="ESITO")
	private String esito;

	@Column(name="PARAMETERS")
	private String parameters;
	
	
	public CrzEventLog(){
		super();
	}


	public CrzEventLog(String matricolaCrz,
			String eventCode, String esito, String parameters) {
		super();
		this.matricolaCrz = matricolaCrz;
		this.eventTimestamp = new Date();
		this.eventCode = eventCode;
		this.esito = esito;
		this.parameters = parameters;
	}


	public Long getIdLog() {
		return idLog;
	}


	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}


	public String getMatricolaCrz() {
		return matricolaCrz;
	}


	public void setMatricolaCrz(String matricolaCrz) {
		this.matricolaCrz = matricolaCrz;
	}


	public Date getEventTimestamp() {
		return eventTimestamp;
	}


	public void setEventTimestamp(Date eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}


	public String getEventCode() {
		return eventCode;
	}


	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}


	public String getEsito() {
		return esito;
	}


	public void setEsito(String esito) {
		this.esito = esito;
	}


	public String getParameters() {
		return parameters;
	}


	public void setParameters(String parameters) {
		this.parameters = parameters;
	}


	@Override
	public String toString() {
		return "CrzEventLog [idLog=" + idLog + ", matricolaCrz=" + matricolaCrz
				+ ", eventTimestamp=" + eventTimestamp + ", eventCode="
				+ eventCode + ", esito=" + esito + ", parameters=" + parameters
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result
				+ ((eventCode == null) ? 0 : eventCode.hashCode());
		result = prime * result
				+ ((eventTimestamp == null) ? 0 : eventTimestamp.hashCode());
		result = prime * result + ((idLog == null) ? 0 : idLog.hashCode());
		result = prime * result
				+ ((matricolaCrz == null) ? 0 : matricolaCrz.hashCode());
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
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
		CrzEventLog other = (CrzEventLog) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (eventCode == null) {
			if (other.eventCode != null)
				return false;
		} else if (!eventCode.equals(other.eventCode))
			return false;
		if (eventTimestamp == null) {
			if (other.eventTimestamp != null)
				return false;
		} else if (!eventTimestamp.equals(other.eventTimestamp))
			return false;
		if (idLog == null) {
			if (other.idLog != null)
				return false;
		} else if (!idLog.equals(other.idLog))
			return false;
		if (matricolaCrz == null) {
			if (other.matricolaCrz != null)
				return false;
		} else if (!matricolaCrz.equals(other.matricolaCrz))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		return true;
	}


	
	
	
}