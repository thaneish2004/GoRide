package com.taxi.app.repository;

import com.taxi.app.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Passenger, String> {
    Optional<Passenger> findByEmailAndPassword(String email, String password);
    boolean existsByEmailIgnoreCase(String email);
    Optional<Passenger> findByEmail(String email);
    List<Passenger> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContaining(
            String name, String email, String phone);
}
