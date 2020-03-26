package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public interface TotAttAssInterface {

	public abstract Long getAttAss();

	public abstract String getEsito();

	public abstract Long getAttAssT1();

	public abstract Long getAttAssT2();

	public abstract Long getAttAssT3();

	public abstract Long getAttAssT4();

	public abstract String getCodConcentratore();
	
	public abstract String getMatricolaLenntCliente() ;
	
	public abstract Date getDataRil();
	
	public abstract String getProvenienza();
	
	public abstract Date getDataAcq(); 

}