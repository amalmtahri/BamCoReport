package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
