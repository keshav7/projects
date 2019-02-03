package com.projects.pl.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import com.projects.pl.server.core.enums.SlotState;
import com.projects.pl.server.core.enums.SlotType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "slot_booking")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class SlotBooking extends AuditedBaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "vehicle")
    private String vehicle;
    @Column(name = "status", columnDefinition = "VARCHAR(60)", nullable = false)
    @Enumerated(EnumType.STRING)
    @Audited
    @NotNull
    private SlotState slotState;
    @Column(name = "slot_type", columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private SlotType slotType;
}
