package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @GetMapping("/findGroups")
    public ResponseEntity<List<GroupDto>> getAllGroups(){
        List<GroupDto> groupDto = service.getGroups();
        return  ResponseEntity.ok(groupDto);
    }

    @GetMapping("/findGroup/{id}")
    public Group findGroupById(@PathVariable long id){
        return service.getGroupById(id);
    }

    @PostMapping("/addGroup")
    public Group addGroup(@RequestBody Group group){
        return service.saveGroup(group);
    }

    @PutMapping("/updateGroup")
    public Group updateGroup(@RequestBody Group group){
        return service.updateGroup(group);
    }

    @DeleteMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable long id){
        return service.deleteGroup(id);
    }
}
