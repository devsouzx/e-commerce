package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.model.user.dto.UserRequestDTO;
import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserRequestDTO body) {
        User user = new User();
        if (userService.findByEmail(body.email()) != null) {
            user = userService.findByEmail(body.email());
        } else {
            user.setName(body.name());
            user.setEmail(body.email());
            user.setPhone(body.phone());
            user.setPassword(body.password());
            userService.saveUser(user);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
