package com.ericsson.urm.persistence.dao.mgre;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ericsson.communication.responsetype.ReadResetLenntsListResponseType.ResetResult;
import com.ericsson.mgre.biz.networkMgmt.business.LenntClienteSearchCriteriaBO;
import com.ericsson.mgre.db.dto.ResetStatusWordLennt;
import com.ericsson.urm.core.enumeration.LenntTypeCode;
import com.ericsson.urm.device.driver.DeviceProtocol;
import com.ericsson.urm.persistence.dto.mgre.LenntType;
import com.ericsson.urm.persistence.dto.mgre.datatype.InstantDailyReadingsLennt;
import com.ericsson.urm.persistence.dto.mgre.datatype.LenntStatusWordDto;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.ericsson.urm.persistence.Hibernate;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.LenntCliente;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LenntClienteDAO extends GenericDAO {
	

	
	private static Logger logger = Logger.getLogger(LenntClienteDAO.class);
	
	private static String QUERY_MATRICOLE_BY_CONCENTRATORE = "select a.matricolaLenntCliente from LenntCliente a where a.codConcentratore=:codConcentratore order by a.matricolaLenntCliente";
	
	private static String QUERY_BY_DATAFASE = "from LenntCliente a where a.dataFase>=:beginDate and a.dataFase<=:endDate";

	private static String QUERY_FASE_BY_MATRICOLA = "select a.fase from LenntCliente a where a.matricolaLenntCliente =:matricolaCliente";
	
	private static String NATIVE_QUERY_ALL_LENNTCLIENTE = "select a.* from lennt_cliente a ";
	private static String NATIVE_QUERY_COUNT_LENNTCLIENTE = "select count(*) as c from lennt_cliente a ";
	
	public LenntClienteDAO(HibernateSessionManagement sm) {
		super(sm);
	}

	public LenntCliente getById(String matricolaLennt) {
		ArgumentsCheckerUtil.checkNull(matricolaLennt, "matricolaLennt");
		return (LenntCliente) getSession().get(LenntCliente.class, matricolaLennt);
	}

	public void save(LenntCliente obj) {
		ArgumentsCheckerUtil.checkNull(obj, "lenntCliente");
		getSession().save(obj);
	}
	
	public void update(LenntCliente obj) {
		ArgumentsCheckerUtil.checkNull(obj, "lenntCliente");
		getSession().update(obj);
	}

	public void saveOrUpdate(LenntCliente obj) {
		ArgumentsCheckerUtil.checkNull(obj, "lenntCliente");
		getSession().saveOrUpdate(obj);
	}

	public void delete(LenntCliente obj) {
		ArgumentsCheckerUtil.checkNull(obj, "lenntCliente");
		getSession().delete(obj);
	}
	
	public String getFaseByMatricola(String matricolaCliente) {
		ArgumentsCheckerUtil.checkNull(matricolaCliente, "matricolaCliente");
		Query qry = getSession().createQuery(QUERY_FASE_BY_MATRICOLA);
		
		qry.setString("matricolaCliente", matricolaCliente);
		String ret = (String)qry.uniqueResult();
		
		return ret==null?"":ret;
	}

	public String[] getMatricoleByConcentratore(String codConcentratore) {
		ArgumentsCheckerUtil.checkNull(codConcentratore, "codConcentratore");
		Query qry = getSession().createQuery(QUERY_MATRICOLE_BY_CONCENTRATORE);

		qry.setString("codConcentratore", codConcentratore);
		List list = qry.list();
		String[] ret = null;
		if (list != null && list.size() > 0) {
			ret = new String[list.size()];
			ret = (String[]) list.toArray(ret);
		} else {
			ret = new String[0];
		}

		return ret;

	}
	
	public LenntCliente[] getByDatePhaseInterval(Date beginDate, Date endDate) {
		ArgumentsCheckerUtil.checkNull(beginDate, "beginDate");
		ArgumentsCheckerUtil.checkNull(endDate, "endDate");
		Query qry = getSession().createQuery(QUERY_BY_DATAFASE);
		qry.setDate("beginDate", beginDate);
		qry.setDate("endDate", endDate);
		List list = qry.list();
		LenntCliente[] ret = null;
		if (list != null && list.size() > 0) {
			ret = new LenntCliente[list.size()];
			ret = (LenntCliente[]) list.toArray(ret);
		} else {
			ret = new LenntCliente[0];
		}

		return ret;
	}
	
	public List findLenntClienteByCriteria(LenntClienteSearchCriteriaBO criteria){
		
		SQLQuery qry = getSession().createSQLQuery(buildQueryAllByCriteria(criteria,false));
		
		qry.addEntity("a", LenntCliente.class);
		
		return qry.list();
		
	}
	
	
	public long countLenntCliente(LenntClienteSearchCriteriaBO criteria) {
		
		SQLQuery qry = getSession().createSQLQuery(buildQueryAllByCriteria(criteria,true));
		
		qry.addScalar("c", Hibernate.LONG);
		
		Long res  = (Long)qry.uniqueResult();	
		
		return res!=null?res.longValue():0;
	}
	
	private String buildQueryAllByCriteria(LenntClienteSearchCriteriaBO criteria, boolean isForCount){
		
		StringBuffer sb = new StringBuffer();
		
		if(isForCount){			
			sb.append("select count(*) as c from ( ");			
		}
		
		sb.append(NATIVE_QUERY_ALL_LENNTCLIENTE);
		
		if(criteria!=null){
			sb.append(" where ");
			if((criteria.getCodConcentratore()!=null && criteria.getCodConcentratore().length()>0) && (criteria.getMatricolaLenntCliente()!=null && criteria.getMatricolaLenntCliente().length>0)){
				sb.append(" a.cod_concentratore = '"+criteria.getCodConcentratore()+"'");
				sb.append(" and ( ");
				for(int i=0;i<criteria.getMatricolaLenntCliente().length;i++){
					sb.append(" a.matricola_lennt_cliente = '"+criteria.getMatricolaLenntCliente()[i]+"'");
					if(i<criteria.getMatricolaLenntCliente().length-1)
						sb.append(" or ");
				}
				sb.append(" ) ");
			}else if(criteria.getCodConcentratore()!=null && criteria.getCodConcentratore().length()>0){
				sb.append(" a.cod_concentratore = '"+criteria.getCodConcentratore()+"'");
			}else{
				for(int i=0;i<criteria.getMatricolaLenntCliente().length;i++){
					sb.append(" a.matricola_lennt_cliente = '"+criteria.getMatricolaLenntCliente()[i]+"'");
					if(i<criteria.getMatricolaLenntCliente().length-1)
						sb.append(" or ");
				}				
			}
		}
		
		if(isForCount){			
			sb.append(" ) ");			
		}
		
		return sb.toString();
		
	}
	
	public List<LenntCliente> getByProtocol(DeviceProtocol protocol) {
		ArgumentsCheckerUtil.checkNull(protocol, "protocol");
		
		Criteria crit = getSession().createCriteria(LenntCliente.class);
		crit.createAlias("tipo", "t").add(Restrictions.eq("t.protocol", protocol.toString()));
		
		return crit.list();
	}
	
	
	public List<String> getLenntsByTypeCode(LenntTypeCode tipo) {
		Criteria crit = getSession().createCriteria(LenntCliente.class);
		crit.createAlias("tipo", "t").add(Restrictions.eq("t.internalCode", tipo.getDbCode())).setProjection(Property.forName("matricolaLenntCliente"));
		List<Object> ret = crit.list();
		List<String> res = new ArrayList<String>();
		for (Object o : ret)
			res.add((String)o);
		return res;
	}
	
	public List<String> getLenntsByTypeCodeAndValidIP(List<String> tipoList) {
		ArgumentsCheckerUtil.checkNull(tipoList, "tipoList");
		StringBuffer sb = new StringBuffer();
		
		sb = new StringBuffer();
		sb.append("select lc.matricolaLenntCliente ");
		sb.append("from LenntCliente lc, IpGateway ipG ");
		sb.append("where (lc.codConcentratore = ipG.id ");
		sb.append(" or lc.matricolaLenntCliente = ipG.id) ");
	
		if(tipoList!=null && tipoList.size()>0) {
			sb.append(" and (");
			for(int j=0;j<tipoList.size();++j) {
				if(j>0) {
					sb.append(" or ");
				}
				sb.append(" lc.tipo.internalCode ='"+tipoList.get(j)+"'");
			}
			sb.append(" ) ");
		}	
		sb.append("and ipG.ipAddress is not null");
		
		Query qry = getSession().createQuery(sb.toString());
		
		return qry.list();
	}
	
	public Map<String,Set<String>> getMetersByTypeCodeAndValidIP(List<String> tipoList) {
		StringBuffer sb = new StringBuffer();
		
		Map<String,Set<String>> metersGroups = new HashMap<String, Set<String>>();
		
		sb = new StringBuffer();
		sb.append("select lc.codConcentratore, lc.matricolaLenntCliente ");
		sb.append("from LenntCliente lc, IpGateway ipG ");
		sb.append("where (lc.codConcentratore = ipG.id ");
		sb.append(" or lc.matricolaLenntCliente = ipG.id) ");
	
		if(tipoList!=null && tipoList.size()>0) {
			sb.append(" and (");
			for(int j=0;j<tipoList.size();++j) {
				if(j>0) {
					sb.append(" or ");
				}
				sb.append(" lc.tipo.internalCode ='"+tipoList.get(j)+"'");
			}
			sb.append(" ) ");
		}	
		sb.append(" and ipG.ipAddress is not null ");
		sb.append(" order by lc.codConcentratore, lc.matricolaLenntCliente");
		
		Query qry = getSession().createQuery(sb.toString());
		List<Object[]> qryResults = qry.list();
		
		String idCCS = null;
		String idMeter = null;
		Set<String> meters = null;
		for(Object[] r : qryResults) {
			if(r != null && r.length>1) {
				idMeter = (String)r[1];
				if(idMeter!=null) {
					idCCS = r[0]!=null ? (String)r[0] : "";
					meters = metersGroups.get(idCCS);
					if(meters == null) {
						meters = new LinkedHashSet<String>();
					}
					meters.add(idMeter);
					metersGroups.put(idCCS, meters);
				}
			}
		}
		
		return metersGroups;
	}
	
	
	public List<String> findTaskByCodeAndStatus(Set<LenntTypeCode> tipoList) {
		ArgumentsCheckerUtil.checkNull(tipoList, "tipoList");
		   
	    Set<String> tipi = new HashSet<String>();
	    for (LenntTypeCode LenntTypeCode : tipoList) {
	    	tipi.add(tipoList.toString());
		} 	   
	    
	    Criteria crit = getSession().createCriteria(LenntType.class);
	    if(tipoList != null && !tipoList.isEmpty()) {
	     crit.add(Restrictions.in("internalCode", tipi));
	    }
	    
	    crit.setProjection(Property.forName("lenntTypeId"));
	    
	    List<Object> ret = crit.list();
		List<String> res = new ArrayList<String>();
		for (Object o : ret)
			res.add((String)o);
		return res;
	}
	
	public List<String> getSpecialLenntIds() {
		Criteria crit = getSession().createCriteria(LenntCliente.class);
		crit.add(Restrictions.eq("utenzaSpeciale", '1')).setProjection(Property.forName("matricolaLenntCliente"));
		List<Object> ret = crit.list();
		HashSet<String> res = new HashSet<String>();
		for (Object o : ret)
			res.add((String)o);
		return new ArrayList<String>(res);
	}
	
	
	public Map<String,Set<LenntStatusWordDto>> getLenntsWithAntitamperOnAndValidIP( String commaSeparatedListaMeters) {
		//CR18
		//estrae i lennt raggiungibili e che abbiano il 13° bit (antitamper) a 1 nella parola di stato
		logger.debug("commaSeparatedListaMeters:" + commaSeparatedListaMeters);
		
		StringBuffer sb = new StringBuffer();
		
		Map<String,Set<LenntStatusWordDto>> metersGroups = new HashMap<String, Set<LenntStatusWordDto>>();
		
		sb = new StringBuffer();
		
		sb.append("select COD_CONCENTRATORE, MATRICOLA_LENNT_CLIENTE, IP_ADDRESS, ANTITAMPER, LAST_DATA_RESET  from table(FExtractLenntToBeResetted(")
		  .append((commaSeparatedListaMeters==null? null : "'"+commaSeparatedListaMeters+"'")).append("))");  
		
		if(commaSeparatedListaMeters!=null){
			logger.debug("GAP estrazione lennt da resettare: " + sb.toString());
		}else{
			logger.debug("URM estrazione lennt da resettare: " + sb.toString());
		}
		
		SQLQuery qry = getSession().createSQLQuery(sb.toString());
		qry.addScalar("COD_CONCENTRATORE", Hibernate.STRING);
		qry.addScalar("MATRICOLA_LENNT_CLIENTE", Hibernate.STRING);
		qry.addScalar("IP_ADDRESS", Hibernate.STRING);
		qry.addScalar("ANTITAMPER", Hibernate.INTEGER);
		qry.addScalar("LAST_DATA_RESET", Hibernate.DATE);
		qry.setResultTransformer(Transformers.aliasToBean(ResetStatusWordLennt.class));
		String idCCS = null;
		String idMeter = null;
		String ipAddress = null;
		int antitamper = -1;
		Date lastDataReset = null;
		Set<LenntStatusWordDto> meters = null;
		List<ResetStatusWordLennt> qryResults = null;
		
		qryResults = qry.list();
			
		if(qryResults!=null){
			for(ResetStatusWordLennt r : qryResults) {
				if(r != null) {
					idMeter = r.getMATRICOLA_LENNT_CLIENTE();
					if(idMeter!=null) {
						idCCS = (r.getCOD_CONCENTRATORE()!=null ? r.getCOD_CONCENTRATORE() : "");
						meters = metersGroups.get(idCCS);
						ipAddress = r.getIP_ADDRESS();
						antitamper = r.getANTITAMPER();
						lastDataReset = r.getLAST_DATA_RESET();
						if(meters == null) {
							meters = new LinkedHashSet<LenntStatusWordDto>();
						}
						LenntStatusWordDto stato = new LenntStatusWordDto();
						stato.matricola = idMeter;
						stato.lastDateReset = lastDataReset;
						stato.stato = ResetResult.SUCCESS;
						if(ipAddress==null || ipAddress.isEmpty()){
							stato.stato= ResetResult.UNREACHABLE;
						}else{
							if(antitamper==-1){
								stato.stato=ResetResult.MISSING_STATUS_WORD;
							}else if(antitamper==0){
								stato.stato=ResetResult.ANTI_TAMPER_OFF;
							}
						}
						meters.add(stato);
						metersGroups.put(idCCS, meters);
					}
				}
			}
		}
		return metersGroups;
	}
	

	public Map<String,Set<LenntStatusWordDto>> getGatewayCodeByLenntId(String matricola){
		//CR18
			//estrae il gateway code del  lennt da resettare nel caso di reset di lennt singolo!
			//restituisce una mappa con un solo elemento (fatto così perchè al chiamante serve così)
				logger.debug("matricola lennt:" + matricola);
				
				StringBuffer sb = new StringBuffer();
				
				Map<String,Set<LenntStatusWordDto>> metersGroups = new HashMap<String, Set<LenntStatusWordDto>>();
				
				sb = new StringBuffer();
				
				
				sb.append("select lc.cod_concentratore as COD_CONCENTRATORE, lc.matricola_lennt_cliente as MATRICOLA_LENNT_CLIENTE,ipg.ip_address IP_ADDRESS, '-1' as ANTITAMPER, trunc(sysdate) as LAST_DATA_RESET  ");
				sb.append("  from  gre_lennt_cliente lc,  gre_ip_gateway ipg, gre_lennt_type lt   ");
				sb.append(" where lc.matricola_lennt_cliente=:matricola AND  lc.tipo = lt.lennt_type_id and (ipg.gateway_code = lc.cod_concentratore and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   ");
				sb.append(" OR  ipg.gateway_code = lc.matricola_lennt_cliente and lt.protocol<>'LANDIS_BT_CCS_MEDIATED')  ");
			
				logger.debug("GAP estrazione singolo lennt da resettare: " + sb.toString());
				
				
				SQLQuery qry = getSession().createSQLQuery(sb.toString());
				qry.addScalar("COD_CONCENTRATORE", Hibernate.STRING);
				qry.addScalar("MATRICOLA_LENNT_CLIENTE", Hibernate.STRING);
				qry.addScalar("IP_ADDRESS", Hibernate.STRING);
				qry.addScalar("ANTITAMPER", Hibernate.INTEGER);
				qry.addScalar("LAST_DATA_RESET", Hibernate.DATE);
				qry.setString("matricola", matricola);
				qry.setResultTransformer(Transformers.aliasToBean(ResetStatusWordLennt.class));
				String idCCS = null;
				String idMeter = null;
				String ipAddress = null;
				Date lastDateReset = null;
				Set<LenntStatusWordDto> meters = null;
				List<ResetStatusWordLennt> qryResults = null;

				qryResults = qry.list();
					
				if(qryResults!=null){
					for(ResetStatusWordLennt r : qryResults) {
						if(r != null) {
							idMeter = r.getMATRICOLA_LENNT_CLIENTE();
							lastDateReset = r.getLAST_DATA_RESET();
							if(idMeter!=null) {
								idCCS = (r.getCOD_CONCENTRATORE()!=null ? r.getCOD_CONCENTRATORE() : "");
								meters = metersGroups.get(idCCS);
								ipAddress = r.getIP_ADDRESS();
								if(meters == null) {
									meters = new LinkedHashSet<LenntStatusWordDto>();
								}
								LenntStatusWordDto stato = new LenntStatusWordDto();
								stato.matricola = idMeter;
								stato.stato = ResetResult.SUCCESS;
								if(ipAddress==null || ipAddress.isEmpty()){
									stato.stato=ResetResult.UNREACHABLE;
								}
								stato.lastDateReset=lastDateReset;
								meters.add(stato);
								metersGroups.put(idCCS, meters);
							}
						}
					}
				}
				return metersGroups;
	}
	
	
	/* CR034 
	 * 
	 */
	public Map<String,Map<String, String>> getGatewayCodeAndLenntIdForDailyInstantPunctualReadings(long gAnag, long gVet, long nMaxLennt, boolean useAlternativeCcs){

			//estrae tutti i lennt raggiungibili tramite CCS per i quali non esistono letture in gre_tot_atta_ass prima di sysdate - gVet 
		   // e che risultavano nel file address del concentratore dopo la data sysdate - gAnag 
		   //restituisce una mappa con chiava il CCS e value un set di lennt sottesi a quel ccs
		  // NOTA : sono esclusi i lennt diretti perchè non vengono presi tramite file g.eea e non stanno nel file address
				


				
				StringBuffer sb = new StringBuffer("select rownum, matricolaLennt, ccs, ccsEnum from (  select * from (");
				Map<String,Map<String, String>> metersCCsMap = new HashMap<String, Map<String, String>>();
								
				sb.append(" SELECT lc.matricola_lennt_cliente as matricolaLennt, lc.cod_concentratore as ccs , 'CCS0' as ccsEnum,  ");
				sb.append(" 		 decode(lc.last_punctual_failure, null, '19900101', to_char(lc.last_punctual_failure, 'YYYYMMDD')) as ultimoFallimento ");
				sb.append(" 						                   FROM gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id "); 
				sb.append(" 					                      WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
				sb.append(" 					                        AND lc.cod_concentratore is not null  and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
				sb.append(" 				                            AND not exists (select 1 from gre_tot_att_ass tot    ");
				sb.append(" 					                                         where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
				sb.append(" 				                            AND exists (select 1 from gre_ip_gateway ip    ");
				sb.append(" 				                                         where ip.ip_address is not null    ");
				sb.append(" 				                                           and ip.gateway_code=lc.cod_concentratore) ");
				
				if(useAlternativeCcs){
					sb.append(" UNION ");
					
					sb.append(" SELECT lc.matricola_lennt_cliente as matricolaLennt, lc.cod_concentratore2 as ccs , 'CCS1' as ccsEnum,  ");
					sb.append(" 		 decode(lc.last_punctual_failure, null, '19900101', to_char(lc.last_punctual_failure, 'YYYYMMDD')) as ultimoFallimento ");
					sb.append(" 						                   FROM gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id  "); 
					sb.append(" 					                      WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
					sb.append(" 					                        AND lc.cod_concentratore2 is not null   and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
					sb.append(" 				                            AND not exists (select 1 from gre_tot_att_ass tot    ");
					sb.append(" 					                                         where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
					sb.append(" 				                            AND exists (select 1 from gre_ip_gateway ip    ");
					sb.append(" 				                                         where ip.ip_address is not null    ");
					sb.append(" 				                                           and ip.gateway_code=lc.cod_concentratore2) ");
					
									
					
					sb.append(" UNION ");
					
					sb.append(" SELECT lc.matricola_lennt_cliente as matricolaLennt, lc.cod_concentratore3 as ccs , 'CCS2' as ccsEnum,  ");
					sb.append(" 		 decode(lc.last_punctual_failure, null, '19900101', to_char(lc.last_punctual_failure, 'YYYYMMDD')) as ultimoFallimento ");
					sb.append(" 						                   FROM gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id   "); 
					sb.append(" 					                      WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
					sb.append(" 					                        AND lc.cod_concentratore3 is not null   and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
					sb.append(" 				                            AND not exists (select 1 from gre_tot_att_ass tot    ");
					sb.append(" 					                                         where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
					sb.append(" 				                            AND exists (select 1 from gre_ip_gateway ip    ");
					sb.append(" 				                                         where ip.ip_address is not null    ");
					sb.append(" 				                                           and ip.gateway_code=lc.cod_concentratore3) ");
				
				}
				sb.append(" ) ORDER BY ultimoFallimento ASC) t where rownum< :nMaxLennt  order by ccsEnum "); 

				
			 	logger.debug("Estrazione lennt per lettura instantanea giornaliera (useAlternativeCcs="+useAlternativeCcs+" - sql: " + sb.toString() );
			 	
				SQLQuery qry = getSession().createSQLQuery(sb.toString());
				qry.addScalar("matricolaLennt", Hibernate.STRING);
				qry.addScalar("ccs", Hibernate.STRING);
				qry.addScalar("ccsEnum", Hibernate.STRING);
				qry.setLong("gAnag", gAnag);
				qry.setLong("gVet", gVet);
				qry.setLong("nMaxLennt", nMaxLennt);
				qry.setResultTransformer(Transformers.aliasToBean(InstantDailyReadingsLennt.class));
				String idCCS = null;
				String idMeter = null;
				Map<String, String> meters = null;
				List<InstantDailyReadingsLennt> qryResults = null;

				qryResults = qry.list();
					
				if(qryResults!=null){
					for(InstantDailyReadingsLennt r : qryResults) {
						if(r != null) {
							idCCS = r.getCcs();
							idMeter = r.getMatricolaLennt();
							logger.debug("adding meter " + idMeter + " to ccs " + idCCS);
							if(idMeter!=null && idCCS!=null) {
								meters = metersCCsMap.get(idCCS);
								if(meters == null) {
									meters = new HashMap<String, String>();
								}
								if(!meters.containsKey(idMeter)){
										meters.put(idMeter,r.getCcsEnum());
										logger.debug("ADDED meter " + idMeter + " to ccs " + idCCS);
								}
								metersCCsMap.put(idCCS, meters);
							}
						}
					}
				}
				return metersCCsMap;

	}

	public long getLenntNumberForInstantPunctualReadings(long gAnag, long gVet, boolean useAlternativeCcs){

		//estrae il numero di lennt raggiungibili tramite CCS per i quali non esistono letture in gre_tot_atta_ass prima di sysdate - gVet
		// e che risultavano nel file address del concentratore dopo la data sysdate - gAnag
		//restituisce una mappa con chiava il CCS e value un set di lennt sottesi a quel ccs
		// NOTA : sono esclusi i lennt diretti perchè non vengono presi tramite file g.eea e non stanno nel file address

		StringBuffer sb = new StringBuffer("select count(distinct matricola_lennt_cliente) as total from (");

		sb.append(" SELECT 	lc.matricola_lennt_cliente ");
		sb.append(" FROM 	gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id ");
		sb.append(" 		WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
		sb.append(" 		AND lc.cod_concentratore is not null  and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
		sb.append(" 		AND not exists (select 1 from gre_tot_att_ass tot    ");
		sb.append(" 						where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
		sb.append(" 		AND exists (select 1 from gre_ip_gateway ip    ");
		sb.append(" 					where ip.ip_address is not null    ");
		sb.append(" 					and ip.gateway_code=lc.cod_concentratore) ");

		if(useAlternativeCcs){
			sb.append(" UNION ");

			sb.append(" SELECT 	lc.matricola_lennt_cliente ");
			sb.append(" FROM 	gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id  ");
			sb.append(" 		WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
			sb.append(" 		AND lc.cod_concentratore2 is not null   and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
			sb.append(" 		AND not exists (select 1 from gre_tot_att_ass tot    ");
			sb.append(" 						where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
			sb.append(" 		AND exists (select 1 from gre_ip_gateway ip    ");
			sb.append(" 				    where ip.ip_address is not null    ");
			sb.append(" 			and ip.gateway_code=lc.cod_concentratore2) ");

			sb.append(" UNION ");

			sb.append(" SELECT lc.matricola_lennt_cliente");
			sb.append(" FROM gre_lennt_cliente lc inner join gre_lennt_type lt on lc.tipo = lt.lennt_type_id   ");
			sb.append(" 	 WHERE to_char(lc.ULTIMO_CONTATTO_ADD, 'YYYYMMDD')  >= to_char(sysdate - :gAnag, 'YYYYMMDD')    ");
			sb.append(" 	 AND lc.cod_concentratore3 is not null   and lt.protocol<>'LANDIS_BT_LENNT_DIRECT'   and lc.Tipo<>'TBD' ");
			sb.append(" 	 AND not exists (select 1 from gre_tot_att_ass tot    ");
			sb.append(" 					 where tot.matricola_lennt_cliente=lc.matricola_lennt_cliente and to_char(tot.data_ril, 'YYYYMMDD') >= to_char(sysdate - :gVet, 'YYYYMMDD'))   ");
			sb.append(" 	 AND exists (select 1 from gre_ip_gateway ip    ");
			sb.append(" 				 where ip.ip_address is not null    ");
			sb.append(" 		 and ip.gateway_code=lc.cod_concentratore3) ");
		}
		sb.append(" )");

		logger.debug("Estrazione Numero lennt per lettura instantanea giornaliera (useAlternativeCcs="+useAlternativeCcs+" - sql: " + sb.toString() );

		SQLQuery qry = getSession().createSQLQuery(sb.toString());
		qry.addScalar("total", new org.hibernate.type.LongType());
		qry.setLong("gAnag", gAnag);
		qry.setLong("gVet", gVet);

		Long total = (Long)qry.uniqueResult();

		return total!=null?total.longValue():0;
	}
	
	public List<String> getLenntsByConcentratoreDaBonificare(String codConcentratore, Date dataIniziale, boolean ingoraDataIniziale) {
		ArgumentsCheckerUtil.checkNull(codConcentratore, "codConcentratore");
		StringBuffer sb = new StringBuffer();
		
		sb = new StringBuffer();
		sb.append("select lc.matricolaLenntCliente ");
		sb.append("from LenntCliente lc, Concentratore ccs ");
		sb.append("where lc.codConcentratore = ccs.codConcentratore AND ccs.codConcentratore = :codConcentratore");
		sb.append(" AND trunc(lc.ultimoContattoAdd, 'DD') = trunc(ccs.ultimoContattoAdd, 'DD') ");
		sb.append(" AND ccs.ultimoContattoAdd is not null and ccs.ipVpn is not null ");
		if(!ingoraDataIniziale && dataIniziale!=null){
			sb.append(" AND lc.timestampAssLennt >= :dataIniziale ");
		}
		
		Query qry = getSession().createQuery(sb.toString());
		qry.setString("codConcentratore", codConcentratore);
		if(ingoraDataIniziale==false && dataIniziale!=null){
			qry.setDate("dataIniziale", dataIniziale);
		}
		
		return qry.list();
	}

	public long totalOperatorRequestDaily(String taskCode) {
		StringBuffer sbQuery =new StringBuffer("select COUNT(*) AS total from GCF_OPERATOR_REQUEST");
		sbQuery.append(" where trunc(REQUEST_START_DATE)=trunc(sysdate)");
		sbQuery.append(" and REQUEST_TYPE=:taskCode");

		SQLQuery qry = getSession().createSQLQuery(sbQuery.toString());
		qry.addScalar("total", new org.hibernate.type.LongType());
		qry.setString("taskCode", taskCode);
		Long total = (Long)qry.uniqueResult();

		return total!=null?total.longValue():0;
	}

}
