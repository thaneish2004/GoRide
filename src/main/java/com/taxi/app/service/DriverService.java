package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.model.Driver;
import com.taxi.app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Optional<Driver> login(LoginRequest req) {
        return driverRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    public List<Driver> getAvailable() {
        return driverRepository.findByStatusIgnoreCase("AVAILABLE");
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Optional<Driver> findById(String id) {
        return driverRepository.findById(id);
    }

    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    public boolean deleteById(String id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
