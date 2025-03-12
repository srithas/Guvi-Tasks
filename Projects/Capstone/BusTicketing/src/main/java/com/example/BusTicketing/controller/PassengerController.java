package com.example.BusTicketing.controller;

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

import com.example.BusTicketing.domain.Passenger;
import com.example.BusTicketing.service.PassengerService;

@Controller
public class PassengerController {

    @Autowired
    private PassengerService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Passenger> listpassenger = service.listAll();
        model.addAttribute("listpassenger", listpassenger);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePassenger(@ModelAttribute("passenger") Passenger std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPassengerPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Passenger std = service.get(id);
        mav.addObject("passenger", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletepassenger(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}