package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.Flight;
import com.projects.airline.server.core.domain.FlightSeat;
import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.domain.SeatFare;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.enums.SeatStatus;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.FlightSeatRepository;
import com.projects.airline.server.core.request.CreatSeatRequest;
import com.projects.airline.server.core.service.api.FlightSeatService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FlightSeatServiceImpl implements FlightSeatService {

    @Autowired
    FlightSeatRepository flightSeatRepository;
    @Override
    public Iterable<FlightSeat> save(CreatSeatRequest seatRequest, Flight flight, SeatFare fare) throws AirlineException {
        try {
            return flightSeatRepository.save(setDomainAttributes(seatRequest, flight, fare));
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public FlightSeat findById(Long seatId) throws AirlineException{
        try {
            return flightSeatRepository.findOne(seatId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    private List<FlightSeat> setDomainAttributes(CreatSeatRequest seatRequest, Flight flight, SeatFare fare) {
        List<FlightSeat> flightSeats = new ArrayList<>();
        for (int i = seatRequest.getSeat_from(); i <= seatRequest.getSeat_to(); i++) {
            FlightSeat flightSeat = new FlightSeat();
            flightSeat.setCreatedAt(new DateTime());
            flightSeat.setFareId(fare);
            flightSeat.setFlight(flight);
            flightSeat.setStatus(SeatStatus.AVAILABLE);
            flightSeat.setNumber(i);
            flightSeats.add(flightSeat);
        }
        return flightSeats;
    }
}