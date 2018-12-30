package com.projects.fc.server.service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.exception.FCException;

public interface CompanyManagerService {
    ClientResponse addCompany(Company company, String requestedBy,
                              String requestId) throws FCException;
}
