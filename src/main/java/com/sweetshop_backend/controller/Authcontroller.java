package com.sweetshop_backend.controller;

import com.sweetshop_backend.model.User;
import com.sweetshop_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="https://localhost:3000")
public class Authcontroller {
    @Autowired
    private final AuthService service;

    public Authcontroller(AuthService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public String register(@RequestBody User user){
        service.register((user));
        return "user registered successfully";
    }
    @PostMapping("/Login")
    public String login(@RequestBody User user){
        return service.login(user.getUsername(), user.getPassword());
    }
}
