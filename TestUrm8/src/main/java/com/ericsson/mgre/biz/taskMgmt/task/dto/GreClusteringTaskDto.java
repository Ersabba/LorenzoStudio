package com.ericsson.mgre.biz.taskMgmt.task.dto;

import java.io.Serializable;
import java.util.Date;

public class GreClusteringTaskDto implements Serializable {


	private static final long serialVersionUID = 1L;
	private String id;
	private String description;
	private String date_start;
	private String time_start;
	private String state;
	private String id_client_request;
	private Date idDate;

	
	public GreClusteringTaskDto() {
	}

	public GreClusteringTaskDto(String id) {
		this.id = id;
	}

	public GreClusteringTaskDto(String id, String description, String date_start, String time_start, String state,
			String id_client_request) {
		this.id = id;
		this.description = description;
		this.date_start = date_start;
		this.time_start = time_start;
		this.state = state;
		this.id_client_request = id_client_request;
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId_client_request() {
		return id_client_request;
	}

	public void setId_client_request(String id_client_request) {
		this.id_client_request = id_client_request;
	}

	public Date getIdDate() {
		return idDate;
	}

	public void setIdDate(Date idDate) {
		this.idDate = idDate;
	}

@Override
public String toString() {
	return "GreClusteringTaskDto [id=" + id + ", description=" + description + ", state=" + state + ", date_start="
			+ date_start + ", time_start=" + time_start + ", id_client_request=" + id_client_request + "]";
}
}
