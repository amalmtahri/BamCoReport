package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private ProfileService service;

    @PostMapping("/add")
    public Profile saveProfile(@RequestBody Profile profile){
        return service.saveProfile(profile);
    }

    @PostMapping("/addList")
    public List<Profile> saveProfiles(@RequestBody List<Profile> profiles){
        return service.saveProfiles(profiles);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileDto>> getAllProfiles(){
        List<ProfileDto> profileDto = service.getProfiles();
        return ResponseEntity.ok(profileDto);
    }
    @GetMapping("/findBy/{id}")
    public Profile findProfile(@PathVariable Long id){
        return service.getProfileById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable Long id){
        return service.deleteProfile(id);
    }

    @PutMapping("/update")
    public Profile updateUser(@RequestBody Profile profile){
        return service.updateProfile(profile);
    }
}
