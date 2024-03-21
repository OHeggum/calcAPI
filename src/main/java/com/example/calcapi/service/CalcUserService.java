package com.example.calcapi.service;

import com.example.calcapi.entity.CalculatorUser;
import com.example.calcapi.repository.CalculatorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcUserService {

    @Autowired
    private CalculatorUserRepository calcUserRepository;

    public void createUser(String username, String password) {
        CalculatorUser newUser = new CalculatorUser();
        newUser.setName(username);
        newUser.setPassword(password);
        calcUserRepository.save(newUser);
    }
}
