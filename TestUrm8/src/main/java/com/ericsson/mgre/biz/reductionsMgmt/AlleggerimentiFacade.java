package com.ericsson.mgre.biz.reductionsMgmt;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface AlleggerimentiFacade extends EJBObject {
  public void createConfigAlleggProgr(com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] capd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void eseguiAlleggEmergGruppoApplicativo(Long coeffLimitazione, String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void eseguiAlleggEmergLenntCliente(Long coeffLimitazione, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void eseguiAlleggProgrGruppoApplicativo(String codConfigAll, String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void eseguiAlleggProgrLenntCliente(String codConfigAll, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getAllCodConfigAll()     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggEmergDTO[] getAllConfigAlleggEmerg()     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO[] getAllGruppoApplicativo()     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getConcentratoreByGruppoApplicativo(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] getConfigAlleggProgr(String codConfigAll)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO getGruppoApplicativo(String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO getGruppoApplicativo(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;
  
  public void removeConfigAllegProgr(String codConfigAll)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setConfigAlleggProgr(com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] capd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setGruppoApplicativo(com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO gad)     throws RemoteException, javax.ejb.CreateException, javax.ejb.FinderException, Exception;

  public void setPianoAlleggerimentoGruppoApplicativoAssoc(String codConfigAll, String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setPianoAlleggerimentoLenntClienteAssoc(String codConfigAll, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void sospendiAlleggEmergGruppoApplicativo(String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void sospendiAlleggEmergLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void sospendiAlleggProgrGruppoApplicativo(String codConfigAll, String codCabinaSecondaria, String codTiputt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void sospendiAlleggProgrLenntCliente(String codConfigAll, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

}
