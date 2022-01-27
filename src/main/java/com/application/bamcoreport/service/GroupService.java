package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupService implements IGroupService {

    @Autowired
    IMapClassWithDto<Group, GroupDto> groupMapping;
    @Autowired
    private GroupRepository repository;

    @Override
    public List<GroupDto> getGroups() {
        List<Group> groups = repository.findAll();
        return groupMapping.convertListToListDto(groups, GroupDto.class);
    }

    public Group saveGroup(Group group){
        return repository.save(group);
    }


    public Group getGroupById(Long id){
        return repository.findById(id).orElse(null);
    }


    public String deleteRole(Long id){
        repository.deleteById(id);
        return "Group removed !!";
    }

    public Group updateGroup(Group group) {
        Group existingGroup = repository.findById(group.getId()).orElse(null);
        existingGroup.setName(group.getName());
        existingGroup.setParentPath(group.getParentPath());
        existingGroup.setDisplayname(group.getDisplayname());
        existingGroup.setDescription(group.getDescription());
        existingGroup.setCreatedBy(group.getCreatedBy());
        return repository.save(existingGroup);
    }
}
