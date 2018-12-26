package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.exception.AirlineException;

public interface LocationService {
    Location save(Location location) throws AirlineException;
    Location findById(Long locationId) throws AirlineException;
}
