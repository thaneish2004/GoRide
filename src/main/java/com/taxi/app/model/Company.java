package com.taxi.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company extends Person {

    private String companyName;
    private String registrationNumber;

    public Company() {}

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
