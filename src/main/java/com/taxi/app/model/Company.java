package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a company/organization that owns vehicles and employs drivers.
 * Extends Person with company-specific business details.
 */
@Entity
@Table(name = "companies")
public class Company extends Person {

    /** Registered business name. */
    private String companyName;
    /** Official business registration number. */
    private String registrationNumber;

    /** Required by JPA. */
    public Company() {}

    /**
     * Constructs a Company with full details.
     * @param companyName        business name
     * @param registrationNumber official registration ID
     */
    public Company(String id, String name, String email, String phone, String password,
                   String companyName, String registrationNumber) {
        super(id, name, email, phone, password);
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getRole() { return "COMPANY"; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
}
