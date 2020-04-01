package com.ericsson.urm.persistence.core.dao.readings;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;

import com.ericsson.urm.StringConstants;
import com.ericsson.urm.core.datatypes.LenntStatusComponentMap;
import com.ericsson.urm.core.datatypes.StatusComponent;
import com.ericsson.urm.device.driver.datatype.ComponentId;
import com.ericsson.urm.exceptions.ConfigurationException;
import com.ericsson.urm.persistence.Hibernate;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.CCsLenntComponent;
import com.ericsson.urm.persistence.dto.MonthlyMissingDate;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class MonthlyMeasuresDAO extends GenericDAO {
	private static Logger logger = Logger.getLogger(MonthlyMeasuresDAO.class);
	private static String	QUERY_MAX_LENNTS_TO_CONTACT_FOR_MONTHLY_LENNT_INCOMPLETE;

//	private static String	QUERY_LENNTS_TO_CONTACT_FOR_REG_PICCO_MESE_PARZ_PUNCTUAL;

	private static final String	SP_POPULATE_MONTHLY_LENNT_INCOMPL = "{ call PExtractMonthlyLenntIncomplete(?, ?) }";


	static {
		StringBuffer sb = new StringBuffer();
			

//***********			
		sb = new StringBuffer();

		sb.append("select count(distinct k.matricola_lennt_cliente ) as maxNumLennts from (            ");
		sb.append("    SELECT lc.matricola_lennt_cliente matricola_lennt_cliente                       ");
		sb.append("      FROM (SELECT matricola_lennt_cliente, component                               ");
		sb.append("              FROM utenze_cm unpivot(enabled FOR component IN(eea,                  ");
		sb.append("                                                              eua,                  ");
		sb.append("                                                              eei,                  ");
		sb.append("                                                              eui,                  ");
		sb.append("                                                              eec,                  ");
		sb.append("                                                              euc))                 ");
		sb.append("             where (enabled <> 0 and component <> 'EEA' or component = 'EEA')) ucm, ");
		sb.append("           gre_lennt_cliente lc,                                                    ");
		sb.append("           gre_lennt_type lt,                                                       ");
		sb.append("           t_siu tsiu,                                                              ");
		sb.append("           gre_ip_gateway ipg                                                       ");
		sb.append("     WHERE NOT EXISTS                                                               ");
		sb.append("     (SELECT 1                                                                      ");
		sb.append("              FROM gre_monthly_missing_a150 t                                       ");
		sb.append("             WHERE t.matricola_lennt_cliente = lc.matricola_lennt_cliente           ");
		sb.append("               AND t.component = ucm.component                                      ");
		sb.append("               AND t.status = 0                                            		   ");
		sb.append("            )                                                                       ");
		sb.append("       AND tsiu.cod_app = lc.matricola_lennt_cliente                                ");
		sb.append("       AND ucm.matricola_lennt_cliente = lc.matricola_lennt_cliente                 ");
		sb.append("       AND lt.lennt_type_id = lc.tipo                                               ");
		sb.append("       AND (ipg.gateway_code = lc.matricola_lennt_cliente and                       ");
		sb.append("           lt.protocol in ('LANDIS_BT_LENNT_DIRECT') or                             ");
		sb.append("           ipg.gateway_code = lc.cod_concentratore and                              ");
		sb.append("           lt.protocol in ('LANDIS_BT_CCS_MEDIATED'))                               ");
		sb.append("       AND ipg.ip_address IS NOT NULL                                               ");
		sb.append(") k                                                                                 ");



		QUERY_MAX_LENNTS_TO_CONTACT_FOR_MONTHLY_LENNT_INCOMPLETE = sb.toString();
	}

	public MonthlyMeasuresDAO(HibernateSessionManagement sm) {
		super(sm);
	}

	
/*	
	public List<RegistroPiccoMeseParz> getLenntIdsToRegistroPiccoMeseParzPunctual(String matricolaLenntCliente, EnergyComponentId energyComponentId, String mese, String anno) {
		ArgumentsCheckerUtil.checkNull(matricolaLenntCliente,"matricolaLenntCliente");
		ArgumentsCheckerUtil.checkNull(energyComponentId,"energyComponentId");
		ArgumentsCheckerUtil.checkString(mese,"mese");
		ArgumentsCheckerUtil.checkString(anno,"anno");
		
		Query q = getSession().createQuery(QUERY_LENNTS_TO_CONTACT_FOR_REG_PICCO_MESE_PARZ_PUNCTUAL);
		q.setString("matricolaLenntCliente", matricolaLenntCliente);
		q.setString("energyComponentId", energyComponentId.getEnergyId());
		q.setString("mese", mese);
		q.setString("anno", anno);

		return q.list();
	}
	*/
	public void populateMonthlyLenntIncomplete(String lenntTypes, String meterTypesDec) throws HibernateException, ConfigurationException, SQLException  {
		ArgumentsCheckerUtil.checkNull(lenntTypes,"lenntTypes");// Settato a stringa vuota per attivare i decimali o "PP" per es. per disattivarli
		
		sm.getSession().doWork(connection->{
			try (final CallableStatement cs = connection.prepareCall(SP_POPULATE_MONTHLY_LENNT_INCOMPL)) {
				cs.setString(1, lenntTypes);
				cs.setString(2, meterTypesDec);
				cs.executeUpdate();
			}				
		});
		
	}
	
	
	public Map<String, LenntStatusComponentMap> getLenntForMonthlyMeasuresPunctual() {
		
		Map<String, LenntStatusComponentMap>  mappaCcsLenntComp = null;
		StringBuilder qry = new StringBuilder();
		qry.append(" select t.ccs_id        codConcentratore,            ");
		qry.append("        t.meter_id      matricolaLenntCliente,       ");
		qry.append("        t.component     componente,                  ");
		qry.append("        t.missing       missing                      ");
		qry.append(" from V_MONTHLY_LENNT_INCOMPLETE t");
	
		
		SQLQuery query = getSession().createSQLQuery(qry.toString());
		query.addScalar("codConcentratore", Hibernate.STRING);
		query.addScalar("matricolaLenntCliente", Hibernate.STRING);
		query.addScalar("componente", Hibernate.STRING);
		query.addScalar("missing", Hibernate.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(CCsLenntComponent.class));
		
		logger.debug("\n"+query.toString()+"\n");
		
		List<CCsLenntComponent> list = query.list();		
			
		
		
		if(!(list==null) && !list.isEmpty()){
			mappaCcsLenntComp = new LinkedHashMap<String, LenntStatusComponentMap>();
			for(CCsLenntComponent rec : list){
				if(rec!=null){
					String codiceCCS = rec.getCodConcentratore()==null? "" : rec.getCodConcentratore();
					LenntStatusComponentMap lcMap = mappaCcsLenntComp.get(codiceCCS);
					if(lcMap==null){
						lcMap = new LenntStatusComponentMap();
					}
					Set<StatusComponent> componenti = lcMap.get(rec.getMatricolaLenntCliente());
					if(componenti==null){
						componenti = new HashSet<StatusComponent>();
					}
					ComponentId component = ComponentId.parse(rec.getComponente());
					componenti.add(new StatusComponent(component, rec.getMissing()));
					lcMap.put(rec.getMatricolaLenntCliente(), componenti);
					mappaCcsLenntComp.put(codiceCCS, lcMap);
				}
			}
			
			
		}

		return mappaCcsLenntComp;
	}
	
	public int getLenntForMonthlyMeasuresPunctualSize() {
		
		
		StringBuilder qry = new StringBuilder();
		qry.append(" select count(distinct t.meter_id) as nlennts ");
		qry.append(" from V_MONTHLY_LENNT_INCOMPLETE t");
	
		
		SQLQuery query = getSession().createSQLQuery(qry.toString());
		query.addScalar("nlennts", new org.hibernate.type.IntegerType());
		
		logger.debug("\n"+query.toString()+"\n");
		
		int nlennts = (Integer)query.uniqueResult();		
			
		return nlennts;
	}

	public Long getLenntForMonthlyMeasuresPunctualSizeNoFilter() {

		StringBuilder qry = new StringBuilder();
		qry.append(" select count(*) as nlennts ");
		qry.append(" from V_MONTHLY_LENNT_INCOMPLETE_NF t");

		SQLQuery query = getSession().createSQLQuery(qry.toString());
		query.addScalar("nlennts", new org.hibernate.type.LongType());

		logger.debug("\n"+query.toString()+"\n");

		Long nlennts = (Long)query.uniqueResult();

		return nlennts;
	}
	
	private String makeInClause(List<String> typeCodes) {

		StringBuffer buf = new StringBuffer();

		if(typeCodes!=null) {
			for (int i = 0; i < typeCodes.size(); i++) {
				if (buf.length()>0) {
					buf.append(",");
				}
				buf.append("'");
				buf.append(ArgumentsCheckerUtil.checkString(typeCodes.get(i)));
				buf.append("'");
			}
		}
		
		String result = StringConstants.EMPTY_STRING;
		if(buf.length()>0) {
			result = " AND glc.tipo IN ("+buf.toString()+") ";
		}
		
		return result;
	}
	
	private String makeInClauseCase(List<String> typeCodes) {
		StringBuffer buf = new StringBuffer();
		buf.append(" case ");
		int i = 0;
		if(typeCodes!=null && !typeCodes.isEmpty()) {
			for (; i < typeCodes.size(); i++) {
				buf.append(" when t1.tipo = ");
				buf.append("'");
				buf.append(ArgumentsCheckerUtil.checkString(typeCodes.get(i)));
				buf.append("'");
				buf.append(" then ");
				buf.append(i+1);
			}
			buf.append(" else ").append(i+1);
		}
		else {
			buf.append(" when 1 = 1 then 1 ");
		}
		buf.append(" end, ");

		return buf.toString();
	}

	public Map<String, LenntStatusComponentMap> getMonthlyMissingLenntComponents(int maxMeterManaged, String meterTypesDecimal) {
		Map<String, LenntStatusComponentMap> result = new LinkedHashMap<String, LenntStatusComponentMap>();
		
		sm.getSession().doWork((new Work() {
			
			private Map<String, LenntStatusComponentMap> resultOut = null;
			
			private int    maxMeterManaged = 0;
			private String meterTypesDecimal = null;
			
			public Work initialize(int maxMeterManaged, String meterTypesDecimal, Map<String, LenntStatusComponentMap> resultOut) {
				this.resultOut = resultOut;
				this.maxMeterManaged = maxMeterManaged;
				this.meterTypesDecimal = meterTypesDecimal;
				return this;
			}

			@Override
			public void execute(Connection connection) throws SQLException {
 
				CallableStatement stmt = null;				
				try {
					stmt = connection.prepareCall("{ ? = call FMonthlyLenntComponentsMissing(?,?) }");
					stmt.registerOutParameter(1, OracleTypes.CURSOR);
					stmt.setInt(2, maxMeterManaged);
					if(meterTypesDecimal!=null) {
						stmt.setString(3, meterTypesDecimal);
					}
					else {
						stmt.setNull(3, OracleTypes.NULL);
					}
					
					stmt.execute();
					ResultSet rs = ((OracleCallableStatement)stmt).getCursor(1);
					
					LenntStatusComponentMap lenntStatusComponentMap = null; 
					String ccsId = null;
					String meterId = null;
					String component = null;
					StatusComponent statusComponent = null;
					Set<StatusComponent> statusComponentSet = null;
					int status = 15;
					
					while (rs.next()) {
						try {
							ccsId     = rs.getString("ccsId");
							meterId   = rs.getString("meterId");
							component = rs.getString("component");
							status	  = rs.getInt("status");
							
							if(meterId==null || meterId.trim().isEmpty()) {
								logger.error("Query retrieve undefined meterId");
								continue;
							}
							if(component==null || component.trim().isEmpty()) {
								logger.error("Query retrieve undefined component");
								continue;
							}
							
							if(ccsId==null) {
								ccsId = StringConstants.EMPTY_STRING;
							}
							
							lenntStatusComponentMap = resultOut.get(ccsId);
							if(lenntStatusComponentMap==null) {
								lenntStatusComponentMap = new LenntStatusComponentMap();
							}
							
							statusComponentSet = lenntStatusComponentMap.get(meterId);
							if(statusComponentSet==null) {
								statusComponentSet = new LinkedHashSet<StatusComponent>();
							}
							
							statusComponent = new StatusComponent(ComponentId.parse(component), status);
							
							statusComponentSet.add(statusComponent);
							
							lenntStatusComponentMap.put(meterId, statusComponentSet);
							
							resultOut.put(ccsId, lenntStatusComponentMap);
							
						} catch (Exception e) {
							
							logger.error(e.getMessage(),e);
						}
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
		}).initialize(maxMeterManaged, meterTypesDecimal, result));
		
		return result;
	}
	

	public Set<MonthlyMissingDate> getMonthlyMissingDates(String meterId) {
		SQLQuery qry = getSession().createSQLQuery("select METER_ID as meterId, MISSING_MONTH as missingMonth, ENERGY_TYPE as energyType from V_MONTHLY_MISSING_DATE t where t.METER_ID=:meterId");
		qry.setString("meterId", meterId);
		qry.addScalar("meterId", Hibernate.STRING);
		qry.addScalar("missingMonth", Hibernate.DATE);
		qry.addScalar("energyType", Hibernate.STRING);
		qry.setResultTransformer(Transformers.aliasToBean(MonthlyMissingDate.class));

		List<MonthlyMissingDate> results = qry.list();
		
		Set<MonthlyMissingDate> resultSet = null;
		if(results!=null) {
			resultSet = new LinkedHashSet<MonthlyMissingDate>(results);
		}
		else {
			resultSet = new LinkedHashSet<MonthlyMissingDate>();
		}
		
		return resultSet;
	}

	public long getMonthlyMissingComponentMaxLennt() {

		SQLQuery qry = getSession().createSQLQuery(QUERY_MAX_LENNTS_TO_CONTACT_FOR_MONTHLY_LENNT_INCOMPLETE);

		qry.addScalar("maxNumLennts", new org.hibernate.type.LongType());

		logger.debug("\n"+qry.toString()+"\n");

		long nMaxlennts = (Long)qry.uniqueResult();

		return nMaxlennts;
	}
}
