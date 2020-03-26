package com.ericsson.urm.device.driver.registersreading;

/*
 * 
TIPO REGISTRO		codice indicante il registro da trasmettere
					=0 check sum della memoria programma
					=1 dump della memoria dati
					=2 abilitazione fasi (solo per trifase)
					=3 registri statistici scrittura eeprom
					=4 registro visualizzazioni abilitate/disabilitate
					=5 lettura configurazione ricetrasmettitori O.C.
					=6 crittografazione
					=7 lettura dati programmazione RTC
					=8 lettura blocco Eeprom (byte 0-31)
					=9 lettura blocco Eeprom (byte 32-63)
					=10 Stato configurazione CG
					=11 contatori di comunicazione LENNT - AL
					=12 dati download
					=13 Stato configurazione AL
					=14 Tariffa base
					=15 lettura ora sgancio magnetotermico
					=16 lettura flag configurazione
					=17 lettura release firmware IMQ
					=18 Informazioni diagnostiche
					=19 lettura programmazione seriale modem
					=20 lettura parametri Centro
					=21 lettura user id GPRS
					=22 lettura password GPRS
					=23 lettura server SMTP
					=24 lettura user id SMTP
					=25 lettura password SMTP
					=26 lettura email mittente
					=27 lettura email destinatario
					=28 lettura parametri rete
					=29 lettura sito notifica LENNT
					=30 lettura stringa notifica LENNT
					=31 lettura programmazioni applicazione IP
*/

public enum TipoRegistro {
	CHECK_SUM_MEMORIA_PROGRAMMA(0),
	DUMP_MEMORIA_DATI(1),
	ABILITAZIONE_FASI(2),
	REGISTRI_STATICI_LETTURA_EEPROM(3),
	REGISTRI_VISUALIZZAZIONI(4),
	LETTURA_CONFIGURAZIONE_RICETRASMETTITORI_OC(5),
	CRITTOGRAFAZIONE(6),
	LETTURA_DATI_PROGRAMMAZIONE_RTC(7),
	LETTURA_BLOCCO_EEPROM_BYTE_0_31(8),
	LETTURA_BLOCCO_EEPROM_BYTE_32_63(9),
	STATO_CONFIGURAZIONE_CG(10),
	CONTATORI_COMUNICAZIONE_LENNT_AL(11),
	DATI_DOWNLOAD(12),
	STATO_CONFIGURAZIONE_AL(13),
	TARIFFA_BASE(14),
	LETTURA_ORA_SGANCIO_MAGNETOTERMICO(15),
	LETTURA_FLAG_CONFIGURAZIONE(16),
	LETTURA_RELEASE_FIRMWARE_IMQ(17),
	INFORMAZIONI_DIAGNOSTICHE(18),
	LETTURA_PROGRAMMAZIONE_SERIALE_MODEM(19),
	LETTURA_PARAMETRI_CENTRO(20),
	LETTURA_USER_ID_GPRS(21),
	LETTURA_PASSWORD_GPRS(22),
	LETTURA_SERVER_SMTP(23),
	LETTURA_USER_ID_SMTP(24),
	LETTURA_PASSWORD_SMTP(25),
	LETTURA_EMAIL_MITTENTE(26),
	LETTURA_EMAIL_DESTINATARIO(27),
	LETTURA_PARAMETRI_RETE(28),
	LETTURA_SITO_NOTIFICA_LENNT(29),
	LETTURA_STRINGA_NOTIFICA_LENNT(30),
	LETTURA_PROGRAMMAZIONI_APPLICAZIONE_IP(31),
	
	CREDENZIALI_DI_ACCESSO_USB(42),
	PARAMETRI_TCP_IP(43),
	ACCESS_POINT_NAME(44),
	LETTURA_SITO_NOTIFICA_CRZ(45),
	MOBILE_RADIO_COMMUNICATION_MANAGEMENT(46),
	ZVEI_COMMUNICATION_MANAGEMENT(47),
	ENABLING_MEASUREMENT(49),
	LETTURA_REGISTRI_ENERGIE(51),
	FUNCTIONAL_REGISTERS(53),
	LETTURA_CREDENZIALI_DI_ACCESSO_APN(54);


	private int	value;

	private TipoRegistro(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	public static TipoRegistro parseValue(int registro) {
		for (TipoRegistro tg : TipoRegistro.values()) {
			if (tg.value == registro) {
				return tg;
			}
		}
		throw new IllegalArgumentException("Invalid period: " + registro);
	}
}
