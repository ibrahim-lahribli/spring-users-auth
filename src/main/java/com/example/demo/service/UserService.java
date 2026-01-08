package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

// Services handle business logic (e.g., validation, exceptions)
@Service
public class UserService {

    // injecting UserRepository to interact with the database
    @Autowired private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        // Business logic can be added here before saving

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // By using Optional, the caller is forced to handle the case where no user exists, preventing
    // accidental null dereferences
    // UserRepository.findById(id) returns Optional<User>, so the service method naturally
    // propagates this type.
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
