package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public interface MisuPotMensiliInterface {

	
	public abstract String getMatricolaLenntCliente();
	
	public abstract String getCodConcentratore();
	

	public abstract Date getDataRil();

	public abstract Date getDataRilT1();

	public abstract Date getDataRilT2();

	public abstract Date getDataRilT3();

	public abstract Date getDataRilT4();

	public abstract Long getValueT1();

	public abstract Long getValueT2();

	public abstract Long getValueT3();

	public abstract Long getValueT4();
	
	public abstract Date getDataAcq();
	
	public abstract String getProvenienza();

}