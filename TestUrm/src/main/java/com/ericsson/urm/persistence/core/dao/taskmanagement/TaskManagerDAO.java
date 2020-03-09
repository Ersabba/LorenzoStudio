package com.ericsson.urm.persistence.core.dao.taskmanagement;

import com.ericsson.mgre.biz.taskMgmt.task.dto.TaskDto;
import com.ericsson.urm.core.datatype.GreBlobType;
import com.ericsson.urm.core.datatype.TaskDetail;
import com.ericsson.urm.core.taskmanagement.TaskStatus;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.dao.GenericDAO;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import java.util.List;

public class TaskManagerDAO extends GenericDAO {

    private static String QUERY_GRE_TASKS;
    private static String QUERY_URM_TASK;
    private static String QUERY_URM_ACTIVITY;

    static {//CAST((FROM_TZ(expectedstartdate, 'UTC') AT LOCAL) AS TIMESTAMP)

        StringBuffer sb = new StringBuffer();
        sb.append("                 SELECT 'GRE_TASKS' as origin,                                                                            \n");
        sb.append("                        t2.code as taskCode,                                                                              \n");
        sb.append("                        t2.DESCRIPTION as taskDescription,                                                                \n");
        sb.append("                        t2.PERIOD as period,                                                                              \n");
        sb.append("                        T.ID as taskId,                                                                                   \n");
        sb.append("                        T.STATE as taskState,                                                                             \n");
        sb.append("                        CASE T.EXPECTEDSTARTTIME                                                                          \n");
        sb.append("                            WHEN 0                                                                                        \n");
        sb.append("                                THEN NULL                                                                                 \n");
        sb.append("                            ELSE                                                                                          \n");
        sb.append("                                CAST((FROM_TZ(                                                                            \n");
        sb.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                       \n");
        sb.append("                                + NUMTODSINTERVAL( T.EXPECTEDSTARTTIME / 1000, 'SECOND' )                                 \n");
        sb.append("                                , 'UTC') AT LOCAL) AS TIMESTAMP)                                                          \n");
        sb.append("                        END as expectedStartDate,                                                                         \n");
        sb.append("                        case T.STARTTIME                                                                                  \n");
        sb.append("                            WHEN 0                                                                                        \n");
        sb.append("                                THEN NULL                                                                                 \n");
        sb.append("                            ELSE                                                                                          \n");
        sb.append("                                CAST((FROM_TZ(                                                                            \n");
        sb.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                       \n");
        sb.append("                                + NUMTODSINTERVAL( T.STARTTIME / 1000, 'SECOND' )                                         \n");
        sb.append("                                , 'UTC') AT LOCAL) AS TIMESTAMP)                                                          \n");
        sb.append("                        END as startDate,                                                                                 \n");
        sb.append("                        CASE                                                                                              \n");
        sb.append("                             WHEN T.STATE = 'IDLE' or T.STATE = 'SCHEDULED' or T.STATE = 'RUNNING'                        \n");
        sb.append("                                     or T.STATE = 'CANCELLED' or T.LASTSTATEUPDATETIME = 0                                \n");
        sb.append("                                THEN NULL                                                                                 \n");
        sb.append("                             ELSE                                                                                         \n");
        sb.append("                                CAST((FROM_TZ(                                                                            \n");
        sb.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                       \n");
        sb.append("                                + NUMTODSINTERVAL( T.LASTSTATEUPDATETIME / 1000, 'SECOND' )                               \n");
        sb.append("                                , 'UTC') AT LOCAL) AS TIMESTAMP)                                                          \n");
        sb.append("                        END as endDate,                                                                                   \n");
        sb.append("                        T.TARGETS as targets,                                                                             \n");
        sb.append("                        T.TARGETTYPE as targetType,                                                                       \n");
        sb.append("                        NULL as chronScheduling                                                                           \n");
        sb.append("                   FROM ACTIVITIES t2, TASKS T                                                                            \n");
        sb.append("                  WHERE t2.CODE = T.ACTIVITYCODE                                                                          \n");

        QUERY_GRE_TASKS =sb.toString();

        sb = new StringBuffer();

        sb.append("                 SELECT 'URM_TASK' as origin,                                                                              \n");
        sb.append("                        t1.code as taskCode,                                                                               \n");
        sb.append("                        t1.description as taskDescription,                                                                 \n");
        sb.append("                        null as period,                                                                                    \n");
        sb.append("                        t2.id as taskId,                                                                                   \n");
        sb.append("                        CASE                                                                                               \n");
        sb.append("                         WHEN t2.status = 'NEW' THEN 'IDLE'                                                                \n");
        sb.append("                         WHEN t2.status = 'FINISHED' and (t2.subtask_failed = 0 or t2.subtask_failed is null)              \n");
        sb.append("												THEN 'COMPLETED'                                                              \n");
        sb.append("                         WHEN t2.status = 'FINISHED' and t2.tot_subtask is not null and t2.subtask_failed != 0             \n");
        sb.append("												THEN 'COMPLETED_WITH_ERRORS'                                                  \n");
        sb.append("                         ELSE t2.status                                                                                    \n");
        sb.append("                        END as taskState,                                                                                  \n");
        sb.append("                        t2.start_date as expectedStartDate,                                                                \n");
        sb.append("                        t2.start_date as startDate,                                                                        \n");
        sb.append("                        t2.end_date as endDate,                                                                            \n");
        sb.append("                        NULL as targets,                                                                                   \n");
        sb.append("                        NULL as targetType,                                                                                \n");
        sb.append("                        NULL as chronScheduling                                                                            \n");
        sb.append("                   FROM urm_activity_type t1, urm_task t2                                                                  \n");
        sb.append("                  WHERE t1.code = t2.code and t1.code!='A149'                                                              \n");


        QUERY_URM_TASK = sb.toString();

        sb = new StringBuffer();

        sb.append("                 select 'URM_ACTIVITY' as origin,                                              \n");
        sb.append("                        t2.code as taskCode,                                                   \n");
        sb.append("                        t2.description as taskDescription,                                     \n");
        sb.append("                        null as period,                                                        \n");
        sb.append("                        null as taskId,                                                        \n");
        sb.append("                        'SCHEDULED' as taskState,                                              \n");
        sb.append("                        null  as expectedStartDate,                                            \n");
        sb.append("                        null as startDate,                                                     \n");
        sb.append("                        null as endDate,                                                       \n");
        sb.append("                        NULL as targets,                                                       \n");
        sb.append("                        NULL as targetType,                                                    \n");
        sb.append("                        t1.chron_scheduling as chronScheduling                                 \n");
        sb.append("                   FROM urm_activity t1, urm_activity_type t2                                  \n");
        sb.append("                  WHERE t2.code = t1.code                                                      \n");
        sb.append("                    AND t2.enabled = 'Y'                                                       \n");
        sb.append("                    AND t1.suspended = 'N'                                                     \n");
        sb.append("                    AND t1.chron_scheduling is not null                                        \n");
        sb.append("                    AND NOT EXISTS(SELECT 1                                                    \n");
        sb.append("                                     FROM urm_task t3                                          \n");
        sb.append("                                    WHERE t2.code = t3.code                                    \n");
        sb.append("                                      AND t3.status = 'RUNNING')                               \n");

        QUERY_URM_ACTIVITY = sb.toString();
    }

