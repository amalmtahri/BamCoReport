package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.UserDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements  IUserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    public  User findUserByUserName(String userName){
        return  repository.findByUsername(userName);
    }

    public String deleteUser(Long id){
        repository.deleteById(id);
        return "User removed !!";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        assert existingUser != null;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =this.findUserByUserName(username);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        //add user roles
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}