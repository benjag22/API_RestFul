package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;


@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(columnDefinition = "date", updatable = false, nullable = false)
    protected Date createDate;

    @Column(columnDefinition = "date", nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = new Date();
        if (createDate == null) {
            createDate = new Date();
        }
    }

    public long getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }
}