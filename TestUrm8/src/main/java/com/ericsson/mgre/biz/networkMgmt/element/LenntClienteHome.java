package com.ericsson.mgre.biz.networkMgmt.element;


/*
  ** This file was automatically generated by EJBGen 2.15 beta - Workshop 8.1
  ** Build: 20030408-0944
*/

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface LenntClienteHome extends EJBLocalHome {
  public Collection findAll()     throws FinderException;
  public Collection findAvailable()     throws FinderException;
  public Collection findAvailableForCabinaSecondaria()     throws FinderException;
  public Collection findAvailableForLineaBt()     throws FinderException;
  public Collection findByCodCabinaSecondaria(String codCabinaSecondaria)     throws FinderException;
  public Collection findByCodConcentratore(String codConcentratore)     throws FinderException;
  public Collection findByCodConcentratoreAndCodTiputt(String codConcentratore, String codTiputt)     throws FinderException;
  public Collection findByCodConfigAll(String codConfigAll)     throws FinderException;
  public Collection findByCodGruppoApplicativo(String codGruppoApplicativo)     throws FinderException;
  public Collection findByCodLineaBt(Long codLineaBt)     throws FinderException;
  public Collection findByCodSezione(Long codSezione)     throws FinderException;
  public Collection findByCodTipmodin(String codTipmodin)     throws FinderException;
  public Collection findByCoeffLimitazione(Long coeffLimitazione)     throws FinderException;
  public Collection findByNumeroUtenza(String nnumeroUtenza)     throws FinderException;
  public LenntCliente findByPrimaryKey(String primaryKey)     throws FinderException;
  public Collection findByRaggiungLennt(String raggiungLennt)     throws FinderException;
  public Collection findByTipoAlimentazione(String tipoAlimentazione)     throws FinderException;
  public LenntCliente create(String matricolaLenntCliente)     throws CreateException;
  public String[] getByRaggiungLennt(String raggiungLennt)  throws javax.ejb.FinderException;
  public String[] getByTipoAlimentazione(String tipoAlimentazione)  throws javax.ejb.FinderException;
}