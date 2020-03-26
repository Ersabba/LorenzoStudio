package com.ericsson.urm.persistence.dto.mgre;


import java.util.Date;



public class FrazTotEr implements java.io.Serializable {

		private static final long serialVersionUID = 1L;

		private Long attErFraz;
		private Long attErT1Fraz;
		private Long attErT2Fraz;
		private Long attErT3Fraz;
		private Long attErT4Fraz;	
		private Long reattIndErFraz=null;
		private Long reattCapErFraz=null;
		
		private String matricolaLenntCliente;
		private Date dataRil;
		
		
		public FrazTotEr(){
			
		}
		
		public FrazTotEr(String matricolaLenntCliente, Date dataRil, Long attErFraz, Long attErT1Fraz, 
				Long attErT2Fraz, Long attErT3Fraz, Long attErT4Fraz, 
				Long reattIndErFraz, Long reattCapErFraz){
			this.setMatricolaLenntCliente(matricolaLenntCliente);
			this.setDataRil(dataRil);
			this.attErFraz=attErFraz;
			this.attErT1Fraz=attErT1Fraz;
			this.attErT2Fraz=attErT2Fraz;
			this.attErT3Fraz=attErT3Fraz;
			this.attErT4Fraz=attErT4Fraz;	
			this.reattIndErFraz=reattIndErFraz;
			this.reattCapErFraz=reattCapErFraz;
		}
		
		public Long getAttErFraz() {
			return attErFraz;
		}

		public void setAttErFraz(Long attErFraz) {
			this.attErFraz = attErFraz;
		}

		public Long getAttErT1Fraz() {
			return attErT1Fraz;
		}

		public void setAttErT1Fraz(Long attErT1Fraz) {
			this.attErT1Fraz = attErT1Fraz;
		}

		public Long getAttErT2Fraz() {
			return attErT2Fraz;
		}

		public void setAttErT2Fraz(Long attErT2Fraz) {
			this.attErT2Fraz = attErT2Fraz;
		}

		public Long getAttErT3Fraz() {
			return attErT3Fraz;
		}

		public void setAttErT3Fraz(Long attErT3Fraz) {
			this.attErT3Fraz = attErT3Fraz;
		}

		public Long getAttErT4Fraz() {
			return attErT4Fraz;
		}

		public void setAttErT4Fraz(Long attErT4Fraz) {
			this.attErT4Fraz = attErT4Fraz;
		}

		public Long getReattIndErFraz() {
			return reattIndErFraz;
		}

		public void setReattIndErFraz(Long reattIndErFraz) {
			this.reattIndErFraz = reattIndErFraz;
		}

		public Long getReattCapErFraz() {
			return reattCapErFraz;
		}

		public void setReattCapErFraz(Long reattCapErFraz) {
			this.reattCapErFraz = reattCapErFraz;
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
			return "FrazTotEr [attErFraz=" + attErFraz + ", attErT1Fraz="
					+ attErT1Fraz + ", attErT2Fraz=" + attErT2Fraz
					+ ", attErT3Fraz=" + attErT3Fraz + ", attErT4Fraz="
					+ attErT4Fraz + ", reattIndErFraz=" + reattIndErFraz
					+ ", reattCapErFraz=" + reattCapErFraz
					+ ", matricolaLenntCliente=" + matricolaLenntCliente
					+ ", dataRil=" + dataRil + "]";
		}


			
	}
