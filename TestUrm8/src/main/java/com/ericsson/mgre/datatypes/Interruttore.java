package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class Interruttore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codInterruttore;
	private String oraInterrProvoc;
	private Integer durataInterruzione;
	private String statoInterruttore;
	private Integer tensione;
	private String primoSportello;
	private String formazioneCavo;
	private String tipo;
	
	public Interruttore() {
	}	

	public Interruttore(String codInterruttore, String oraInterrProvoc,
			Integer durataInterruzione, String statoInterruttore,
			Integer tensione, String primoSportello, String formazioneCavo, String tipo) {
		super();
		this.codInterruttore = codInterruttore;
		this.oraInterrProvoc = oraInterrProvoc;
		this.durataInterruzione = durataInterruzione;
		this.statoInterruttore = statoInterruttore;
		this.tensione = tensione;
		this.primoSportello = primoSportello;
		this.formazioneCavo = formazioneCavo;
		this.tipo = tipo;
	}

	public String getCodInterruttore() {
		return codInterruttore;
	}

	public void setCodInterruttore(String codInterruttore) {
		this.codInterruttore = codInterruttore;
	}

	public String getOraInterrProvoc() {
		return oraInterrProvoc;
	}

	public void setOraInterrProvoc(String oraInterrProvoc) {
		this.oraInterrProvoc = oraInterrProvoc;
	}

	public Integer getDurataInterruzione() {
		return durataInterruzione;
	}

	public void setDurataInterruzione(Integer durataInterruzione) {
		this.durataInterruzione = durataInterruzione;
	}

	public String getStatoInterruttore() {
		return statoInterruttore;
	}

	public void setStatoInterruttore(String statoInterruttore) {
		this.statoInterruttore = statoInterruttore;
	}

	public Integer getTensione() {
		return tensione;
	}

	public void setTensione(Integer tensione) {
		this.tensione = tensione;
	}

	public String getPrimoSportello() {
		return primoSportello;
	}

	public void setPrimoSportello(String primoSportello) {
		this.primoSportello = primoSportello;
	}

	public String getFormazioneCavo() {
		return formazioneCavo;
	}

	public void setFormazioneCavo(String formazioneCavo) {
		this.formazioneCavo = formazioneCavo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codInterruttore == null) ? 0 : codInterruttore.hashCode());
		result = prime
				* result
				+ ((durataInterruzione == null) ? 0 : durataInterruzione
						.hashCode());
		result = prime * result
				+ ((formazioneCavo == null) ? 0 : formazioneCavo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((oraInterrProvoc == null) ? 0 : oraInterrProvoc.hashCode());
		result = prime * result
				+ ((primoSportello == null) ? 0 : primoSportello.hashCode());
		result = prime
				* result
				+ ((statoInterruttore == null) ? 0 : statoInterruttore
						.hashCode());
		result = prime * result
				+ ((tensione == null) ? 0 : tensione.hashCode());
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
		Interruttore other = (Interruttore) obj;
		if (codInterruttore == null) {
			if (other.codInterruttore != null)
				return false;
		} else if (!codInterruttore.equals(other.codInterruttore))
			return false;
		if (durataInterruzione == null) {
			if (other.durataInterruzione != null)
				return false;
		} else if (!durataInterruzione.equals(other.durataInterruzione))
			return false;
		if (formazioneCavo == null) {
			if (other.formazioneCavo != null)
				return false;
		} else if (!formazioneCavo.equals(other.formazioneCavo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (oraInterrProvoc == null) {
			if (other.oraInterrProvoc != null)
				return false;
		} else if (!oraInterrProvoc.equals(other.oraInterrProvoc))
			return false;
		if (primoSportello == null) {
			if (other.primoSportello != null)
				return false;
		} else if (!primoSportello.equals(other.primoSportello))
			return false;
		if (statoInterruttore == null) {
			if (other.statoInterruttore != null)
				return false;
		} else if (!statoInterruttore.equals(other.statoInterruttore))
			return false;
		if (tensione == null) {
			if (other.tensione != null)
				return false;
		} else if (!tensione.equals(other.tensione))
			return false;
		return true;
	}
	
	
		
}