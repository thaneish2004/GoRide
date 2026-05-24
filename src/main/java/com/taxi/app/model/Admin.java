package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a system administrator with full access to
 * manage users, drivers, bookings, and vehicles.
 * Standalone entity (not extending Person) with its own table.
 */
@Entity
@Table(name = "admins")
public class Admin {

    /** Unique identifier (UUID string). */
    @Id
    private String id;

    private String name;
    private String email;
    private String password;

    /** Required by JPA. */
    public Admin() {}

    /**
     * Constructs an Admin with the given credentials.
     * @param id       unique identifier
     * @param name     display name
     * @param email    login email
     * @param password login password
     */
    public Admin(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return "ADMIN"; }
}
