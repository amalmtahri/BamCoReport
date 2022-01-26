package com.application.bamcoreport.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_memberships")
public class UserMemberShip {
    private Long id;
    private User user_id;
    private Role role_id;
    private Group group_id;
    private User assignedBy;
    private Date assignedDate;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public Group getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Group group_id) {
        this.group_id = group_id;
    }

    @ManyToMany
    @JoinColumn(name = "user_id")
    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    @CreatedDate
    @Column(name = "assigned_date", nullable = false, updatable = false)
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }
}
