package com.women.health.controller;

import com.women.health.entity.Women;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/women")
public class DashboardController {

    @GetMapping("/dashboard")
    public String getAllProjectList(HttpSession session, Model model) {
        // Retrieve customer and product information from the session
        Women women = (Women) session.getAttribute("women");

        // Use the retrieved data in the dashboard view
        model.addAttribute("women", women);

        return "women-dashboard/women-dashboard";
    }

}
