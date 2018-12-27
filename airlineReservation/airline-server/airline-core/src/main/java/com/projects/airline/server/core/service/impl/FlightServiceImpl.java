package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.enums.FlightStatus;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.FlightRepository;
import com.projects.airline.server.core.repository.FlightRepositoryCustom;
import com.projects.airline.server.core.request.CreateFlightRequest;
import com.projects.airline.server.core.service.api.FlightService;
import com.projects.airline.server.core.utils.DateTimeFormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightRepositoryCustom flightRepositoryCustom;

    @Override
    public Flight saveFlight(CreateFlightRequest flightRequest, AirlineCompany airlineCompany,
                             Aircraft aircraft, Location srcLocation, Location destLocation,
                             String requestedBy) throws AirlineException {
        try {
            Flight flight = setDomainAttributes(flightRequest);
            flight.setAirlineCompany(airlineCompany);
            flight.setAircraft(aircraft);
            flight.setSourceLoc(srcLocation);
            flight.setDestLoc(destLocation);
            flight.setCreatedAt(new DateTime());
            flight.setCreatedBy(requestedBy);
            return flightRepository.save(flight);
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }

    }

    @Override
    public Flight findById(Long flightId) throws AirlineException{
        try {
            return flightRepository.findOne(flightId);
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public List<Flight> search(CreateFlightRequest request) throws AirlineException {
        try {
            return flightRepositoryCustom.search(request);
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    private Flight setDomainAttributes(CreateFlightRequest flightRequest) {
        Flight flight = new Flight();
        flight.setStatus(FlightStatus.CREATED);
        flight.setDesignSrcArrivalTime(DateTimeFormatUtils.FORMATTER.
                parseDateTime(flightRequest.getDesignArrTimeSrc()));
        flight.setDesignSrcDepTime(DateTimeFormatUtils.FORMATTER.
                parseDateTime(flightRequest.getDesignDepTimeSrc()));
        flight.setDesignDestArrivalTime(DateTimeFormatUtils.FORMATTER.
                parseDateTime(flightRequest.getDesignArrTimeDest()));
        return flight;

    }
}
