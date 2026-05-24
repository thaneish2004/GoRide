package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.dto.UserView;
import com.taxi.app.model.Passenger;
import com.taxi.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Passenger> login(LoginRequest req) {
        return userRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    public UserView toView(Passenger p) {
        return new UserView(p.getId(), p.getName(), p.getEmail(), p.getPhone(),
                p.getRole(), p.getPassengerType(), p.getCardNumber(), p.getCardExpiry());
    }

    public List<UserView> search(String query) {
        String q = query.toLowerCase();
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(q, q, q)
                .stream()
                .map(this::toView)
                .toList();
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    public Passenger register(Passenger passenger) {
        passenger.setId(UUID.randomUUID().toString());
        return userRepository.save(passenger);
    }

    public List<Passenger> findAll() {
        return userRepository.findAll();
    }

    public Optional<Passenger> findById(String id) {
        return userRepository.findById(id);
    }

    public Passenger update(Passenger passenger) {
        return userRepository.save(passenger);
    }

    public boolean deleteById(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
