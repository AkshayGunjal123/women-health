package com.women.health.service;

import com.women.health.entity.DoctorAppointment;
import com.women.health.entity.Symptoms;
import com.women.health.repository.DoctorAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorAppointmentService {

    @Autowired
    DoctorAppointmentRepository doctorAppointmentRepository;

    public void saveAppointment(DoctorAppointment appointment) {
        doctorAppointmentRepository.save(appointment);
    }

    public DoctorAppointment getAppointment(String email) {
        return doctorAppointmentRepository.getAppointmentByWomenEmail(email);
    }

}
