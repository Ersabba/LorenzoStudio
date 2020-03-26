package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class LenntClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String matricolaLenntCliente;
    String codConcentratore;
    String codGruppoApplicativo;
    String caratteristicaInstallazione;
    String codTiputt;
    String codTipmodin;
    String guastoLennt;
    String lingua;
    String codConfigAll;
    String matrDistrEnerg;
    String numeroUtenza;
    String numtelGuasti;
    String numtelInfo;
    String raggiungLennt;
    String releaseFirmware;
    String statoAlleggProgr;
    String statoAlleggEmerg;
    String presenzaDatiSegr;
    String annoFabbricazione;
    String codPosizione;
    String costruttore;
    String progressivoAnno;
    String tipo;
    String fase;
    String codCabinaSecondaria;
    String tipoAlimentazione;
    Integer indirizzo;
    Long codLineaBt;
    Long codSezione;
    Long coeffLimitazione;
    Long flagAbilitazione;
    Long flagRipetitore;
    Long progrLenntGruppo;
    Date ultimoContatto;
    String tipoAssegnazione;
    // Modifiche R01
    String codConcentratore2;
    String codConcentratore3;
    Integer utenzaSpeciale;

    public LenntClienteDTO() { }

    public LenntClienteDTO(LenntCliente lc)
    {
        setAnnoFabbricazione(lc.getAnnoFabbricazione());
        setCaratteristicaInstallazione(lc.getCaratteristicaInstallazione());
        setCodConcentratore(lc.getCodConcentratore());
        setCodConfigAll(lc.getCodConfigAll());
        setCodGruppoApplicativo(lc.getCodGruppoApplicativo());
        setCodLineaBt(lc.getCodLineaBt());
        setCodPosizione(lc.getCodPosizione());
        setFlagAbilitazione(lc.getFlagAbilitazione());
        setFlagRipetitore(lc.getFlagRipetitore());
        setCodSezione(lc.getCodSezione());
        setCodTipmodin(lc.getCodTipmodin());
        setCodTiputt(lc.getCodTiputt());
        setCoeffLimitazione(lc.getCoeffLimitazione());
        setCostruttore(lc.getCostruttore());
        setGuastoLennt(lc.getGuastoLennt());
        setIndirizzo(lc.getIndirizzo());
        setLingua(lc.getLingua());
        setMatrDistrEnerg(lc.getMatrDistrEnerg());
        setMatricolaLenntCliente(lc.getMatricolaLenntCliente());
        setNumtelGuasti(lc.getNumtelGuasti());
        setNumtelInfo(lc.getNumtelInfo());
        setNumeroUtenza(lc.getNumeroUtenza());
        setPresenzaDatiSegr(lc.getPresenzaDatiSegr());
        setProgressivoAnno(lc.getProgressivoAnno());
        setProgrLenntGruppo(lc.getProgrLenntGruppo());
        setRaggiungLennt(lc.getRaggiungLennt());
        setReleaseFirmware(lc.getReleaseFirmware());
        setStatoAlleggEmerg(lc.getStatoAlleggEmerg());
        setStatoAlleggProgr(lc.getStatoAlleggProgr());
        setTipo(lc.getTipo());
        setFase(lc.getFase());
        setUltimoContatto(lc.getUltimoContatto());
        setCodCabinaSecondaria(lc.getCodCabinaSecondaria());
        setTipoAlimentazione(lc.getTipoAlimentazione());
        setTipoAssegnazione(lc.getTipoAssegnazione());
        setCodConcentratore2(lc.getCodConcentratore2());
        setCodConcentratore3(lc.getCodConcentratore3());
        setUtenzaSpeciale(lc.getUtenzaSpeciale());
    }

    public static void setLenntCliente(LenntCliente lc, LenntClienteDTO lcd)
    {
        lc.setAnnoFabbricazione(lcd.getAnnoFabbricazione());
        lc.setCaratteristicaInstallazione(lcd.getCaratteristicaInstallazione());
        lc.setCodConcentratore(lcd.getCodConcentratore());
        lc.setCodConfigAll(lcd.getCodConfigAll());
        lc.setCodGruppoApplicativo(lcd.getCodGruppoApplicativo());
        lc.setCodLineaBt(lcd.getCodLineaBt());
        lc.setCodPosizione(lcd.getCodPosizione());
        lc.setFlagAbilitazione(lcd.getFlagAbilitazione());
        lc.setFlagRipetitore(lcd.getFlagRipetitore());
        lc.setCodSezione(lcd.getCodSezione());
        lc.setCodTipmodin(lcd.getCodTipmodin());
        lc.setCodTiputt(lcd.getCodTiputt());
        lc.setCoeffLimitazione(lcd.getCoeffLimitazione());
        lc.setCostruttore(lcd.getCostruttore());
        lc.setGuastoLennt(lcd.getGuastoLennt());
        lc.setIndirizzo(lcd.getIndirizzo());
        lc.setLingua(lcd.getLingua());
        lc.setMatrDistrEnerg(lcd.getMatrDistrEnerg());
        lc.setNumeroUtenza(lcd.getNumeroUtenza());
        lc.setNumtelGuasti(lcd.getNumtelGuasti());
        lc.setNumtelInfo(lcd.getNumtelInfo());
        lc.setPresenzaDatiSegr(lcd.getPresenzaDatiSegr());
        lc.setProgressivoAnno(lcd.getProgressivoAnno());
        lc.setProgrLenntGruppo(lcd.getProgrLenntGruppo());
        lc.setRaggiungLennt(lcd.getRaggiungLennt());
        lc.setReleaseFirmware(lcd.getReleaseFirmware());
        lc.setStatoAlleggEmerg(lcd.getStatoAlleggEmerg());
        lc.setStatoAlleggProgr(lcd.getStatoAlleggProgr());
        lc.setTipo(lcd.getTipo());
        lc.setFase(lcd.getFase());
        lc.setUltimoContatto(lcd.getUltimoContatto());
        lc.setCodCabinaSecondaria(lcd.getCodCabinaSecondaria());
        lc.setTipoAlimentazione(lcd.getTipoAlimentazione());
        lc.setTipoAssegnazione(lcd.getTipoAssegnazione());
        lc.setCodConcentratore2(lcd.getCodConcentratore2());
        lc.setCodConcentratore3(lcd.getCodConcentratore3());
        lc.setUtenzaSpeciale(lcd.getUtenzaSpeciale());
    }

    public String toString()
    {
        return new String("{matr. LENNT: " + matricolaLenntCliente + ", concentratore: " + codConcentratore + ", gruppo appl.: " + codGruppoApplicativo + ", caratt. inst.: " + caratteristicaInstallazione + ", tipo utente: " + codTiputt + ", tipo inst.: " + codTipmodin + ", guasto: " + guastoLennt + ", lingua: " + lingua + ", config. allegg. progr.: " + codConfigAll + ", matr. distr. energ.: " + matrDistrEnerg + ", num. utenza: " + numeroUtenza + ", tel. guasti: " + numtelGuasti + ", tel. info: " + numtelInfo + ", raggiungibile: " + raggiungLennt + ", release fw: " + releaseFirmware + ", stato allegg. progr.: " + statoAlleggProgr + ", stato allegg. emerg.: " + statoAlleggEmerg + ", presenza dati segr.: " + presenzaDatiSegr + ", anno: " + annoFabbricazione + ", posizione: " + codPosizione + ", costruttore: " + costruttore + ", indirizzo: " + indirizzo + ", progr. nell'anno: " + progressivoAnno + ", tipo: " + tipo + ", fase: " + fase + ", linea BT: " + codLineaBt + ", sezione: " + codSezione + ", coeff. limit.: " + coeffLimitazione + ", ripetitore: " + flagRipetitore + ", progr. gruppo appl.: " + progrLenntGruppo + ", ultimo contatto: " + ultimoContatto + ", cabina secondaria: " + codCabinaSecondaria + ", tipo alimentazione: " + tipoAlimentazione + "}");
    }

    public String getTipoAssegnazione() {
        return ParamUtils.nullSafeValue(tipoAssegnazione);
    }

    public void setTipoAssegnazione(String val) {
        tipoAssegnazione = ParamUtils.nullSafeValue(val);
    }

    public String getMatricolaLenntCliente()
    {
        return ParamUtils.nullSafeValue(matricolaLenntCliente);
    }

    public void setMatricolaLenntCliente(String value)
    {
        matricolaLenntCliente = ParamUtils.nullSafeValue(value);
    }

    public void checkMatricolaLenntCliente()
        throws Exception
    {
        ParamChecker.checkMatricolaLenntCliente(matricolaLenntCliente);
        setCostruttore(matricolaLenntCliente.substring(0, 2));
        setTipo(matricolaLenntCliente.substring(4, 6));
        setAnnoFabbricazione(matricolaLenntCliente.substring(2, 4));
        setProgressivoAnno(matricolaLenntCliente.substring(6));
    }

    public String getCodConcentratore()
    {
        return ParamUtils.nullSafeValue(codConcentratore);
    }

    public void setCodConcentratore(String value)
    {
        codConcentratore = ParamUtils.nullSafeValue(value);
    }

    public String getCodGruppoApplicativo()
    {
        return ParamUtils.nullSafeValue(codGruppoApplicativo);
    }

    public void setCodGruppoApplicativo(String value)
    {
        codGruppoApplicativo = ParamUtils.nullSafeValue(value);
    }

    public String getCaratteristicaInstallazione()
    {
        return ParamUtils.nullSafeValue(caratteristicaInstallazione);
    }

    public void setCaratteristicaInstallazione(String value)
    {
        caratteristicaInstallazione = ParamUtils.nullSafeValue(value);
    }

    public String getCodTiputt()
    {
        return ParamUtils.nullSafeValue(codTiputt);
    }

    public void setCodTiputt(String value)
    {
        codTiputt = ParamUtils.nullSafeValue(value);
    }

    public String getCodTipmodin()
    {
        return ParamUtils.nullSafeValue(codTipmodin);
    }

    public void setCodTipmodin(String value)
    {
        codTipmodin = ParamUtils.nullSafeValue(value);
    }

    public String getGuastoLennt()
    {
        return ParamUtils.nullSafeValue(guastoLennt);
    }

    public void setGuastoLennt(String value)
    {
        guastoLennt = ParamUtils.nullSafeValue(value);
    }

    public String getLingua()
    {
        return ParamUtils.nullSafeValue(lingua);
    }

    public void setLingua(String value)
    {
        lingua = ParamUtils.nullSafeValue(value);
    }

    public String getCodConfigAll()
    {
        return ParamUtils.nullSafeValue(codConfigAll);
    }

    public void setCodConfigAll(String value)
    {
        codConfigAll = ParamUtils.nullSafeValue(value);
    }

    public String getMatrDistrEnerg()
    {
        return ParamUtils.nullSafeValue(matrDistrEnerg);
    }

    public void setMatrDistrEnerg(String value)
    {
        matrDistrEnerg = ParamUtils.nullSafeValue(value);
    }

    public String getNumeroUtenza()
    {
        return ParamUtils.nullSafeValue(numeroUtenza);
    }

    public void setNumeroUtenza(String value)
    {
        numeroUtenza = ParamUtils.nullSafeValue(value);
    }

    public void checkNumeroUtenza()
        throws Exception
    {
        ParamChecker.checkNumeroUtenza(numeroUtenza);
    }

    public String getNumtelGuasti()
    {
        return ParamUtils.nullSafeValue(numtelGuasti);
    }

    public void setNumtelGuasti(String value)
    {
        numtelGuasti = ParamUtils.nullSafeValue(value);
    }

    public String getNumtelInfo()
    {
        return ParamUtils.nullSafeValue(numtelInfo);
    }

    public void setNumtelInfo(String value)
    {
        numtelInfo = ParamUtils.nullSafeValue(value);
    }

    public String getRaggiungLennt()
    {
        return ParamUtils.nullSafeValue(raggiungLennt);
    }

    public void setRaggiungLennt(String value)
    {
        raggiungLennt = ParamUtils.nullSafeValue(value);
    }

    public String getReleaseFirmware()
    {
        return ParamUtils.nullSafeValue(releaseFirmware);
    }

    public void setReleaseFirmware(String value)
    {
        releaseFirmware = ParamUtils.nullSafeValue(value);
    }

    public String getStatoAlleggProgr()
    {
        return ParamUtils.nullSafeValue(statoAlleggProgr);
    }

    public void setStatoAlleggProgr(String value)
    {
        statoAlleggProgr = ParamUtils.nullSafeValue(value);
    }

    public String getStatoAlleggEmerg()
    {
        return ParamUtils.nullSafeValue(statoAlleggEmerg);
    }

    public void setStatoAlleggEmerg(String value)
    {
        statoAlleggEmerg = ParamUtils.nullSafeValue(value);
    }

    public String getPresenzaDatiSegr()
    {
        return ParamUtils.nullSafeValue(presenzaDatiSegr);
    }

    public void setPresenzaDatiSegr(String value)
    {
        presenzaDatiSegr = ParamUtils.nullSafeValue(value);
    }

    public String getAnnoFabbricazione()
    {
        return ParamUtils.nullSafeValue(annoFabbricazione);
    }

    public void setAnnoFabbricazione(String value)
    {
        annoFabbricazione = ParamUtils.nullSafeValue(value);
    }

    public String getCodPosizione()
    {
        return ParamUtils.nullSafeValue(codPosizione);
    }

    public void setCodPosizione(String value)
    {
        codPosizione = ParamUtils.nullSafeValue(value);
    }

    public String getCostruttore()
    {
        return ParamUtils.nullSafeValue(costruttore);
    }

    public void setCostruttore(String value)
    {
        costruttore = ParamUtils.nullSafeValue(value);
    }

    public Integer getIndirizzo()
    {
        return ParamUtils.nullSafeValue(indirizzo);
    }

    public void setIndirizzo(Integer value)
    {
        indirizzo = ParamUtils.nullSafeValue(value);
    }

    public String getProgressivoAnno()
    {
        return ParamUtils.nullSafeValue(progressivoAnno);
    }

    public void setProgressivoAnno(String value)
    {
        progressivoAnno = ParamUtils.nullSafeValue(value);
    }

    public String getTipo()
    {
        return ParamUtils.nullSafeValue(tipo);
    }

    public void setTipo(String value)
    {
        tipo = ParamUtils.nullSafeValue(value);
    }

    public String getFase()
    {
        return ParamUtils.nullSafeValue(fase);
    }

    public void setFase(String value)
    {
        fase = ParamUtils.nullSafeValue(value);
    }

    public String getCodCabinaSecondaria()
    {
        return ParamUtils.nullSafeValue(codCabinaSecondaria);
    }

    public void setCodCabinaSecondaria(String value)
    {
        codCabinaSecondaria = ParamUtils.nullSafeValue(value);
    }

    public String getTipoAlimentazione()
    {
        return ParamUtils.nullSafeValue(tipoAlimentazione);
    }

    public void setTipoAlimentazione(String value)
    {
        tipoAlimentazione = ParamUtils.nullSafeValue(value);
    }

    public Long getCodLineaBt()
    {
        return ParamUtils.nullSafeValue(codLineaBt);
    }

    public void setCodLineaBt(Long value)
    {
        codLineaBt = ParamUtils.nullSafeValue(value);
    }

    public Long getCodSezione()
    {
        return ParamUtils.nullSafeValue(codSezione);
    }

    public void setCodSezione(Long value)
    {
        codSezione = ParamUtils.nullSafeValue(value);
    }

    public Long getCoeffLimitazione()
    {
        return ParamUtils.nullSafeValue(coeffLimitazione);
    }

    public void setCoeffLimitazione(Long value)
    {
        coeffLimitazione = ParamUtils.nullSafeValue(value);
    }

    public Long getFlagAbilitazione()
    {
        return ParamUtils.nullSafeValue(flagAbilitazione);
    }

    public void setFlagAbilitazione(Long value)
    {
        flagAbilitazione = ParamUtils.nullSafeValue(value);
    }

    public Long getFlagRipetitore()
    {
        return ParamUtils.nullSafeValue(flagRipetitore);
    }

    public void setFlagRipetitore(Long value)
    {
        flagRipetitore = ParamUtils.nullSafeValue(value);
    }

    public Long getProgrLenntGruppo()
    {
        return ParamUtils.nullSafeValue(progrLenntGruppo);
    }

    public void setProgrLenntGruppo(Long value)
    {
        progrLenntGruppo = ParamUtils.nullSafeValue(value);
    }

    public Date getUltimoContatto()
    {
        return ParamUtils.nullSafeValue(ultimoContatto);
    }

    public void setUltimoContatto(Date value)
    {
        ultimoContatto = ParamUtils.nullSafeValue(value);
    }
    
    // Modifiche R01
    public String getCodConcentratore2()
    {
        return ParamUtils.nullSafeValue(codConcentratore2);
    }

    public void setCodConcentratore2(String value)
    {
    	codConcentratore2 = ParamUtils.nullSafeValue(value);
    }
    
    public String getCodConcentratore3()
    {
        return ParamUtils.nullSafeValue(codConcentratore3);
    }

    public void setCodConcentratore3(String value)
    {
    	codConcentratore3 = ParamUtils.nullSafeValue(value);
    }
    // end

    
    public Integer getUtenzaSpeciale()
    {
        return ParamUtils.nullSafeValue(utenzaSpeciale);
    }

    public void setUtenzaSpeciale(Integer value)
    {
    	utenzaSpeciale = ParamUtils.nullSafeValue(value);
    }
    
    public void check() throws Exception {
        checkMatricolaLenntCliente();
    }
}
