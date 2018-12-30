package com.projects.fc.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "company")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Company extends AuditedBaseEntity{
    @Column(name = "name")
    @NotNull
    String name;
    @Column(name = "description")
    @NotNull
    String description;
}
