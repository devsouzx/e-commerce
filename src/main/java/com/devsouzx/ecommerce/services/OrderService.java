package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderProduct;
import com.devsouzx.ecommerce.dtos.order.OrderResponseDTO;
import com.devsouzx.ecommerce.repositories.OrderProductRepository;
import com.devsouzx.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    public List<OrderProduct> findOrderProductByOrder(Order order) {
        return orderProductRepository.findByOrder(order);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));
    }
}
