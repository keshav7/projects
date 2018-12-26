package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Reservation extends AuditedBaseEntity{
    @JoinColumn(name = "traveller_id")
    @OneToOne(fetch = FetchType.LAZY)
    Traveller travellerId;
    @JoinColumn(name = "seat_id")
    @OneToOne(fetch = FetchType.LAZY)
    FlightSeat seatId;
}
