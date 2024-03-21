package com.example.calcapi.controller;

import com.example.calcapi.entity.CalculatorUser;
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
    private CalcUserService userService;

    @PostMapping("/loginOrRegister")
    public ResponseEntity<String> loginOrRegister(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getName();
        String password = loginRequest.getPassword();

        // Check if the provided username exists
        CalculatorUser user = userService.getUserByName(username);
        if (user == null) {
            // If the user doesn't exist, create a new user
            userService.createUser(username, password);
            return ResponseEntity.ok("User registered successfully");
        } else {
            // If the user exists, check if the password matches
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed due to wrong password");
            }
        }
    }
}
