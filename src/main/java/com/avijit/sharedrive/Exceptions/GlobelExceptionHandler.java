package com.avijit.sharedrive.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobelExceptionHandler {
    public ResponseEntity<String> handleException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UserTypeExceptions.class)
    public ResponseEntity<String> handleUserTypeException(UserTypeExceptions e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
