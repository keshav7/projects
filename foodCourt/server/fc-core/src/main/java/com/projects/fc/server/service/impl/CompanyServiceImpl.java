package com.projects.fc.server.service.impl;

import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.repository.CompanyRepository;
import com.projects.fc.server.service.api.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company save(Company company) throws FCException {
        try {
            return companyRepository.save(company);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Company findById(Long companyId) throws FCException {
        try {
            return companyRepository.findOne(companyId);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
