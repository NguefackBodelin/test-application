package com.simple.test.testapplication.controller;

import com.simple.test.testapplication.dto.UsersDto;
import com.simple.test.testapplication.entity.Users;
import com.simple.test.testapplication.exception.UsersException;
import com.simple.test.testapplication.mapper.UsersMapper;
import com.simple.test.testapplication.request.UsersRequest;
import com.simple.test.testapplication.search.UsersSpecification;
import com.simple.test.testapplication.service.UsersService;
import com.simple.test.testapplication.utility.Validators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UsersController {

  private final UsersService usersService;
  private final UsersMapper usersMapper;
  private final UsersSpecification specification;

  @Autowired
  public UsersController(
      UsersService usersService, UsersMapper usersMapper, UsersSpecification specification) {
    this.usersService = usersService;
    this.usersMapper = usersMapper;
    this.specification = specification;
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<UsersDto> findById(@PathVariable("id") Long id) throws UsersException {
    log.info("start find by id: {}", id);
    Validators.validateId(id);
    UsersDto dto =
        usersService
            .findUsersById(id)
            .map(usersMapper::toUsersDto)
            .orElseThrow(() -> new UsersException("", HttpStatus.NOT_FOUND));
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/users/all")
  public ResponseEntity<Page<UsersDto>> findAll(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "surname") String surname,
      @RequestParam(value = "identity") String ientity,
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "15") int size,
      @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
    log.info("start find all with filter");
    Pageable paging = PageRequest.of(page, size);
    Page<Users> usersPage = usersService.findAllUsers(name, surname, ientity, paging);
    List<UsersDto> usersDtoList = usersMapper.toListDto(usersPage.getContent());
    Page<UsersDto> usersDtoPage = new PageImpl<UsersDto>(usersDtoList, paging, usersDtoList.size());
    return ResponseEntity.ok(usersDtoPage);
  }

  @PostMapping("/users")
  public ResponseEntity<UsersDto> saveUsers(@RequestBody UsersRequest request) {
    log.info("start save users");
    UsersDto usersDto =
        usersMapper.toUsersDto(usersService.save(usersMapper.toUsersEntity(request)));
    return ResponseEntity.ok(usersDto);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<UsersDto> updateUsers(
      @PathVariable("id") Long id, @RequestBody UsersRequest usersRequest) throws UsersException {
    log.info("start update users");
    Validators.validateId(id);
    Optional<Users> usersFound = usersService.findUsersById(id);
    if (usersFound.isEmpty()) {
      log.error("user with id: {} not found ", id);
      throw new UsersException("user with id: " + id + " not found ", HttpStatus.NOT_FOUND);
    }
    Users userstoUpdate = UsersRequest.setUserToUpdate(usersRequest, usersFound.get());
    UsersDto usersDto = usersMapper.toUsersDto(usersService.save(userstoUpdate));
    return ResponseEntity.ok(usersDto);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) throws UsersException {
    log.info("start delete users by id");
    Validators.validateId(id);
    usersService.deleteUsersById(id);
    return ResponseEntity.ok("ok");
  }
}
