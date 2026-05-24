package com.taxi.app.controller;

import com.taxi.app.dto.UserView;
import com.taxi.app.repository.BookingRepository;
import com.taxi.app.repository.DriverRepository;
import com.taxi.app.repository.UserRepository;
import com.taxi.app.repository.VehicleRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Admin dashboard controller.
 * Displays aggregate system statistics from all repositories.
 */
@Controller
public class AdminController {

    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final BookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;

    public AdminController(UserRepository userRepository, DriverRepository driverRepository,
                           BookingRepository bookingRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.bookingRepository = bookingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /** Admin dashboard with counts for passengers, drivers, bookings, and vehicles. */
    @GetMapping("/admin/dashboard")
    public String dashboard(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null || !"ADMIN".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("admin", user);
        model.addAttribute("userCount", userRepository.count());
        model.addAttribute("driverCount", driverRepository.count());
        model.addAttribute("bookingCount", bookingRepository.count());
        model.addAttribute("vehicleCount", vehicleRepository.count());
        return "admin-dashboard";
    }
}
