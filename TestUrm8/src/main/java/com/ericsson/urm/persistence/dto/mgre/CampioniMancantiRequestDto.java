package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.ericsson.mgre.datatypes.Componente;

public class CampioniMancantiRequestDto implements Serializable {
	
	private static final long	serialVersionUID	= 1L;
	
	private Set<String> matricole = null;
	private Date startDate = null;
	private Date endDate = null;
	private Set<Componente> components = null;
	
	public CampioniMancantiRequestDto(Set<String> matricole, Date startDate, Date endDate, Set<Componente> componentes) {
		this.matricole = matricole;
		this.startDate = startDate;
		this.endDate = endDate;
		this.components = componentes;
	}

	public Set<String> getMatricole() {
		return matricole;
	}

	public void setMatricole(Set<String> matricole) {
		this.matricole = matricole;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Componente> getComponents() {
		return components;
	}

	public void setComponents(Set<Componente> components) {
		this.components = components;
	}
}
