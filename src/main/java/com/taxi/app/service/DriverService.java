package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.model.Driver;
import com.taxi.app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Driver operations.
 * Handles authentication, availability queries, and CRUD.
 */
@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    /** Authenticate driver via email/password. */
    public Optional<Driver> login(LoginRequest req) {
        return driverRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    /** Retrieve drivers currently available for dispatch. */
    public List<Driver> getAvailable() {
        return driverRepository.findByStatusIgnoreCase("AVAILABLE");
    }

    /** Retrieve all drivers. */
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    /** Find driver by ID. */
    public Optional<Driver> findById(String id) {
        return driverRepository.findById(id);
    }

    /** Update existing driver record. */
    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    /** Delete driver by ID. Returns true if deleted. */
    public boolean deleteById(String id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
