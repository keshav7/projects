package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.Traveller;
import org.springframework.data.repository.CrudRepository;

public interface TravellerRepository extends CrudRepository<Traveller, Long> {
}
