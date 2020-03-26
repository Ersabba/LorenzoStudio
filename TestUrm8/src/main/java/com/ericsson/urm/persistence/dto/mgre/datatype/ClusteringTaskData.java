package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

import com.ericsson.mgre.biz.taskMgmt.task.dto.GreClusteringTaskDto;

public class ClusteringTaskData extends GreClusteringTaskDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id_row;
	private Long executed;
	private Long failed;
	private Long n_lennt_e;
	private Long n_lennt_f;
	private String data;
	private String validita;
	private String id_1;
	private String id_client_request_1;
	private Long ccs_file_creati;
	private String inizio_finestra_temporale;
	private String fine_finestra_temporale;
	private Long n_lennt_estratti;
	private Long n_lennt_inseriti;
	

	public Long getId_row() {
		return id_row;
	}
	public void setId_row(Long id_row) {
		this.id_row = id_row;
	}

	public Long getExecuted() {
		return executed;
	}
	public void setExecuted(Long executed) {
		this.executed = executed;
	}
	public Long getFailed() {
		return failed;
	}
	public void setFailed(Long failed) {
		this.failed = failed;
	}
	public Long getN_lennt_e() {
		return n_lennt_e;
	}
	public void setN_lennt_e(Long n_lennt_e) {
		this.n_lennt_e = n_lennt_e;
	}
	public Long getN_lennt_f() {
		return n_lennt_f;
	}
	public void setN_lennt_f(Long n_lennt_f) {
		this.n_lennt_f = n_lennt_f;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValidita() {
		return validita;
	}
	public void setValidita(String validita) {
		this.validita = validita;
	}
	public String getId_1() {
		return id_1;
	}
	public void setId_1(String id_1) {
		this.id_1 = id_1;
	}
	public String getId_client_request_1() {
		return id_client_request_1;
	}
	public void setId_client_request_1(String id_client_request_1) {
		this.id_client_request_1 = id_client_request_1;
	}
	public Long getCcs_file_creati() {
		return ccs_file_creati;
	}
	public void setCcs_file_creati(Long ccs_file_creati) {
		this.ccs_file_creati = ccs_file_creati;
	}
	public String getInizio_finestra_temporale() {
		return inizio_finestra_temporale;
	}
	public void setInizio_finestra_temporale(String inizio_finestra_temporale) {
		this.inizio_finestra_temporale = inizio_finestra_temporale;
	}
	public String getFine_finestra_temporale() {
		return fine_finestra_temporale;
	}
	public void setFine_finestra_temporale(String fine_finestra_temporale) {
		this.fine_finestra_temporale = fine_finestra_temporale;
	}
	public Long getN_lennt_estratti() {
		return n_lennt_estratti;
	}
	public void setN_lennt_estratti(Long n_lennt_estratti) {
		this.n_lennt_estratti = n_lennt_estratti;
	}
	public Long getN_lennt_inseriti() {
		return n_lennt_inseriti;
	}
	public void setN_lennt_inseriti(Long n_lennt_inseriti) {
		this.n_lennt_inseriti = n_lennt_inseriti;
	}
	
	
	@Override
	public String toString() {
		return "ClusteringTaskData [  id_row=" + id_row + ", executed=" + executed + ", failed=" + failed + ", n_lennt_e="
				+ n_lennt_e + ", n_lennt_f=" + n_lennt_f + ", data=" + data + ", validita=" + validita + ", id_1="
				+ id_1 + ", id_client_request_1=" + id_client_request_1 + ", ccs_file_creati=" + ccs_file_creati
				+ ", inizio_finestra_temporale=" + inizio_finestra_temporale + ", fine_finestra_temporale="
				+ fine_finestra_temporale + ", n_lennt_estratti=" + n_lennt_estratti + ", n_lennt_inseriti="
				+ n_lennt_inseriti + "], "+super.toString();
	}
}