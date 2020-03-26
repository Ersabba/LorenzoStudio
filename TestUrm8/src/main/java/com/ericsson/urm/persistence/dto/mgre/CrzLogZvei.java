package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the GRE_CRZ_LOG_ZVEI database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_LOG_ZVEI")
public class CrzLogZvei implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name = "crzLogZveiIdGenerator", sequenceName = "SQN_LOGID_ZVEI",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="crzLogZveiIdGenerator")
	@Column(name="LOG_ID", unique=true, nullable=false)
	private Long logId;
	
	@Column(name="MATRICOLA_CRZ")
	private String crzMat;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="URMDATE")
	private Date urmDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LOG_TIMESTAMP")
	private Date logTimestamp;
	
	@Column(name="ESITO_COMUNICAZIONE")
	private Long esitoComunicazione;

	public CrzLogZvei() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getCrzMat() {
		return crzMat;
	}

	public void setCrzMat(String crzMat) {
		this.crzMat = crzMat;
	}

	public Date getUrmDate() {
		return urmDate;
	}

	public void setUrmDate(Date urmDate) {
		this.urmDate = urmDate;
	}

	public Date getLogTimestamp() {
		return logTimestamp;
	}

	public void setLogTimestamp(Date logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

	public Long getEsitoComunicazione() {
		return esitoComunicazione;
	}

	public void setEsitoComunicazione(Long esitoComunicazione) {
		this.esitoComunicazione = esitoComunicazione;
	}

	@Override
	public String toString() {
		return "CrzLogZvei [logId=" + logId + ", crzMat=" + crzMat
				+ ", urmDate=" + urmDate + ", logTimestamp=" + logTimestamp
				+ ", esitoComunicazione=" + esitoComunicazione + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crzMat == null) ? 0 : crzMat.hashCode());
		result = prime
				* result
				+ ((esitoComunicazione == null) ? 0 : esitoComunicazione
						.hashCode());
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		result = prime * result
				+ ((logTimestamp == null) ? 0 : logTimestamp.hashCode());
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
		CrzLogZvei other = (CrzLogZvei) obj;
		if (crzMat == null) {
			if (other.crzMat != null)
				return false;
		} else if (!crzMat.equals(other.crzMat))
			return false;
		if (esitoComunicazione == null) {
			if (other.esitoComunicazione != null)
				return false;
		} else if (!esitoComunicazione.equals(other.esitoComunicazione))
			return false;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		if (logTimestamp == null) {
			if (other.logTimestamp != null)
				return false;
		} else if (!logTimestamp.equals(other.logTimestamp))
			return false;
		if (urmDate == null) {
			if (other.urmDate != null)
				return false;
		} else if (!urmDate.equals(other.urmDate))
			return false;
		return true;
	}
	

}