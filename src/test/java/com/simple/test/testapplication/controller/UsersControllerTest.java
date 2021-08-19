package com.simple.test.testapplication.controller;

import com.simple.test.testapplication.TestApplication;
import com.simple.test.testapplication.entity.Users;
import com.simple.test.testapplication.service.UsersService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestApplication.class)
public class UsersControllerTest {

  /*@MockBean UsersService usersService;*/
  @Autowired WebApplicationContext webApplicationContext;
  MockMvc mockMvc;
  Users users;

  /*@Test
  public void testfindAll() throws Exception {

    Pageable paging = of(0, 15);
    Users users = new Users("test", "test1", uuid.toString(), new Date());
    List<Users> usersList = Arrays.asList(users);
    Page<Users> pageUsers = new PageImpl<Users>(usersList, paging, 1);

    when(usersService.findAllUsers(any(), any(), any(), any())).thenReturn(pageUsers);
    this.mockMvc
        .perform(MockMvcRequestBuilders.get("/v1/users/all").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
  }*/

  @Before
  public void setUp() {
    UUID uuid = UUID.randomUUID();
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    users = new Users("test", "test1", uuid.toString(), new Date());
  }
}
