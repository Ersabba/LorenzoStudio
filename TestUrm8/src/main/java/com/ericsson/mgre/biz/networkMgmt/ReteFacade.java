package com.ericsson.mgre.biz.networkMgmt;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBObject;
import javax.ejb.FinderException;

import com.ericsson.mgre.biz.networkMgmt.element.DataProvisioningDTO;
import com.ericsson.mgre.biz.networkMgmt.utils.TipoRichLettureCurve;
import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfig;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfigShort;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoOperazioni;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoStatisticheOperazioni;
import com.ericsson.urm.persistence.dto.mgre.IpGateway;
import com.ericsson.urm.persistence.dto.mgre.UtenzeCM;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnabledEnergyComponents;

public interface ReteFacade extends EJBObject {
  public void createAceaLink(com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO ald)     throws RemoteException, javax.ejb.CreateException, URMBusinessException;

  public void createCabinaSecondaria(com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO csd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void createConcentratore(com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO cd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void createLenntCliente(com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO lcd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void createLenntTrasformatore(com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO ltd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO getAceaLink(String matricolaAL)     throws RemoteException, javax.ejb.FinderException, URMBusinessException;

  public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO[] getAllAceaLink()     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO[] getAllCabinaSecondaria()     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getAllConcentratore()     throws RemoteException, Exception;
  public String[] getAllConcentratoreAsc()     throws RemoteException, Exception;
  public String[] getAllConcentratoreWithFileNew()     throws RemoteException, javax.ejb.FinderException, Exception;
  public String[] getAllConcentratoreWithFileTut()     throws RemoteException, javax.ejb.FinderException, Exception;
  
  public String[] getCodConcentratoreForMonthlyBestEffort(Date dateDetection) throws FinderException, RemoteException, Exception;
  
  public String[] getCodConcentratoreForMaxPowerMeasure(Date dateDetection, boolean isMonthly) throws Exception;
  
  public String[] getCodConcentratoreForNetworkWideActivities() throws RemoteException, javax.ejb.FinderException, Exception;
  public String[] getCodConcentratoreForNetworkWideActivitiesWithFileTut() throws RemoteException, javax.ejb.FinderException, Exception;
  public String[] getCodConcentratoreForNetworkWideActivitiesWithFileNew() throws RemoteException, javax.ejb.FinderException, Exception;
  
  public List     getCodConcentratoreForNetworkWideActivitiesAsList() throws RemoteException;
  
  public String[] getAllLenntCliente()     throws RemoteException, Exception;

  public String[] getAllLenntTrasformatore()     throws RemoteException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO getCabinaSecondaria(String codCabinaSecondaria)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO getLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO[] getLenntClienteByNumeroUtenza(String numeroUtenza)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntNonRaggiungibili()     throws RemoteException, javax.ejb.FinderException, Exception;

  public String[] getLenntTipoAlimentazioneEmergenza()     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO getLenntTrasformatore(String matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;

  public String getLenntType(String matricolaLennt)     throws RemoteException, Exception;

  public void removeAceaLink(String matricolaAL)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeCabinaSecondaria(String codCabinaSecondaria)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeConcentratore(String codConcentratore)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeLenntCliente(String matricolaLenntCliente)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void removeLenntTrasformatore(String matricolaLennt)     throws RemoteException, javax.ejb.FinderException, Exception;


  /**
   * /**
   */
  public void resetLenntRaggiungibili()     throws RemoteException, javax.ejb.FinderException, Exception;

  public void resetLenntRipetitore()     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setAceaLink(com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO ald)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCabinaSecondaria(com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO csd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setConcentratore(com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO cd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setLenntCliente(com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO lcd)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setLenntTrasformatore(com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO ltd)     throws RemoteException, javax.ejb.CreateException, Exception;
  
  public void setPeriodoCurvaDiCarico(String lennt, String periodo) throws RemoteException, javax.ejb.CreateException, Exception;
  
  public void insertOrUpdateCurvaCaricoConfig(CurvaCaricoConfig ccc) throws RemoteException, javax.ejb.CreateException, URMBusinessException;
  
  public void deleteCurvaCaricoConfig(String matricolaLennt) throws RemoteException, javax.ejb.CreateException, Exception;
  
  //implementazione delle regole da 2 a 7 della CR "Acquisizione puntuale campioni mancanti"
  public void gestisciAbilitazioneCurveCaricoConfig(String matricolaLennt, TipoRichLettureCurve richiesta, boolean rispostaOk, String periodoCurve, boolean... flagMonitorTecnico) throws RemoteException, javax.ejb.CreateException, Exception;
  
  public CurvaCaricoConfig getCurvaCaricoConfig(String lennt) throws RemoteException, javax.ejb.CreateException, Exception;
  
  public EnabledEnergyComponents getEnabledComponents() throws RemoteException, Exception;
  
  // Aggiunte RL 20/01/2009
  
  public int countLennt() throws RemoteException;
  
  public int countCcs() throws RemoteException;
  
  public List getCcsList() throws RemoteException;
  
  public com.ericsson.urm.persistence.dto.mgre.Concentratore getConcentratoreById(String matr) throws RemoteException;
  
  public void updateConcentratore(com.ericsson.urm.persistence.dto.mgre.Concentratore ccs) throws RemoteException;

  public void saveOrUpdateLoadCurveOperation(CurvaCaricoOperazioni dto) throws RemoteException, URMBusinessException;
  
  public List<CurvaCaricoOperazioni> getCurveCaricoOperazioniByDataAcq(Date dataAcq) throws RemoteException, URMBusinessException;

  public CurvaCaricoStatisticheOperazioni getCurvaCaricoStatisticheOperazioni(Date d) throws RemoteException, URMBusinessException;
  
  public com.ericsson.urm.persistence.dto.mgre.LenntCliente getLenntClienteById(String matricolaLennt) throws RemoteException,URMBusinessException;
  
  public IpGateway getIpGatewayById(String gatewayCode) throws RemoteException, URMBusinessException;
  
  public List<CurvaCaricoConfigShort> getConfigurazioneLenntAbilitati(String matricolaLike, List<String> matricole) throws RemoteException, URMBusinessException;
  
  public void updateCurvaCaricoConfigShort(CurvaCaricoConfigShort cccShort) throws RemoteException, URMBusinessException;
  
  public void updateIpGateway(IpGateway ipGateway) throws RemoteException, URMBusinessException;
  
  public void updateTableMetersFault(String meterId) throws RemoteException, URMBusinessException;


  //Caricamento anagrafica lennts componenti multiple (Utenze_cm)
  public void saveUtenzaCM(UtenzeCM utenza) throws RemoteException, URMBusinessException;
  public void truncateUtenzeCM() throws RemoteException, URMBusinessException;
  
//Caricamento file abilitazione lennts curve di carico config  
  public void saveOrUpdateCurvaCaricoConfig(CurvaCaricoConfig cdc) throws RemoteException, URMBusinessException;
  
  public String getCodToponomasticoByCodPos(String codPos) throws URMBusinessException, RemoteException;
  
  public void truncateDataProvisioning() throws RemoteException, URMBusinessException;
  public boolean saveDataProvisioning(DataProvisioningDTO dataProvisioning) throws RemoteException, URMBusinessException;
  public void rimuoviCCSByRadiusUserAndMatricola(String radiusUser, String matricolaApparatoAttivo) throws URMBusinessException, RemoteException;
}
