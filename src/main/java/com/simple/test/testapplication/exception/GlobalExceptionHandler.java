package com.simple.test.testapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UsersException.class)
  public ResponseEntity<GlobalException> usersException(UsersException e, WebRequest request) {
    GlobalException globalException =
        GlobalException.builder()
            .message(e.getMessage())
            .httpStatus(e.getHttpStatus())
            .dateTime(ZonedDateTime.now())
            .build();
    return new ResponseEntity<>(globalException, e.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<GlobalException> genericException(Exception e, WebRequest request) {
    GlobalException globalException =
        GlobalException.builder()
            .message(e.getMessage())
            .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
            .dateTime(ZonedDateTime.now())
            .build();
    return new ResponseEntity<>(globalException, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
