package com.projects.airline.sever.wrapper.serviceManager.impl;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateFlightRequest;
import com.projects.airline.server.core.service.api.AircraftService;
import com.projects.airline.server.core.service.api.AirlineCompanyService;
import com.projects.airline.server.core.service.api.FlightService;
import com.projects.airline.server.core.service.api.LocationService;
import com.projects.airline.sever.wrapper.serviceManager.api.FlightManagerService;
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
public class FlightManagerServiceImpl implements FlightManagerService{

    @Autowired
    FlightService flightService;
    @Autowired
    LocationService locationService;
    @Autowired
    AirlineCompanyService airlineCompanyService;
    @Autowired
    AircraftService aircraftService;
    private static final String FLIGHT_ID = "flight_id";
    @Override
    public ClientResponse createFlight(CreateFlightRequest createFlightRequest,
                                       String requestedBy, String requestId) throws AirlineException {
        try {
            ClientResponse clientResponse = null;
            Location srcLocation = locationService.findById(Long.parseLong(createFlightRequest.getSrcLocation()));
            Location destLocation = locationService.findById(Long.parseLong(createFlightRequest.getDestLocation()));
            AirlineCompany airlineCompany = airlineCompanyService.findById(Long.parseLong(createFlightRequest.getAirlineCompany()));
            Aircraft aircraft = aircraftService.findById(Long.parseLong(createFlightRequest.getAircraft()));
            flightService.saveFlight(createFlightRequest, airlineCompany, aircraft, srcLocation, destLocation, requestedBy);
            Map<String, Object> responseData = new HashMap();
            responseData.put(FLIGHT_ID, airlineCompany.getId());
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
            return clientResponse;
        } catch(AirlineException e) {
            throw e;
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }

    }
}
