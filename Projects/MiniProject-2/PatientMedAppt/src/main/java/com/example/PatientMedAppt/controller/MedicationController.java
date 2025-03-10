package com.example.PatientMedAppt.controller;

import com.example.PatientMedAppt.domain.Medication;
import com.example.PatientMedAppt.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MedicationController {

    @Autowired
    private MedicationRepository medicationRepository;

    // View medications list
    @GetMapping("/medications")
    public String viewMedications(Model model) {
        model.addAttribute("medications", medicationRepository.findAll());
        return "medications"; // Thymeleaf template for displaying medications
    }

    // Add new medication
    @PostMapping("/addMedication")
    public String addMedication(@RequestParam("name") String name,
                                @RequestParam("dosage") String dosage,
                                @RequestParam("instructions") String instructions) {
        Medication medication = new Medication(name, dosage, instructions);
        medication.setStatus("Requested Change");  // Set status to "Requested Change" when added
        medicationRepository.save(medication);
        return "redirect:/medications";
    }

    // Show edit form for a specific medication
    @GetMapping("/editMedication/{id}")
    public String editMedicationForm(@PathVariable("id") Long id, Model model) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid medication ID:" + id));
        model.addAttribute("medication", medication);
        return "editMedication";  // This should be the view with the form for editing the medication
    }

    // Handle the editing of a medication
    @PostMapping("/editMedication")
    public String editMedication(@RequestParam("id") Long id,
                                 @RequestParam("name") String name,
                                 @RequestParam("dosage") String dosage,
                                 @RequestParam("instructions") String instructions) {
        Medication medication = medicationRepository.findById(id).orElseThrow();
        medication.setName(name);
        medication.setDosage(dosage);
        medication.setInstructions(instructions);
        medication.setStatus("Requested Change");  // Set status to "Requested Change"
        medicationRepository.save(medication);
        return "redirect:/medications";
    }

    // Delete medication
    @GetMapping("/deleteMedication/{id}")
    public String deleteMedication(@PathVariable("id") Long id) {
        medicationRepository.deleteById(id);
        return "redirect:/medications";
    }
}
