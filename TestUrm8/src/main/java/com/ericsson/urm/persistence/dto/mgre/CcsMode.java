package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="GRE_CCS_MODE")
public class CcsMode implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@Id
	@Column(name = "CCS_CODE")
	private String ccsCode;
	
	@Column(name = "CCS_MODE")
	private String ccsMode;

	
	@Column(name = "DATA_ORA_INIZIO")
	private Date dataOraInizio;
	
	@Column(name = "DATA_ORA_INIZIO_MILLIS")
	private long dataOraInizioMillis;
	
	@Column(name="TIMEOUT_SECONDS")
	private long timeOutSeconds;
	
	@Column(name="TASK_ID")
	private long taskId;
	
	public CcsMode(){
		
	}
	

	public String getCcsCode() {
		return ccsCode;
	}

	public void setCcsCode(String ccsCode) {
		this.ccsCode = ccsCode;
	}

	public String getCcsMode() {
		return ccsMode;
	}

	public void setCcsMode(String ccsMode) {
		this.ccsMode = ccsMode;
	}

	public Date getDataOraInizio() {
		return dataOraInizio;
	}

	public void setDataOraInizio(Date dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}


	public long getDataOraInizioMillis() {
		return dataOraInizioMillis;
	}


	public void setDataOraInizioMillis(long millis) {
		this.dataOraInizioMillis = millis;
	}


	public long getTimeOutSeconds() {
		return timeOutSeconds;
	}


	public void setTimeOutSeconds(long timeOutSeconds) {
		this.timeOutSeconds = timeOutSeconds;
	}


	public long getTaskId() {
		return taskId;
	}


	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}



	
}
