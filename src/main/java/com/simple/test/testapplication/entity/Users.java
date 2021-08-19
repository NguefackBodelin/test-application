package com.simple.test.testapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {
  private String name;
  private String surname;
  private String identity;
  private Date birthdate;
}
