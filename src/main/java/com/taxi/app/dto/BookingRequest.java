package com.taxi.app.dto;

public class BookingRequest {
    private String pickupLocation;
    private String dropLocation;
    private String vehicleType;
    private String bookingType;
    private String scheduledTime;
    private boolean cooperation;
    private double distance;
    private double fare;
    private String paymentMethod;

    public BookingRequest() {}

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
    public boolean isCooperation() { return cooperation; }
    public void setCooperation(boolean cooperation) { this.cooperation = cooperation; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
