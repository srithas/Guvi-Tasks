package com.example.EmployeeManagement.controller;

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

import com.example.EmployeeManagement.domain.Employee;
import com.example.EmployeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> listemployee = service.listAll();
        model.addAttribute("listemployee", listemployee);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "new";
    }

    @GetMapping("/view/{id}")
    public String viewEmployeeDetails(@PathVariable(name = "id") int id, Model model) {
        Employee employee = service.get(id);  // Retrieve employee by ID
        if (employee != null) {
            model.addAttribute("employee", employee);  // Add employee to the model
            return "details";  // Redirect to a new HTML page to display details
        } else {
            // If employee not found, redirect to home page or show an error message
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Employee std = service.get(id);
        mav.addObject("employee", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteemployee(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}