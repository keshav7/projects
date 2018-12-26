package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "airline_company")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class AirlineCompany extends AuditedBaseEntity {
    @Column(name = "name")
    @NotNull
    String name;
    @Column(name = "registration_number")
    String registrationNumber;
}
