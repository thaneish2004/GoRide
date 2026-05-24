package com.taxi.app.config;

import com.taxi.app.service.AdminService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Seeds initial data into the database on application startup.
 * Creates the default admin account if it does not exist.
 */
@Component
public class SeedDataConfig implements CommandLineRunner {

    private final AdminService adminService;

    public SeedDataConfig(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) {
        adminService.seed("admin@taxi.com", "Admin", "admin123");
    }
}
