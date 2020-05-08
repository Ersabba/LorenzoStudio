package com.ericsson.urm.persistence.dao.mgre;

import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgre.Concentratore;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.Work;
import org.hibernate.type.StringType;
import com.ericsson.urm.persistence.Hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ConcentratoreDAO extends GenericDAO {
	
	private final static Logger logger = Logger.getLogger(ConcentratoreDAO.class);
	
	private final static String QUERY_IP_NOT_NULL = "from Concentratore where ipVpn is not null";
	private final static String NATIVE_QUERY_CCS_LOADCURVES;
	private final static String NATIVE_QUERY_MONTHLY_REG_BE;
	private final static String NATIVE_QUERY_IP_NOT_NULL;
	private final static String NATIVE_QUERY_SYNCHRONIZE_CCS;
	private final static String NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS_PERIODIC;
	private final static String NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS;
	private final static String NATIVE_QUERY_CCS_DA_BONIFICARE;
	private final static String HQL_QUERY_AGGIORNAMENTO_STATUS_CCS_RIMOSSI;
	
	static {
		
		StringBuffer app = new StringBuffer();
		app.append("select distinct c.cod_concentratore as cod_concentratore");
		app.append(" from concentratore c, lennt_cliente lc");
		app.append(" where c.ip_vpn is not null ");
		app.append(" and (c.cod_concentratore = lc.cod_concentratore ");
		app.append(" or c.cod_concentratore = lc.cod_concentratore2 ");
		app.append(" or c.cod_concentratore = lc.cod_concentratore3) ");
		app.append(" and (lc.periodo_curve_di_carico = 'Q' ");
		app.append(" or lc.periodo_curve_di_carico = 'M' ");
		app.append(" or lc.periodo_curve_di_carico = 'H') ");
		NATIVE_QUERY_CCS_LOADCURVES = app.toString();
		
    	
    	app = new StringBuffer();
		app.append(" select c.cod_concentratore as cod_concentratore from concentratore c");
		app.append(" where c.ip_vpn is not null");
		app.append(" and not exists(");
		app.append(" select 1 from mensile_att_ass maa");
		app.append(" where maa.data_ril = :data_ril");
		app.append(" and maa.cod_concentratore = c.cod_concentratore");
		app.append(" )");
		app.append(" and not exists(");
		app.append(" select 1 from mensile_er mer");
		app.append(" where mer.data_ril = :data_ril");
		app.append(" and mer.cod_concentratore = c.cod_concentratore");
		app.append(" )");
		app.append(" and not exists(");
		app.append(" select 1 from mensile_reatt_ass mra");
		app.append(" where mra.data_ril = :data_ril");
		app.append(" and mra.cod_concentratore = c.cod_concentratore");
		app.append(" )");
    	NATIVE_QUERY_MONTHLY_REG_BE = app.toString();
    	
    	
    	app = new StringBuffer();
    	app.append(" select c.cod_concentratore as cod_concentratore from concentratore c");
		app.append(" where c.ip_vpn is not null");
		NATIVE_QUERY_IP_NOT_NULL = app.toString();

		app = new StringBuffer();
		app.append(" select a.cod_concentratore as cod_concentratore  from concentratore a ");
		app.append(" where a.ip_vpn is not null ");
		app.append(" minus ");
		app.append(" select distinct(b.mtrccs) as cod_concentratore from gre_sincr_ccs b ");
		app.append(" where (trunc(sysdate) - trunc(b.datasincr)) < :daysRequired ");
		app.append(" 		and esito='SUCCESS'");
		NATIVE_QUERY_SYNCHRONIZE_CCS = app.toString();

		app = new StringBuffer();
		app.append(" select t1.cod_concentratore                                ");
		app.append("   from gre_concentratore t1                                ");
		app.append("   left join Mds_File_Ccs_Fetched t2                        ");
		app.append("     on t1.cod_concentratore = t2.cod_concentratore         ");
		app.append("    and t2.file_type in (:fileTypes)                        ");
		app.append("    and upper(t2.file_name) like                            ");
		app.append("        upper('%/' || :tipoPeriodo || :periodo || '%')      ");
		app.append("  where (t2.file_type is null and t1.ip_vpn is not null)    ");
		app.append("     or (t2.file_corrente = 'N' and t1.ip_vpn is not null)  ");
		NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS_PERIODIC = app.toString();
		
		app = new StringBuffer();
		app.append(" select t1.cod_concentratore                                          ");
		app.append("   from gre_concentratore t1                                          ");
		app.append("   left join Mds_File_Ccs_Fetched t2                                  "); 
		app.append("     on t1.cod_concentratore = t2.cod_concentratore                   ");
		app.append("    and t2.file_type in (:fileTypes)                                  ");
		app.append("    where t1.ip_vpn is not null                                       ");
		app.append("       and ( t2.file_type is null                                     ");
		app.append("         or  t2.file_corrente = 'N'                                   ");
		app.append("         or  t2.file_type is not null and t2.acq_date<trunc(sysdate)) ");
		
		
		NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS = app.toString();
		
		
		app = new StringBuffer();		
		app.append(" select t1.cod_concentratore  ");
		app.append("   from gre_concentratore t1  ");
		app.append("  where t1.ip_vpn is not null ");
		app.append("    and cod_concentratore IN (:lista) ");
		app.append("    and bonifica_add = 'S'   ");
		NATIVE_QUERY_CCS_DA_BONIFICARE = app.toString();

		app = new StringBuffer();
		app.append("update 	Concentratore c");
		app.append(" set	c.stato='RIMOSSO', ");
		app.append("  		c.dataVariazioneStato=current_timestamp(), ");
		app.append("		c.ipVpn=null ");
		app.append("where 	c.codConcentratore!=:cod_concentratore and");
		app.append("	 	c.radiusUser=:utente_radius and");
		app.append("	 	c.stato!='RIMOSSO'");

		HQL_QUERY_AGGIORNAMENTO_STATUS_CCS_RIMOSSI =app.toString();

	}

	public ConcentratoreDAO(OracleHibernateSessionManagement sm) {
		super(sm);
		// TODO Auto-generated constructor stub
	}
	
	public Concentratore getById(String codConcentratore){
		ArgumentsCheckerUtil.checkNull(codConcentratore, "codConcetratore");
		return (Concentratore)getSession().get(Concentratore.class, codConcentratore);
	}
	
	public void save(Concentratore concentratore){
		ArgumentsCheckerUtil.checkNull(concentratore, "concentratore");
		getSession().save(concentratore);
	}
	
	public void saveOrUpdate(Concentratore concentratore){
		ArgumentsCheckerUtil.checkNull(concentratore, "concentratore");
		getSession().saveOrUpdate(concentratore);
	}
	
	public void delete(Concentratore concentratore){
		ArgumentsCheckerUtil.checkNull(concentratore, "concentratore");
		getSession().delete(concentratore);
	}
	
	public List getCodConcentratoreForMonthlyBestEffortAsList(Date data_ril) {
		ArgumentsCheckerUtil.checkNull(data_ril, "data_ril");
		
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_MONTHLY_REG_BE);
		qry.setDate("data_ril", data_ril);
		qry.addScalar("cod_concentratore", new StringType());
		List list=qry.list();
	
		return list;
	}
	

	/**
	 * @deprecated
	 * @param inizioCiclo
	 * @return
	 */
	public Set<String> getIdCCSForMonthlyMeasureBEAsList(Date inizioCiclo) {
		
		Set<String> result = new LinkedHashSet<String>();
		
		sm.getSession().doWork((new Work() {
			
			private Date inizioCiclo = null;
			private Set<String> result = null;
			
			public Work initialize(Date inizioCiclo, Set<String> result) {
				this.inizioCiclo = inizioCiclo;
				this.result = result;
				return this;
			}
			
			@Override
			public void execute(Connection connection) throws SQLException {
				
				CallableStatement stmt = null;				
				try {
					stmt = connection.prepareCall("{ ? = call FCcsForMonthlyReadings(?) }");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setDate(2, new java.sql.Date(inizioCiclo.getTime()));
					
					stmt.execute();
					ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
					while (rs.next()) {
						result.add(rs.getString("ccs"));
					}
				} 
				catch(SQLException e) {
					throw e;
				}
				catch (Exception e) {
					throw new SQLException(e.getMessage(),e);
				}
				finally {
					if(stmt!=null) {
						try {
							stmt.close();
						} catch (Exception e) {
							logger.error("Close CallableStatement failed; "+e.getMessage());
						}
					}
				}
			}
		}).initialize(inizioCiclo,result));
		
		return result;
	}
	
	public Map<String,Set<String>> getCcsFileNeededForReadings(Date inizioCiclo) {
		
		Map<String,Set<String>> result = new LinkedHashMap<String, Set<String>>();
		
		sm.getSession().doWork((new Work() {
			
			private Date inizioCiclo = null;
			private Map<String,Set<String>> result = null;
			
			public Work initialize(Date inizioCiclo, Map<String,Set<String>> result) {
				this.inizioCiclo = inizioCiclo;
				this.result = result;
				return this;
			}
			
			@Override
			public void execute(Connection connection) throws SQLException {
				
				CallableStatement stmt = null;
				String ccsId = null;
				String fileType = null;
				Set<String> fileTypeSet = null;
				try {
					stmt = connection.prepareCall("{ ? = call FCcsMonthlyFileMissing(?) }");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setDate(2, new java.sql.Date(inizioCiclo.getTime()));
					
					stmt.execute();
					ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
					while (rs.next()) {
						ccsId    = rs.getString("ccsId");
						fileType = rs.getString("ftype");
						fileTypeSet = result.get(ccsId);
						if(fileTypeSet==null) {
							fileTypeSet = new LinkedHashSet<String>();
						}
						fileTypeSet.add(fileType);
						
						result.put(ccsId,fileTypeSet);
					}
				} 
				catch(SQLException e) {
					throw e;
				}
				catch (Exception e) {
					throw new SQLException(e.getMessage(),e);
				}
				finally {
					if(stmt!=null) {
						try {
							stmt.close();
						} catch (Exception e) {
							logger.error("Close CallableStatement failed; "+e.getMessage());
						}
					}
				}
			}
		}).initialize(inizioCiclo,result));
		
		return result;
	}

	public List getCodConcentratoreForLoadCurvesActivitiesAsList() {
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_CCS_LOADCURVES);
		qry.addScalar("cod_concentratore", new StringType());
		List list=qry.list();
		
		return list;
	}
	
	public List getConcentratoreWithIpNotNullAsList() {
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_IP_NOT_NULL);
		qry.addScalar("cod_concentratore", new StringType());
		List list = qry.list();

		return list;
	}
	
	public Concentratore[] getConcentratoreWithIpNotNull() {
		Query qry = getSession().createQuery(QUERY_IP_NOT_NULL);
		List list = qry.list();

		Concentratore[] ret = null;
		if (list != null && list.size() > 0) {
			ret = new Concentratore[list.size()];
			ret = (Concentratore[]) list.toArray(ret);
		} else {
			ret = new Concentratore[0];
		}
		return ret;
	}
	
	public List<String> getReqSynchrCcsList(int daysRequired) {
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_SYNCHRONIZE_CCS);
		qry.setInteger("daysRequired", daysRequired);
		qry.addScalar("cod_concentratore", new StringType());
		List<String> list = qry.list();

		return list;
	}
	
	public Concentratore getConcentratoreByLastFiveChars(String ccsCode){
		ArgumentsCheckerUtil.checkString(ccsCode, "ccsCode");
		
		Concentratore ret = null;
		Query qry=getSession().createQuery("from Concentratore c where c.codConcentratore like '%"+ ccsCode + "'");
		List list = qry.list();
		if (list != null && list.size() > 0) {
			ret = (Concentratore)list.get(0);
		}
		return ret;
	}
	
	public List<String> getCcsForAcquisitionTasks(Set<String> fileTypes, String tipoPeriodo, String periodo) {
		ArgumentsCheckerUtil.checkNull(fileTypes, "fileType");
		ArgumentsCheckerUtil.checkString(tipoPeriodo, "tipoPeriodo");
		ArgumentsCheckerUtil.checkString(periodo, "periodo");
		
		SQLQuery sqlQuery = getSession().createSQLQuery(NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS_PERIODIC);
		
		sqlQuery.setParameterList("fileTypes", fileTypes);
		sqlQuery.setString("tipoPeriodo", tipoPeriodo);
		sqlQuery.setString("periodo", periodo);
		sqlQuery.addScalar("cod_concentratore", new StringType());
		
		List res = sqlQuery.list();

		return res;
	}
	
	public List<String> getCcsForAcquisitionTasks(Set<String> fileTypes) {
		ArgumentsCheckerUtil.checkNull(fileTypes, "fileType");
		
		SQLQuery sqlQuery = getSession().createSQLQuery(NATIVE_QUERY_GET_CCS_FOR_ACQ_TASKS);
		
		sqlQuery.setParameterList("fileTypes", fileTypes);
		sqlQuery.addScalar("cod_concentratore", new StringType());
		
		List res = sqlQuery.list();

		return res;
	}
	

	public List<String>  getConcentratoriDaBonificare(List<String> listaCCS) {
		List<String> res = null;
		if( listaCCS!=null && !listaCCS.isEmpty()){
			SQLQuery sqlQuery = getSession().createSQLQuery(NATIVE_QUERY_CCS_DA_BONIFICARE);
			sqlQuery.setParameterList("lista", listaCCS, Hibernate.STRING);
			sqlQuery.addScalar("cod_concentratore", new StringType());
			res = sqlQuery.list();
		}
		if(res==null) {
			res = new ArrayList<String>();
		}
		return res;
	}

	/*
	 * modifica lo stato (a RIMOSSO) e la data variazione stato (a data odierna) e ip_vpn=null per quei CCS/CMS che hanno
	 * cod_concentratore != matricolaApparatoAttivo
	 * che hanno utente_radius = radiusUser e stato!='RIMOSSO'
	 */

	public int updateStatusCCSRimosso(String radiusUser, String matricolaApparatoAttivo){

		ArgumentsCheckerUtil.checkString(radiusUser, "radiusUser");
		ArgumentsCheckerUtil.checkString(matricolaApparatoAttivo, "matricolaApparatoAttivo");

		int updatedEntities = 	getSession().
								createQuery(HQL_QUERY_AGGIORNAMENTO_STATUS_CCS_RIMOSSI).
								setString("utente_radius",radiusUser).
								setString("cod_concentratore",matricolaApparatoAttivo).
								executeUpdate();


		return updatedEntities;
	}
}
