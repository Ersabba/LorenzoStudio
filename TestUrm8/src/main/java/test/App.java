package test;

import com.ericsson.gestionesw.persistence.dto.SincrCcs;
import com.ericsson.gestionesw.persistence.dto.Trps;
import com.ericsson.gestionesw.persistence.dto.TrpsId;
import com.ericsson.gestionesw.persistence.dto.datatype.TipoUsoRel;
import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.exceptions.URMBusinessException;
import com.ericsson.urm.persistence.HibernateSessionManagement;
import com.ericsson.urm.persistence.OracleHibernateSessionManagement;
import com.ericsson.urm.persistence.OracleHibernateSessionManagement2;
import com.ericsson.urm.persistence.RadiusHibernateSessionManagement;
import com.ericsson.urm.persistence.core.dao.radius.RadiusDAO;
import com.ericsson.urm.persistence.core.dao.readings.AcqMultipleFileDAO;
import com.ericsson.urm.persistence.core.dao.readings.MonthlyMeasuresDAO;
import com.ericsson.urm.persistence.core.dto.RadCheck;
import com.ericsson.urm.persistence.core.dto.RadiusCMSInfoDTO;
import com.ericsson.urm.persistence.core.dto.TestDto;
import com.ericsson.urm.persistence.dao.gestionesw.SincrCcsDAO;
import com.ericsson.urm.persistence.dao.gestionesw.TrpsDAO;
import com.ericsson.urm.persistence.dao.mds.AcqFileCcsDAO;
import com.ericsson.urm.persistence.dao.mds.StatsAcqFileCcsDAO;
import com.ericsson.urm.persistence.dao.mgcf.ActivityDAO;
import com.ericsson.urm.persistence.dao.mgcf.DeviceReachabilityDAO;
import com.ericsson.urm.persistence.dao.mgcf.ReachabilityStatusDAO;
import com.ericsson.urm.persistence.dao.mgre.*;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcs;
import com.ericsson.urm.persistence.dto.mds.AcqFileCcsId;
import com.ericsson.urm.persistence.dto.mds.StatsAcqFileCcs;
import com.ericsson.urm.persistence.dto.mds.StatsAcqFileCcsId;
import com.ericsson.urm.persistence.dto.mgcf.Activity;
import com.ericsson.urm.persistence.dto.mgcf.DeviceReachabilityStatus;
import com.ericsson.urm.persistence.dto.mgcf.ReachabilityStatistic;
import com.ericsson.urm.persistence.dto.mgre.*;
import com.ericsson.urm.util.ArgumentsCheckerUtil;
import com.ericsson.urm.util.DateUtil;
import com.mysql.jdbc.JDBC4PreparedStatement;
import org.apache.commons.lang3.mutable.MutableLong;
import org.hibernate.SQLQuery;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class App {

    public static void main(String[] args) {

        System.out.println("Maven + Hibernate + Oracle");

        //OracleHibernateSessionManagement2 sm = new OracleHibernateSessionManagement2();

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

        //test_cr21();

        //test_cr67();

        //testPassingParameters();

        //long numLennt = getLenntForMonthlyMeasuresPunctualSizeNoFilter();

        //System.out.println("Numero Lennt :"+numLennt);

        testTableGreSincrCCS();
    }

    static public void  testReachability(){

        /*OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        ReachabilityStatusDAO reachabilityStatusDAO = new ReachabilityStatusDAO(sm);

        DeviceReachabilityStatus deviceReachabilityStatus = reachabilityStatusDAO.getLast();

        System.out.println(" Info trovate per il test : "+deviceReachabilityStatus);

        //reachabilityStatusDAO.closeTransaction();


        DeviceReachabilityDAO deviceReachabilityDAO = new DeviceReachabilityDAO(sm);

        ReachabilityStatistic stat = deviceReachabilityDAO.getStatistics(1000);


        System.out.println("Statistiche:"+stat);

        deviceReachabilityDAO.closeTransaction();*/

    }

    static public void  testTRPS(){

/*        System.out.println("Maven + Hibernate + Oracle + Tabella TRPS");

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        TrpsDAO trpsDAO = new TrpsDAO(sm);

       //List<Trps> list = trpsDAO.getAll();

        *//* for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getAllViewJsp();

        for(Trps trps:list)
            System.out.println(trps);

        list = trpsDAO.getTrpsGroup("MA","TEST",	"SMA");

        for(Trps trps:list)
            System.out.println(trps);*//*

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

        trpsDAO.closeTransaction();*/

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

            connection.setAutoCommit(false);

            PreparedStatement stmt0=connection.prepareStatement(AcqMultipleFileDAO.DELETE_QUERY_FILES_TO_BE_PROCESSED);

            int re =stmt0.executeUpdate();

            // System.out.println("Statement query: "+ rs.getStatement().toString());
            System.out.println("Record cancellati: "+ re);

            connection.commit();
            stmt0.close();

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

            System.out.println("Data (Java.util.date) di acquisizione passata alla query: "+acqDate);

            java.sql.Date testDate = new java.sql.Date(acqDate.getTime());

            System.out.println("Data (Java.sql.date) di acquisizione passata alla query: "+format.format(testDate));

            stmt.setDate(4, testDate);
            stmt.setString(5,"G_EEA");
            stmt.setDate(6, testDate);
            stmt.setString(7,"G");

            //ResultSet rs=stmt.executeQuery();

            int nr =stmt.executeUpdate();

            // System.out.println("Statement query: "+ rs.getStatement().toString());
            System.out.println("Record inseriti: "+ nr);

            connection.commit();
            stmt.close();

            PreparedStatement stmt2=connection.prepareStatement(AcqMultipleFileDAO.NATIVE_QUERY_FILES_TO_BE_PROCESSED_3,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            //stmt2.setString(1,"G_EEA");

            ResultSet rs=stmt2.executeQuery();

            if (!rs.next() ) {
                System.out.println("no data");
            }
            else {

                System.out.println("Data present!");

                rs.beforeFirst();

                while (rs.next()) {
                    String codConc = rs.getString("COD_CONCENTRATORE");
                    String fileType = rs.getString("FILE_TYPE");
                    String fileName = rs.getString("FILE_NAME");
                    Date acqDate1 =rs.getDate("ACQ_DATE");
                    String insertTime = rs.getString("INSERT_TIME");
                    Date dataElab =rs.getDate("DATA_ELAB");
                    String fileCorrente = rs.getString("FILE_CORRENTE");

                    System.out.println("DataAcquisizione come java.sql.Date senza formattazione " + rs.getDate("ACQ_DATE"));
                    System.out.println("DataAcquisizione come java.sql.Date con formattazione   " + format.format(rs.getDate("ACQ_DATE")));
                    System.out.println("DataAcquisizione come java.sql.Timestamp                " + rs.getTimestamp("ACQ_DATE"));

                    System.out.println(codConc + "\t" + fileType +
                            "\t" + fileName + "\t" + acqDate1 +
                            "\t" + insertTime + "\t" + dataElab + "\t" + fileCorrente);
                }
            }

            connection.commit();
            stmt2.close();

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

    public static void test_cr21(){

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        ActivityDAO dao = new ActivityDAO(sm);

        // Fatto da Angelica
        // Activity[] activities = dao.getSuspendedActivities(1);

        Activity[] activities = dao.getSuspendedActivitiesLorenzo(1);

        for(int i=0;i<activities.length;i++)
            System.out.println("Attività n."+i+" "+activities[i]);

        dao.closeTransaction();

    }

    public static void test_cr67() {

        OracleHibernateSessionManagement sm = new OracleHibernateSessionManagement();

        /*StatsAcqFileCcsDAO statsAcqFileCcsDAO = new StatsAcqFileCcsDAO(sm);

        StatsAcqFileCcsId statsAcqFileCcsId = new StatsAcqFileCcsId(new Date(),"12345","FILENAME");

        StatsAcqFileCcs statsAcqFileCcs = new StatsAcqFileCcs(statsAcqFileCcsId,3,4,5,6,"A333");

        statsAcqFileCcsDAO.insert(statsAcqFileCcs);

        statsAcqFileCcsDAO.closeTransaction();*/

        LenntClienteDAO dao = new LenntClienteDAO(sm);

        long numLennt=dao.getLenntNumberForInstantPunctualReadings(5,20,true);

        System.out.println("Numero totale record:"+numLennt);

        dao.closeTransaction();

        //storeReadingsNumAndNumLennt(new Date(),"CCS_TEST","FILE_TEST",0,0);
    }

    private static void passParameter1(long par1){

        par1++;
    }

    private static void passParameter2(Long par1){

        par1++;
    }

    private static void passParameter3(AtomicLong par1){

        par1.incrementAndGet();
    }

    private static void passParameter4(String par1){

        Long value = Long.parseLong(par1);

        value++;
        par1=String.valueOf(value);
    }

    private static void passParameter5(AtomicReference<Provenienza> prov1){

        prov1.set(Provenienza.CCS);
    }

    private static void passParameter6(MutableLong prov6){

        prov6.increment();
    }

    public static void testPassingParameters(){

        System.out.println("Passing Parameters");

        long test1=0;

        passParameter1(test1);

        System.out.println("Parametro 1 Incrementato: "+test1);

        Long test2=0L;

        passParameter2(test2);

        System.out.println("Parametro 2 Incrementato: "+test2);

        AtomicLong test3=new AtomicLong(5);

        passParameter3(test3);

        System.out.println("Parametro 3 Incrementato: "+test3);

        String test4 = "0";

        passParameter4(test4);

        System.out.println("Parametro 4 Incrementato: "+test4);

        AtomicReference test5 = new AtomicReference<Provenienza>(Provenienza.DIR);

        passParameter5(test5);

        System.out.println("Parametro 5 Cambiato: "+test5.get().toString());

        MutableLong test6=new MutableLong(0);

        passParameter6(test6);

        System.out.println("Parametro 6 Cambiato: "+test6);
    }

    public static void storeReadingsNumAndNumLennt(Date acqDate, String idCCS, String fileName, long dbReadingsStored, long lenntNum)  {

        ArgumentsCheckerUtil.checkNull(acqDate, "acqDate");
        ArgumentsCheckerUtil.checkNull(fileName, "fileName");
        ArgumentsCheckerUtil.checkString(idCCS, "idCCS");

        OracleHibernateSessionManagement sm = null;
        try {
            sm = new OracleHibernateSessionManagement();
            StatsAcqFileCcsDAO dao = new StatsAcqFileCcsDAO(sm);

            StatsAcqFileCcsId id = new StatsAcqFileCcsId(DateUtil.azzeraHHMMSS(acqDate), idCCS, fileName);

            StatsAcqFileCcs acq = dao.getById(id);

            if(acq!=null){
                acq.setNumMatricolePresenti(lenntNum);
                acq.setNumReadings(dbReadingsStored);
            }
            else
                acq = new StatsAcqFileCcs(id,dbReadingsStored,lenntNum,0,0,"");

            dao.saveOrUpdate(acq);

            dao.closeTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getLenntForMonthlyMeasuresPunctualSizeNoFilter()  {

        long nlennts=0;

        OracleHibernateSessionManagement sm = null;
        try {
            sm = new OracleHibernateSessionManagement();
            MonthlyMeasuresDAO dao = new MonthlyMeasuresDAO(sm);

            //nlennts = dao.getLenntForMonthlyMeasuresPunctualSizeNoFilter();

            nlennts=dao.getMonthlyMissingComponentMaxLennt();

            dao.closeTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nlennts;
    }

    public static void testTableGreSincrCCS(){

        OracleHibernateSessionManagement sm = null;
        try {
            sm = new OracleHibernateSessionManagement();
            SincrCcsDAO dao = new SincrCcsDAO(sm);

            SincrCcs sincrCcs = new SincrCcs("matricolaCcs", "0.0.0.0", "TestRelease", new Date(), new Date(),true);

            dao.saveOrUpdate(sincrCcs);

            SincrCcs sincrCcs1=dao.getLastCcsSyncronization("matricolaCcs");

            System.out.println("Ultima sincronizzazione: "+sincrCcs1);

            ConcentratoreDAO dao1 = new ConcentratoreDAO(sm);

            dao1.getReqSynchrCcsList(500);

            dao.closeTransaction();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
