package com.ericsson.mgre.biz.taskMgmt.activity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Activity bean data transfer object.
 * It encapsulates the Activity bean fields allowing them to be
 * transferred across the session facade layer.
 */
public class ActivityDto implements Serializable
{
	private static final long serialVersionUID = -1L;

	public static interface Codes {
		  public final String RETRIEVE_READINGS                = "A5";
		  public final String DATI_GESTIONE_FORNITURA          = "A9";
		  
		  public final String ACQ_UPDATE_PHASE_METERS          = "A50";
		  public final String PROCESSOR_UPDATE_PHASE_METERS    = "A51";
		  public final String ACQ_COUNTERS_EAA                 = "A52";
		  public final String PROCESSOR_COUNTERS_EAA           = "A53";
		  public final String ACQ_COUNTERS_EAE_Q1Q4_Q2Q3       = "A54";
		  public final String PROCESSOR_COUNTERS_EAE_Q1Q4_Q2Q3 = "A55";
		  public final String ACQ_LOAD_PROGRESSION             = "A56";
		  public final String PROCESSOR_LOAD_PROGRESSION       = "A57";
		  public final String ACQ_MONTHLY_REGISTER             = "A58";
		  public final String PROCESSOR_MONTHLY_REGISTER       = "A59";
		  public final String ACQ_MONTHLY_POWER_MEASURES       = "A60";
		  public final String PROCESSOR_MONTHLY_POWER_MEASURES = "A61";
		  public final String ACQ_NETWORK_STATUS               = "A62";
		  public final String PROCESSOR_NETWORK_STATUS         = "A63";
		  public final String ACQ_VERIFICA_CONGRUENZA          = "A64";
		  public final String PROCESSOR_VERIFICA_CONGRUENZA    = "A65";
		  
		  public final String ACQ_MONTHLY_VMXVMN			   = "A66";
		  public final String PROCESSOR_MONTHLY_VMXVMN  	   = "A67";
		  public final String LOAD_VMXVMN_TENSIONI	  	       = "A68";
		  public final String ACQ_MONTHLY_MEASURES             = "A69";
		  public final String PROCESSOR_MONTHLY_MEASURES       = "A70";
		  public final String ACQ_CURVE_CARICO_PUNTUALI        = "A71";
		  public final String PROCESSOR_CURVE_CARICO_PUNTUALI  = "A72";
		  public final String ACQ_CAMPIONI_MANCANTI		 	   = "A73";
		  public final String PROCESSOR_CAMPIONI_MANCANTI 	   = "A74";
		  public final String ACQ_INTERRUZIONI_PROVOCATE       = "A75";
		  public final String PROCESSOR_INTERRUZIONI_PROVOCATE = "A76";
		  public final String CLUSTERING_INTERRUZIONI_LENNT    = "A77";
          public final String EXPORT_CLUSTERING_INTERRUZIONI   = "A78";
          
          public final String ACQ_WEEKLY_VMXVMN				   = "A79";
          public final String PROCESSOR_WEEKLY_VMXVMN  	       = "A80";
          public final String EXPORT_VMXVMN   				   = "A81";
	      public final String EXPORT_MONTHLY_MEASURES          = "A82";
		  public final String CARICAMENTO_ANAGRAFICA_UTENZE_CM = "A85";
          public final String ACQ_MONTHLY_MEASURES_EEA         = "A86";
		  public final String PROCESSOR_MONTHLY_MEASURES_EEA   = "A87";
		  public final String PROCESSOR_LOADCURVES             = "A88";  // Elaborazione curve di carico dipendente dall'acq. del task di Ronda (URM Core)
		  public final String CARICAMENTO_ABILITAZIONE_CDC	   = "A89";
	}
	
	private String code;
	private String description;
	private ActivityDto.Period period;
	private Date startTime;
	private long delayMillis = 0; //delay sullo start del task: usato solo in alcune parti, 0 è il default
	private int hourInterval;
	private int dayOfWeek;
	private int dayOfMonth;
	private int daysOfRetry;
	private int month;
	private String enabled;
	private long averageExecTime;
	private long execNumber;
	private String exportEnabled;


	public String getCode () {
		return code;
	}

	public void setCode (String code) {
		this.code = code;
	}
	
	public int getDaysOfRetry() {
		return daysOfRetry;
	}

