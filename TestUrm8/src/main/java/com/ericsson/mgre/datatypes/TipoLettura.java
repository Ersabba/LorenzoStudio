package com.ericsson.mgre.datatypes;

public enum TipoLettura {

		DAILY("DAILY"), MONTHLY("MONTHLY");
		
		private String tipoLettura ;

		private TipoLettura(String tipoLettura) {
			this.tipoLettura = tipoLettura;
		}

		public String getTipoLettura() {
			return tipoLettura;
		}

		public static TipoLettura parse(String tipoLettura) throws IllegalArgumentException{
			if(tipoLettura!=null){
				for(TipoLettura t : TipoLettura.values()){
					if (t.tipoLettura.equalsIgnoreCase(tipoLettura)) 
						return t;
				}
			}
			throw new IllegalArgumentException( "Unknown TipoLettura: " + tipoLettura);
		}
}
