package com.projects.airline.server.core.repository;


import com.projects.airline.server.core.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long>{
}
