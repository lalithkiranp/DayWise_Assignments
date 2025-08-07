package com.example.flight_booking.repositories;

import com.example.flight_booking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Get all reservations for a specific flight
    List<Reservation> findByFlightId(Long flightId);
}
