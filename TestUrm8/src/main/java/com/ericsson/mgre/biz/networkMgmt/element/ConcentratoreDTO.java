package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

import com.ericsson.mgre.biz.networkMgmt.utils.ParamChecker;
import com.ericsson.mgre.biz.networkMgmt.utils.ParamUtils;

public class ConcentratoreDTO implements Serializable {

	private static final long serialVersionUID = -1L;
	
	String codConcentratore;
    String codCabinaSecondaria;
    String codPadre;
    String statoConcentratore;
    String accessUser;
    String accessPwd;
    String ftprUser;
    String ftprPwd;
    String ftpwUser;
    String ftpwPwd;
    String tipoModem;
    String imsiModem;
    String ipVpn;
    String numTelModem;
    String pstnModem;
    String statoGuasto;
    Long codTrasformatore;
    Object fileNew;
    Object fileTut;

    public ConcentratoreDTO(){ }

    public ConcentratoreDTO(Concentratore c) {
        setAccessPwd(c.getAccessPwd());
        setAccessUser(c.getAccessUser());
        setCodCabinaSecondaria(c.getCodCabinaSecondaria());
        setCodConcentratore(c.getCodConcentratore());
        setCodPadre(c.getCodPadre());
        setCodTrasformatore(c.getCodTrasformatore());
        setFtprPwd(c.getFtprPwd());
        setFtprUser(c.getFtprUser());
        setFtpwPwd(c.getFtpwPwd());
        setFtpwUser(c.getFtpwUser());
        setImsiModem(c.getImsiModem());
        setIpVpn(c.getIpVpn());
        setNumTelModem(c.getNumTelModem());
        setPstnModem(c.getPstnModem());
        setStatoConcentratore(c.getStatoConcentratore());
        setTipoModem(c.getTipoModem());
        setStatoGuasto(c.getStatoGuasto());
        setFileNew(c.getFileNew());
        setFileTut(c.getFileTut());
    }

    public static void setConcentratore(Concentratore c, ConcentratoreDTO cd)  {
        c.setAccessPwd(cd.getAccessPwd());
        c.setAccessUser(cd.getAccessUser());
        c.setCodCabinaSecondaria(cd.getCodCabinaSecondaria());
        c.setCodPadre(cd.getCodPadre());
        c.setCodTrasformatore(cd.getCodTrasformatore());
        c.setFtprPwd(cd.getFtprPwd());
        c.setFtprUser(cd.getFtprUser());
        c.setFtpwPwd(cd.getFtpwPwd());
        c.setFtpwUser(cd.getFtpwUser());
        c.setImsiModem(cd.getImsiModem());
        c.setIpVpn(cd.getIpVpn());
        c.setNumTelModem(cd.getNumTelModem());
        c.setPstnModem(cd.getPstnModem());
        c.setStatoConcentratore(cd.getStatoConcentratore());
        c.setTipoModem(cd.getTipoModem());
        c.setStatoGuasto(cd.getStatoGuasto());
        c.setFileNew(cd.getFileNew());
        c.setFileTut(cd.getFileTut());
    }

    public String toString() {
        return new String("{concentratore: " + codConcentratore + ", cabina sec.: " + codCabinaSecondaria + ", conc. padre: " + codPadre + ", stato: " + statoConcentratore + ", access user: " + accessUser + ", access pwd: " + accessPwd + ", FTP read user: " + ftprUser + ", FTP read pwd: " + ftprPwd + ", FTP write user: " + ftpwUser + ", FTP write pwd: " + ftpwPwd + ", tipo modem: " + tipoModem + ", IMSI modem: " + imsiModem + ", IP addr.: " + ipVpn + ", num. tel. modem: " + numTelModem + ", matr. PSTN modem: " + pstnModem + ", stato guasto: " + statoGuasto + ", trasformatore: " + codTrasformatore + "}");
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

    public void setCodCabinaSecondaria(String value) {
        codCabinaSecondaria = ParamUtils.nullSafeValue(value);
    }

    public String getCodCabinaSecondaria() {
        return ParamUtils.nullSafeValue(codCabinaSecondaria);
    }

    public void setCodPadre(String value) {
        codPadre = ParamUtils.nullSafeValue(value);
    }

    public String getCodPadre() {
        return ParamUtils.nullSafeValue(codPadre);
    }

    public void setStatoConcentratore(String value) {
        statoConcentratore = ParamUtils.nullSafeValue(value);
    }

    public String getStatoConcentratore() {
        return ParamUtils.nullSafeValue(statoConcentratore);
    }

    public void setAccessUser(String value) {
        accessUser = ParamUtils.nullSafeValue(value);
    }

    public String getAccessUser() {
        return ParamUtils.nullSafeValue(accessUser);
    }

    public void setAccessPwd(String value) {
        accessPwd = ParamUtils.nullSafeValue(value);
    }

    public String getAccessPwd() {
        return ParamUtils.nullSafeValue(accessPwd);
    }

    public void setFtprUser(String value) {
        ftprUser = ParamUtils.nullSafeValue(value);
    }

    public String getFtprUser() {
        return ParamUtils.nullSafeValue(ftprUser);
    }

    public void setFtprPwd(String value) {
        ftprPwd = ParamUtils.nullSafeValue(value);
    }

    public String getFtprPwd() {
        return ParamUtils.nullSafeValue(ftprPwd);
    }

    public void setFtpwUser(String value) {
        ftpwUser = ParamUtils.nullSafeValue(value);
    }

    public String getFtpwUser() {
        return ParamUtils.nullSafeValue(ftpwUser);
    }

    public void setFtpwPwd(String value) {
        ftpwPwd = ParamUtils.nullSafeValue(value);
    }

    public String getFtpwPwd() {
        return ParamUtils.nullSafeValue(ftpwPwd);
    }

    public void setTipoModem(String value) {
        tipoModem = ParamUtils.nullSafeValue(value);
    }

    public String getTipoModem() {
        return ParamUtils.nullSafeValue(tipoModem);
    }

    public void setImsiModem(String value) {
        imsiModem = ParamUtils.nullSafeValue(value);
    }

    public String getImsiModem() {
        return ParamUtils.nullSafeValue(imsiModem);
    }

    public void setIpVpn(String value) {
        ipVpn = ParamUtils.nullSafeValue(value);
    }

    public String getIpVpn() {
        return ParamUtils.nullSafeValue(ipVpn);
    }

    public void setNumTelModem(String value) {
        numTelModem = ParamUtils.nullSafeValue(value);
    }

    public String getNumTelModem() {
        return ParamUtils.nullSafeValue(numTelModem);
    }

    public void setPstnModem(String value) {
        pstnModem = ParamUtils.nullSafeValue(value);
    }

    public String getPstnModem() {
        return ParamUtils.nullSafeValue(pstnModem);
    }

    public void setStatoGuasto(String value) {
        statoGuasto = ParamUtils.nullSafeValue(value);
    }

    public String getStatoGuasto() {
        return ParamUtils.nullSafeValue(statoGuasto);
    }

    public void setCodTrasformatore(Long value) {
        codTrasformatore = ParamUtils.nullSafeValue(value);
    }

    public Long getCodTrasformatore() {
        return ParamUtils.nullSafeValue(codTrasformatore);
    }

    public void setFileNew(Object value) {
        fileNew = value;
    }

    public Object getFileNew() {
        return fileNew;
    }

    public void setFileTut(Object value) {
        fileTut = value;
    }

    public Object getFileTut() {
        return fileTut;
    }

    public void check() throws Exception {
        checkCodConcentratore();
    }

}
