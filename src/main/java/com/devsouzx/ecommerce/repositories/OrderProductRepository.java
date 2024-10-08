package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.model.Order;
import com.devsouzx.ecommerce.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID>  {
    List<OrderProduct> findByOrder(Order order);
}
