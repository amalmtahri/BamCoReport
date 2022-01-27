package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements  IUserService{
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    @Autowired
    IMapClassWithDto<User, UserDto> userMapping;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }
    public String deleteUser(Long id){
        repository.deleteById(id);
        return "User removed !!";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setEnabled(user.isEnabled());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getLastName());
        existingUser.setTitle(user.getTitle());
        existingUser.setJobTitle(user.getJobTitle());
        existingUser.setManagerUserId(user.getManagerUserId());
        existingUser.setCreatedBy(user.getCreatedBy());
        return repository.save(existingUser);
    }

}