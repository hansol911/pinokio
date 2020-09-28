package com.pinokio.pino.exception;

public class ExceptionResponse {

    private String code;
    private String message;

    public ExceptionResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getError() {
        return code;
    }

    public void setError(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}