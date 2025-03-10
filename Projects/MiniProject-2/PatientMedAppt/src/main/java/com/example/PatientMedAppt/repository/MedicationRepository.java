package com.example.PatientMedAppt.repository;

import com.example.PatientMedAppt.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
