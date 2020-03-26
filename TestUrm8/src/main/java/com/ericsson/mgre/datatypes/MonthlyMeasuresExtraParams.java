package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.util.DateUtil;

public class MonthlyMeasuresExtraParams implements Serializable {
	
	public static enum MonthlyMeasureExtraKeys {
		
		START_DAY_PHASE_2("START_DAY_PHASE_2"),
		START_DAY_PHASE_3("START_DAY_PHASE_3"),
		JAN_EXPORT_DAY("JAN_EXPORT_DAY"),
		FEB_EXPORT_DAY("FEB_EXPORT_DAY"),
		MAR_EXPORT_DAY("MAR_EXPORT_DAY"),
		APR_EXPORT_DAY("APR_EXPORT_DAY"),
		MAY_EXPORT_DAY("MAY_EXPORT_DAY"),
		JUN_EXPORT_DAY("JUN_EXPORT_DAY"),
		JUL_EXPORT_DAY("JUL_EXPORT_DAY"),
		AUG_EXPORT_DAY("AUG_EXPORT_DAY"),
		SEP_EXPORT_DAY("SEP_EXPORT_DAY"),
		OCT_EXPORT_DAY("OCT_EXPORT_DAY"),
		NOV_EXPORT_DAY("NOV_EXPORT_DAY"),
		DEC_EXPORT_DAY("DEC_EXPORT_DAY"),
		USE_MIDMONTH_READINGS("USE_MIDMONTH_READINGS");
		
		private String value;
		
