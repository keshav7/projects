package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
