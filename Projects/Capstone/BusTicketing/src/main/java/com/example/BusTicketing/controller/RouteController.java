package com.example.BusTicketing.controller;

import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.domain.Route;
import com.example.BusTicketing.domain.Booking;
import com.example.BusTicketing.repository.PassengerRepository;
import com.example.BusTicketing.repository.RouteRepository;
import com.example.BusTicketing.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Display all routes
    @GetMapping("/routes")
    public String viewRoutes(Model model) {
        List<Route> routes = routeRepository.findAll();
        model.addAttribute("routes", routes);
        return "routes"; // This should be the name of your routes.html
    }

    // Handle booking route button click and display booking form
    @PostMapping("/book-route/{routeId}")
    public String bookRoute(@PathVariable Long routeId, @SessionAttribute("passenger") Passenger passenger, Model model) {
        // Retrieve the route based on the routeId
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("Route not found"));

        // Add the route and passenger details to the model and show the booking form
        model.addAttribute("route", route);
        model.addAttribute("passenger", passenger);

        // Redirect to the booking details form page
        return "booking-form"; // This should be the name of your booking form page (booking-form.html)
    }

    // Handle the submission of the booking form
    @PostMapping("/submit-booking")
    public String submitBooking(Long routeId, Long passengerId, String seatPreference, String paymentMethod,
                                String cardNumber, String expiryDate, String cvv, Model model) {
        // Retrieve the route and passenger from the database
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("Route not found"));
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() -> new RuntimeException("Passenger not found"));

        // Create a new booking
        Booking booking = new Booking();
        booking.setRoute(route);
        booking.setPassenger(passenger);
        booking.setSeatPreference(seatPreference);
        booking.setPaymentMethod(paymentMethod);
        booking.setCardNumber(cardNumber);
        booking.setExpiryDate(expiryDate);
        booking.setCvv(cvv);

        // Save the booking to the database
        bookingRepository.save(booking);

        // Add a success message to the model
        model.addAttribute("successMessage", "Booking successfully completed!");

        // Redirect to a success page or back to the routes page (adjust based on your flow)
        return "booking-success"; // This can be a page that shows the booking success message
    }

    // Optionally, add a method to view a specific booking
    @GetMapping("/view-booking/{bookingId}")
    public String viewBooking(@PathVariable Long bookingId, Model model) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        model.addAttribute("booking", booking);
        return "booking-details"; // This should be the name of your booking details page
    }
    @GetMapping("/bookings-history")
    public String viewBookingsHistory(HttpSession session, Model model) {
        // Get the logged-in passenger from the session
        Passenger passenger = (Passenger) session.getAttribute("passenger");

        if (passenger != null) {
            // Fetch all bookings for the logged-in passenger
            List<Booking> bookings = bookingRepository.findByPassenger(passenger);
            model.addAttribute("bookings", bookings);
        } else {
            model.addAttribute("error", "You need to log in first!");
            return "redirect:/login"; // Redirect to login if the user is not logged in
        }

        return "bookings-history"; // Name of the Thymeleaf template to display bookings history
    }
    @GetMapping("/tickets")
    public String viewTickets(HttpSession session, Model model) {
        // Get the logged-in passenger from the session
        Passenger passenger = (Passenger) session.getAttribute("passenger");

        if (passenger != null) {
            // Fetch all bookings for the logged-in passenger
            List<Booking> bookings = bookingRepository.findByPassenger(passenger);
            model.addAttribute("bookings", bookings);
        } else {
            model.addAttribute("error", "You need to log in first!");
            return "redirect:/login"; // Redirect to login if the user is not logged in
        }

        return "tickets"; // Name of the Thymeleaf template to display bookings history
    }

}

//package com.example.BusTicketing.controller;
//
//import com.example.BusTicketing.domain.Booking;
//import com.example.BusTicketing.domain.Passenger;
//import com.example.BusTicketing.domain.Route;
//import com.example.BusTicketing.repository.BookingRepository;
//import com.example.BusTicketing.repository.RouteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class RouteController {
//
//    @Autowired
//    private RouteRepository routeRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @PostMapping("/book-route/{routeId}")
//    public String bookRoute(@PathVariable Long routeId,
//                            @RequestParam String firstname,
//                            @RequestParam String lastname,
//                            @RequestParam String email,
//                            @RequestParam String seatPreferences,
//                            @RequestParam String paymentInfo,
//                            Model model,
//                            HttpSession session) {
//
//        // Find the route based on routeId
//        Route route = routeRepository.findById(routeId).orElseThrow();
//
//        // Get the logged-in passenger (assuming the passenger is stored in the session)
//        Passenger passenger = (Passenger) session.getAttribute("passenger");
//
//        // Create and save a new booking
//        Booking booking = new Booking(passenger, route, firstname, lastname, email, seatPreferences, paymentInfo);
//        bookingRepository.save(booking);
//
//        // Add success message to the model
//        model.addAttribute("successMessage", "Booking successful!");
//
//        // Return to a view that shows success (can also be a redirect to dashboard)
//        return "booking-success";
//    }
//}
//
