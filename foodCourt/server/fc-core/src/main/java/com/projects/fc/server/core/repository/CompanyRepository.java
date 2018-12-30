package com.projects.fc.server.core.repository;

import com.projects.fc.server.core.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
