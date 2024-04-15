package com.women.health.controller;

import com.women.health.entity.Women;
import com.women.health.service.SignInService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SignInController {

    @Autowired
    private SignInService signInService;

    @GetMapping("/signin")
    public String login(Model model) {

        model.addAttribute("women", new Women());

        return "signin/women-signin"; // Return the name of your login Thymeleaf template
    }

    @PostMapping("/signin")
    public String login(@ModelAttribute("women") Women women,HttpSession session, Model model) {
        // Check if the provided credentials are valid
        if (signInService.isValidUser(women.getEmail(), women.getPassword()) != null ) {

            Women women1 = signInService.isValidUser(women.getEmail(), women.getPassword());

            // Redirect to women-dashboard on successful login
            System.out.println("Successfully Signed In...email : "+women.getEmail());

            session.setAttribute("women", women1);

            return "redirect:/women/dashboard";

        } else {
            // Add an error message and return to the login page on failed login
            model.addAttribute("error", "Invalid email or password");
            return "signin/women-signin";
        }
    }
}
