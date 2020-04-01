package com.ericsson.urm.persistence.dto;

import java.io.Serializable;

public class CCsLenntComponent implements Serializable {

		private static final long	serialVersionUID	= 1L;

		private String codConcentratore=null;
		private String matricolaLenntCliente;
		private String componente;
		private int missing;
		
		
		public CCsLenntComponent() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CCsLenntComponent(String codConcentratore, String matricolaLenntCliente, String componente, int missing) {
			super();
			this.codConcentratore = codConcentratore;
			this.matricolaLenntCliente = matricolaLenntCliente;
			this.componente = componente;
			this.missing = missing;
		}

		public String getCodConcentratore() {
			return codConcentratore;
		}

		public void setCodConcentratore(String codConcentratore) {
			this.codConcentratore = codConcentratore;
		}

		public String getMatricolaLenntCliente() {
			return matricolaLenntCliente;
		}

		public void setMatricolaLenntCliente(String matricolaLenntCliente) {
			this.matricolaLenntCliente = matricolaLenntCliente;
		}

		public String getComponente() {
			return componente;
		}

		public void setComponente(String componente) {
			this.componente = componente;
		}

		public int getMissing() {
			return missing;
		}

		public void setMissing(int missing) {
			this.missing = missing;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((codConcentratore == null) ? 0 : codConcentratore
							.hashCode());
			result = prime * result
					+ ((componente == null) ? 0 : componente.hashCode());
			result = prime
					* result
					+ ((matricolaLenntCliente == null) ? 0
							: matricolaLenntCliente.hashCode());
			result = prime * result + missing;
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
			CCsLenntComponent other = (CCsLenntComponent) obj;
			if (codConcentratore == null) {
				if (other.codConcentratore != null)
					return false;
			} else if (!codConcentratore.equals(other.codConcentratore))
				return false;
			if (componente == null) {
				if (other.componente != null)
					return false;
			} else if (!componente.equals(other.componente))
				return false;
			if (matricolaLenntCliente == null) {
				if (other.matricolaLenntCliente != null)
					return false;
			} else if (!matricolaLenntCliente
					.equals(other.matricolaLenntCliente))
				return false;
			if (missing != other.missing)
				return false;
			return true;
		}

		
		
		
}
