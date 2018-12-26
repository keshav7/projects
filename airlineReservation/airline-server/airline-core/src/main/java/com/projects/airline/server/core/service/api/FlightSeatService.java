package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.FlightSeat;
import com.projects.airline.server.core.domain.SeatFare;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreatSeatRequest;

import java.util.List;

public interface FlightSeatService {
    Iterable<FlightSeat> save(CreatSeatRequest seatRequest, Flight flight, SeatFare fare) throws AirlineException;
}
