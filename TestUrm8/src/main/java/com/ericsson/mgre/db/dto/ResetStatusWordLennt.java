package com.ericsson.mgre.db.dto;

import java.io.Serializable;
import java.util.Date;

public class ResetStatusWordLennt implements Serializable{
	private static final long serialVersionUID = 1L;
	private String COD_CONCENTRATORE;
	private String MATRICOLA_LENNT_CLIENTE;
	private String IP_ADDRESS;
	private int ANTITAMPER;
	private Date LAST_DATA_RESET;
	
	public String getCOD_CONCENTRATORE() {
		return COD_CONCENTRATORE;
	}
	public void setCOD_CONCENTRATORE(String cOD_CONCENTRATORE) {
		COD_CONCENTRATORE = cOD_CONCENTRATORE;
	}
	public String getMATRICOLA_LENNT_CLIENTE() {
		return MATRICOLA_LENNT_CLIENTE;
	}
	public void setMATRICOLA_LENNT_CLIENTE(String mATRICOLA_LENNT_CLIENTE) {
		MATRICOLA_LENNT_CLIENTE = mATRICOLA_LENNT_CLIENTE;
	}
	public String getIP_ADDRESS() {
		return IP_ADDRESS;
	}
	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}
	public int getANTITAMPER() {
		return ANTITAMPER;
	}
	public void setANTITAMPER(int aNTITAMPER) {
		ANTITAMPER = aNTITAMPER;
	}
	public Date getLAST_DATA_RESET() {
		return LAST_DATA_RESET;
	}
	public void setLAST_DATA_RESET(Date lAST_DATA_RESET) {
		LAST_DATA_RESET = lAST_DATA_RESET;
	}
	
	
}
