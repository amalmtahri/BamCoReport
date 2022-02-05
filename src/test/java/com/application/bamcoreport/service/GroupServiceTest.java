package com.application.bamcoreport.service;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.GroupRepository;
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
class GroupServiceTest {

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private GroupService groupService;

    @Test
    void testGetGroups() {
        Date date = new Date();
        Group group1 = new Group(1,"group1","group1","group1","description",new User(),date,null);
        Group group2 = new Group(2,"group2","group2","group2","description",new User(),date,null);
        Group group3 = new Group(3,"group3","group3","group3","description",new User(),date,null);
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        when(groupRepository.findAll()).thenReturn(groups);
        //Assertions
        assertThat(groupRepository.findAll()).isNotNull();
    }

    @Test
    void testSaveGroup() {
        Date date = new Date();
        Group group1 = new Group(1,"group1","group1","group1","description",new User(),date,null);
        when(groupRepository.save(eq(group1))).thenReturn(group1);
        assertNotNull(groupRepository.save(group1));
    }

    @Test
    void testGetGroupById() {
        // Create the objet
        Date date = new Date();
        Group group1 = new Group(1,"group1","group1","group1","description",new User(),date,null);
        // Pass to mock
        when(groupRepository.findById(eq(group1.getId()))).thenReturn(Optional.of(group1));
        // Call
        Group result = groupService.getGroupById(group1.getId());
        // Assertions
        assertNotNull(result);
        Assertions.assertEquals(result.getId(), group1.getId());
        // Verify call to mock
        verify(groupRepository, times(1)).findById(eq(group1.getId()));
    }

    @Test
    void deleteGroup() {
        Date date = new Date();
        Group group1 = new Group(1,"group1","group1","group1","description",new User(),date,null);
        //groupRepository.deleteById(group1.getId());
        assertThat(groupService.deleteGroup(group1.getId())).isEqualTo("Group removed !!");
    }
}