package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.Aircraft;
import com.projects.core.domain.AuditedBaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}
