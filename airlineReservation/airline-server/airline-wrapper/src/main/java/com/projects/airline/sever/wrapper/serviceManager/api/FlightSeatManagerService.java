package com.projects.airline.sever.wrapper.serviceManager.api;

import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreatSeatRequest;
import com.projects.airline.server.core.request.CreateFlightRequest;
import com.projects.core.datatypes.dto.ClientResponse;

import java.util.List;

public interface FlightSeatManagerService {
    ClientResponse createFlightSeats(List<CreatSeatRequest> creatSeatsRequest, String requestedBy,
                                     String requestId) throws AirlineException;
}
