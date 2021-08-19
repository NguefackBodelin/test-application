package com.simple.test.testapplication.request;

import com.simple.test.testapplication.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequest {
  private String name;
  private String surname;
  private String identity;
  private Date birthdate;

  public static Users setUserToUpdate(UsersRequest usersRequest, Users users) {
    if (StringUtils.hasLength(usersRequest.getName())) {
      users.setName(usersRequest.getName());
    }

    if (StringUtils.hasLength(usersRequest.getSurname())) {
      users.setName(usersRequest.getSurname());
    }

    if (StringUtils.hasLength(usersRequest.getIdentity())) {
      users.setName(usersRequest.getIdentity());
    }

    return users;
  }
}
