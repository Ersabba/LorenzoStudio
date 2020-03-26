package com.ericsson.mgre.biz.networkMgmt.element.config;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

// Referenced classes of package com.ericsson.mgre.biz.networkMgmt.element.config:
//            Densita

public class DensitaDTO implements Serializable {

    String codDensita;
    String descDensita;

    public String toString() {
        return new String("{codice: " + codDensita + ", descrizione: " + descDensita + "}");
    }

    public DensitaDTO() { }

    public DensitaDTO(Densita d) {
        setCodDensita(d.getCodDensita());
        setDescDensita(d.getDescDensita());
    }

    public static void setDensita(Densita d, DensitaDTO dd) {
        d.setCodDensita(dd.getCodDensita());
        d.setDescDensita(dd.getDescDensita());
    }

    public void setCodDensita(String valore) {
        codDensita = ParamUtils.nullSafeValue(valore);
    }

    public String getCodDensita() {
        return ParamUtils.nullSafeValue(codDensita);
    }

    public void setDescDensita(String valore) {
        descDensita = ParamUtils.nullSafeValue(valore);
    }

    public String getDescDensita() {
        return ParamUtils.nullSafeValue(descDensita);
    }

}