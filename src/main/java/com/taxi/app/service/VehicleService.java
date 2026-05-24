package com.taxi.app.service;

import com.taxi.app.model.Vehicle;
import com.taxi.app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for Vehicle operations.
 * Handles registration with plate uniqueness validation and CRUD.
 */
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /** Retrieve vehicles owned by a specific driver or company. */
    public List<Vehicle> getByOwnerId(String ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    /** Check whether a license plate is already registered. */
    public boolean plateExists(String plate) {
        return vehicleRepository.findByPlateIgnoreCase(plate).isPresent();
    }

    /** Register new vehicle after validating plate uniqueness. */
    public Vehicle add(Vehicle vehicle) {
        if (plateExists(vehicle.getPlate())) {
            throw new IllegalArgumentException("Vehicle with plate " + vehicle.getPlate() + " already exists");
        }
        vehicle.setId(UUID.randomUUID().toString());
        return vehicleRepository.save(vehicle);
    }

    /** Retrieve all vehicles. */
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    /** Find vehicle by ID. */
    public Optional<Vehicle> findById(String id) {
        return vehicleRepository.findById(id);
    }

    /** Update existing vehicle record. */
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /** Delete vehicle by ID. Returns true if deleted. */
    public boolean deleteById(String id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
