package com.application.bamcoreport.controller;

import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user){
       return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> saveUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/findUsers")
    public List<User> findUsers(){
        return service.getUsers();
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
