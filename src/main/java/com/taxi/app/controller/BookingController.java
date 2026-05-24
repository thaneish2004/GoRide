package com.taxi.app.controller;

import com.taxi.app.dto.BookingRequest;
import com.taxi.app.dto.BookingView;
import com.taxi.app.dto.UserView;
import com.taxi.app.model.Booking;
import com.taxi.app.model.Driver;
import com.taxi.app.service.BookingService;
import com.taxi.app.service.DriverService;
import com.taxi.app.service.UserService;
import com.taxi.app.service.VehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final DriverService driverService;
    private final UserService userService;
    private final VehicleService vehicleService;

    public BookingController(BookingService bookingService, DriverService driverService,
                             UserService userService, VehicleService vehicleService) {
        this.bookingService = bookingService;
        this.driverService = driverService;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/book")
    public String bookingForm(Model model) {
        model.addAttribute("bookingRequest", new BookingRequest());
        return "booking";
    }

    @PostMapping("/book")
    public String createBooking(@ModelAttribute BookingRequest req, HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        Booking b = new Booking();
        b.setPassengerId(user.getId());
        b.setPickupLocation(req.getPickupLocation());
        b.setDropLocation(req.getDropLocation());
        b.setVehicleType(req.getVehicleType());
        b.setBookingType(req.getBookingType());
        b.setScheduledTime(req.getScheduledTime());
        b.setFare(0);
        b.setPaymentMethod(req.getPaymentMethod());

        bookingService.createBooking(b);
        model.addAttribute("message", "Booking created successfully. A driver will set the fare upon acceptance.");
        return "booking";
    }

    @GetMapping("/my-bookings")
    public String myBookings(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        List<Booking> bookings = bookingService.findByPassengerId(user.getId());
        List<BookingView> views = bookings.stream().map(b -> {
            String pName = userService.findById(b.getPassengerId()).map(p -> p.getName()).orElse("N/A");
            String dName = b.getDriverId() != null && !b.getDriverId().isBlank()
                    ? driverService.findById(b.getDriverId()).map(d -> d.getName()).orElse("N/A")
                    : "Unassigned";
            return new BookingView(b.getId(), pName, dName, b.getPickupLocation(),
                    b.getDropLocation(), b.getStatus(), b.getFare(),
                    b.getBookingType(), b.getVehicleType(), b.getPaymentMethod());
        }).collect(Collectors.toList());

        model.addAttribute("bookings", views);
        return "my-bookings";
    }

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam String id, HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        boolean ok = bookingService.cancelById(id);
        session.setAttribute("flash", ok ? "Booking cancelled." : "Booking not found.");
        return "redirect:/my-bookings";
    }

    @GetMapping("/check-availability")
    @ResponseBody
    public List<Driver> checkAvailability() {
        return driverService.getAvailable();
    }

    @GetMapping("/select-company")
    public String selectCompany() {
        return "redirect:/company/setup";
    }
}
