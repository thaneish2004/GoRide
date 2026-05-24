package com.taxi.app.service;

import com.taxi.app.model.Booking;
import com.taxi.app.model.Driver;
import com.taxi.app.repository.BookingRepository;
import com.taxi.app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public BookingService(BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    public double calculateFare(double distance) {
        return calculateFare(distance, false);
    }

    public double calculateFare(double distance, boolean cooperation) {
        double baseFare = 3.0;
        double perKm = cooperation ? 1.2 : 1.5;
        double fare = baseFare + distance * perKm;
        return Math.round(fare * 100.0) / 100.0;
    }

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

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(String id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findByPassengerId(String passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

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
