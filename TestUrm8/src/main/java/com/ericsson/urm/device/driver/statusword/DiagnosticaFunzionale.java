package com.ericsson.urm.device.driver.statusword;

import java.io.Serializable;

public class DiagnosticaFunzionale implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private byte[]  rawData;
	
	private boolean codiceAccessoLennt = false;			// = 1 Codice di accesso Lennt assente
														// = 0 Codice di accesso Lennt presente
	private AnagraficaLennt anagraficaLennt;			// = 0 Anagrafica Presente	
														// = 1 Errore formato
														// = 2 Anagrafica Assente


	private boolean orologio = false;					// = 1 Orologio non inizializzato
														// = 0 Orologio inizializzato
	private boolean matricolaCcs = false;					// = 1 Matricola CCS assente
	
	private Routing routing; 							// = 1 Routing Lennt assente
														// = 0 Routing Lennt consistente e presente
														// = 2 Routing Lennt corrotto (*)
	
	private Tipomodem tipomodem; 						// = 0 GSM
														// = 1 GPRS
	
	private int lenntRipetitori = -1;					// = Num. Lennt con ripetitori contenuti in Rouxxx.cfg
	private boolean statoCensimentoAceaLink = false;	//= 1 Censimento in corso
														
	private int masterSlaveTokenTrasmessi = -1;			// numero token trasmessi
	private int masterSlaveTokenRicevuti = -1;			// numero token ricevuti
	
	private int hdlc = -1;								// Fine indirizzo HDLC
	
	private int segnalazioniVarie = -1;					// Segnalazioni varie (presenza/assenza file PAR e PRG, abilitazione/disabilitazione del reinstradamento,eliminazione e recupero dati).
														
	private int parametroCCS  = -1;
	private int parametroMOC  = -1;
	private int periodoRaccoltaCurveDiCarico=3;
	
	
	public static enum AnagraficaLennt {
		ANAGRAFICA_PRESENTE(0), ERRORE_FORMATO(1), ANAGRAFICA_ASSENTE(2);
		
		private int value = -1;

		private AnagraficaLennt(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static AnagraficaLennt parseValue(int newValue) {
			for(AnagraficaLennt ret : AnagraficaLennt.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
		
	public static enum Routing {
		ROUTING_LENNT_ASSENTE(0), ROUTING_LENNT_PRESENTE(1), ROUTING_LENNT_CORROTTO(2);
		
		private int value = -1;

		private Routing(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static Routing parseValue(int newValue) {
			for(Routing ret : Routing.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum Tipomodem {
		GSM(0), GPRS(1);
		
		private int value = -1;
		private Tipomodem(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
	}
		
		public static Tipomodem parseValue(int newValue) {
			for(Tipomodem ret : Tipomodem.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	
	
	public DiagnosticaFunzionale() {
		super();
	}

	public DiagnosticaFunzionale(byte[] toParse) {
		super();
		parse(toParse);
	}
	
	public void parse(byte[] toParse) {
		this.rawData = toParse;
		
	//	Byte 30:48 informazioni riguardanti la diagnostica funzionale	
		if (toParse == null || toParse.length < 19)
			throw new IllegalArgumentException("Invalid message: it's null or has invalid length");		
		
		byte[] app = new byte[1];
		System.arraycopy(toParse, 0, app, 0, 1);
		int i = 1;
		this.codiceAccessoLennt = (toParse[i++] & 0xff) == 1;		
		this.anagraficaLennt = AnagraficaLennt.parseValue(toParse[i++] & 0xff);		
		this.orologio = (toParse[i++] & 0xff) == 1;		
		this.matricolaCcs = (toParse[i++] & 0xff) == 1;
		this.routing = Routing.parseValue(toParse[i++] & 0xff);
		this.tipomodem = Tipomodem.parseValue(toParse[i++] & 0xff);
		
		int loLenntRipetitori = (toParse[i++] & 0xff);
		int hiLenntRipetitori = (toParse[i++] & 0xff);
		this.lenntRipetitori = loLenntRipetitori + hiLenntRipetitori * 256;		
		this.statoCensimentoAceaLink = (toParse[i++] & 0xff) == 1;
		
		int masterTokenTrasmessi = (toParse[i++] & 0xff);  
		int slaveTokenTrasmessi = (toParse[i++] & 0xff);				
		this.masterSlaveTokenTrasmessi = masterTokenTrasmessi + slaveTokenTrasmessi * 256;
		
		int masterTokenRicevuti = (toParse[i++] & 0xff);  
		int slaveTokenRicevuti = (toParse[i++] & 0xff);				
		this.masterSlaveTokenRicevuti = masterTokenRicevuti + slaveTokenRicevuti * 256;
		
		this.hdlc = (toParse[i++] & 0xff);
		this.segnalazioniVarie = (toParse[i++] & 0xff);
		
		this.parametroCCS  = (toParse[i++] & 0xff);
		this.parametroMOC  = (toParse[i++] & 0xff);
		
		this.periodoRaccoltaCurveDiCarico = (toParse[i++] & 0xff);
	}

	
		
	public boolean isCodiceAccessoLenntAssente() {
		return codiceAccessoLennt;
	}

	public AnagraficaLennt getAnagraficaLennt() {
		return anagraficaLennt;
	}

	public boolean isOrologioNonInizializzato() {
		return orologio;
	}

	public boolean isMatricolaCcsAssente() {
		return matricolaCcs;
	}

	public Routing getRouting() {
		return routing;
	}

	public Tipomodem getTipomodem() {
		return tipomodem;
	}

	public int getNumLenntRipetitori() {
		return lenntRipetitori;
	}

	public boolean isStatoCensimentoAceaLinkCensimentoInCorso() {
		return statoCensimentoAceaLink;
	}
	
	public int getMasterSlaveNumTokenTrasmessi() {
		return masterSlaveTokenTrasmessi;
	}

	public int getMasterSlaveNumTokenRicevuti() {
		return masterSlaveTokenRicevuti;
	}

	public int getFineIndirizzoHdlc() {
		return hdlc;
	}
		
//	Byte 43 -> dal bit 0 al bit 4

	public boolean isSegnalazioniVarieFilePAR_assente() {
		return (segnalazioniVarie & 0x01) == 0x01;
	}
	
	public boolean isSegnalazioniVarieFilePRG_assente() {
		return (segnalazioniVarie & 0x02) == 0x02;
	}
	
	public boolean isSegnalazioniVarieReinstradamento_disabilitato() {
		return (segnalazioniVarie & 0x04) == 0x04;
	}
	
	public boolean isSegnalazioniVarieEliminazioneMeter_disabilitata() {
		return (segnalazioniVarie & 0x08) == 0x08;
	}
	
	public boolean isSegnalazioniVarieRecuperoDatiFatturazione_disabilitato() {
		return (segnalazioniVarie & 0x10) == 0x10;
	}
		
	public int getParametroCCS() {
		return parametroCCS;
	}

	public int getParametroMOC() {
		return parametroMOC;
	}
	
	public int getPeriodoRaccoltaCurveDiCarico() {
		return periodoRaccoltaCurveDiCarico;
	}
	
	public byte[] asByteArray() {
		return rawData;
	}
}
