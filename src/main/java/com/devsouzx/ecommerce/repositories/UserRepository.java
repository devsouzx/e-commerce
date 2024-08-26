package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}