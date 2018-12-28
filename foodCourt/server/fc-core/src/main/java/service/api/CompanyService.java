package service.api;

import domain.Company;
import domain.MenuItem;
import exception.FCException;

public interface CompanyService {
    Company save(Company company) throws FCException;
    Company findById(Long companyId) throws FCException;
}
