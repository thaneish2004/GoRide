package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Abstract base class for all person types in the system.
 * Uses JPA mapped superclass inheritance strategy. Each subclass
 * (Passenger, Driver, Company) maps to its own table.
 */
@MappedSuperclass
public abstract class Person {

    /** Unique identifier (UUID string). */
    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String password;

    /** Required by JPA. */
    protected Person() {}

    /**
     * Constructs a Person with the given attributes.
     * @param id    unique identifier
     * @param name  full name
     * @param email email address (used as login)
     * @param phone contact number
     * @param password login password
     */
    protected Person(String id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /** Returns the role identifier for this person type. */
    public abstract String getRole();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
