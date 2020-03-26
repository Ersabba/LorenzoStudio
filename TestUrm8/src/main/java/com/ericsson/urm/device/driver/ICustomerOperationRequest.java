package com.ericsson.urm.device.driver;

import java.util.Set;

import com.ericsson.urm.device.driver.datatype.IBTCommandExecutor;
import com.ericsson.urm.device.driver.energytotalizer.InstallationParameterRequest;
import com.ericsson.urm.device.driver.energytotalizer.TotalizerRequestType;
import com.ericsson.urm.device.driver.maxpower.MonthlyMaxPowerRequest;
import com.ericsson.urm.device.driver.programmingcfg.ProgrammingConfiguration;
import com.ericsson.urm.device.driver.registersblockprogramming.Block1;
import com.ericsson.urm.device.driver.registersblockprogramming.Block8;
import com.ericsson.urm.device.driver.registersblockprogramming.SettingLoadCurvesRequest;
import com.ericsson.urm.device.driver.timeplan.TariffPlanRequest;


public interface ICustomerOperationRequest extends IDriver {

	public IBTCommandExecutor createTimePlanExecutor(TariffPlanRequest plan, StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
//	public boolean sendTimePlan(TariffPlanRequest plan, StatisticsCommandsOutput statisticsCommandsOutput)
//			throws DeviceDriverException, CommunicationException,UnsupportedOperationException;
	
	public IBTCommandExecutor createContractAndTimePlanExecutor(
			ProgrammingConfiguration configuration,
			TariffPlanRequest plan, 
			InstallationParameterRequest ipRequest,
			Block1 registerBlock,  
			StatisticsCommandsOutput statisticsCommandsOutput) throws UnsupportedOperationException, DeviceDriverException;

//	public boolean sendContractAndTimePlan(ProgrammingConfiguration configuration, TariffPlanRequest plan,
//											InstallationParameterRequest ipRequest,
//											RegistersBlockProgrammingRequest registerBlock,
//											StatisticsCommandsOutput statisticsCommandsOutput)
//					throws CommunicationException, UnsupportedOperationException, DeviceDriverException;

	public IBTCommandExecutor createCustomerDeactivationExecutor(StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
	public IBTCommandExecutor createCustomerDeactivationExecutor(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
	//public boolean customerDeactivation(StatisticsCommandsOutput statisticsCommandsOutput) throws DeviceDriverException, CommunicationException;
	//public boolean customerDeactivation(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput) throws DeviceDriverException, CommunicationException;

	public IBTCommandExecutor createCustomerReactivationExecutor(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput) throws UnsupportedOperationException, DeviceDriverException;
	//public boolean customerReactivation(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput) throws DeviceDriverException, CommunicationException;

	
	public IBTCommandExecutor createReadingsMonthlyMaxPowerExecutor(MonthlyMaxPowerRequest request) throws UnsupportedOperationException, DeviceDriverException;
	
	public IBTCommandExecutor createReadingsMonthlyMaxPowerExecutor(
			MonthlyMaxPowerRequest request, 
			StatisticsCommandsOutput statisticsCommandsOutput) throws UnsupportedOperationException, DeviceDriverException;
	
	public IBTCommandExecutor createInstantTotalizerExecutor(Set<TotalizerRequestType> requests, 
			StatisticsCommandsOutput statisticsCommandsOutput) throws UnsupportedOperationException, DeviceDriverException;
	
//	public MonthlyMaxPowerResponse readMonthlyMaxPower(MonthlyMaxPowerRequest request) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
//	
//	public MonthlyMaxPowerResponse readMonthlyMaxPower(
//					MonthlyMaxPowerRequest request, 
//					StatisticsCommandsOutput statisticsCommandsOutput) 
//					throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public IBTCommandExecutor createProgramCCExecutor(SettingLoadCurvesRequest settingLoadCurvesRequest, StatisticsCommandsOutput statisticsCommandsOutput)
			   throws UnsupportedOperationException, DeviceDriverException;

	
	public IBTCommandExecutor createActivateCCExecutor(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput)
			   throws UnsupportedOperationException, DeviceDriverException;
	
	//public boolean activateCC(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput ) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	
	public IBTCommandExecutor createDeactivateCCExecutor(
			ProgrammingConfiguration configuration, 
			StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
	//public boolean deactivateCC(ProgrammingConfiguration configuration, StatisticsCommandsOutput statisticsCommandsOutput ) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;

	public IBTCommandExecutor createAnnulmentDetachmentsExecutor(ProgrammingConfiguration configuration,
			TariffPlanRequest plan, InstallationParameterRequest ipRequest,
			Block1 registerBlock, 
			StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
//	public boolean sendAnnulmentDetachments(
//						ProgrammingConfiguration configuration, TariffPlanRequest plan, InstallationParameterRequest ipRequest,
//						RegistersBlockProgrammingRequest registerBlock, 
//						StatisticsCommandsOutput statisticsCommandsOutput) 
//						throws CommunicationException, UnsupportedOperationException, DeviceDriverException;

	public IBTCommandExecutor createDisablingPortExecutor (
			Block8 registerBlock, 
			StatisticsCommandsOutput statisticsCommandsOutput)
			throws UnsupportedOperationException, DeviceDriverException;
	
//	public boolean sendDisablingPort(
//			RegistersBlockProgrammingRequest registerBlock, 
//			StatisticsCommandsOutput statisticsCommandsOutput) 
//					throws CommunicationException, UnsupportedOperationException, DeviceDriverException;
	
	public IBTCommandExecutor createActivationAndTimePlanExecutor(
				ProgrammingConfiguration configuration,
				TariffPlanRequest plan, 
				StatisticsCommandsOutput statisticsCommandsOutput) throws UnsupportedOperationException, DeviceDriverException;

//	public boolean sendActivationAndTimePlan(
//			ProgrammingConfiguration configuration,
//			TariffPlanRequest plan, 
//			StatisticsCommandsOutput statisticsCommandsOutput) 
//					throws CommunicationException, UnsupportedOperationException, DeviceDriverException;
}
