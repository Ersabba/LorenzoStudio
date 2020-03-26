package com.ericsson.urm.device.driver;

import java.util.Date;
import java.util.List;

import com.ericsson.urm.device.driver.bermode.ccs.OperativeMode;
import com.ericsson.urm.device.driver.bermode.ccs.ProgrammerCCSModeResponse;
import com.ericsson.urm.device.driver.currentdata.CurrentDataResponse;
import com.ericsson.urm.device.driver.datatype.CCSActivityCode;
import com.ericsson.urm.device.driver.datatype.GeneralTotalizersDecimalResponseMap;
import com.ericsson.urm.device.driver.datatype.TariffTotalizersDecimalResponseMap;
import com.ericsson.urm.device.driver.datetime.DateTimeDevice;
import com.ericsson.urm.device.driver.display.DisplayStatus;
import com.ericsson.urm.device.driver.energytotalizer.DailyActiveAbsorbedTotRequest;
import com.ericsson.urm.device.driver.energytotalizer.DailyActiveAbsorbedTotResponse;
import com.ericsson.urm.device.driver.energytotalizer.DailyTotalizerRequest;
import com.ericsson.urm.device.driver.energytotalizer.DailyTotalizerResponse;
import com.ericsson.urm.device.driver.energytotalizer.InstantTotalizerRequest;
import com.ericsson.urm.device.driver.energytotalizer.InstantTotalizerResponse;
import com.ericsson.urm.device.driver.energytotalizer.MonthlyTotalizerRequest;
import com.ericsson.urm.device.driver.energytotalizer.MonthlyTotalizerResponse;
import com.ericsson.urm.device.driver.lenntdata.MeterIdentifiers;
import com.ericsson.urm.device.driver.loadcurves.LoadCurveReadingRequest;
import com.ericsson.urm.device.driver.loadcurves.LoadCurveReadingResponse;
import com.ericsson.urm.device.driver.loadcurves.LoadMonthlyCurveReadingResponse;
import com.ericsson.urm.device.driver.maxpower.MonthlyMaxPowerRequest;
import com.ericsson.urm.device.driver.maxpower.MonthlyMaxPowerResponse;
import com.ericsson.urm.device.driver.programmingcfg.ProgrammingConfiguration;
import com.ericsson.urm.device.driver.programmingcfg.SupplierParameter;
import com.ericsson.urm.device.driver.programmingdisplay.DisplayProgrammingParameterRequest;
import com.ericsson.urm.device.driver.qltyvoltage.QualityDataVoltageResponse;
import com.ericsson.urm.device.driver.qltyvoltage.QualityParameterRequest;
import com.ericsson.urm.device.driver.qltyvoltage.QualityParameterResponse;
import com.ericsson.urm.device.driver.registersblockprogramming.RegistersBlockProgrammingRequest;
import com.ericsson.urm.device.driver.registersblockprogramming.SettingLoadCurvesRequest;
import com.ericsson.urm.device.driver.standbyccs.StandbyResponse;
import com.ericsson.urm.device.driver.statusword.CcsStatusWordResponse;
import com.ericsson.urm.device.driver.statusword.LenntCompleteStatusWordResponse;
import com.ericsson.urm.device.driver.taskstatusccs.TaskStatusResponse;
import com.ericsson.urm.device.driver.viprofiles.ViProfilesRequest;
import com.ericsson.urm.device.driver.viprofiles.ViProfilesResponse;


public interface IReadingsRequest extends IDriver {

	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public List<LoadCurveReadingResponse> getDailyLoadCurves(List<LoadCurveReadingRequest> request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public LoadMonthlyCurveReadingResponse getMonthlyLoadCurves(LoadCurveReadingRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	/**
	 * Funzionalit&agrave; che permette di leggere i dati dello stato del Lennt 
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 */
	public LenntStateData readLenntStatus() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	/**
	 * Metodo per la lettura dei dati di consumo istantaneo del Lennt
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 */
	public PowerData readCurrentPowerData() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	/**
	 * Metodo per la lettura dei totalizzatori giornalieri dell'energi attiva assorbita.
	 * @param request
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 */
	public DailyActiveAbsorbedTotResponse getActiveAbsorbedTotalizer(DailyActiveAbsorbedTotRequest request)throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public DailyTotalizerResponse getDailyTotalizer(DailyTotalizerRequest request)throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public GeneralTotalizersDecimalResponseMap getGeneralTotalizersDecimalDailyResponseMap(Date day) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public TariffTotalizersDecimalResponseMap getTariffTotalizersDecimalDailyResponseMap(Date day) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public MonthlyMaxPowerResponse readMonthlyMaxPower(MonthlyMaxPowerRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	public InstantTotalizerResponse getInstantTotalizer(InstantTotalizerRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public SupplierParameter getSupplierConfiguration() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	/**
	 * Metodo per impostare il tempo di standby (timeStandBy>0) del CCS 
	 * @param timeStandBy
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public StandbyResponse standbyCCS(int timeStandBy) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	/**
	 * Metodo per leggere la parola di stato CCS
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public CcsStatusWordResponse getStatusWord() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	/**
	 * Metodo per leggere lo stato del task del CCS
	 * @return
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public TaskStatusResponse executeTask(CCSActivityCode activitiCode) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	/**
	 * Metodo per impostare data e ora del device
	 * @param date
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public void synchronizeTime(Date date) throws DeviceDriverException,CommunicationException, UnsupportedOperationException;
	
    public boolean setQualityParameter(QualityParameterRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public QualityParameterResponse getQualityParameter() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public QualityDataVoltageResponse getQualityVoltageCurrentWeek() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	//public Date getLenntTime() throws LenntDriverException, CommunicationException, UnsupportedOperationException;
	
	public ViProfilesResponse getViProfiles(ViProfilesRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	/**
	 * Metodo per leggere i dati correnti di cabina.
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 * @throws UnsupportedOperationException
	 */
	public CurrentDataResponse getCurrentData() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public MonthlyTotalizerResponse getMonthlyTotalizer(MonthlyTotalizerRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;

	// usato per programmare un generico registro del lennt. fa uso del bt040
	public void programRegistersBlock(RegistersBlockProgrammingRequest request) throws DeviceDriverException, CommunicationException,
			UnsupportedOperationException;


	public byte[] getStatusWordReduced() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	public LenntCompleteStatusWordResponse getStatusWordComplete() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public boolean setDisplayProgramming(DisplayProgrammingParameterRequest displayProgrammingParameterRequest) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public boolean activateCC(ProgrammingConfiguration configuration) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public boolean deactivateCC(ProgrammingConfiguration configuration) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public boolean setProductionLoadCurves(SettingLoadCurvesRequest settingLoadCurvesRequest) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public DateTimeDevice readTime() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public DisplayStatus readDisplayStatus() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public MeterIdentifiers readLenntData() throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public ProgrammerCCSModeResponse programmazioneCCS(OperativeMode operativeMode) 
			throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
}
