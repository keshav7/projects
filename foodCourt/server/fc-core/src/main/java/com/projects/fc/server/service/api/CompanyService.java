package com.projects.fc.server.service.api;

import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.exception.FCException;

public interface CompanyService {
    Company save(Company company) throws FCException;
    Company findById(Long companyId) throws FCException;
}
