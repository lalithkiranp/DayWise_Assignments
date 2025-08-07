package com.example.flight_booking.repositories;

import com.example.flight_booking.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    // To ensure flightNumber uniqueness or search by it
    Optional<Flight> findByFlightNumber(String flightNumber);
}

