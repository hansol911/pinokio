package com.pinokio.pino.exception;

import org.springframework.http.HttpStatus;

public class UserIdDuplicationException extends ApiException {
    public UserIdDuplicationException(String msg) {
        super(msg);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
