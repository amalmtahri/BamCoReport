package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.controller.api.UserApi;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserApi {

    @Autowired
    private UserService service;

    @Override
    public UserDto saveUser(@RequestBody UserDto userDto){
       return service.saveUser(userDto);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDto = service.getUsers();
        return ResponseEntity.ok(userDto);
    }

    @Override
    public User findUser(@PathVariable Long id){
        return service.getUserById(id);
    }

    @Override
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @Override
    public String deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }
}
