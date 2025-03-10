package com.example.PatientMedAppt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.PatientMedAppt.domain.Patient;
import com.example.PatientMedAppt.service.PatientService;

@Controller
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Patient> listpatient = service.listAll();
        model.addAttribute("listpatient", listpatient);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("patient", new Patient());
        return "new";
    }

    @GetMapping("/view/{id}")
    public String viewPatientDetails(@PathVariable(name = "id") int id, Model model) {
        Patient patient = service.get(id);  // Retrieve employee by ID
        if (patient != null) {
            model.addAttribute("patient", patient);  // Add employee to the model
            return "details";  // Redirect to a new HTML page to display details
        } else {
            // If employee not found, redirect to home page or show an error message
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute("patient") Patient std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPatientPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Patient std = service.get(id);
        mav.addObject("patient", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletepatient(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}