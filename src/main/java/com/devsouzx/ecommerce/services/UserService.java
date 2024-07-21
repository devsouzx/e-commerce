package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.model.user.dto.UserRequestDTO;
import com.devsouzx.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User update(UUID id, UserRequestDTO user) {
        User entity = this.findById(id);
        this.updateDate(entity, user);
        return userRepository.save(entity);
    }

    private void updateDate(User entity, UserRequestDTO user) {
        entity.setName(user.name());
        entity.setEmail(user.email());
        entity.setPhone(user.phone());
        entity.setPassword(user.password());
        entity.setRole(user.role());
        entity.setBirthDate(user.birthDate());
        entity.setGender(user.gender());
        entity.setCreatedAt(user.createdAt());
    }
}
