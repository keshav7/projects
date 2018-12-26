package com.projects.airline.server.core.domain;

import com.projects.airline.server.core.enums.SeatStatus;
import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flight_seat")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class FlightSeat extends AuditedBaseEntity{

    @JoinColumn(name = "flight")
    @OneToOne(fetch = FetchType.LAZY)
    Flight flight;
    @Column(name = "number")
    Integer number;
    @JoinColumn(name = "fare_id")
    @OneToOne(fetch = FetchType.LAZY)
    SeatFare fareId;
    @Column(name = "seat_status", columnDefinition = "VARCHAR(60)", nullable = false)
    @Enumerated(EnumType.STRING)
    SeatStatus status;
}
