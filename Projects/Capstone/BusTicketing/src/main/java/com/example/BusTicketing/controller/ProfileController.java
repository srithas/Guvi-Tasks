package com.example.BusTicketing.controller;

import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.repository.PassengerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    private PassengerRepository passengerRepository;

    // Show profile page
    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        if (passenger == null) {
            return "redirect:/login"; // Redirect to login if not logged in
        }

        model.addAttribute("passenger", passenger);
        return "profile"; // Load profile.html
    }

    // Load the edit profile page
    @GetMapping("/edit/{id}")
    public String editProfile(@PathVariable Long id, Model model) {
        Passenger passenger = passengerRepository.findById(id).orElse(null);
        if (passenger == null) {
            return "redirect:/dashboard"; // Redirect if passenger not found
        }

        model.addAttribute("passenger", passenger);
        return "edit-profile"; // Load edit-profile.html
    }

    // Handle form submission and update passenger data
    @PostMapping("/update/{id}")
    public String updateProfile(@PathVariable Long id, @ModelAttribute Passenger passenger, HttpSession session) {
        Passenger existingPassenger = passengerRepository.findById(id).orElse(null);
        if (existingPassenger != null) {
            existingPassenger.setFirstname(passenger.getFirstname());
            existingPassenger.setLastname(passenger.getLastname());
            existingPassenger.setEmail(passenger.getEmail());
            existingPassenger.setPassword(passenger.getPassword());
            passengerRepository.save(existingPassenger);

            // Update session with new details
            session.setAttribute("passenger", existingPassenger);
        }

        return "redirect:/profile"; // Redirect back to profile page
    }
}
