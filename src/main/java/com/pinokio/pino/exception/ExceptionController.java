package com.pinokio.pino.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    // 500
    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ExceptionResponse> handleDataException(final DataIntegrityViolationException ex) {
        ExceptionResponse response = new ExceptionResponse("0002", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({ EmptyResultDataAccessException.class })
    public ResponseEntity<ExceptionResponse> handleEmptyException(final EmptyResultDataAccessException ex) {
        ExceptionResponse response = new ExceptionResponse("0001", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
