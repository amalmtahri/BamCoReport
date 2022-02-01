package com.application.bamcoreport.controller;


import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.service.ProfileMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profileMember")
public class ProfileMemberController {

    @Autowired
    private ProfileMemberService service;

    @PostMapping("/add")
    public ProfileMember saveProfileMember(@RequestBody ProfileMember profileMember){
        return service.saveProfile(profileMember);
    }

    @PostMapping("/addList")
    public List<ProfileMember> saveProfileMembers(@RequestBody List<ProfileMember> profileMembers){
        return service.saveProfiles(profileMembers);
    }

    @GetMapping("/find")
    public ResponseEntity<List<ProfileMemberDto>> getAllProfileMembers(){
        List<ProfileMemberDto> profileMemberDto = service.getProfileMembers();
        return ResponseEntity.ok(profileMemberDto);
    }
    @GetMapping("/findBy/{id}")
    public ProfileMember findProfileMember(@PathVariable Long id){
        return service.getProfileMemberById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProfileMember(@PathVariable Long id){
        return service.deleteProfileMember(id);
    }

    @PutMapping("/update")
    public ProfileMember updateUser(@RequestBody ProfileMember profileMember){
        return service.updateProfileMember(profileMember);
    }
}