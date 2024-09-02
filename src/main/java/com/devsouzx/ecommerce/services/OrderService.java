package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderProduct;
import com.devsouzx.ecommerce.repositories.OrderProductRepository;
import com.devsouzx.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
