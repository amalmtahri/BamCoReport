package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    public Profile saveProfile(Profile profile){

        User user=userService.getUserById(profile.getCreatedBy().getId());
        profile.setCreatedBy(user);
        User userupdate=userService.getUserById(profile.getLastUpdateBy().getId());
        profile.setLastUpdateBy(userupdate);
        return repository.save(profile);
    }

    public List<Profile> saveProfiles(List<Profile> profiles){
        return repository.saveAll(profiles);
    }

    public List<ProfileDto> getProfiles() {
        List<Profile> profiles = repository.findAll();
        return profileMapping.convertListToListDto(profiles,ProfileDto.class);
    }

    public Profile getProfileById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteProfile(Long id){
        repository.deleteById(id);
        return "Profile removed !!";
    }

    public  Profile updateProfile(Profile profile){
        Profile existingProfile = repository.findById(profile.getId()).orElse(null);
        if(existingProfile!=null){
            User userC=userService.getUserById(profile.getCreatedBy().getId());
            User userL=userService.getUserById(profile.getLastUpdateBy().getId());
            profile.setCreatedBy(userC);
            profile.setLastUpdateBy(userL);
            return  repository.save(profile);
        }
        return profile;
    }
}
