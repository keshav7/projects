package com.projects.airline.server.core.service.api;

import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;

public interface AirlineCompanyService {

    AirlineCompany addAirlineCompany(CreateAirlineCompanyRequest createAirlineCompanyRequest, String requestedBy) throws AirlineException;
    AirlineCompany findById(Long airlineCompanyId) throws AirlineException;

}
