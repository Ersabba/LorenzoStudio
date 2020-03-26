package com.ericsson.urm.device.driver.timeplan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ericsson.urm.device.driver.datatype.EnergyFlowDirection;
import com.ericsson.urm.device.driver.datatype.TariffId;
import com.ericsson.urm.device.driver.datatype.WeekDay;



public class TariffPlanRequest {
	public static final Logger logger = Logger.getLogger(TariffPlanRequest.class);

	
	//
	//
	//
	public static class TariffEndTime implements Serializable {
		private static final long serialVersionUID = -1L;
		public static final Logger logger = Logger.getLogger(TariffEndTime.class);
		
		private TariffId tariffId = TariffId.T4;
		private short dayIntervalEndTime = 0;
		
		
		public TariffEndTime() {
			
		}
		
		public TariffEndTime(TariffId tariffId, short dayIntervalEndTime) {
			setTariffId(tariffId);
			setDayIntervalEndTime(dayIntervalEndTime);
		}

		public TariffId getTariffId() {
			return tariffId;
		}

		public void setTariffId(TariffId tariffId) {
			if(tariffId==null) {
				throw new IllegalArgumentException("Undefined tariffId");
			}
			this.tariffId = tariffId;
		}


		public short getDayIntervalEndTime() {
			return dayIntervalEndTime;
		}
		
		public void setDayIntervalEndTime(short dayIntervalEndTime) {
			if(dayIntervalEndTime<0 || dayIntervalEndTime>96) {
				throw new IllegalArgumentException("Invalid dayIntervalEndTime:"+dayIntervalEndTime+", valid values:0-96");
			}
		
			this.dayIntervalEndTime = dayIntervalEndTime;
		}
	}
	
	
	//
	//
	//
	public static class TariffPlanDayRequest implements Serializable {
		private static final long serialVersionUID = -1L;
		private WeekDay weekDay = WeekDay.Monday;
		private final static int NUM_TARIFF_ENDTIME_ELEMENTS = 6;
		//private TariffEndTime[] tariffEndTimes = new TariffEndTime[NUM_TARIFF_ENDTIME_ELEMENTS];
		private List<TariffEndTime> tariffEndTimes = new ArrayList<TariffEndTime>();
		
	
		public TariffPlanDayRequest() {
			
			initTariffEndTimes();
		}

		public TariffPlanDayRequest(WeekDay weekDay) {
			
			setWeekDay(weekDay);
			
			initTariffEndTimes();
		}
		
		public void setWeekDay(WeekDay weekDay) {
			if(weekDay==null) {
				throw new IllegalArgumentException("Undefined weekDay");
			}
			this.weekDay = weekDay;
		}

		public WeekDay getWeekDay() {
			return weekDay;
		}
		
	
		public List<TariffEndTime> getUnmodifiableTariffEndTimes() {
			return Collections.unmodifiableList(tariffEndTimes);
		}

		public void setTariffEndTimes(TariffEndTime[] tariffEndTimes) {
			if(tariffEndTimes==null) {
				throw new IllegalArgumentException("Undefined tariffEndTimes");
			}
			
			this.tariffEndTimes = new ArrayList<TariffEndTime>();	
			for(int j=0; j<NUM_TARIFF_ENDTIME_ELEMENTS; ++j) {
				this.tariffEndTimes.add(j<tariffEndTimes.length ? tariffEndTimes[j] : new TariffEndTime());
			}
			sortTariffEndTimes();
			
			if(this.tariffEndTimes.size() > NUM_TARIFF_ENDTIME_ELEMENTS) {
				this.tariffEndTimes.remove(this.tariffEndTimes.size()-1 );
			}
		}
		
		public TariffEndTime getTariffById(int index) {
			checkTariffIndex(index);
			return tariffEndTimes.get(index);
		}

