package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Location;
import com.projects.airline.server.core.domain.Traveller;
import com.projects.airline.server.core.exception.AirlineException;

public interface TravellerService {
    Traveller save(Traveller traveller) throws AirlineException;
    Traveller findById(Long travellerId) throws AirlineException;
}
