package com.ericsson.urm.device.driver.loadcurves;

import java.io.Serializable;
import java.util.Date;

public class LoadMonthlyCurveReadingResponse implements Serializable {

	private static final long serialVersionUID = -1L;

	private Date curveDate = null;
	private int periodRequest = 0;

	private LoadCurveComponentType componentType = null;
	
	private Curve curveMensili = null;
	
	public Date getCurveDate() {
		return curveDate;
	}


	public void setCurveDate(Date curveDate) {
		this.curveDate = curveDate;
	}


	public int getPeriodRequest() {
		return periodRequest;
	}


	public void setPeriodRequest(int periodRequest) {
		this.periodRequest = periodRequest;
	}


	public LoadCurveComponentType getComponentType() {
		return componentType;
	}


	public void setComponentType(LoadCurveComponentType componentType) {
		this.componentType = componentType;
	}


	public Curve getCurveMensili() {
		return curveMensili;
	}


	public void setCurveMensili(Curve curveMensili) {
		this.curveMensili = curveMensili;
	}

	public static class Curve  implements Serializable {
		
		private static final long serialVersionUID = -1L;
		
		private int tipoPotenza = -1;
		private boolean periodoCurva0_12 = false;
		private boolean periodoCurva12_24 = false;
		private boolean meseCorrente = true;
		private int[] valori = null;
		
		public int getTipoPotenza() {
			return tipoPotenza;
		}
		public void setTipoPotenza(int tipoPotenza) {
			this.tipoPotenza = tipoPotenza;
		}
		public boolean isPeriodoCurva0_12() {
			return periodoCurva0_12;
		}
		public void setPeriodoCurva0_12(boolean periodoCurva0_12) {
			this.periodoCurva0_12 = periodoCurva0_12;
		}
		public boolean isMeseCorrente() {
			return meseCorrente;
		}
		public void setMeseCorrente(boolean meseCorrente) {
			this.meseCorrente = meseCorrente;
		}
		public int[] getValori() {
			return valori;
		}
		public void setValori(int[] valori) {
			this.valori = valori;
		}
		public boolean isPeriodoCurva12_24() {
			return periodoCurva12_24;
		}
		public void setPeriodoCurva12_24(boolean periodoCurva12_24) {
			this.periodoCurva12_24 = periodoCurva12_24;
		}
		
		
	}
	
	

}
