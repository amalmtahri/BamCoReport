package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.Group;
import com.application.bamcoreport.entity.Profile;
import com.application.bamcoreport.entity.Role;
import com.application.bamcoreport.entity.User;

import java.util.Date;

public class ProfileMemberDto {
    private long id;
    private Profile profile;
    private User user;
    private Group group;
    private Role role;
    private Date creationDate;
    private Date lastUpdate;

    public ProfileMemberDto() {
    }

    public ProfileMemberDto(long id, Profile profile, User user, Group group, Role role, Date creationDate, Date lastUpdate) {
        this.id = id;
        this.profile = profile;
        this.user = user;
        this.group = group;
        this.role = role;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
