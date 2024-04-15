package com.women.health.service;

import com.women.health.entity.Women;
import com.women.health.repository.WomenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {

    @Autowired
    private WomenRepository womenRepository;

    public Women isValidUser(String email, String password) {
        // Fetch women data from the database based on email
        Women women = womenRepository.findByEmail(email);

        // Check if women exists and the provided password matches
         if (women != null && women.getPassword().equals(password)){
             return women;
         }
         return null;
    }
}
