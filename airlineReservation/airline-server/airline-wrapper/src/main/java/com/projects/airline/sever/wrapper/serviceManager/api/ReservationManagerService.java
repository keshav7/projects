package com.projects.airline.sever.wrapper.serviceManager.api;

import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreatSeatRequest;
import com.projects.airline.server.core.request.CreateReservationRequest;
import com.projects.core.datatypes.dto.ClientResponse;

import java.util.List;

public interface ReservationManagerService {

    ClientResponse createReservation(CreateReservationRequest reservationRequest, String requestedBy,
                                     String requestId) throws AirlineException;
}
