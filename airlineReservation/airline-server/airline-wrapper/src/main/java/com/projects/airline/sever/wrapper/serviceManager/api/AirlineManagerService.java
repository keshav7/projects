package com.projects.airline.sever.wrapper.serviceManager.api;

import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;
import com.projects.core.datatypes.dto.ClientResponse;

public interface AirlineManagerService {

    ClientResponse createAirlineCompany(CreateAirlineCompanyRequest createAirlineCompanyRequest, String requestedBy,
                                        String requestId) throws AirlineException;
}
