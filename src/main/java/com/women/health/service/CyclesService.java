package com.women.health.service;

import com.women.health.entity.Cycles;
import com.women.health.repository.CyclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CyclesService {

    @Autowired
    private CyclesRepository cyclesRepository;

    public void saveCycles(List<Cycles> cycles) {
        for (Cycles cycle : cycles) {
            cyclesRepository.save(cycle);
        }
    }

    public List<Cycles> getAllCyclesByEmail(String email) {
        // Fetch all tracker records for the given email from the database
        return cyclesRepository.findByEmail(email);
    }
}
