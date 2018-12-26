package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.AircraftRepository;
import com.projects.airline.server.core.service.api.AircraftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AircraftServiceIml implements AircraftService {

    @Autowired
    AircraftRepository aircraftRepository;

    @Override
    public Aircraft save(Aircraft aircraft) throws AirlineException {
        try {
            return aircraftRepository.save(aircraft);
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Aircraft findById(Long aircraftId) throws AirlineException {
        try {
            return aircraftRepository.findOne(aircraftId);
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
