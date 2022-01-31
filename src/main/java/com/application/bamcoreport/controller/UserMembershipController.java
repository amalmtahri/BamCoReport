package com.application.bamcoreport.controller;

import com.application.bamcoreport.DTO.models.UserMemberShipDto;
import com.application.bamcoreport.entity.UserMemberShip;
import com.application.bamcoreport.service.UserMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userMembership")
public class UserMembershipController {


    @Autowired
    private UserMembershipService service;

    @GetMapping("/findUserMemberships")
    public ResponseEntity<List<UserMemberShipDto>> getAllUserMemberships(){
        List<UserMemberShipDto> userMemberShipDtos = service.getUserMemberships();
        return ResponseEntity.ok(userMemberShipDtos);
    }

    @PostMapping("/addUserMembership")
    public UserMemberShip addUseMembership(@RequestBody UserMemberShip userMemberShip){
        return service.saveUserMembership(userMemberShip);
    }

    @GetMapping("/findUserMembership/{id}")
    public UserMemberShip getUserMembership(@PathVariable long id){
        return service.getUserMembershipById(id);
    }

    @DeleteMapping("/deleteUserMembership/{id}")
    public String deleteUserMembership(@PathVariable long id){
        return service.deleteUserMembership(id);
    }

    @PutMapping("/updateUserMembership")
    public UserMemberShip updateUserMembership(@RequestBody UserMemberShip userMemberShip){
        return service.updateUserMembership(userMemberShip);
    }
}
