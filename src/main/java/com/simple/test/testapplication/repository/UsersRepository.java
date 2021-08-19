package com.simple.test.testapplication.repository;

import com.simple.test.testapplication.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository
    extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

  Page findAll(Specification specification, Pageable page);
}
