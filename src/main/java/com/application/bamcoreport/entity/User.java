package com.application.bamcoreport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Schema
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "jobtitle", nullable = false)
    private String jobtitle;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "manageruserid")
    private User manageruserid;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   // @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "createdby")
    private User createdby;

    @CreatedDate
    @Column(name = "createdat", nullable = false, updatable = false)
    private Date creationdate;

    @LastModifiedDate
    @Column(name = "updatedat")
    private Date lastupdate;

    public User() {
    }

    public User(long id, UserContactInfo userContactInfo, boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, User manageruserid, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
        this.userContactInfo = userContactInfo;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }


    public User(long id, boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, User manageruserid, User createdby, Date creationdate, Date lastupdate) {
        this.id = id;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserContactInfo getUserContactInfo() {
        return userContactInfo;
    }

    public void setUserContactInfo(UserContactInfo userContactInfo) {
        this.userContactInfo = userContactInfo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public User getManageruserid() {
        return manageruserid;
    }

    public void setManageruserid(User manageruserid) {
        this.manageruserid = manageruserid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }
}
