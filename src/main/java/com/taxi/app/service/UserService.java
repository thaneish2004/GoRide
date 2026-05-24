package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.dto.UserView;
import com.taxi.app.model.Passenger;
import com.taxi.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for Passenger user operations.
 * Handles authentication, registration, search, and CRUD.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** Authenticate passenger via email/password. */
    public Optional<Passenger> login(LoginRequest req) {
        return userRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    /** Convert Passenger entity to a lightweight session view. */
    public UserView toView(Passenger p) {
        return new UserView(p.getId(), p.getName(), p.getEmail(), p.getPhone(),
                p.getRole(), p.getPassengerType(), p.getCardNumber(), p.getCardExpiry());
    }

    /** Search passengers by name, email, or phone (partial match). */
    public List<UserView> search(String query) {
        String q = query.toLowerCase();
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(q, q, q)
                .stream()
                .map(this::toView)
                .toList();
    }

    /** Check if email is already registered (case-insensitive). */
    public boolean emailExists(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    /** Register new passenger with generated UUID. */
    public Passenger register(Passenger passenger) {
        passenger.setId(UUID.randomUUID().toString());
        return userRepository.save(passenger);
    }

    /** Retrieve all passengers. */
    public List<Passenger> findAll() {
        return userRepository.findAll();
    }

    /** Find passenger by ID. */
    public Optional<Passenger> findById(String id) {
        return userRepository.findById(id);
    }

    /** Update existing passenger record. */
    public Passenger update(Passenger passenger) {
        return userRepository.save(passenger);
    }

    /** Delete passenger by ID. Returns true if deleted. */
    public boolean deleteById(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
