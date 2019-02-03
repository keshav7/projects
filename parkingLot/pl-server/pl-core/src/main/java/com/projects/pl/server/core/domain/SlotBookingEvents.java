package com.projects.pl.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import com.projects.pl.server.core.enums.SlotBookingEventName;
import com.projects.pl.server.core.enums.SlotState;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "slot_booking_events")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class SlotBookingEvents extends AuditedBaseEntity{

    @ManyToOne(fetch = FetchType.LAZY
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
            , optional = false)
    @JoinColumn(name = "slot_booking")
    SlotBooking slotBooking;
    @Column(name = "vehicle")
    String vehicle;
    @Column(name = "event_name", columnDefinition = "VARCHAR(20)", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    SlotBookingEventName slotBookingEventName;
}
