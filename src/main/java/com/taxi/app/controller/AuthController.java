package com.taxi.app.controller;

import com.taxi.app.dto.LoginRequest;
import com.taxi.app.dto.RegisterRequest;
import com.taxi.app.dto.UserView;
import com.taxi.app.model.Driver;
import com.taxi.app.model.Passenger;
import com.taxi.app.service.AdminService;
import com.taxi.app.service.CompanyService;
import com.taxi.app.service.DriverService;
import com.taxi.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for authentication: login, registration, and logout.
 * Routes users to role-specific home pages on successful login.
 */
@Controller
public class AuthController {

    private final UserService userService;
    private final DriverService driverService;
    private final CompanyService companyService;
    private final AdminService adminService;

    public AuthController(UserService userService, DriverService driverService,
                          CompanyService companyService, AdminService adminService) {
        this.userService = userService;
        this.driverService = driverService;
        this.companyService = companyService;
        this.adminService = adminService;
    }

    /** Show the login form. */
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    /**
     * Process login. Authenticates against the correct service based on userType.
     * Admin -> /admin/dashboard, others -> /home for role dispatch.
     */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest req, HttpSession session, Model model) {
        String type = req.getUserType();

        if ("ADMIN".equals(type)) {
            var adminOpt = adminService.login(req);
            if (adminOpt.isPresent()) {
                var a = adminOpt.get();
                UserView uv = new UserView(a.getId(), a.getName(), a.getEmail(), null, "ADMIN", null, null, null);
                session.setAttribute("loggedInUser", uv);
                return "redirect:/admin/dashboard";
            }
            model.addAttribute("error", "Invalid admin credentials");
            return "login";
        }

        if ("DRIVER".equals(type)) {
            var driverOpt = driverService.login(req);
            if (driverOpt.isPresent()) {
                Driver d = driverOpt.get();
                UserView uv = new UserView(d.getId(), d.getName(), d.getEmail(), d.getPhone(),
                        d.getRole(), null, null, null);
                session.setAttribute("loggedInUser", uv);
                return "redirect:/home";
            }
            model.addAttribute("error", "Invalid driver credentials");
            return "login";
        }

        if ("COMPANY".equals(type)) {
            var companyOpt = companyService.login(req);
            if (companyOpt.isPresent()) {
                var c = companyOpt.get();
                UserView uv = new UserView(c.getId(), c.getName(), c.getEmail(), c.getPhone(),
                        c.getRole(), null, null, null);
                session.setAttribute("loggedInUser", uv);
                return "redirect:/home";
            }
            model.addAttribute("error", "Invalid company credentials");
            return "login";
        }

        var userOpt = userService.login(req);
        if (userOpt.isPresent()) {
            session.setAttribute("loggedInUser", userService.toView(userOpt.get()));
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    /** Show the registration form. */
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    /** Register a new passenger or driver account. */
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest req, Model model) {
        if (userService.emailExists(req.getEmail())) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }
        if ("DRIVER".equals(req.getUserType())) {
            Driver d = new Driver();
            d.setName(req.getName());
            d.setEmail(req.getEmail());
            d.setPhone(req.getPhone());
            d.setPassword(req.getPassword());
            d.setLicenseNumber("TBD");
            d.setStatus("AVAILABLE");
            d.setId(java.util.UUID.randomUUID().toString());
            driverService.update(d);
            return "redirect:/login";
        }
        Passenger p = new Passenger();
        p.setName(req.getName());
        p.setEmail(req.getEmail());
        p.setPhone(req.getPhone());
        p.setPassword(req.getPassword());
        p.setPassengerType("REGULAR");
        userService.register(p);
        return "redirect:/login";
    }

    /** Logout: invalidate session and return to landing page. */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
