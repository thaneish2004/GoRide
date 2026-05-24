package com.taxi.app.controller;

import com.taxi.app.dto.BookingView;
import com.taxi.app.dto.UserView;
import com.taxi.app.model.Booking;
import com.taxi.app.service.BookingService;
import com.taxi.app.service.DriverService;
import com.taxi.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for driver dispatch tasks and admin booking management.
 * Drivers can view pending tasks, accept with fare, update status.
 */
@Controller
public class DispatchController {

    private final BookingService bookingService;
    private final DriverService driverService;
    private final UserService userService;

    public DispatchController(BookingService bookingService, DriverService driverService, UserService userService) {
        this.bookingService = bookingService;
        this.driverService = driverService;
        this.userService = userService;
    }

    /** Show available and assigned dispatch tasks for the current driver. */
    @GetMapping("/tasks")
    public String tasks(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null || !"DRIVER".equals(user.getRole())) return "redirect:/login";

        List<Booking> all = bookingService.findAll();
        List<Booking> driverTasks = all.stream()
                .filter(b -> "PENDING".equals(b.getStatus())
                        || (user.getId().equals(b.getDriverId())
                        && ("CONFIRMED".equals(b.getStatus())
                            || "IN_PROGRESS".equals(b.getStatus())
                            || "COMPLETED".equals(b.getStatus()))))
                .sorted((a, b1) -> {
                    if ("COMPLETED".equals(a.getStatus()) && !"COMPLETED".equals(b1.getStatus())) return 1;
                    if (!"COMPLETED".equals(a.getStatus()) && "COMPLETED".equals(b1.getStatus())) return -1;
                    return 0;
                })
                .collect(Collectors.toList());
        model.addAttribute("tasks", toViews(driverTasks));
        return "dispatch-tasks";
    }

    /**
     * Update the status of a dispatch task.
     * Accepting a task sets driver, fare, and marks as CONFIRMED.
     * Completing a task frees the driver back to AVAILABLE.
     */
    @PostMapping("/tasks/update")
    public String updateTask(@RequestParam String bookingId, @RequestParam String status,
                             @RequestParam(required = false) Double fare,
                             HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        bookingService.findById(bookingId).ifPresent(b -> {
            if ("PENDING".equals(b.getStatus()) && "CONFIRMED".equals(status)) {
                bookingService.assignDriver(bookingId, user.getId(), fare != null ? fare : 0);
            } else if (user.getId().equals(b.getDriverId())) {
                b.setStatus(status);
                if ("COMPLETED".equals(status)) {
                    driverService.findById(b.getDriverId()).ifPresent(d -> {
                        d.setStatus("AVAILABLE");
                        driverService.update(d);
                    });
                }
                bookingService.update(b);
            }
        });
        if ("COMPLETED".equals(status)) {
            session.setAttribute("flash", "Task completed successfully.");
        } else if ("CONFIRMED".equals(status)) {
            session.setAttribute("flash", "Task accepted.");
        }
        return "redirect:/tasks";
    }

    /** Admin: view all bookings in the system. */
    @GetMapping("/admin/bookings")
    public String adminBookings(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        List<BookingView> views = toViews(bookingService.findAll());
        model.addAttribute("bookings", views);
        return "admin-bookings";
    }

    /** Admin: cancel/delete a booking. */
    @PostMapping("/admin/bookings/delete")
    public String adminDeleteBooking(@RequestParam String id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        bookingService.cancelById(id);
        return "redirect:/admin/bookings";
    }

    /** Check if the logged-in user has ADMIN role. */
    private boolean isAdmin(HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        return user != null && "ADMIN".equals(user.getRole());
    }

    /** Convert Booking entities to display-friendly BookingView objects. */
    private List<BookingView> toViews(List<Booking> bookings) {
        return bookings.stream().map(b -> {
            String pName = userService.findById(b.getPassengerId()).map(p -> p.getName()).orElse("N/A");
            String dName = b.getDriverId() != null && !b.getDriverId().isBlank()
                    ? driverService.findById(b.getDriverId()).map(d -> d.getName()).orElse("N/A")
                    : "Unassigned";
            return new BookingView(b.getId(), pName, dName, b.getPickupLocation(),
                    b.getDropLocation(), b.getStatus(), b.getFare(),
                    b.getBookingType(), b.getVehicleType(), b.getPaymentMethod());
        }).collect(Collectors.toList());
    }
}