		private MonthlyMeasureExtraKeys(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public static MonthlyMeasureExtraKeys parse (String value){
			for(MonthlyMeasureExtraKeys curr : MonthlyMeasureExtraKeys.values()){
				if(curr.toString().equalsIgnoreCase(value)){
					return curr;					
				}
			}
			
			throw new IllegalArgumentException ("MonthlyMeasureExtraParams: unsupported value " + value);
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	private Date inizioSecondoCicloRaccolta;
	private Date inizioUltimoCicloRaccolta;
	private Date janExportDate;
	private Date febExportDate;
	private Date marExportDate;
	private Date aprExportDate;
	private Date mayExportDate;
	private Date junExportDate;
	private Date julExportDate;
	private Date augExportDate;
	private Date sepExportDate;
	private Date octExportDate;
	private Date novExportDate;
	private Date decExportDate;
	private boolean useMidMonthReadings;
	private SubdailyActivityExtraParams subdailyActivityExtraParams = null;
	
	
	public MonthlyMeasuresExtraParams() {
		super();
	}
	

	public Date getInizioSecondoCicloRaccolta() {
		return inizioSecondoCicloRaccolta;
	}

	public void setInizioSecondoCicloRaccolta(Date inizioSecondoCicloRaccolta) {
		this.inizioSecondoCicloRaccolta = inizioSecondoCicloRaccolta;
	}

	public Date getInizioUltimoCicloRaccolta() {
		return inizioUltimoCicloRaccolta;
	}

	public void setInizioUltimoCicloRaccolta(Date inizioUltimoCicloRaccolta) {
		this.inizioUltimoCicloRaccolta = inizioUltimoCicloRaccolta;
	}

	public Date getJanExportDate() {
		return janExportDate;
	}

	public void setJanExportDate(Date janExportDate) {
		this.janExportDate = janExportDate;
	}

	public Date getFebExportDate() {
		return febExportDate;
	}

	public void setFebExportDate(Date febExportDate) {
		this.febExportDate = febExportDate;
	}

	public Date getMarExportDate() {
		return marExportDate;
	}

	public void setMarExportDate(Date marExportDate) {
		this.marExportDate = marExportDate;
	}

	public Date getAprExportDate() {
		return aprExportDate;
	}

	public void setAprExportDate(Date aprExportDate) {
		this.aprExportDate = aprExportDate;
	}

	public Date getMayExportDate() {
		return mayExportDate;
	}

	public void setMayExportDate(Date mayExportDate) {
		this.mayExportDate = mayExportDate;
	}

	public Date getJunExportDate() {
		return junExportDate;
	}

	public void setJunExportDate(Date junExportDate) {
		this.junExportDate = junExportDate;
	}

	public Date getJulExportDate() {
		return julExportDate;
	}

	public void setJulExportDate(Date julExportDate) {
		this.julExportDate = julExportDate;
	}

	public Date getAugExportDate() {
		return augExportDate;
	}

	public void setAugExportDate(Date augExportDate) {
		this.augExportDate = augExportDate;
	}

	public Date getSepExportDate() {
		return sepExportDate;
	}

	public void setSepExportDate(Date sepExportDate) {
		this.sepExportDate = sepExportDate;
	}

	public Date getOctExportDate() {
		return octExportDate;
	}

	public void setOctExportDate(Date octExportDate) {
		this.octExportDate = octExportDate;
	}

	public Date getNovExportDate() {
		return novExportDate;
	}

	public void setNovExportDate(Date novExportDate) {
		this.novExportDate = novExportDate;
	}

	public Date getDecExportDate() {
		return decExportDate;
	}

	public void setDecExportDate(Date decExportDate) {
		this.decExportDate = decExportDate;
	}
	
	public SubdailyActivityExtraParams getSubdailyActivityExtraParams() {
		return subdailyActivityExtraParams;
	}

	public void setSubdailyActivityExtraParams(
			SubdailyActivityExtraParams subdailyActivityExtraParams) {
		this.subdailyActivityExtraParams = subdailyActivityExtraParams;
	}
	
	public boolean isUseMidMonthReadings() {
		return useMidMonthReadings;
	}


	public void setUseMidMonthReadings(boolean useMidMonthReadings) {
		this.useMidMonthReadings = useMidMonthReadings;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aprExportDate == null) ? 0 : aprExportDate.hashCode());
		result = prime * result
				+ ((augExportDate == null) ? 0 : augExportDate.hashCode());
		result = prime * result
				+ ((decExportDate == null) ? 0 : decExportDate.hashCode());
		result = prime * result
				+ ((febExportDate == null) ? 0 : febExportDate.hashCode());
		result = prime
				* result
				+ ((inizioSecondoCicloRaccolta == null) ? 0
						: inizioSecondoCicloRaccolta.hashCode());
		result = prime
				* result
				+ ((inizioUltimoCicloRaccolta == null) ? 0
						: inizioUltimoCicloRaccolta.hashCode());
		result = prime * result
				+ ((janExportDate == null) ? 0 : janExportDate.hashCode());
		result = prime * result
				+ ((julExportDate == null) ? 0 : julExportDate.hashCode());
		result = prime * result
				+ ((junExportDate == null) ? 0 : junExportDate.hashCode());
		result = prime * result
				+ ((marExportDate == null) ? 0 : marExportDate.hashCode());
		result = prime * result
				+ ((mayExportDate == null) ? 0 : mayExportDate.hashCode());
		result = prime * result
				+ ((novExportDate == null) ? 0 : novExportDate.hashCode());
		result = prime * result
				+ ((octExportDate == null) ? 0 : octExportDate.hashCode());
		result = prime * result
				+ ((sepExportDate == null) ? 0 : sepExportDate.hashCode());
		result = prime
				* result
				+ ((subdailyActivityExtraParams == null) ? 0
						: subdailyActivityExtraParams.hashCode());
		result = prime * result + (useMidMonthReadings ? 1231 : 1237);
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
		MonthlyMeasuresExtraParams other = (MonthlyMeasuresExtraParams) obj;
		if (aprExportDate == null) {
			if (other.aprExportDate != null)
				return false;
		} else if (!aprExportDate.equals(other.aprExportDate))
			return false;
		if (augExportDate == null) {
			if (other.augExportDate != null)
				return false;
		} else if (!augExportDate.equals(other.augExportDate))
			return false;
		if (decExportDate == null) {
			if (other.decExportDate != null)
				return false;
		} else if (!decExportDate.equals(other.decExportDate))
			return false;
		if (febExportDate == null) {
			if (other.febExportDate != null)
				return false;
		} else if (!febExportDate.equals(other.febExportDate))
			return false;
		if (inizioSecondoCicloRaccolta == null) {
			if (other.inizioSecondoCicloRaccolta != null)
				return false;
		} else if (!inizioSecondoCicloRaccolta
				.equals(other.inizioSecondoCicloRaccolta))
			return false;
		if (inizioUltimoCicloRaccolta == null) {
			if (other.inizioUltimoCicloRaccolta != null)
				return false;
		} else if (!inizioUltimoCicloRaccolta
				.equals(other.inizioUltimoCicloRaccolta))
			return false;
		if (janExportDate == null) {
			if (other.janExportDate != null)
				return false;
		} else if (!janExportDate.equals(other.janExportDate))
			return false;
		if (julExportDate == null) {
			if (other.julExportDate != null)
				return false;
		} else if (!julExportDate.equals(other.julExportDate))
			return false;
		if (junExportDate == null) {
			if (other.junExportDate != null)
				return false;
		} else if (!junExportDate.equals(other.junExportDate))
			return false;
		if (marExportDate == null) {
			if (other.marExportDate != null)
				return false;
		} else if (!marExportDate.equals(other.marExportDate))
			return false;
		if (mayExportDate == null) {
			if (other.mayExportDate != null)
				return false;
		} else if (!mayExportDate.equals(other.mayExportDate))
			return false;
		if (novExportDate == null) {
			if (other.novExportDate != null)
				return false;
		} else if (!novExportDate.equals(other.novExportDate))
			return false;
		if (octExportDate == null) {
			if (other.octExportDate != null)
				return false;
		} else if (!octExportDate.equals(other.octExportDate))
			return false;
		if (sepExportDate == null) {
			if (other.sepExportDate != null)
				return false;
		} else if (!sepExportDate.equals(other.sepExportDate))
			return false;
		if (subdailyActivityExtraParams == null) {
			if (other.subdailyActivityExtraParams != null)
				return false;
		} else if (!subdailyActivityExtraParams
				.equals(other.subdailyActivityExtraParams))
			return false;
		if (useMidMonthReadings != other.useMidMonthReadings)
			return false;
		return true;
	}


