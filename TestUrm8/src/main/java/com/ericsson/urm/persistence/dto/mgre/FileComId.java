package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class FileComId implements Serializable{

    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;


    @Column(name="COD_CONCENTRATORE")
    private String codiceConcentratore;

    @Column(name="ACQ_DATE")
    private Date acquisitionDate;

    @Column(name="MTR")
    private String matricola;

    public FileComId(){};

    public FileComId(String codiceConcentratore, Date acquisitionDate, String matricola) {
        this.codiceConcentratore = codiceConcentratore;
        this.acquisitionDate = acquisitionDate;
        this.matricola = matricola;
    }

    public String getCodiceConcentratore() {
        return codiceConcentratore;
    }

    public void setCodiceConcentratore(String codiceConcentratore) {
        this.codiceConcentratore = codiceConcentratore;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

	@Override
	public String toString() {
		return "FileComId [codiceConcentratore=" + codiceConcentratore + ", acquisitionDate=" + acquisitionDate
				+ ", matricola=" + matricola + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result + ((codiceConcentratore == null) ? 0 : codiceConcentratore.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
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
		FileComId other = (FileComId) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (codiceConcentratore == null) {
			if (other.codiceConcentratore != null)
				return false;
		} else if (!codiceConcentratore.equals(other.codiceConcentratore))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}


}
