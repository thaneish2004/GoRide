package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a ride booking from request through completion.
 * Tracks the full lifecycle: PENDING -> CONFIRMED -> IN_PROGRESS -> COMPLETED / CANCELLED.
 */
@Entity
@Table(name = "bookings")
public class Booking {

    /** Unique booking identifier (UUID string). */
    @Id
    private String id;

    /** References the Passenger who created this booking. */
    private String passengerId;
    /** References the Driver assigned to this booking (null until accepted). */
    private String driverId;
    private String pickupLocation;
    private String dropLocation;
    /** Requested vehicle category. */
    private String vehicleType;
    /** Type: INSTANT or SCHEDULED. */
    private String bookingType;
    /** For SCHEDULED bookings, the requested pickup time. */
    private String scheduledTime;
    /** Lifecycle status: PENDING, CONFIRMED, IN_PROGRESS, COMPLETED, CANCELLED. */
    private String status;

    /** Calculated fare amount for the ride. */
    private double fare;

    /** Payment method: CASH, CARD, etc. */
    private String paymentMethod;

    /** Whether this booking is part of a cooperation/shared ride. */
    private boolean cooperation;

    /** Required by JPA. */
    public Booking() {}

    /**
     * Constructs a Booking with full details.
     * @param passengerId   who requested the ride
     * @param driverId      who will drive (may be null)
     * @param pickupLocation origin address
     * @param dropLocation   destination address
     * @param vehicleType    requested vehicle category
     * @param bookingType    INSTANT or SCHEDULED
     * @param scheduledTime  pickup time for scheduled rides
     * @param status         current lifecycle status
     * @param fare           ride fare
     * @param paymentMethod  how the fare will be paid
     * @param cooperation    shared ride flag
     */
    public Booking(String id, String passengerId, String driverId, String pickupLocation,
                   String dropLocation, String vehicleType, String bookingType,
                   String scheduledTime, String status, double fare,
                   String paymentMethod, boolean cooperation) {
        this.id = id;
        this.passengerId = passengerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.vehicleType = vehicleType;
        this.bookingType = bookingType;
        this.scheduledTime = scheduledTime;
        this.status = status;
        this.fare = fare;
        this.paymentMethod = paymentMethod;
        this.cooperation = cooperation;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }
    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public String getBookingType() { return bookingType; }
    public void setBookingType(String bookingType) { this.bookingType = bookingType; }
    public String getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(String scheduledTime) { this.scheduledTime = scheduledTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public boolean isCooperation() { return cooperation; }
    public void setCooperation(boolean cooperation) { this.cooperation = cooperation; }
}
