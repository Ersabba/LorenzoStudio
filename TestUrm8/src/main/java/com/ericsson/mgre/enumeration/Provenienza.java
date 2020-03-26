package com.ericsson.mgre.enumeration;

import com.ericsson.urm.device.driver.DeviceProtocol;
import org.apache.log4j.Logger;

import com.ericsson.urm.persistence.dto.mgre.InfoLetture.ModalitaLettura;

public enum Provenienza {
	CCS("CCS"),  							/*da file ccs*/
	DIR("DIR"),  							/*acquisizione diretta*/
	STORICI("STO"), 						/*Registri storicizzati Lennt orari*/
	THOR_SNIFFER("TSF"), 					/*Sniffer di campo Thor*/
	SNIFFER("HSF"), 						/*Sniffer di campo Hammer*/
	HAMMER_SONDA_OTTICA("HSO"),   			/*Sonda ottica Hammer*/
	THOR("HGU"),    						/*Gestione Utenza Thor e Hammer (DCL)*/
	GCF("GCF"),     						/*Gestione Clienti Finali */
	CRZ("CRZ"),     						/*CRZ*/
	GPRS("GPR"),							/* Specializzazione di DIR: Acquisizione diretta dei registri da LENNT tramite canale GPRS  */
	PLC("URM"), 							/* Specializzazione di DIR: Acquisizione diretta dei registri tramite canale PLC */
	OLD_THOR_GU("THOR"), 					/*vecchio valore inserito da thor*/
	HAMMER_GESTIONE_UTENZA_SNIFFER("HGS"); 	/*Hammer, sniffer da gestione utenza*/
	
	private static Logger logger = Logger.getLogger(Provenienza.class);
	
	private String	provenienza;
	private int priorita = 0;

	private Provenienza(String provenienza) {
		this.provenienza = provenienza;
		setPriorita(provenienza);
	}

	public String getProvenienza() {
		return this.provenienza;
	}
	
	
	
	public int getPriorita() {
		return priorita;
	}

	private void setPriorita(String provenienza) {
		this.priorita = 0;
		if("HSO".equalsIgnoreCase(provenienza)){
			this.priorita = 1;
		} else if("CRZ".equalsIgnoreCase(provenienza)){
			this.priorita = 2;
		}
		
	}

	public static Provenienza parse(String provenienza) {
		if (provenienza == null)
			return null;
		for (Provenienza tu : Provenienza.values())
			if (tu.provenienza.equalsIgnoreCase(provenienza))
				return tu;
		
		throw new IllegalArgumentException("Invalid Provenienza:" + provenienza);
	}

	public static Provenienza fromDeviceProtocol(DeviceProtocol deviceProtocol){

		Provenienza provenienza = Provenienza.DIR;

		if(deviceProtocol!=null){
			switch(deviceProtocol){
				case LANDIS_BT_CCS_MEDIATED:
					provenienza = Provenienza.PLC;
					break;

				case LANDIS_BT_LENNT_DIRECT:
					provenienza = Provenienza.GPRS;
					break;

				default:
					logger.warn("Protocol Detected:"+deviceProtocol.toString()+"Direct access not detected. Setting DIR for Provenienza");
					provenienza = Provenienza.DIR;
					break;
			}
		}

		return provenienza;
	}

}
