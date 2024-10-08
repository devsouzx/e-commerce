package com.devsouzx.ecommerce.services.user;

import com.devsouzx.ecommerce.model.User;
import com.devsouzx.ecommerce.model.UserRole;
import com.devsouzx.ecommerce.requests.UserRequestDTO;
import com.devsouzx.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserRequestDTO body) {
        User user = new User(body.name(), body.email(), new BCryptPasswordEncoder().encode(body.password()), body.phone(), body.birthDate(), body.gender(), UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
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
        entity.setRole(UserRole.USER);
        entity.setBirthDate(user.birthDate());
        entity.setGender(user.gender());
        entity.setAvatarUrl(user.avatarUrl());
        entity.setCreatedAt(user.createdAt());
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
