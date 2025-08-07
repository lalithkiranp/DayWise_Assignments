package com.example.flight_booking.service;



import com.example.flight_booking.entities.Flight;
import com.example.flight_booking.entities.Reservation;
import com.example.flight_booking.repositories.FlightRepository;
import com.example.flight_booking.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookReservation(Reservation reservation) {
        Long flightId = reservation.getFlight().getId();
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight with ID " + flightId + " not found."));

        if (reservation.getSeatsBooked() > flight.getSeatsAvailable()) {
            throw new RuntimeException("Not enough seats available for flight " + flight.getFlightNumber());
        }

        flight.setSeatsAvailable(flight.getSeatsAvailable() - reservation.getSeatsBooked());
        flightRepository.save(flight);

        reservation.setFlight(flight);
        reservation.setReservedAt(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByFlightId(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation with ID " + reservationId + " not found."));

        Flight flight = reservation.getFlight();
        flight.setSeatsAvailable(flight.getSeatsAvailable() + reservation.getSeatsBooked());

        flightRepository.save(flight);
        reservationRepository.delete(reservation);
    }
}

