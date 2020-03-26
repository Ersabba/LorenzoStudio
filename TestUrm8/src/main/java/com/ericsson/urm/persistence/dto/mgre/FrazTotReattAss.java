package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;



public class FrazTotReattAss  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long reattIndAssFraz;
	private Long reattIndAssT1Fraz;
	private Long reattIndAssT2Fraz;
	private Long reattIndAssT3Fraz;
	private Long reattIndAssT4Fraz;	
	private Long reattCapAssFraz=null;
	
	private String matricolaLenntCliente;
	private Date dataRil;

	public FrazTotReattAss(){
		super();
	}
	
	public FrazTotReattAss(String matricolaLenntCliente, Date dataRil, Long reattIndAssFraz, 
			Long reattIndAssT1Fraz, Long reattIndAssT2Fraz, Long reattIndAssT3Fraz, 
			Long reattIndAssT4Fraz,  Long reattCapAssFraz){
		
		super();
		this.setMatricolaLenntCliente(matricolaLenntCliente);
		this.setDataRil(dataRil);
		this.reattIndAssFraz=reattIndAssFraz;
		this.reattIndAssT1Fraz=reattIndAssT1Fraz;
		this.reattIndAssT2Fraz=reattIndAssT2Fraz;
		this.reattIndAssT3Fraz=reattIndAssT3Fraz;
		this.reattIndAssT4Fraz=reattIndAssT4Fraz;
		this.reattCapAssFraz=reattCapAssFraz;
	}
	
	

	public Long getReattIndAssFraz() {
		return reattIndAssFraz;
	}

	public void setReattIndAssFraz(Long reattIndAssFraz) {
		this.reattIndAssFraz = reattIndAssFraz;
	}

	public Long getReattIndAssT1Fraz() {
		return reattIndAssT1Fraz;
	}

	public void setReattIndAssT1Fraz(Long reattIndAssT1Fraz) {
		this.reattIndAssT1Fraz = reattIndAssT1Fraz;
	}

	public Long getReattIndAssT2Fraz() {
		return reattIndAssT2Fraz;
	}

	public void setReattIndAssT2Fraz(Long reattIndAssT2Fraz) {
		this.reattIndAssT2Fraz = reattIndAssT2Fraz;
	}

	public Long getReattIndAssT3Fraz() {
		return reattIndAssT3Fraz;
	}

	public void setReattIndAssT3Fraz(Long reattIndAssT3Fraz) {
		this.reattIndAssT3Fraz = reattIndAssT3Fraz;
	}

	public Long getReattIndAssT4Fraz() {
		return reattIndAssT4Fraz;
	}

	public void setReattIndAssT4Fraz(Long reattIndAssT4Fraz) {
		this.reattIndAssT4Fraz = reattIndAssT4Fraz;
	}

	public Long getReattCapAssFraz() {
		return reattCapAssFraz;
	}

	public void setReattCapAssFraz(Long reattCapAssFraz) {
		this.reattCapAssFraz = reattCapAssFraz;
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

	@Override
	public String toString() {
		return "FrazTotReattAss [reattIndAssFraz=" + reattIndAssFraz
				+ ", reattIndAssT1Fraz=" + reattIndAssT1Fraz
				+ ", reattIndAssT2Fraz=" + reattIndAssT2Fraz
				+ ", reattIndAssT3Fraz=" + reattIndAssT3Fraz
				+ ", reattIndAssT4Fraz=" + reattIndAssT4Fraz
				+ ", reattCapAssFraz=" + reattCapAssFraz
				+ ", matricolaLenntCliente=" + matricolaLenntCliente
				+ ", dataRil=" + dataRil + "]";
	}
	
	

}