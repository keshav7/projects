package com.projects.airline.sever.wrapper.serviceManager.api;

import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;
import com.projects.airline.server.core.request.CreateFlightRequest;
import com.projects.core.datatypes.dto.ClientResponse;

public interface FlightManagerService {

    ClientResponse createFlight(CreateFlightRequest createFlightRequest, String requestedBy,
                                String requestId) throws AirlineException;

}
