package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.FlightSeat;
import org.springframework.data.repository.CrudRepository;

public interface FlightSeatRepository extends CrudRepository<FlightSeat, Long> {
}
