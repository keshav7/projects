package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.AirlineCompany;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.AirlineRepository;
import com.projects.airline.server.core.request.CreateAirlineCompanyRequest;
import com.projects.airline.server.core.service.api.AirlineCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public AirlineCompany addAirlineCompany(CreateAirlineCompanyRequest createAirlineCompanyRequest, String requestedBy)
            throws AirlineException {
        try {
            return airlineRepository.save(setDomainAttributesForAirlineCompany(createAirlineCompanyRequest));
        } catch (Exception e) {
        throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public AirlineCompany findById(Long airlineCompanyId) throws AirlineException {
        try {
            return airlineRepository.findOne(airlineCompanyId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }


    private AirlineCompany setDomainAttributesForAirlineCompany(CreateAirlineCompanyRequest createAirlineCompanyRequest) {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setName(createAirlineCompanyRequest.getName());
        airlineCompany.setRegistrationNumber(createAirlineCompanyRequest.getRegistrationNumber());
        return airlineCompany;
    }
}
