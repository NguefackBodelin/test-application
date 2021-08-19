package com.simple.test.testapplication.service.impl;

import com.simple.test.testapplication.entity.Users;
import com.simple.test.testapplication.exception.UsersException;
import com.simple.test.testapplication.repository.UsersRepository;
import com.simple.test.testapplication.search.UsersSpecification;
import com.simple.test.testapplication.service.UsersService;
import com.simple.test.testapplication.utility.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

  private UsersRepository usersRepository;
  private UsersSpecification usersSpecification;

  @Autowired
  public UsersServiceImpl(UsersRepository usersRepository, UsersSpecification usersSpecification) {
    this.usersRepository = usersRepository;
    this.usersSpecification = usersSpecification;
  }

  @Override
  public Users save(Users users) {
    return usersRepository.save(users);
  }

  @Override
  public Optional<Users> findUsersById(Long id) throws UsersException {
    Validators.validateId(id);
    return usersRepository.findById(id);
  }

  @Override
  public Page<Users> findAllUsers(String name, String surname, String identity, Pageable pageable) {
    return usersRepository.findAll(
        usersSpecification.getUsers(new Users(name, surname, identity, null)), pageable);
  }

  @Override
  public void deleteUsersById(Long id) throws UsersException {
    Validators.validateId(id);
    usersRepository.deleteById(id);
  }
}
