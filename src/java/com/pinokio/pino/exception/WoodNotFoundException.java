package com.pinokio.pino.exception;

import org.springframework.http.HttpStatus;

public class WoodNotFoundException extends ApiException{
    public WoodNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
