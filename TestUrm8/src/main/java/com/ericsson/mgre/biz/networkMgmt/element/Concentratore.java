package com.ericsson.mgre.biz.networkMgmt.element;

import java.util.Date;

import javax.ejb.EJBLocalObject;

public interface Concentratore extends EJBLocalObject {
    public String getAccessPwd() ;
    public String getAccessUser() ;
    public String getCodCabinaSecondaria() ;
    public String getCodConcentratore() ;
    public String getCodPadre() ;
    public Long getCodTrasformatore() ;
    public String getFtprPwd() ;
    public String getFtprUser() ;
    public String getFtpwPwd() ;
    public String getFtpwUser() ;
    public String getImsiModem() ;
    public String getIpVpn() ;
    public String getNumTelModem() ;
    public String getPstnModem() ;
    public String getStatoConcentratore() ;
    public String getStatoGuasto() ;
    public String getTipoModem() ;
    public Object getFileNew() ;
    public Object getFileTut() ;
    public Date getUltimoContattoAdd() ;
    public String getModelloModem() ;
    public String getCostruttoreModem() ;
    public Date getDataVariazioneDatiModem() ;

    public void setAccessPwd(String val) ;
    public void setAccessUser(String val) ;
    public void setCodCabinaSecondaria(String val) ;
    public void setCodConcentratore(String val) ;
    public void setCodPadre(String val) ;
    public void setCodTrasformatore(Long val) ;
    public void setFtprPwd(String val) ;
    public void setFtprUser(String val) ;
    public void setFtpwPwd(String val) ;
    public void setFtpwUser(String val) ;
    public void setImsiModem(String val) ;
    public void setIpVpn(String val) ;
    public void setNumTelModem(String val) ;
    public void setPstnModem(String val) ;
    public void setStatoConcentratore(String val) ;
    public void setStatoGuasto(String val) ;
    public void setTipoModem(String val);
    public void setFileNew(Object val) ;
    public void setFileTut(Object val) ;
    public void setUltimoContattoAdd(Date val) ;
    public void setModelloModem(String val) ;
    public void setCostruttoreModem(String val) ;
    public void setDataVariazioneDatiModem(Date val) ;

}
