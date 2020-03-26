package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class LenntConcentratoreDTO implements Serializable {


	private static final long serialVersionUID = -1L;
	String codConcentratore;
    String matricolaLenntCliente;
    Date dataAssoc;
    SimpleDateFormat sdf;

    public LenntConcentratoreDTO() {
        sdf = new SimpleDateFormat("yyyyMMdd");
    }

    public LenntConcentratoreDTO(LenntConcentratore lc) throws ParseException {
        sdf = new SimpleDateFormat("yyyyMMdd");
        setCodConcentratore(lc.getCodConcentratore());
        setMatricolaLenntCliente(lc.getMatricolaLenntCliente());
        setDataAssoc(sdf.format(lc.getDataAssoc()));
    }

    public static void setLenntConcentratore(LenntConcentratore lc, LenntConcentratoreDTO lcd) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        lc.setDataAssoc(sdf.parse(lcd.getDataAssoc()));
    }

    public String toString() {
        return new String("{matr. LENNT: " + matricolaLenntCliente + ", concentratore: " + codConcentratore + ", data assoc.: " + dataAssoc + "}");
    }

    public void setCodConcentratore(String value) {
        codConcentratore = ParamUtils.nullSafeValue(value);
    }

    public void checkCodConcentratore() throws Exception {
        ParamChecker.checkCodConcentratore(codConcentratore);
    }

    public String getCodConcentratore() {
        return ParamUtils.nullSafeValue(codConcentratore);
    }

    public void setMatricolaLenntCliente(String value) {
        matricolaLenntCliente = ParamUtils.nullSafeValue(value);
    }

    public void checkMatricolaLenntCliente() throws Exception {
        ParamChecker.checkMatricolaLenntCliente(matricolaLenntCliente);
    }

    public String getMatricolaLenntCliente() {
        return ParamUtils.nullSafeValue(matricolaLenntCliente);
    }

    public void setDataAssoc(String yyyyMMdd) throws ParseException {
        dataAssoc = sdf.parse(yyyyMMdd);
    }

    public String getDataAssoc() {
        return new String(sdf.format(dataAssoc));
    }

    public void check() throws Exception {
        checkCodConcentratore();
        checkMatricolaLenntCliente();
    }
}