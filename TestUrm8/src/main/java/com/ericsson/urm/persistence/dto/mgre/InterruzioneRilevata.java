package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.core.enumeration.Phase;
import com.ericsson.urm.util.DateUtil;


public class InterruzioneRilevata implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private long				id;
	private String				matricolaLenntCliente;
	private Date				timestampEvento;
	private String				tipoEvento;
	private String				fase;
	private String				codConcentratore;
	private Integer				durataEvento; // in secondi; se non si trova l'evento di fine vale Integer.MAX_VALUE
	
	
	
	public Integer getDurataEvento() {
		return durataEvento;
	}
	public void setDurataEvento(Integer durataEvento) {
		this.durataEvento = durataEvento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public Date getTimestampEvento() {
		return timestampEvento;
	}
	public void setTimestampEvento(Date timestampEvento) {
		this.timestampEvento = timestampEvento;
	}
	
	public void setTipoEvento(String tipoEvento) {
		if (tipoEvento == null)
			throw new IllegalArgumentException("tipoEvento argument cannot be NULL");
		
		this.tipoEvento = TipoEvento.parse(tipoEvento).toString();
	}
	
	public TipoEvento getTipoEvento() {
		return tipoEvento !=null ? TipoEvento.parse(tipoEvento) : null;
	}
	public void setTipoEventoAsEnum(TipoEvento tipoEvento) {
		if (tipoEvento == null)
			throw new IllegalArgumentException("tipoEvento argument cannot be NULL");
		
		this.tipoEvento = tipoEvento.toString();
	}
	
	public Phase getFase() {
		return fase !=null ? Phase.parse(fase) : null;
	}
	public void setFase(String fase) {
		if (fase == null)
			this.fase = null;
		else
			this.fase = Phase.parse(fase).toString();
	}
	
	public void setFaseAsEnum(Phase fase) {
		if (fase == null)
			this.fase = null;
		else
			this.fase = fase.toString();
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	
	public static enum TipoEvento {
		INIZIO, FINE;
		
		public static TipoEvento parse(String tipoEvento)	{
			for (TipoEvento curr : TipoEvento.values()) {
				if(curr.toString().equalsIgnoreCase(tipoEvento)) { return curr; }
			}
		
			throw new IllegalArgumentException ("TipoEvento: unsupported tipoEvento: " + tipoEvento);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((durataEvento == null) ? 0 : durataEvento.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente.hashCode());
		result = prime * result + ((timestampEvento == null) ? 0 : timestampEvento.hashCode());
		result = prime * result + ((tipoEvento == null) ? 0 : tipoEvento.hashCode());
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
		InterruzioneRilevata other = (InterruzioneRilevata) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		}
		else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (durataEvento == null) {
			if (other.durataEvento != null)
				return false;
		}
		else if (!durataEvento.equals(other.durataEvento))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		}
		else if (!fase.equals(other.fase))
			return false;
//		if (id != other.id)
//			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		}
		else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (timestampEvento == null) {
			if (other.timestampEvento != null)
				return false;
		}
		else if (!timestampEvento.equals(other.timestampEvento))
			return false;
		if (tipoEvento == null) {
			if (other.tipoEvento != null)
				return false;
		}
		else if (!tipoEvento.equals(other.tipoEvento))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String ora = "";
		if (timestampEvento != null)
			ora = ",h=" + DateUtil.formatDate(timestampEvento, "HH:mm:ss");
		return "Ril[id=" + id + ",m=" + matricolaLenntCliente + ora + ",d=" + durataEvento + "s] ";
	}
}
