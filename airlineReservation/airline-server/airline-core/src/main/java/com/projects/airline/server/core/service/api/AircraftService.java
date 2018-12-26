package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;

public interface AircraftService {

    Aircraft save(Aircraft aircraft) throws AirlineException;
    Aircraft findById(Long aircraftId) throws AirlineException;
}
