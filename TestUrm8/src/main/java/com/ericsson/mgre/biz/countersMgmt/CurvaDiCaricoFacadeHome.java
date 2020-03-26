package com.ericsson.mgre.biz.countersMgmt;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface CurvaDiCaricoFacadeHome extends EJBHome {
  public CurvaDiCaricoFacade create()     throws CreateException, RemoteException;

}
