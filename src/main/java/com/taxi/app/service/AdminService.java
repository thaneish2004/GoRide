package com.taxi.app.service;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.model.Admin;
import com.taxi.app.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Optional<Admin> login(LoginRequest req) {
        return adminRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
    }

    public boolean existsByEmail(String email) {
        return adminRepository.existsByEmail(email);
    }

    public Admin seed(String email, String name, String password) {
        if (adminRepository.existsByEmail(email)) {
            return adminRepository.findByEmailAndPassword(email, password).orElse(null);
        }
        Admin admin = new Admin(UUID.randomUUID().toString(), name, email, password);
        return adminRepository.save(admin);
    }
}
