package com.fileUploadApplication.demo.controller;


import com.fileUploadApplication.demo.model.User;
import com.fileUploadApplication.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // User registration endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user.getGovernmentId(), user.getUsername(), user.getPassword());
        return ResponseEntity.ok(savedUser);
    }

    // User login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> validUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (validUser.isPresent()) {
            return ResponseEntity.ok(validUser.get());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
