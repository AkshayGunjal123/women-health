package com.women.health.controller;

import com.women.health.entity.DoctorAppointment;
import com.women.health.entity.Women;
import com.women.health.service.DoctorAppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    //appointment
    @Autowired
    private DoctorAppointmentService doctorAppointmentService;

    @GetMapping("/appointment")
    public String doctorAppointment(HttpSession session, Model model) {

        Women women = (Women) session.getAttribute("women");

        DoctorAppointment doctorAppointment = new DoctorAppointment();

        doctorAppointment.setWomenName(women.getEmail());
        doctorAppointment.setWomenName(women.getName());

        model.addAttribute("doctorAppointment", doctorAppointment);
        return "women-dashboard/doctor-appointment";

    }

    @PostMapping("/appointment")
    public String submitAppointmentForm(@ModelAttribute DoctorAppointment appointment,HttpSession session,Model model) {

        Women women = (Women) session.getAttribute("women");

        appointment.setWomenName(women.getEmail());
        appointment.setWomenName(women.getName());

        doctorAppointmentService.saveAppointment(appointment);

        model.addAttribute("women", women);
        return "women-dashboard/women-dashboard";
    }

    @GetMapping("/appointments")
    public String getAppointments(HttpSession session, Model model) {

        Women women = (Women) session.getAttribute("women");

        DoctorAppointment appointment = doctorAppointmentService.getAppointment(women.getEmail());

        model.addAttribute("appointments", appointment);

        return "women-dashboard/appointment-record"; // This is the name of your HTML template
    }
}

