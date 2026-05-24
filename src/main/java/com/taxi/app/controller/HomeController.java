package com.taxi.app.controller;

import com.taxi.app.dto.UserView;
import com.taxi.app.model.Booking;
import com.taxi.app.service.BookingService;
import com.taxi.app.service.VehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BookingService bookingService;
    private final VehicleService vehicleService;

    public HomeController(BookingService bookingService, VehicleService vehicleService) {
        this.bookingService = bookingService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        if ("DRIVER".equals(user.getRole())) {
            List<Booking> all = bookingService.findAll();
            long pendingCount = all.stream().filter(b -> "PENDING".equals(b.getStatus())).count();
            long myTaskCount = all.stream().filter(b -> user.getId().equals(b.getDriverId())
                    && ("CONFIRMED".equals(b.getStatus()) || "IN_PROGRESS".equals(b.getStatus()))).count();
            long vehicleCount = vehicleService.getByOwnerId(user.getId()).size();
            model.addAttribute("pendingCount", pendingCount);
            model.addAttribute("myTaskCount", myTaskCount);
            model.addAttribute("vehicleCount", vehicleCount);
            return "home-driver";
        }

        return switch (user.getRole()) {
            case "ADMIN" -> "redirect:/admin/dashboard";
            case "COMPANY" -> "redirect:/company/setup";
            default -> "home-passenger";
        };
    }
}
