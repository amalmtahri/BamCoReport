package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
       return service.saveUser(userDto);
    }



    @GetMapping("/findUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDto = service.getUsers();
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/findUser/{id}")
    public User findUser(@PathVariable  Long id){
        return service.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }
}
