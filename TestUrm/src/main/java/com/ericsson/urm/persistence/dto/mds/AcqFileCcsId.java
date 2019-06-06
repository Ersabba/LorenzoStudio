package com.ericsson.urm.persistence.dto.mds;

import java.io.Serializable;
import java.util.Date;

public class AcqFileCcsId implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private Date acquisitionDate=null;
	private String concentratorId=null;
	private String fileName=null;
		
	
	public AcqFileCcsId() {
		super();
	}

	public AcqFileCcsId(Date acquisitionDate, String concentratorId, String fileName) {
		super();
		this.acquisitionDate = acquisitionDate;
		this.concentratorId = concentratorId;
		this.fileName = fileName;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}


	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}


	public String getConcentratorId() {
		return concentratorId;
	}


	public void setConcentratorId(String concentratorId) {
		this.concentratorId = concentratorId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result
				+ ((concentratorId == null) ? 0 : concentratorId.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AcqFileCcsId other = (AcqFileCcsId) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (concentratorId == null) {
			if (other.concentratorId != null)
				return false;
		} else if (!concentratorId.equals(other.concentratorId))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcqFileCcsId{" +
				"acquisitionDate=" + acquisitionDate +
				", concentratorId='" + concentratorId + '\'' +
				", fileName='" + fileName + '\'' +
				'}';
	}
}