	public void setDaysOfRetry(int daysOfRetry) {
		this.daysOfRetry = daysOfRetry;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public ActivityDto.Period getPeriod () {
		return period;
	}

	public void setPeriod (ActivityDto.Period period) {
		this.period = period;
	}

	public boolean isCasual () {
		return period.equals (ActivityDto.Period.CASUAL);
	}
	
	public boolean isOneShot() {
		return period.equals (ActivityDto.Period.ONE_SHOT);
	}

	public boolean isPeriodic () {
		return period.isPeriodic();
	}

	public long getAverageExecTime() {
		return averageExecTime;
	}

	public void setAverageExecTime(long averageExecTime) {
		this.averageExecTime = averageExecTime;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getExecNumber() {
		return execNumber;
	}

	public void setExecNumber(long execNumber) {
		this.execNumber = execNumber;
	}

	public int getHourInterval() {
		return hourInterval;
	}

	public void setHourInterval(int hourInterval) {
		this.hourInterval = hourInterval;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getStartTime() {
		return startTime;
	}

	public long getDelayMillis() {
		return delayMillis;
	}

	public void setDelayMillis(long delayMillis) {
		this.delayMillis = delayMillis;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getExportEnabled() {
		return exportEnabled;
	}

	public void setExportEnabled(String exportEnabled) {
		this.exportEnabled = exportEnabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (averageExecTime ^ (averageExecTime >>> 32));
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + dayOfMonth;
		result = prime * result + dayOfWeek;
		result = prime * result + daysOfRetry;
		result = prime * result + (int) (delayMillis ^ (delayMillis >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + (int) (execNumber ^ (execNumber >>> 32));
		result = prime * result + ((exportEnabled == null) ? 0 : exportEnabled.hashCode());
		result = prime * result + hourInterval;
		result = prime * result + month;
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityDto other = (ActivityDto) obj;
		if (averageExecTime != other.averageExecTime)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		}
		else if (!code.equals(other.code))
			return false;
		if (dayOfMonth != other.dayOfMonth)
			return false;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (daysOfRetry != other.daysOfRetry)
			return false;
		if (delayMillis != other.delayMillis)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		}
		else if (!enabled.equals(other.enabled))
			return false;
		if (execNumber != other.execNumber)
			return false;
		if (exportEnabled == null) {
			if (other.exportEnabled != null)
				return false;
		}
		else if (!exportEnabled.equals(other.exportEnabled))
			return false;
		if (hourInterval != other.hourInterval)
			return false;
		if (month != other.month)
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		}
		else if (!period.equals(other.period))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		}
		else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	public String toString () {
		return code + ", " + description + ", " + period.toString ();
	}

	/**
	 * Typed enumeration class whose purpose is to abstract
	 * the activity periodicity.
	 */
	/*public static final class Period implements Serializable
	{
		public static final Period CASUAL   = new Period ("CASUAL");
		public static final Period SUBDAILY = new Period ("SUBDAILY");
		public static final Period DAILY    = new Period ("DAILY");
		public static final Period WEEKLY   = new Period ("WEEKLY");
		public static final Period MONTHLY  = new Period ("MONTHLY");
		public static final Period MONTHLY_BE  = new Period ("MONTHLY_BE");
		public static final Period YEARLY   = new Period ("YEARLY");
        public static final Period EXACT    = new Period ("EXACT");

		private final String literal;

		private Period (String literal) {
			this.literal = literal;
		}

		public static Period parse (String literal)
		{
			if (CASUAL.literal.equals (literal))   return CASUAL;
			if (SUBDAILY.literal.equals (literal)) return SUBDAILY;
			if (DAILY.literal.equals (literal))    return DAILY;
			if (WEEKLY.literal.equals (literal))   return WEEKLY;
			if (MONTHLY.literal.equals (literal))  return MONTHLY;
			if (MONTHLY_BE.literal.equals (literal))  return MONTHLY_BE;
			if (YEARLY.literal.equals (literal))   return YEARLY;
            if (EXACT.literal.equals (literal))   return EXACT;

			throw new IllegalArgumentException (
					"ActivityDto.Period.parse: unsupported literal value " + literal
				);
		}

		public String toString ()
		{
			return literal;
		}

		public boolean equals (Object other)
		{
			if (this == other) return true;
			if (other == null) return false;
			if (other instanceof Period) {
				return ((Period) other).literal.equals (literal);
			}
			return false;
		}

		public int hashCode ()
		{
			return literal.hashCode ();
		}
	}*/
	public static enum Period {
		CASUAL(false, false),
		ONE_SHOT(false, true),
		SUBDAILY,
		DAILY,
		WEEKLY,
		MONTHLY,
		MONTHLY_BE,
		YEARLY,
		EXACT;
		
		private boolean periodic = true;
		private boolean schedulable = true;
		
		
		private Period() {
			this.periodic = true;
			this.schedulable = true;
		}
		
		private Period(boolean periodic, boolean schedulable) {
			this.periodic = periodic;
		}

		public boolean isPeriodic() {
			return periodic;
		}
		
		public boolean isSchedulable() {
			return schedulable;
		}

		public static Period parse (String literal) {
			if(literal!=null && literal.trim().length()>0) {
				for(Period p : Period.values()) {
					if(p.toString().equalsIgnoreCase(literal)) {
						return p;
					}
				}
			}

			throw new IllegalArgumentException("ActivityDto.Period.parse: unsupported literal value " + literal);
		}
	}
}