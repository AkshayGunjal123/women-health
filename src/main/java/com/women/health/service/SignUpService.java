package com.women.health.service;

import com.women.health.entity.Women;
import com.women.health.repository.WomenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private WomenRepository womenRepository;

    //private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignUpService(WomenRepository womenRepository) {
        this.womenRepository = womenRepository;
    }


    public boolean womenSignUp(Women women) {

       //  Encode the password before saving to the database
       // women.setPassword(passwordEncoder.encode(women.getPassword()));

        // Save the new women sign-up data and get the saved entity
        Women savedWoman = womenRepository.save(women);

        // Check if the savedWoman is not null, indicating successful storage
        return (savedWoman != null);

    }

//    public Women findWomenByEmail(String email) {
//        return womenRepository.findByEmail(email);
//    }


}
