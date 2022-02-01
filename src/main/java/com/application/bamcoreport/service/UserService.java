package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;

    @Autowired
    IMapClassWithDto<User, UserDto> userMapping;


    public UserDto saveUser(UserDto userdto){
        // convert DTO to entity
        User userRequest = userMapping.convertToEntity(userdto,User.class);
        User getManageruserid = this.getUserById(userRequest.getManageruserid().getId());
        userRequest.setManageruserid(getManageruserid);
        User getCreatedBy = this.getUserById(userRequest.getCreatedby().getId());
        userRequest.setCreatedby(getCreatedBy);
        User user = repository.save(userRequest);
        // convert entity to DTO
        UserDto userResponse = userMapping.convertToDto(user, UserDto.class);
        return userResponse;
    }


    @Override
    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public User getUserById(long id){
        return repository.findById(id).orElse(null);
    }
    public String deleteUser(long id){
        repository.deleteById(id);
        return "User removed !!";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        if(existingUser !=null) {
            User getManageruserid = this.getUserById(user.getManageruserid().getId());
            User getCreatedBy = this.getUserById(user.getCreatedby().getId());
            existingUser.setEnabled(user.isEnabled());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setTitle(user.getTitle());
            existingUser.setJobtitle(user.getJobtitle());
            existingUser.setManageruserid(getManageruserid);
            existingUser.setCreatedby(getCreatedBy);
        }
        return repository.save(existingUser);
    }

}