    public TaskManagerDAO(HibernateSessionManagement sm) {
        super(sm);
    }

    public String buildQueryAll(){

        StringBuffer query2 = new StringBuffer("");

        query2.append("SELECT *  									");
        query2.append("FROM   (                                     ");
        query2.append("         SELECT A.*,                         ");
        query2.append("                rownum rnum                  ");
        query2.append("         FROM (                              ");
        query2.append("                 SELECT 'GRE_TASKS' as origin,                                                                             ");
        query2.append("                        ACT.CODE as taskCode,                                                                              ");
        query2.append("                        ACT.DESCRIPTION as taskDescription,                                                                ");
        query2.append("                        ACT.PERIOD as period,                                                                              ");
        query2.append("                        T.ID as taskId,                                                                                    ");
        query2.append("                        T.STATE as taskState,                                                                              ");
        query2.append("                        CASE T.EXPECTEDSTARTTIME                                                                           ");
        query2.append("                            WHEN 0                                                                                         ");
        query2.append("                                THEN NULL                                                                                  ");
        query2.append("                            ELSE                                                                                           ");
        query2.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                        ");
        query2.append("                                + NUMTODSINTERVAL( T.EXPECTEDSTARTTIME / 1000, 'SECOND' )                                  ");
        query2.append("                        END as expectedStartDate,                                                                          ");
        query2.append("                        case T.STARTTIME                                                                                   ");
        query2.append("                            WHEN 0                                                                                         ");
        query2.append("                                THEN NULL                                                                                  ");
        query2.append("                            ELSE                                                                                           ");
        query2.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                        ");
        query2.append("                                + NUMTODSINTERVAL( T.STARTTIME / 1000, 'SECOND' )                                          ");
        query2.append("                        END as startDate,                                                                                  ");
        query2.append("                        case T.LASTSTATEUPDATETIME                                                                         ");
        query2.append("                            WHEN 0                                                                                         ");
        query2.append("                                THEN NULL                                                                                  ");
        query2.append("                            ELSE                                                                                           ");
        query2.append("                                TIMESTAMP '1970-01-01 00:00:00.000'                                                        ");
        query2.append("                                + NUMTODSINTERVAL( T.LASTSTATEUPDATETIME / 1000, 'SECOND' )                                ");
        query2.append("                        END as endDate,                                                                                    ");
        query2.append("                        T.TARGETS as targets,                                                                              ");
        query2.append("                        T.TARGETTYPE as targetType,                                                                        ");
        query2.append("                        NULL as chronScheduling                                                                            ");
        query2.append("                   FROM ACTIVITIES ACT, TASKS T                                                                            ");
        query2.append("                  WHERE ACT.CODE = T.ACTIVITYCODE                                                                          ");
        query2.append("                                                                                                                           ");
        query2.append("                UNION ALL                                                                                                  ");
        query2.append("                                                                                                                           ");
        query2.append("                 SELECT 'URM_TASK' as origin,                                                                              ");
        query2.append("                        t1.code as taskCode,                                                                               ");
        query2.append("                        t1.description as taskDescription,                                                                 ");
        query2.append("                        null as period,                                                                                    ");
        query2.append("                        t2.id as taskId,                                                                                   ");
        query2.append("                        CASE                                                                                               ");
        query2.append("                         WHEN t2.status = 'NEW' THEN 'IDLE'                                                                ");
        query2.append("                         WHEN t2.status = 'FINISHED' and (t2.subtask_failed = 0 or t2.subtask_failed is null)              ");
        query2.append("												THEN 'COMPLETED'                                                             ");
        query2.append("                         WHEN t2.status = 'FINISHED' and t2.tot_subtask is not null and t2.subtask_failed != 0             ");
        query2.append("												THEN 'COMPLETED_WITH_ERRORS'                                                 ");
        query2.append("                         ELSE t2.status                                                                                    ");
        query2.append("                        END as taskState,                                                                                  ");
        query2.append("                        t2.start_date as expectedStartDate,                                                                ");
        query2.append("                        t2.start_date as startDate,                                                                        ");
        query2.append("                        t2.end_date as endDate,                                                                            ");
        query2.append("                        NULL as targets,                                                                           ");
        query2.append("                        NULL as targetType,                                                                                ");
        query2.append("                        NULL as chronScheduling                                                                            ");
        query2.append("                   FROM urm_activity_type t1, urm_task t2                                                                  ");
        query2.append("                  WHERE t1.code = t2.code                                                                                  ");
        query2.append("                                                                                                                           ");
        query2.append("                  UNION ALL                                                                                                ");
        query2.append("                                                                                                                           ");
        query2.append("                 select 'URM_ACTIVITY' as origin,                                                                          ");
        query2.append("                        t2.code as taskCode,                                                                               ");
        query2.append("                        t2.description as taskDescription,                                                                 ");
        query2.append("                        null as period,                                                                                    ");
        query2.append("                        null as taskId,                                                                                    ");
        query2.append("                        'SCHEDULED' as taskState,                                                                          ");
        query2.append("                        null  as expectedStartDate,                                                                        ");
        query2.append("                        null as startDate,                                                                                 ");
        query2.append("                        null as endDate,                                                                                   ");
        query2.append("                        EMPTY_BLOB() as targets,                                                                           ");
        query2.append("                        NULL as targetType,                                                                                ");
        query2.append("                        t1.chron_scheduling as chronScheduling                                                             ");
        query2.append("                   FROM urm_activity t1, urm_activity_type t2                                                              ");
        query2.append("                  WHERE t2.code = t1.code                                                                                  ");
        query2.append("                    AND t2.enabled = 'Y'                                                                                   ");
        query2.append("                    AND t1.suspended = 'N'                                                                                 ");
        query2.append("                    AND t1.chron_scheduling is not null                                                                    ");
        query2.append("                    AND NOT EXISTS(SELECT 1                                                                                ");
        query2.append("                                     FROM urm_task t3                                                                      ");
        query2.append("                                    WHERE t2.code = t3.code                                                                ");
        query2.append("                                      AND t3.status = 'RUNNING')                                                           ");
        query2.append("                                                                                                                           ");
        query2.append("                ORDER BY endDate desc NULLS LAST, startDate desc NULLS LAST) A                                             ");
        query2.append("        WHERE rownum <= :range) B            ");
        query2.append("WHERE rnum > :start                          ");

        return query2.toString();

    }

