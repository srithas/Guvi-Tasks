package com.example.PatientMedAppt.repository;

import com.example.PatientMedAppt.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.isBooked = true ORDER BY a.dateTime ASC")
    List<Appointment> findUpcomingAppointments();
}
