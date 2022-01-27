package com.application.bamcoreport.DTO.models;

import com.application.bamcoreport.entity.User;

import java.util.Date;

public class UserDto {


    private Long id;
    private boolean enabled;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String jobTitle;
    private User managerUserId;
    private User createdBy;
    private Date creationDate;
    private Date lastUpdate;


    public UserDto() {
    }

    public UserDto(Long id, boolean enabled, String username, String password, String firstName, String lastName, String title, String jobTitle, User managerUserId, User createdBy, Date creationDate, Date lastUpdate) {
        this.id = id;
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.jobTitle = jobTitle;
        this.managerUserId = managerUserId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public User getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(User managerUserId) {
        this.managerUserId = managerUserId;
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
        return "UserDto{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", managerUserId=" + managerUserId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
