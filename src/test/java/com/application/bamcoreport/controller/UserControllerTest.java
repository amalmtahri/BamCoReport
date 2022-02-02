package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import com.application.bamcoreport.service.UserService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @Autowired
    private UserController userController;

    @Test
    void testSaveUser() {
        UserDto userDto = new UserDto(true,"amalmthr","amalooo","amal","mtahri","developpement","developer web",new User(),new User(), null,null);
        UserDto saveUser = userController.saveUser(userDto);
        assertThat(saveUser).isNotNull();
    }


    @Test
    void testGetAllUsers() {
        ResponseEntity<List<UserDto>> users =  userController.getAllUsers();
        assertThat(users).isNotNull();
    }

    @Test
    void testFindUser() {
        User user = userController.findUser(1L);
        assertThat(user).isNotNull();
    }

    @Test
    void testUpdateUser() {
    }

    @Test
    void testDeleteUser() {
        String deleteUser = userController.deleteUser(31L);
        assertThat(deleteUser).isEqualTo("User removed !!");
    }
}