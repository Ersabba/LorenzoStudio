package com.ericsson.mgre.biz.networkMgmt.element;

import javax.ejb.EJBLocalObject;

public interface PnPElement extends EJBLocalObject {

    public String getCcs();
    public String getLennt();
    public String getDataPnP();
    public String getStat();
    public String getCcsPre();
    public String getStatCcsPre();
    public String getFase();
    public void setCcs(String ccs);
    public void setLennt(String lennt);
    public void setDataPnP(String data);
    public void setStat(String stat);
    public void setCcsPre(String val);
    public void setStatCcsPre(String val);
    public void setFase(String val);
}
