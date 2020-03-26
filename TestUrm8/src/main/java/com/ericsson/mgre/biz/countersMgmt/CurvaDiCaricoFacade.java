package com.ericsson.mgre.biz.countersMgmt;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.ejb.EJBObject;

import com.ericsson.mgre.datatypes.CdcStatisticsData;
import com.ericsson.mgre.datatypes.OneShotExpRec;
import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.dto.mgre.datatype.LoadCurvesCcsState;
import com.ericsson.urm.persistence.dto.mgre.datatype.LoadProgressionData;

/**
 * 
 *
 */
public interface CurvaDiCaricoFacade extends EJBObject {
  public com.ericsson.mgre.biz.countersMgmt.load.CaricoTrasformatoreDTO[] getCaricoTrasformatoreByTrasformatoreAndData(Long codTrasformatore, Date dataCurva)     throws RemoteException, javax.ejb.FinderException, Exception;

  public java.util.HashMap getCaricoTrasformatoreMapByTrasformatoreAndData(Long codTrasformatore, Date dataCurva)     throws RemoteException, javax.ejb.FinderException, Exception;

  public com.ericsson.mgre.biz.countersMgmt.load.CurvaDiCaricoDTO getCurvaDiCarico(String lennt, Date data, Long numPeriodo)     throws RemoteException, javax.ejb.FinderException, Exception;

  public void setCaricoTrasformatore(com.ericsson.mgre.biz.countersMgmt.load.CaricoTrasformatoreDTO counter)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCarico(com.ericsson.mgre.biz.countersMgmt.load.CurvaDiCaricoDTO counter)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoAttAss(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long attAss)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoAttEr(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long attEr)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoReattCapAss(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long reattCapAss)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoReattCapEr(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long reattCapEr)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoReattIndAss(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long reattIndAss)     throws RemoteException, javax.ejb.CreateException, Exception;

  public void setCurvaDiCaricoReattIndEr(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long reattIndEr)     throws RemoteException, javax.ejb.CreateException, Exception;
  
  public void setCurvaDiCaricoForLenntCom(Date dataCurva, String matricolaLennt, Long numPeriodo, String periodoAcquisizione, Long periodoIntegrazione, Long value, String type) throws RemoteException, javax.ejb.CreateException, Exception;
  
  public LoadCurvesCcsState setLoadCurves(LoadCurvesCcsState loadCurvesCcsState, List ccsLoadProgressionData, AtomicLong recordsStored) throws URMBusinessException,RemoteException;
  
  public com.ericsson.urm.persistence.dto.mgre.CurvaDiCarico[] getLoadProgressionByDateAcqOrdered(Date dataAcq) throws URMBusinessException,RemoteException;
  
  public long setCurvaDiCarico(LoadProgressionData loadProgressionData) throws URMBusinessException,RemoteException;
  public Set<CdcStatisticsData> loadStatisticheCurve(Date referenceDate, int dayligthCorrente, int dayligthPrecedente) throws URMBusinessException, RemoteException;
}
