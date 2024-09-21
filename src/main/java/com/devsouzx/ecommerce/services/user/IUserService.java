package com.devsouzx.ecommerce.services.user;

import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.dtos.user.UserRequestDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User register(UserRequestDTO body);
    List<User> findAll();
    User findByEmail(String email);
    void saveUser(User user);
    User findById(UUID id);
    User update(UUID id, UserRequestDTO user);
    void delete(User user);
}
