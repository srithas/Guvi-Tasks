package com.example.BusTicketing.controller;

import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session, // Add HttpSession to store user
                        Model model) {

        Passenger passenger = passengerRepository.findByEmail(email);
        if (passenger != null && passenger.getPassword().equals(password)) {
            session.setAttribute("passenger", passenger); // Store the passenger in session
            return "redirect:/dashboard"; // Redirect to dashboard after successful login
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}


