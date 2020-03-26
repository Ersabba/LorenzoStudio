package com.ericsson.mgre.biz.countersMgmt.load;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.biz.countersMgmt.utils.ParamUtils;

public class CaricoTrasformatoreDTO implements Serializable {

    Long codTrasformatore;
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
        return new String("{cod. trasformatore: " + codTrasformatore + ", periodo acquisizione: " + periodoAcquisizione + ", data: " + dataCurva.toString() + ", periodo integrazione: " + periodoIntegrazione + ", AA: " + attAss + ", AE: " + attEr + ", RCA: " + reattCapAss + ", RCE: " + reattCapEr + ", RIA: " + reattIndAss + ", RIE: " + reattIndEr + "}");
    }

    public CaricoTrasformatoreDTO() { }

    public CaricoTrasformatoreDTO(CaricoTrasformatore ct)
    {
        setCodTrasformatore(ct.getCodTrasformatore());
        setDataCurva(ct.getDataCurva());
        setNumPeriodo(ct.getNumPeriodo());
        setPeriodoAcquisizione(ct.getPeriodoAcquisizione());
        setPeriodoIntegrazione(ct.getPeriodoIntegrazione());
        setAttAss(ct.getAttAss());
        setAttEr(ct.getAttEr());
        setReattCapAss(ct.getReattCapAss());
        setReattCapEr(ct.getReattCapEr());
        setReattIndAss(ct.getReattIndAss());
        setReattIndEr(ct.getReattIndEr());
    }

    public static void setCaricoTrasformatore(CaricoTrasformatore ct, CaricoTrasformatoreDTO ctd)
    {
        ct.setPeriodoAcquisizione(ctd.getPeriodoAcquisizione());
        ct.setPeriodoIntegrazione(ctd.getPeriodoIntegrazione());
        ct.setAttAss(ctd.getAttAss());
        ct.setAttEr(ctd.getAttEr());
        ct.setReattCapAss(ctd.getReattCapAss());
        ct.setReattCapEr(ctd.getReattCapEr());
        ct.setReattIndAss(ctd.getReattIndAss());
        ct.setReattIndEr(ctd.getReattIndEr());
    }

    public static Long sum(Long first, Long second)  {
        if(first == null && second == null)
            return null;
        if(first == null)
            first = new Long(0L);
        if(second == null)
            second = new Long(0L);
        return new Long(first.longValue() + second.longValue());
    }

    public void setCodTrasformatore(Long valore)
    {
        codTrasformatore = ParamUtils.nullSafeValue(valore);
    }

    public Long getCodTrasformatore()
    {
        return ParamUtils.nullSafeValue(codTrasformatore);
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