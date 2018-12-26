package com.projects.airline.server.core.service.impl;

import com.projects.airline.server.core.domain.FlightSeat;
import com.projects.airline.server.core.domain.Reservation;
import com.projects.airline.server.core.domain.Traveller;
import com.projects.airline.server.core.enums.Errors;
import com.projects.airline.server.core.exception.AirlineException;
import com.projects.airline.server.core.repository.ReservationRepository;
import com.projects.airline.server.core.request.CreateReservationRequest;
import com.projects.airline.server.core.service.api.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation save(CreateReservationRequest reservationRequest, FlightSeat seat, Traveller traveller) throws AirlineException {
        try {

            Reservation reservation = setDomainAttributes(reservationRequest, seat, traveller);
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    private Reservation setDomainAttributes(CreateReservationRequest reservationRequest, FlightSeat seat, Traveller traveller) {

        Reservation reservation = new Reservation();
        reservation.setSeatId(seat);
        reservation.setTravellerId(traveller);
        return reservation;
    }

    @Override
    public Reservation findById(Long reservationId) throws AirlineException {
        try {
            return reservationRepository.findOne(reservationId);
        } catch (Exception e) {
            throw new AirlineException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}