    private String getWhereCondGreTasks(String code, String status){

        String codeCondition = null;
        String statusCondition = null;
        StringBuffer sb = new StringBuffer();
        sb.append(getWhereMultipleCodes(code));

        if(status!=null && !status.isEmpty()){
            statusCondition = " and t.state  = :status ";
            sb.append(statusCondition);
        }

        return sb.toString();
    }

    private String getWhereCondUrmTask(String code, String status){

        String statusCondition = null;
        String additionalCondition = null;
        StringBuffer sb = new StringBuffer();

        sb.append(getWhereMultipleCodes(code));

        if(status!=null && !status.isEmpty()){

            if(TaskDto.State.parse(status).equals(TaskDto.State.IDLE)){
                statusCondition = " t2.status = '"+TaskStatus.NEW.toString()+"'";
            }else if(TaskDto.State.parse(status).equals(TaskDto.State.COMPLETED)){
                // FINISHED(true) con subtask valorizzati e subtask failed = 0
                statusCondition = " t2.status = '"+TaskStatus.FINISHED.toString()+"'";
                additionalCondition = " and tot_subtask is not null "
                        +" and subtask_failed = 0 ";
            }else if(TaskDto.State.parse(status).equals(TaskDto.State.COMPLETED_WITH_ERRORS)){
                // FINISHED(true) subtask valorizzati e subtask failed != 0
                statusCondition = " t2.status = '"+ TaskStatus.FINISHED.toString()+"'";
                additionalCondition = " and tot_subtask is not null "
                        +" and subtask_failed != 0 ";
            }else{
                statusCondition = " t2.status = '"+status+"'";
            }

            sb.append(" and ");
            sb.append(statusCondition);

            if(additionalCondition!=null && !additionalCondition.isEmpty()){
                sb.append(additionalCondition);
            }
        }

        return sb.toString();
    }

