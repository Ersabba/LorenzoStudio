package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block24 implements RegistersBlock {

	private static final long		serialVersionUID	= 1L;

	private int						sogliaPotenzaRifer1;		// watt
	private int						sogliaTensioneRifer1;		// decimi volt
	private int						sogliaPotenzaRifer2;		// watt
	private int						sogliaTensioneRifer2;		// decimi volt
	private byte					modalitaEstensUscite;		// da definire il formato
	private boolean					teleruttorePresente;		// true presente, false assente
	private ProceduraControlloPmax	proceduraControlloPmax;
	private ProceduraControlloVmax	proceduraControlloVmax;
	
	public int getSogliaPotenzaRifer1() {
		return sogliaPotenzaRifer1;
	}
	
	public void setSogliaPotenzaRifer1(int sogliaPotenzaRifer1) {
		this.sogliaPotenzaRifer1 = sogliaPotenzaRifer1;
	}
	
	public int getSogliaTensioneRifer1() {
		return sogliaTensioneRifer1;
	}
	
	public void setSogliaTensioneRifer1(int sogliaTensioneRifer1) {
		this.sogliaTensioneRifer1 = sogliaTensioneRifer1;
	}
	
	public int getSogliaPotenzaRifer2() {
		return sogliaPotenzaRifer2;
	}
	
	public void setSogliaPotenzaRifer2(int sogliaPotenzaRifer2) {
		this.sogliaPotenzaRifer2 = sogliaPotenzaRifer2;
	}
	
	public int getSogliaTensioneRifer2() {
		return sogliaTensioneRifer2;
	}
	
	public void setSogliaTensioneRifer2(int sogliaTensioneRifer2) {
		this.sogliaTensioneRifer2 = sogliaTensioneRifer2;
	}
	
	public byte getModalitaEstensUscite() {
		return modalitaEstensUscite;
	}
	
	public void setModalitaEstensUscite(byte modalitaEstensUscite) {
		this.modalitaEstensUscite = modalitaEstensUscite;
	}
	
	public boolean isTeleruttorePresente() {
		return teleruttorePresente;
	}
	
	public void setTeleruttorePresente(boolean teleruttorePresente) {
		this.teleruttorePresente = teleruttorePresente;
	}
	
	public ProceduraControlloPmax getProceduraControlloPmax() {
		return proceduraControlloPmax;
	}
	
	public void setProceduraControlloPmax(ProceduraControlloPmax proceduraControlloPmax) {
		this.proceduraControlloPmax = proceduraControlloPmax;
	}
	
	public ProceduraControlloVmax getProceduraControlloVmax() {
		return proceduraControlloVmax;
	}
	
	public void setProceduraControlloVmax(ProceduraControlloVmax proceduraControlloVmax) {
		this.proceduraControlloVmax = proceduraControlloVmax;
	}
}
