package com.fileUploadApplication.demo.service;

import com.fileUploadApplication.demo.model.User;
import com.fileUploadApplication.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(String governmentId, String username, String password) {
        User user = new User();
        user.setGovernmentId(governmentId);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    // Validate user login
    public Optional<User> validateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user;
        }
        return Optional.empty();
    }
}