    private String getWhereMultipleCodes(String code){

        String ret="";
        StringBuffer sqlCondition;

        if((code!=null && !code.isEmpty())) {
            if (code.indexOf("|") == -1)
                ret = " and t2.code = :code ";
            else{
                String codes[] = code.split("\\|");
                sqlCondition = new StringBuffer("and t2.code in (");

                for(int i=0; i<codes.length ;i++)
                    sqlCondition.append("'"+codes[i]+"',");

                sqlCondition.deleteCharAt(sqlCondition.length() - 1);
                sqlCondition.append(")");

                ret = sqlCondition.toString();
            }
        }
        else
            ret ="";

        return ret;
    }

    private String buildQueryTaskDetailsNew(String taskCode, String status){

        String  whereCondGreTasks="";
        String  whereCondUrmTask="";
        String whereCondUrmActivity="";

        StringBuffer query3 = new StringBuffer("");

        if(status==null || status.isEmpty() || !status.equals(TaskDto.State.SCHEDULED.toString()))
            whereCondUrmTask = getWhereCondUrmTask(taskCode, status);

        whereCondGreTasks = getWhereCondGreTasks(taskCode, status);
        whereCondUrmActivity = getWhereMultipleCodes(taskCode);

        System.out.println("Condizione Where del GRE:"+whereCondGreTasks);
        System.out.println("Condizione Where del CORE:"+whereCondUrmTask);
        System.out.println("Condizione Where di ACTIVITY:"+whereCondUrmActivity);

        query3.append("SELECT *  									                                    ");
        query3.append("FROM   (                                                                         ");
        query3.append("         SELECT A.*,                                                             ");
        query3.append("                rownum rnum                                                      ");
        query3.append("         FROM (                                                                  ");
        query3.append(QUERY_GRE_TASKS);
        query3.append(whereCondGreTasks);
        if(status!=null && !status.isEmpty() && status.equals(TaskDto.State.SCHEDULED.toString())) {
            query3.append("                UNION ALL                                                        ");
            query3.append(QUERY_URM_ACTIVITY);
            query3.append(whereCondUrmActivity);
        }
        else {
            query3.append("                UNION ALL                                                        ");
            query3.append(QUERY_URM_TASK);
            query3.append(whereCondUrmTask);
        }
        query3.append("                ORDER BY endDate desc NULLS LAST, startDate desc NULLS LAST) A   ");
        query3.append("        WHERE rownum <= :range) B                                                ");
        query3.append("WHERE rnum > :start                                                              ");

        System.out.println("Inizio Query \n");
        System.out.println(query3.toString());
        System.out.println("Fine Query \n");

        return query3.toString();

    }



