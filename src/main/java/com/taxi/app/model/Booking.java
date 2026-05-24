package com.taxi.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    private String id;

    private String passengerId;
    private String driverId;
    private String pickupLocation;
    private String dropLocation;
    private String vehicleType;
    private String bookingType;
    private String scheduledTime;
    private String status;

    private double fare;

    private String paymentMethod;

    private boolean cooperation;

    public Booking() {}

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
