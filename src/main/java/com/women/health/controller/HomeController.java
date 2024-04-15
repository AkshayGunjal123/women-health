package com.women.health.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String getAllProjectProjectionList() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidating the session
        session.invalidate();
        return "index";
    }
}
