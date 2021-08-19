package com.simple.test.testapplication.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UsersException extends Exception {
  private String message;
  private HttpStatus httpStatus;

  public UsersException(String message, HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
    this.message = message;
  }
}
