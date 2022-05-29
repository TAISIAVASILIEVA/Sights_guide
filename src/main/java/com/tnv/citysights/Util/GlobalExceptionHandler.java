package com.tnv.citysights.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidException.class)
    public ResponseEntity handleNotValidException(ValidException e) {
        log.error(e.getResponseMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getResponseMessage());
    }
}
