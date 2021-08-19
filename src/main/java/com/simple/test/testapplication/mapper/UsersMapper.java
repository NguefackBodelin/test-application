package com.simple.test.testapplication.mapper;

import com.simple.test.testapplication.dto.UsersDto;
import com.simple.test.testapplication.entity.Users;
import com.simple.test.testapplication.request.UsersRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
  UsersDto toUsersDto(Users users);

  Users toUsersEntity(UsersDto usersDto);

  Users toUsersEntity(UsersRequest usersRequest);

  List<UsersDto> toListDto(List<Users> users);
}
