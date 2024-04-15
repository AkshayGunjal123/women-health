package com.women.health.controller;

import com.women.health.entity.Symptoms;
import com.women.health.entity.Women;
import com.women.health.service.SymptomsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SymptomsController {


    @Autowired
    private SymptomsService symptomService;
    @GetMapping("/symptoms")
    public String showSymptomForm(Model model) {
        model.addAttribute("symptoms", new Symptoms());
        return "women-dashboard/women-symptoms";
    }

    @PostMapping("/symptoms")
    public String storeSymptoms(@RequestParam("symptoms") List<String> symptomsList, HttpSession session,Model model) {

        Women women = (Women) session.getAttribute("women");

        System.out.println("women : "+women);
        System.out.println("women email : "+women.getEmail());

        // Concatenate all symptoms into a single string
        String allSymptoms = String.join(", ", symptomsList);

        // Create a Symptoms object with the concatenated symptoms string
        Symptoms symptoms = new Symptoms();
        symptoms.setEmail(women.getEmail());
        symptoms.setAllSymptoms(allSymptoms);


        symptomService.saveSymptom(symptoms);

        model.addAttribute("women", women);

        // trackerService.updateLastSelectedDate(tracker.getEmail(), LocalDate.now());
        return "women-dashboard/women-dashboard";
    }

    @GetMapping("/viewSymptoms")
    public String viewSymptoms(HttpSession session, Model model) {


        Women women = (Women) session.getAttribute("women");

        System.out.println("women email : "+women.getEmail());

        List<Symptoms> symptomsList = symptomService.getAllSymptomsByEmail(women.getEmail());

        Symptoms symptomsData = symptomsList.get(0);

        model.addAttribute("symptomsData", symptomsData);

        return "women-dashboard/view-symptoms"; // This is the name of your HTML template
    }

}
