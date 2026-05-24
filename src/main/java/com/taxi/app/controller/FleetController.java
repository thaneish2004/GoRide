package com.taxi.app.controller;

import com.taxi.app.dto.UserView;
import com.taxi.app.model.Company;
import com.taxi.app.model.Vehicle;
import com.taxi.app.service.CompanyService;
import com.taxi.app.service.DriverService;
import com.taxi.app.service.UserService;
import com.taxi.app.service.VehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FleetController {

    private final CompanyService companyService;
    private final VehicleService vehicleService;
    private final DriverService driverService;
    private final UserService userService;

    public FleetController(CompanyService companyService, VehicleService vehicleService,
                           DriverService driverService, UserService userService) {
        this.companyService = companyService;
        this.vehicleService = vehicleService;
        this.driverService = driverService;
        this.userService = userService;
    }

    @GetMapping("/company/setup")
    public String companySetupForm(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        model.addAttribute("company", new Company());
        return "company-setup";
    }

    @PostMapping("/company/setup")
    public String companySetup(@ModelAttribute Company company, HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        company.setId(user.getId());
        company.setEmail(user.getEmail());
        company.setPassword("");
        companyService.save(company);
        model.addAttribute("message", "Company setup complete");
        return "company-setup";
    }

    @GetMapping("/fleet")
    public String fleet(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        List<Vehicle> vehicles = vehicleService.getByOwnerId(user.getId());
        model.addAttribute("vehicles", vehicles);
        return "fleet";
    }

    @GetMapping("/vehicle/add")
    public String addVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle-add";
    }

    @PostMapping("/vehicle/add")
    public String addVehicle(@RequestParam String make, @RequestParam("model") String carModel,
                             @RequestParam Integer year, @RequestParam String plateNumber,
                             @RequestParam String type, HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(make);
        vehicle.setModel(carModel);
        vehicle.setYear(year);
        vehicle.setPlate(plateNumber);
        vehicle.setType(type);
        vehicle.setOwnerId(user.getId());
        vehicle.setOwnerType(user.getRole());
        vehicle.setStatus("ACTIVE");
        try {
            vehicleService.add(vehicle);
            model.addAttribute("message", "Vehicle added");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "vehicle-add";
        }
        return "redirect:/fleet";
    }

    @PostMapping("/vehicle/update")
    public String updateVehicle(@RequestParam String id, @RequestParam String status,
                                HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        vehicleService.findById(id).ifPresent(v -> {
            v.setStatus(status);
            vehicleService.update(v);
        });
        return "redirect:/fleet";
    }

    @PostMapping("/vehicle/delete")
    public String deleteVehicle(@RequestParam String id, @RequestParam(defaultValue = "/fleet") String redirect,
                                HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        vehicleService.findById(id).ifPresent(v -> {
            if ("ADMIN".equals(user.getRole()) || v.getOwnerId().equals(user.getId())) {
                vehicleService.deleteById(id);
            }
        });
        return "redirect:" + redirect;
    }

    /* ── Admin fleet management ── */

    @GetMapping("/admin/vehicles")
    public String adminVehicles(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null || !"ADMIN".equals(user.getRole())) return "redirect:/login";
        List<Vehicle> vehicles = vehicleService.findAll();
        Map<String, String> ownerNames = new HashMap<>();
        for (Vehicle v : vehicles) {
            ownerNames.put(v.getOwnerId(), resolveOwnerName(v.getOwnerId(), v.getOwnerType()));
        }
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("ownerNames", ownerNames);
        model.addAttribute("drivers", driverService.findAll());
        model.addAttribute("companies", companyService.findAll());
        return "admin-vehicles";
    }

    @PostMapping("/admin/vehicles/add")
    public String adminAddVehicle(@RequestParam String make, @RequestParam("model") String carModel,
                                   @RequestParam Integer year, @RequestParam String plateNumber,
                                   @RequestParam String type, @RequestParam String ownerId,
                                   @RequestParam String ownerType, HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null || !"ADMIN".equals(user.getRole())) return "redirect:/login";
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(make);
        vehicle.setModel(carModel);
        vehicle.setYear(year);
        vehicle.setPlate(plateNumber);
        vehicle.setType(type);
        vehicle.setOwnerId(ownerId);
        vehicle.setOwnerType(ownerType);
        vehicle.setStatus("ACTIVE");
        try {
            vehicleService.add(vehicle);
            model.addAttribute("message", "Vehicle added for " + resolveOwnerName(ownerId, ownerType));
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/admin/vehicles";
    }

    private String resolveOwnerName(String id, String type) {
        if ("DRIVER".equals(type)) {
            return driverService.findById(id).map(d -> d.getName()).orElse(id);
        }
        if ("COMPANY".equals(type)) {
            return companyService.findById(id).map(c -> c.getName()).orElse(id);
        }
        return userService.findById(id).map(u -> u.getName()).orElse(id);
    }

    @PostMapping("/admin/vehicles/toggle")
    public String toggleVehicle(@RequestParam String id, HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null || !"ADMIN".equals(user.getRole())) return "redirect:/login";
        vehicleService.findById(id).ifPresent(v -> {
            v.setActive(!v.isActive());
            vehicleService.update(v);
        });
        return "redirect:/admin/vehicles";
    }
}
