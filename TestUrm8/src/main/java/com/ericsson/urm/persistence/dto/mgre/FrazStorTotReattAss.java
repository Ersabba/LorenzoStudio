package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;


public class FrazStorTotReattAss  implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private Long reattIndAssFraz;
	private Long reattIndAssT1Fraz;
	private Long reattIndAssT2Fraz;
	private Long reattIndAssT3Fraz;
	private Long reattIndAssT4Fraz;	
	private Long reattCapAssFraz=null;
	private FrazStorTotReattAssId id=null;
	
	public FrazStorTotReattAss(){
		
	}
	
	
	public FrazStorTotReattAss(String matricolaLenntCliente, Date dataRil, Long reattIndAssFraz, 
			Long reattIndAssT1Fraz, Long reattIndAssT2Fraz, Long reattIndAssT3Fraz, 
			Long reattIndAssT4Fraz,  Long reattCapAssFraz){
		
		super();
		FrazStorTotReattAssId id = new FrazStorTotReattAssId(matricolaLenntCliente, dataRil);
		this.setId(id);
		this.reattIndAssFraz=reattIndAssFraz;
		this.reattIndAssT1Fraz=reattIndAssT1Fraz;
		this.reattIndAssT2Fraz=reattIndAssT2Fraz;
		this.reattIndAssT3Fraz=reattIndAssT3Fraz;
		this.reattIndAssT4Fraz=reattIndAssT4Fraz;
		this.reattCapAssFraz=reattCapAssFraz;
	}
	public FrazStorTotReattAss(FrazStorTotReattAssId id){
		this.id = id;
	}

	public FrazStorTotReattAssId getId() {
		return id;
	}

	public void setId(FrazStorTotReattAssId id) {
		this.id = id;
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
		if(id!=null)
			return id.getMatricolaLenntCliente();
		else return null;
	}

	public Date getDataRil() {
		if(id!=null)
			return id.getDataRil();
		else return null;
	}
	@Override
	public String toString() {
		return "FrazStorTotReattAss [reattIndAssFraz=" + reattIndAssFraz
				+ ", reattIndAssT1Fraz=" + reattIndAssT1Fraz
				+ ", reattIndAssT2Fraz=" + reattIndAssT2Fraz
				+ ", reattIndAssT3Fraz=" + reattIndAssT3Fraz
				+ ", reattIndAssT4Fraz=" + reattIndAssT4Fraz
				+ ", reattCapAssFraz=" + reattCapAssFraz + ", id=" + id + "]";
	}
	
	

	

	
}