		public void setTariffEndTime(TariffEndTime tariffEndTime) {
			if(tariffEndTime == null) {
				throw new IllegalArgumentException("Undefined tariffEndTime");
			}
			
			tariffEndTimes.add(tariffEndTime);

			sortTariffEndTimes();
			
			if(tariffEndTimes.size() > NUM_TARIFF_ENDTIME_ELEMENTS) {
				tariffEndTimes.remove(tariffEndTimes.size()-1 );
			}
		}
		
		private void initTariffEndTimes() {
			tariffEndTimes = new ArrayList<TariffEndTime>();
			for(int j=0; j<NUM_TARIFF_ENDTIME_ELEMENTS; ++j) {
				tariffEndTimes.add(new TariffEndTime());
			}
		}
		
		private void sortTariffEndTimes() {
			if(tariffEndTimes!=null) {
				Collections.sort(tariffEndTimes, new Comparator<TariffEndTime>() {
					@Override
					public int compare(TariffEndTime o1, TariffEndTime o2) {
						// Ascending
						
						if(o2.dayIntervalEndTime==0) {
							return -1;
						}
						if(o1.dayIntervalEndTime==0) {
							return 1;
						}
						
						return  o1.dayIntervalEndTime > o2.dayIntervalEndTime ? 1 : 
						        o1.dayIntervalEndTime < o2.dayIntervalEndTime ?  -1 : 0;	
					}
				});
			}	
		}
		
		private void checkTariffIndex(int index) {
			if(tariffEndTimes==null) {
				throw new IllegalStateException("TimePlanDayRequest not initialized");
			}
			
			if(index<0 || index>=tariffEndTimes.size()) {
				throw new IllegalArgumentException("Invalid tariff index:"+index+", valid values:0-"+tariffEndTimes.size());
			}
		}
	}
	
	
	//
	//
	//
	private static class TariffPlanDayRequestMap extends EnumMap<WeekDay, TariffPlanDayRequest> {

		private static final long serialVersionUID = -1L;
		public TariffPlanDayRequestMap(Class<WeekDay> keyType) {
			super(keyType);
			// TODO Auto-generated constructor stub
		}
	
	};
	
	
	//
	//
	//
	public static class TariffPlanPeriodRequest implements Serializable {
		
		
		//
		// Private attributes;
		//
		private static final long serialVersionUID = -1L;
		private int period = 1;
		private String planName = null;
		private Date datePeriod = null;

		private TariffPlanDayRequestMap tariffPlanDayRequestMap = new TariffPlanDayRequestMap(WeekDay.class) {
			private static final long serialVersionUID = -1L;

			{
				for(WeekDay weekDay : WeekDay.values()) {
					put(weekDay, new TariffPlanDayRequest(weekDay));
				}
			}
		};
		
		public TariffPlanPeriodRequest() {
			
		}
		
		public TariffPlanPeriodRequest(int period) {
		
			setPeriod(period);
		}

		//
		//
		//
		
		public int getPeriod() {
			return period;
		}

		private void setPeriod(int period) {
			if(period<1 || period>6) {
				throw new IllegalArgumentException("Invalid period:"+period+", valid values:1-6");
			}
			this.period = period;
		}
		
		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

		public Date getDatePeriod() {
			return datePeriod;
		}

		public void setDatePeriod(Date datePeriod) {
			this.datePeriod = datePeriod;
		}

		public Set<Map.Entry<WeekDay,TariffPlanDayRequest>> entrySetTimePlanDayRequest() {

			return tariffPlanDayRequestMap.entrySet();
		}
		
		public TariffPlanDayRequest getTimePlanDayRequest(WeekDay weekDay) {

			return tariffPlanDayRequestMap.get(weekDay);
		}

		public void setTimePlanDayRequest(TariffPlanDayRequest timePlanDayRequest) {
			
			if(timePlanDayRequest==null) {
				throw new IllegalArgumentException("Undefined timePlanDayRequest");
			}
			if(timePlanDayRequest.getWeekDay()==null) {
				throw new IllegalArgumentException("Undefined WeekDay");
			}
			tariffPlanDayRequestMap.put(timePlanDayRequest.getWeekDay(), timePlanDayRequest);
		}

	}
	
