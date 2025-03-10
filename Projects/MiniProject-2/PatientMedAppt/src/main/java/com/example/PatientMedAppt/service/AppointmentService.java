package com.example.PatientMedAppt.service;

import com.example.PatientMedAppt.domain.Appointment;
import com.example.PatientMedAppt.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    // Fetch all booked appointments
    public List<Appointment> getUpcomingAppointments() {
        return appointmentRepository.findUpcomingAppointments();
    }

    // Save a new appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Find an appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // Cancel an appointment
    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
