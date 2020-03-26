package com.ericsson.mgre.biz.networkMgmt;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

import com.ericsson.mgre.biz.networkMgmt.element.DataProvisioningDTO;
import com.ericsson.mgre.biz.networkMgmt.element.LenntCliente;
import com.ericsson.mgre.biz.networkMgmt.utils.TipoRichLettureCurve;
import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfig;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoConfigShort;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoOperazioni;
import com.ericsson.urm.persistence.dto.mgre.CurvaCaricoStatisticheOperazioni;
import com.ericsson.urm.persistence.dto.mgre.IpGateway;
import com.ericsson.urm.persistence.dto.mgre.UtenzeCM;
import com.ericsson.urm.persistence.dto.mgre.datatype.EnabledEnergyComponents;


public interface ReteFacadeLocal extends EJBLocalObject {
  public void createAceaLink(com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO ald)  throws javax.ejb.CreateException, URMBusinessException;
  public void createCabinaSecondaria(com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO csd)  throws javax.ejb.CreateException, Exception;
  public void createConcentratore(com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO cd)  throws javax.ejb.CreateException, Exception;
  public void createLenntCliente(com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO lcd)  throws javax.ejb.CreateException, Exception;
  public void createLenntTrasformatore(com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO ltd)  throws javax.ejb.CreateException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO getAceaLink(String matricolaAL)  throws javax.ejb.FinderException, URMBusinessException;
  public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO[] getAllAceaLink()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO[] getAllCabinaSecondaria()  throws javax.ejb.FinderException, Exception;
  public String[] getAllConcentratore()  throws Exception;
  public String[] getAllConcentratoreAsc()  throws Exception;
  public String[] getAllConcentratoreWithFileNew()  throws javax.ejb.FinderException, Exception;
  public String[] getAllConcentratoreWithFileTut()  throws javax.ejb.FinderException, Exception;
  public String[] getCodConcentratoreForNetworkWideActivitiesWithFileTut() throws javax.ejb.FinderException, Exception;
  public String[] getCodConcentratoreForNetworkWideActivitiesWithFileNew() throws javax.ejb.FinderException, Exception;
  public String[] getAllLenntCliente()  throws Exception;
  public String[] getAllLenntTrasformatore()  throws Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO getCabinaSecondaria(String codCabinaSecondaria)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO getLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public LenntCliente getLenntClienteBean(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public LenntCliente[] getLenntClienteBeanByCodConcentratoreAndCodTiputt(String codConcentratore, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO[] getLenntClienteByNumeroUtenza(String numeroUtenza)  throws javax.ejb.FinderException, Exception;
  public String[] getLenntNonRaggiungibili()  throws javax.ejb.FinderException, Exception;
  public String[] getCodConcentratoreForNetworkWideActivities()  throws javax.ejb.FinderException, Exception;
  public List     getCodConcentratoreForNetworkWideActivitiesAsList();
  
  public String[] getCodConcentratoreForMonthlyBestEffort(Date dateDetection) throws FinderException, Exception;
  public String[] getCodConcentratoreForMaxPowerMeasure(Date dateDetection, boolean isMonthly) throws Exception;
  public String[] getLenntTipoAlimentazioneEmergenza()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO getLenntTrasformatore(String matricolaLennt)  throws javax.ejb.FinderException, Exception;
  public String getLenntType(String matricolaLennt)  throws Exception;
  public void removeAceaLink(String matricolaAL)  throws javax.ejb.FinderException, Exception;
  public void removeCabinaSecondaria(String codCabinaSecondaria)  throws javax.ejb.FinderException, Exception;
  public void removeConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
  public void removeLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public void removeLenntTrasformatore(String matricolaLennt)  throws javax.ejb.FinderException, Exception;

  /**
   * /**
   */
  public void resetLenntRaggiungibili()  throws javax.ejb.FinderException, Exception;
  public void resetLenntRipetitore()  throws javax.ejb.FinderException, Exception;
  public void setAceaLink(com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO ald)  throws javax.ejb.CreateException, Exception;
  public void setCabinaSecondaria(com.ericsson.mgre.biz.networkMgmt.element.CabinaSecondariaDTO csd)  throws javax.ejb.CreateException, Exception;
  public void setConcentratore(com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO cd)  throws javax.ejb.CreateException, Exception;
  public void setLenntCliente(com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO lcd)  throws javax.ejb.CreateException, Exception;
  public void setLenntTrasformatore(com.ericsson.mgre.biz.networkMgmt.element.LenntTrasformatoreDTO ltd)  throws javax.ejb.CreateException, Exception;
  public void setPeriodoCurvaDiCarico(String lennt, String periodo) throws javax.ejb.CreateException, Exception;
  public void insertOrUpdateCurvaCaricoConfig(CurvaCaricoConfig ccc) throws javax.ejb.CreateException, URMBusinessException;
  public void deleteCurvaCaricoConfig(String matricolaLennt) throws javax.ejb.CreateException, Exception;
  public void gestisciAbilitazioneCurveCaricoConfig(String matricolaLennt, TipoRichLettureCurve richiesta, boolean rispostaOk, String periodoCurve, boolean... flagMonitorTecnico) throws javax.ejb.CreateException, Exception;
  public CurvaCaricoConfig getCurvaCaricoConfig(String lennt) throws javax.ejb.CreateException, Exception;
  public EnabledEnergyComponents getEnabledComponents() throws Exception;
  
  // Aggiunte RL 20/01/2009
  
  public int countLennt() throws Exception;
  
  public int countCcs() throws Exception;
  
  public com.ericsson.urm.persistence.dto.mgre.Concentratore getConcentratoreById(String matr);
  
  public void updateConcentratore(com.ericsson.urm.persistence.dto.mgre.Concentratore ccs);
  
  public void saveOrUpdateLoadCurveOperation(CurvaCaricoOperazioni dto) throws URMBusinessException;
  
  public List<CurvaCaricoOperazioni> getCurveCaricoOperazioniByDataAcq(Date dataAcq) throws URMBusinessException;
  
  public CurvaCaricoStatisticheOperazioni getCurvaCaricoStatisticheOperazioni(Date d) throws URMBusinessException;
  
  public com.ericsson.urm.persistence.dto.mgre.LenntCliente getLenntClienteById(String matricolaLennt) throws URMBusinessException;

  public IpGateway getIpGatewayById(String gatewayCode) throws URMBusinessException;
  
  public List<CurvaCaricoConfigShort> getConfigurazioneLenntAbilitati(String matricolaLike, List<String> matricole) throws URMBusinessException;
  
  public void updateCurvaCaricoConfigShort(CurvaCaricoConfigShort cccShort) throws URMBusinessException;
  
  public void updateIpGateway(IpGateway ipGateway) throws URMBusinessException;
  
  public void updateTableMetersFault(String meterId) throws URMBusinessException;

  //Caricamento anagrafica lennts componenti multiple (Utenze_cm)
  public void saveUtenzaCM(UtenzeCM utenza) throws URMBusinessException;
  public void truncateUtenzeCM() throws URMBusinessException;
  
  
  //Caricamento file abilitazione lennts curve di carico config
  public void saveOrUpdateCurvaCaricoConfig(CurvaCaricoConfig cdc) throws URMBusinessException;
  
  public String getCodToponomasticoByCodPos(String codPos) throws URMBusinessException;
  
  public void truncateDataProvisioning() throws URMBusinessException;
  public boolean saveDataProvisioning(DataProvisioningDTO dataProvisioning) throws URMBusinessException;
  public void rimuoviCCSByRadiusUserAndMatricola(String radiusUser, String matricolaApparatoAttivo) throws URMBusinessException;
}
