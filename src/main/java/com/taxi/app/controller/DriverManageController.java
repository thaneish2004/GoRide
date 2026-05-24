package com.taxi.app.controller;

import com.taxi.app.dto.UserView;
import com.taxi.app.model.Driver;
import com.taxi.app.service.DriverService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Admin controller for driver management (CRUD operations).
 */
@Controller
public class DriverManageController {

    private final DriverService driverService;

    public DriverManageController(DriverService driverService) {
        this.driverService = driverService;
    }

    /** List all drivers for admin management. */
    @GetMapping("/admin/drivers")
    public String listDrivers(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        List<Driver> drivers = driverService.findAll();
        model.addAttribute("drivers", drivers);
        return "admin-drivers";
    }

    /** Update driver details (name, phone, license, status). */
    @PostMapping("/admin/drivers/edit")
    public String editDriver(@ModelAttribute Driver driver, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        driverService.findById(driver.getId()).ifPresent(d -> {
            d.setStatus(driver.getStatus());
            d.setName(driver.getName());
            d.setPhone(driver.getPhone());
            d.setLicenseNumber(driver.getLicenseNumber());
            driverService.update(d);
        });
        return "redirect:/admin/drivers";
    }

    /** Delete a driver account. */
    @PostMapping("/admin/drivers/delete")
    public String deleteDriver(@RequestParam String id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        driverService.deleteById(id);
        return "redirect:/admin/drivers";
    }

    /** Create a new driver account from admin panel. */
    @PostMapping("/admin/drivers/create")
    public String createDriver(@ModelAttribute Driver driver, HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        driver.setId(UUID.randomUUID().toString());
        if (driver.getStatus() == null || driver.getStatus().isBlank()) {
            driver.setStatus("AVAILABLE");
        }
        driverService.update(driver);
        return "redirect:/admin/drivers";
    }

    /** Check if the logged-in user has ADMIN role. */
    private boolean isAdmin(HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        return user != null && "ADMIN".equals(user.getRole());
    }
}
