package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class CabinaSecondariaDTO  implements Serializable  {

    String codCabinaSecondaria;
    String codZona;
    String codDensita;
    String indirizzoCabina;
    String nomeCabina;
    String note;
    String statoGuasto;

    public CabinaSecondariaDTO() { }

    public CabinaSecondariaDTO(CabinaSecondaria cs) {
        setCodCabinaSecondaria(cs.getCodCabinaSecondaria());
        setCodZona(cs.getCodZona());
        setCodDensita(cs.getCodDensita());
        setIndirizzoCabina(cs.getIndirizzoCabina());
        setNomeCabina(cs.getNomeCabina());
        setNote(cs.getNote());
        setStatoGuasto(cs.getStatoGuasto());
    }

    public static void setCabinaSecondaria(CabinaSecondaria cs, CabinaSecondariaDTO csd) {
        cs.setCodZona(csd.getCodZona());
        cs.setCodDensita(csd.getCodDensita());
        cs.setIndirizzoCabina(csd.getIndirizzoCabina());
        cs.setNomeCabina(csd.getNomeCabina());
        cs.setNote(csd.getNote());
        cs.setStatoGuasto(csd.getStatoGuasto());
    }

    public String toString() {
        return new String("{id.: " + codCabinaSecondaria + ", zona: " + codZona + ", densit\340: " + codDensita + ", indirizzo: " + indirizzoCabina + ", nome: " + nomeCabina + ", note: " + note + ", stato: " + statoGuasto + "}");
    }

    public void setCodCabinaSecondaria(String value) {
        codCabinaSecondaria = ParamUtils.nullSafeValue(value);
    }

    public void checkCodCabinaSecondaria() throws Exception {
        ParamChecker.checkCodCabinaSecondaria(codCabinaSecondaria);
    }

    public void setCodZona(String value) {
        codZona = ParamUtils.nullSafeValue(value);
    }

    public void setCodDensita(String value) {
        codDensita = ParamUtils.nullSafeValue(value);
    }

    public void setIndirizzoCabina(String value) {
        indirizzoCabina = ParamUtils.nullSafeValue(value);
    }

    public void setNomeCabina(String value) {
        nomeCabina = ParamUtils.nullSafeValue(value);
    }

    public void setNote(String value) {
        note = ParamUtils.nullSafeValue(value);
    }

    public void setStatoGuasto(String value) {
        statoGuasto = ParamUtils.nullSafeValue(value);
    }

    public String getCodCabinaSecondaria() {
        return ParamUtils.nullSafeValue(codCabinaSecondaria);
    }

    public String getCodZona() {
        return ParamUtils.nullSafeValue(codZona);
    }

    public String getCodDensita() {
        return ParamUtils.nullSafeValue(codDensita);
    }

    public String getIndirizzoCabina() {
        return ParamUtils.nullSafeValue(indirizzoCabina);
    }

    public String getNomeCabina() {
        return ParamUtils.nullSafeValue(nomeCabina);
    }

    public String getNote() {
        return ParamUtils.nullSafeValue(note);
    }

    public String getStatoGuasto() {
        return ParamUtils.nullSafeValue(statoGuasto);
    }

    public void check() throws Exception {
        checkCodCabinaSecondaria();
    }
}
