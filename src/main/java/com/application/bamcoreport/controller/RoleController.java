package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/identity/role")
public class RoleController {


    @Autowired
    private RoleService service;

    @GetMapping("/findRoles")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDto = service.getRoles();
        return ResponseEntity.ok(roleDto);
    }

    @PostMapping("/saveRole")
    public Role saveRole(@RequestBody Role role){
        return service.saveRole(role);
    }

    @GetMapping("/findById/{id}")
    public Role findById(@PathVariable Long id){
        return service.getRoleById(id);
    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable Long id){
        return service.deleteRole(id);
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role){
        return service.updateRole(role);
    }


}
