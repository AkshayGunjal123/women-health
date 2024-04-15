package com.women.health.controller;

import com.women.health.entity.Women;
import com.women.health.repository.WomenRepository;
import com.women.health.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Level;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/register")
    public String signup(Model model) {
        model.addAttribute("women", new Women());
        return "signup/women-signup";
    }


    @PostMapping("/registerWomen")
    public String customerSignUp(@ModelAttribute("women") Women women) {
        signUpService.womenSignUp(women);
        return "signin/women-signin";
    }



}
