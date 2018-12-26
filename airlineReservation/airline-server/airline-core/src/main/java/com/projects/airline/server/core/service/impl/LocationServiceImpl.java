package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.LocationRepository;
import com.projects.airline.server.core.service.api.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location save(Location location) throws AirlineException{
        try {
            return locationRepository.save(location);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Location findById(Long locationId) throws AirlineException{
        try {
            return locationRepository.findOne(locationId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
