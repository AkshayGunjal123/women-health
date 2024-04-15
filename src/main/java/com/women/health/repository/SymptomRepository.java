package com.women.health.repository;

import com.women.health.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptoms, Long> {

    public List<Symptoms> getSymptomsByEmail(String email);
}
