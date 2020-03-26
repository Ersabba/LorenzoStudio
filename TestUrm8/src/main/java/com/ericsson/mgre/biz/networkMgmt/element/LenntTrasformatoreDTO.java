package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class LenntTrasformatoreDTO implements Serializable {

    String matricolaLennt;
    String codConcentratore;
    String statoLennt;
    String raggiungLennt;
    Long codSbarraBt;
    Date ultimoContatto;

    public LenntTrasformatoreDTO() { }

    public LenntTrasformatoreDTO(LenntTrasformatore lt)
    {
        setMatricolaLennt(lt.getMatricolaLennt());
        setCodConcentratore(lt.getCodConcentratore());
        setStatoLennt(lt.getStatoLennt());
        setRaggiungLennt(lt.getRaggiungLennt());
        setCodSbarraBt(lt.getCodSbarraBt());
        setUltimoContatto(lt.getUltimoContatto());
    }

    public static void setLenntTrasformatore(LenntTrasformatore lt, LenntTrasformatoreDTO ltd)
    {
        lt.setStatoLennt(ltd.getStatoLennt());
        lt.setCodConcentratore(ltd.getCodConcentratore());
        lt.setCodSbarraBt(ltd.getCodSbarraBt());
        lt.setUltimoContatto(ltd.getUltimoContatto());
    }

    public String toString()
    {
        return new String("{matricola: " + matricolaLennt + ", concentratore: " + codConcentratore + ", trasformatore: " + codSbarraBt + ", stato: " + statoLennt + ", ultimo contatto: " + ultimoContatto + "}");
    }

    public void setMatricolaLennt(String value)
    {
        matricolaLennt = ParamUtils.nullSafeValue(value);
    }

    public void checkMatricolaLennt()
        throws Exception
    {
        ParamChecker.checkMatricolaLennt(matricolaLennt);
    }

    public String getMatricolaLennt()
    {
        return ParamUtils.nullSafeValue(matricolaLennt);
    }

    public void setCodConcentratore(String value)
    {
        codConcentratore = ParamUtils.nullSafeValue(value);
    }

    public String getCodConcentratore()
    {
        return ParamUtils.nullSafeValue(codConcentratore);
    }

    public void setCodSbarraBt(Long value)
    {
        codSbarraBt = ParamUtils.nullSafeValue(value);
    }

    public Long getCodSbarraBt()
    {
        return ParamUtils.nullSafeValue(codSbarraBt);
    }

    public void setStatoLennt(String value)
    {
        statoLennt = ParamUtils.nullSafeValue(value);
    }

    public String getStatoLennt()
    {
        return ParamUtils.nullSafeValue(statoLennt);
    }

    public void setRaggiungLennt(String value)
    {
        raggiungLennt = ParamUtils.nullSafeValue(value);
    }

    public String getRaggiungLennt()
    {
        return ParamUtils.nullSafeValue(raggiungLennt);
    }

    public void setUltimoContatto(Date value)
    {
        ultimoContatto = ParamUtils.nullSafeValue(value);
    }

    public Date getUltimoContatto()
    {
        return ParamUtils.nullSafeValue(ultimoContatto);
    }

    public void check() throws Exception {
        checkMatricolaLennt();
    }
}
