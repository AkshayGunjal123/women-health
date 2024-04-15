package com.women.health.service;

import com.women.health.entity.Symptoms;
import com.women.health.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsService {

    @Autowired
    private SymptomRepository symptomRepository;

    public List<Symptoms> getAllSymptomsByEmail(String email) {
        return symptomRepository.getSymptomsByEmail(email);
    }

    public void saveSymptom(Symptoms symptoms) {
        symptomRepository.save(symptoms);
    }

}
