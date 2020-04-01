package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class StatisticsLogAnalysis implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				fileName;
	private Date				lastRowTimestamp;
	private Date				updateTimestamp;
	private Long				lastBytePosition;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getLastRowTimestamp() {
		return lastRowTimestamp;
	}

	public void setLastRowTimestamp(Date lastRowTimestamp) {
		this.lastRowTimestamp = lastRowTimestamp;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}
	
	public Long getLastBytePosition() {
		return lastBytePosition;
	}

	public void setLastBytePosition(Long lastBytePosition) {
		this.lastBytePosition = lastBytePosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime
				* result
				+ ((lastBytePosition == null) ? 0 : lastBytePosition.hashCode());
		result = prime
				* result
				+ ((lastRowTimestamp == null) ? 0 : lastRowTimestamp.hashCode());
		result = prime * result
				+ ((updateTimestamp == null) ? 0 : updateTimestamp.hashCode());
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
		StatisticsLogAnalysis other = (StatisticsLogAnalysis) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (lastBytePosition == null) {
			if (other.lastBytePosition != null)
				return false;
		} else if (!lastBytePosition.equals(other.lastBytePosition))
			return false;
		if (lastRowTimestamp == null) {
			if (other.lastRowTimestamp != null)
				return false;
		} else if (!lastRowTimestamp.equals(other.lastRowTimestamp))
			return false;
		if (updateTimestamp == null) {
			if (other.updateTimestamp != null)
				return false;
		} else if (!updateTimestamp.equals(other.updateTimestamp))
			return false;
		return true;
	}

}
