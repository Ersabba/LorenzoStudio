package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class MgdbLenntCliente implements Serializable, MgdbDto {
	
	private final static long serialVersionUID = -1;
	
	private String 		matricolaLenntCliente		= null;
	private String 		codConcentratore			= null;
	private String 		codTipmodin					= null;
	private String 		giornoSettimana				= null;
	private Long 		coeffLimitazione			= null;
	private String 		codConfigAll				= null;
	private String 		codTiputt					= null;
	private String 		codGruppoApplicativo		= null;
	private Long 		codLineaBt					= null;
	private Long 		codSezione					= null;
	private Long 		flagRipetitore				= null;
	private Long 		progLenntGruppo				= null;
	private String 		caratteristicaInstallazione	= null;
	private String 		raggLennt					= null;
	private String 		statoAllegEmerg				= null;
	private String 		guastoLennt					= null;
	private String 		statoAllegProgr				= null;
	private String 		presenzaDatiSegr			= null;
	private String 		codPosizione				= null;
	private Long 		indirizzo					= null;
	private String 		costruttore					= null;
	private String   	tipo						= null;
	private String 		annoFabbricazione			= null;
	private String 		progressivoAnno				= null;
	private String 		matrDistrEnerg				= null;
	private String 		lingua						= null;
	private String 		releaseFirmware				= null;
	private String 		numTelGuasti				= null;
	private String 		numTelInfo					= null;
	private String 		numeroUtenza				= null;
	private String 		fase						= null;
	private String 		faseOld						= null;
	private Date   		dataFase					= null;
	private Date   		ultimoContatto				= null;
	private String 		cabinaSecondaria			= null;
	private String 		tipoAlimentazione			= null;
	private String 		tipoAssegnazione			= null;
	private String 		codConcentratore2			= null;
	private String 		codConcentratore3			= null;
	private String 		utenzaSpeciale 				= null;
	private Long 		flagAbilitazione			= null;
	private boolean     billingMode                 = false;
	private String 		indirizzoHDLC 				= null;
	private String 		gruppoHDLC 					= null;
	private String 		progressivoHDLC				= null;
	
	
	public MgdbLenntCliente() {
		super();
	}

	public Object clone() {
		try {
			MgdbLenntCliente lc = (MgdbLenntCliente) super.clone();
			if (dataFase != null)
				lc.dataFase = (Date) dataFase.clone();
			if (ultimoContatto != null)
				lc.ultimoContatto = (Date) ultimoContatto.clone();
			return lc;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		MgdbLenntCliente other = (MgdbLenntCliente)srcDto;
		this.matricolaLenntCliente = other.matricolaLenntCliente;
		this.codConcentratore = other.codConcentratore;
		this.codTipmodin = other.codTipmodin;
		this.giornoSettimana = other.giornoSettimana;
		this.coeffLimitazione = other.coeffLimitazione;
		this.codConfigAll = other.codConfigAll;
		this.codTiputt = other.codTiputt;
		this.codGruppoApplicativo = other.codGruppoApplicativo;
		this.codLineaBt = other.codLineaBt;
		this.codSezione = other.codSezione;
		this.flagRipetitore = other.flagRipetitore;
		this.progLenntGruppo = other.progLenntGruppo;
		this.caratteristicaInstallazione = other.caratteristicaInstallazione;
		this.raggLennt = other.raggLennt;
		this.statoAllegEmerg = other.statoAllegEmerg;
		this.guastoLennt = other.guastoLennt;
		this.statoAllegProgr = other.statoAllegProgr;
		this.presenzaDatiSegr = other.presenzaDatiSegr;
		this.codPosizione = other.codPosizione;
		this.indirizzo = other.indirizzo;
		this.costruttore = other.costruttore;
		this.tipo = other.tipo;
		this.annoFabbricazione = other.annoFabbricazione;
		this.progressivoAnno = other.progressivoAnno;
		this.matrDistrEnerg = other.matrDistrEnerg;
		this.lingua = other.lingua;
		this.releaseFirmware = other.releaseFirmware;
		this.numTelGuasti = other.numTelGuasti;
		this.numTelInfo = other.numTelInfo;
		this.numeroUtenza = other.numeroUtenza;
		this.fase = other.fase;
		this.faseOld = other.faseOld;
		this.dataFase = other.dataFase;
		this.ultimoContatto = other.ultimoContatto;
		this.cabinaSecondaria = other.cabinaSecondaria;
		this.tipoAlimentazione = other.tipoAlimentazione;
		this.tipoAssegnazione = other.tipoAssegnazione;
		this.codConcentratore2 = other.codConcentratore2;
		this.codConcentratore3 = other.codConcentratore3;
		this.utenzaSpeciale = other.utenzaSpeciale;
		this.flagAbilitazione = other.flagAbilitazione;
		this.billingMode = other.billingMode;
		this.indirizzoHDLC = other.indirizzoHDLC;
		this.gruppoHDLC = other.gruppoHDLC;
		this.progressivoHDLC = other.progressivoHDLC;
	}
	
	public Serializable retrievePrimaryKey() {
		return getMatricolaLenntCliente();
	}
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}


	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}


	public String getCodConcentratore() {
		return codConcentratore;
	}


	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}


	public String getCodTipmodin() {
		return codTipmodin;
	}


	public void setCodTipmodin(String codTipmodin) {
		this.codTipmodin = codTipmodin;
	}


	public String getGiornoSettimana() {
		return giornoSettimana;
	}


	public void setGiornoSettimana(String giornoSettimana) {
		this.giornoSettimana = giornoSettimana;
	}


	public Long getCoeffLimitazione() {
		return coeffLimitazione;
	}


	public void setCoeffLimitazione(Long coeffLimitazione) {
		this.coeffLimitazione = coeffLimitazione;
	}


	public String getCodConfigAll() {
		return codConfigAll;
	}


	public void setCodConfigAll(String codConfigAll) {
		this.codConfigAll = codConfigAll;
	}


	public String getCodTiputt() {
		return this.codTiputt;
	}

	public void setCodTiputt(String codTiputt) {
		this.codTiputt = codTiputt;
	}


	public String getCodGruppoApplicativo() {
		return codGruppoApplicativo;
	}


	public void setCodGruppoApplicativo(String codGruppoApplicativo) {
		this.codGruppoApplicativo = codGruppoApplicativo;
	}


	public Long getCodLineaBt() {
		return codLineaBt;
	}


	public void setCodLineaBt(Long codLineaBt) {
		this.codLineaBt = codLineaBt;
	}


	public Long getCodSezione() {
		return codSezione;
	}


	public void setCodSezione(Long codSezione) {
		this.codSezione = codSezione;
	}


	public Long getFlagRipetitore() {
		return flagRipetitore;
	}


	public void setFlagRipetitore(Long flagRipetitore) {
		this.flagRipetitore = flagRipetitore;
	}


	public Long getProgLenntGruppo() {
		return progLenntGruppo;
	}


	public void setProgLenntGruppo(Long progLenntGruppo) {
		this.progLenntGruppo = progLenntGruppo;
	}


	public String getCaratteristicaInstallazione() {
		return caratteristicaInstallazione;
	}


	public void setCaratteristicaInstallazione(String caratteristicaInstallazione) {
		this.caratteristicaInstallazione = caratteristicaInstallazione;
	}


	public String getRaggLennt() {
		return raggLennt;
	}


	public void setRaggLennt(String raggLennt) {
		this.raggLennt = raggLennt;
	}


	public String getStatoAllegEmerg() {
		return statoAllegEmerg;
	}


	public void setStatoAllegEmerg(String statoAllegEmerg) {
		this.statoAllegEmerg = statoAllegEmerg;
	}


	public String getGuastoLennt() {
		return guastoLennt;
	}


	public void setGuastoLennt(String guastoLennt) {
		this.guastoLennt = guastoLennt;
	}


	public String getStatoAllegProgr() {
		return statoAllegProgr;
	}


	public void setStatoAllegProgr(String statoAllegProgr) {
		this.statoAllegProgr = statoAllegProgr;
	}


	public String getPresenzaDatiSegr() {
		return presenzaDatiSegr;
	}


	public void setPresenzaDatiSegr(String presenzaDatiSegr) {
		this.presenzaDatiSegr = presenzaDatiSegr;
	}
	

	public String getCodPosizione() {
		return codPosizione;
	}


	public void setCodPosizione(String codPosizione) {
		this.codPosizione = codPosizione;
	}


	public Long getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(Long indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getCostruttore() {
		return costruttore;
	}


	public void setCostruttore(String costruttore) {
		this.costruttore = costruttore;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getAnnoFabbricazione() {
		return annoFabbricazione;
	}


	public void setAnnoFabbricazione(String annoFabbricazione) {
		this.annoFabbricazione = annoFabbricazione;
	}


	public String getProgressivoAnno() {
		return progressivoAnno;
	}


	public void setProgressivoAnno(String progressivoAnno) {
		this.progressivoAnno = progressivoAnno;
	}


	public String getMatrDistrEnerg() {
		return matrDistrEnerg;
	}


	public void setMatrDistrEnerg(String matrDistrEnerg) {
		this.matrDistrEnerg = matrDistrEnerg;
	}


	public String getLingua() {
		return lingua;
	}


	public void setLingua(String lingua) {
		this.lingua = lingua;
	}


	public String getReleaseFirmware() {
		return releaseFirmware;
	}


	public void setReleaseFirmware(String releaseFirmware) {
		this.releaseFirmware = releaseFirmware;
	}


	public String getNumTelGuasti() {
		return numTelGuasti;
	}


	public void setNumTelGuasti(String numTelGuasti) {
		this.numTelGuasti = numTelGuasti;
	}


	public String getNumTelInfo() {
		return numTelInfo;
	}


	public void setNumTelInfo(String numTelInfo) {
		this.numTelInfo = numTelInfo;
	}


	public String getNumeroUtenza() {
		return numeroUtenza;
	}


	public void setNumeroUtenza(String numeroUtenza) {
		this.numeroUtenza = numeroUtenza;
	}


	public String getFase() {
		return fase;
	}


	public void setFase(String fase) {
		this.fase = fase;
	}


	public Date getUltimoContatto() {
		return ultimoContatto;
	}


	public void setUltimoContatto(Date ultimoContatto) {
		this.ultimoContatto = ultimoContatto;
	}


	public String getCabinaSecondaria() {
		return cabinaSecondaria;
	}


	public void setCabinaSecondaria(String cabinaSecondaria) {
		this.cabinaSecondaria = cabinaSecondaria;
	}


	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}


	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}


	public String getTipoAssegnazione() {
		return tipoAssegnazione;
	}


	public void setTipoAssegnazione(String tipoAssegnazione) {
		this.tipoAssegnazione = tipoAssegnazione;
	}


	public String getCodConcentratore2() {
		return codConcentratore2;
	}


	public void setCodConcentratore2(String codConcentratore2) {
		this.codConcentratore2 = codConcentratore2;
	}


	public String getCodConcentratore3() {
		return codConcentratore3;
	}


	public void setCodConcentratore3(String codConcentratore3) {
		this.codConcentratore3 = codConcentratore3;
	}

	public String getFaseOld() {
		return faseOld;
	}

	public void setFaseOld(String faseOld) {
		this.faseOld = faseOld;
	}

	public Date getDataFase() {
		return dataFase;
	}

	public void setDataFase(Date dataFase) {
		this.dataFase = dataFase;
	}

	public String getUtenzaSpeciale() {
		return this.utenzaSpeciale;
	}

	public void setUtenzaSpeciale(String utenzaSpeciale) {
		this.utenzaSpeciale = utenzaSpeciale;
	}
	
	public Long getFlagAbilitazione() {
		return flagAbilitazione;
	}

	public void setFlagAbilitazione(Long flagAbilitazione) {
		this.flagAbilitazione = flagAbilitazione;
	}

	public boolean isBillingMode() {
		return billingMode;
	}

	public void setBillingMode(boolean billingMode) {
		this.billingMode = billingMode;
	}
	
	

	public String getIndirizzoHDLC() {
		return indirizzoHDLC;
	}

	public void setIndirizzoHDLC(String indirizzoHDLC) {
		this.indirizzoHDLC = indirizzoHDLC;
	}
	
	

	public String getGruppoHDLC() {
		return gruppoHDLC;
	}

	public void setGruppoHDLC(String gruppoHDLC) {
		this.gruppoHDLC = gruppoHDLC;
	}

	public String getProgressivoHDLC() {
		return progressivoHDLC;
	}

	public void setProgressivoHDLC(String progressivoHDLC) {
		this.progressivoHDLC = progressivoHDLC;
	}

	public String toString() {
		return "LenntCliente [annoFabbricazione=" + annoFabbricazione + ", cabinaSecondaria=" + cabinaSecondaria
				+ ", caratteristicaInstallazione=" + caratteristicaInstallazione + ", codConcentratore=" + codConcentratore
				+ ", codConcentratore2=" + codConcentratore2 + ", codConcentratore3=" + codConcentratore3 + ", codConfigAll="
				+ codConfigAll + ", codGruppoApplicativo=" + codGruppoApplicativo + ", codLineaBt=" + codLineaBt
				+ ", codPosizione=" + codPosizione + ", codSezione=" + codSezione + ", codTipmodin=" + codTipmodin + ", codTiputt="
				+ codTiputt + ", coeffLimitazione=" + coeffLimitazione + ", costruttore=" + costruttore + ", fase=" + fase
				+ ", flagRipetitore=" + flagRipetitore + ", giornoSettimana=" + giornoSettimana + ", guastoLennt=" + guastoLennt
				+ ", indirizzo=" + indirizzo + ", lingua=" + lingua + ", matrDistrEnerg=" + matrDistrEnerg
				+ ", matricolaLenntCliente=" + matricolaLenntCliente + ", numTelGuasti=" + numTelGuasti + ", numTelInfo="
				+ numTelInfo + ", numeroUtenza=" + numeroUtenza + ", presenzaDatiSegr="
				+ presenzaDatiSegr + ", progLenntGruppo=" + progLenntGruppo + ", progressivoAnno=" + progressivoAnno
				+ ", raggLennt=" + raggLennt + ", releaseFirmware=" + releaseFirmware + ", statoAllegEmerg=" + statoAllegEmerg
				+ ", statoAllegProgr=" + statoAllegProgr + ", tipo=" + tipo + ", tipoAlimentazione=" + tipoAlimentazione
				+ ", tipoAssegnazione=" + tipoAssegnazione + ", ultimoContatto=" + ultimoContatto 
				+ ", utenzaSpeciale="+utenzaSpeciale+", flagAbilitazione="+flagAbilitazione+", billingMode="
				+ billingMode + ", gruppoHDLC="+gruppoHDLC + ", progressivoHDLC="+progressivoHDLC + ", indirizzoHDLC="+indirizzoHDLC + "]";

	}
	
	



	public static enum TipoUtenza {
		SPECIALE("1"),
		STANDARD("0");

		private String	dbValue;

		private TipoUtenza(String dbValue) {
			this.dbValue = dbValue;
		}

		public String getDbValue() {
			return this.dbValue;
		}

		public static TipoUtenza parse(String dbValue) {
			if (dbValue == null)
				return null;
			for (TipoUtenza tu : TipoUtenza.values()) {
				if (tu.dbValue.equals(dbValue)) {
					return tu;
				}
				else
				if (tu.toString().equalsIgnoreCase(dbValue)) {
					return tu;
				}
			}
			throw new IllegalArgumentException("Invalid dbValue:" + dbValue);
		}
	}

	
}
