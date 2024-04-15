package com.women.health.controller;

import com.women.health.entity.Women;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WomenController {
    @GetMapping("/welcome")
    public String welcome() {
        return "home-content";
    }

    @GetMapping("/healthinfo")
    public String healthInfo() {
        return "healthinfo/women-healthinfo";
    }
}
