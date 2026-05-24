package com.taxi.app.dto;

/**
 * View projection of a booking for display in tables.
 * Resolves foreign IDs to human-readable names (passengerName, driverName).
 */
public class BookingView {
    private String bookingId;
    private String passengerName;
    private String driverName;
    private String pickup;
    private String drop;
    private String status;
    private double fare;
    private String bookingType;
    private String vehicleType;
    private String paymentMethod;

    /** Required by Jackson. */
    public BookingView() {}

    public BookingView(String bookingId, String passengerName, String driverName,
                       String pickup, String drop, String status, double fare,
                       String bookingType, String vehicleType, String paymentMethod) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.driverName = driverName;
        this.pickup = pickup;
        this.drop = drop;
        this.status = status;
        this.fare = fare;
        this.bookingType = bookingType;
        this.vehicleType = vehicleType;
        this.paymentMethod = paymentMethod;
    }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getPickup() { return pickup; }
    public void setPickup(String pickup) { this.pickup = pickup; }
    public String getDrop() { return drop; }
    public void setDrop(String drop) { this.drop = drop; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public String getBookingType() { return bookingType; }
    public void setBookingType(String bookingType) { this.bookingType = bookingType; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
