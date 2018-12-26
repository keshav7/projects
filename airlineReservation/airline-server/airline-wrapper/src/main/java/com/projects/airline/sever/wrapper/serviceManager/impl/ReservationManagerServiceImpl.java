package com.projects.airline.sever.wrapper.serviceManager.impl;

import com.projects.airline.server.core.domain.FlightSeat;
import com.projects.airline.server.core.domain.Traveller;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateReservationRequest;
import com.projects.airline.server.core.service.api.FlightSeatService;
import com.projects.airline.server.core.service.api.ReservationService;
import com.projects.airline.server.core.service.api.TravellerService;
import com.projects.airline.sever.wrapper.serviceManager.api.ReservationManagerService;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ReservationManagerServiceImpl implements ReservationManagerService {

    @Autowired
    FlightSeatService flightSeatService;
    @Autowired
    TravellerService travellerService;
    @Autowired
    ReservationService reservationService;

    @Override
    public ClientResponse createReservation(CreateReservationRequest reservationRequest,
                                            String requestedBy, String requestId) throws AirlineException {
        try {
            ClientResponse clientResponse = null;
            FlightSeat flightSeat = flightSeatService.findById(Long.parseLong(reservationRequest.getSeat()));
            Traveller traveller = travellerService.findById(Long.parseLong(reservationRequest.getTraveller()));
            reservationService.save(reservationRequest, flightSeat, traveller);
            Map<String, Object> responseData = new HashMap();
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
            return clientResponse;
        } catch(AirlineException e) {
            throw e;
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
