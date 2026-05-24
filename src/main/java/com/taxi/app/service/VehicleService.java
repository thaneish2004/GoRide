package com.taxi.app.service;

import com.taxi.app.model.Vehicle;
import com.taxi.app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getByOwnerId(String ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }

    public boolean plateExists(String plate) {
        return vehicleRepository.findByPlateIgnoreCase(plate).isPresent();
    }

    public Vehicle add(Vehicle vehicle) {
        if (plateExists(vehicle.getPlate())) {
            throw new IllegalArgumentException("Vehicle with plate " + vehicle.getPlate() + " already exists");
        }
        vehicle.setId(UUID.randomUUID().toString());
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findById(String id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public boolean deleteById(String id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
