package com.simple.test.testapplication.service;

import com.simple.test.testapplication.entity.Users;
import com.simple.test.testapplication.exception.UsersException;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsersService {

  Users save(Users users);

  Optional<Users> findUsersById(Long id) throws UsersException;

  Page<Users> findAllUsers(String name, String surname, String identity, Pageable pageable);

  void deleteUsersById(Long id) throws UsersException;
}
