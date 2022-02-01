package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserContactInfoDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.entity.UserContactInfo;
import com.application.bamcoreport.repository.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactInfoService {

    @Autowired
    private UserContactInfoRepository repository;

    @Autowired
    IMapClassWithDto<UserContactInfo, UserContactInfoDto> UserContactInfoMapping;

    public UserContactInfo saveUserContactInfo(UserContactInfo UserContactInfo){
        return repository.save(UserContactInfo);
    }

    public List<UserContactInfo> saveUserContactInfos(List<UserContactInfo> userContactInfos){
        return repository.saveAll(userContactInfos);
    }

    public List<UserContactInfoDto> getUserContactInfos() {
        List<UserContactInfo> userContactInfos = repository.findAll();
        return UserContactInfoMapping.convertListToListDto(userContactInfos,UserContactInfoDto.class);
    }

    public UserContactInfo getUserContactInfoById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteUserContactInfo(Long id){
        repository.deleteById(id);
        return "UserContactInfo removed !!";
    }

    public UserContactInfo updateUserContactInfo(UserContactInfo userContactInfo){
        UserContactInfo existingUserContactInfo = repository.findById(userContactInfo.getId()).orElse(null);
        if(existingUserContactInfo!=null){
            return  repository.save(userContactInfo);
        }
        return userContactInfo;
    }
}
