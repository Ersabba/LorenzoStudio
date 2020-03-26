package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class FileAddCurrentId implements Serializable{

    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;


    @Column(name="COD_CONCENTRATORE")
    private String codiceConcentratore;

    @Column(name="MATRICOLA_LENNT_CLIENTE")
    private String matricola;

    public FileAddCurrentId(){};

    public FileAddCurrentId(String codiceConcentratore, String matricola) {
        this.codiceConcentratore = codiceConcentratore;
        this.matricola = matricola;
    }

    public String getCodiceConcentratore() {
        return codiceConcentratore;
    }

    public void setCodiceConcentratore(String codiceConcentratore) {
        this.codiceConcentratore = codiceConcentratore;
    }

   
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

	@Override
	public String toString() {
		return "FileAddCurrentId [codiceConcentratore=" + codiceConcentratore + ", matricola=" + matricola + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		FileAddCurrentId other = (FileAddCurrentId) obj;
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