	@Override
	public String toString() {
		
		String sInizioSecondoCicloRaccolta = inizioSecondoCicloRaccolta==null?"":DateUtil.formatDate(inizioSecondoCicloRaccolta, "dd/MM/yyyy");
		String sInizioUltimoCicloRaccolta = inizioUltimoCicloRaccolta==null?"":DateUtil.formatDate(inizioUltimoCicloRaccolta, "dd/MM/yyyy");
		String sJanExportDate = janExportDate==null?"":DateUtil.formatDate(janExportDate, "dd/MM/yyyy");
		String sFebExportDate = febExportDate==null?"":DateUtil.formatDate(febExportDate, "dd/MM/yyyy");
		String sMarExportDate = marExportDate==null?"":DateUtil.formatDate(marExportDate, "dd/MM/yyyy");		
		String sAprExportDate = aprExportDate==null?"":DateUtil.formatDate(aprExportDate, "dd/MM/yyyy");
		String sMayExportDate = mayExportDate==null?"":DateUtil.formatDate(mayExportDate, "dd/MM/yyyy");
		String sJunExportDate = junExportDate==null?"":DateUtil.formatDate(junExportDate, "dd/MM/yyyy");
		String sJulExportDate = julExportDate==null?"":DateUtil.formatDate(julExportDate, "dd/MM/yyyy");
		String sAugExportDate = augExportDate==null?"":DateUtil.formatDate(augExportDate, "dd/MM/yyyy");
		String sSepExportDate = sepExportDate==null?"":DateUtil.formatDate(sepExportDate, "dd/MM/yyyy");		
		String sOctExportDate = octExportDate==null?"":DateUtil.formatDate(octExportDate, "dd/MM/yyyy");
		String sNovExportDate = novExportDate==null?"":DateUtil.formatDate(novExportDate, "dd/MM/yyyy");		
		String sDecExportDate = decExportDate==null?"":DateUtil.formatDate(decExportDate, "dd/MM/yyyy");	
		String sSubdailyActivityExtraParams = subdailyActivityExtraParams==null?"":subdailyActivityExtraParams.toString();
		
		String sUseMidMonthReadings = useMidMonthReadings?"Y":"N";
		
		return "MonthlyMeasuresExtraParams [inizioSecondoCicloRaccolta="
				+ sInizioSecondoCicloRaccolta + ", inizioUltimoCicloRaccolta="
				+ sInizioUltimoCicloRaccolta + ", janExportDate="
				+ sJanExportDate + ", febExportDate=" + sFebExportDate
				+ ", marExportDate=" + sMarExportDate + ", aprExportDate="
				+ sAprExportDate + ", mayExportDate=" + sMayExportDate
				+ ", junExportDate=" + sJunExportDate + ", julExportDate="
				+ sJulExportDate + ", augExportDate=" + sAugExportDate
				+ ", sepExportDate=" + sSepExportDate + ", octExportDate="
				+ sOctExportDate + ", novExportDate=" + sNovExportDate 
				+ ", useMidMonthReadings=" + sUseMidMonthReadings 
				+ ", decExportDate=" + sDecExportDate + ", subdailyActivityExtraParams=" + sSubdailyActivityExtraParams + "]";
	}	
			
}
