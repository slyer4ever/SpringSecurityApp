package com.example.demo.dao;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class Auditable<U> {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    protected Date creationDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    protected Date lastModifiedDate;

    // Getters and Setters

}
