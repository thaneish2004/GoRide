package com.taxi.app.repository;

import com.taxi.app.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Booking entity operations.
 * Provides query methods for retrieving bookings by passenger.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    /** Retrieve all bookings for a specific passenger. */
    List<Booking> findByPassengerId(String passengerId);
}
