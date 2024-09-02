package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
