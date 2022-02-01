package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.ProfileDto;
import com.application.bamcoreport.DTO.models.ProfileMemberDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.ProfileMember;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.ProfileMemberRepository;
import com.application.bamcoreport.repository.ProfileMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileMemberService {
    @Autowired
    private ProfileMemberRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    ProfileService profileService;

    @Autowired
    IMapClassWithDto<ProfileMember, ProfileMemberDto> profileMapping;

    public ProfileMember saveProfile(ProfileMember profileMember){
        return repository.save(profileMember);
    }

    public List<ProfileMember> saveProfiles(List<ProfileMember> profilesMembers){
        return repository.saveAll(profilesMembers);
    }

    public List<ProfileMemberDto> getProfileMembers() {
        List<ProfileMember> profilesMembers = repository.findAll();
        return profileMapping.convertListToListDto(profilesMembers, ProfileMemberDto.class);
    }

    public ProfileMember getProfileMemberById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteProfileMember(Long id){
        repository.deleteById(id);
        return "ProfileMember removed !!";
    }

    public  ProfileMember updateProfileMember(ProfileMember profileMember){
        ProfileMember existingProfileMember = repository.findById(profileMember.getId()).orElse(null);
        if(existingProfileMember!=null){
            User userC=userService.getUserById(profileMember.getUserId().getId());
            Role role=roleService.getRoleById(profileMember.getRoleId().getId());
            Profile profile=profileService.getProfileById(profileMember.getProfileId().getId());
            profileMember.setProfileId(profile);
            profileMember.setRoleId(role);
            profileMember.setUserId(userC);
            return  repository.save(profileMember);
        }
        return profileMember;
    }
}
