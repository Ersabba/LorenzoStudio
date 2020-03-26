package com.ericsson.mgre.biz.networkMgmt.element.config;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class TipoUtenteDTO implements Serializable {

    String codTiputt;
    String desTiputt;

    public String toString() {
        return new String("{codice: " + codTiputt + ", descrizione: " + desTiputt + "}");
    }

    public TipoUtenteDTO() { }

    public TipoUtenteDTO(TipoUtente tu) {
        setCodTiputt(tu.getCodTiputt());
        setDesTiputt(tu.getDesTiputt());
    }

    public static void setTipoUtente(TipoUtente tu, TipoUtenteDTO tud) {
        tu.setCodTiputt(tud.getCodTiputt());
        tu.setDesTiputt(tud.getDesTiputt());
    }

    public void setCodTiputt(String valore) {
        codTiputt = ParamUtils.nullSafeValue(valore);
    }

    public String getCodTiputt() {
        return ParamUtils.nullSafeValue(codTiputt);
    }

    public void setDesTiputt(String valore) {
        desTiputt = ParamUtils.nullSafeValue(valore);
    }

    public String getDesTiputt() {
        return ParamUtils.nullSafeValue(desTiputt);
    }
}
