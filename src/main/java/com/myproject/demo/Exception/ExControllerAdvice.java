package com.myproject.demo.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ExceptionResponse> memberNotFoundHandler(MemberNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.MEMBER_NOT_FOUND);
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LackOfPointException.class)
    public ResponseEntity<ExceptionResponse> lackOfPointHandler(LackOfPointException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.NOT_ENOUGH_POINT);
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
