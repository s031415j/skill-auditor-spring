package com.example.skillsauditor.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserExceptionHandler {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    public ResponseEntity<Object> handleGenericException(Exception e) {

        LOG.info(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
