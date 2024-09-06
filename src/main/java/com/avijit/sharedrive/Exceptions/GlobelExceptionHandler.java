package com.avijit.sharedrive.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobelExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<?> handleNotExistException(NotExistException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.NOT_FOUND.value(),e.getMessage());
        return new  ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserTypeExistExceptions.class)
    public ResponseEntity<?> handleUserTypeExistException(UserTypeExistExceptions e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.FOUND.value(), e.getMessage());
        return new ResponseEntity<>(errorResponseDto,HttpStatus.FOUND);
    }
}
