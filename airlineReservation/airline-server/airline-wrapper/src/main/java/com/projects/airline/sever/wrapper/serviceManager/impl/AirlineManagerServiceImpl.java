package com.projects.airline.sever.wrapper.serviceManager.impl;


import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;
import com.projects.airline.server.core.service.api.AirlineCompanyService;
import com.projects.airline.sever.wrapper.serviceManager.api.AirlineManagerService;
import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class AirlineManagerServiceImpl implements AirlineManagerService{

    private static final String AIRLINE_COMPANY_ID = "airline_id";

    @Autowired
    AirlineCompanyService airlineCompanyService;

    @Override
    public ClientResponse createAirlineCompany(CreateAirlineCompanyRequest createAirlineCompanyRequest, String requestedBy, String requestId) throws AirlineException {

        ClientResponse clientResponse = null;
        try {
            AirlineCompany airlineCompany = airlineCompanyService.addAirlineCompany(createAirlineCompanyRequest,requestedBy);
            Map<String, Object> responseData = new HashMap();
            responseData.put(AIRLINE_COMPANY_ID, airlineCompany.getId());
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
        } catch(AirlineException e) {
            throw e;
        } catch(Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
        return clientResponse;
    }

    public static class ReservationManagerServiceImpl {
    }
}
