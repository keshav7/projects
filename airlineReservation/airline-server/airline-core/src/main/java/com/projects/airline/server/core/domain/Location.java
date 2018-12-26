package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Location extends AuditedBaseEntity {
    @Column(name = "name")
    String name;
    @Column(name = "city")
    String city;
}
