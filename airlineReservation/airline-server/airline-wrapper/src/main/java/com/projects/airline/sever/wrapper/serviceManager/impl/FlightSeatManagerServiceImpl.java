package com.projects.airline.sever.wrapper.serviceManager.impl;

import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.SeatFare;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreatSeatRequest;
import com.projects.airline.server.core.service.api.FlightSeatService;
import com.projects.airline.server.core.service.api.FlightService;
import com.projects.airline.server.core.service.api.SeatFareService;
import com.projects.airline.sever.wrapper.serviceManager.api.FlightSeatManagerService;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class FlightSeatManagerServiceImpl implements FlightSeatManagerService {

    @Autowired
    FlightService flightService;
    @Autowired
    SeatFareService seatFareService;
    @Autowired
    FlightSeatService flightSeatService;

    @Override
    public ClientResponse createFlightSeats(List<CreatSeatRequest> creatSeatsRequest,
                                            String requestedBy, String requestId) throws AirlineException {
        try {
            ClientResponse clientResponse = null;
            for(CreatSeatRequest creatSeatRequest: creatSeatsRequest) {
                SeatFare seatFare = seatFareService.findById(Long.parseLong(creatSeatRequest.getFare()));
                Flight flight = flightService.findById(Long.parseLong(creatSeatRequest.getFlight()));
                flightSeatService.save(creatSeatRequest, flight, seatFare);
            }
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
