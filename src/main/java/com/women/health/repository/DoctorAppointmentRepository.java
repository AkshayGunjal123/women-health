package com.women.health.repository;

import com.women.health.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long> {

    public DoctorAppointment getAppointmentByWomenEmail(String email);
}