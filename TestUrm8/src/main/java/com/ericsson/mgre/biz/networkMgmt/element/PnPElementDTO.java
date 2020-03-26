package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class PnPElementDTO implements Serializable {

    String matricolaCCS;
    String matricolaLennt;
    String dataPnP;
    String statistiche;
    String ccs_precedente;
    String stat_precedenti;

    public PnPElementDTO() { }

    public PnPElementDTO(PnPElement pnp) {
        setMatricolaCCS(pnp.getCcs());
        setMatricolaLennt(pnp.getLennt());
        setDataPnP(pnp.getDataPnP());
        setStatistiche(pnp.getStat());
        setCcsPrecedente(pnp.getCcsPre());
        setStatistichePrecedenti(pnp.getStatCcsPre());
    }

    public static void setPnPElemet(PnPElement pnp, PnPElementDTO pnpd) {
        pnp.setCcs(pnpd.getMatricolaCCS());
        pnp.setLennt(pnpd.getMatricolaLennt());
        pnp.setDataPnP(pnpd.getDataPnP());
        pnp.setStat(pnpd.getStatistiche());
        pnp.setCcsPre(pnpd.getCcsPrecedente());
        pnp.setStatCcsPre(pnpd.getStatistichePrecedenti());
    }

    public String toString()
    {
        return new String("{matricola CCS: " + matricolaCCS + ", matr. LENNT: " + matricolaLennt + ", data pnp: " + dataPnP + ", statistiche: " + statistiche + "}");
    }

    public void setMatricolaCCS(String value) {
        matricolaCCS = ParamUtils.nullSafeValue(value);
    }

    public void setMatricolaLennt(String value) {
        matricolaLennt = ParamUtils.nullSafeValue(value);
    }

    public void setDataPnP(String value) {
        dataPnP = ParamUtils.nullSafeValue(value);
    }

    public void setStatistiche(String value) {
        statistiche = ParamUtils.nullSafeValue(value);
    }

    public void setCcsPrecedente(String value) {
        ccs_precedente = ParamUtils.nullSafeValue(value);
    }

    public void setStatistichePrecedenti(String value) {
        stat_precedenti = ParamUtils.nullSafeValue(value);
    }

    public String getMatricolaCCS() {
        return ParamUtils.nullSafeValue(matricolaCCS);
    }

    public String getMatricolaLennt() {
       return ParamUtils.nullSafeValue(matricolaLennt);
    }

    public String getDataPnP() {
        return ParamUtils.nullSafeValue(dataPnP);
    }

    public String getStatistiche() {
        return ParamUtils.nullSafeValue(statistiche);
    }

    public String getCcsPrecedente() {
        return ParamUtils.nullSafeValue(ccs_precedente);
    }

    public String getStatistichePrecedenti() {
        return ParamUtils.nullSafeValue(stat_precedenti);
    }
}
