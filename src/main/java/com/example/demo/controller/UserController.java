package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



//Controllers expose REST endpoints

@RestController // marks this class as a REST controller
@RequestMapping("/api/users") // base URL for user-related endpoints
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    //@RequestBody : binds the HTTP request body to a transfer or domain object, enabling automatic deserialization of the incoming JSON into a Java object.
    //@Valid : performs validation on the transfer object based on the constraints defined in the User entity.
    //returns ResponseEntity to provide more control over HTTP response (status code, headers, body)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    

}