    public List<TaskDetail> loadTaskDetails(String taskCode, String status, int start, int range){

        System.out.println("TaskCode: "+taskCode);
        System.out.println("Status: "+status);
        System.out.println("Start: "+start);
        System.out.println("Range: "+range);

        String queryTasksJsp = buildQueryTaskDetailsNew(taskCode,status);

        SQLQuery qry = getSession().createSQLQuery(queryTasksJsp);

        if(taskCode!=null && !taskCode.isEmpty() && taskCode.indexOf("|")==-1)
            qry.setString("code", taskCode);

        if(status!=null && !status.isEmpty())
            qry.setString("status", status);

        qry.setInteger("start", start);
        qry.setInteger("range", range);

        qry.addScalar("origin", Hibernate.STRING)
                .addScalar("taskCode", Hibernate.STRING)
                .addScalar("taskDescription", Hibernate.STRING)
                .addScalar("period", Hibernate.STRING)
                .addScalar("taskId", Hibernate.LONG)
                .addScalar("taskState", Hibernate.STRING)
                .addScalar("expectedStartDate", Hibernate.TIMESTAMP)
                .addScalar("startDate", Hibernate.TIMESTAMP)
                .addScalar("endDate", Hibernate.TIMESTAMP)
                .addScalar("targets", new GreBlobType())
                .addScalar("targetType", Hibernate.STRING)
                .addScalar("chronScheduling", Hibernate.STRING);

        qry.setResultTransformer(Transformers.aliasToBean(TaskDetail.class));

        List<TaskDetail> result = qry.list();

        System.out.println("Risultato Trasformazione Query ("+result.size()+"):");

        for(TaskDetail taskDetail:result)
            System.out.println(taskDetail);

        System.out.println("Fine Risultato Trasformazione Query:");

        return result;

    }

    public String buildQueryTaskDetailsNoPage(String taskCode, String status, boolean isForCount){

        StringBuffer sb = new StringBuffer();
        String queryTaskDetails = null;
        String whereCondGreTasks = "";
        String whereCondUrmTask = "";

        if((taskCode!=null && !taskCode.isEmpty()) || (status!=null && !status.isEmpty())){
            whereCondGreTasks = "where " + getWhereCondGreTasks(taskCode, status).substring(5);
            whereCondUrmTask = "where " + getWhereCondUrmTask(taskCode, status).substring(5);
            whereCondGreTasks=whereCondGreTasks.replaceFirst("t2.code","t.activitycode");
        }

        sb = new StringBuffer();
        if(isForCount){
            sb.append(" select count(1) as num from \n");
            sb.append(" ( \n");
        }
        sb.append(" select t.id taskId, \n");
        sb.append("        t.expectedstarttime startTime, \n");
        sb.append("        'GRE_TASKS' origin \n");
        sb.append("   from gre_tasks t \n");
        sb.append(whereCondGreTasks);
        sb.append("  union \n");
        sb.append(" select t2.id taskId, \n");
        sb.append("        (t2.start_date - to_date('01-01-1970','DD-MM-YYYY'))*24*60*60*1000 startTime, \n");
        sb.append("        'URM_TASK' origin \n");
        sb.append("   from urm_task t2 \n");
        sb.append(whereCondUrmTask);
        sb.append("  order by 2 \n");
        if(isForCount){
            sb.append(" ) \n");
        }
        queryTaskDetails = sb.toString();

        return queryTaskDetails;
    }
}
