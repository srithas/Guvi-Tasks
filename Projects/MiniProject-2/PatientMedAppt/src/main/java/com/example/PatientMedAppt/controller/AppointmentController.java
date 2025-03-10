package com.example.PatientMedAppt.controller;

import com.example.PatientMedAppt.domain.Appointment;
import com.example.PatientMedAppt.domain.Patient;
import com.example.PatientMedAppt.repository.AppointmentRepository;
import com.example.PatientMedAppt.service.AppointmentService;
import com.example.PatientMedAppt.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;


    // Display all appointments
    @GetMapping("/appointments")
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments";
    }

    // Book an appointment
    @GetMapping("/appointments/book/{id}")
    public String bookAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setBooked(true);
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }


    @GetMapping("/appointments/upcoming")
    public String viewUpcomingAppointments(Model model) {
        List<Appointment> bookedAppointments = appointmentService.getUpcomingAppointments();
        model.addAttribute("appointments", bookedAppointments);
        return "index";
    }


}
