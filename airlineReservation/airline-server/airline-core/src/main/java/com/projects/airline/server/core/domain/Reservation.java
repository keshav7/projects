package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reservation")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Reservation extends AuditedBaseEntity{
    @JoinColumn(name = "traveller_id")
    @OneToOne(fetch = FetchType.LAZY)
    Traveller travellerId;
    @JoinColumn(name = "seat_id")
    @OneToOne(fetch = FetchType.LAZY)
    FlightSeat seatId;
}
