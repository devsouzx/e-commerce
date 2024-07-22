package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.address.dto.DeleteUserRequestDTO;
import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.domain.user.dto.PasswordRequestDTO;
import com.devsouzx.ecommerce.domain.user.dto.UserRequestDTO;
import com.devsouzx.ecommerce.domain.user.dto.UserResponseDTO;
import com.devsouzx.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> users = userService.findAll().stream().map(UserResponseDTO::new).toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}/update-password")
    public ResponseEntity<?> updatePassword(@PathVariable UUID id, @RequestBody PasswordRequestDTO body) {
        User user = userService.findById(id);

        if (!passwordEncoder.matches(body.oldPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong Password");
        }

        user.setPassword(passwordEncoder.encode(body.newPassword()));
        userService.saveUser(user);

        return ResponseEntity.ok().body("Password updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id, @RequestBody DeleteUserRequestDTO body) {
        User user = userService.findById(id);

        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong Password");
        }

        userService.delete(user);

        return ResponseEntity.ok().body("User deleted");
    }
}
