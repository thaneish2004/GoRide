package com.taxi.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    private String id;

    private String make;
    private String model;
    private Integer year;
    private String plate;
    private String type;
    private String ownerId;
    private String ownerType;
    private String status;
    private boolean active = true;

    public Vehicle() {}

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
