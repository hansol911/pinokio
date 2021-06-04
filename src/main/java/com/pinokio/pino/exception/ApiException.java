package com.pinokio.pino.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {
    public abstract HttpStatus getStatus();

    public ApiException(String msg) {
        super(msg);
    }
}