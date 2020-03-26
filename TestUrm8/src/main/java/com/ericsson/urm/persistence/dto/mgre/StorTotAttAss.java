package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;


public class StorTotAttAss implements java.io.Serializable, TotAttAssInterface {
	
	private static final long serialVersionUID = 1L;
	
	private StorTotAttAssId id=null;
	private Long attAss;
	private String esito;
	private Long attAssT1;
	private Long attAssT2;
	private Long attAssT3;
	private Long attAssT4;
	private String codConcentratore;
	private String provenienza=null;
	private Date dataAcq;
	private Date exportedDate;
	
	public StorTotAttAss(){
		
	}
	
	public StorTotAttAss(StorTotAttAssId id){
		this.id=id;
	}

	public StorTotAttAss(StorTotAttAssId id, Long attAss,
			String esito, Long attAssT1, Long attAssT2, Long attAssT3,
			Long attAssT4, String codConcentratore) {
		
		this.id=id;
		this.attAss = attAss;
		this.esito = esito;
		this.attAssT1 = attAssT1;
		this.attAssT2 = attAssT2;
		this.attAssT3 = attAssT3;
		this.attAssT4 = attAssT4;
		this.codConcentratore = codConcentratore;
	}


	
	
	
	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getAttAss()
	 */
	public Long getAttAss() {
		return attAss;
	}

	public void setAttAss(Long attAss) {
		this.attAss = attAss;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getEsito()
	 */
	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getAttAssT1()
	 */
	public Long getAttAssT1() {
		return attAssT1;
	}

	public void setAttAssT1(Long attAssT1) {
		this.attAssT1 = attAssT1;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getAttAssT2()
	 */
	public Long getAttAssT2() {
		return attAssT2;
	}

	public void setAttAssT2(Long attAssT2) {
		this.attAssT2 = attAssT2;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getAttAssT3()
	 */
	public Long getAttAssT3() {
		return attAssT3;
	}

	public void setAttAssT3(Long attAssT3) {
		this.attAssT3 = attAssT3;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getAttAssT4()
	 */
	public Long getAttAssT4() {
		return attAssT4;
	}

	public void setAttAssT4(Long attAssT4) {
		this.attAssT4 = attAssT4;
	}

	/* (non-Javadoc)
	 * @see com.ericsson.urm.persistence.dto.mgre.TotAttAssInterface#getCodConcentratore()
	 */
	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public StorTotAttAssId getId() {
		return id;
	}

	public void setId(StorTotAttAssId id) {
		this.id = id;
	}
	
	@Override
	public String getMatricolaLenntCliente() {
		if(id!=null)
			return id.getMatricolaLenntCliente();
		else return null;
	}
	
	@Override
	public Date getDataRil() {
		if(id!=null)
			return id.getDataRil();
		else return null;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public Date getDataAcq() {
		return dataAcq;
	}
	
	public void setDataAcq(Date dataAcq){
		this.dataAcq = dataAcq;
	}

	public Date getExportedDate() {
		return exportedDate;
	}

	public void setExportedDate(Date exportedDate) {
		this.exportedDate = exportedDate;
	}

	@Override
	public String toString() {
		return "StorTotAttAss [id=" + id + ", attAss=" + attAss + ", esito="
				+ esito + ", attAssT1=" + attAssT1 + ", attAssT2=" + attAssT2
				+ ", attAssT3=" + attAssT3 + ", attAssT4=" + attAssT4
				+ ", codConcentratore=" + codConcentratore + ", provenienza="
				+ provenienza + ", dataAcq=" + dataAcq + ", exportedDate="
				+ exportedDate + "]";
	}

}