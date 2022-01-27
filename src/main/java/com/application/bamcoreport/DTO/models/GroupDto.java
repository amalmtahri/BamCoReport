package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;

import java.util.Date;

public class GroupDto {

    private Long id;
    private String name;
    private String parentPath;
    private String displayname;
    private String description;
    private User createdBy;
    private Date creationDate;
    private Date lastUpdate;

    public GroupDto() {
    }

    public GroupDto(Long id, String name, String parentPath, String displayname, String description, User createdBy, Date creationDate, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.parentPath = parentPath;
        this.displayname = displayname;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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


    @Override
    public String toString() {
        return "GroupDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", displayname='" + displayname + '\'' +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
