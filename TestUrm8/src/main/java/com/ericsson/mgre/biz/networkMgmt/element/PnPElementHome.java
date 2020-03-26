package com.ericsson.mgre.biz.networkMgmt.element;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface PnPElementHome extends EJBLocalHome {
    public PnPElement findByCCS_Lennt(String CCS, String Lennt) throws FinderException;
    public Collection findByCCS(String CCS) throws FinderException;
    public Collection findByCCS_Pre(String CCS) throws FinderException;
    public PnPElement findByPrimaryKey(PnPElementBeanPK element) throws FinderException;
    public PnPElement create(String mtrCCS, String mtrLennt, String date, String stat, String ccs_pre, String stat_pre, String fase) throws CreateException;

}
