package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;
import io.swagger.annotations.ApiModel;

import java.util.Date;


@ApiModel("Role")
public class RoleDto {


    private Long id;
    private String name;
    private String displayName;
    private String description;
    private User createdby;
    private Date creationDate;
    private Date lastUpdate;


    public RoleDto() {
    }

    public RoleDto(Long id, String name, String displayName, String description, User createdBy, Date creationDate, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.createdby = createdBy;
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


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdby;
    }

    public void setCreatedBy(User createdBy) {
        this.createdby = createdBy;
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
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", createdBy=" + createdby +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
