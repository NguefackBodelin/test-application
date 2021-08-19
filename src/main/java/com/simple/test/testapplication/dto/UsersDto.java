package com.simple.test.testapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
  private String name;
  private String surname;
  private String identity;
  private Date birthdate;
}
