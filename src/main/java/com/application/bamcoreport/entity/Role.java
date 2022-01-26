package com.application.bamcoreport.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String name;
    private String displayName;
    private String description;
    private int createdBy;
    private Date creationDate;
    private Date lastUpdate;
    private int iconId;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
