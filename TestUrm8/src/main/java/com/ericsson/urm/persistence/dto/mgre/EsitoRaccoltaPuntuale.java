package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class EsitoRaccoltaPuntuale implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long taskId;
	private Date dataEsecuzione;
	private long nLenntEstratti;
	private long nLenntContattati;
	private long nLenntAcquisiti;
		
	public EsitoRaccoltaPuntuale(){
		
	}

	public EsitoRaccoltaPuntuale(long taskId, Date dataEsecuzione,
			long nLenntEstratti, long nLenntContattati, long nLenntAcquisiti) {
		super();
		this.taskId = taskId;
		this.dataEsecuzione = dataEsecuzione;
		this.nLenntEstratti = nLenntEstratti;
		this.nLenntContattati = nLenntContattati;
		this.nLenntAcquisiti = nLenntAcquisiti;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public Date getDataEsecuzione() {
		return dataEsecuzione;
	}

	public void setDataEsecuzione(Date dataEsecuzione) {
		this.dataEsecuzione = dataEsecuzione;
	}

	public long getnLenntEstratti() {
		return nLenntEstratti;
	}

	public void setnLenntEstratti(long nLenntEstratti) {
		this.nLenntEstratti = nLenntEstratti;
	}

	public long getnLenntContattati() {
		return nLenntContattati;
	}

	public void setnLenntContattati(long nLenntContattati) {
		this.nLenntContattati = nLenntContattati;
	}

	public long getnLenntAcquisiti() {
		return nLenntAcquisiti;
	}

	public void setnLenntAcquisiti(long nLenntAcquisiti) {
		this.nLenntAcquisiti = nLenntAcquisiti;
	}

	@Override
	public String toString() {
		return "EsitoRaccoltaPuntuale [taskId=" + taskId + ", dataEsecuzione="
				+ dataEsecuzione + ", nLenntEstratti=" + nLenntEstratti
				+ ", nLenntContattati=" + nLenntContattati
				+ ", nLenntAcquisiti=" + nLenntAcquisiti + "]";
	}
	


			
}