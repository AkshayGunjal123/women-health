package com.women.health.repository;

import com.women.health.entity.Cycles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclesRepository extends JpaRepository<Cycles, Long> {


    List<Cycles> findByEmail(String email);


}