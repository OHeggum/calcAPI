package com.example.calcapi.service;

import com.example.calcapi.entity.CalculatorUser;
import com.example.calcapi.repository.CalculatorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcUserService {

    @Autowired
    private CalculatorUserRepository calcUserRepository;

    public String getPasswordByUsername(String username) {
        CalculatorUser calcUser = CalculatorUserRepository.findByName(username);
        if (calcUser != null) {
            return calcUser.getPassword();
        } else {
            // Handle case where user is not found
            return null;
        }
    }

    public CalculatorUser getUserByName(String username) {
        return CalculatorUserRepository.findByName(username);
    }

    public void createUser(String username, String password) {
        CalculatorUser newUser = new CalculatorUser();
        newUser.setName(username);
        newUser.setPassword(password);
        calcUserRepository.save(newUser);
    }
}
