package com.application.bamcoreport.service;

import com.application.bamcoreport.DTO.models.GroupDto;
import com.application.bamcoreport.DTO.services.IMapClassWithDto;
import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.User;
import com.application.bamcoreport.repository.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class GroupService implements IGroupService {

    @Autowired
    IMapClassWithDto<Group, GroupDto> groupMapping;
    @Autowired
    private GroupRepository repository;

    @Autowired
    private UserService userService;

    @Override
    public List<GroupDto> getGroups() {
        List<Group> groups = repository.findAll();
        return groupMapping.convertListToListDto(groups, GroupDto.class);
    }

    public GroupDto saveGroup(GroupDto groupDto){
        // convert DTO to entity
        Group groupRequest = groupMapping.convertToEntity(groupDto,Group.class);
        User getUserData = userService.getUserById(groupRequest.getCreatedby().getId());
        groupRequest.setCreatedby(getUserData);
        log.info("Saving new role {} to database",groupRequest.getId());
        Group group = repository.save(groupRequest);
        // convert entity to DTO
        GroupDto groupResponse = groupMapping.convertToDto(group, GroupDto.class);
        return groupResponse;
    }


    public Group getGroupById(long id){
        return repository.findById(id).orElse(null);
    }


    public String deleteGroup(long id){
        repository.deleteById(id);
        return "Group removed !!";
    }

    public Group updateGroup(Group group) {
        Group existingGroup = repository.findById(group.getId()).orElse(null);
        if(existingGroup !=null) {
            User getUserData = userService.getUserById(group.getCreatedby().getId());
            existingGroup.setName(group.getName());
            existingGroup.setParentpath(group.getParentpath());
            existingGroup.setDisplayname(group.getDisplayname());
            existingGroup.setDescription(group.getDescription());
            existingGroup.setCreatedby(getUserData);
        }
        return repository.save(existingGroup);
    }
}
