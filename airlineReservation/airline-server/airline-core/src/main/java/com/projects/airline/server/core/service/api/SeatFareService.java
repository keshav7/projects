package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.domain.SeatFare;
import com.projects.airline.server.core.exception.AirlineException;

public interface SeatFareService {
    SeatFare save(SeatFare seatFare) throws AirlineException;
    SeatFare findById(Long seatFareId) throws AirlineException;
}
