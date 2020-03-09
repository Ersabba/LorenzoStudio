package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class LenntCliente implements Serializable, MgdbDto {
	private final static long serialVersionUID = -1;
	private String matricolaLenntCliente=null;
	private String codConcentratore=null;
	private String codTipmodin=null;
	private String giornoSettimana=null;
	private Long coeffLimitazione=null;
	private String codConfigAll=null;
	private String codTiputt=null;
	private String codGruppoApplicativo=null;
	private Long codLineaBt=null;
	private Long codSezione=null;
	private Long flagRipetitore=null;
	private Long progLenntGruppo=null;
	private String caratteristicaInstallazione=null;
	private String raggLennt=null;
	private String statoAllegEmerg=null;
	private String guastoLennt=null;
	private String statoAllegProgr=null;
	private String presenzaDatiSegr=null;
	private String codPosizione=null;
	private Long indirizzo=null;
	private String costruttore=null;
	private LenntType tipo=null;
	private String annoFabbricazione=null;
	private String progressivoAnno=null;
	private String matrDistrEnerg=null;
	private String lingua=null;
	private String releaseFirmware=null;
	private String numTelGuasti=null;
	private String numTelInfo=null;
	private String numeroUtenza=null;
	private String fase=null;
	private String faseOld=null;
	private Date   dataFase=null;
	private Date   ultimoContatto=null;
	private String cabinaSecondaria=null;
	private String tipoAlimentazione=null;
	private String tipoAssegnazione=null;
	private String codConcentratore2=null;
	private String codConcentratore3=null;
	private String modello = null;
	private boolean     billingMode                 = false;
	private Date   		ultimoContattoAdd  			= null;
	private Date   		lastPunctualFailure	        = null;
	
	public LenntCliente() {
		super();
	}

	public Object clone() {
		try {
			LenntCliente lc = (LenntCliente) super.clone();
			if (dataFase != null)
				lc.dataFase = (Date) dataFase.clone();
			if (ultimoContatto != null)
				lc.ultimoContatto = (Date) ultimoContatto.clone();
			if (ultimoContattoAdd != null)
				lc.ultimoContattoAdd = (Date) ultimoContattoAdd.clone();
			if (lastPunctualFailure != null)
				lc.lastPunctualFailure = (Date) lastPunctualFailure.clone();
			return lc;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		LenntCliente other = (LenntCliente)srcDto;
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
		this.ultimoContattoAdd = other.ultimoContattoAdd;
		this.lastPunctualFailure = other.lastPunctualFailure;
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
		return codTiputt;
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


	public LenntType getTipo() {
		return tipo;
	}


	public void setTipo(LenntType tipo) {
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
	
	public void setGatewayCode(String gatewayCode) {
		this.codConcentratore = gatewayCode;
	}
	
	public String getGatewayCode() {
		return this.codConcentratore;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	public String getModello() {
		return this.modello;
	}

	public boolean isBillingMode() {
		return billingMode;
	}

	public void setBillingMode(boolean billingMode) {
		this.billingMode = billingMode;
	}

	public Date getUltimoContattoAdd() {
		return ultimoContattoAdd;
	}

	public void setUltimoContattoAdd(Date ultimoContattoAdd) {
		this.ultimoContattoAdd = ultimoContattoAdd;
	}
	


	public Date getLastPunctualFailure() {
		return lastPunctualFailure;
	}

	public void setLastPunctualFailure(Date lastPunctualFailure) {
		this.lastPunctualFailure = lastPunctualFailure;
	}

	@Override
	public String toString() {
		return "LenntCliente [matricolaLenntCliente=" + matricolaLenntCliente + ", codConcentratore=" + codConcentratore
				+ ", codTipmodin=" + codTipmodin + ", giornoSettimana=" + giornoSettimana + ", coeffLimitazione="
				+ coeffLimitazione + ", codConfigAll=" + codConfigAll + ", codTiputt=" + codTiputt
				+ ", codGruppoApplicativo=" + codGruppoApplicativo + ", codLineaBt=" + codLineaBt + ", codSezione="
				+ codSezione + ", flagRipetitore=" + flagRipetitore + ", progLenntGruppo=" + progLenntGruppo
				+ ", caratteristicaInstallazione=" + caratteristicaInstallazione + ", raggLennt=" + raggLennt
				+ ", statoAllegEmerg=" + statoAllegEmerg + ", guastoLennt=" + guastoLennt + ", statoAllegProgr="
				+ statoAllegProgr + ", presenzaDatiSegr=" + presenzaDatiSegr + ", codPosizione=" + codPosizione
				+ ", indirizzo=" + indirizzo + ", costruttore=" + costruttore + ", tipo=" + tipo
				+ ", annoFabbricazione=" + annoFabbricazione + ", progressivoAnno=" + progressivoAnno
				+ ", matrDistrEnerg=" + matrDistrEnerg + ", lingua=" + lingua + ", releaseFirmware=" + releaseFirmware
				+ ", numTelGuasti=" + numTelGuasti + ", numTelInfo=" + numTelInfo + ", numeroUtenza=" + numeroUtenza
				+ ", fase=" + fase + ", faseOld=" + faseOld + ", dataFase=" + dataFase + ", ultimoContatto="
				+ ultimoContatto + ", cabinaSecondaria=" + cabinaSecondaria + ", tipoAlimentazione=" + tipoAlimentazione
				+ ", tipoAssegnazione=" + tipoAssegnazione + ", codConcentratore2=" + codConcentratore2
				+ ", codConcentratore3=" + codConcentratore3 + ", modello=" + modello + ", billingMode=" + billingMode
				+ ", ultimoContattoAdd="
				+ ultimoContattoAdd + ", lastPunctualFailure="
				+ lastPunctualFailure + "]";
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
