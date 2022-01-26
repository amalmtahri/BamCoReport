package com.application.bamcoreport.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profilemembers")
public class ProfileMember {


    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name="profiles_id")
    private Profile profile;

    @ManyToOne()
    @JoinColumn(name="users_id")
    private  User user;

    @ManyToOne()
    @JoinColumn(name="groupes_id")
    private  Group group;

    @ManyToOne()
    @JoinColumn(name="roles_id")
    private Role role;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date lastUpdate;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
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
