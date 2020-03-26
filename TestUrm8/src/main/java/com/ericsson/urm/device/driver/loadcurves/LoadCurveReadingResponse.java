package com.ericsson.urm.device.driver.loadcurves;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoadCurveReadingResponse implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private Date curveDate = null;
	private int periodRequest = 0;
	private boolean allPeriodRequest = false;

	private LoadCurveComponentType componentType = null;
	private List<Curve> curves = new ArrayList<Curve>();

	public static class Curve  implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -1L;
		private Date startTime = null;
		private Date endTime = null;
		private boolean summerToSolarTimeChange = false;
		private int tariffAbsorbedType = -1;
		private int tariffSuppliedType = -1;
		private boolean valid = true;
		private int value = -1;
		private int periodNumber = -1;
		private String integrationPeriodReference = null;
		private int status=-1;

		public Curve() {
			super();
		}

		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}

		/**
		 * Flag che indica che il campione della curva è aggiuntivo perché riferito all'ora
		 * del passaggio da ora legale a ora solare: in questa occasione si aggiunge un ora, alle 3 l'orologio 
		 * va riportato alle 2
		 * @return true se il campione è un campione aggiuntivo
		 */
		public boolean isSummerToSolarTimeChange() {
			return summerToSolarTimeChange;
		}

		/**
		 * Valorizzazione del flag che indica che il campione della curva è aggiuntivo perché riferito all'ora
		 * del passaggio da ora legale a ora solare: in questa occasione si aggiunge un ora, alle 3 l'orologio 
		 * va riportato alle 2
		 * @param summerToSolarTimeChange
		 */
		public void setSummerToSolarTimeChange(boolean summerToSolarTimeChange) {
			this.summerToSolarTimeChange = summerToSolarTimeChange;
		}

		public int getTariffAbsorbedType() {
			return tariffAbsorbedType;
		}

		public void setTariffAbsorbedType(int tariffAbsorbedType) {
			this.tariffAbsorbedType = tariffAbsorbedType;
		}

		public int getTariffSuppliedType() {
			return tariffSuppliedType;
		}

		public void setTariffSuppliedType(int tariffSuppliedType) {
			this.tariffSuppliedType = tariffSuppliedType;
		}

		/**
		 * Valore booleano che indica che il campione è pienamente valido. Se il flag è false il campione 
		 * non è valido benché presente. In questo caso il suo status sarà diverso da 4 =  campione presente 
		 * e completamente elaborato.
		 * @return
		 */
		public boolean isValid() {
			return valid;
		}

		public void setValid(boolean valid) {
			this.valid = valid;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public String getIntegrationPeriodReference() {
			return integrationPeriodReference;
		}

		public void setIntegrationPeriodReference(String integrationPeriodReference) {
			this.integrationPeriodReference = integrationPeriodReference;
		}

		public int getPeriodNumber() {
			return periodNumber;
		}

		public void setPeriodNumber(int periodNumber) {
			this.periodNumber = periodNumber;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
		public FlagStatoCampione getStatusDec() {

			if(((status >> 2) & 0x01) == 1) 
				return FlagStatoCampione.ValidSample; 
			
			if(((status >> 1) & 0x01) == 1)
				return FlagStatoCampione.NotElaborated;
			
			if((status & 0x01) == 1)
				return FlagStatoCampione.PowerFail;
			
			return FlagStatoCampione.Unknown;
		}
		
		public static enum FlagStatoCampione {
			ValidSample("V"), NotElaborated("N"), PowerFail("F"), Unknown("U");
			
			private String flag = "";
			private FlagStatoCampione(String flag){
				this.flag = flag;
			}
			
			public String getFlag() {
				return flag;
			}

			public static FlagStatoCampione parse(String flag){
				for(FlagStatoCampione f : FlagStatoCampione.values()){
					if(f.toString().equalsIgnoreCase(flag) || f.flag.equalsIgnoreCase(flag)) {
						return f;
					}
				}
				throw new IllegalArgumentException("Stato campione non valido");
				
			}
		}

	}
	
	public Date getCurveDate() {
		return curveDate;
	}

	public LoadCurveComponentType getComponentType() {
		return componentType;
	}

	public List<Curve> getCurves() {
		return curves;
	}
	
	public void setCurveDate(Date curveDate) {
		this.curveDate = curveDate;
	}

	public void setComponentType(LoadCurveComponentType componentType) {
		if(componentType==null)
			throw new IllegalArgumentException("Null value not admitted");
		this.componentType = componentType;
	}

	public void setCurves(List<Curve> curves) {
		this.curves = curves;
	}

	public int getPeriodRequest() {
		return periodRequest;
	}

	public void setPeriodRequest(int periodRequest) {
		this.periodRequest = periodRequest;
	}

	public boolean isAllPeriodRequest() {
		return allPeriodRequest;
	}

	public void setAllPeriodRequest(boolean allPeriodRequest) {
		this.allPeriodRequest = allPeriodRequest;
	}

	@Override
	public String toString() {
		return "LoadCurveReadingResponse [curveDate=" + curveDate + ", periodRequest=" + periodRequest
				+ ", allPeriodRequest=" + allPeriodRequest + ", componentType=" + componentType + ", curves=" + curves
				+ "]";
	}

}
