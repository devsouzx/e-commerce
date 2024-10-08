package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.requests.AvatarRequestDTO;
import com.devsouzx.ecommerce.requests.DeleteUserRequestDTO;
import com.devsouzx.ecommerce.model.User;
import com.devsouzx.ecommerce.requests.PasswordRequestDTO;
import com.devsouzx.ecommerce.responses.UserResponseDTO;
import com.devsouzx.ecommerce.services.address.IAddressService;
import com.devsouzx.ecommerce.services.user.IUserService;
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
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IAddressService addressService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> users = userService.findAll().stream().map(UserResponseDTO::new).toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable UUID id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserResponseDTO(user));
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

    @PostMapping("/{id}/avatar")
    public ResponseEntity<?> avatar(@PathVariable UUID id, @RequestBody AvatarRequestDTO body) {
        User user = userService.findById(id);
        user.setAvatarUrl(body.avatarUrl());
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }
}
