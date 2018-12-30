package com.projects.fc.server.service.impl;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.projects.fc.server.service.api.CompanyManagerService;
import com.projects.fc.server.service.api.CompanyService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CompanyManagerServiceImpl  implements CompanyManagerService{

    @Autowired
    CompanyService companyService;

    @Override
    public ClientResponse addCompany(Company company, String requestedBy, String requestId) throws FCException {
        try {
            ClientResponse clientResponse = null;
            Company company1 = companyService.save(company);
            Map<String, Object> responseData = new HashMap();
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
            return clientResponse;
        } catch(FCException e) {
            throw e;
        } catch(Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
