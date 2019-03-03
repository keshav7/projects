package com.projects.pl.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "billing")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Billing extends AuditedBaseEntity{

    @Column(name = "slot_id")
    Long slot_id;
    @Column(name = "duration_in_mins")
    Long durationMins;
    @Column(name = "price")
    Double price;

}