	//
	//
	//
	public static class TariffPlanContractRequest implements Serializable {
		private static final long serialVersionUID = -1L;
		private EnergyFlowDirection energyFlowDirection = null;
		
		//
		//
		//
		private Map<Integer,TariffPlanPeriodRequest> tariffPlanPeriodRequestMap = new HashMap<Integer,TariffPlanPeriodRequest>();
		
		
		private TariffPlanContractRequest(EnergyFlowDirection energyFlowDirection) {
			this.energyFlowDirection = energyFlowDirection;
			
			initTariffPlanPeriodRequests();
		}
		

		public EnergyFlowDirection getEnergyFlowDirection() {
			return energyFlowDirection;
		}

		//
		//
		//
		public Set<Integer> getPeriods() {
			return tariffPlanPeriodRequestMap.keySet();
		}
		
		public TariffPlanPeriodRequest getTimePlanPeriodRequest(int period) {
			return tariffPlanPeriodRequestMap.get(period);
		}

		public void setTimePlanPeriodRequests(TariffPlanPeriodRequest tariffPlanPeriodRequest) {
			if(tariffPlanPeriodRequest==null) {
				throw new IllegalArgumentException("Undefined tariffPlanPeriodRequest");
			}
			checkPeriod(tariffPlanPeriodRequest.getPeriod());
			
			tariffPlanPeriodRequestMap.put(tariffPlanPeriodRequest.getPeriod(), tariffPlanPeriodRequest);
		}
		
		
		private void initTariffPlanPeriodRequests() {
			tariffPlanPeriodRequestMap.clear();
			tariffPlanPeriodRequestMap.put(1, new TariffPlanPeriodRequest(1));
		}
		
		private void checkPeriod(int period) {
			if(period<1 || period>6) {
				throw new IllegalArgumentException("Invalid period:"+period+", valid values:1-6");
			}
		}
		
	}
	
	//
	//
	//
	private static class TariffPlanContractRequestMap extends EnumMap<EnergyFlowDirection, TariffPlanContractRequest> {

		private static final long serialVersionUID = -1L;
		public TariffPlanContractRequestMap(Class<EnergyFlowDirection> keyType) {
			super(keyType);
		}
	};
	

	//
	//
	//
	private TariffPlanContractRequestMap tariffPlanContractRequestMap = new TariffPlanContractRequestMap(EnergyFlowDirection.class) {
		private static final long serialVersionUID = -1L;

		{
			for(EnergyFlowDirection currEFD : EnergyFlowDirection.values()) {
				put(currEFD, new TariffPlanContractRequest(currEFD));
			}
		}
	};
	
	
	
	//
	//
	//
	private String contractName = null;
	private Date contractBeginDate = null;
	private Date contractEndDate = null;
	

	public TariffPlanRequest() {
		
	}
	
	public TariffPlanContractRequest getAbsorbedTariffPlanContractRequest() {
		
		return tariffPlanContractRequestMap.get(EnergyFlowDirection.ABSORBED);
	}
	
	public TariffPlanContractRequest getSuppliedTariffPlanContractRequest() {
		return tariffPlanContractRequestMap.get(EnergyFlowDirection.SUPPLIED);
	}
	
	public TariffPlanContractRequest getTariffPlanContractRequest(EnergyFlowDirection energyFlowDirection) {
		if(energyFlowDirection == null) {
			throw new IllegalArgumentException("Undefined argument energy flow direction");
		}
		return tariffPlanContractRequestMap.get(energyFlowDirection);
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Date getContractBeginDate() {
		return contractBeginDate;
	}

	public void setContractBeginDate(Date contractBeginDate) {
		this.contractBeginDate = contractBeginDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

}
