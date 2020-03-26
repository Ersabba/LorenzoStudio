package com.ericsson.mgre.biz.countersMgmt.load;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.biz.countersMgmt.utils.ParamUtils;

public class CurvaDiCaricoDTO implements Serializable {

    String matricolaLenntCliente;
    String periodoAcquisizione;
    Date dataCurva;
    Long numPeriodo;
    Long periodoIntegrazione;
    Long attAss;
    Long attEr;
    Long reattCapAss;
    Long reattCapEr;
    Long reattIndAss;
    Long reattIndEr;

    public String toString()
    {
        return new String("{matr. LENNT: " + matricolaLenntCliente + ", periodo acquisizione: " + periodoAcquisizione + ", data: " + dataCurva.toString() + ", periodo integrazione: " + periodoIntegrazione + ", AA: " + attAss + ", AE: " + attEr + ", RCA: " + reattCapAss + ", RCE: " + reattCapEr + ", RIA: " + reattIndAss + ", RIE: " + reattIndEr + "}");
    }

    public CurvaDiCaricoDTO() { }

    public CurvaDiCaricoDTO(CurvaDiCarico cdc)
    {
        setMatricolaLenntCliente(cdc.getMatricolaLenntCliente());
        setDataCurva(cdc.getDataCurva());
        setNumPeriodo(cdc.getNumPeriodo());
        setPeriodoAcquisizione(cdc.getPeriodoAcquisizione());
        setPeriodoIntegrazione(cdc.getPeriodoIntegrazione());
        setAttAss(cdc.getAttAss());
        setAttEr(cdc.getAttEr());
        setReattCapAss(cdc.getReattCapAss());
        setReattCapEr(cdc.getReattCapEr());
        setReattIndAss(cdc.getReattIndAss());
        setReattIndEr(cdc.getReattIndEr());
    }

    public static void setCurvaDiCarico(CurvaDiCarico cdc, CurvaDiCaricoDTO cdcd)
    {
        cdc.setPeriodoAcquisizione(cdcd.getPeriodoAcquisizione());
        cdc.setPeriodoIntegrazione(cdcd.getPeriodoIntegrazione());
        cdc.setAttAss(cdcd.getAttAss());
        cdc.setAttEr(cdcd.getAttEr());
        cdc.setReattCapAss(cdcd.getReattCapAss());
        cdc.setReattCapEr(cdcd.getReattCapEr());
        cdc.setReattIndAss(cdcd.getReattIndAss());
        cdc.setReattIndEr(cdcd.getReattIndEr());
    }

    public void setMatricolaLenntCliente(String valore)
    {
        matricolaLenntCliente = ParamUtils.nullSafeValue(valore);
    }

    public String getMatricolaLenntCliente()
    {
        return ParamUtils.nullSafeValue(matricolaLenntCliente);
    }

    public void setPeriodoAcquisizione(String valore)
    {
        periodoAcquisizione = ParamUtils.nullSafeValue(valore);
    }

    public String getPeriodoAcquisizione()
    {
        return ParamUtils.nullSafeValue(periodoAcquisizione);
    }

    public void setPeriodoIntegrazione(Long valore)
    {
        periodoIntegrazione = ParamUtils.nullSafeValue(valore);
    }

    public Long getPeriodoIntegrazione()
    {
        return ParamUtils.nullSafeValue(periodoIntegrazione);
    }

    public void setNumPeriodo(Long valore)
    {
        numPeriodo = ParamUtils.nullSafeValue(valore);
    }

    public Long getNumPeriodo()
    {
        return ParamUtils.nullSafeValue(numPeriodo);
    }

    public void setDataCurva(Date yyMMdd)
    {
        dataCurva = ParamUtils.nullSafeValue(yyMMdd);
    }

    public Date getDataCurva()
    {
        return ParamUtils.nullSafeValue(dataCurva);
    }

    public void setAttAss(Long valore)
    {
        attAss = ParamUtils.nullSafeValue(valore);
    }

    public Long getAttAss()
    {
        return ParamUtils.nullSafeValue(attAss);
    }

    public void setAttEr(Long valore)
    {
        attEr = ParamUtils.nullSafeValue(valore);
    }

    public Long getAttEr()
    {
        return ParamUtils.nullSafeValue(attEr);
    }

    public void setReattCapAss(Long valore)
    {
        reattCapAss = ParamUtils.nullSafeValue(valore);
    }

    public Long getReattCapAss()
    {
        return ParamUtils.nullSafeValue(reattCapAss);
    }

    public void setReattCapEr(Long valore)
    {
        reattCapEr = ParamUtils.nullSafeValue(valore);
    }

    public Long getReattCapEr()
    {
        return ParamUtils.nullSafeValue(reattCapEr);
    }

    public void setReattIndAss(Long valore)
    {
        reattIndAss = ParamUtils.nullSafeValue(valore);
    }

    public Long getReattIndAss()
    {
        return ParamUtils.nullSafeValue(reattIndAss);
    }

    public void setReattIndEr(Long valore)
    {
        reattIndEr = ParamUtils.nullSafeValue(valore);
    }

    public Long getReattIndEr()
    {
        return ParamUtils.nullSafeValue(reattIndAss);
    }
}
