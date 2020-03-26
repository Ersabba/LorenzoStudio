package com.ericsson.mgre.biz.networkMgmt;

import javax.ejb.EJBLocalObject;


public interface ConfigurazioniFacadeLocal extends EJBLocalObject {
  public com.ericsson.mgre.biz.networkMgmt.element.config.DensitaDTO[] getAllDensita()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.FasciaTariffariaDTO[] getAllFasciaTariffaria()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.TipoUtenteDTO[] getAllTipoUtente()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.TipologiaInstallazioneDTO[] getAllTipologiaInstallazione()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.ZonaDTO[] getAllZona()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.DensitaDTO getDensita(String codDensita)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.FasciaTariffariaDTO getFasciaTariffaria(String codFascia)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.TipoUtenteDTO getTipoUtente(String codTiput)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.TipologiaInstallazioneDTO getTipologiaInstallazione(String codTipmodin)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.networkMgmt.element.config.ZonaDTO getZona(String codZona)  throws javax.ejb.FinderException, Exception;
}
