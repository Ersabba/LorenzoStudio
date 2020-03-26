package com.ericsson.mgre.datatypes.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class TaskOnRecipientMessage implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private long taskId;
	private int idRecipientList;
	private String activityCode;
	private Date startDate;
	
	private int beginIndex = -1;
	private int endIndex = -1;

	private ArrayList<?> recipientList;
	
	public TaskOnRecipientMessage() {
	}
	
	public TaskOnRecipientMessage(long taskId, int idRecipientList,
			String activityCode, Date startDate, ArrayList<?> recipientList) {
		
		this.taskId = taskId;
		this.idRecipientList = idRecipientList;
		this.activityCode = activityCode;
		this.startDate = startDate;
		this.recipientList = recipientList;
		beginIndex = -1;
		endIndex = -1;
	}
	
	public TaskOnRecipientMessage(long taskId, int idRecipientList,
			String activityCode, Date startDate, int beginIndex, int endIndex) {
		
		this.taskId = taskId;
		this.idRecipientList = idRecipientList;
		this.activityCode = activityCode;
		this.startDate = startDate;
		this.recipientList = null;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	public long getTaskId() {
		return taskId;
	}


	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}


	public String getActivityCode() {
		return activityCode;
	}


	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ArrayList getRecipientList() {
		return recipientList;
	}


	public void setRecipientList(ArrayList recipientList) {
		this.recipientList = recipientList;
	}
	
	public int getIdRecipientList() {
		return idRecipientList;
	}

	public void setIdRecipientList(int idRecipientList) {
		this.idRecipientList = idRecipientList;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activityCode == null) ? 0 : activityCode.hashCode());
		result = prime * result + beginIndex;
		result = prime * result + endIndex;
		result = prime * result + idRecipientList;
		result = prime * result
				+ ((recipientList == null) ? 0 : recipientList.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (int) (taskId ^ (taskId >>> 32));
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
		TaskOnRecipientMessage other = (TaskOnRecipientMessage) obj;
		if (activityCode == null) {
			if (other.activityCode != null)
				return false;
		} else if (!activityCode.equals(other.activityCode))
			return false;
		if (beginIndex != other.beginIndex)
			return false;
		if (endIndex != other.endIndex)
			return false;
		if (idRecipientList != other.idRecipientList)
			return false;
		if (recipientList == null) {
			if (other.recipientList != null)
				return false;
		} else if (!recipientList.equals(other.recipientList))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

}
