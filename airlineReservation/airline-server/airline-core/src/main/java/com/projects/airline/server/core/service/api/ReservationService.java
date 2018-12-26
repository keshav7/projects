package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.FlightSeat;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.domain.Reservation;
import com.projects.airline.server.core.domain.Traveller;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateReservationRequest;

public interface ReservationService {

    Reservation save(CreateReservationRequest reservationRequest, FlightSeat flightSeat, Traveller traveller) throws AirlineException;
    Reservation findById(Long reservationId) throws AirlineException;
}
