package com.pinokio.pino.cotroller;


import com.pinokio.pino.exeption.ErrResponse;
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
    /*@ExceptionHandler({ DataIntegrityViolationException.class })
    public String handleDataException(final DataIntegrityViolationException ex) {
        //log.info(ex.getClass().getName());
        //log.error("하위 테이블에 값이 존재합니다.", ex);
        log.error("하위 테이블에 값이 존재합니다.");
        return ex.getMessage();
    }*/


    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ErrResponse> handleAll(final DataIntegrityViolationException ex) {
        ErrResponse response = new ErrResponse("0002", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public ErrResponse handleConflictException(DataIntegrityViolationException ex) throws Exception {
        return new ErrResponse("error-0002", ex.getMessage());
    }
//    public ResponseEntity<Object> handleAll(final DataIntegrityViolationException ex) {
//        log.info(ex.getClass().getName());
//        log.error("하위 테이블에 값이 존재합니다.", ex);
//        //log.error("하위 테이블에 값이 존재합니다.");
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler({ EmptyResultDataAccessException.class })
//    public ResponseEntity<Object> handleAll(final EmptyResultDataAccessException ex) {
//        log.info(ex.getClass().getName());
//        log.error("존재하지 않는 값입니다.", ex);
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @ExceptionHandler({ EmptyResultDataAccessException.class })
    public ResponseEntity<ErrResponse> handleAll(final EmptyResultDataAccessException ex) {
        ErrResponse response = new ErrResponse("0001", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}