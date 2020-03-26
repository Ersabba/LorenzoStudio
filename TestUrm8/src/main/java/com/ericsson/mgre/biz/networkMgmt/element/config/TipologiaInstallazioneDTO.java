package com.ericsson.mgre.biz.networkMgmt.element.config;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class TipologiaInstallazioneDTO implements Serializable {

    String codTipmodin;
    String desTipmodin;

    public String toString() {
        return new String("{codice: " + codTipmodin + ", descrizione: " + desTipmodin + "}");
    }

    public TipologiaInstallazioneDTO() { }

    public TipologiaInstallazioneDTO(TipologiaInstallazione ti) {
        setCodTipmodin(ti.getCodTipmodin());
        setDesTipmodin(ti.getDesTipmodin());
    }

    public static void setTipologiaInstallazione(TipologiaInstallazione ti, TipologiaInstallazioneDTO tid) {
        ti.setCodTipmodin(tid.getCodTipmodin());
        ti.setDesTipmodin(tid.getDesTipmodin());
    }

    public void setCodTipmodin(String valore) {
        codTipmodin = ParamUtils.nullSafeValue(valore);
    }

    public String getCodTipmodin() {
        return ParamUtils.nullSafeValue(codTipmodin);
    }

    public void setDesTipmodin(String valore) {
        desTipmodin = ParamUtils.nullSafeValue(valore);
    }

    public String getDesTipmodin() {
        return ParamUtils.nullSafeValue(desTipmodin);
    }
}
