package com.ericsson.mgre.biz.networkMgmt;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBObject;

import com.ericsson.mgre.biz.networkMgmt.business.LenntClienteSearchCriteriaBO;
import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.exceptions.DataAccessException;
import com.ericsson.urm.exceptions.URMBusinessException;

public interface TopologiaFacade extends EJBObject {

    public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO[] getAceaLinkByLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO[] getLenntClienteDTOByGruppoApplicativo(String codGruppoApplicativo)  throws javax.ejb.FinderException, Exception;
    public String[] getAvailableAceaLink() throws RemoteException, Exception;
    public String[] getAvailableConcentratore() throws RemoteException, Exception;
    public String[] getAvailableLenntCliente() throws RemoteException, Exception;
    public String[] getAvailableLenntClienteForCabinaSecondaria() throws RemoteException, Exception;
    public String[] getAvailableLenntTrasformatore() throws RemoteException, Exception;
    public String[] getConcentratoreByCabinaSecondaria(String codCabinaSecondaria)     throws RemoteException, javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratoreByLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratoreByLenntTrasformatore(String matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.LenntConcentratoreDTO[] getConcentratoreLenntHistory(String matricolaLenntCliente)  throws Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.config.DensitaDTO getDensitaByLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteConcentratorePairs() throws RemoteException, Exception;

  public String[] getMatricolaALByLenntCliente(String matricolaLenntCliente) throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteByCabinaSecondaria(String codCabinaSecondaria) throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteByConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteByGruppoApplicativo(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteRipetitoreRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteRipetitoreIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntClienteIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getStatoLenntClienteRipetitoreRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getStatoLenntClienteRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getStatoLenntClienteRipetitoreIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getStatoLenntClienteIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getFaseLenntClienteRipetitoreRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getFaseLenntClienteRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getFaseLenntClienteRipetitoreIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getFaseLenntClienteIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getUltimoContattoLenntClienteRipetitoreRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getUltimoContattoLenntClienteRgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getUltimoContattoLenntClienteRipetitoreIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getUltimoContattoLenntClienteIrgByConcentratore(String codGruppoApplicativo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public java.util.HashMap getLenntClienteMapByConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.LenntConcentratoreDTO[] getLenntConcentratoreHistory(String matricolaLenntCliente)     throws RemoteException, Exception;

  public String[] getLenntTrasformatoreByConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public java.util.HashMap getLenntTrasformatoreMapByConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.config.ZonaDTO getZonaByLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeCabinaSecondariaConcentratoreAssoc(String codCabinaSecondaria, String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeCabinaSecondariaLenntClientAssoc(String codCabinaSecondaria, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeCabinaSecondariaLenntClienteAssoc(String codCabinaSecondaria, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeConcentratoreLenntClientAssoc(String codConcentratore, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeConcentratoreLenntTrasformatoreAssoc(String codConcentratore, String matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeLenntClienteAceaLinkAssoc(String matricolaLenntCliente, String matricolaAL)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setCabinaSecondariaConcentratoreAssoc(String codCabinaSecondaria, String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setCabinaSecondariaLenntClienteAssoc(String codCabinaSecondaria, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setConcentratoreLenntClientAssoc(String codConcentratore, String[] matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setConcentratoreLenntClientAssoc(String codConcentratore, String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setConcentratoreLenntTrasformatoreAssoc(String codConcentratore, String matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setLenntClienteAceaLinkAssoc(String matricolaLenntCliente, String matricolaAL)     throws RemoteException, javax.ejb.FinderException, URMBusinessException;
  
  public void setMeterAceaLinkAssociation(String matricolaLenntCliente, String matricolaAL) throws RemoteException, URMBusinessException;
  
  // modifica R01
  public void setCCSProperties(String ccsCode) throws RemoteException, URMBusinessException;
  public void setCCSLennt(String ccs, String lennt, Date data) throws RemoteException ;
  public void setLenntCliente(String ccs, String lennt, Date data) throws RemoteException;
  public List searchLenntClienteByCriteria(LenntClienteSearchCriteriaBO criteria) throws RemoteException, URMBusinessException;
  public long countLenntCliente(LenntClienteSearchCriteriaBO criteria) throws RemoteException, URMBusinessException;
  public void updateLenntCliente(List lenntList) throws RemoteException, URMBusinessException;
  public com.ericsson.urm.persistence.dto.mgre.LenntCliente getLenntClienteById(String matricolaLennt) throws RemoteException, URMBusinessException;
  public com.ericsson.urm.persistence.dto.mgre.Tc getCcsById(String codConcentratore) throws RemoteException, URMBusinessException;
  public List searchCcsByIdArray(String[] selectedItems) throws RemoteException, URMBusinessException;
  public long countCcs(String[] selectedItems) throws RemoteException, URMBusinessException;
  public void updateTc(List ccsList) throws RemoteException, URMBusinessException;
  
  public void saveLenntCliente(String ccs, String lennt, Date data) throws URMBusinessException, ConfigurationException, DataAccessException, RemoteException;
  public void saveLenntConcentratore(String ccs, String lennt, Date data) throws URMBusinessException, RemoteException;

  public Long getLenntSottesiDaStatusWord(String codConcentratore) throws URMBusinessException, RemoteException;
  public List<String> getAllDistinctTypeInstallUff()throws URMBusinessException, RemoteException;
}
