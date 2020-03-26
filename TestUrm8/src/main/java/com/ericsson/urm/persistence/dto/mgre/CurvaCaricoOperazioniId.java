package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class CurvaCaricoOperazioniId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String  matricolaLenntCliente;
	private Long    taskId;
	
	public CurvaCaricoOperazioniId() {
		super();
	}
	
	public CurvaCaricoOperazioniId(String matricolaLenntCliente, Long taskId) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.taskId = taskId;
	}
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
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
		CurvaCaricoOperazioniId other = (CurvaCaricoOperazioniId) obj;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		}
		else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		}
		else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}
}
