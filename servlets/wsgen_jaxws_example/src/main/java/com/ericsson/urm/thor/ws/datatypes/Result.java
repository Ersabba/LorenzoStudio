package com.ericsson.urm.thor.ws.datatypes;

import com.ericsson.urm.StringConstants;

public class Result {

    private ResultCode resultCode = null;
    private String message = null;


    public Result() {
        this.resultCode = ResultCode.FAILED;
        this.message = StringConstants.EMPTY_STRING;
    }

    public Result(String idRequest, ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
