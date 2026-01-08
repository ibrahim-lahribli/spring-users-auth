package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // ← all endpoints in this controller will start with /api
public class HelloController {

    @GetMapping("/hello") // ← handles GET requests to /api/hello
    public String sayHello() {
        return "Hello from Spring Boot! 🌱";
    }
}
