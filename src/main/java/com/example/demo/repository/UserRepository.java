package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

//Repositories handle database operations 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
// JpaRepository provides built-in CRUD: save(), findById(), findAll(), deleteById(), etc.
    // Add custom queries if needed later, e.g., findByEmail(String email);

}
