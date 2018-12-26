package com.projects.airline.server.core.domain;

import com.projects.airline.server.core.enums.AircraftType;
import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "aircraft")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Aircraft extends AuditedBaseEntity{
    @Column(name = "name")
    String name;
    @Column(name = "aircraft_type", columnDefinition = "VARCHAR(60)", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    AircraftType type;
    @Column(name = "man_date")
    DateTime manDate;
    @Column(name = "capacity")
    Integer capacity;

}
