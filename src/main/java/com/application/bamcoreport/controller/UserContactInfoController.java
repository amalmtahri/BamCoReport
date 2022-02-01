package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.UserContactInfo;
import com.application.bamcoreport.service.UserContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userContactInfo")
public class UserContactInfoController {

    @Autowired
    private UserContactInfoService service;

    @PostMapping("/add")
    public UserContactInfo saveUserContactInfo(@RequestBody UserContactInfo userContactInfo){
        return service.saveUserContactInfo(userContactInfo);
    }

    @PostMapping("/addList")
    public List<UserContactInfo> saveUserContactInfos(@RequestBody List<UserContactInfo> userContactInfos){
        return service.saveUserContactInfos(userContactInfos);
    }

    @GetMapping("/find")
    public ResponseEntity<List<UserContactInfoDto>> getAllUserContactInfos(){
        List<UserContactInfoDto> userDto = service.getUserContactInfos();
        return ResponseEntity.ok(userDto);
    }
    @GetMapping("/findBy/{id}")
    public UserContactInfo findUserContactInfo(@PathVariable Long id){
        return service.getUserContactInfoById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUserContactInfo(@PathVariable Long id){
        return service.deleteUserContactInfo(id);
    }


    @PutMapping("/update")
    public UserContactInfo updateUser(@RequestBody UserContactInfo userContactInfo){
        return service.updateUserContactInfo(userContactInfo);
    }

}
