package com.application.bamcoreport.service;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserMemberShip;
import com.application.bamcoreport.repository.UserMembershipRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserMembershipServiceTest {

    @Mock
    private UserMembershipRepository userMembershipRepository;

    @InjectMocks
    private UserMembershipService userMembershipService;


    @Test
    void testGetUserMemberships() {

        Date date = new Date();
        UserMemberShip userMemberShip1 = new UserMemberShip(1,new User(),new Role(),new Group(),new User(),date);
        UserMemberShip userMemberShip2 = new UserMemberShip(2,new User(),new Role(),new Group(),new User(),date);
        UserMemberShip userMemberShip3 = new UserMemberShip(3,new User(),new Role(),new Group(),new User(),date);

        List<UserMemberShip> userMemberShips = new ArrayList<>();
        userMemberShips.add(userMemberShip1);
        userMemberShips.add(userMemberShip2);
        userMemberShips.add(userMemberShip3);
        when(userMembershipRepository.findAll()).thenReturn(userMemberShips);
        //Assertions
        assertThat(userMembershipRepository.findAll()).isNotNull();

    }

    @Test
    void testSaveUserMembership() {
        Date date = new Date();
        UserMemberShip userMemberShip1 = new UserMemberShip(1,new User(),new Role(),new Group(),new User(),date);
        when(userMembershipRepository.save(eq(userMemberShip1))).thenReturn(userMemberShip1);
        assertNotNull(userMembershipRepository.save(userMemberShip1));

    }

    @Test
    void testGetUserMembershipById() {

        // Create the objet
        Date date = new Date();
        UserMemberShip userMemberShip1 = new UserMemberShip(1,new User(),new Role(),new Group(),new User(),date);
        // Pass to mock
        when(userMembershipRepository.findById(eq(userMemberShip1.getId()))).thenReturn(Optional.of(userMemberShip1));
        // Call
        UserMemberShip result = userMembershipService.getUserMembershipById(userMemberShip1.getId());
        // Assertions
        assertNotNull(result);
        Assertions.assertEquals(result.getId(), userMemberShip1.getId());
        // Verify call to mock
        verify(userMembershipRepository, times(1)).findById(eq(userMemberShip1.getId()));

    }

    @Test
    void testDeleteUserMembership() {
        Date date = new Date();
        UserMemberShip userMemberShip1 = new UserMemberShip(1,new User(),new Role(),new Group(),new User(),date);
        assertThat(userMembershipService.deleteUserMembership(userMemberShip1.getId())).isEqualTo("UserMembership removed !!");

    }
}