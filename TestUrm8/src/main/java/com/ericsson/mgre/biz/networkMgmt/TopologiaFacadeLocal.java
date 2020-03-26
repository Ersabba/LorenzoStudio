package com.ericsson.mgre.biz.networkMgmt;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBLocalObject;

import com.ericsson.mgre.biz.networkMgmt.business.LenntClienteSearchCriteriaBO;
import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.exceptions.DataAccessException;
import com.ericsson.urm.exceptions.URMBusinessException;


public interface TopologiaFacadeLocal extends EJBLocalObject {
    public com.ericsson.mgre.biz.networkMgmt.element.AceaLinkDTO[] getAceaLinkByLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.LenntClienteDTO[] getLenntClienteDTOByGruppoApplicativo(String codGruppoApplicativo)  throws javax.ejb.FinderException, Exception;
    public String[] getAvailableAceaLink() throws Exception;
    public String[] getAvailableConcentratore() throws Exception;
    public String[] getAvailableLenntCliente() throws Exception;
    public String[] getAvailableLenntClienteForCabinaSecondaria() throws Exception;
    public String[] getAvailableLenntTrasformatore() throws Exception;
    public String[] getConcentratoreByCabinaSecondaria(String codCabinaSecondaria)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratoreByLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.ConcentratoreDTO getConcentratoreByLenntTrasformatore(String matricolaLennt)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.LenntConcentratoreDTO[] getConcentratoreLenntHistory(String matricolaLenntCliente)  throws Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.config.DensitaDTO getDensitaByLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteConcentratorePairs()  throws javax.ejb.FinderException, Exception;
    public String[] getMatricolaALByLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteByCabinaSecondaria(String codCabinaSecondaria)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteByGruppoApplicativo(String codGruppoApplicativo)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteRipetitoreRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteRipetitoreIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getLenntClienteIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getStatoLenntClienteRipetitoreRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getStatoLenntClienteRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getStatoLenntClienteRipetitoreIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getStatoLenntClienteIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getFaseLenntClienteRipetitoreRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getFaseLenntClienteRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getFaseLenntClienteRipetitoreIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getFaseLenntClienteIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getUltimoContattoLenntClienteRipetitoreRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getUltimoContattoLenntClienteRgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getUltimoContattoLenntClienteRipetitoreIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public String[] getUltimoContattoLenntClienteIrgByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public java.util.HashMap getLenntClienteMapByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.LenntConcentratoreDTO[] getLenntConcentratoreHistory(String matricolaLenntCliente)  throws Exception;
    public String[] getLenntTrasformatoreByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public java.util.HashMap getLenntTrasformatoreMapByConcentratore(String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public com.ericsson.mgre.biz.networkMgmt.element.config.ZonaDTO getZonaByLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void removeCabinaSecondariaConcentratoreAssoc(String codCabinaSecondaria, String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public void removeCabinaSecondariaLenntClientAssoc(String codCabinaSecondaria, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void removeCabinaSecondariaLenntClienteAssoc(String codCabinaSecondaria, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void removeConcentratoreLenntClientAssoc(String codConcentratore, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void removeConcentratoreLenntTrasformatoreAssoc(String codConcentratore, String matricolaLennt)  throws javax.ejb.FinderException, Exception;
    public void removeLenntClienteAceaLinkAssoc(String matricolaLenntCliente, String matricolaAL)  throws javax.ejb.FinderException, Exception;
    public void setCabinaSecondariaConcentratoreAssoc(String codCabinaSecondaria, String codConcentratore)  throws javax.ejb.FinderException, Exception;
    public void setCabinaSecondariaLenntClienteAssoc(String codCabinaSecondaria, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void setConcentratoreLenntClientAssoc(String codConcentratore, String[] matricolaLennt)  throws javax.ejb.FinderException, Exception;
    public void setConcentratoreLenntClientAssoc(String codConcentratore, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
    public void setConcentratoreLenntTrasformatoreAssoc(String codConcentratore, String matricolaLennt)  throws javax.ejb.FinderException, Exception;
    public void setLenntClienteAceaLinkAssoc(String matricolaLenntCliente, String matricolaAL)  throws javax.ejb.FinderException, URMBusinessException;
    public void setMeterAceaLinkAssociation(String matricolaLenntCliente, String matricolaAL) throws URMBusinessException;
    //  Modifica R01
    public void setCCSProperties(String ccsCode) throws URMBusinessException;
    public void setCCSLennt(String ccs, String lennt, Date data);
    public void setLenntCliente(String ccs, String lennt, Date data);
    public List searchLenntClienteByCriteria(LenntClienteSearchCriteriaBO criteria) throws URMBusinessException;
    public long countLenntCliente(LenntClienteSearchCriteriaBO criteria) throws URMBusinessException;
    public void updateLenntCliente(List lenntList) throws URMBusinessException;
    public com.ericsson.urm.persistence.dto.mgre.LenntCliente getLenntClienteById(String matricolaLennt) throws URMBusinessException;
    public com.ericsson.urm.persistence.dto.mgre.Tc getCcsById(String codConcentratore) throws URMBusinessException;
    public List searchCcsByIdArray(String[] selectedItems) throws URMBusinessException;
    public long countCcs(String[] selectedItems) throws URMBusinessException;
    public void updateTc(List ccsList) throws URMBusinessException;
    
    public void saveLenntCliente(String ccs, String lennt, Date data) throws URMBusinessException, ConfigurationException, DataAccessException;
    public void saveLenntConcentratore(String ccs, String lennt, Date data) throws URMBusinessException;

    public Long getLenntSottesiDaStatusWord(String codConcentratore) throws URMBusinessException;
    public List<String> getAllDistinctTypeInstallUff()throws URMBusinessException;
}
