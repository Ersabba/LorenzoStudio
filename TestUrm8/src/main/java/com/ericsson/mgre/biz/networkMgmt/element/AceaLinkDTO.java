package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class AceaLinkDTO implements Serializable {

    String matricolaAL;
    String matricolaLenntCliente;
    String annoFabbrAL;
    String costruttoreAL;
    String numProgrAL;
    String tipoApparatoAL;
    Integer indirizzoAL;

    public AceaLinkDTO() { }

    public AceaLinkDTO(AceaLink al)
    {
        setMatricolaAL(al.getMatricolaAL());
        setIndirizzoAL(al.getIndirizzoAL());
        setMatricolaLenntCliente(al.getMatricolaLenntCliente());
        setAnnoFabbrAL(al.getAnnoFabbrAL());
        setCostruttoreAL(al.getCostruttoreAL());
        setNumProgrAL(al.getNumProgrAL());
        setTipoApparatoAL(al.getTipoApparatoAL());
    }

    public static void setAceaLink(AceaLink al, AceaLinkDTO ald)
    {
        al.setIndirizzoAL(ald.getIndirizzoAL());
        al.setMatricolaLenntCliente(ald.getMatricolaLenntCliente());
        al.setAnnoFabbrAL(ald.getAnnoFabbrAL());
        al.setCostruttoreAL(ald.getCostruttoreAL());
        al.setNumProgrAL(ald.getNumProgrAL());
        al.setTipoApparatoAL(ald.getTipoApparatoAL());
    }

    public String toString()
    {
        return new String("{matricola: " + matricolaAL + ", matr. LENNT: " + matricolaLenntCliente + ", indirizzo: " + indirizzoAL + ", costruttore: " + costruttoreAL + ", anno fabbr.: " + annoFabbrAL + ", progr.: " + numProgrAL + ", tipo: " + tipoApparatoAL + "}");
    }

    public void setMatricolaAL(String value)
    {
        matricolaAL = ParamUtils.nullSafeValue(value);
    }

    public void checkMatricolaAL()
        throws Exception
    {
        ParamChecker.checkMatricolaAL(matricolaAL);
        setCostruttoreAL(matricolaAL.substring(0, 2));
        setTipoApparatoAL(matricolaAL.substring(2, 4));
        setAnnoFabbrAL(matricolaAL.substring(4, 6));
        setNumProgrAL(matricolaAL.substring(6));
    }

    public void setMatricolaLenntCliente(String value)
    {
        matricolaLenntCliente = ParamUtils.nullSafeValue(value);
    }

    public void setIndirizzoAL(Integer value)
    {
        indirizzoAL = ParamUtils.nullSafeValue(value);
    }

    public void setCostruttoreAL(String value)
    {
        costruttoreAL = ParamUtils.nullSafeValue(value);
    }

    public void setAnnoFabbrAL(String value)
    {
        annoFabbrAL = ParamUtils.nullSafeValue(value);
    }

    public void setNumProgrAL(String value)
    {
        numProgrAL = ParamUtils.nullSafeValue(value);
    }

    public void setTipoApparatoAL(String value)
    {
        tipoApparatoAL = ParamUtils.nullSafeValue(value);
    }

    public String getMatricolaAL()
    {
        return ParamUtils.nullSafeValue(matricolaAL);
    }

    public String getMatricolaLenntCliente()
    {
        return ParamUtils.nullSafeValue(matricolaLenntCliente);
    }

    public Integer getIndirizzoAL()
    {
        return ParamUtils.nullSafeValue(indirizzoAL);
    }

    public String getCostruttoreAL()
    {
        return ParamUtils.nullSafeValue(costruttoreAL);
    }

    public String getAnnoFabbrAL()
    {
        return ParamUtils.nullSafeValue(annoFabbrAL);
    }

    public String getNumProgrAL()
    {
        return ParamUtils.nullSafeValue(numProgrAL);
    }

    public String getTipoApparatoAL()
    {
        return ParamUtils.nullSafeValue(tipoApparatoAL);
    }

    public void check() throws Exception {
        checkMatricolaAL();
    }
}
