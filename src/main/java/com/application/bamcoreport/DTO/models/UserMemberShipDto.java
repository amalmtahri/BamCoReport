package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;

import java.util.Date;

public class UserMemberShipDto {


    private Long id;
    private User userId;
    private Role roleId;
    private Group groupId;
    private User assignedBy;
    private Date assignedDate;

    public UserMemberShipDto() {
    }

    public UserMemberShipDto(Long id, User userId, Role roleId, Group groupId, User assignedBy, Date assignedDate) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }
}
