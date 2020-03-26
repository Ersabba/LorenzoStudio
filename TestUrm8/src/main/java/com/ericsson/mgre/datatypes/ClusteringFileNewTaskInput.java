package com.ericsson.mgre.datatypes;

import java.io.Serializable;


public class ClusteringFileNewTaskInput implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idClusteringTask = null;
	private int durata_finestra_temporale = 0;
	private String region = null;
	private String prefisso_nome_filenew = "NEW";
	private FileNewMode modalita_operativa = FileNewMode.F;  //assume i valori N(solo creazione dei file) / I (solo invio dei file) / F (creazione ed invio dei file)
	private FileNewRequestor richiedente = FileNewRequestor.Clustering;
	
	public int getDurata_finestra_temporale() {
		return durata_finestra_temporale;
	}
	public void setDurata_finestra_temporale(int durata_finestra_temporale) {
		this.durata_finestra_temporale = durata_finestra_temporale;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPrefisso_nome_filenew() {
		return prefisso_nome_filenew;
	}
	public void setPrefisso_nome_filenew(String prefisso_nome_filenew) {
		this.prefisso_nome_filenew = prefisso_nome_filenew;
	}
	public FileNewMode getModalita_operativa() {
		return modalita_operativa;
	}
	public void setModalita_operativa(FileNewMode modalita_operativa) {
		this.modalita_operativa = modalita_operativa;
	}
	public FileNewRequestor getRichiedente() {
		return richiedente;
	}
	public void setRichiedente(FileNewRequestor richiedente) {
		this.richiedente = richiedente;
	}
	
	public String getIdClusteringTask() {
		return idClusteringTask;
	}
	public void setIdClusteringTask(String idClusteringTask) {
		this.idClusteringTask = idClusteringTask;
	}



	public enum FileNewMode{
		I, N, F;
		
		public static FileNewMode parse(String s){
			for(FileNewMode curr : FileNewMode.values()) {
				if(s!= null && curr.toString().equalsIgnoreCase(s)) { return curr; }
			}			
			return FileNewMode.F;
		}
	}
	
	
	public enum FileNewRequestor{
		Operatore, Clustering, Thor;
	}
	
	

}
