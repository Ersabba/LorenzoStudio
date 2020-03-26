package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;


public class FrazTotAttAss  implements java.io.Serializable, TotAttAssInterfaceFraz {
	
	private static final long serialVersionUID = 1L;

	private Long attAssFraz;
	private Long attAssT1Fraz;
	private Long attAssT2Fraz;
	private Long attAssT3Fraz;
	private Long attAssT4Fraz;
	private String codConcentratore;
	private String matricolaLenntCliente;
	private Date dataRil;
	
	public FrazTotAttAss(){
		super();
	}
	
	public FrazTotAttAss(String matricolaLenntCliente, Date dataRil, Long attAssFraz,
			Long attAssT1Fraz, Long attAssT2Fraz, Long attAssT3Fraz, Long attAssT4Fraz){
		super();
		this.setMatricolaLenntCliente(matricolaLenntCliente);
		this.setDataRil(dataRil);
		this.attAssFraz = attAssFraz;
		this.attAssT1Fraz = attAssT1Fraz;
		this.attAssT2Fraz = attAssT2Fraz;
		this.attAssT3Fraz = attAssT3Fraz;
		this.attAssT4Fraz = attAssT4Fraz;
	}

	
	public Long getAttAssFraz() {
		return attAssFraz;
	}

	public void setAttAssFraz(Long attAssFraz) {
		this.attAssFraz = attAssFraz;
	}

	public Long getAttAssT1Fraz() {
		return attAssT1Fraz;
	}

	public void setAttAssT1Fraz(Long attAssT1Fraz) {
		this.attAssT1Fraz = attAssT1Fraz;
	}

	public Long getAttAssT2Fraz() {
		return attAssT2Fraz;
	}

	public void setAttAssT2Fraz(Long attAssT2Fraz) {
		this.attAssT2Fraz = attAssT2Fraz;
	}

	public Long getAttAssT3Fraz() {
		return attAssT3Fraz;
	}

	public void setAttAssT3Fraz(Long attAssT3Fraz) {
		this.attAssT3Fraz = attAssT3Fraz;
	}

	public Long getAttAssT4Fraz() {
		return attAssT4Fraz;
	}

	public void setAttAssT4Fraz(Long attAssT4Fraz) {
		this.attAssT4Fraz = attAssT4Fraz;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	
	

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	@Override
	public String toString() {
		return "FrazTotAttAss [attAssFraz=" + attAssFraz + ", attAssT1Fraz="
				+ attAssT1Fraz + ", attAssT2Fraz=" + attAssT2Fraz
				+ ", attAssT3Fraz=" + attAssT3Fraz + ", attAssT4Fraz="
				+ attAssT4Fraz + ", matricolaLenntCliente="
				+ matricolaLenntCliente + ", dataRil=" + dataRil 
				+ ", codConcentratore=" + codConcentratore + "]";
	}
	
	
}