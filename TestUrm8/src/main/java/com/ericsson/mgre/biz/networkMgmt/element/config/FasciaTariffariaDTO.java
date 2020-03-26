package com.ericsson.mgre.biz.networkMgmt.element.config;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class FasciaTariffariaDTO implements Serializable {

    String codFascia;
    String descrizioneFascia;

    public String toString() {
        return new String("{codice: " + codFascia + ", descrizione: " + descrizioneFascia + "}");
    }

    public FasciaTariffariaDTO() { }

    public FasciaTariffariaDTO(FasciaTariffaria ft) {
        setCodFascia(ft.getCodFascia());
        setDescrizioneFascia(ft.getDescrizioneFascia());
    }

    public static void setFasciaTariffaria(FasciaTariffaria ft, FasciaTariffariaDTO ftd) {
        ft.setCodFascia(ftd.getCodFascia());
        ft.setDescrizioneFascia(ftd.getDescrizioneFascia());
    }

    public void setCodFascia(String valore) {
        codFascia = ParamUtils.nullSafeValue(valore);
    }

    public String getCodFascia() {
        return ParamUtils.nullSafeValue(codFascia);
    }

    public void setDescrizioneFascia(String valore) {
        descrizioneFascia = ParamUtils.nullSafeValue(valore);
    }

    public String getDescrizioneFascia() {
        return ParamUtils.nullSafeValue(descrizioneFascia);
    }
}