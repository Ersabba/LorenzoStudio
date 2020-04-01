package test;

import com.ericsson.communication.responsetype.Parser169File;
import com.ericsson.gestionesw.persistence.dto.Trps;
import com.ericsson.gestionesw.persistence.dto.TrpsId;
import com.ericsson.gestionesw.persistence.dto.datatype.TipoUsoRel;
import com.ericsson.mgre.biz.taskMgmt.activity.dto.ActivityDto;
import com.ericsson.mgre.biz.taskMgmt.task.dto.TaskDto;
import com.ericsson.mgre.webapp.taskAdmin.control.LinkEnablerUtil;
import com.ericsson.mgre.webapp.taskAdmin.view.TaskDetailsForm;
import com.ericsson.urm.core.datatype.TaskDetail;
import com.ericsson.urm.core.taskmanagement.TaskCode;
import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.core.dao.readings.AcqMultipleFileDAO;
import com.ericsson.urm.persistence.core.dao.taskmanagement.TaskManagerDAO;
import com.ericsson.urm.persistence.dao.gestionesw.TrpsDAO;
import com.ericsson.urm.persistence.dao.mgcf.DeviceReachabilityDAO;
import com.ericsson.urm.persistence.dao.mgcf.ReachabilityStatusDAO;
import com.ericsson.urm.persistence.dao.mgre.*;
import com.ericsson.urm.persistence.dto.mgcf.DeviceReachabilityStatus;
import com.ericsson.urm.persistence.dto.mgcf.ReachabilityStatistic;
import com.ericsson.urm.persistence.dto.mgre.*;
import com.ericsson.urm.util.DateUtil;
import com.ericsson.urm.util.FunctionUtil;
import weblogic.jms.extensions.Schedule;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        System.out.println("Maven + Hibernate + Oracle");

        // OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        /*AcqFileCcsDAO acqFileCcsDAO = new AcqFileCcsDAO(sm);

        Date dataAcquisizione = new GregorianCalendar(2016, Calendar.FEBRUARY, 18).getTime();
        String idConcentratore = "0508530013199";            // COD_CONCENTRATORE
        String fileName ="CCS/DATA/VI/G1413199.VI";                    // FILE_NAME

        System.out.println("Reperimento da DB riga data acq:" + dataAcquisizione + " idConc:"+idConcentratore+" fileName:"+fileName);

        AcqFileCcsId acqFileCcsId = new AcqFileCcsId(dataAcquisizione,idConcentratore,fileName);

        AcqFileCcs acqFileCcs = acqFileCcsDAO.getById(acqFileCcsId);

        System.out.println("Record trovato:"+acqFileCcs.toString());

        fileName="ADD03936.cfg";
        idConcentratore = "0506530003936";

        System.out.println("Reperimento da DB riga con file "+fileName+" e idconc:"+idConcentratore);

        acqFileCcs = acqFileCcsDAO.getLastFetchedFileByCcsIdAndFileName(idConcentratore,fileName);

        System.out.println("Record trovato:"+acqFileCcs.toString());

        String utenzaRadius="utenzaradius";
        idConcentratore="0504490000634";

        ConcentratoreDAO concentratoreDAO = new ConcentratoreDAO(sm);

        System.out.println("Aggiornamento status CCS rimossi per utenza radius "+utenzaRadius+" e CCS:"+idConcentratore);

        int recordAggiornati = concentratoreDAO.updateStatusCCSRimosso(utenzaRadius,idConcentratore);

        System.out.println("Record aggiornati:"+recordAggiornati);

        concentratoreDAO.closeTransaction();*/

        /* System.out.println("Maven + Hibernate + MySql");

        RadiusHibernateSessionManagement sm = new RadiusHibernateSessionManagement();

        RadiusDAO dao = new RadiusDAO(sm);

        String radiusUser="0506530003406";

        TestDto testDTO = dao.testMethod();

        System.out.println(" Info trovate per il test : "+testDTO);

        RadiusCMSInfoDTO radiusCMSInfoDTO = dao.getRadiusInfoByRadiusUsername2("0506530003406"); // 0506530003406
        radiusCMSInfoDTO.setUser("0506530003406");

        System.out.println(" Info trovate per il radius: "+radiusCMSInfoDTO);

        List<RadCheck> list = dao.getAllRadCheck();

        //for (RadCheck rc : list)
        System.out.println(list.get(0));


        dao.closeTransaction(); */

        //testTRPS();

        //testTables_CR52();

        //testDateHibernate();

        // testJDBCConnection();

        /*Vector<FileADD> vec = new Vector<FileADD>();


        FileADD fileADD = new FileADD();
        fileADD.setMtr("0505510001989");
        fileADD.setfase("T");
        vec.add(fileADD);

        fileADD = new FileADD();
        fileADD.setMtr("0506400211533");
        fileADD.setfase("T");
        vec.add(fileADD);

        fileADD = new FileADD();
        fileADD.setMtr("0506400221393");
        fileADD.setfase("R");
        vec.add(fileADD);

        Parser169File parser169File = new Parser169File();
        parser169File.setParVector(vec);


        String target="0506530003936";
        Date acqDate = new Date();

        updatePhaseMeters (parser169File,  target, acqDate );*/

        //testTimeZone();

        //testQueryTasksJsp();

        testCurrentTime();
    }

    static public void  testReachability(){

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        ReachabilityStatusDAO reachabilityStatusDAO = new ReachabilityStatusDAO(sm);

        DeviceReachabilityStatus deviceReachabilityStatus = reachabilityStatusDAO.getLast();

        System.out.println(" Info trovate per il test : "+deviceReachabilityStatus);

        //reachabilityStatusDAO.closeTransaction();


        DeviceReachabilityDAO deviceReachabilityDAO = new DeviceReachabilityDAO(sm);

        ReachabilityStatistic stat = deviceReachabilityDAO.getStatistics(1000);


        System.out.println("Statistiche:"+stat);

        deviceReachabilityDAO.closeTransaction();

    }

    static public void  testTRPS(){

        System.out.println("Maven + Hibernate + Oracle + Tabella TRPS");

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        TrpsDAO trpsDAO = new TrpsDAO(sm);

       //List<Trps> list = trpsDAO.getAll();

        /* for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getAllViewJsp();

        for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getTrpsGroup("MA","TEST",	"SMA");

        for(Trps trps:list)
            System.out.println(trps);*/

        // SET	SB	PSA_UPD14.SET	12346	TEST	201	500

        String codice="PAR";
        String tipoInstallazione ="ANG";
        String fileName="ANG_UPD.PAR";
        String checkSum="36600";
        String ambiente ="TEST";
        String minValue="1";
        String maxValue="10";

        TrpsId trpsId = new TrpsId(codice, TipoUsoRel.parse(ambiente), tipoInstallazione, Long.parseLong(minValue));
        Trps trps = new Trps(trpsId,fileName,checkSum,Long.parseLong(maxValue));

        //trpsDAO.update(trps);

        trpsDAO.deleteGroup(tipoInstallazione,ambiente,codice);

        trpsDAO.closeTransaction();

    }

    static void testTables_CR52(){

        System.out.println("Maven + Hibernate + Oracle + Bug Ojdbc");

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        /*FileAddressDAO fileAddressDAO = new FileAddressDAO(sm);

        FileAddressId fileAddressId = new FileAddressId("codConcentrat", new Date(), "0123456789");

        FileAddress fileAddress = new FileAddress(fileAddressId,"gruppo","progressivo","fase","indirizzoHDLC","dataAss","oraAss",new Date());

        fileAddressDAO.save(fileAddress);

        fileAddressDAO.closeTransaction();*/

/*        FileDemDAO fileDemDAO = new FileDemDAO(sm);

        FileDemId fileDemId = new FileDemId("codConcentra2", new Date(), "012345678_2");

        FileDem fileDem = new FileDem(fileDemId,"data2","ora2",new Date());

        fileDemDAO.save(fileDem);

        fileDemDAO.closeTransaction();*/

        /*FileComDAO fileComDAO = new FileComDAO(sm);

        FileComId fileComId = new FileComId("codConcentra2", new Date(), "012345678_2");

        FileCom fileCom = new FileCom(fileComId,"commOk1","commTOT2","commPer2",new Date());

        fileComDAO.save(fileCom);

        fileComDAO.closeTransaction();*/

        /* FileRoutingDAO fileRoutingDAO = new FileRoutingDAO(sm);
        FileAddressDAO fileAddressDAO = new FileAddressDAO(sm);
        FileDemDAO fileDemDAO = new FileDemDAO(sm);
        FileComDAO fileComDAO = new FileComDAO(sm);

        // Inseriamo 100 righe: con 4 concentratori diversi
       FileRoutingId fileRoutingId;

        FileRouting fileRouting;

        for(int i=1;i<=4;i++){
            for(int j=0;j<25;j++){

                fileRoutingId = new FileRoutingId("codConcentr"+i, new Date(), "MATR_"+j);
                fileRouting = new FileRouting(fileRoutingId,"rip1","rip2","rip3","rip4",new Date());
                fileRoutingDAO.save(fileRouting)
                ;
            }
        }*/


        /*String string = "15 Febbraio 2019";
        DateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Date testDate = null;
        try {
            testDate = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long nRows = fileRoutingDAO.getTotalRowsByDate(testDate);

        System.out.println("Data: "+testDate+" Numero di righe della tabella GRE_FILE_ROU: "+nRows);

        List<FileRouting> list = fileRoutingDAO.getRowsByDateAndRange(testDate,3,7);

        for(Object fileRouting:list){
            System.out.println("FileRouting " +fileRouting);
        }

        nRows = fileAddressDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_ADDRESS: "+nRows);

        nRows = fileComDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_COM: "+nRows);

        nRows = fileDemDAO.getTotalRowsByDate(testDate);

        System.out.println("Numero di righe della tabella GRE_FILE_DEM: "+nRows);

        fileAddressDAO.closeTransaction();
        fileComDAO.closeTransaction();
        fileDemDAO.closeTransaction();
        fileRoutingDAO.closeTransaction();*/

    }

    static void testJDBCConnection(){

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@172.30.6.80:1521:svil", "URMTEST3", "URMTEST3");

            PreparedStatement stmt=connection.prepareStatement(AcqMultipleFileDAO.NATIVE_QUERY_FILES_TO_BE_PROCESSED_4);

            stmt.setString(1,"G_EEA");

            stmt.setString(2,"G_EEA");
            stmt.setString(3,"G_EEA");

            String string = "03 Giugno 2019 15:41:00";
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");

           /* String string = "01 Giugno 2019";
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy");*/
            Date acqDate = null;
            try {
                acqDate = format.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            /*Calendar cal = Calendar.getInstance();
            cal.setTime(acqDate);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            acqDate = cal.getTime();*/

            java.sql.Date testDate = new java.sql.Date(acqDate.getTime());

            System.out.println("Data passata alla query: "+testDate);

            stmt.setDate(4, testDate);
            stmt.setString(5,"G_EEA");
            stmt.setDate(6, testDate);
            stmt.setString(7,"G");

            //ResultSet rs=stmt.executeQuery();

            int re =stmt.executeUpdate();

            // System.out.println("Statement query: "+ rs.getStatement().toString());
            System.out.println("Record inseriti"+ re);

            /*if (!rs.next() ) {
                System.out.println("no data");
            }
            else {
                while (rs.next()) {
                    String codConc = rs.getString("COD_CONCENTRATORE");
                    String fileType = rs.getString("FILE_TYPE");
                    String fileName = rs.getString("FILE_NAME");
                    Date acqDate1 =rs.getDate("ACQ_DATE");
                    String insertTime = rs.getString("INSERT_TIME");
                    Date dataElab =rs.getDate("DATA_ELAB");
                    String fileCorrente = rs.getString("FILE_CORRENTE");

                    System.out.println(codConc + "\t" + fileType +
                            "\t" + fileName + "\t" + acqDate1 +
                            "\t" + insertTime + "\t" + dataElab + "\t" + fileCorrente);
                }
            }*/

            connection.close();


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    static void testDateHibernate() {

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        String string = "01 Giugno 2019 15:41:00";
        DateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        Date acqDate = null;
        try {
            acqDate = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*Calendar cal = Calendar.getInstance();
        cal.setTime(acqDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        acqDate = cal.getTime();*/

        System.out.println("Data acquisizione:"+acqDate);

        Set<String> fileTypes = new HashSet<String>();

        fileTypes.add("G_EEA");

        AcqMultipleFileDAO dao = new AcqMultipleFileDAO(sm);

        Map<String,Set<String>> filesForCCS = dao.getFilesToBeProcessed(fileTypes, acqDate);

        if(filesForCCS.isEmpty()){
            System.out.println("Nessun risultato !!!!");
        }
        else{
            for (Map.Entry<String, Set<String>> entry : filesForCCS.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
        dao.closeTransaction();

    }

    static void updatePhaseMeters (Parser169File parser169File, String target, Date acqDate ) {
        OracleHibernateSessionManagement	sm = null;

        LenntConcentratoreDAO lenntConcentratoreDAO = null;
        LenntConcentratoreId lenntConcentratoreId = null;
        LenntConcentratore lenntConcentratore = null;

        LenntClienteDAO lenntClienteDAO = null;
        LenntCliente lenntCliente = null;

        try {
            sm = new OracleHibernateSessionManagement();

            System.out.println("acqDate:"+acqDate);

            //sm.openSession();
            lenntConcentratoreDAO = new LenntConcentratoreDAO(sm);
            lenntClienteDAO = new LenntClienteDAO(sm);
            String meterId;
            String concentratorId = target;
            String fase;
            String faseOld;
            String codCcsOld;

            if(acqDate==null) {
                acqDate = new Date();
            }

            int size = parser169File.getVectSize();
            System.out.println("Vector size:"+size);
            for (int i = 0; i < size; i++) {
                boolean aggiornatoCCS = false;
                boolean updatedPhase = false;
                boolean updatedUltimoContAdd = false;
                meterId = parser169File.getItemMtr(i);
                fase = parser169File.getItemFase(i);

                System.out.println("meterId:"+meterId);
                System.out.println("fase:"+fase);

                if(fase!=null ) {
                    fase = fase.trim();
                    if(fase.length()==0) {
                        fase=null;
                    }
                }

                lenntCliente = lenntClienteDAO.getById(meterId);
                if(lenntCliente!=null) {
                    if(lenntCliente.getUltimoContatto()==null || acqDate.getTime() >= lenntCliente.getUltimoContatto().getTime())
                    {
                        codCcsOld = lenntCliente.getCodConcentratore();
                        if(!concentratorId.equals(codCcsOld)){
                            lenntCliente.setTipoAssegnazione("FASE");
                            lenntCliente.setCodConcentratore3(lenntCliente.getCodConcentratore2());
                            lenntCliente.setCodConcentratore2(codCcsOld);
                            lenntCliente.setCodConcentratore(concentratorId);
                            lenntCliente.setUltimoContatto(acqDate);
                            aggiornatoCCS = true;
                        }
                    } else {
                        System.out.println("Processing not needed. Bind LENNT and CCS, table LenntCliente is already update");
                    }

                    if(lenntCliente.getDataFase() == null || acqDate.getTime() >= lenntCliente.getDataFase().getTime())
                    {
                        faseOld = lenntCliente.getFase();
                        if(faseOld!=null ) {
                            faseOld = faseOld.trim();
                            if(faseOld.length()==0) {
                                faseOld=null;
                            }
                        }
                        if(fase!=null && faseOld==null ||
                                fase!=null && faseOld!=null && !faseOld.equals(fase)) {
                            lenntCliente.setDataFase(acqDate);
                            lenntCliente.setFase(fase);
                            lenntCliente.setFaseOld(faseOld);
                            updatedPhase = true;
                        }
                    } else {
                        System.out.println("Processing not needed. PHASE is already update");
                    }

                    Date ultimoContattoAdd = lenntCliente.getUltimoContattoAdd();

                    if((acqDate!=null && ultimoContattoAdd==null) ||
                            (acqDate!=null && ultimoContattoAdd!=null && acqDate.getTime() >= ultimoContattoAdd.getTime())){
                        lenntCliente.setUltimoContattoAdd(acqDate);
                        updatedUltimoContAdd = true;
                    }

                    if(aggiornatoCCS || updatedPhase || updatedUltimoContAdd) {
                        lenntClienteDAO.update(lenntCliente);
                    }

                } else {
                    lenntCliente = new LenntCliente();
                    lenntCliente.setMatricolaLenntCliente(meterId);
                    lenntCliente.setCodConcentratore(concentratorId);
                    lenntCliente.setDataFase(acqDate);
                    lenntCliente.setFase(fase);
                    lenntCliente.setTipoAssegnazione("FASE");
                    lenntCliente.setUltimoContatto(acqDate);
                    lenntClienteDAO.save(lenntCliente);
                    aggiornatoCCS = true;
                }

                if(aggiornatoCCS) {
                    lenntConcentratoreId = new LenntConcentratoreId(concentratorId,meterId,acqDate);
                    lenntConcentratore = lenntConcentratoreDAO.getById(lenntConcentratoreId);
                    // Aggiorno lennt_concentratore
                    if(lenntConcentratore == null) {
                        try {
                            lenntConcentratore = new LenntConcentratore();
                            lenntConcentratore.setId(lenntConcentratoreId);
                            lenntConcentratoreDAO.saveOrUpdate(lenntConcentratore);
                        } catch (Exception e) {
                            System.out.println(e.toString()+" "+e);
                        }
                    }
                }

                System.out.println("Ciclo finito:"+i);
            }

            System.out.println("Ciclo finito !!!!");

            lenntConcentratoreDAO.closeTransaction();

            System.out.println("Chiudo Transazione");

            //sm.closeSession();

        } catch (Exception e) {
           /* if(sm!=null) {
                try { sm.rollbackSession(); }
                catch (Exception e1) {
                    logger.error(e1.toString(),e1); }
            }*/
            System.out.println(e.toString()+" "+e);
            //throw new CantProcessCommandException(e.toString());
        }
    }

    private static List getBlobAsList(String obj) throws Exception {
        if(obj == null) return null;

        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(obj.getBytes()));
        return (List)input.readObject();

    }

    private static List<TaskDetailsForm.TaskDetails> createTaskDetails (Collection<TaskDetail> tasks) {

        List<TaskDetailsForm.TaskDetails> taskDetails = new ArrayList<TaskDetailsForm.TaskDetails>();

        String state;
        String result;
        String target;
        String targetType;
        List targets;
        String expectedTime;
        String startTime;
        String endTime;
        boolean canClick;
        String dateFormat = "dd/MM/yyyy HH:mm";

        for (Iterator<TaskDetail> iter = tasks.iterator(); iter.hasNext(); ) {

            TaskDetail taskDto = (TaskDetail) iter.next();

            state="";
            result="";
            target = "";
            targetType="";
            targets=null;
            expectedTime="";
            startTime="";
            endTime="";
            canClick=false;

            System.out.println("TaskDetail:"+taskDto);

            if(taskDto.getOrigin().equalsIgnoreCase("GRE_TASKS")){

                try {
                    targets = taskDto.getTargets();

                } catch (Exception e) {
                    System.out.println("Errore nella conversione del BLOB:");
                    e.printStackTrace();
                }

                if (targets == null || targets.size() == 0) {
                    target = "Tutta la rete";
                }
                else if (targets.size() == 1) {
                    target = (String) targets.get(0);
                }
                else if (targets.size() > 1) {
                    target = ((String) targets.get(0)) + ", ...";
                }

                // Calculate expected start time format, or leave it empty if
                // its value is not defined.
                expectedTime = taskDto.getExpectedStartDate() == null ?
                        "": new SimpleDateFormat(dateFormat).format(taskDto.getExpectedStartDate());

                // Calculate the start time format, or leave it empty if
                // its value is not defined.
                startTime = taskDto.getStartDate()== null ?
                        "" : new SimpleDateFormat(dateFormat).format(taskDto.getStartDate());

                // Calculate the end time format, or leave it empty if
                // task state is different from IDLE, SCHEDULED, RUNNING and CANCELLED.
                endTime = "";

                String taskState = taskDto.getTaskState();

                if ((!taskState.equals (TaskDto.State.IDLE.toString())) &&
                        (!taskState.equals (TaskDto.State.SCHEDULED.toString())) &&
                        (!taskState.equals (TaskDto.State.RUNNING.toString())) &&
                        (!taskState.equals (TaskDto.State.CANCELLED.toString())))
                    endTime = new SimpleDateFormat(dateFormat).format(taskDto.getEndDate());

                targetType = (taskDto.getPeriod()!=null&&taskDto.getPeriod().equalsIgnoreCase("CASUAL")) ? taskDto.getTargetType() : "";
            }
            else {
                // Calculate expected start time format, or leave it empty if
                // its value is not defined.
                //
                expectedTime = taskDto.getStartDate() == null ?
                        "": new SimpleDateFormat(dateFormat).format(taskDto.getStartDate());

                //logger.debug("loading details task id " +task.getTaskId() + ": expectedTime " + expectedTime);
                if(taskDto.getTaskId()==null){
                    /* L'attività è periodica perchè proviene dalla tabella URM_ACTIVITY */
                    if(FunctionUtil.isNumeric(taskDto.getChronScheduling())) {
                        String[] validFormats = {
                                "yyyyMMddHHmm", "yyyyMMddHHmmss"
                        };

                        for(String format : validFormats) {
                            if(taskDto.getChronScheduling().length()==format.length()) {
                                expectedTime =  DateUtil.formatDate(DateUtil.parseDate(taskDto.getChronScheduling(), format), dateFormat);
                                break;
                            }
                        }
                    }else {
                        Calendar nextScheduledTime = null;
                        try {
                            nextScheduledTime = Schedule.nextScheduledTime(taskDto.getChronScheduling());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        expectedTime = DateUtil.formatDate(nextScheduledTime.getTime(), dateFormat);
                    }
                }

                // Calculate the start time format, or leave it empty if
                // its value is not defined.
                startTime = expectedTime;

                // Calculate the end time format, or leave it empty if
                // task state is different from IDLE, SCHEDULED, RUNNING and CANCELLED.
                endTime = taskDto.getEndDate() == null ?
                        "": new SimpleDateFormat(dateFormat).format(taskDto.getEndDate());
            }

            /* If state is COMPLETED, COMPLETED_WITH_ERRORS or FAILED set the
            bean state to COMPLETED and the bean result to OK, ERRORS and
            FAILED respectively. */
            if (taskDto.getTaskState().equals(TaskDto.State.COMPLETED.toString())) {
                state = TaskDto.State.COMPLETED.toString ();
                canClick = LinkEnablerUtil.canEnableLink (taskDto.getTaskCode());
                result = "OK";
            }
            else if (taskDto.getTaskState().equals(TaskDto.State.COMPLETED_WITH_ERRORS.toString())) {
                state = TaskDto.State.COMPLETED.toString ();
                result = "ERRORS";
            }
            else if (taskDto.getTaskState().equals(TaskDto.State.FAILED.toString())) {
                state = TaskDto.State.COMPLETED.toString ();
                result = "FAILED";
            }
            else  {
                state = taskDto.getTaskState();
            }

            if(taskDto.getTaskCode().equalsIgnoreCase(TaskCode.DATI_GESTIONE_FORNITURA.getCode()))
                taskDto.setTaskDescription("Dati di gestione fornitura");

            TaskDetailsForm.TaskDetails details = new TaskDetailsForm.TaskDetails (
                    taskDto.getTaskId()!=null?String.valueOf(taskDto.getTaskId().longValue()):"",
                    taskDto.getTaskCode(),
                    taskDto.getTaskDescription(),
                    targetType,
                    target,
                    expectedTime,
                    startTime,
                    endTime,
                    state,
                    result,
                    canClick
            );

            taskDetails.add(details);
        }
        return taskDetails;
    }
/*

    private void setSearchActivityInfos(TaskDetailsForm taskDetailsForm, TaskManagerFacade remoteFacade) throws Exception{

        List<TaskDetailsForm.SmartEntry> activityInfoListFromGre = null;
        List<TaskDetailsForm.SmartEntry> activityInfoListFromUrm = null;
        List<TaskDetailsForm.SmartEntry> ret = new ArrayList<TaskDetailsForm.SmartEntry>();
        Iterator<TaskDetailsForm.SmartEntry> iter = null;
        TaskDetailsForm.SmartEntry gestFornitura = null;
        TaskDetailsForm.SmartEntry gestFornituraGprs = null;
        TaskDetailsForm.SmartEntry union = null;
        String newDesc = "Dati di gestione fornitura";
        StringBuilder newCode = null;


        try{

            if (taskDetailsForm.getSearchActivityInfos () == null) {
                ActivityDAO activityDAO = MgreDAOFactory.createActivityDAO();
                Collection<ActivityDto> activitiesFromGre = activityDAO.findAll();
                List<UrmActivityType> activityTypesFromUrm = remoteFacade.getActivityTypes();
                activityInfoListFromGre = createActivityInfosOld(activitiesFromGre);
                activityInfoListFromUrm = createActivityInfosNew(activityTypesFromUrm);
                if(activityInfoListFromGre!=null && !activityInfoListFromGre.isEmpty()){
                    if(activityInfoListFromUrm!=null && !activityInfoListFromUrm.isEmpty()){
                        activityInfoListFromUrm.addAll(activityInfoListFromGre);
                        ret = activityInfoListFromUrm;
                    }else{
                        ret = activityInfoListFromGre;
                    }
                }

                //Unisce i task A9 e A116 (Dati di gestione fornitura)
                iter = ret.iterator();
                while(iter.hasNext()){
                    TaskDetailsForm.SmartEntry entry = iter.next();
                    if(entry.getValue().equalsIgnoreCase(TaskCode.DATI_GESTIONE_FORNITURA.getCode())){
                        gestFornituraGprs = entry;
                        newCode = new StringBuilder(TaskCode.DATI_GESTIONE_FORNITURA.getCode());
                        iter.remove();
                    }else if(entry.getValue().equalsIgnoreCase(ActivityDto.Codes.DATI_GESTIONE_FORNITURA)){
                        gestFornitura = entry;
                        if(newCode == null){
                            newCode = new StringBuilder(ActivityDto.Codes.DATI_GESTIONE_FORNITURA);
                        }else{
                            newCode = newCode.append("|"+ActivityDto.Codes.DATI_GESTIONE_FORNITURA);
                        }
                        iter.remove();
                    }
                }

                if(gestFornituraGprs!=null && gestFornitura!=null){
                    union = new TaskDetailsForm.SmartEntry(newCode.toString(),newDesc);
                }

                if(union!=null) {
                    ret.add(union);
                }

                */
/*Ordina la lista di SmartEntries in ordine alfabetico per descrizione dell'attività*//*

                if(ret!=null && !ret.isEmpty()){
                    Collections.sort(ret, new SmartEntryComparator());
                }
                taskDetailsForm.setSearchActivityInfos(ret);
            }

        }catch(Exception e){
            logger.error("Error setting activity infos for gre task details: "+e.getMessage(),e);
            throw e;
        }

    }
*/

    static public void  testQueryTasksJsp(){

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        TaskManagerDAO taskManagerDAO = new TaskManagerDAO(sm);

        List<TaskDetail> list = taskManagerDAO.loadTaskDetails("A52","",0,25);

        String queryTotJsp = taskManagerDAO.buildQueryTaskDetailsNoPage("", "", true);

        List<TaskDetailsForm.TaskDetails> list2;

        list2=createTaskDetails(list);

        for(TaskDetailsForm.TaskDetails taskDetails:list2)
            System.out.println(taskDetails);

        System.out.println("Query TOT: \n"+queryTotJsp);

        /*List testList = Collections.emptyList();

        String testString="";
        byte[] stringByte = new byte[0];
        ByteArrayOutputStream bos= null;


        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(testList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myStr = new String(bos.toByteArray());

        System.out.println("Lista vuota: "+myStr);

        ByteArrayInputStream bis= null;
        ObjectInputStream ois;
        List namesList;

        try {
            ByteArrayInputStream fis = new ByteArrayInputStream(bos.toByteArray());
             ois = new ObjectInputStream(fis);
             namesList = (List) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Byte di una lista vuota");
        for (int i=0; i< bos.toByteArray().length ; i++)
            System.out.println(bos.toByteArray()[i]);

        TaskDetailsForm.TaskDetails taskDetails = list2.get(0);

        String myStr2 = taskDetails.getTarget();

        System.out.println("Contenuto del BLOB");
        for (int i = 0; i< myStr2.getBytes(Charset.forName("US-ASCII")).length ; i++)
            System.out.println(myStr2.getBytes(Charset.forName("US-ASCII"))[i]);*/

    }

    static public void testTimeZone(){

        Long millisec = 1599210000000L;

        Long millisec_2 = 1599202800000L;

        Date now = new Date();

        java.sql.Timestamp ts =  new Timestamp(now.getTime());

        // I millisecondi contengono una ora in meno

        // Timestamp odierno: 2020-02-13 15:53:58.921       GMT+1 (Da Java)
        // Timestamp in millisecondi: 1581605638921
        // 13-FEB-20 14:53:58,921000000                     GMT
        System.out.println("Timestamp odierno: "+ts);
        System.out.println("Timestamp in millisecondi: "+ts.getTime());
        System.out.println("Date in millisecondi: "+now.getTime());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(ts);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

        System.out.println("Millisecondi dal 1970:"+millisec);
        Date expiry = new Date( millisec);
        System.out.println("Epoch Time: "+expiry); // GMT+2

        System.out.println("Millisecondi dal 1970:"+millisec_2);
        Date expiry2 = new Date( millisec_2);
        System.out.println("Epoch Time: "+expiry2);// GMT+2
    }

    static public void testCurrentTime() {
        Date newSyncDate = new Date();

        System.out.println("Data Odierna:"+newSyncDate);

        long datetimeSaved = newSyncDate.getTime();

        TimeZone zone = TimeZone.getDefault();

        // Contrary to its specification the meter needs to explicitly add
        // DST to its clock even if it know that it is in DST
        if (zone.inDaylightTime(new Date(datetimeSaved))) {
            datetimeSaved += zone.getDSTSavings();
        }

        System.out.println("datetimeSaved:"+new Date(datetimeSaved));
    }
}
