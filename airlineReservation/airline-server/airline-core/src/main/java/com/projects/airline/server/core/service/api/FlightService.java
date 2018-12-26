package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateFlightRequest;

public interface FlightService {

    Flight saveFlight(CreateFlightRequest flightRequest,
                      AirlineCompany airlineCompany,
                      Aircraft aircraft,
                      Location srcLocation,
                      Location destLocation,
                      String requestedBy) throws AirlineException;
    Flight findById(Long flightId) throws AirlineException;
}
