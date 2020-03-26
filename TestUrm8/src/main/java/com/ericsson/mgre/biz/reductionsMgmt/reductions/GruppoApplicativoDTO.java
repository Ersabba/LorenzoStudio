package com.ericsson.mgre.biz.reductionsMgmt.reductions;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class GruppoApplicativoDTO implements Serializable {

    String codGruppoApplicativo;
    String codConfigAll;
    String giornoSettimana;
    String codCabinaSecondaria;
    String codTiputt;
    String statoAlleggEmerg;
    String statoAlleggProgr;
    Long coeffLimitazione;
    Long primoProgrUtile;

    public GruppoApplicativoDTO() { }

    public GruppoApplicativoDTO(GruppoApplicativo ga) {
        setCodGruppoApplicativo(ga.getCodGruppoApplicativo());
        setCodCabinaSecondaria(ga.getCodCabinaSecondaria());
        setCodTiputt(ga.getCodTiputt());
        setCodConfigAll(ga.getCodConfigAll());
        setGiornoSettimana(ga.getGiornoSettimana());
        setCoeffLimitazione(ga.getCoeffLimitazione());
        setPrimoProgrUtile(ga.getPrimoProgrUtile());
        setStatoAlleggEmerg(ga.getStatoAlleggEmerg());
        setStatoAlleggProgr(ga.getStatoAlleggProgr());
    }

    public static void setGruppoApplicativo(GruppoApplicativo ga, GruppoApplicativoDTO gad) {
        ga.setCodCabinaSecondaria(gad.getCodCabinaSecondaria());
        ga.setCodTiputt(gad.getCodTiputt());
        ga.setCodConfigAll(gad.getCodConfigAll());
        ga.setGiornoSettimana(gad.getGiornoSettimana());
        ga.setCoeffLimitazione(gad.getCoeffLimitazione());
        ga.setPrimoProgrUtile(gad.getPrimoProgrUtile());
        ga.setStatoAlleggEmerg(gad.getStatoAlleggEmerg());
        ga.setStatoAlleggProgr(gad.getStatoAlleggProgr());
    }

    public String toString() {
        return new String("{gruppo applicativo: " + codGruppoApplicativo + ", cabina secondaria: " + codCabinaSecondaria + ", tipo utente: " + codTiputt + ", piano di alleggerimento: " + codConfigAll + ", giorno della settimana: " + giornoSettimana + ", coeff. di limitazione: " + coeffLimitazione + ", primo progressivo utile: " + primoProgrUtile + ", stato alleg. emerg.: " + statoAlleggEmerg + ", stato alleg. progr.: " + statoAlleggProgr + "}");
    }

    public void setCodConfigAll(String value) {
        codConfigAll = ParamUtils.nullSafeValue(value);
    }

    public void checkCodGruppoApplicativo() throws Exception {
        ParamChecker.checkCodGruppoApplicativo(codGruppoApplicativo);
    }

    public String getCodConfigAll() {
        return ParamUtils.nullSafeValue(codConfigAll);
    }

    public void setGiornoSettimana(String value) {
        giornoSettimana = ParamUtils.nullSafeValue(value);
    }

    public void checkGiornoSettimana() throws Exception {
        ParamChecker.checkGiornoSettimana(giornoSettimana);
    }

    public String getGiornoSettimana() {
        return ParamUtils.nullSafeValue(giornoSettimana);
    }

    public void setCoeffLimitazione(Long value) {
        coeffLimitazione = ParamUtils.nullSafeValue(value);
    }

    public Long getCoeffLimitazione() {
        return ParamUtils.nullSafeValue(coeffLimitazione);
    }

    public void setPrimoProgrUtile(Long value) {
        primoProgrUtile = ParamUtils.nullSafeValue(value);
    }

    public Long getPrimoProgrUtile() {
        return ParamUtils.nullSafeValue(primoProgrUtile);
    }

    public void setCodCabinaSecondaria(String value) {
        codCabinaSecondaria = ParamUtils.nullSafeValue(value);
    }

    public void checkCodCabinaSecondaria() throws Exception {
        ParamChecker.checkCodCabinaSecondaria(codCabinaSecondaria);
    }

    public String getCodCabinaSecondaria() {
        return ParamUtils.nullSafeValue(codCabinaSecondaria);
    }

    public void setCodGruppoApplicativo(String value) {
        codGruppoApplicativo = ParamUtils.nullSafeValue(value);
    }

    public String getCodGruppoApplicativo() {
        return ParamUtils.nullSafeValue(codGruppoApplicativo);
    }

    public void setCodTiputt(String value) {
        codTiputt = ParamUtils.nullSafeValue(value);
    }

    public void checkCodTiputt() throws Exception {
        ParamChecker.checkCodTiputt(codTiputt);
    }

    public String getCodTiputt() {
        return ParamUtils.nullSafeValue(codTiputt);
    }

    public void setStatoAlleggEmerg(String value) {
        statoAlleggEmerg = ParamUtils.nullSafeValue(value);
    }

    public String getStatoAlleggEmerg() {
        return ParamUtils.nullSafeValue(statoAlleggEmerg);
    }

    public void setStatoAlleggProgr(String value) {
        statoAlleggProgr = ParamUtils.nullSafeValue(value);
    }

    public String getStatoAlleggProgr() {
        return ParamUtils.nullSafeValue(statoAlleggProgr);
    }

    public void check() throws Exception {
        checkCodCabinaSecondaria();
        checkCodTiputt();
        setCodGruppoApplicativo(getCodCabinaSecondaria() + getCodTiputt().substring(2));
        checkCodGruppoApplicativo();
    }
}