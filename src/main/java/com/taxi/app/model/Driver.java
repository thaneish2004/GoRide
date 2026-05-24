package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a driver who accepts and fulfills ride bookings.
 * Status tracks availability for dispatching new tasks.
 */
@Entity
@Table(name = "drivers")
public class Driver extends Person {

    /** Driver's license number. */
    private String licenseNumber;
    /** Current availability: AVAILABLE, BUSY, or OFFLINE. */
    private String status;

    /** Required by JPA. */
    public Driver() {}

    /**
     * Constructs a Driver with full details.
     * @param licenseNumber driver's license identifier
     * @param status        initial availability status
     */
    public Driver(String id, String name, String email, String phone, String password,
                  String licenseNumber, String status) {
        super(id, name, email, phone, password);
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    @Override
    public String getRole() { return "DRIVER"; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
