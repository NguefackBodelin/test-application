package com.simple.test.testapplication.utility;

import com.simple.test.testapplication.exception.UsersException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class Validators {
  public static void validateId(Long id) throws UsersException {
    if (id == null || id < 0) {
      log.error("id cannot be null, 0 or negative");
      throw new UsersException("", HttpStatus.BAD_REQUEST);
    }
  }
}
