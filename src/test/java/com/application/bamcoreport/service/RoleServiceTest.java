package com.application.bamcoreport.service;

import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.RoleRepository;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void testGetRoles() {
        //Create data

        Date date  = new Date();
        Role role1 = new Role(1,"roleA","roleA","roleA",new User(),date,null);
        Role role2 = new Role(2,"roleB","roleB","roleB",new User(),date,null);
        Role role3 = new Role(3,"roleC","roleC","roleC",new User(),date,null);

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        //pass to mock
        when(roleRepository.findAll()).thenReturn(roles);
        //Assertions
        assertThat(roleRepository.findAll()).isNotNull();
    }

    @Test
    void testSaveRole() {
        Date date = new Date();
        Role role1 = new Role(1,"roleA","roleA","roleA",new User(),date,null);
        when(roleRepository.save(eq(role1))).thenReturn(role1);
        assertNotNull(roleRepository.save(role1));
    }

    @Test
    void testGetRoleById() {
        // Create the objet
        Date date = new Date();
        Role role = new Role(1,"roleA","roleA","roleA",new User(),date,null);
        // Pass to mock
        when(roleRepository.findById(eq(role.getId()))).thenReturn(Optional.of(role));
        // Call
        Role result = roleService.getRoleById(role.getId());
        // Assertions
        assertNotNull(result);
        Assertions.assertEquals(result.getId(), role.getId());
        // Verify call to mock
        verify(roleRepository, times(1)).findById(eq(role.getId()));
    }

    @Test
    void testDeleteRole() {
        Date date = new Date();
        Role role = new Role(1,"roleA","roleA","roleA",new User(),date,null);
        roleRepository.deleteById(role.getId());
        assertThat(roleService.deleteRole(role.getId())).isEqualTo("Role removed !!");
    }
}