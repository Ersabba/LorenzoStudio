package com.ericsson.urm.device.driver.statusword;

import java.io.Serializable;

public class StatoOperativo implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private byte[]  rawData;
	
	private TipoModoFunzionamento modoFunzionamento;	// = 0 Fabbrica	
														// = 1 Tariffazione
														// = 2 Stand by: diagnostica funzionale per anomalia
														// = 3 Stand by temporizzato su richiesta del CG
	private boolean rete230Vac = false;					// = 1 Assente: funzionamento a batteria
														// = 0 Presente
	private boolean attivitaPeriodicaLettura = false;	// = 1 nessuna attivita’ in esecuzione
														// = 0 attivita’ in esecuzione
	private boolean attivitaProgrUnaTantum = false;		// = 1 nessuna attivita’ in esecuzione
														// = 0 attivita’ in esecuzione
	private boolean attivitaCodaLavori = false;			// = 1 nessuna coda lavori in esecuzione
														// = 0 Coda lavori in esecuzione
	private boolean taskDisalimentazioni = false;		// = 1 task non in esecuzione
														// = 0 task in esecuzione
	private int canaleComunicazioneCCSLennt = -1;		// primi 2 bit = 00/01/02/03
	private int canaleComunicazioneLenntAceaLink = -1;	// primi 2 bit = 00/01/02/03
	
	private boolean restartPeriodico = false;			// = 0 disattivo
														// = 1 attivo
	private int numeroLennt = -1;						// Numero Lennt contenuti in anagrafica
	private int numeroAceaLink = -1;					// Numero Acea Link in anagrafica
	private int numeroRibaltamentiInAtto = -1;	
	private int indirizzoBaseHDLC = -1;
	private GestioneAllarmi gestioneAllarmi;			//= 0 Assenza Allarme
														//= 1 Allarme in corso non ancora inviato
														//= 2 Allarme in corso già inviato
	private GestioneSegnalazioni gestioneSegnalazioni;  // = 0 Assenza Segnalazione
														//= 1 Segnalazione in corso non ancora rilevata
														//= 2 Segnalazione in corso già rilevata

	private int pnp = -1;  								//= 0 Plug and Play in esecuzione
	
	private StatoMio1 statoMio1;						// Primo nibble
														// = 0 Mio 1 configurato correttamente
														// = 1 Mio 1 configurato non correttamente
														// = 2 Mio 1 assente
														// = 3 Down load in corso
	
	private StatoMio2 statoMio2;						// Primo nibble
														// = 0 Mio 2 configurato correttamente
														// = 1 Mio 2 configurato non correttamente
														// = 2 Mio 2 assente
														// = 3 Down load in corso
	
	private StatoDownloadLennt statoDownloadLennt;		// = 1 Nessun down load Lennt non in corso
														// = 2 Down load Lennt Monofase in corso
														// = 3 Down load Lennt Trifase diretto in corso
														// = 4 Down load Lennt Trifase indiretto(Tipo 52) in
	
	private StatoCensimentoLennt statoCensimentoLennt; 	// = 1 Censimento Lennt in corso
	private TipoCCS tipoCCS; 							// = 0 CCS stand alone
														// = 1 CCS master
														// = 2 CCS slave
	private String IpCentro = null;
	private String IpTrap = null;
	
	
	public static enum TipoModoFunzionamento {
		FABBRICA(0), TARIFFAZIONE(1), STAND_BY_DIAGNOSTICA_ANOMALIA(2), STAND_BY_TEMPORIZZATO(3);
		
		private int value = -1;

		private TipoModoFunzionamento(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static TipoModoFunzionamento parseValue(int newValue) {
			for(TipoModoFunzionamento ret : TipoModoFunzionamento.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
		
	public static enum GestioneAllarmi {
		ASSENZA_ALLARME(0), ALLARME_NN_INVIATO(1), ALLARME_INVIATO(2);
		
		private int value = -1;

		private GestioneAllarmi(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static GestioneAllarmi parseValue(int newValue) {
			for(GestioneAllarmi ret : GestioneAllarmi.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum GestioneSegnalazioni {
		ASSENZA_SEGNALAZIONE(0), SEGNALAZIONE_NN_RILEVATA(1), SEGNALAZIONE_RILEVATA(2);
		
		private int value = -1;

		private GestioneSegnalazioni(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static GestioneSegnalazioni parseValue(int newValue) {
			for(GestioneSegnalazioni ret : GestioneSegnalazioni.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum StatoMio1 {
		MIO_1_CONF_CORRETTAMENTE(0), MIO_1_CONF_NN_CORRETTAMENTE(1), MIO_1_ASSENTE(2), DOWNLOAD_IN_CORSO(3);
	
		private int value = -1;

		private StatoMio1(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static StatoMio1 parseValue(int newValue) {
			for(StatoMio1 ret : StatoMio1.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
		
	public static enum StatoMio2 {
		MIO_2_CONF_CORRETTAMENTE(0), MIO_2_CONF_NN_CORRETTAMENTE(1), MIO_2_ASSENTE(2), DOWNLOAD_IN_CORSO(3);
		
		private int value = -1;

		private StatoMio2(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static StatoMio2 parseValue(int newValue) {
			for(StatoMio2 ret : StatoMio2.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum StatoDownloadLennt {
		DOWNLOAD_NN_IN_CORSO(1), DOWNLOAD_MONOFASE_IN_CORSO(2), DOWNLOAD_TRIFASE_DIRETTO_IN_CORSO(3), DOWNLOAD_TRIFASE_INDIRETTO_IN_CORSO(4);
		
		private int value = -1;

		private StatoDownloadLennt(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static StatoDownloadLennt parseValue(int newValue) {
			for(StatoDownloadLennt ret : StatoDownloadLennt.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
		
	public static enum StatoCensimentoLennt {
		CENSIMENTO_LENNT_IN_CORSO(1);
		
		private int value = -1;

		private StatoCensimentoLennt(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static StatoCensimentoLennt parseValue(int newValue) {
			for(StatoCensimentoLennt ret : StatoCensimentoLennt.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;
		}		
	}
	
	public static enum TipoCCS {
		CCS_STAND_ALONE(0), CCS_MASTER(1), CCS_SLAVE(2);
		
		private int value = -1;

		private TipoCCS(int value) {
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
		
		public static TipoCCS parseValue(int newValue) {
			for(TipoCCS ret : TipoCCS.values()) {
				if(ret.getValue() == newValue) {
					return ret;
				}
			}
			
			return null;					
		}
	}
	
	
	public StatoOperativo() {
		super();
	}

	public StatoOperativo(byte[] toParse) {
		super();
		parse(toParse);
	}
	
	public void parse(byte[] toParse) {
		rawData = toParse;
		
//		Byte 00:29 informazioni riguardanti lo stato operativo	
		if (toParse == null || toParse.length < 30)
			throw new IllegalArgumentException("Invalid message: it's null or has invalid length");		
		
		byte[] app = new byte[1];
		System.arraycopy(toParse, 0, app, 0, 1);
		int i = 1;
		this.modoFunzionamento = TipoModoFunzionamento.parseValue(toParse[i++] & 0xff);
		this.rete230Vac = (toParse[i++] & 0xff) == 1;		
		this.attivitaPeriodicaLettura = (toParse[i++] & 0xff) == 1;
		this.attivitaProgrUnaTantum = (toParse[i++] & 0xff) == 1;
		this.attivitaCodaLavori = (toParse[i++] & 0xff) == 1;
		this.taskDisalimentazioni = (toParse[i++] & 0xff) == 1;
		this.canaleComunicazioneCCSLennt = (toParse[i++] & 0x03);
		this.canaleComunicazioneLenntAceaLink = (toParse[i++] & 0x03);
		this.restartPeriodico = (toParse[i++] & 0xff) == 1;
		
		app = new byte[2];
		System.arraycopy(toParse, i, app, 0, 2);
		this.numeroLennt = getIntFromNBytes(app,2);
		i=+2;
		
		app = new byte[2];
		System.arraycopy(toParse, i, app, 0, 2);
		this.numeroAceaLink = getIntFromNBytes(app,2);
		i=+2;
		
		this.numeroRibaltamentiInAtto = (toParse[i++] & 0xff) ;
		this.indirizzoBaseHDLC = (toParse[i++] & 0xff) ;
		
		this.gestioneAllarmi = GestioneAllarmi.parseValue(toParse[i++] & 0xff);
		this.gestioneSegnalazioni = GestioneSegnalazioni.parseValue(toParse[i++] & 0xff);

		this.statoMio1 = StatoMio1.parseValue(toParse[i++] & 0x15);
		this.statoMio2 = StatoMio2.parseValue(toParse[i++] & 0x15);
		
		this.statoCensimentoLennt = StatoCensimentoLennt.parseValue(toParse[i++] & 0xff);
		this.tipoCCS = TipoCCS.parseValue(toParse[i++] & 0xff);
		
		app = new byte[4];
		System.arraycopy(toParse, i, app, 0, 4);
		i += 4;
		IpCentro =((int) app[0] & 0xff)+"."+((int) app[1] & 0xff)+"."+((int) app[2] & 0xff)+"."+((int) app[3] & 0xff);
		
		app = new byte[4];
		System.arraycopy(toParse, i, app, 0, 4);
		i += 4;
		IpTrap =((int) app[0] & 0xff)+"."+((int) app[1] & 0xff)+"."+((int) app[2] & 0xff)+"."+((int) app[3] & 0xff);
	}


	
	public TipoModoFunzionamento getModoFunzionamento() {
		return modoFunzionamento;
	}

	public boolean isRete230VacAssente() {
		return rete230Vac;
	}

	public boolean isAttivitaPeriodicaDiLetturaNonInEsecuzione() {
		return attivitaPeriodicaLettura;
	}

	public boolean isAttivitaProgrUnaTantumNonInEsecuzione() {
		return attivitaProgrUnaTantum;
	}

	public boolean isAttivitaCodaLavoriNonInEsecuzione() {
		return attivitaCodaLavori;
	}

	public boolean isTaskDisalimentazioniNonInEsecuzione() {
		return taskDisalimentazioni;
	}

	public int getCanaleComunicazioneCCSLennt() {
		return canaleComunicazioneCCSLennt;
	}

	public int getCanaleComunicazioneLenntAceaLink() {
		return canaleComunicazioneLenntAceaLink;
	}

	public boolean isRestartPeriodicoAttivo() {
		return restartPeriodico;
	}

	public int getNumeroLenntInAnagrafica() {
		return numeroLennt;
	}

	public int getNumeroAceaLinkInAnagrafica() {
		return numeroAceaLink;
	}

	public int getNumeroRibaltamentiInAtto() {
		return numeroRibaltamentiInAtto;
	}

	public int getIndirizzoBaseHDLC() {
		return indirizzoBaseHDLC;
	}

	public GestioneAllarmi getGestioneAllarmi() {
		return gestioneAllarmi;
	}

	public GestioneSegnalazioni getGestioneSegnalazioni() {
		return gestioneSegnalazioni;
	}

	public int getPnpInEsecuzione() {
		return pnp;
	}

	public StatoMio1 getStatoMio1() {
		return statoMio1;
	}

	public StatoMio2 getStatoMio2() {
		return statoMio2;
	}

	public StatoDownloadLennt getStatoDownloadLennt() {
		return statoDownloadLennt;
	}

	public StatoCensimentoLennt getStatoCensimentoLennt() {
		return statoCensimentoLennt;
	}

	public TipoCCS getTipoCCS() {
		return tipoCCS;
	}

	public String getIpCentro() {
		return IpCentro;
	}

	public String getIpTrap() {
		return IpTrap;
	}

	/**
	 * Metodo che converte un array di N byte nel corrispondente intero
	 * 
	 * @param bytes
	 * @return
	 */
	private int getIntFromNBytes(byte[] bytes, int length) {
		if (bytes == null || bytes.length != length)
			throw new IllegalArgumentException("Byte array must be not null and contains "+length+" bytes");

		int ret = 0;
		for (int i = 0; i < length; i++) {
			ret = (ret | ((int) bytes[i] & 0xff) << (i * 8));
		}
		return ret;
	}
	
	public byte[] asByteArray() {
		return rawData;
	}

}
