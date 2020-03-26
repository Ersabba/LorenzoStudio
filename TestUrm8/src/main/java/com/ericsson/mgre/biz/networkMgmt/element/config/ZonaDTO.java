package com.ericsson.mgre.biz.networkMgmt.element.config;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class ZonaDTO implements Serializable {

    String codZona;
    String descZona;

    public String toString() {
        return new String("{codice: " + codZona + ", descrizione: " + descZona + "}");
    }

    public ZonaDTO() { }

    public ZonaDTO(Zona z) {
        setCodZona(z.getCodZona());
        setDescZona(z.getDescZona());
    }

    public static void setZona(Zona z, ZonaDTO zd) {
        z.setCodZona(zd.getCodZona());
        z.setDescZona(zd.getDescZona());
    }

    public void setCodZona(String valore) {
        codZona = ParamUtils.nullSafeValue(valore);
    }

    public String getCodZona() {
        return ParamUtils.nullSafeValue(codZona);
    }

    public void setDescZona(String valore) {
        descZona = ParamUtils.nullSafeValue(valore);
    }

    public String getDescZona() {
        return ParamUtils.nullSafeValue(descZona);
    }
}
