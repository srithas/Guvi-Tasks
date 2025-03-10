package com.example.PatientMedAppt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PatientMedAppt.domain.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
