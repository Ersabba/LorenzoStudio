package com.ericsson.mgcf.business;

import java.io.Serializable;
import java.util.Date;

public class ActivityCriteriaBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int idEs;
	String[] taskId;
	String state;
	String[] meterId;
	String codPos;
	Date beginDate;
	Date endDate;
	int minRows;
	int maxRows;
	
	public ActivityCriteriaBO() {}

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}

	public String[] getTaskId() {
		return taskId;
	}

	public void setTaskId(String[] taskId) {
		this.taskId = taskId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String[] getMeterId() {
		return meterId;
	}

	public void setMeterId(String[] meterId) {
		this.meterId = meterId;
	}

	public String getCodPos() {
		return codPos;
	}

	public void setCodPos(String codPos) {
		this.codPos = codPos;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getMinRows() {
		return minRows;
	}

	public void setMinRows(int minRows) {
		this.minRows = minRows;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + ((codPos == null) ? 0 : codPos.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + idEs;
		result = prime * result + maxRows;
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result + minRows;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ActivityCriteriaBO other = (ActivityCriteriaBO) obj;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		if (codPos == null) {
			if (other.codPos != null)
				return false;
		} else if (!codPos.equals(other.codPos))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (idEs != other.idEs)
			return false;
		if (maxRows != other.maxRows)
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (minRows != other.minRows)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}

	
	
	
	

}
