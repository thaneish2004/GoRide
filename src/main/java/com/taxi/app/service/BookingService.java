package com.taxi.app.service;

import com.taxi.app.model.Booking;
import com.taxi.app.model.Driver;
import com.taxi.app.repository.BookingRepository;
import com.taxi.app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for ride booking operations.
 * Handles fare calculation, booking lifecycle, and driver assignment.
 */
@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public BookingService(BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    /** Calculate fare based on distance (standard $3 base + $1.5/km). */
    public double calculateFare(double distance) {
        return calculateFare(distance, false);
    }

    /** Calculate fare with cooperation discount ($1.2/km for shared rides). */
    public double calculateFare(double distance, boolean cooperation) {
        double baseFare = 3.0;
        double perKm = cooperation ? 1.2 : 1.5;
        double fare = baseFare + distance * perKm;
        return Math.round(fare * 100.0) / 100.0;
    }

    /** Create a booking in PENDING status. Validates scheduled time if applicable. */
    public Booking createBooking(Booking booking) {
        if ("SCHEDULED".equalsIgnoreCase(booking.getBookingType())) {
            if (booking.getScheduledTime() == null || booking.getScheduledTime().isBlank()) {
                throw new IllegalArgumentException("Scheduled time required for scheduled bookings");
            }
        }
        booking.setId(UUID.randomUUID().toString());
        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }

    /** Assign driver to booking, set fare, mark as CONFIRMED, flag driver BUSY. */
    public Booking assignDriver(String bookingId, String driverId, double fare) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + bookingId));
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found: " + driverId));
        booking.setDriverId(driverId);
        booking.setFare(fare);
        booking.setStatus("CONFIRMED");
        driver.setStatus("BUSY");
        driverRepository.save(driver);
        return bookingRepository.save(booking);
    }

    /** Retrieve all bookings. */
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    /** Find booking by ID. */
    public Optional<Booking> findById(String id) {
        return bookingRepository.findById(id);
    }

    /** Retrieve all bookings for a passenger. */
    public List<Booking> findByPassengerId(String passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    /** Update existing booking. */
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    /** Cancel booking by ID (sets CANCELLED status). Returns true if cancelled. */
    public boolean cancelById(String id) {
        Optional<Booking> opt = bookingRepository.findById(id);
        if (opt.isPresent()) {
            Booking b = opt.get();
            b.setStatus("CANCELLED");
            bookingRepository.save(b);
            return true;
        }
        return false;
    }
}
