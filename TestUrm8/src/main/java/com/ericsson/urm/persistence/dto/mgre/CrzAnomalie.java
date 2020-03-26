package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * The persistent class for the GRE_CRZ_ANOMALIE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_ANOMALIE")
public class CrzAnomalie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "crzAnomaliaIdGenerator", sequenceName = "SQN_ID_CRZANOMALIE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="crzAnomaliaIdGenerator")
	@Column(name="ID_LOG", unique=true, nullable=false)
	private Long idLog;

	@Column(name="CRZ_MAT")
	private String crzMat;
	
	@Column(name="POST_DATA")
	private String postData;
	   
	@Temporal(TemporalType.DATE)
	@Column(name="URM_DATE")
	private Date urmDate;
	
	public CrzAnomalie(){}

	public Long getIdLog() {
		return idLog;
	}

	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public Date getUrmDate() {
		return urmDate;
	}

	public void setUrmDate(Date urmDate) {
		this.urmDate = urmDate;
	}

	public String getCrzMat() {
		return crzMat;
	}

	public void setCrzMat(String crzMat) {
		this.crzMat = crzMat;
	}


	@Override
	public String toString() {
		return "CrzLogPost [idLog=" + idLog + ", crzMat=" + crzMat
				+ ", postData=" + postData
				+ ", urmDate=" + urmDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crzMat == null) ? 0 : crzMat.hashCode());
		result = prime * result + ((idLog == null) ? 0 : idLog.hashCode());
		result = prime * result
				+ ((postData == null) ? 0 : postData.hashCode());
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
		CrzAnomalie other = (CrzAnomalie) obj;
		if (crzMat == null) {
			if (other.crzMat != null)
				return false;
		} else if (!crzMat.equals(other.crzMat))
			return false;
		if (idLog == null) {
			if (other.idLog != null)
				return false;
		} else if (!idLog.equals(other.idLog))
			return false;
		if (postData == null) {
			if (other.postData != null)
				return false;
		} else if (!postData.equals(other.postData))
			return false;
		if (urmDate == null) {
			if (other.urmDate != null)
				return false;
		} else if (!urmDate.equals(other.urmDate))
			return false;
		return true;
	}

		

}