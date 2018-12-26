package com.projects.airline.server.core.repository;

import com.projects.airline.server.core.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
