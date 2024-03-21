package com.example.calcapi.controller;

import com.example.calcapi.entity.CalculatorUser;
import com.example.calcapi.repository.CalculatorUserRepository;
import com.example.calcapi.request.LoginRequest;
import com.example.calcapi.service.CalcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CalculatorUserRepository userRepository;

    @PostMapping("/loginOrRegister")
    public ResponseEntity<Integer> loginOrRegister(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getName();
        String password = loginRequest.getPassword();

        int userID;

        // Check if the provided username exists
        CalculatorUser user = userRepository.findByName(username);
        if (user == null) {
            // If the user doesn't exist, create a new user
            CalculatorUser newUser = new CalculatorUser();
            newUser.setName(username);
            newUser.setPassword(password);
            userRepository.save(newUser);
            userID = userRepository.findIdByNameAndPassword(username, password);
            return ResponseEntity.ok(userID);
        } else {
            // If the user exists, check if the password matches
            if (user.getPassword().equals(password)) {
                userID = userRepository.findIdByNameAndPassword(username, password);
                return ResponseEntity.ok(userID);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(999);
            }
        }
    }
}
