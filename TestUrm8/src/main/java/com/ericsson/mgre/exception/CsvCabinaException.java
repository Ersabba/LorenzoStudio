package com.ericsson.mgre.exception;


public class CsvCabinaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CsvCabinaException() {
		super();
	}

	public CsvCabinaException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}

	public CsvCabinaException(Throwable arg0) {
		super(arg0);
	}

	public CsvCabinaException(ErrorCode errorCode, Throwable arg1) {
		super(errorCode.getDescription(), arg1);
	}
	
	public static enum ErrorCode {
		GENERIC("Errore durante l'elaborazione richiesta"),
		INTERNAL("Errore interno"),
		OPERATION_NOT_ALLOWED("Operazione non consentita");
		
		private ErrorCode(String descr) {
			this.descr = descr;
		}
		
		private String descr;
		
		public String getDescription() {
			return this.descr;
		}
	}

}
