package com.application.bamcoreport.DTO.models;

import java.sql.Date;

public class ProfileDto {
    private long id;
    private  boolean isDefault;
    private String name;
    private  String description;
    private Date creationDate;
    private long createdBy;
    private Date lastUpdateDate;
    private long lastUpdateBy;

    public ProfileDto() {
    }

    public ProfileDto(long id, boolean isDefault, String name, String description, Date creationDate, long createdBy, Date lastUpdateDate, long lastUpdateBy) {
        this.id = id;
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
