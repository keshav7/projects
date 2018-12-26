package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.AirlineCompany;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository extends CrudRepository<AirlineCompany, Long> {

}
