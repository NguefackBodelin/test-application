package com.simple.test.testapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
public class GlobalException {
  private String message;
  private HttpStatus httpStatus;
  private ZonedDateTime dateTime;
}
