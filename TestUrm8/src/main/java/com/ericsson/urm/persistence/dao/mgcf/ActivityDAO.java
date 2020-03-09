package com.ericsson.urm.persistence.dao.mgcf;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import com.ericsson.mgcf.business.ActivityCriteriaBO;
import com.ericsson.urm.StringConstants;
import com.ericsson.urm.persistence.Hibernate;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import com.ericsson.urm.persistence.dto.mgcf.Activity;
import com.ericsson.urm.persistence.dto.mgcf.ActivityThor;
import com.ericsson.urm.persistence.dto.mgcf.ExternalSystem;
import com.ericsson.urm.persistence.dto.mgcf.Meter;
import com.ericsson.urm.persistence.dto.mgcf.RequestAssociation;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class ActivityDAO extends GenericDAO {
	private static final Logger logger = Logger.getLogger(ActivityDAO.class);
	
	//hibernate queries
	private final static String QUERY_RECOVERY;
	private final static String QUERY_COUNT = "select a.state,count(a) from Activity a";
	 
	
	//native queries
	private static final String NATIVE_QUERY_FIND_BY_SUB_ID="select * from mgcf_activity a, mgcf_subscription s where s.id_request=a.id_request and s.subscription_id=:subscriptionId order by a.id_request desc";
	private final static String NATIVE_QUERY_ATTIVITA_DA_ESEGUIRE;
	private final static String NATIVE_QUERY_ATTIVITA_BY_STATE_WITH_OFFSET;
	private final static String NATIVE_QUERY_ATTIVITA_BY_STATE;
	private final static String NATIVE_QUERY_ATTIVITA_BY_ID_REQ;
	private final static String NATIVE_QUERY_ALL_TASK_BY_RANGE;
	private final static String NATIVE_QUERY_ATTIVITA_BY_TASKID_IDES;
	private final static String NATIVE_QUERY_ATTIVITA_BY_CRITERIA_NOT_PAGED;
	private final static String NATIVE_QUERY_ATTIVITA_ESEGUITE_BY_LOCATION_ID;
	private final static String PROCEDURE_RECOVERY_WAITING_ACTIVITIES="{call PRECOVERY_WAITING_ACTIVITIES(?)}";
	private final static String NATIVE_QUERY_SUSPENDED_ACTIVITIES;
    private final static String NATIVE_QUERY_SUSPENDED_ACTIVITIES_LOR;
	
	private final static String NATIVE_QUERY_ATTIVITA_BY_LENNTCOM_IDES;
	
	static{
		
		//PRIMA DELLA CR26
		/*StringBuffer app = new StringBuffer("select * from (select a.* from mgcf_activity a, mgcf_task_type b, mgcf_request_association c");
		app.append(" where to_number(a.tasktype_id,'9999') = to_number(b.code,'9999')");
		app.append(" and b.id_es = c.id_es");
		app.append(" and a.id_request = c.id_request");
		app.append(" and a.state='Ready' and sysdate > a.expected_date");
		app.append(" + b.EXECUTION_DATE_DAY + b.EXECUTION_DATE_HOUR/24+b.EXECUTION_DATE_MIN/1440");
		app.append(" order by a.expected_date, a.priority desc) aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" where rownum<:max_rownum");
		app.append(" and cc.id_request = aa.id_request");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_es =:idEs");
		NATIVE_QUERY_ATTIVITA_DA_ESEGUIRE = app.toString();*/
		
		
		//CR26 nuova estrazione interventi da eseguire
		/*StringBuffer app = new StringBuffer("with ");
		app.append(" Estrazione as (  ");
		app.append("      select aa.* from (select a.* from mgcf_activity a, mgcf_task_type b, mgcf_request_association c  ");
		app.append("       where to_number(a.tasktype_id,'9999') = to_number(b.code,'9999')  ");
		app.append("       and b.id_es = c.id_es  ");
		app.append("       and a.id_request = c.id_request  ");
		app.append("       and a.state='Ready' and sysdate > a.expected_date  ");
		app.append("      + b.EXECUTION_DATE_DAY + b.EXECUTION_DATE_HOUR/24+b.EXECUTION_DATE_MIN/1440  ");
		app.append("       order by a.expected_date, a.priority desc, a.insert_date, a.id_request) aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd  ");
		app.append("       where cc.id_request = aa.id_request  ");
		app.append("       and cc.id_request_type = dd.id_request_type  ");
		app.append("       and cc.id_es = bb.id_es  ");
		app.append("       and cc.id_es = :idEs ");
		app.append("   ), ");
		app.append("   miaSelect2 as (select zz.id_request as id_request, mm.meter_id as meter_id, rownum as ordine from Estrazione zz, gcf_meters mm where mm.id_request = zz.id_request),  ");
		app.append("   miaSelect3 as (select XX.meter_id as meter_id, min(ordine) as mininoid from miaSelect2 XX group by XX.meter_id), ");
		app.append("   miaSelect4 as (select aaa.id_request from miaSelect2 aaa, miaSelect3 bbb where aaa.ordine = bbb.mininoid) ");
		app.append("   select aa.*, bb.*, cc.*, dd.* from  ");
		app.append("       mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd, miaSelect4 SS ");
		app.append("       where cc.id_request = aa.id_request  ");
		app.append("       and cc.id_request_type = dd.id_request_type  ");
		app.append("       and cc.id_es = bb.id_es  ");
		app.append("       and cc.id_es = :idEs  ");
		app.append("   and aa.id_request = SS.id_request AND rownum<:max_rownum");*/
		
		
		StringBuffer app = new StringBuffer(" with ");
		app.append(" EstrazioneIniziale as (Select act.*, rownum as ordine from ");			    
		app.append("      (select aa.*, mm.meter_id as meter from mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd , gcf_meters mm , mgcf_task_type ee ");
		app.append("       where cc.id_request = aa.id_request  ");
		app.append("         and mm.id_request = aa.id_request ");
		app.append("         and ee.id_es = cc.id_es  ");
		app.append("         and to_number(aa.tasktype_id,'9999') = to_number(ee.code,'9999') ");
		app.append("         and cc.id_request_type = dd.id_request_type  ");
		app.append("         and aa.state='Ready' and sysdate > aa.expected_date + ee.EXECUTION_DATE_DAY + ee.EXECUTION_DATE_HOUR/24+ee.EXECUTION_DATE_MIN/1440     ");       
		app.append("         and cc.id_es = bb.id_es  ");
		app.append("         and cc.id_es =:idEs ");
		app.append("         and not exists ( ");
		app.append("                   select 1 from mgcf_activity act, gcf_meters met where act.id_request = met.id_request and act.id_request<>aa.id_request and met.meter_id = mm.meter_id and act.state IN ('waitRead', 'In Progress', 'ThorActivityWait') ");
		app.append("                 )");
		app.append("       order by aa.expected_date, aa.insert_date, aa.priority desc, aa.id_request ");
		app.append("      ) act),  ");
		app.append("  EstrazioneIntermedia as (select XX.meter as meter, min(ordine) as mininoid from EstrazioneIniziale XX group by XX.meter), ");
		app.append("  EstrazioneFinale as (select aaa.id_request from EstrazioneIniziale aaa, EstrazioneIntermedia bbb where aaa.ordine = bbb.mininoid) ");
		app.append("   select aa.*, bb.*, cc.*, dd.* from  ");
		app.append("      mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd, EstrazioneFinale SS ");
		app.append("    where cc.id_request = aa.id_request  ");
		app.append("      and cc.id_request_type = dd.id_request_type  ");
		app.append("      and cc.id_es = bb.id_es  ");
		app.append("      and cc.id_es =:idEs  ");
		app.append("      and aa.id_request = SS.id_request");
		app.append("      and rownum<:max_rownum ");
		 
		NATIVE_QUERY_ATTIVITA_DA_ESEGUIRE = app.toString();
		
		
		app = new StringBuffer("select aa.*,bb.*,cc.*,dd.* from");
		app.append(" (select * from mgcf_activity a where a.state=:state");
		app.append(" and sysdate > a.expected_date + :offset_min/1440");
		app.append(" ORDER BY priority desc) aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" where rownum < :max_rownum");
		app.append(" and cc.id_request = aa.id_request");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_es =:idEs");
		NATIVE_QUERY_ATTIVITA_BY_STATE_WITH_OFFSET = app.toString();
		
		app = new StringBuffer("select aa.*,bb.*,cc.*,dd.* from");
		app.append(" (select * from mgcf_activity a where state=:state");
		app.append(" ORDER BY priority desc) aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" where rownum < :max_rownum");
		app.append(" and cc.id_request = aa.id_request");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_es =:idEs");		
		NATIVE_QUERY_ATTIVITA_BY_STATE = app.toString();
		
	
		app = new StringBuffer("select aa.*, bb.*, cc.*,dd.* from");
		app.append(" mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" WHERE cc.id_request = aa.id_request");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and aa.id_request=:id_request");		
		NATIVE_QUERY_ATTIVITA_BY_ID_REQ = app.toString();
		
		app = new StringBuffer("select aa.*, bb.*, cc.*,dd.* from");
		app.append(" mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" WHERE cc.id_request = aa.id_request");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es=:id_es");
		app.append(" and cc.task_id=:task_id");
		NATIVE_QUERY_ATTIVITA_BY_TASKID_IDES = app.toString();
		
		
		app = new StringBuffer("SELECT * "); 
		app.append(" FROM (SELECT A.*, ROWNUM RNUM ");  			    
		app.append(" FROM (SELECT MA.* ");
		app.append(" FROM MGCF_ACTIVITY MA ");
		app.append(" WHERE MA.ID_REQUEST IN (SELECT MRA.ID_REQUEST FROM MGCF_REQUEST_ASSOCIATION MRA ");
		app.append(" WHERE MRA.ID_ES = :id_es ) " );
		app.append(" AND MA.LENNTCOM_FLAG = :lenntcom ");
		NATIVE_QUERY_ALL_TASK_BY_RANGE=app.toString();
		
		app = new StringBuffer("select aa.*,bb.*,cc.*,dd.* from");
		app.append(" (select * from mgcf_activity a where a.lenntcom_flag='Y'");
		app.append(" ORDER BY priority desc) aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" where rownum < :max_rownum");
		app.append(" and cc.id_request = aa.id_request");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_es =:idEs");
		NATIVE_QUERY_ATTIVITA_BY_LENNTCOM_IDES=app.toString();

		
		app = new StringBuffer("from Activity a where a.requestAssociation.externalSystem.idEs=:idEs");
		app.append(" and a.recoveryCode is not null");
		app.append(" and a.recoveryCode not in ('"+Activity.RECOVERY_CODES.RESULTS.FAILED+"'");
		app.append(",'"+Activity.RECOVERY_CODES.RESULTS.SUCCESS+"')");
		QUERY_RECOVERY=app.toString();		
		
		app = new StringBuffer();
		app.append("select aa.*,rap.*,es.*,rt.*,mm.* from ");
		app.append(" mgcf_request_association rap, mgcf_activity aa, mgcf_external_system es, mgcf_request_type rt, mgcf_meters mm ");
		app.append(" where es.id_es = :idEs ");
		app.append(" and es.id_es = rap.id_es ");
		app.append(" and rap.id_request_type = rt.id_request_type ");
		app.append(" and rap.id_request = aa.id_request ");
		app.append(" and rap.id_request = mm.id_request ");
		NATIVE_QUERY_ATTIVITA_BY_CRITERIA_NOT_PAGED = app.toString();

		app = new StringBuffer("select aa.*, bb.*, cc.*,dd.* from");
		app.append(" mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc, mgcf_request_type dd");
		app.append(" WHERE cc.id_request = aa.id_request");
		app.append(" and aa.location_id =:locationId");
		app.append(" and cc.id_es = bb.id_es");
		app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and cc.id_es=:id_es");
		app.append(" ORDER BY aa.execution_timestamp");
		NATIVE_QUERY_ATTIVITA_ESEGUITE_BY_LOCATION_ID = app.toString();
		
		app = new StringBuffer("select aa.*, bb.*, cc.*");
        //app = new StringBuffer("select aa.*");
        app.append(" from mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc ");
		app.append(" where bb.id_es = :idEs and cc.id_es = bb.id_es and cc.id_request = aa.id_request ");
        //app.append(" and cc.id_request_type = dd.id_request_type");
		app.append(" and (aa.state='Suspend' OR aa.state='SuspendRead')");
		NATIVE_QUERY_SUSPENDED_ACTIVITIES=app.toString();

        app = new StringBuffer("select aa.*");
        app.append(" from mgcf_activity aa, mgcf_external_system bb, mgcf_request_association cc ");
        app.append(" where bb.id_es = :idEs and cc.id_es = bb.id_es and cc.id_request = aa.id_request ");
        app.append(" and (aa.state='Suspend' OR aa.state='SuspendRead')");
        NATIVE_QUERY_SUSPENDED_ACTIVITIES_LOR=app.toString();
	}
	
	public static class ActivityCountState{
		public String state=null;
		public long count=-1;
	}
	

	public ActivityDAO(HibernateSessionManagement sm) {
		super(sm);
		
	}

	public Activity getById(long idrequest){
		SQLQuery qry= getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_BY_ID_REQ);
		qry.addEntity("aa", Activity.class);
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");		
		qry.addJoin("dd", "cc.requestType");
		qry.setLong("id_request", idrequest);
		
		Activity[] app=extractJoinedActivity(qry.list());
		return app.length>0?app[0]:null; 
	}
	
	
	public Activity getByIdEsAndKeyInt(int id_es, String task_id){
		SQLQuery qry= getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_BY_TASKID_IDES);
		qry.addEntity("aa", Activity.class);		
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setInteger("id_es", id_es);
		qry.setString("task_id", task_id);
		
		Activity[] app=extractJoinedActivity(qry.list());
		return app.length>0?app[0]:null; 
	}
	
	
	public void persist(Activity act){
		ArgumentsCheckerUtil.checkNull(act);
		getSession().persist(act);
	}
	
	
	public void saveOrUpdate(Activity act){
		ArgumentsCheckerUtil.checkNull(act);
		getSession().saveOrUpdate(act);
	}
	
	
	
	public void delete(Activity act){
		ArgumentsCheckerUtil.checkNull(act);
		getSession().delete(act);
	}
	
	/**
	 * Due to an Hibernate bug, bug id HHH-2831, we need to check the type of the objects contained in the list returned by the query.
	 * Instead of a list of Activity due to the bug hibernate returns a list of Objects[], the first element is the Activity expected and the 
	 * other two are a {@link RequestAssociation} and an {@link ExternalSystem} joined in the query  
	 * @param list
	 * @return
	 */	
	private Activity[] extractJoinedActivity(List list){

        System.out.println("Stampa contenuto lista\n");
            for(Object obj : list) {
                Object[] rows = (Object[])obj;

                System.out.println("Numero righe:"+rows.length);

                Activity act = (Activity)rows[0];
                System.out.println("Activity: "+act );

                RequestAssociation req = (RequestAssociation)rows[1];
                System.out.println("RequestAssociation: "+req );

                ExternalSystem ext = (ExternalSystem)rows[2];
                System.out.println("ExternalSystem: "+ext );

            }
            System.out.println("\n");

		Activity[] ret = null;
		if (list.size() > 0) {
			ret = new Activity[list.size()];
			if (list.get(0) instanceof Activity) {
				ret= new Activity[list.size()];
				ret = (Activity[]) list.toArray(ret);
			}
			// workaround due to hibernate bug: bug_id = HHH-2831
			else {
				
				for (int i = 0; i < ret.length; i++) {

					if (!(list.get(i) instanceof Object[]) && !(((Object[]) list.get(i))[0] instanceof Activity)) {
						throw new RuntimeException("Illegal type: I expect for a list of Object[] and the first element must be an Activity");
					}
					ret[i] = (Activity) ((Object[]) list.get(i))[0];
				}
			}
		} else {
			ret = new Activity[0];
		}
		return ret;
		
	}
	

	public Activity[] findAttivitaDaEseguire(int idEs, int max_rownum) {

		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_DA_ESEGUIRE);

		qry.addEntity("aa", Activity.class);
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setInteger("max_rownum", max_rownum);
		qry.setInteger("idEs", idEs);
		List list = qry.list();

		
		return extractJoinedActivity(list);
	}
	
	/*public Activity[] findAllLenntcom(int idEs, int max_rownum) {
		SQLQuery qry = getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_DA_ESEGUIRE);

		qry.addEntity("aa", Activity.class);
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setInteger("max_rownum", max_rownum);
		qry.setInteger("idEs", idEs);
		List list = qry.list();

		
		return extractJoinedActivity(list);
	}*/
	
	public List findAllActiveTasksByRange(int offset, int range, String matLennt, int idEs, String state, Date expectedDate) throws Exception {
		StringBuffer query = new StringBuffer("SELECT * "); 
		query.append("FROM (SELECT A.*, ROWNUM RNUM ");  			    
		query.append("FROM (SELECT MA.* ");
		query.append("FROM MGCF_ACTIVITY MA ");
		query.append("WHERE MA.ID_REQUEST IN (SELECT MRA.ID_REQUEST FROM MGCF_REQUEST_ASSOCIATION MRA, MGCF_METERS ME ");
		query.append(" WHERE MRA.ID_ES = :id_es AND ME.ID_REQUEST=MRA.ID_REQUEST AND ME.METER_ID like :matLennt) " );
		query.append(" AND MA.STATE NOT IN('Distacco Annullato','Cancelled by SIU') ");
		
		if(state!=null && !state.equals(StringConstants.EMPTY_STRING) && !state.equalsIgnoreCase("all active") ) {
			query.append("AND MA.STATE='"+state+"' ");
		}
		
		if(expectedDate!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			query.append("AND MA.EXPECTED_DATE >= TO_DATE('"+sdf.format(expectedDate)+"','yyyymmdd')");
		}
		
				  			    
		query.append(") A WHERE ROWNUM <= :range ) ");  			    
		query.append("WHERE RNUM  > :offset");
		
		SQLQuery qry=getSession().createSQLQuery(query.toString());
		qry.addEntity(Activity.class);
		qry.setInteger("id_es", idEs);
		qry.setInteger("range", range);
		qry.setInteger("offset", offset);
		qry.setString("matLennt","%"+matLennt+"%");
		List list=qry.list();
		
		return list;
	}
	
	
	
	public List findAllTasksByRange(int offset, int range, int idEs, boolean isLenntcomm) throws Exception {
		StringBuffer query = new StringBuffer(NATIVE_QUERY_ALL_TASK_BY_RANGE); 
		
				  			    
		query.append(") A WHERE ROWNUM <= :range ) ");  			    
		query.append("WHERE RNUM  > :offset");
		
		SQLQuery qry=getSession().createSQLQuery(query.toString());
		qry.addEntity(Activity.class);
		qry.setString("lenntcom", isLenntcomm?"Y":"N");
		qry.setInteger("id_es", idEs);
		qry.setInteger("range", range);
		qry.setInteger("offset", offset);
		List list=qry.list();
		
		return list;
	}
	
	public Activity[] findByState(int idEs,String state,int max_rownum) {
		ArgumentsCheckerUtil.checkString(state);
		
		SQLQuery qry=getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_BY_STATE);

		qry.addEntity("aa", Activity.class);
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setString("state", state);
		qry.setInteger("idEs", idEs);
		qry.setInteger("max_rownum", max_rownum);
		return extractJoinedActivity(qry.list());
	}
	
	
	public Activity[] findByState(int idEs,String state, long offset_min, int max_rownum ) {
		ArgumentsCheckerUtil.checkString(state);
		
		SQLQuery qry=getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_BY_STATE_WITH_OFFSET);
		qry.addEntity("aa", Activity.class);
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setString("state", state);
		qry.setInteger("max_rownum", max_rownum);
		qry.setLong("offset_min", offset_min);
		qry.setInteger("idEs", idEs);
		List list=qry.list();
		
		return extractJoinedActivity(list);
	}
	
	public int recovery(){
		StringBuffer query = new StringBuffer("update Activity set state='Ready' where ");
		query.append("state='In Progress' or state='waitRead'");

		Query qry = getSession().createQuery(query.toString());

		return qry.executeUpdate();
	}
	
	
	/**
	 * It finds instances of class Activity using passed parameters.<br/> All the parameters will
	 * be included in the query if they are not null and not empty
	 * @param keyint
	 * @param codpos
	 * @param dataPrev
	 * @return
	 */
	public Activity[] findByTaskIdLocIDExpDt(int idEs,String taskId, String codpos, Date dataPrev){
		return findByTaskIdLocIDExpDtTaskType(idEs,taskId, codpos,dataPrev, null,null);
	}
	
	public Activity[] findByTaskIdLocIDExpDtState(int idEs,String taskId, String codpos, Date dataPrev,String state){
		return findByTaskIdLocIDExpDtTaskType(idEs,taskId, codpos,dataPrev, null,state);
	}

	/**
	 * It finds instances of class Activity using passed parameters.<br/> All the parameters will
	 * be included in the query if they are not null and not empty
	 * @param taskId
	 * @param locationId
	 * @param expectedDate
	 * @param taskTypeId
	 * @return
	 */

	public Activity[] findByTaskIdLocIDExpDtTaskType(int idEs,String taskId, String locationId,  Date expectedDate, String taskTypeId, String state) {

		Activity[] ret = null;

		boolean k = taskId != null && !taskId.equals(StringConstants.EMPTY_STRING);
		boolean c = locationId != null && !locationId.equals(StringConstants.EMPTY_STRING);		
		boolean t = taskTypeId != null && !taskTypeId.equals(StringConstants.EMPTY_STRING);
		boolean s = state != null && !state.equals(StringConstants.EMPTY_STRING);
		boolean d = expectedDate != null;
		String str_and = "and ";

		StringBuffer query = new StringBuffer("select act from Activity act where act.requestAssociation.externalSystem.idEs=:idEs and ");
		
		

		// if
		if (k) {
			query.append("act.requestAssociation.taskId = :taskId and ");
		}
		if (c) {
			query.append("act.locationId = :locationId and ");
		}

		if (d) {
			query.append("act.expectedDate = :expectedDate and ");
		}

		if(t){
			query.append("act.taskTypeId = :taskTypeId");
		}
		if(s){
			query.append("act.state = :state");
		}
		if (query.toString().endsWith(str_and)) {
			int app = query.lastIndexOf(str_and);
			query.replace(app, app + 4, StringConstants.EMPTY_STRING);
		}

		Query hquery = getSession().createQuery(query.toString());

		hquery.setInteger("idEs", idEs);
		
		if (k) {
			hquery.setString("taskId", taskId);
		}
		if (c) {
			hquery.setString("locationId", locationId);
		}
		if (d) {
			//SimpleDateFormat formatter = new SimpleDateFormat(StringConstants.DATE_FORMAT);
			hquery.setDate("expectedDate", expectedDate);
		}
		if(t){
			hquery.setString("taskTypeId", taskTypeId);
		}
		
		if(s){
			hquery.setString("state", state);
		}

		List list = hquery.list();

		if (list == null) {
			ret = new Activity[0];

		} else {
			ret = new Activity[list.size()];
			ret = (Activity[]) list.toArray(ret);
		}
		return ret;

	}
	
	/**
	 * Finds Activities that can be referred to a subscriptionId. It joins the Activity with the Subscription.
	 * It returns an empty array or an ordered array, ordered by idRequest descending. 
	 * @param subscriptionId
	 * @return
	 */
	public Activity[] findBySubscriptionId(String subscriptionId){
		ArgumentsCheckerUtil.checkNull(subscriptionId, "subscriptionId");
		SQLQuery qry=getSession().createSQLQuery(NATIVE_QUERY_FIND_BY_SUB_ID);
		
		qry.setString("subscriptionId", subscriptionId);
		qry.addEntity(Activity.class);
		
		List list=qry.list();
		Activity[] ret = extractJoinedActivity(list);		
		return ret;
	}
	                
	public ActivityCountState[] countStates(int idEs,String taskTypeId, Date expectedDate ){
		
		ActivityCountState[] ret=null;
		
		
		boolean t=taskTypeId!=null && !taskTypeId.equals(StringConstants.EMPTY_STRING);
		boolean d=expectedDate!=null;
		
		StringBuffer query= new StringBuffer(QUERY_COUNT);
		query.append(" where a.requestAssociation.externalSystem.idEs=:idEs ");
		
		
		if(t || d){			
			
			if(d){
				query.append(" and a.expectedDate=:expectedDate");
			}
			if(t){
				query.append(" and a.taskTypeId=:taskTypeId");
				
			}
			
			

		}
		
		query.append(" group by a.state");
		
		Query hQuery=getSession().createQuery(query.toString());
		hQuery.setInteger("idEs", idEs);
		
		if(t){
			hQuery.setString("taskTypeId", taskTypeId);
		}
		
		if(d){
			hQuery.setDate("expectedDate", expectedDate);
		}
		
		List list= hQuery.list();
		
		if(list!=null && list.size()>0){
			ret= new ActivityCountState[list.size()];
			Iterator iter= list.iterator();
			for(int i=0;iter.hasNext();i++){
				Object[] curr= (Object[])iter.next();
				ret[i]= new ActivityCountState();				
				ret[i].state=(String) curr[0];
				ret[i].count=((Long) curr[1]).longValue();
			}
		}else{
			ret= new ActivityCountState[0];
		}
		
		
		return ret;
	}
	
	public Activity getLastExecutedByLocationId(int id_es, String locationId){
		SQLQuery qry= getSession().createSQLQuery(NATIVE_QUERY_ATTIVITA_ESEGUITE_BY_LOCATION_ID);
		qry.addEntity("aa", Activity.class);		
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.addJoin("dd", "cc.requestType");
		qry.setInteger("id_es", id_es);
		qry.setString("locationId", locationId);
		
		Activity[] app=extractJoinedActivity(qry.list());
		
		return app.length>0?app[0]:null; 
	}
	
	public Activity[] getSuspendedActivities(int idEs){
		SQLQuery qry= getSession().createSQLQuery(NATIVE_QUERY_SUSPENDED_ACTIVITIES);
		qry.addEntity("aa", Activity.class);		
		qry.addJoin("cc", "aa.requestAssociation");
		qry.addJoin("bb", "cc.externalSystem");
		qry.setInteger("idEs", idEs);
		
		return extractJoinedActivity(qry.list());
	}

    public Activity[] getSuspendedActivitiesLorenzo(int idEs){
        SQLQuery qry= getSession().createSQLQuery(NATIVE_QUERY_SUSPENDED_ACTIVITIES_LOR);
        qry.addEntity("aa", Activity.class);
        qry.setInteger("idEs", idEs);

        List<Activity> list = qry.list();

        Activity[] ret= new Activity[list.size()];
        ret = (Activity[]) list.toArray(ret);

        return ret;
    }
	
	public Activity[] findInRecovering(int idEs){
		Query qry=getSession().createQuery(QUERY_RECOVERY);
		qry.setInteger("idEs", idEs);
	
		List list=qry.list();
		Activity[] ret = null;		
		
		if (list == null) {
			ret = new Activity[0];

		} else {
			ret = new Activity[list.size()];
			ret = (Activity[]) list.toArray(ret);
		}
		return ret;
	}
	
	
	public List findByCriteriaNotPaged(ActivityCriteriaBO criteriaBO) {
		
		SQLQuery qry = getSession().createSQLQuery(buildQueryAttivitaByCriteria(criteriaBO, false));

		qry.addEntity("aa", Activity.class);
		qry.addJoin("rap", "aa.requestAssociation");
		qry.addJoin("es", "rap.externalSystem");
		qry.addJoin("rt", "rap.requestType");
		
		qry.addEntity("mm", Meter.class);

		qry.setInteger("idEs", criteriaBO.getIdEs());
		
		if(criteriaBO.getBeginDate()!=null) {
			qry.setDate("beginDate", criteriaBO.getBeginDate());
		}
		if(criteriaBO.getEndDate()!=null) {
			qry.setDate("endDate", criteriaBO.getEndDate());
		}
		
		return qry.list();
	}
	
	
	public long countActivityByCriteria(ActivityCriteriaBO criteriaBO) {
		
		SQLQuery qry = getSession().createSQLQuery(buildQueryAttivitaByCriteria(criteriaBO, true));

		qry.setInteger("idEs", criteriaBO.getIdEs());
		
		if(criteriaBO.getBeginDate()!=null) {
			qry.setDate("beginDate", criteriaBO.getBeginDate());
		}
		if(criteriaBO.getEndDate()!=null) {
			qry.setDate("endDate", criteriaBO.getEndDate());
		}
		
		qry.addScalar("c", Hibernate.LONG);
		
		Long res  = (Long)qry.uniqueResult();	
		
		return res!=null?res.longValue():0;
	}
	
	private String buildQueryAttivitaByCriteria(ActivityCriteriaBO criteriaBO, boolean isForCount){
		
		ArgumentsCheckerUtil.checkNull(criteriaBO);
		
		StringBuffer sb = new StringBuffer();
		
		if(isForCount){			
			sb.append("select count(*) as c from ( ");			
		}
		
		sb.append(NATIVE_QUERY_ATTIVITA_BY_CRITERIA_NOT_PAGED);
		
		if(criteriaBO.getBeginDate()!=null) {
			sb.append(" and aa.expected_date>= :beginDate");
		}
		if(criteriaBO.getEndDate()!=null) {
			sb.append(" and aa.expected_date<= :endDate");
		}
		if(criteriaBO.getState()!=null && criteriaBO.getState().length()>0) {
			sb.append(" and aa.state = '"+criteriaBO.getState()+"'");
		}
		if(criteriaBO.getCodPos()!=null && criteriaBO.getCodPos().length()>0) {
			sb.append(" and aa.location_id like '"+criteriaBO.getCodPos()+"'");
		}
		if(criteriaBO.getMeterId()!=null && criteriaBO.getMeterId().length>0) {
			sb.append(" and ( ");
			for(int i=0;i<criteriaBO.getMeterId().length;i++){
				sb.append(" mm.meter_id = '"+criteriaBO.getMeterId()[i]+"'");
				if(i<criteriaBO.getMeterId().length-1)
					sb.append(" or ");
			}
			sb.append(" ) ");
		}
		
		if(isForCount){			
			sb.append(" ) ");			
		}
		
		return sb.toString();
		
	}
	
	
	  public List<ActivityThor> findThorActivityByTaskIdAndIdMeter(int idEs, String TaskId, String ThorState, String thorIdMeter){
	    StringBuffer sqlThorActivity = new StringBuffer();
	    sqlThorActivity.append(" SELECT R.TASK_ID as thorCode, R.ID_REQUEST as idRequest, T.METER as idMeter, A.TASKSTATE_ID as taskStateID, A.TASKTYPE_ID as taskTypeID, ");
	    sqlThorActivity.append(" A.EXPECTED_DATE as expectedDate, A.INSERT_DATE as insertDate, A.LOCATION_ID as locationID, A.ERROR_CODE as errorCode, A.STATE as state ");
	    sqlThorActivity.append(" FROM GCF_REQUEST_ASSOCIATION R, GCF_ACTIVITY A, THOR_PCL_REQUEST T ");
	    
	    sqlThorActivity.append(" WHERE ");
	    if ((TaskId != null) && (!TaskId.equals("")))
	    {
	      sqlThorActivity.append(" (R.TASK_ID LIKE '__' || :ID_TASK ");
	      sqlThorActivity.append(" OR R.TASK_ID LIKE '__' || :ID_TASK || 'R' ");
	      sqlThorActivity.append(" OR R.TASK_ID LIKE '__' || :ID_TASK || 'S' ");
	      sqlThorActivity.append(" OR R.TASK_ID = :ID_TASK ) ");
	    }
	    if ((thorIdMeter != null) && (!thorIdMeter.equals("")))
	    {
	      if ((TaskId != null) && (!TaskId.equals(""))) {
	        sqlThorActivity.append(" AND ");
	      }
	      sqlThorActivity.append(" T.METER = :ID_METER ");
	    }
	    if (((TaskId != null) && (!TaskId.equals(""))) || ((thorIdMeter != null) && (!thorIdMeter.equals("")))) {
	      sqlThorActivity.append(" AND ");
	    }
	    sqlThorActivity.append(" R.ID_REQUEST = T.ID_REQUEST ");
	    sqlThorActivity.append(" AND R.ID_REQUEST = A.ID_REQUEST ");
	    sqlThorActivity.append(" AND UPPER(A.STATE) = UPPER(:THOR_STATE) ");
	    sqlThorActivity.append(" AND t.DELETED = 0 ");
	    
	    logger.debug("sqlThorActivity : " + sqlThorActivity.toString());
	    
	    SQLQuery qry = getSession().createSQLQuery(sqlThorActivity.toString());
	    if ((TaskId != null) && (!TaskId.equals("")))
	    {
	      qry.setString("ID_TASK", TaskId);
	      logger.debug("ID_TASK : " + TaskId);
	    }
	    if ((thorIdMeter != null) && (!thorIdMeter.equals("")))
	    {
	      qry.setString("ID_METER", thorIdMeter);
	      logger.debug("ID_METER : " + thorIdMeter);
	    }
	    qry.setString("THOR_STATE", ThorState);
	    logger.debug("THOR_STATE : " + ThorState);
	    
	    qry.addScalar("thorCode", Hibernate.STRING);
	    qry.addScalar("idRequest", Hibernate.LONG);
	    qry.addScalar("idMeter", Hibernate.STRING);
	    qry.addScalar("taskStateID", Hibernate.STRING);
	    qry.addScalar("taskTypeID", Hibernate.STRING);
	    qry.addScalar("expectedDate", Hibernate.DATE);
	    qry.addScalar("insertDate", Hibernate.DATE);
	    qry.addScalar("locationID", Hibernate.STRING);
	    qry.addScalar("errorCode", Hibernate.STRING);
	    qry.addScalar("state", Hibernate.STRING);
	    
	    qry.setResultTransformer(Transformers.aliasToBean(ActivityThor.class));
	    
	    List<ActivityThor> listaActivityThor = null;
	    listaActivityThor = qry.list();
	    logger.debug("listaThorActivity : " + listaActivityThor.toString());
	    logger.info("listaThorActivity.size() : " + listaActivityThor.size());
	    
	    return listaActivityThor;
	  }
	  
	public boolean updateActivityThor(int idEs, long idRequest, String newState, String oldState) throws HibernateException, Exception{
	    Activity activity = getById(idRequest);
	    activity.setState(newState);
	    
	    ArgumentsCheckerUtil.checkNull(activity);
	    getSession().update(activity);
	    return true;
	}
	  
	public boolean updateThorPclRequest(int idEs, long idRequest) throws HibernateException, Exception{
		int executeUpdate;
		StringBuffer updateThorActivity;
		//PreparedStatement ps;
		executeUpdate = 0;

		updateThorActivity = new StringBuffer((new StringBuilder(" UPDATE THOR_PCL_REQUEST set DELETED = 1 WHERE ID_REQUEST = ")).append(idRequest).toString());
		logger.debug((new StringBuilder("SQL UPDATE: ")).append(updateThorActivity.toString()).toString());
		
	    try{
	    	getSession().doWork(conn->{
	    		try(PreparedStatement ps = conn.prepareStatement(updateThorActivity.toString())) {
	    			ps.executeUpdate();
		    	}
	    		catch(Throwable t) {
	    			logger.error(t.getMessage(), t);
	    			throw new RuntimeException(t);
	    		}
	    	});
	    	
	        executeUpdate = 1;
	        
	    }catch(HibernateException e){
	        logger.error(e.getMessage(), e);
	        throw e;
	    }catch(Throwable t){
	        logger.error(t.getMessage(), t);
	        throw new Exception(t.getMessage(),t);
	    }
	    return executeUpdate == 1;
	}

	public void restoreWaitingThor() throws HibernateException, Exception{
		try {
			sm.getSession().doWork(connection->{
				try (CallableStatement cs = connection.prepareCall(PROCEDURE_RECOVERY_WAITING_ACTIVITIES)) {
					
					cs.setLong(1, System.currentTimeMillis());
					cs.executeUpdate();
				}
				catch (Throwable t) {
			    	logger.error("Error while close db session;"+t.getMessage());
			    	throw new RuntimeException(t.getMessage(),t);
			    }
			});
		} catch (HibernateException e) {
			throw e;
		} catch (Throwable t) {
			
			throw new Exception(t.getMessage(),t);
		}
		
	}
}
