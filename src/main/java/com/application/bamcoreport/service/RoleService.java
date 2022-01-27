package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.RoleDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    IMapClassWithDto<Role, RoleDto> roleMapping;
    @Autowired
    private RoleRepository repository;

    @Override
    public List<RoleDto> getRoles() {
        List<Role> roles = repository.findAll();
        return roleMapping.convertListToListDto(roles, RoleDto.class);
    }

    public Role saveRole(Role role){
        return repository.save(role);
    }

    public Role getRoleById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deleteRole(Long id){
        repository.deleteById(id);
        return "Role removed !!";
    }

    public Role updateRole(Role role) {
        Role existingRole = repository.findById(role.getId()).orElse(null);
        existingRole.setName(role.getName());
        existingRole.setDisplayName(role.getDisplayName());
        existingRole.setDescription(role.getDescription());
        existingRole.setCreatedBy(role.getCreatedBy());
        return repository.save(existingRole);
    }

}
