package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class CdcStatisticsData implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private String  matricola;
	private String pod;
    private Date dataUltimaLettura;
    private String presenzaFineMeseCorrente; 
    private String periodoCurve;
    private Long curveEEACorrente;
    private Long curveAtteseEEACorrente;
    private Long curveEEICorrente;
    private Long curveAtteseEEICorrente; 
    private Long curveEECCorrente;
    private Long curveAtteseEECCorrente;
    private Long curveEEAPrecedente;
    private Long curveAtteseEEAPrecedente;
    private Long curveEEIPrecedente;
    private Long curveAtteseEEIPrecedente;
    private Long curveEECPrecedente;
    private Long curveAtteseEECPrecedente;
    private String percEEACorrente;
    private String percEEICorrente;
    private String percEECCorrente;
    private String percEEAPrecedente;
    private String percEEIPrecedente;
    private String percEECPrecedente;
    
    public CdcStatisticsData() {
    	
    }
    
	public CdcStatisticsData(String matricola, String pod, Date dataUltimaLettura, String presenzaFineMeseCorrente,
			String periodoCurve, Long curveEEACorrente, Long curveAtteseEEACorrente, Long curveEEICorrente,
			Long curveAtteseEEICorrente, Long curveEECCorrente, Long curveAtteseEECCorrente, Long curveEEAPrecedente,
			Long curveAtteseEEAPrecedente, Long curveEEIPrecedente, Long curveAtteseEEIPrecedente,
			Long curveEECPrecedente, Long curveAtteseEECPrecedente, String percEEACorrente, String percEEICorrente,
			String percEECCorrente, String percEEAPrecedente, String percEEIPrecedente, String percEECPrecedente) {
		super();
		this.matricola = matricola;
		this.pod = pod;
		this.dataUltimaLettura = dataUltimaLettura;
		this.presenzaFineMeseCorrente = presenzaFineMeseCorrente;
		this.periodoCurve = periodoCurve;
		this.curveEEACorrente = curveEEACorrente;
		this.curveAtteseEEACorrente = curveAtteseEEACorrente;
		this.curveEEICorrente = curveEEICorrente;
		this.curveAtteseEEICorrente = curveAtteseEEICorrente;
		this.curveEECCorrente = curveEECCorrente;
		this.curveAtteseEECCorrente = curveAtteseEECCorrente;
		this.curveEEAPrecedente = curveEEAPrecedente;
		this.curveAtteseEEAPrecedente = curveAtteseEEAPrecedente;
		this.curveEEIPrecedente = curveEEIPrecedente;
		this.curveAtteseEEIPrecedente = curveAtteseEEIPrecedente;
		this.curveEECPrecedente = curveEECPrecedente;
		this.curveAtteseEECPrecedente = curveAtteseEECPrecedente;
		this.percEEACorrente = percEEACorrente;
		this.percEEICorrente = percEEICorrente;
		this.percEECCorrente = percEECCorrente;
		this.percEEAPrecedente = percEEAPrecedente;
		this.percEEIPrecedente = percEEIPrecedente;
		this.percEECPrecedente = percEECPrecedente;
	}
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public Date getDataUltimaLettura() {
		return dataUltimaLettura;
	}

	public void setDataUltimaLettura(Date dataUltimaLettura) {
		this.dataUltimaLettura = dataUltimaLettura;
	}

	public String getPresenzaFineMeseCorrente() {
		return presenzaFineMeseCorrente;
	}

	public void setPresenzaFineMeseCorrente(String presenzaFineMeseCorrente) {
		this.presenzaFineMeseCorrente = presenzaFineMeseCorrente;
	}

	public String getPeriodoCurve() {
		return periodoCurve;
	}

	public void setPeriodoCurve(String periodoCurve) {
		this.periodoCurve = periodoCurve;
	}

	public Long getCurveEEACorrente() {
		return curveEEACorrente;
	}

	public void setCurveEEACorrente(Long curveEEACorrente) {
		this.curveEEACorrente = curveEEACorrente;
	}

	public Long getCurveAtteseEEACorrente() {
		return curveAtteseEEACorrente;
	}

	public void setCurveAtteseEEACorrente(Long curveAtteseEEACorrente) {
		this.curveAtteseEEACorrente = curveAtteseEEACorrente;
	}

	public Long getCurveEEICorrente() {
		return curveEEICorrente;
	}

	public void setCurveEEICorrente(Long curveEEICorrente) {
		this.curveEEICorrente = curveEEICorrente;
	}

	public Long getCurveAtteseEEICorrente() {
		return curveAtteseEEICorrente;
	}

	public void setCurveAtteseEEICorrente(Long curveAtteseEEICorrente) {
		this.curveAtteseEEICorrente = curveAtteseEEICorrente;
	}

	public Long getCurveEECCorrente() {
		return curveEECCorrente;
	}

	public void setCurveEECCorrente(Long curveEECCorrente) {
		this.curveEECCorrente = curveEECCorrente;
	}

	public Long getCurveAtteseEECCorrente() {
		return curveAtteseEECCorrente;
	}

	public void setCurveAtteseEECCorrente(Long curveAtteseEECCorrente) {
		this.curveAtteseEECCorrente = curveAtteseEECCorrente;
	}

	public Long getCurveEEAPrecedente() {
		return curveEEAPrecedente;
	}

	public void setCurveEEAPrecedente(Long curveEEAPrecedente) {
		this.curveEEAPrecedente = curveEEAPrecedente;
	}

	public Long getCurveAtteseEEAPrecedente() {
		return curveAtteseEEAPrecedente;
	}

	public void setCurveAtteseEEAPrecedente(Long curveAtteseEEAPrecedente) {
		this.curveAtteseEEAPrecedente = curveAtteseEEAPrecedente;
	}

	public Long getCurveEEIPrecedente() {
		return curveEEIPrecedente;
	}

	public void setCurveEEIPrecedente(Long curveEEIPrecedente) {
		this.curveEEIPrecedente = curveEEIPrecedente;
	}

	public Long getCurveAtteseEEIPrecedente() {
		return curveAtteseEEIPrecedente;
	}

	public void setCurveAtteseEEIPrecedente(Long curveAtteseEEIPrecedente) {
		this.curveAtteseEEIPrecedente = curveAtteseEEIPrecedente;
	}

	public Long getCurveEECPrecedente() {
		return curveEECPrecedente;
	}

	public void setCurveEECPrecedente(Long curveEECPrecedente) {
		this.curveEECPrecedente = curveEECPrecedente;
	}

	public Long getCurveAtteseEECPrecedente() {
		return curveAtteseEECPrecedente;
	}

	public void setCurveAtteseEECPrecedente(Long curveAtteseEECPrecedente) {
		this.curveAtteseEECPrecedente = curveAtteseEECPrecedente;
	}

	public String getPercEEACorrente() {
		return percEEACorrente;
	}

	public void setPercEEACorrente(String percEEACorrente) {
		this.percEEACorrente = percEEACorrente;
	}

	public String getPercEEICorrente() {
		return percEEICorrente;
	}

	public void setPercEEICorrente(String percEEICorrente) {
		this.percEEICorrente = percEEICorrente;
	}

	public String getPercEECCorrente() {
		return percEECCorrente;
	}

	public void setPercEECCorrente(String percEECCorrente) {
		this.percEECCorrente = percEECCorrente;
	}

	public String getPercEEAPrecedente() {
		return percEEAPrecedente;
	}

	public void setPercEEAPrecedente(String percEEAPrecedente) {
		this.percEEAPrecedente = percEEAPrecedente;
	}

	public String getPercEEIPrecedente() {
		return percEEIPrecedente;
	}

	public void setPercEEIPrecedente(String percEEIPrecedente) {
		this.percEEIPrecedente = percEEIPrecedente;
	}

	public String getPercEECPrecedente() {
		return percEECPrecedente;
	}

	public void setPercEECPrecedente(String percEECPrecedente) {
		this.percEECPrecedente = percEECPrecedente;
	}

	@Override
	public String toString() {
		return "CdcStatisticsData [matricola=" + matricola + ", pod=" + pod + ", dataUltimaLettura=" + dataUltimaLettura
				+ ", presenzaFineMeseCorrente=" + presenzaFineMeseCorrente + ", periodoCurve=" + periodoCurve
				+ ", curveEEACorrente=" + curveEEACorrente + ", curveAtteseEEACorrente=" + curveAtteseEEACorrente
				+ ", curveEEICorrente=" + curveEEICorrente + ", curveAtteseEEICorrente=" + curveAtteseEEICorrente
				+ ", curveEECCorrente=" + curveEECCorrente + ", curveAtteseEECCorrente=" + curveAtteseEECCorrente
				+ ", curveEEAPrecedente=" + curveEEAPrecedente + ", curveAtteseEEAPrecedente="
				+ curveAtteseEEAPrecedente + ", curveEEIPrecedente=" + curveEEIPrecedente
				+ ", curveAtteseEEIPrecedente=" + curveAtteseEEIPrecedente + ", curveEECPrecedente="
				+ curveEECPrecedente + ", curveAtteseEECPrecedente=" + curveAtteseEECPrecedente + ", percEEACorrente="
				+ percEEACorrente + ", percEEICorrente=" + percEEICorrente + ", percEECCorrente=" + percEECCorrente
				+ ", percEEAPrecedente=" + percEEAPrecedente + ", percEEIPrecedente=" + percEEIPrecedente
				+ ", percEECPrecedente=" + percEECPrecedente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curveAtteseEEACorrente == null) ? 0 : curveAtteseEEACorrente.hashCode());
		result = prime * result + ((curveAtteseEEAPrecedente == null) ? 0 : curveAtteseEEAPrecedente.hashCode());
		result = prime * result + ((curveAtteseEECCorrente == null) ? 0 : curveAtteseEECCorrente.hashCode());
		result = prime * result + ((curveAtteseEECPrecedente == null) ? 0 : curveAtteseEECPrecedente.hashCode());
		result = prime * result + ((curveAtteseEEICorrente == null) ? 0 : curveAtteseEEICorrente.hashCode());
		result = prime * result + ((curveAtteseEEIPrecedente == null) ? 0 : curveAtteseEEIPrecedente.hashCode());
		result = prime * result + ((curveEEACorrente == null) ? 0 : curveEEACorrente.hashCode());
		result = prime * result + ((curveEEAPrecedente == null) ? 0 : curveEEAPrecedente.hashCode());
		result = prime * result + ((curveEECCorrente == null) ? 0 : curveEECCorrente.hashCode());
		result = prime * result + ((curveEECPrecedente == null) ? 0 : curveEECPrecedente.hashCode());
		result = prime * result + ((curveEEICorrente == null) ? 0 : curveEEICorrente.hashCode());
		result = prime * result + ((curveEEIPrecedente == null) ? 0 : curveEEIPrecedente.hashCode());
		result = prime * result + ((dataUltimaLettura == null) ? 0 : dataUltimaLettura.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((percEEACorrente == null) ? 0 : percEEACorrente.hashCode());
		result = prime * result + ((percEEAPrecedente == null) ? 0 : percEEAPrecedente.hashCode());
		result = prime * result + ((percEECCorrente == null) ? 0 : percEECCorrente.hashCode());
		result = prime * result + ((percEECPrecedente == null) ? 0 : percEECPrecedente.hashCode());
		result = prime * result + ((percEEICorrente == null) ? 0 : percEEICorrente.hashCode());
		result = prime * result + ((percEEIPrecedente == null) ? 0 : percEEIPrecedente.hashCode());
		result = prime * result + ((periodoCurve == null) ? 0 : periodoCurve.hashCode());
		result = prime * result + ((pod == null) ? 0 : pod.hashCode());
		result = prime * result + ((presenzaFineMeseCorrente == null) ? 0 : presenzaFineMeseCorrente.hashCode());
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
		CdcStatisticsData other = (CdcStatisticsData) obj;
		if (curveAtteseEEACorrente == null) {
			if (other.curveAtteseEEACorrente != null)
				return false;
		} else if (!curveAtteseEEACorrente.equals(other.curveAtteseEEACorrente))
			return false;
		if (curveAtteseEEAPrecedente == null) {
			if (other.curveAtteseEEAPrecedente != null)
				return false;
		} else if (!curveAtteseEEAPrecedente.equals(other.curveAtteseEEAPrecedente))
			return false;
		if (curveAtteseEECCorrente == null) {
			if (other.curveAtteseEECCorrente != null)
				return false;
		} else if (!curveAtteseEECCorrente.equals(other.curveAtteseEECCorrente))
			return false;
		if (curveAtteseEECPrecedente == null) {
			if (other.curveAtteseEECPrecedente != null)
				return false;
		} else if (!curveAtteseEECPrecedente.equals(other.curveAtteseEECPrecedente))
			return false;
		if (curveAtteseEEICorrente == null) {
			if (other.curveAtteseEEICorrente != null)
				return false;
		} else if (!curveAtteseEEICorrente.equals(other.curveAtteseEEICorrente))
			return false;
		if (curveAtteseEEIPrecedente == null) {
			if (other.curveAtteseEEIPrecedente != null)
				return false;
		} else if (!curveAtteseEEIPrecedente.equals(other.curveAtteseEEIPrecedente))
			return false;
		if (curveEEACorrente == null) {
			if (other.curveEEACorrente != null)
				return false;
		} else if (!curveEEACorrente.equals(other.curveEEACorrente))
			return false;
		if (curveEEAPrecedente == null) {
			if (other.curveEEAPrecedente != null)
				return false;
		} else if (!curveEEAPrecedente.equals(other.curveEEAPrecedente))
			return false;
		if (curveEECCorrente == null) {
			if (other.curveEECCorrente != null)
				return false;
		} else if (!curveEECCorrente.equals(other.curveEECCorrente))
			return false;
		if (curveEECPrecedente == null) {
			if (other.curveEECPrecedente != null)
				return false;
		} else if (!curveEECPrecedente.equals(other.curveEECPrecedente))
			return false;
		if (curveEEICorrente == null) {
			if (other.curveEEICorrente != null)
				return false;
		} else if (!curveEEICorrente.equals(other.curveEEICorrente))
			return false;
		if (curveEEIPrecedente == null) {
			if (other.curveEEIPrecedente != null)
				return false;
		} else if (!curveEEIPrecedente.equals(other.curveEEIPrecedente))
			return false;
		if (dataUltimaLettura == null) {
			if (other.dataUltimaLettura != null)
				return false;
		} else if (!dataUltimaLettura.equals(other.dataUltimaLettura))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		if (percEEACorrente == null) {
			if (other.percEEACorrente != null)
				return false;
		} else if (!percEEACorrente.equals(other.percEEACorrente))
			return false;
		if (percEEAPrecedente == null) {
			if (other.percEEAPrecedente != null)
				return false;
		} else if (!percEEAPrecedente.equals(other.percEEAPrecedente))
			return false;
		if (percEECCorrente == null) {
			if (other.percEECCorrente != null)
				return false;
		} else if (!percEECCorrente.equals(other.percEECCorrente))
			return false;
		if (percEECPrecedente == null) {
			if (other.percEECPrecedente != null)
				return false;
		} else if (!percEECPrecedente.equals(other.percEECPrecedente))
			return false;
		if (percEEICorrente == null) {
			if (other.percEEICorrente != null)
				return false;
		} else if (!percEEICorrente.equals(other.percEEICorrente))
			return false;
		if (percEEIPrecedente == null) {
			if (other.percEEIPrecedente != null)
				return false;
		} else if (!percEEIPrecedente.equals(other.percEEIPrecedente))
			return false;
		if (periodoCurve == null) {
			if (other.periodoCurve != null)
				return false;
		} else if (!periodoCurve.equals(other.periodoCurve))
			return false;
		if (pod == null) {
			if (other.pod != null)
				return false;
		} else if (!pod.equals(other.pod))
			return false;
		if (presenzaFineMeseCorrente == null) {
			if (other.presenzaFineMeseCorrente != null)
				return false;
		} else if (!presenzaFineMeseCorrente.equals(other.presenzaFineMeseCorrente))
			return false;
		return true;
	}
    
}