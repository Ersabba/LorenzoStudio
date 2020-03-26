package com.ericsson.urm.device.driver.lenntdata;

import java.io.Serializable;
import java.util.Calendar;

public class MeterIdentifiers implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private byte[] statusWord = null;
	private String matricolaContatore = null;
	private String matricolaDistributore = null;
	private Language lingua = null;
	private int dwlIndex;
	private String serialNumber = null; 
	private Calendar startDwlTimeStamp = null;
	private Calendar endDwlTimeStamp = null;
	private int startedDwlsNumber;
	private int endedDwlsNumber;
			
	
	public static enum Language {
		
		IT(0),
		EN(1),
		FR(2),
		D(3),
		E(4),
		P(5);
		
		private int value;

		private Language(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static Language valueOf(int value) {
			for(Language lan : Language.values()) {
				if(lan.value == value) {
					return lan;
				}
			}
			throw new IllegalArgumentException("Unknown Language with value:"+value);
		}
	}


	public byte[] getStatusWord() {
		return statusWord;
	}


	public void setStatusWord(byte[] statusWord) {
		this.statusWord = statusWord;
	}


	public String getMatricolaContatore() {
		return matricolaContatore;
	}


	public void setMatricolaContatore(String matricolaContatore) {
		this.matricolaContatore = matricolaContatore;
	}


	public String getMatricolaDistributore() {
		return matricolaDistributore;
	}


	public void setMatricolaDistributore(String matricolaDistributore) {
		this.matricolaDistributore = matricolaDistributore;
	}


	public Language getLingua() {
		return lingua;
	}


	public void setLingua(Language lingua) {
		this.lingua = lingua;
	}


	public int getDwlIndex() {
		return dwlIndex;
	}


	public void setDwlIndex(int dwlIndex) {
		this.dwlIndex = dwlIndex;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public Calendar getStartDwlTimeStamp() {
		return startDwlTimeStamp;
	}


	public void setStartDwlTimeStamp(Calendar startDwlTimeStamp) {
		this.startDwlTimeStamp = startDwlTimeStamp;
	}


	public Calendar getEndDwlTimeStamp() {
		return endDwlTimeStamp;
	}


	public void setEndDwlTimeStamp(Calendar endDwlTimeStamp) {
		this.endDwlTimeStamp = endDwlTimeStamp;
	}


	public int getStartedDwlsNumber() {
		return startedDwlsNumber;
	}


	public void setStartedDwlsNumber(int startedDwlsNumber) {
		this.startedDwlsNumber = startedDwlsNumber;
	}


	public int getEndedDwlsNumber() {
		return endedDwlsNumber;
	}


	public void setEndedDwlsNumber(int endedDwlsNumber) {
		this.endedDwlsNumber = endedDwlsNumber;
	}
	
	

}
