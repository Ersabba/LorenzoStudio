package com.ericsson.mgre.biz.reductionsMgmt.reductions;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class ProgressiviLiberatiDTO implements Serializable {

    String codGruppoApplicativo;
    Long progrLiberato;

    public ProgressiviLiberatiDTO() { }

    public ProgressiviLiberatiDTO(ProgressiviLiberati pl) {
        setCodGruppoApplicativo(pl.getCodGruppoApplicativo());
        setProgrLiberato(pl.getProgrLiberato());
    }

    public static void setProgressiviLiberati(ProgressiviLiberati progressiviliberati, ProgressiviLiberatiDTO progressiviliberatidto) { }

    public String toString() {
        return new String("{gruppo applicativo: " + codGruppoApplicativo + ", progr. libero: " + progrLiberato + "}");
    }

    public void setProgrLiberato(Long value) {
        progrLiberato = ParamUtils.nullSafeValue(value);
    }

    public Long getProgrLiberato() {
        return ParamUtils.nullSafeValue(progrLiberato);
    }

    public void setCodGruppoApplicativo(String value) {
        codGruppoApplicativo = ParamUtils.nullSafeValue(value);
    }

    public void checkCodGruppoApplicativo() throws Exception {
        ParamChecker.checkCodGruppoApplicativo(codGruppoApplicativo);
    }

    public String getCodGruppoApplicativo() {
        return ParamUtils.nullSafeValue(codGruppoApplicativo);
    }

    public void check() throws Exception {
        checkCodGruppoApplicativo();
    }
}
