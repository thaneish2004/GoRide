package com.taxi.app.controller;

import com.taxi.app.dto.UserView;
import com.taxi.app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserProfileController {

    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        userService.findById(user.getId()).ifPresent(p ->
                model.addAttribute("profile", userService.toView(p)));
        return "profile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute UserView form, HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        userService.findById(user.getId()).ifPresent(p -> {
            p.setName(form.getName());
            p.setPhone(form.getPhone());
            p.setPassengerType(form.getPassengerType());
            p.setCardNumber(form.getCardNumber());
            p.setCardExpiry(form.getCardExpiry());
            userService.update(p);
        });
        model.addAttribute("message", "Profile updated");
        return "redirect:/profile";
    }

    @GetMapping("/payment")
    public String payment(HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        userService.findById(user.getId()).ifPresent(p ->
                model.addAttribute("profile", userService.toView(p)));
        return "payment";
    }

    @PostMapping("/payment")
    public String updatePayment(@RequestParam String cardNumber, @RequestParam String cardExpiry,
                                HttpSession session, Model model) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        userService.findById(user.getId()).ifPresent(p -> {
            p.setCardNumber(cardNumber);
            p.setCardExpiry(cardExpiry);
            userService.update(p);
        });
        model.addAttribute("message", "Payment info updated");
        return "redirect:/profile";
    }

    @GetMapping("/admin/users")
    public String listUsers(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        List<UserView> users = userService.findAll().stream()
                .map(userService::toView)
                .toList();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @GetMapping("/admin/users/search")
    public String searchUsers(@RequestParam String q, HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        model.addAttribute("users", userService.search(q));
        return "admin-users";
    }

    @PostMapping("/admin/users/delete")
    public String deleteUser(@RequestParam String id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

    private boolean isAdmin(HttpSession session) {
        UserView user = (UserView) session.getAttribute("loggedInUser");
        return user != null && "ADMIN".equals(user.getRole());
    }
}
