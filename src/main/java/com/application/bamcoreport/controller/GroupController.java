package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.controller.api.GroupApi;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController implements GroupApi {

    @Autowired
    private GroupService service;

    @Override
    public ResponseEntity<List<GroupDto>> getAllGroups(){
        List<GroupDto> groupDto = service.getGroups();
        return  ResponseEntity.ok(groupDto);
    }

    @Override
    public Group findGroupById(@PathVariable long id){
        return service.getGroupById(id);
    }

    @Override
    public Group addGroup(@RequestBody Group group){
        return service.saveGroup(group);
    }

    @Override
    public Group updateGroup(@RequestBody Group group){
        return service.updateGroup(group);
    }

    @Override
    public String deleteGroup(@PathVariable long id){
        return service.deleteGroup(id);
    }
}
