package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.SeatFare;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.SeatFareRepository;
import com.projects.airline.server.core.service.api.SeatFareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SeatFareServiceImpl implements SeatFareService {

    @Autowired
    SeatFareRepository seatFareRepository;

    @Override
    public SeatFare save(SeatFare seatFare) throws AirlineException {
        try {
            return seatFareRepository.save(seatFare);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public SeatFare findById(Long seatFareId) throws AirlineException {
        try {
            return seatFareRepository.findOne(seatFareId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
