package com.application.bamcoreport.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userId")
    private UserContactInfo userContactInfo;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name = "manageruserid")
    private User managerUserId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date lastUpdate;

    public User(User user){
        this.id= user.getId();
        this.userContactInfo = user.getUserContactInfo();
        this.enabled = user.isEnabled();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.title = user.getTitle();
        this.jobTitle = user.getJobTitle();
        this.managerUserId = user.getManagerUserId();
        this.createdBy = user.getCreatedBy();
        this.creationDate = user.getCreationDate();
        this.lastUpdate = user.getLastUpdate();
    }


}
