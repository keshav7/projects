package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;

import javax.persistence.Column;

public class Traveller extends AuditedBaseEntity{
    @Column(name = "fname")
    String fName;
    @Column(name = "lname")
    String lName;
    @Column(name = "email")
    String email;
}
