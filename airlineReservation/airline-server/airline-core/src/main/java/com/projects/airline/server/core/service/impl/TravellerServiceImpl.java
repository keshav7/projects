package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.Traveller;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.TravellerRepository;
import com.projects.airline.server.core.service.api.TravellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TravellerServiceImpl implements TravellerService{

    @Autowired
    TravellerRepository travellerRepository;

    @Override
    public Traveller save(Traveller traveller) throws AirlineException {
        try {
            return travellerRepository.save(traveller);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Traveller findById(Long travellerId) throws AirlineException {
        try {
            return travellerRepository.findOne(travellerId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
