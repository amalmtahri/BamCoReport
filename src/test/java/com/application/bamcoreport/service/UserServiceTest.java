package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@SpringBootTest
class UserServiceTest {

    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Autowired
    IMapClassWithDto<User, UserDto> userMapping;

    @Autowired
    PasswordEncoder passwordEncoder;

    @BeforeEach
    @Disabled
    public void setup() {
        userService = new UserService(passwordEncoder);
        //(userRepository,passwordEncoder);
    }

    @Test
    public void getUserById() {
        // Create the objet
        Date date = new Date();
        User user = new User(32, true, "update", "amalooo", "amal", "mtahri", "developpement", "developer web", new User(), new User(), date, null);
        // Pass to mock
        when(userRepository.findById(eq(user.getId()))).thenReturn(Optional.of(user));
        // Call
        User result = userService.getUserById(user.getId());
        // Assertions
        assertNotNull(result);
        Assertions.assertEquals(result.getId(), user.getId());
        // Verify call to mock
        verify(userRepository, times(1)).findById(eq(user.getId()));
    }


    @Test
    public void testGetUsers(){
        //create data
        Date date = new Date();
        User user1 = new User(1, true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), date, null);
        User user2 = new User(2, true, "userB", "userB", "userB", "userB", "developpement", "developer web", new User(), new User(), date, null);
        User user3 = new User(3, true, "userC", "userC", "userC", "userC", "developpement", "developer web", new User(), new User(), date, null);
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //pass to mock
        when(userRepository.findAll()).thenReturn(users);
        //Assertions
        assertThat(userRepository.findAll()).isNotNull();
    }

    @Test
    public void testSaveUser(){
        Date date = new Date();
        User user1 = new User(1,true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), date, null);
        //pass to mock
        when(userRepository.save(eq(user1))).thenReturn(user1);
        //Assertions
        assertNotNull(userRepository.save(user1));
    }

    @Test
    public void testDeleteUser(){
        Date date = new Date();
        User user1 = new User(1,true, "userA", "userA", "userA", "userA", "developpement", "developer web", new User(), new User(), date, null);
        userRepository.deleteById(user1.getId());
        assertThat(userService.deleteUser(user1.getId())).isEqualTo("User removed !!");
    }

}