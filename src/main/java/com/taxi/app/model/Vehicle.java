package com.taxi.app.model;

import jakarta.persistence.*;

/**
 * Represents a vehicle registered in the system.
 * Each vehicle belongs to either a Driver or a Company (ownerType field).
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {

    /** Unique identifier (UUID string). */
    @Id
    private String id;

    private String make;
    private String model;
    private Integer year;
    /** License plate number (unique). */
    private String plate;
    /** Vehicle category: SEDAN, SUV, VAN, or LUXURY. */
    private String type;
    /** ID of the owning driver or company. */
    private String ownerId;
    /** Owner type discriminator: DRIVER or COMPANY. */
    private String ownerType;
    /** Operational status: AVAILABLE, MAINTENANCE, OUT_OF_SERVICE. */
    private String status;
    /** Soft-delete flag. */
    private boolean active = true;

    /** Required by JPA. */
    public Vehicle() {}

    /**
     * Constructs a Vehicle with full details.
     * @param make      manufacturer
     * @param model     model name
     * @param year      manufacturing year
     * @param plate     license plate number
     * @param type      vehicle category
     * @param ownerId   owning entity ID
     * @param ownerType DRIVER or COMPANY
     * @param status    operational status
     */
    public Vehicle(String id, String make, String model, Integer year, String plate, String type,
                   String ownerId, String ownerType, String status) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.type = type;
        this.ownerId = ownerId;
        this.ownerType = ownerType;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public String getOwnerType() { return ownerType; }
    public void setOwnerType(String ownerType) { this.ownerType = ownerType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
