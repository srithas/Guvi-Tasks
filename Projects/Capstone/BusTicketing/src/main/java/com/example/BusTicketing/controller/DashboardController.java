package com.example.BusTicketing.controller;

import com.example.BusTicketing.domain.Booking;
import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.domain.Route;
import com.example.BusTicketing.repository.BookingRepository;
import com.example.BusTicketing.repository.PassengerRepository;
import com.example.BusTicketing.repository.RouteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/dashboard")
    public String showDashboardPage(HttpSession session, Model model) {
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        if (passenger == null) {
            return "redirect:/login";
        }
        model.addAttribute("passenger", passenger);
        return "dashboard";
    }

    @PostMapping("/check-routes")
    public String checkRoutes(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              Model model,
                              HttpSession session) {

        model.addAttribute("routes", routeRepository.findByDepartureAndDestination(from, to));

        Passenger passenger = (Passenger) session.getAttribute("passenger");
        model.addAttribute("passenger", passenger);

        return "routes";
    }

    // Redirect to booking form
    @GetMapping("/book/{id}")
    public String showBookingForm(@PathVariable Long id, Model model, HttpSession session) {
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        Route route = routeRepository.findById(id).orElse(null);

        model.addAttribute("passenger", passenger);
        model.addAttribute("route", route);

        return "booking-form";
    }

    // Handle booking submission
    @PostMapping("/book")
    public String bookRoute(@RequestParam Long routeId,
                            @RequestParam String seatPreference,
                            @RequestParam String paymentMethod,
                            @RequestParam String cardNumber,
                            @RequestParam String expiryDate,
                            @RequestParam String cvv,
                            HttpSession session) {

        Passenger passenger = (Passenger) session.getAttribute("passenger");
        Route route = routeRepository.findById(routeId).orElse(null);

        if (passenger != null && route != null) {
            Booking booking = new Booking(passenger, route, seatPreference, paymentMethod, cardNumber, expiryDate, cvv);
            bookingRepository.save(booking);
        }

        return "redirect:/routes";
    }
}
