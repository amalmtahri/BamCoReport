package com.application.bamcoreport.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_memberships")
public class UserMemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    private Role roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignedby")
    private User assignedBy;

    @CreatedDate
    @Column(name = "assigned_date", nullable = false, updatable = false)
    private Date assignedDate;

    public UserMemberShip(Long id, User userId, Role roleId, Group groupId, User assignedBy) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
        this.assignedBy = assignedBy;
    }

    public UserMemberShip() {
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

    @Override
    public String toString() {
        return "UserMemberShip{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                ", assignedBy=" + assignedBy +
                ", assignedDate=" + assignedDate +
                '}';
    }
}
