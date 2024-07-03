package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.dto.UserRequestDTO;
import com.devsouzx.ecommerce.dto.UserResponseDTO;
import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserRequestDTO body) {
        User user = new User();
        if (userRepository.findByEmail(body.email()) != null) {
            user = userRepository.findByEmail(body.email());
        } else {
            user.setName(body.name());
            user.setEmail(body.email());
            user.setPassword(body.password());
            userRepository.save(user);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return ResponseEntity.ok(user);
    }
}
