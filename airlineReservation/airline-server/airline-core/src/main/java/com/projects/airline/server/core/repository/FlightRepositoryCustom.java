package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateFlightRequest;

import java.util.List;

public interface FlightRepositoryCustom {
    List<Flight> search(CreateFlightRequest request) throws AirlineException;
    Long count(CreateFlightRequest request) throws AirlineException;
}
