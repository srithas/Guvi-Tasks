package com.example.BusTicketing.repository;

import com.example.BusTicketing.domain.Booking;
import com.example.BusTicketing.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Find all bookings for a specific passenger
    List<Booking> findByPassenger(Passenger passenger);
}
