package com.taxi.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver extends Person {

    private String licenseNumber;
    private String status;

    public Driver() {}

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
