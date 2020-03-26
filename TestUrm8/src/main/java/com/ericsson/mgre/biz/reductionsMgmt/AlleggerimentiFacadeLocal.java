package com.ericsson.mgre.biz.reductionsMgmt;

import javax.ejb.EJBLocalObject;

import com.ericsson.mgre.biz.networkMgmt.element.LenntCliente;
import com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativo;

public interface AlleggerimentiFacadeLocal extends EJBLocalObject {
  public void createConfigAlleggProgr(com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] capd)  throws javax.ejb.CreateException, Exception;
  public void eseguiAlleggEmergGruppoApplicativo(Long coeffLimitazione, String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void eseguiAlleggEmergLenntCliente(Long coeffLimitazione, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public void eseguiAlleggProgrGruppoApplicativo(String codConfigAll, String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void eseguiAlleggProgrLenntCliente(String codConfigAll, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public String[] getAllCodConfigAll()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggEmergDTO[] getAllConfigAlleggEmerg()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO[] getAllGruppoApplicativo()  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO getGruppoApplicativo(String codGruppoApplicativo)     throws javax.ejb.FinderException, Exception;
  // modifica per gestione degli alleggerimenti
  public String[] getConcentratoreByGruppoApplicativo(String codGruppoApplicativo)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] getConfigAlleggProgr(String codConfigAll)  throws javax.ejb.FinderException, Exception;
  public com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO getGruppoApplicativo(String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void removeConfigAllegProgr(String codConfigAll)  throws javax.ejb.FinderException, Exception;
  public void setConfigAlleggProgr(com.ericsson.mgre.biz.reductionsMgmt.reductions.ConfigAlleggProgrDTO[] capd)  throws javax.ejb.CreateException, Exception;
  public void setGruppoApplicativo(com.ericsson.mgre.biz.reductionsMgmt.reductions.GruppoApplicativoDTO gad)  throws javax.ejb.CreateException, javax.ejb.FinderException, Exception;
  public void setLenntClienteGruppoApplicativoAssoc(LenntCliente lc, GruppoApplicativo ga)  throws javax.ejb.CreateException, javax.ejb.FinderException, Exception;
  public void setPianoAlleggerimentoGruppoApplicativoAssoc(String codConfigAll, String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void setPianoAlleggerimentoLenntClienteAssoc(String codConfigAll, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public void sospendiAlleggEmergGruppoApplicativo(String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void sospendiAlleggEmergLenntCliente(String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
  public void sospendiAlleggProgrGruppoApplicativo(String codConfigAll, String codCabinaSecondaria, String codTiputt)  throws javax.ejb.FinderException, Exception;
  public void sospendiAlleggProgrLenntCliente(String codConfigAll, String matricolaLenntCliente)  throws javax.ejb.FinderException, Exception;
}
