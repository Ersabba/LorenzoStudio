package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;
import java.util.GregorianCalendar;


public class MensileAttAssId implements java.io.Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private String mese=null;
	private String anno=null;
	
	
		
	public MensileAttAssId(String matricolaLenntCliente, String mese, String anno) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.mese = ("00"+mese).substring(mese.length());
		this.anno = ("0000"+anno).substring(anno.length());
	}
	
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public MensileAttAssId(String matricolaLenntCliente, Date referenceDate) {
		super();
		
		GregorianCalendar cal = new GregorianCalendar ();
		cal.setTime(referenceDate);
		String year = String.valueOf(cal.get(GregorianCalendar.YEAR));
		String month = String.valueOf(cal.get(GregorianCalendar.MONTH)+1);
		
		this.matricolaLenntCliente = matricolaLenntCliente;
		
		this.mese = ("00"+month).substring(month.length());
		this.anno = ("0000"+year).substring(year.length());
	}

	public MensileAttAssId(){
		
	}


	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}


	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}


	public String getMese() {
		return mese;
	}


	public void setMese(String mese) {
		this.mese = mese;
	}


	public String getAnno() {
		return anno;
	}


	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String toString() {
		return "MensileAttAssId [anno=" + anno + ", matricolaLenntCliente=" + matricolaLenntCliente + ", mese=" + mese + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MensileAttAssId that = (MensileAttAssId) o;

		if (!getMatricolaLenntCliente().equals(that.getMatricolaLenntCliente())) return false;
		if (!getMese().equals(that.getMese())) return false;
		return getAnno().equals(that.getAnno());
	}

	@Override
	public int hashCode() {
		int result = getMatricolaLenntCliente().hashCode();
		result = 31 * result + getMese().hashCode();
		result = 31 * result + getAnno().hashCode();
		return result;
	}
}