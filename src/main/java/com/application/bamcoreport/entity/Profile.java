package com.application.bamcoreport.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isdefault", nullable = false)
    private  boolean isDefault;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private  String description;

    @CreatedDate
    @Column(name = "creationdate", nullable = false, updatable = false)
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name="users_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User createdBy;

    @LastModifiedDate
    @Column(name = "lastupdatedate", nullable = false)
    private Date lastUpdateDate;


    @ManyToOne()
    @JoinColumn(name="users_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User lastUpdateBy;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
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


    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


    public User getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(User lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", isDefault=" + isDefault +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateBy=" + lastUpdateBy +
                '}';
    }
}
