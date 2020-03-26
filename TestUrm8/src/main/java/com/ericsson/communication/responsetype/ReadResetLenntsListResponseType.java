package com.ericsson.communication.responsetype;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ericsson.communication.CommandResponseType;
import com.ericsson.communication.CommandResponseTypeEnumeration;
import com.ericsson.communication.UrmCommunicationException;

public class ReadResetLenntsListResponseType extends CommandResponseType implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String idRequest = "ID_REQUEST";
	public static final String resetResults = "RESET_RESULTS";

	
	public static enum ResetResult {
		NOT_EXISTS,
		SUCCESS,
		FAILED,
		IP_ADDRESS_NULL, 
		ANTI_TAMPER_OFF, 
		MISSING_STATUS_WORD,
		NOT_EXECUTED,
		UNREACHABLE,
		FEW_DAYS_RESETTED,
		GENERIC_ERROR;
		
	}
	
    public CommandResponseTypeEnumeration getCommandResponseType() {
        return CommandResponseTypeEnumeration.RES_RESET_LENNTS_LIST;
    }

    public boolean isValid() {
        return true;
    }

    
    public String getIdRequest() throws UrmCommunicationException {
        return (String) getResponseTypeBody().getResult(idRequest);
    }
/**
 * Metodo che restituisce il risultato del reset per ciascun lennt della lista
 *
 *
 */

    public Map<String, ResetResult> getResetResults() throws UrmCommunicationException {
        Map<String, ResetResult> results = (HashMap<String,ResetResult>) getResponseTypeBody().getResult(resetResults);
        return results;
    }



}
