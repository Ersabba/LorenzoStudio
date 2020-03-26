package com.ericsson.mgre.biz.networkMgmt.element;

import java.rmi.RemoteException;
import java.util.Date;

import javax.ejb.EJBObject;

/**
 * CSSSincr bean remote interface.
 */

public interface CCSSincr extends EJBObject{
	
	public String getMtrCcs()throws RemoteException;
	public String getIpCcs()throws RemoteException;
	public Date   getDataSincr() throws RemoteException;
	public String getRelease() throws RemoteException;
	public String getMarcaOraria() throws RemoteException;
	
	public void setMtrCcs(String mtrcss) throws RemoteException; 
	public void setIpCcs(String ip) throws RemoteException;
	public void setDataSincr(Date data) throws RemoteException;
	public void setRelease(String release) throws RemoteException;
	public void setMarcaOraria(String marcaOraria) throws RemoteException;

}